package org.vertex.channel.component.processor;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Preconditions;
import com.yunche.forward.maitian.component.DefaultMessageProcessor;
import com.yunche.forward.maitian.component.Message;
import com.yunche.forward.maitian.config.constant.BusiInterFaceEnum;
import com.yunche.forward.maitian.config.constant.LoanProcessEnum;
import com.yunche.forward.maitian.config.constant.StandardKey;
import com.yunche.forward.maitian.config.exception.BizException;
import com.yunche.forward.maitian.domain.entity.ApprovalParam;
import com.yunche.forward.maitian.domain.entity.LoanCustomer;
import com.yunche.forward.maitian.domain.entity.LoanOrder;
import com.yunche.forward.maitian.mapper.LoanCustomerMapper;
import com.yunche.forward.maitian.mapper.LoanOrderMapper;
import com.yunche.forward.maitian.util.HttpClientUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.acl.LastOwnerException;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * author: zhengdu
 * Date: 2019-03-25
 */
@Component
@Slf4j
public class ApprovalProcessor extends DefaultMessageProcessor {
    private static final String approval_url = "/api/v1/loanprocess/external/approval";

    @Autowired
    private LoanOrderMapper loanOrderMapper;
    @Autowired
    private LoanCustomerMapper loanCustomerMapper;

    @Override
    protected Message process(Message message) {
        JSONObject result = (JSONObject) message.payload;
        String serviceId = message.getHeader(StandardKey.SERVICE_ID, String.class);
        Map<String, String> header = message.getHeader(StandardKey.HTTP_HEADER, Map.class);
        String systemUrl = message.getHeader(StandardKey.SYSTEM_URL, String.class);

        if (success(result) && BusiInterFaceEnum.isApproval(serviceId)) {
            try {
                String params = approvalParams(message, result);
                String s = HttpClientUtils.postJson(systemUrl + approval_url, params, header);
                log.info("调用审核接口,参数：{} 返回：{}",params,s);
                JSONObject dataJson = JSONObject.parseObject(s);
                if (!success(dataJson)) {
                    return appprivalFail(message,dataJson);
                }
            } catch (Exception e) {
                throw new BizException("自动审核异常："+e.getMessage());
            }
        }
        return message;
    }

    private Message appprivalFail(Message message,JSONObject dataJson) {
        Long orderId = message.getHeader(StandardKey.ORDER_ID, Long.class);
        LoanOrder loanOrder = loanOrderMapper.selectById(orderId);
        List<LoanCustomer> customers = loanCustomerMapper.selectByMasterId(loanOrder.getLoanCustomerId());

        JSONObject params = new JSONObject();
        params.put("loanOrderInfo",loanOrder);
        params.put("customers",customers);
        dataJson.put("data",params);
        dataJson.put("msg",dataJson.getString("msg"));
        message.payLoad(dataJson);
        return message;
    }

    /**
     * 自动提交参数
     * @param message
     * @param result
     * @return
     */
    private String approvalParams(Message message,JSONObject result) {
        String serviceId = message.getHeader(StandardKey.SERVICE_ID, String.class);
        Long orderId = message.getHeader(StandardKey.ORDER_ID, Long.class);
        // 针对征信提交接口(第一个) 不知道订单号
        if (orderId == null) {
            JSONObject data = result.getJSONObject("data");
            orderId = data != null ? data.getLong("orderId") : null;
            Preconditions.checkNotNull(orderId,"订单号不能为空");
            message.addHeader(StandardKey.ORDER_ID, orderId);
        }

        ApprovalParam param = new ApprovalParam();
        param.setOrderId(orderId);
        param.setAction(ApprovalParam.PASS);
        param.setTaskDefinitionKey(LoanProcessEnum.gettaskKey(serviceId));
        param.setCheckPermission(false);
        param.setNeedLog(true);
        if (LoanProcessEnum.USERTASK_TELEPHONE_VERIFY.serviceId.equals(serviceId)) {
            param.setPassLevel(Byte.valueOf("1"));
        }
        return JSONObject.toJSONString(param);
    }


    boolean success (JSONObject result) {
        return "EC00000200".equals(result.getString("code"));
    }

}

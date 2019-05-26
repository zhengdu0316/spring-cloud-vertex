package org.vertex.channel.component.conver;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.vertex.channel.component.Message;

/**
 * Description:
 * author: zhengdu
 * Date: 2019-03-05
 */
@Component
@Slf4j
public class LoanCreditApplyConver implements MessageConver {



    @Override
    public Message conver(Message message) {
        JSONObject result = (JSONObject) message.payload;
        if (success(result)) {
            return enrich(result,message);
        }
        return message;
    }

    private Message enrich(JSONObject result, Message message) {
        String orderId = result.getString("data");
//        LoanOrder loanOrder = loanOrderMapper.selectById(Long.valueOf(orderId));
        JSONObject data = new JSONObject();
//        data.put("orderId",loanOrder.getId());
//        data.put("loanBaseInfoId",loanOrder.getLoanBaseInfoId());
//        data.put("customs",getcustoms(loanOrder.getLoanCustomerId(), loanOrder.getId(), message));

        result.put("data",data);
        return new Message(message.headers,result);
    }

    private JSONArray getcustoms(Long id, Long orderId, Message message) {

//
//
        JSONArray customArray = new JSONArray();
//
//        List<ZhongAnCusParam> customerparams = Lists.newArrayList();
//        customers.forEach(customer -> {
//            JSONObject customerData = new JSONObject();
//            customerData.put("id",customer.getId());
//            customerData.put("custType",customer.getCustType());
//            customerData.put("idCard",customer.getIdCard());
//            customArray.add(customerData);
//
//            ZhongAnCusParam cusParam = new ZhongAnCusParam();
//            cusParam.setCustomertype(customer.getCustType().toString());
//            cusParam.setIdcard(customer.getIdCard());
//            cusParam.setName(customer.getName());
//            cusParam.setRalationship(customer.getCustRelation() == null ? "0" : customer.getCustRelation().toString() );
//            cusParam.setTel(customer.getMobile());
//            cusParam.setLoanmoney("1");
//            customerparams.add(cusParam);
//        });
//
//        ZhongAnQueryParam queryParam = new ZhongAnQueryParam();
//        queryParam.setOrder_id(orderId.toString());
//        queryParam.setCustomers(customerparams);
//        queryParam.setHttpHeader(message.getHeader(StandardKey.HTTP_HEADER, Map.class));
//        queryParam.setSystemUrl(message.getHeader(StandardKey.SYSTEM_URL, String.class));
//        // 众安大数据查询
//        zhongAnService.apply(queryParam);

        return customArray;
    }
}

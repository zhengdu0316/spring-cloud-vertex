package org.vertex.channel.component.processor;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import org.vertex.channel.component.DefaultMessageProcessor;
import org.vertex.channel.component.Message;
import org.vertex.channel.config.constant.BusiInterFaceEnum;

import java.util.Map;
import java.util.Set;

/**
 * Description:
 * author: zhengdu
 * Date: 2019-03-05
 */
public class SimpleHttpInvoker extends DefaultMessageProcessor {



//    @Autowired
//    private BusiIntfCfgMapper busiIntfCfgMapper;


    @Override
    protected Message process(Message message) {
        String url = getUrl(message);
        return httpInvoke(message, url);
    }


    private Message httpInvoke(Message message,String url) {
        Map<String, String> header = message.getHeader("", Map.class);
        String reqMethod = BusiInterFaceEnum.getReqMethod(message.getHeader("", String.class));
        JSONObject parmas = (JSONObject) message.payload;
        String result = null;
//        try {
//            if (StandardKey.GET.equals(reqMethod)) {
//                result = HttpClientUtils.get(url, buildReqMap(parmas), header);
//            } else {
//                result = HttpClientUtils.postJson(url, parmas.toJSONString(), header);
//            }
//            JSONObject resultJson = JSONObject.parseObject(result);
//            if (!success(resultJson)) {
//                throw new BizException("业务系统调用异常:"+resultJson.getString("msg"));
//            }
//        } catch (Exception e) {
//            throw new BizException(e.getMessage());
//        }
        return new Message(message.headers,JSONObject.parseObject(result));
    }

    private Map<String,String> buildReqMap(JSONObject parmas) {
        Map<String,String> reqMap = Maps.newHashMap();
        Set<Map.Entry<String, Object>> entries = parmas.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            reqMap.put(entry.getKey(),String.valueOf(entry.getValue()));
        }
        return reqMap;
    }

    private String getUrl(Message message) {
//        String serviceId = message.getHeader(StandardKey.SERVICE_ID, String.class);
////        String platCode = message.getHeader(StandardKey.PLAT_CODE, String.class);
////        BusiIntfCfg busiIntfCfg = busiIntfCfgMapper.selectByServiceId(serviceId,platCode);
////        if (busiIntfCfg != null) {
////            message.addHeader(StandardKey.SYSTEM_URL, busiIntfCfg.getSystemUrl());
////            return busiIntfCfg.getSystemUrl()+busiIntfCfg.getBusiUrl();
////        }
////        throw new BizException("业务接口配置异常");
        return null;
    }

    boolean success (JSONObject result) {
//        if (result.containsKey("resultCode")) {
//            return HttpStatus.SC_OK == result.getIntValue("resultCode");
//        }
        return "EC00000200".equals(result.getString("code"));
    }
}

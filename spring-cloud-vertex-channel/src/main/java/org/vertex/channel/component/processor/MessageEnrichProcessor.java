package org.vertex.channel.component.processor;

import com.alibaba.fastjson.JSONObject;
import org.vertex.channel.component.DefaultMessageProcessor;
import org.vertex.channel.component.Message;

/**
 * Description:
 * author: zhengdu
 * Date: 2019-03-05
 */
public class MessageEnrichProcessor extends DefaultMessageProcessor {
//    @Autowired
//    private ConfIdKeyDOMapper confIdKeyDOMapper;

    @Override
    protected Message process(Message message) {
        JSONObject jsonObject = (JSONObject) message.payload;
        JSONObject pub = jsonObject.getJSONObject("pub");
        JSONObject req = jsonObject.getJSONObject("req");

//        ConfIdKeyDO confIdKeyDO = confIdKeyDOMapper.selectByPrimaryKey(pub.getString("appid"));
//        Map<String, String> httpHeaders = Maps.newHashMap();
//        httpHeaders.put("Cookie","sid=".concat(confIdKeyDO.getToken()));

//        message.addHeader(StandardKey.HTTP_HEADER,httpHeaders);
//        message.addHeader(StandardKey.SERVICE_ID, pub.getString(StandardKey.SERVICE_ID));
//        message.addHeader(StandardKey.PLAT_CODE, pub.getString(StandardKey.PLAT_CODE));
//        message.addHeader(StandardKey.ORDER_ID, pub.getLong(StandardKey.ORDER_ID));
//        message.payLoad(req);
        return message;
    }
}

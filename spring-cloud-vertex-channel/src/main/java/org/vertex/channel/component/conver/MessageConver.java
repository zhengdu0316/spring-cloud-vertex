package org.vertex.channel.component.conver;

import com.alibaba.fastjson.JSONObject;
import org.vertex.channel.component.Message;

/**
 * Description:
 * author: zhengdu
 * Date: 2019-03-05
 */
public interface MessageConver {

    public Message conver(Message message);

    default boolean success(JSONObject result) {
        return "EC00000200".equals(result.getString("code"));
    }
}

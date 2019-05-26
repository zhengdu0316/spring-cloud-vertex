package org.vertex.channel.component;

/**
 * Description:
 * author: zhengdu
 * Date: 2019-03-05
 */
public interface MessageProcessor {

    public Message processInternal(Message message);

    public MessageProcessor next(MessageProcessor processor);
}

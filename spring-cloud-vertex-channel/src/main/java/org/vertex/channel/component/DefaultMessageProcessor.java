package org.vertex.channel.component;

/**
 * Description:
 * author: zhengdu
 * Date: 2019-03-05
 */
public class DefaultMessageProcessor implements MessageProcessor{

    protected MessageProcessor next;

    @Override
    public Message processInternal(Message message) {
        Message result = process(message);
        if (next == null) {
            return result;
        }
        return next.processInternal(result);
    }

    protected Message process(Message message) {
        return message;
    }

    @Override
    public MessageProcessor next(MessageProcessor next) {
        this.next = next;
        return this;
    }
}

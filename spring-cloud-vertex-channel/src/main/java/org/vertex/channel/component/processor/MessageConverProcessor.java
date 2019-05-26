package org.vertex.channel.component.processor;

import org.vertex.channel.component.DefaultMessageProcessor;
import org.vertex.channel.component.Message;
import org.vertex.channel.component.MessageConverFactory;
import org.vertex.channel.component.MessageProcessor;
import org.vertex.channel.component.conver.MessageConver;
import org.vertex.channel.config.constant.StandardKey;

/**
 * Description:
 * author: zhengdu
 * Date: 2019-03-05
 */
public class MessageConverProcessor extends DefaultMessageProcessor {

    private MessageConverFactory messageConverFactory;

    @Override
    protected Message process(Message message) {
        MessageConver messageConver = messageConverFactory.decide(message.getHeader(StandardKey.SERVICE_ID, String.class));
        if (messageConver != null) {
            return messageConver.conver(message);
        }
        return message;
    }

    public MessageProcessor setMessageConverFactory(MessageConverFactory messageConverFactory) {
        this.messageConverFactory = messageConverFactory;
        return this;
    }
}

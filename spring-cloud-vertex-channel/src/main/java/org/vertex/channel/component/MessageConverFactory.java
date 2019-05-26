package org.vertex.channel.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.vertex.channel.component.conver.MessageConver;
import org.vertex.channel.config.constant.BusiInterFaceEnum;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * Description:
 * author: zhengdu
 * Date: 2019-03-05
 */
@Component
public class MessageConverFactory {
    @Autowired
    private ApplicationContext applicationContext;

    private Map<String, MessageConver> convers;


    @PostConstruct
    public void init() {
        this.convers = applicationContext.getBeansOfType(MessageConver.class);
    }

    public MessageConver decide(String serviceId){
        String converBean = BusiInterFaceEnum.getMsgConverBean(serviceId);
        return convers.get(converBean);
    }
}

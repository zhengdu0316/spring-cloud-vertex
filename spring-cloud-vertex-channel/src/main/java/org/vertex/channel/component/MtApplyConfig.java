package org.vertex.channel.component;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.vertex.channel.component.processor.MessageConverProcessor;
import org.vertex.channel.component.processor.MessageEnrichProcessor;
import org.vertex.channel.component.processor.SimpleHttpInvoker;

/**
 * Description: 责任链 -流程配置
 * author: zhengdu
 * Date: 2019-03-05
 */
@Configuration
public class MtApplyConfig {


    @Bean
    public MessageProcessor mtApplyProcessor(MessageProcessor simpleHttpInvoker){
        MessageEnrichProcessor enrichProcessor = new MessageEnrichProcessor();
        enrichProcessor.next(simpleHttpInvoker);
        return enrichProcessor;
    }

//    @Bean
//    public MessageProcessor httpInvoker() {
//        HttpInvoker httpInvoker = new HttpInvoker();
//        httpInvoker.setInvokeStrategy(message -> {
//            String serviceId = message.getHeader(StandardKey.SERVICE_ID, String.class);
//            if (BusiInterFaceEnum.isConver(serviceId)) {
//                return "loanInvoker";
//            }
//            return "other";
//        });
//        httpInvoker.addProcessor("loanInvoker",simpleHttpInvoker());
//        httpInvoker.addProcessor("other",simpleHttpInvoker());
//        return httpInvoker;
//    }

    @Bean
    public MessageProcessor simpleHttpInvoker(MessageProcessor messageConverProcessor) {
        SimpleHttpInvoker simpleHttpInvoker = new SimpleHttpInvoker();
        simpleHttpInvoker.next(messageConverProcessor);
        return simpleHttpInvoker;
    }

    @Bean
    public MessageProcessor messageConverProcessor(MessageConverFactory messageConverFactory,MessageProcessor approvalProcessor) {
        MessageConverProcessor messageConverProcessor = new MessageConverProcessor();
        messageConverProcessor.setMessageConverFactory(messageConverFactory);
        messageConverProcessor.next(approvalProcessor);
        return messageConverProcessor;
    }

}

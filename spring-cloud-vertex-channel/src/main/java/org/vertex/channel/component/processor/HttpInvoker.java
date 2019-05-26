package org.vertex.channel.component.processor;

import com.google.common.collect.Collections2;
import com.yunche.forward.maitian.component.DefaultMessageProcessor;
import com.yunche.forward.maitian.component.HttpInvokeStrategy;
import com.yunche.forward.maitian.component.Message;
import com.yunche.forward.maitian.component.MessageProcessor;
import com.yunche.framework.util.CollectionUtil;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * author: zhengdu
 * Date: 2019-03-05
 */
public class HttpInvoker extends DefaultMessageProcessor {

    private HttpInvokeStrategy invokeStrategy;

    private Map<String,MessageProcessor> processorMap = new HashMap<>();

    @Override
    protected Message process(Message message) {
        String resultConver = invokeStrategy.resultConver(message);
        return super.process(message);
    }

    public void setInvokeStrategy(HttpInvokeStrategy invokeStrategy) {
        this.invokeStrategy = invokeStrategy;
    }

    public void addProcessor(String key,MessageProcessor messageProcessor){
        processorMap.put(key,messageProcessor);
    }
}

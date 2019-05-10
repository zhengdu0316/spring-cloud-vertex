package org.vertex.springcloudvertexclient.service;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.codingapi.txlcn.tc.annotation.TxTransaction;
import org.springframework.stereotype.Service;
import org.vertex.springcloudvertexclient.config.aop.SelfFilter;

/**
 * @author zhengdu
 * @date 2019/4/29 上午10:48
 */
@Service
public class ServiceFromJarService {

    @SelfFilter
    @LcnTransaction
    public String server1(){

        return "hello,world";
    }
}

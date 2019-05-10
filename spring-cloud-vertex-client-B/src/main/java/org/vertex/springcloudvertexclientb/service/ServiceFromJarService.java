package org.vertex.springcloudvertexclientb.service;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import org.springframework.stereotype.Service;
import org.vertex.springcloudvertexclientb.config.aop.SelfFilter;

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

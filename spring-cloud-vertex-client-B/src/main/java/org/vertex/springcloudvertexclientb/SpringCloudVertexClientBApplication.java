package org.vertex.springcloudvertexclientb;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhengdu
 * @date 2019/5/9 上午11:25
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableDistributedTransaction
public class SpringCloudVertexClientBApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudVertexClientBApplication.class, args);
    }

}

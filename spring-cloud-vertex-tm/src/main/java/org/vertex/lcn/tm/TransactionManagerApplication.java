package org.vertex.lcn.tm;

import com.codingapi.txlcn.tm.config.EnableTransactionManagerServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhengdu
 * @date 2019/5/8 下午9:03
 */
@SpringBootApplication
@EnableTransactionManagerServer
@EnableDiscoveryClient
public class TransactionManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(TransactionManagerApplication.class, args);
    }
}

package org.vertex.springcloudvertexclient;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableDistributedTransaction
@EnableFeignClients
public class SpringCloudVertexClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudVertexClientApplication.class, args);
	}


	@Bean
	public static RestTemplate restTemplate(){
		return new RestTemplate();
	}
}

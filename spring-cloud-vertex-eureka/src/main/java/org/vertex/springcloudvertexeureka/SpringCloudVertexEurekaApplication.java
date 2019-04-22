package org.vertex.springcloudvertexeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudVertexEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudVertexEurekaApplication.class, args);
	}

}

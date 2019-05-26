package org.vertex.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zhengdu
 * @date 2019/5/17 21:49
 */
@SpringBootApplication
@ComponentScan(basePackages = "org.vertex.es.*")
public class ElasticsearchApplication {
    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchApplication.class,args);
    }


//    @Value("${elasticsearch.host:localhost}")
//    public String host;
//    @Value("${elasticsearch.port:9300}")
//    public int port;
//    @Bean
//    public Client client(){
//        TransportClient client = null;
//        try{
//            System.out.println("host:"+ host+"port:"+port);
//            client = new PreBuiltTransportClient(Settings.EMPTY)
//                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host), port));
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
//        return client;
//    }
}
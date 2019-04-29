package org.vertex.springcloudvertexclient.config.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.vertex.springcloudvertexclient.config.handler.AuthorizationHandler;

@SpringBootConfiguration
public class AuthorizationAdapterConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private AuthorizationHandler authorizationHandler;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(authorizationHandler).addPathPatterns("/api/v1/**").excludePathPatterns("/api/v1/login");
    }

}

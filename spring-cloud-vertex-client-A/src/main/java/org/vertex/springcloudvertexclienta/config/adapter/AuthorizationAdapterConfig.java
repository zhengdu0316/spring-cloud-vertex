package org.vertex.springcloudvertexclienta.config.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.vertex.springcloudvertexclienta.config.handler.AuthorizationHandler;

@SpringBootConfiguration
public class AuthorizationAdapterConfig extends WebMvcConfigurationSupport {

    @Autowired
    private AuthorizationHandler authorizationHandler;

    //    @Override
//    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
//        super.addResourceHandlers(registry);
//    }
//
//    @Override
//    protected void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("/login");
//        super.addViewControllers(registry);
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorizationHandler).addPathPatterns("/api/*");

    }

}

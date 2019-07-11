package org.vertex.springcloudvertexclienta.config.adapter;


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.vertex.springcloudvertexclienta.config.filter.RegionCodeAuthFilter;

import javax.servlet.Filter;

/**
 * @author zhengdu
 * @date 2019/7/2 15:40
 */
@Configuration
public class SwhandlerConfig {


    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new RegionCodeAuthFilter());
        filterRegistrationBean.addUrlPatterns("/api/*");
        filterRegistrationBean.setName("regionCodeAuthFilter");
        return filterRegistrationBean;
    }

    @Bean
    public Filter regionCodeAuthFilter(){
        return new RegionCodeAuthFilter();
    }

}
package org.vertex.springcloudvertexclienta.config.filter;

import org.springframework.web.filter.OncePerRequestFilter;
import org.vertex.springcloudvertexclienta.config.adapter.RequestWrapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhengdu
 * @date 2019/7/10 17:43
 */
public class RegionCodeAuthFilter extends OncePerRequestFilter {

//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        ServletRequest requestWrapper = null;
//        if(servletRequest instanceof HttpServletRequest) {
//            requestWrapper = new RequestWrapper((HttpServletRequest) servletRequest);
//        }
//        if(requestWrapper == null) {
//            filterChain.doFilter(servletRequest, servletResponse);
//        } else {
//            filterChain.doFilter(requestWrapper, servletResponse);
//        }
//    }

    @Override
    protected void doFilterInternal(HttpServletRequest servletRequest, HttpServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        ServletRequest requestWrapper = new RequestWrapper(servletRequest);
        filterChain.doFilter(requestWrapper, servletResponse);
    }

}
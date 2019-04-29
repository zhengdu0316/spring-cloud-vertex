package org.vertex.springcloudvertexclient.config.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthorizationHandler implements HandlerInterceptor {
    private static final Logger LOG = LoggerFactory.getLogger(AuthorizationHandler.class);
    private static final String TOKEN_HEADER = "token";
    @Override
    public boolean  preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        try {

//            RequestWrapper requestWrapper = new RequestWrapper(request);
//            String body = requestWrapper.getBody();
//            AuthFilterParam authFilterParam = JSONObject.parseObject(body, AuthFilterParam.class);
//            EmployeeDO loginUser = SessionUtils.getLoginUser();
//            loginUser.getId();
            String token = request.getHeader(TOKEN_HEADER);
            if(StringUtils.isEmpty(token)){
                throw new RuntimeException("未登录");
            }
            return true;
        }catch (Exception e){
           throw new RuntimeException(e.getMessage());
        }
    }
}

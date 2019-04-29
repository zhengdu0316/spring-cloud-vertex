package org.vertex.springcloudvertexclient.aspect;

import com.oracle.tools.packager.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author zhengdu
 * @date 2019/4/29 上午10:50
 */
@Aspect
@Component
public class SelfFilterAop {

    /**
     * @param point
     */
    @Around("@annotation(org.vertex.springcloudvertexclient.config.aop.SelfFilter)")
    public Object around(ProceedingJoinPoint point) throws Throwable {

        Log.info("dofilter ... ");
        return point.proceed();
    }
}

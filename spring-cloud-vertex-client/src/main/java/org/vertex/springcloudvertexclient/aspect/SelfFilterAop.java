package org.vertex.springcloudvertexclient.aspect;

import com.esotericsoftware.minlog.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;

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
        Filter
        Log.info("dofilter ... ");
        return point.proceed();
    }
}

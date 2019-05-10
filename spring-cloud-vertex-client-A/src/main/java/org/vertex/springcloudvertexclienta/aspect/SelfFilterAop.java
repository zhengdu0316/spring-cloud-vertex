package org.vertex.springcloudvertexclienta.aspect;

import com.oracle.tools.packager.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

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
    @Around("@annotation(org.vertex.springcloudvertexclienta.config.aop.SelfFilter)")
    public Object around(ProceedingJoinPoint point) throws Throwable {

        Log.info("dofilter ... ");
        return point.proceed();
    }
}

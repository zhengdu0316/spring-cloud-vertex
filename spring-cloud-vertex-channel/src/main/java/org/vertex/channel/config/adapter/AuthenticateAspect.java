package org.vertex.channel.config.adapter;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


@Aspect
@Component
@Slf4j
public class AuthenticateAspect {
//    @Autowired
//    private CheckKey checkKey;

    @Around("@annotation(com.yunche.forward.maitian.component.anno.Authenticate)")
    public Object authenticate(ProceedingJoinPoint pjd) throws Throwable {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

//        Object[] args = pjd.getArgs();
//        if (ArrayUtils.isEmpty(args)) {
//            throw new BizException("参数不能为空");
//        }
//        JSONObject jsonObject = (JSONObject) args[0];
//        JSONObject pub = jsonObject.getJSONObject("pub");
//        String ipAddress = getIpAddress(request);
//        boolean isAllow = checkKey.checkIsAllow(pub.getString("appid"), pub.getString("appkey"), pub.getString("timestamp"), ipAddress, null);
//        if (!isAllow) {
//            log.error("ip:[{}], appid:[{}], appkey:[{}], timestamp:[{}],",ipAddress,pub.getString("appid"),pub.getString("appkey"),pub.getString("timestamp"));
//            throw new BizException("授权不通过,已上报");
//        }
        return pjd.proceed();
    }

    private String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

}

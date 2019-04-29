package org.vertex.springcloudvertexclient.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.vertex.common.result.ResultBean;
import org.vertex.springcloudvertexclient.config.domain.param.UserParam;

/**
 * @author zhengdu
 * @date 2019/4/23 下午2:53
 */
@RestController
@RequestMapping("/api/v1/")
public class LoginController {

    @PostMapping(value = "/login",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultBean login(@RequestBody UserParam userParam){
        return ResultBean.ofSuccess("[test]:登录成功，无需校验");
    }

    @GetMapping("/testIntercepter")
    public ResultBean testIntercepter(@RequestBody UserParam userParam){
        return ResultBean.ofSuccess("[test]:测试拦截器");
    }
}

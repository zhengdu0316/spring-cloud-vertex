package org.vertex.springcloudvertexclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vertex.common.result.ResultBean;
import org.vertex.springcloudvertexclient.service.ServiceFromJarService;

/**
 * @author zhengdu
 * @date 2019/4/29 上午10:54
 */
@RestController
@RequestMapping("/api/v1/filter")
public class TestFilterController {

    @Autowired
    ServiceFromJarService serviceFromJarService;

    @GetMapping("/1")
    public ResultBean filter(){
        return ResultBean.ofSuccess(serviceFromJarService.server1());
    }

}

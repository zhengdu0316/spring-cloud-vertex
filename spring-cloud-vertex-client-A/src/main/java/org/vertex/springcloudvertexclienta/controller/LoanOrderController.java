package org.vertex.springcloudvertexclienta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.vertex.common.result.ResultBean;
import org.vertex.springcloudvertexclienta.service.LoanOrderService;

/**
 * @author zhengdu
 * @date 2019/5/9 下午3:10
 */
@RestController
@CrossOrigin
@RequestMapping("/ap1/v1/order")
public class LoanOrderController  {

    @Autowired
    private LoanOrderService loanOrderService;

    @GetMapping("/buy")
    public ResultBean buy(@RequestParam("orderId") String orderId){
        return loanOrderService.save(orderId);
    }
}

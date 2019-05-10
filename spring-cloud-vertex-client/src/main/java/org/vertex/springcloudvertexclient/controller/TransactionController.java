package org.vertex.springcloudvertexclient.controller;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.vertex.common.result.ResultBean;
import org.vertex.springcloudvertexclient.service.BuyTransactionService;

/**
 * @author zhengdu
 * @date 2019/5/9 下午3:03
 */
@RestController
@CrossOrigin
@RequestMapping("/api/v1/transaction")
public class TransactionController {

    @Autowired
    private BuyTransactionService buyTransactionService;

    //事件发起者
    @GetMapping("/buy")
    public ResultBean transaction(@RequestParam("orderId") String orderId,@RequestParam("goods") String goods){
        return  buyTransactionService.buy(orderId, goods);
    }
}

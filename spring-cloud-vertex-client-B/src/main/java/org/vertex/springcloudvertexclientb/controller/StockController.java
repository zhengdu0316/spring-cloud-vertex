package org.vertex.springcloudvertexclientb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.vertex.common.result.ResultBean;
import org.vertex.springcloudvertexclientb.service.LoanStockService;

/**
 * @author zhengdu
 * @date 2019/5/9 下午3:18
 */
@RestController
@CrossOrigin
@RequestMapping("/api/v1/stock")
public class StockController {

    @Autowired
    private LoanStockService loanStockService;
    @GetMapping("/save")
    public ResultBean save(@RequestParam("goods") String goods){
        return  loanStockService.save(goods);
    }
}

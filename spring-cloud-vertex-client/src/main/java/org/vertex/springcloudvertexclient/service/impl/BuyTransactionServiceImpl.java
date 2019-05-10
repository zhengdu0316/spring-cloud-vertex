package org.vertex.springcloudvertexclient.service.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.vertex.common.result.ResultBean;
import org.vertex.springcloudvertexclient.feign.SchedualService;
import org.vertex.springcloudvertexclient.feign.StockSchedualService;
import org.vertex.springcloudvertexclient.service.BuyTransactionService;

/**
 * @author zhengdu
 * @date 2019/5/9 下午3:05
 */
@Service
public class BuyTransactionServiceImpl implements BuyTransactionService {



    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private SchedualService schedualService;

    @Autowired
    private StockSchedualService stockSchedualService;
    @Override
    @LcnTransaction
    public ResultBean buy(String orderId,String goods) {
        ResultBean save = schedualService.buy(orderId);
        System.out.println("订单保存成功");
       int a=1/0;
        ResultBean stockRet = stockSchedualService.save(goods);
        System.out.println("库存保存成功");
        return ResultBean.ofSuccess("call -A -B is ok");
    }
}

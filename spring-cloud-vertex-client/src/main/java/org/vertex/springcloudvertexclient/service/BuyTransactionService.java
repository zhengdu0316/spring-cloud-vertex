package org.vertex.springcloudvertexclient.service;

import org.vertex.common.result.ResultBean;

/**
 * @author zhengdu
 * @date 2019/5/9 下午3:04
 */
public interface BuyTransactionService {

    public ResultBean buy(String orderId,String goods);
}

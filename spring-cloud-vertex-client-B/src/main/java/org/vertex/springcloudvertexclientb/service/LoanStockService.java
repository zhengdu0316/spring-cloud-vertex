package org.vertex.springcloudvertexclientb.service;

import org.vertex.common.result.ResultBean;
import org.vertex.springcloudvertexclientb.config.domain.entity.StockDO;

/**
 * @author zhengdu
 * @date 2019/5/9 下午2:52
 */
public interface LoanStockService {

    ResultBean save(String goods);
}

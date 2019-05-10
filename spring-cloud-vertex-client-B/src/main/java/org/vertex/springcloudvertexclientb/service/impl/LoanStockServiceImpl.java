package org.vertex.springcloudvertexclientb.service.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vertex.common.result.ResultBean;
import org.vertex.springcloudvertexclientb.config.domain.entity.StockDO;
import org.vertex.springcloudvertexclientb.mapper.StockDOMapper;
import org.vertex.springcloudvertexclientb.service.LoanStockService;

/**
 * @author zhengdu
 * @date 2019/5/9 下午2:52
 */
@Service
public class LoanStockServiceImpl implements LoanStockService {

    @Autowired
    private StockDOMapper stockDOMapper;
    @Override
    @Transactional
    @LcnTransaction
    public ResultBean save(String  goods) {
        StockDO stockDO = new StockDO();
        stockDO.setGoodsCode(goods);
        stockDO.setGoodsNum(1);
        stockDOMapper.insertSelective(stockDO);
        return ResultBean.ofSuccess("库存记录保存成功");
    }
}

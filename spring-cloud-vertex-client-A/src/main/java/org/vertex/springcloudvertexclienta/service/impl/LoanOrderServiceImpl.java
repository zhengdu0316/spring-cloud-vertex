package org.vertex.springcloudvertexclienta.service.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vertex.common.result.ResultBean;
import org.vertex.springcloudvertexclienta.config.domain.entity.TransorderDO;
import org.vertex.springcloudvertexclienta.mapper.TransorderDOMapper;
import org.vertex.springcloudvertexclienta.service.LoanOrderService;

/**
 * @author zhengdu
 * @date 2019/5/9 下午2:49
 */
@Service
public class LoanOrderServiceImpl implements LoanOrderService {

    @Autowired
    private TransorderDOMapper transorderDOMapper;
    @Override
    @LcnTransaction
    public ResultBean save(String orderId) {
        TransorderDO transorderDO = new TransorderDO();
        transorderDO.setOrderId(orderId);
        transorderDO.setTransCode("100200");
        transorderDOMapper.insertSelective(transorderDO);
        return ResultBean.ofSuccess("订单保存成功");
    }
}

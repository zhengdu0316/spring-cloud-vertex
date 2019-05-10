package org.vertex.springcloudvertexclienta.service;

import org.vertex.common.result.ResultBean;
import org.vertex.springcloudvertexclienta.config.domain.entity.TransorderDO;

/**
 * @author zhengdu
 * @date 2019/5/9 下午2:49
 */
public interface LoanOrderService {

    ResultBean save(String  orderId);
}

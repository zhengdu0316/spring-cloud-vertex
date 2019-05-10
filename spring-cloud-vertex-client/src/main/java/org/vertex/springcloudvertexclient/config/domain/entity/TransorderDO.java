package org.vertex.springcloudvertexclient.config.domain.entity;

import java.util.Date;

public class TransorderDO {
    /**
     *  
     */
    private Integer id;

    /**
     *  
     */
    private Integer orderId;

    /**
     *  
     */
    private String transCode;

    /**
     *  
     */
    private Date transDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getTransCode() {
        return transCode;
    }

    public void setTransCode(String transCode) {
        this.transCode = transCode == null ? null : transCode.trim();
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }
}
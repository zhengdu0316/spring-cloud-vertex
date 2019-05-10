package org.vertex.springcloudvertexclientb.config.domain.entity;

import java.util.Date;

public class StockDO {
    /**
     *  
     */
    private Integer id;

    /**
     *  
     */
    private String goodsCode;

    /**
     *  
     */
    private Integer goodsNum;

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

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode == null ? null : goodsCode.trim();
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }
}
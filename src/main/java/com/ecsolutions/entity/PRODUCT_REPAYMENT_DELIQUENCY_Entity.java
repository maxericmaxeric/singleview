package com.ecsolutions.entity;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017-3-23.
 */
public class PRODUCT_REPAYMENT_DELIQUENCY_Entity {
    private String tbucket;
    private BigDecimal amount;

    public String getTbucket() {
        return tbucket;
    }

    public void setTbucket(String tbucket) {
        this.tbucket = tbucket;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }



}

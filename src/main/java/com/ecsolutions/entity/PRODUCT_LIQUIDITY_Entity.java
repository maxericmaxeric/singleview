package com.ecsolutions.entity;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017-4-5.
 */
public class PRODUCT_LIQUIDITY_Entity {
    private String tenor;
    private BigDecimal amount;

    public String getTenor() {
        return tenor;
    }

    public void setTenor(String tenor) {
        this.tenor = tenor;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

}

package com.ecsolutions.entity;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/3/16.
 */
public class DEPOSIT_ACCOUNT_TRAN_CURRENCY_AMOUNT_Entity {
    private String transaction_date;
    private BigDecimal transaction_amount;

    public DEPOSIT_ACCOUNT_TRAN_CURRENCY_AMOUNT_Entity(String transaction_date, BigDecimal transaction_amount) {
        this.transaction_date = transaction_date;
        this.transaction_amount = transaction_amount;
    }

    public String getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(String transaction_date) {
        this.transaction_date = transaction_date;
    }

    public BigDecimal getTransaction_amount() {
        return transaction_amount;
    }

    public void setTransaction_amount(BigDecimal transaction_amount) {
        this.transaction_amount = transaction_amount;
    }
}

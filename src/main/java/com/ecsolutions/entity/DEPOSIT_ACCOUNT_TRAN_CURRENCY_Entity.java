package com.ecsolutions.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/3/16.
 */
public class DEPOSIT_ACCOUNT_TRAN_CURRENCY_Entity {
    private String currency;
    private List<DEPOSIT_ACCOUNT_TRAN_CURRENCY_AMOUNT_Entity> deposit_account_tran_currency_amount_entitys;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<DEPOSIT_ACCOUNT_TRAN_CURRENCY_AMOUNT_Entity> getTransaction_amount() {
        return deposit_account_tran_currency_amount_entitys;
    }

    public void setTransaction_amount(List<DEPOSIT_ACCOUNT_TRAN_CURRENCY_AMOUNT_Entity> deposit_account_tran_currency_amount_entitys) {
        this.deposit_account_tran_currency_amount_entitys = deposit_account_tran_currency_amount_entitys;
    }
}

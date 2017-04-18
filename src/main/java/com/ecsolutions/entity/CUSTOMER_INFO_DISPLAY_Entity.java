package com.ecsolutions.entity;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017-3-17.
 */
public class CUSTOMER_INFO_DISPLAY_Entity {
    private String customer_full_name;
    private String customer_code;
    private String relationship_level;
    private String credit_rating;
    private BigDecimal account_balance_lcy_sum;
    private BigDecimal balance_lcy_sum;
    private BigDecimal available_amount_lcy_sum;

    public BigDecimal getAccount_balance_lcy_sum() {
        return account_balance_lcy_sum;
    }

    public void setAccount_balance_lcy_sum(BigDecimal account_balance_lcy_sum) {
        this.account_balance_lcy_sum = account_balance_lcy_sum;
    }

    public BigDecimal getBalance_lcy_sum() {
        return balance_lcy_sum;
    }

    public void setBalance_lcy_sum(BigDecimal balance_lcy_sum) {
        this.balance_lcy_sum = balance_lcy_sum;
    }

    public BigDecimal getAvailable_amount_lcy_sum() {
        return available_amount_lcy_sum;
    }

    public void setAvailable_amount_lcy_sum(BigDecimal available_amount_lcy_sum) {
        this.available_amount_lcy_sum = available_amount_lcy_sum;
    }



    public String getCustomer_full_name() {
        return customer_full_name;
    }

    public void setCustomer_full_name(String customer_full_name) {
        this.customer_full_name = customer_full_name;
    }

    public String getCustomer_code() {
        return customer_code;
    }

    public void setCustomer_code(String customer_code) {
        this.customer_code = customer_code;
    }

    public String getRelationship_level() {
        return relationship_level;
    }

    public void setRelationship_level(String relationship_level) {
        this.relationship_level = relationship_level;
    }

    public String getCredit_rating() {
        return credit_rating;
    }

    public void setCredit_rating(String credit_rating) {
        this.credit_rating = credit_rating;
    }








}

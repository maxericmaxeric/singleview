package com.ecsolutions.entity;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/3/30.
 */
public class CustomerCreditLine_Entity {
    private String code1;
    private String parentid;
    private String name1;
    private String display;
    private String Currency;
    private BigDecimal Available_Amount;

    public String getCode1() {
        return code1;
    }

    public void setCode1(String code1) {
        this.code1 = code1;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String currency) {
        Currency = currency;
    }

    public BigDecimal getAvailable_Amount() {
        return Available_Amount;
    }

    public void setAvailable_Amount(BigDecimal available_Amount) {
        Available_Amount = available_Amount;
    }
}

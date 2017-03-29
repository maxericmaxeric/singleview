package com.ecsolutions.entity;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2017/3/28.
 */
public abstract class Base_Entity{
    abstract List<Object> convertToArray();

    //search
    private BigDecimal principal_amount_max;
    private BigDecimal balance_max;
    private String value_date_max;
    private String maturity_date_max;
    private String[] branch_array;
    private String[] principal_currency_array;
    private String[] balance_currency_array;
    private String[] loan_type_array;
    private String[] account_status_array;

    public String getHaha() {
        return haha;
    }

    public void setHaha(String haha) {
        this.haha = haha;
    }

    private String haha;

    public BigDecimal getPrincipal_amount_max() {
        return principal_amount_max;
    }

    public void setPrincipal_amount_max(BigDecimal principal_amount_max) {
        this.principal_amount_max = principal_amount_max;
    }

    public BigDecimal getBalance_max() {
        return balance_max;
    }

    public void setBalance_max(BigDecimal balance_max) {
        this.balance_max = balance_max;
    }

    public String getValue_date_max() {
        return value_date_max;
    }

    public void setValue_date_max(String value_date_max) {
        this.value_date_max = value_date_max;
    }

    public String getMaturity_date_max() {
        return maturity_date_max;
    }

    public void setMaturity_date_max(String maturity_date_max) {
        this.maturity_date_max = maturity_date_max;
    }

    public String[] getBranch_array() {
        return branch_array;
    }

    public void setBranch_array(String[] branch_array) {
        this.branch_array = branch_array;
    }

    public String[] getPrincipal_currency_array() {
        return principal_currency_array;
    }

    public void setPrincipal_currency_array(String[] principal_currency_array) {
        this.principal_currency_array = principal_currency_array;
    }

    public String[] getBalance_currency_array() {
        return balance_currency_array;
    }

    public void setBalance_currency_array(String[] balance_currency_array) {
        this.balance_currency_array = balance_currency_array;
    }

    public String[] getLoan_type_array() {
        return loan_type_array;
    }

    public void setLoan_type_array(String[] loan_type_array) {
        this.loan_type_array = loan_type_array;
    }

    public String[] getAccount_status_array() {
        return account_status_array;
    }

    public void setAccount_status_array(String[] account_status_array) {
        this.account_status_array = account_status_array;
    }


}

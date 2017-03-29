package com.ecsolutions.entity;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2017/3/28.
 */
public abstract class Base_Entity{
    abstract List<Object> convertToArray();

    //loan search
    private BigDecimal principal_amount_max;
    private BigDecimal balance_max;
    private String value_date_max;
    private String maturity_date_max;
    private String[] branch_array;
    private String[] principal_currency_array;
    private String[] balance_currency_array;
    private String[] loan_type_array;
    private String[] account_status_array;

    //deposit search
//    private String[] branch_array;
    private String dp_account_no;
    private String[] account_type_array;
    private String[] currency_array;
    private String open_date_max;
//    private String maturity_date_max;
    private BigDecimal account_balance_max;
//    private String[] account_status_array;


    public String getDp_account_no() {
        return dp_account_no;
    }

    public void setDp_account_no(String dp_account_no) {
        this.dp_account_no = dp_account_no;
    }

    public String[] getAccount_type_array() {
        return account_type_array;
    }

    public void setAccount_type_array(String[] account_type_array) {
        this.account_type_array = account_type_array;
    }

    public String[] getCurrency_array() {
        return currency_array;
    }

    public void setCurrency_array(String[] currency_array) {
        this.currency_array = currency_array;
    }

    public String getOpen_date_max() {
        return open_date_max;
    }

    public void setOpen_date_max(String open_date_max) {
        this.open_date_max = open_date_max;
    }

    public BigDecimal getAccount_balance_max() {
        return account_balance_max;
    }

    public void setAccount_balance_max(BigDecimal account_balance_max) {
        this.account_balance_max = account_balance_max;
    }

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

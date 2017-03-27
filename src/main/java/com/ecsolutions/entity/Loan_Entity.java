package com.ecsolutions.entity;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/3/23.
 */
public class Loan_Entity {
    private String branch;
    private String principal_currency;
    private String ln_account_no;
    private String customer_code;
    private String loan_type;
    private String line_no;
    private BigDecimal principal_amount;
    private BigDecimal balance;
    private String value_date;
    private String maturity_date;
    private String balance_currency;
    private String account_status;

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getPrincipal_currency() {
        return principal_currency;
    }

    public void setPrincipal_currency(String principal_currency) {
        this.principal_currency = principal_currency;
    }

    public String getLn_account_no() {
        return ln_account_no;
    }

    public void setLn_account_no(String ln_account_no) {
        this.ln_account_no = ln_account_no;
    }

    public String getCustomer_code() {
        return customer_code;
    }

    public void setCustomer_code(String customer_code) {
        this.customer_code = customer_code;
    }

    public String getLoan_type() {
        return loan_type;
    }

    public void setLoan_type(String loan_type) {
        this.loan_type = loan_type;
    }

    public String getLine_no() {
        return line_no;
    }

    public void setLine_no(String line_no) {
        this.line_no = line_no;
    }

    public BigDecimal getPrincipal_amount() {
        return principal_amount;
    }

    public void setPrincipal_amount(BigDecimal principal_amount) {
        this.principal_amount = principal_amount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getValue_date() {
        return value_date;
    }

    public void setValue_date(String value_date) {
        this.value_date = value_date;
    }

    public String getMaturity_date() {
        return maturity_date;
    }

    public void setMaturity_date(String maturity_date) {
        this.maturity_date = maturity_date;
    }

    public String getBalance_currency() {
        return balance_currency;
    }

    public void setBalance_currency(String balance_currency) {
        this.balance_currency = balance_currency;
    }

    public String getAccount_status() {
        return account_status;
    }

    public void setAccount_status(String account_status) {
        this.account_status = account_status;
    }


}

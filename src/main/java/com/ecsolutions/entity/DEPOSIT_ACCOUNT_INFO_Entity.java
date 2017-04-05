package com.ecsolutions.entity;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/15.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DEPOSIT_ACCOUNT_INFO_Entity extends Base_Entity{
    private String dp_account_no;
    private String account_type;
    private String currency;
    private String open_date;
    private String maturity_date;
    private BigDecimal account_balance;
    private String account_status;
    private String branch;


    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getDp_account_no() {
        return dp_account_no;
    }

    public void setDp_account_no(String dp_account_no) {
        this.dp_account_no = dp_account_no;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getOpen_date() {
        return open_date;
    }

    public void setOpen_date(String open_date) {
        this.open_date = open_date;
    }

    public String getMaturity_date() {
        return maturity_date;
    }

    public void setMaturity_date(String maturity_date) {
        this.maturity_date = maturity_date;
    }

    public BigDecimal getAccount_balance() {
        return account_balance;
    }

    public void setAccount_balance(BigDecimal account_balance) {
        this.account_balance = account_balance;
    }

    public String getAccount_status() {
        return account_status;
    }

    public void setAccount_status(String account_status) {
        this.account_status = account_status;
    }


    @Override
    public List<Object> convertToArray() {
        List<Object> ret = new ArrayList<Object>();
        ret.add(this.getBranch());
        ret.add(this.getDp_account_no());
        ret.add(this.getAccount_type());
        ret.add(this.getCurrency());
        ret.add(this.getOpen_date());
        ret.add(this.getMaturity_date());
        ret.add(this.getAccount_balance());
        ret.add(this.getAccount_status());

        return ret;
    }


}

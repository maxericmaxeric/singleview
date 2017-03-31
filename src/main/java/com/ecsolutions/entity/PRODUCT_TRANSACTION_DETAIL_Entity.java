package com.ecsolutions.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-3-23.
 */
public class PRODUCT_TRANSACTION_DETAIL_Entity extends Base_Entity{
    private String branch;
    private String dep_serial_no;
    private String transaction_date;
    private String transaction_type;
    private String account_no;
    private String currency;
    private String dr_indicator;
    private BigDecimal transaction_amount;

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getDep_serial_no() {
        return dep_serial_no;
    }

    public void setDep_serial_no(String dep_serial_no) {
        this.dep_serial_no = dep_serial_no;
    }

    public String getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(String transaction_date) {
        this.transaction_date = transaction_date;
    }

    public String getTransaction_type() {
        return transaction_type;
    }

    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
    }

    public String getAccount_no() {
        return account_no;
    }

    public void setAccount_no(String account_no) {
        this.account_no = account_no;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDr_indicator() {
        return dr_indicator;
    }

    public void setDr_indicator(String dr_indicator) {
        this.dr_indicator = dr_indicator;
    }

    public BigDecimal getTransaction_amount() {
        return transaction_amount;
    }

    public void setTransaction_amount(BigDecimal transaction_amount) {
        this.transaction_amount = transaction_amount;
    }

    @Override
    public List<Object> convertToArray() {
        List<Object> ret = new ArrayList<Object>();
        ret.add(this.getBranch());
        ret.add(this.getDep_serial_no());
        ret.add(this.getTransaction_date());
        ret.add(this.getTransaction_type());
        ret.add(this.getAccount_no());
        ret.add(this.getCurrency());
        ret.add(this.getDr_indicator());
        ret.add(this.getTransaction_amount());




        return ret;
    }

}

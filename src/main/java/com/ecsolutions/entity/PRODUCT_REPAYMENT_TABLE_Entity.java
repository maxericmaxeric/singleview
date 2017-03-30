package com.ecsolutions.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-3-23.
 */
public class PRODUCT_REPAYMENT_TABLE_Entity extends Base_Entity{
    private String open_item_num;
    private String instalment_no;
    private String branch;
    private String start_date;
    private String due_date;
    private String paid_date;
    private String currency;
    private BigDecimal instalment_amount;
    private BigDecimal interest_amt;
    private String overdue_flag;

    public String getOpen_item_num() {
        return open_item_num;
    }

    public void setOpen_item_num(String open_item_num) {
        this.open_item_num = open_item_num;
    }

    public String getInstalment_no() {
        return instalment_no;
    }

    public void setInstalment_no(String instalment_no) {
        this.instalment_no = instalment_no;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }



    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    public String getPaid_date() {
        return paid_date;
    }

    public void setPaid_date(String paid_date) {
        this.paid_date = paid_date;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getInstalment_amount() {
        return instalment_amount;
    }

    public void setInstalment_amount(BigDecimal instalment_amount) {
        this.instalment_amount = instalment_amount;
    }

    public BigDecimal getInterest_amt() {
        return interest_amt;
    }

    public void setInterest_amt(BigDecimal interest_amt) {
        this.interest_amt = interest_amt;
    }

    public String getOverdue_flag() {
        return overdue_flag;
    }

    public void setOverdue_flag(String overdue_flag) {
        this.overdue_flag = overdue_flag;
    }

    @Override
    public List<Object> convertToArray() {
        List<Object> ret = new ArrayList<Object>();
        ret.add(this.getCurrency());
        ret.add(this.getBranch());
        ret.add(this.getDue_date());
        ret.add(this.getInstalment_amount());
        ret.add(this.getInstalment_no());
        ret.add(this.getInterest_amt());
        ret.add(this.getOpen_item_num());
        ret.add(this.getOverdue_flag());
        ret.add(this.getPaid_date());
        ret.add(this.getStart_date());



        return ret;
    }


}

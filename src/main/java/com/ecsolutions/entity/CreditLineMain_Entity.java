package com.ecsolutions.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/31.
 */
public class CreditLineMain_Entity extends Base_Entity{
    private String credit_line_no;
    private String line_name;
    private String create_date;
    private String expire_date;
    private String currency;
    private BigDecimal limit;
    private BigDecimal utilized_amount;
    private BigDecimal booking_amount;
    private BigDecimal available_amount;



    private String revolving_ind;

    public String getCredit_line_no() {
        return credit_line_no;
    }

    public void setCredit_line_no(String credit_line_no) {
        this.credit_line_no = credit_line_no;
    }

    public String getLine_name() {
        return line_name;
    }

    public void setLine_name(String line_name) {
        this.line_name = line_name;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getExpire_date() {
        return expire_date;
    }

    public void setExpire_date(String expire_date) {
        this.expire_date = expire_date;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }

    public BigDecimal getUtilized_amount() {
        return utilized_amount;
    }

    public void setUtilized_amount(BigDecimal utilized_amount) {
        this.utilized_amount = utilized_amount;
    }

    public BigDecimal getBooking_amount() {
        return booking_amount;
    }

    public void setBooking_amount(BigDecimal booking_amount) {
        this.booking_amount = booking_amount;
    }

    public BigDecimal getAvailable_amount() {
        return available_amount;
    }

    public void setAvailable_amount(BigDecimal available_amount) {
        this.available_amount = available_amount;
    }

    public String getRevolving_ind() {
        return revolving_ind;
    }

    public void setRevolving_ind(String revolving_ind) {
        this.revolving_ind = revolving_ind;
    }

    @Override
    public List<Object> convertToArray() {
        List<Object> ret = new ArrayList<Object>();
        ret.add(this.getCredit_line_no());
        ret.add(this.getLine_name());
        ret.add(this.getCreate_date());
        ret.add(this.getExpire_date());
        ret.add(this.getCurrency());
        ret.add(this.getLimit());
        ret.add(this.getUtilized_amount());
        ret.add(this.getBooking_amount());
        ret.add(this.getAvailable_amount());
        ret.add(this.getRevolving_ind());
        return ret;
    }
}

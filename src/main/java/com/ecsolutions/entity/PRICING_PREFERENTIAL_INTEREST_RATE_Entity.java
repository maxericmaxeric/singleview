package com.ecsolutions.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-3-27.
 */
public class PRICING_PREFERENTIAL_INTEREST_RATE_Entity extends Base_Entity{
    private String product_code;
    private String product_desc;
    private String ir_spread;
    private String od_int_spread;
    private String preminum_discount;
    private String effective_date;
    private String expiry_date;

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getProduct_desc() {
        return product_desc;
    }

    public void setProduct_desc(String product_desc) {
        this.product_desc = product_desc;
    }

    public String getIr_spread() {
        return ir_spread;
    }

    public void setIr_spread(String ir_spread) {
        this.ir_spread = ir_spread;
    }

    public String getOd_int_spread() {
        return od_int_spread;
    }

    public void setOd_int_spread(String od_int_spread) {
        this.od_int_spread = od_int_spread;
    }

    public String getPreminum_discount() {
        return preminum_discount;
    }

    public void setPreminum_discount(String preminum_discount) {
        this.preminum_discount = preminum_discount;
    }

    public String getEffective_date() {
        return effective_date;
    }

    public void setEffective_date(String effective_date) {
        this.effective_date = effective_date;
    }

    public String getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(String expiry_date) {
        this.expiry_date = expiry_date;
    }


    @Override
    public List<Object> convertToArray() {
        List<Object> ret = new ArrayList<Object>();
        ret.add(this.getProduct_code());
        ret.add(this.getProduct_desc());
        ret.add(this.getIr_spread());
        ret.add(this.getOd_int_spread());
        ret.add(this.getPreminum_discount());
        ret.add(this.getEffective_date());
        ret.add(this.getExpiry_date());
        return ret;
    }
}

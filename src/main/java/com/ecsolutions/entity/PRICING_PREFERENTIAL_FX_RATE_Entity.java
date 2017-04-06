package com.ecsolutions.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-3-27.
 */
public class PRICING_PREFERENTIAL_FX_RATE_Entity extends Base_Entity {
    private String product_code;
    private String product_desc;
    private String ccy1;
    private String ccy2;
    private String point;
    private String preminum_discount;

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

    public String getCcy1() {
        return ccy1;
    }

    public void setCcy1(String ccy1) {
        this.ccy1 = ccy1;
    }

    public String getCcy2() {
        return ccy2;
    }

    public void setCcy2(String ccy2) {
        this.ccy2 = ccy2;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getPreminum_discount() {
        return preminum_discount;
    }

    public void setPreminum_discount(String preminum_discount) {
        this.preminum_discount = preminum_discount;
    }

    @Override
    public List<Object> convertToArray() {
        List<Object> ret = new ArrayList<Object>();
        ret.add(this.getProduct_code());
        ret.add(this.getProduct_desc());
        ret.add(this.getCcy1());
        ret.add(this.getCcy2());
        ret.add(this.getPoint());
        ret.add(this.getPreminum_discount());
        return ret;
    }

}

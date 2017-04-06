package com.ecsolutions.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-3-27.
 */
public class PRICING_PREFERENTIAL_FEES_Entity extends Base_Entity{
    private String fee_type;
    private String preminum_discount;

    public String getFee_type() {
        return fee_type;
    }

    public void setFee_type(String fee_type) {
        this.fee_type = fee_type;
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
        ret.add(this.getFee_type());
        ret.add(this.getPreminum_discount());
        return ret;
    }

}

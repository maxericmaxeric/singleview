package com.ecsolutions.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-3-27.
 */
public class PRICING_PRODUCT_INSTRUCTION_Entity extends Base_Entity{
    private String product_code;
    private String product_desc;
    private String instruction;
    private String maker;
    private String pdate;

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

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getPdate() {
        return pdate;
    }

    public void setPdate(String pdate) {
        this.pdate = pdate;
    }

    @Override
    public List<Object> convertToArray() {
        List<Object> ret = new ArrayList<Object>();
        ret.add(this.getProduct_code());
        ret.add(this.getProduct_desc());
        ret.add(this.getInstruction());
        ret.add(this.getMaker());
        ret.add(this.getPdate());
        return ret;
    }

}

package com.ecsolutions.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-3-27.
 */
public class PRICING_STANDING_INSTRUCTION_Entity extends Base_Entity{
    private String instruction;
    private String maker;
    private String sdate;

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

    public String getSdate() {
        return sdate;
    }

    public void setSdate(String sdate) {
        this.sdate = sdate;
    }


    @Override
    public List<Object> convertToArray() {
        List<Object> ret = new ArrayList<Object>();
        ret.add(this.getInstruction());
        ret.add(this.getMaker());
        ret.add(this.getSdate());
        return ret;
    }
}

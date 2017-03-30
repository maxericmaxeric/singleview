package com.ecsolutions.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/30.
 */
public class BackgroundCheck_Entity extends Base_Entity {
    private String check_date;
    private String check_item;
    private String check_result;

    public String getCheck_date() {
        return check_date;
    }

    public void setCheck_date(String check_date) {
        this.check_date = check_date;
    }

    public String getCheck_item() {
        return check_item;
    }

    public void setCheck_item(String check_item) {
        this.check_item = check_item;
    }

    public String getCheck_result() {
        return check_result;
    }

    public void setCheck_result(String check_result) {
        this.check_result = check_result;
    }

    @Override
    public List<Object> convertToArray() {
        List<Object> ret = new ArrayList<Object>();
        ret.add(this.getCheck_date());
        ret.add(this.getCheck_item());
        ret.add(this.getCheck_result());
        return ret;
    }
}

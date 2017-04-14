package com.ecsolutions.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by Administrator on 2017/4/13.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Function_Entity {
    private String functionid;
    private String functiondesc;
    private String tab;

    public String getFunctionid() {
        return functionid;
    }

    public void setFunctionid(String functionid) {
        this.functionid = functionid;
    }

    public String getFunctiondesc() {
        return functiondesc;
    }

    public void setFunctiondesc(String functiondesc) {
        this.functiondesc = functiondesc;
    }

    public String getTab() {
        return tab;
    }

    public void setTab(String tab) {
        this.tab = tab;
    }
}

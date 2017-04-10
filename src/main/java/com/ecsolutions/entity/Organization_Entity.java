package com.ecsolutions.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by Administrator on 2017/4/10.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Organization_Entity {
    private String organization_code;
    private String organization_desc;

    public String getOrganization_code() {
        return organization_code;
    }

    public void setOrganization_code(String organization_code) {
        this.organization_code = organization_code;
    }

    public String getOrganization_desc() {
        return organization_desc;
    }

    public void setOrganization_desc(String organization_desc) {
        this.organization_desc = organization_desc;
    }
}

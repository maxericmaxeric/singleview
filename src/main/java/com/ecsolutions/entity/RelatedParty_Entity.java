package com.ecsolutions.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/30.
 */
public class RelatedParty_Entity extends Base_Entity{
    private String customer_code;
    private String related_party;
    private String related_party_name;
    private String relationship;
    private String Shareholding;

    public String getCustomer_code() {
        return customer_code;
    }

    public void setCustomer_code(String customer_code) {
        this.customer_code = customer_code;
    }

    public String getRelated_party() {
        return related_party;
    }

    public void setRelated_party(String related_party) {
        this.related_party = related_party;
    }

    public String getRelated_party_name() {
        return related_party_name;
    }

    public void setRelated_party_name(String related_party_name) {
        this.related_party_name = related_party_name;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getShareholding() {
        return Shareholding;
    }

    public void setShareholding(String shareholding) {
        Shareholding = shareholding;
    }

    @Override
    public List<Object> convertToArray() {
        List<Object> ret = new ArrayList<Object>();
        ret.add(this.getCustomer_code());
        ret.add(this.getRelated_party());
        ret.add(this.getRelated_party_name());
        ret.add(this.getRelationship());
        ret.add(this.getShareholding());
        return ret;
    }
}

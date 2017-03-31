package com.ecsolutions.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/31.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CollateralMain_Entity extends Base_Entity{
    private String ref;
    private String collateral_no;
    private String collateral_type;
    private String item_description;
    private String val_currency;
    private BigDecimal valuation;
    private String valuation_date;
    private String line_no;

    private String[] collateral_type_array;
    private String[] val_currency_array;
    private BigDecimal valuation_max;
    private String valuation_date_max;


    private Boolean auto = false;

    public Boolean getAuto() {
        return auto;
    }

    public void setAuto(Boolean auto) {
        this.auto = auto;
    }


    public String[] getCollateral_type_array() {
        return collateral_type_array;
    }

    public void setCollateral_type_array(String[] collateral_type_array) {
        this.collateral_type_array = collateral_type_array;
    }

    public String[] getVal_currency_array() {
        return val_currency_array;
    }

    public void setVal_currency_array(String[] val_currency_array) {
        this.val_currency_array = val_currency_array;
    }

    public BigDecimal getValuation_max() {
        return valuation_max;
    }

    public void setValuation_max(BigDecimal valuation_max) {
        this.valuation_max = valuation_max;
    }

    public String getValuation_date_max() {
        return valuation_date_max;
    }

    public void setValuation_date_max(String valuation_date_max) {
        this.valuation_date_max = valuation_date_max;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getCollateral_no() {
        return collateral_no;
    }

    public void setCollateral_no(String collateral_no) {
        this.collateral_no = collateral_no;
    }

    public String getCollateral_type() {
        return collateral_type;
    }

    public void setCollateral_type(String collateral_type) {
        this.collateral_type = collateral_type;
    }

    public String getItem_description() {
        return item_description;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }

    public String getVal_currency() {
        return val_currency;
    }

    public void setVal_currency(String val_currency) {
        this.val_currency = val_currency;
    }

    public BigDecimal getValuation() {
        return valuation;
    }

    public void setValuation(BigDecimal valuation) {
        this.valuation = valuation;
    }

    public String getValuation_date() {
        return valuation_date;
    }

    public void setValuation_date(String valuation_date) {
        this.valuation_date = valuation_date;
    }

    public String getLine_no() {
        return line_no;
    }

    public void setLine_no(String line_no) {
        this.line_no = line_no;
    }

    @Override
    public List<Object> convertToArray() {
        List<Object> ret = new ArrayList<Object>();
        ret.add(this.getRef());
        ret.add(this.getCollateral_no());
        ret.add(this.getCollateral_type());
        ret.add(this.getItem_description());
        ret.add(this.getVal_currency());
        ret.add(this.getValuation());
        ret.add(this.getValuation_date());
        ret.add(this.getLine_no());

        return ret;
    }
}

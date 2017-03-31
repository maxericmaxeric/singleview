package com.ecsolutions.entity;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2017/3/28.
 */
public abstract class Base_Entity{
    public abstract List<Object> convertToArray();

    //loan search
    private BigDecimal principal_amount_max;
    private BigDecimal balance_max;
    private String value_date_max;
    private String maturity_date_max;
    private String[] branch_array;
    private String[] principal_currency_array;
    private String[] balance_currency_array;
    private String[] loan_type_array;
    private String[] account_status_array;

    //deposit search
//    private String[] branch_array;
    private String[] account_type_array;
    private String[] currency_array;
    private String open_date_max;
//    private String maturity_date_max;
    private BigDecimal account_balance_max;
//    private String[] account_status_array;



    //deposit transaction search
    private String dep_serial_no;
    private String transaction_date_max;
    private String[] transaction_type_array;
    private String account_no;
    private String[] dr_indicator_array;
    private BigDecimal transaction_amount_max;

    //product repayment search
    private String start_date_max;
    private String due_date_max;
    private String paid_date_max;
    private BigDecimal instalment_amount_max;
    private BigDecimal interst_amt_max;
    private String[] overdue_flag_array;

    //Credit line main search
    private String create_date_max;
    private String expire_date_max;
    private BigDecimal limit_max;
    private BigDecimal utilized_amount_max;
    private BigDecimal booking_amount_max;
    private BigDecimal available_amount_max;
    private String[] revolving_ind_array;

    public String[] getRevolving_ind_array() {
        return revolving_ind_array;
    }

    public void setRevolving_ind_array(String[] revolving_ind_array) {
        this.revolving_ind_array = revolving_ind_array;
    }

    public String getCreate_date_max() {
        return create_date_max;
    }

    public void setCreate_date_max(String create_date_max) {
        this.create_date_max = create_date_max;
    }

    public String getExpire_date_max() {
        return expire_date_max;
    }

    public void setExpire_date_max(String expire_date_max) {
        this.expire_date_max = expire_date_max;
    }

    public BigDecimal getLimit_max() {
        return limit_max;
    }

    public void setLimit_max(BigDecimal limit_max) {
        this.limit_max = limit_max;
    }

    public BigDecimal getUtilized_amount_max() {
        return utilized_amount_max;
    }

    public void setUtilized_amount_max(BigDecimal utilized_amount_max) {
        this.utilized_amount_max = utilized_amount_max;
    }

    public BigDecimal getBooking_amount_max() {
        return booking_amount_max;
    }

    public void setBooking_amount_max(BigDecimal booking_amount_max) {
        this.booking_amount_max = booking_amount_max;
    }

    public BigDecimal getAvailable_amount_max() {
        return available_amount_max;
    }

    public void setAvailable_amount_max(BigDecimal available_amount_max) {
        this.available_amount_max = available_amount_max;
    }


    public String[] getOverdue_flag_array() {
        return overdue_flag_array;
    }

    public void setOverdue_flag_array(String[] overdue_flag_array) {
        this.overdue_flag_array = overdue_flag_array;
    }


    public String getStart_date_max() {
        return start_date_max;
    }

    public void setStart_date_max(String start_date_max) {
        this.start_date_max = start_date_max;
    }

    public String getDue_date_max() {
        return due_date_max;
    }

    public void setDue_date_max(String due_date_max) {
        this.due_date_max = due_date_max;
    }

    public String getPaid_date_max() {
        return paid_date_max;
    }

    public void setPaid_date_max(String paid_date_max) {
        this.paid_date_max = paid_date_max;
    }

    public BigDecimal getInstalment_amount_max() {
        return instalment_amount_max;
    }

    public void setInstalment_amount_max(BigDecimal instalment_amount_max) {
        this.instalment_amount_max = instalment_amount_max;
    }

    public BigDecimal getInterst_amt_max() {
        return interst_amt_max;
    }

    public void setInterst_amt_max(BigDecimal interst_amt_max) {
        this.interst_amt_max = interst_amt_max;
    }





    public String getDep_serial_no() {
        return dep_serial_no;
    }

    public void setDep_serial_no(String dep_serial_no) {
        this.dep_serial_no = dep_serial_no;
    }

    public String getTransaction_date_max() {
        return transaction_date_max;
    }

    public void setTransaction_date_max(String transaction_date_max) {
        this.transaction_date_max = transaction_date_max;
    }

    public String[] getTransaction_type_array() {
        return transaction_type_array;
    }

    public void setTransaction_type_array(String[] transaction_type_array) {
        this.transaction_type_array = transaction_type_array;
    }

    public String getAccount_no() {
        return account_no;
    }

    public void setAccount_no(String account_no) {
        this.account_no = account_no;
    }

    public String[] getDr_indicator_array() {
        return dr_indicator_array;
    }

    public void setDr_indicator_array(String[] dr_indicator_array) {
        this.dr_indicator_array = dr_indicator_array;
    }

    public BigDecimal getTransaction_amount_max() {
        return transaction_amount_max;
    }

    public void setTransaction_amount_max(BigDecimal transaction_amount_max) {
        this.transaction_amount_max = transaction_amount_max;
    }





    public String[] getAccount_type_array() {
        return account_type_array;
    }

    public void setAccount_type_array(String[] account_type_array) {
        this.account_type_array = account_type_array;
    }

    public String[] getCurrency_array() {
        return currency_array;
    }

    public void setCurrency_array(String[] currency_array) {
        this.currency_array = currency_array;
    }

    public String getOpen_date_max() {
        return open_date_max;
    }

    public void setOpen_date_max(String open_date_max) {
        this.open_date_max = open_date_max;
    }

    public BigDecimal getAccount_balance_max() {
        return account_balance_max;
    }

    public void setAccount_balance_max(BigDecimal account_balance_max) {
        this.account_balance_max = account_balance_max;
    }

    public BigDecimal getPrincipal_amount_max() {
        return principal_amount_max;
    }

    public void setPrincipal_amount_max(BigDecimal principal_amount_max) {
        this.principal_amount_max = principal_amount_max;
    }

    public BigDecimal getBalance_max() {
        return balance_max;
    }

    public void setBalance_max(BigDecimal balance_max) {
        this.balance_max = balance_max;
    }

    public String getValue_date_max() {
        return value_date_max;
    }

    public void setValue_date_max(String value_date_max) {
        this.value_date_max = value_date_max;
    }

    public String getMaturity_date_max() {
        return maturity_date_max;
    }

    public void setMaturity_date_max(String maturity_date_max) {
        this.maturity_date_max = maturity_date_max;
    }

    public String[] getBranch_array() {
        return branch_array;
    }

    public void setBranch_array(String[] branch_array) {
        this.branch_array = branch_array;
    }

    public String[] getPrincipal_currency_array() {
        return principal_currency_array;
    }

    public void setPrincipal_currency_array(String[] principal_currency_array) {
        this.principal_currency_array = principal_currency_array;
    }

    public String[] getBalance_currency_array() {
        return balance_currency_array;
    }

    public void setBalance_currency_array(String[] balance_currency_array) {
        this.balance_currency_array = balance_currency_array;
    }

    public String[] getLoan_type_array() {
        return loan_type_array;
    }

    public void setLoan_type_array(String[] loan_type_array) {
        this.loan_type_array = loan_type_array;
    }

    public String[] getAccount_status_array() {
        return account_status_array;
    }

    public void setAccount_status_array(String[] account_status_array) {
        this.account_status_array = account_status_array;
    }

    public Base_Entity parseJson(String search, Class<?> classtype) {
        ObjectMapper objectMapper = new ObjectMapper();
        Object obj = null;
        try {
            Class cls = Class.forName(classtype.getName());
            obj =  objectMapper.readValue(search, classtype);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (Base_Entity) obj;
    }
}

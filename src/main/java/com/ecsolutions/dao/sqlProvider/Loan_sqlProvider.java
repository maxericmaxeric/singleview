package com.ecsolutions.dao.sqlProvider;

import com.ecsolutions.entity.LoanSearch_Entity;
import com.ecsolutions.util.SqlProviderUtil;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.jdbc.SQL;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/23.
 */
public class Loan_sqlProvider {
    public String getLoan_Sql(Map<String, Object> parameters) {
        String customer_code = (String)parameters.get("customer_code");
        String search = (String)parameters.get("search");
        String orderCol = (String)parameters.get("orderCol");
        String orderDir = (String)parameters.get("orderDir");

        ObjectMapper objectMapper = new ObjectMapper();
        LoanSearch_Entity loanSearch_entity = null;
        String[] branch_array;
        String LN_Account_No;
        String[] Loan_Type_array;
        String Line_No;
        String[] principal_currency_array;
        BigDecimal Principal_Amount;
        BigDecimal Principal_Amount_Max;
        String Value_Date;
        String Value_Date_Max;
        String Maturity_Date;
        String Maturity_Date_Max;
        String[] Balance_Currency_array;
        BigDecimal Balance;
        BigDecimal Balance_Max;
        String[] Account_Status_array;

        try {
            loanSearch_entity = objectMapper.readValue(search, LoanSearch_Entity.class);

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (loanSearch_entity == null)
            return "";
        else {
            branch_array = loanSearch_entity.getBranch_array();
            LN_Account_No = loanSearch_entity.getLn_account_no();
            Loan_Type_array = loanSearch_entity.getLoan_type_array();
            Line_No = loanSearch_entity.getLine_no();
            Principal_Amount = loanSearch_entity.getPrincipal_amount();
            Principal_Amount_Max = loanSearch_entity.getPrincipal_amount_max();
            principal_currency_array = loanSearch_entity.getPrincipal_currency_array();
            Value_Date = loanSearch_entity.getValue_date();
            Value_Date_Max = loanSearch_entity.getValue_date_max();
            Maturity_Date = loanSearch_entity.getMaturity_date();
            Maturity_Date_Max = loanSearch_entity.getMaturity_date_max();
            Balance_Currency_array = loanSearch_entity.getBalance_currency_array();
            Balance = loanSearch_entity.getBalance();
            Balance_Max = loanSearch_entity.getBalance_max();
            Account_Status_array = loanSearch_entity.getAccount_status_array();
            return new SQL() {
                {
                    SELECT("Branch, LN_Account_No,Loan_Type,Line_No, Principal_Currency,Principal_Amount,Value_Date,Maturity_Date,Balance_Currency,Balance,Account_Status");
                    FROM("LOAN_ACCOUNT_INFO");
                    WHERE("customer_code = #{customer_code}");
                    if (LN_Account_No != null && !LN_Account_No.equals("")) {
                        String LN_Account_No_like = "%" + LN_Account_No + "%";
                        WHERE("LN_ACCOUNT_NO LIKE '" + LN_Account_No_like + "'");
                    }
                    if (Line_No != null && !Line_No.equals("")) {
                        String Line_No_like = "%" + Line_No + "%";
                        WHERE("LINE_NO LIKE '" + Line_No_like + "'");
                    }
                    if (branch_array != null && branch_array.length > 0) {
                        String whereSql = "BRANCH IN (";
                        whereSql += SqlProviderUtil.getArray(branch_array);
                        whereSql += ")";
                        WHERE(whereSql);
                    }

                    if (Loan_Type_array != null && Loan_Type_array.length > 0) {
                        String whereSql = "LOAN_TYPE IN (";
                        whereSql += SqlProviderUtil.getArray(Loan_Type_array);
                        whereSql += ")";
                        WHERE(whereSql);
                    }

                    if (principal_currency_array != null && principal_currency_array.length > 0) {
                        String whereSql = "PRINCIPAL_CURRENCY IN (";
                        whereSql += SqlProviderUtil.getArray(principal_currency_array);
                        whereSql += ")";
                        WHERE(whereSql);
                    }

                    if (Balance_Currency_array != null && Balance_Currency_array.length > 0) {
                        String whereSql = "BALANCE_CURRENCY IN (";
                        whereSql += SqlProviderUtil.getArray(Balance_Currency_array);
                        whereSql += ")";
                        WHERE(whereSql);
                    }
                    if (Account_Status_array != null && Account_Status_array.length > 0) {
                        String whereSql = "ACCOUNT_STATUS IN (";
                        whereSql += SqlProviderUtil.getArray(Account_Status_array);
                        whereSql += ")";
                        WHERE(whereSql);
                    }
                    if (Principal_Amount != null && !Principal_Amount.equals(""))
                        WHERE("PRINCIPAL_AMOUNT >= " + Principal_Amount);
                    if (Principal_Amount_Max != null && !Principal_Amount_Max.equals(""))
                        WHERE("PRINCIPAL_AMOUNT <= " + Principal_Amount_Max);
                    if (Balance != null && !Balance.equals(""))
                        WHERE("BALANCE >= " + Balance);
                    if (Balance_Max != null && !Balance_Max.equals(""))
                        WHERE("BALANCE <= " + Balance_Max);
                    if (Value_Date != null && !Value_Date.equals(""))
                        WHERE("VALUE_DATE >= '" + Value_Date + "'");
                    if (Value_Date_Max != null && !Value_Date_Max.equals(""))
                        WHERE("VALUE_DATE <= '" + Value_Date_Max + "'");
                    if (Maturity_Date != null && !Maturity_Date.equals(""))
                        WHERE("MATURITY_DATE >= '" + Maturity_Date + "'");
                    if (Maturity_Date_Max != null && !Maturity_Date_Max.equals(""))
                        WHERE("MATURITY_DATE <= '" + Maturity_Date_Max + "'");

                    if (orderCol != null && !orderCol.equals("")) {
                        String ordercolumn = orderCol.trim().toUpperCase();
                        String order = null;
                        if (orderDir.trim().toUpperCase().equals("ASC"))
                            order = "ASC";
                        else if (orderDir.trim().toUpperCase().equals("DESC"))
                            order = "DESC";
                        else
                            order = "";
                        ORDER_BY(ordercolumn + " " + order);
                    }
                }
            }.toString();
        }
    }
}

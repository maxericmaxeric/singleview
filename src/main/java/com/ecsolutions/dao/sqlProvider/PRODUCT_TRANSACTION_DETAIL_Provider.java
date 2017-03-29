package com.ecsolutions.dao.sqlProvider;

import com.ecsolutions.entity.PRODUCT_TRANSACTION_DETAIL_Entity;
import com.ecsolutions.util.SqlProviderUtil;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.jdbc.SQL;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by Administrator on 2017-3-29.
 */
public class PRODUCT_TRANSACTION_DETAIL_Provider {
    public String getDpTranSql(Map<String, Object> parameters) {
        String customer_code = (String)parameters.get("customer_code");
        String search = (String)parameters.get("search");
        String orderCol = (String)parameters.get("orderCol");
        String orderDir = (String)parameters.get("orderDir");

        ObjectMapper objectMapper = new ObjectMapper();
        PRODUCT_TRANSACTION_DETAIL_Entity product_transaction_detail_entity = null;
        String[] branch_array;
        String Dep_Serial_No;
        String Transaction_Date;
        String Transaction_Date_Max;
        String[] Transaction_Type_Array;
        String Account_No;
        String[] Currency_Array;
        String[] DR_Indicator_Array;
        BigDecimal Transaction_Amount;
        BigDecimal Transaction_Amount_Max;

        try {
            product_transaction_detail_entity = objectMapper.readValue(search,  PRODUCT_TRANSACTION_DETAIL_Entity.class);

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (product_transaction_detail_entity == null)
            return "";
        else {
            branch_array = product_transaction_detail_entity.getBranch_array();
            Dep_Serial_No=product_transaction_detail_entity.getDep_serial_no();
            Transaction_Date=product_transaction_detail_entity.getTransaction_date();
            Transaction_Date_Max=product_transaction_detail_entity.getTransaction_date_max();
            Transaction_Type_Array=product_transaction_detail_entity.getTransaction_type_array();
            Account_No=product_transaction_detail_entity.getAccount_no();
            Currency_Array=product_transaction_detail_entity.getCurrency_array();
            DR_Indicator_Array=product_transaction_detail_entity.getDr_indicator_array();
            Transaction_Amount=product_transaction_detail_entity.getTransaction_amount();
            Transaction_Amount_Max=product_transaction_detail_entity.getTransaction_amount_max();

            return new SQL() {
                {
                    SELECT("Branch,Dep_Serial_No,Transaction_Date,Transaction_Type,Account_No,Currency,DR_Indicator,Transaction_Amount");
                    FROM("DEPOSIT_ACCOUNT_TRAN");
                    WHERE("customer_code = #{customer_code}");
                    if (Dep_Serial_No != null && !Dep_Serial_No.equals("")) {
                        String Dep_Serial_No_like = "%" + Dep_Serial_No + "%";
                        WHERE("Dep_Serial_No LIKE '" + Dep_Serial_No_like + "'");
                    }
                    if (Account_No != null && !Account_No.equals("")) {
                        String Account_No_like = "%" + Account_No + "%";
                        WHERE("Account_No LIKE '" + Account_No_like + "'");
                    }
                    if (branch_array != null && branch_array.length > 0) {
                        String whereSql = "BRANCH IN (";
                        whereSql += SqlProviderUtil.getArray(branch_array);
                        whereSql += ")";
                        WHERE(whereSql);
                    }

                    if (Transaction_Type_Array != null && Transaction_Type_Array.length > 0) {
                        String whereSql = "Transaction_Type IN (";
                        whereSql += SqlProviderUtil.getArray(Transaction_Type_Array);
                        whereSql += ")";
                        WHERE(whereSql);
                    }

                    if (Currency_Array != null && Currency_Array.length > 0) {
                        String whereSql = "Currency IN (";
                        whereSql += SqlProviderUtil.getArray(Currency_Array);
                        whereSql += ")";
                        WHERE(whereSql);
                    }

                    if (DR_Indicator_Array != null && DR_Indicator_Array.length > 0) {
                        String whereSql = "DR_Indicator IN (";
                        whereSql += SqlProviderUtil.getArray(DR_Indicator_Array);
                        whereSql += ")";
                        WHERE(whereSql);
                    }

                    if (Transaction_Amount != null && !Transaction_Amount.equals(""))
                        WHERE("Transaction_Amount >= " + Transaction_Amount);
                    if (Transaction_Amount_Max != null && !Transaction_Amount_Max.equals(""))
                        WHERE("Transaction_Amount <= " + Transaction_Amount_Max);

                    if (Transaction_Date != null && !Transaction_Date.equals(""))
                        WHERE("Transaction_Date >= '" + Transaction_Date + "'");
                    if (Transaction_Date_Max != null && !Transaction_Date_Max.equals(""))
                        WHERE("Transaction_Date <= '" + Transaction_Date_Max + "'");


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

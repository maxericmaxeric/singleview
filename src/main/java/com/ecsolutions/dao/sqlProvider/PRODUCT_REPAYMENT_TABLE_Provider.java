package com.ecsolutions.dao.sqlProvider;

import com.ecsolutions.entity.PRODUCT_REPAYMENT_TABLE_Entity;
import com.ecsolutions.util.SqlProviderUtil;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.jdbc.SQL;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by Administrator on 2017-3-30.
 */
public class PRODUCT_REPAYMENT_TABLE_Provider {
    public String getRepaymentSql(Map<String, Object> parameters) {
        String customer_code = (String)parameters.get("customer_code");
        String search = (String)parameters.get("search");
        String orderCol = (String)parameters.get("orderCol");
        String orderDir = (String)parameters.get("orderDir");

        ObjectMapper objectMapper = new ObjectMapper();
        PRODUCT_REPAYMENT_TABLE_Entity product_repayment_table_entity = null;
        String[] branch_array;
        String Open_Item_Num;
        String Instalment_No;
        String Start_Date;
        String Start_Date_Max;
        String Due_Date;
        String Due_Date_Max;
        String Paid_Date;
        String Paid_Date_Max;
        String[] Currency_Array;
        BigDecimal Instalment_Amount;
        BigDecimal Instalment_Amount_Max;
        BigDecimal Interest_Amt;
        BigDecimal Interest_Amt_Max;
        String[] Overdue_Flag_Array;

        try {
            product_repayment_table_entity = objectMapper.readValue(search, PRODUCT_REPAYMENT_TABLE_Entity.class);

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (product_repayment_table_entity == null)
            return "";
        else {
            branch_array = product_repayment_table_entity.getBranch_array();
            Open_Item_Num = product_repayment_table_entity.getOpen_item_num();
            Instalment_No = product_repayment_table_entity.getInstalment_no();
            Start_Date = product_repayment_table_entity.getStart_date();
            Start_Date_Max = product_repayment_table_entity.getStart_date_max();
            Due_Date = product_repayment_table_entity.getDue_date();
            Due_Date_Max = product_repayment_table_entity.getDue_date_max();
            Paid_Date = product_repayment_table_entity.getPaid_date();
            Paid_Date_Max = product_repayment_table_entity.getPaid_date_max();
            Currency_Array = product_repayment_table_entity.getCurrency_array();
            Instalment_Amount = product_repayment_table_entity.getInstalment_amount();
            Instalment_Amount_Max = product_repayment_table_entity.getInstalment_amount_max();
            Interest_Amt = product_repayment_table_entity.getInterest_amt();
            Interest_Amt_Max = product_repayment_table_entity.getInterst_amt_max();
            Overdue_Flag_Array = product_repayment_table_entity.getOverdue_flag_array();

            return new SQL() {
                {
                    SELECT("OPEN_ITEM_NUM,INSTALMENT_NO,BRANCH, START_DATE,DUE_DATE,PAID_DATE,CURRENCY,INSTALMENT_AMOUNT,INTEREST_AMT,OVERDUE_FLAG");
                    FROM("repayment");
                    WHERE("customer_code = #{customer_code}");
                    if (Open_Item_Num != null && !Open_Item_Num.equals("")) {
                        String Open_Item_Num_like = "%" + Open_Item_Num + "%";
                        WHERE("Open_Item_Num LIKE '" + Open_Item_Num_like + "'");
                    }
                    if (Instalment_No != null && !Instalment_No.equals("")) {
                        String Instalment_No_like = "%" + Instalment_No + "%";
                        WHERE("Instalment_No LIKE '" + Instalment_No_like + "'");
                    }
                    if (branch_array != null && branch_array.length > 0) {
                        String whereSql = "BRANCH IN (";
                        whereSql += SqlProviderUtil.getArray(branch_array);
                        whereSql += ")";
                        WHERE(whereSql);
                    }

                    if (Overdue_Flag_Array != null && Overdue_Flag_Array.length > 0) {
                        String whereSql = "OVERDUE_FLAG IN (";
                        whereSql += SqlProviderUtil.getArray(Overdue_Flag_Array);
                        whereSql += ")";
                        WHERE(whereSql);
                    }

                    if (Currency_Array != null && Currency_Array.length > 0) {
                        String whereSql = "Currency IN (";
                        whereSql += SqlProviderUtil.getArray(Currency_Array);
                        whereSql += ")";
                        WHERE(whereSql);
                    }


                    if (Start_Date != null && !Start_Date.equals(""))
                        WHERE("Start_Date >= " + Start_Date);
                    if (Start_Date_Max != null && !Start_Date_Max.equals(""))
                        WHERE("Start_Date <= " + Start_Date_Max);

                    if (Due_Date != null && !Due_Date.equals(""))
                        WHERE("Due_Date >= '" + Due_Date + "'");
                    if (Due_Date_Max != null && !Due_Date_Max.equals(""))
                        WHERE("Due_Date <= '" + Due_Date_Max + "'");

                    if (Paid_Date != null && !Paid_Date.equals(""))
                        WHERE("Paid_Date >= '" + Paid_Date + "'");
                    if (Paid_Date_Max != null && !Paid_Date_Max.equals(""))
                        WHERE("Paid_Date <= '" + Paid_Date_Max + "'");

                    if (Instalment_Amount != null && !Instalment_Amount.equals(""))
                        WHERE("Instalment_Amount >= '" + Instalment_Amount + "'");
                    if (Instalment_Amount_Max != null && !Instalment_Amount_Max.equals(""))
                        WHERE("Instalment_Amount <= '" + Instalment_Amount_Max + "'");

                    if (Interest_Amt != null && !Interest_Amt.equals(""))
                        WHERE("Interest_Amt >= '" + Interest_Amt + "'");
                    if (Interest_Amt_Max != null && !Interest_Amt_Max.equals(""))
                        WHERE("Interest_Amt <= '" + Interest_Amt_Max + "'");




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

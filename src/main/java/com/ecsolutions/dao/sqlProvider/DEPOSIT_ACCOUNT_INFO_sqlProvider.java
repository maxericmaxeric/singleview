package com.ecsolutions.dao.sqlProvider;

import com.ecsolutions.entity.DEPOSIT_ACCOUNT_INFO_Entity;
import org.apache.ibatis.jdbc.SQL;

import java.math.BigDecimal;
import java.util.Map;

import static com.ecsolutions.util.SqlProviderUtil.getArray;

/**
 * Created by Administrator on 2017/3/16.
 */
public class DEPOSIT_ACCOUNT_INFO_sqlProvider {
    public String getDEPOSIT_ACCOUNT_INFO_Sql(Map<String, Object> parameters) {
//        String customer_code, String branch, String dp_account_no, String account_type, String currency, String open_date_begin, String open_date_end, String maturity_date_begin, String maturity_date_end, BigDecimal account_balance, String account_status
        String dp_account_no = (String)parameters.get("dp_account_no");
        String[] branch = (String[])parameters.get("branch");
        String[] account_type = (String[])parameters.get("account_type");
        String[] currency = (String[])parameters.get("currency");
        String open_date_begin = (String)parameters.get("open_date_begin");
        String open_date_end = (String)parameters.get("open_date_end");
        String maturity_date_begin = (String)parameters.get("maturity_date_begin");
        String maturity_date_end = (String)parameters.get("maturity_date_end");
        BigDecimal account_balance_min = (BigDecimal)parameters.get("account_balance_min");
        BigDecimal account_balance_max = (BigDecimal)parameters.get("account_balance_max");
        String[] account_status = (String[])parameters.get("account_status");

//        String dp_account_no_like = "%" + dp_account_no + "%";

        return new SQL() {
            {
                SELECT("BRANCH,DP_ACCOUNT_NO,ACCOUNT_TYPE,CURRENCY,OPEN_DATE,MATURITY_DATE,ACCOUNT_BALANCE,ACCOUNT_STATUS");
                FROM("DEPOSIT_ACCOUNT_INFO");
                WHERE("CUSTOMER_CODE = #{customer_code}");
                if (!dp_account_no.equals("") && dp_account_no != null) {
                    String dp_account_no_like = "%" + dp_account_no + "%";
                    WHERE("DP_ACCOUNT_NO LIKE '" + dp_account_no_like + "'");
                }
                if (branch != null && branch.length > 0){
                    String whereSql = "BRANCH IN (";
                    whereSql += getArray(branch);
                    whereSql += ")";
                    WHERE(whereSql);
                }

                if (account_type != null && account_type.length > 0){
                    String whereSql = "ACCOUNT_TYPE IN (";
                    whereSql += getArray(account_type);
                    whereSql += ")";
                    WHERE(whereSql);
                }
                if (currency != null && currency.length > 0){
                    String whereSql = "CURRENCY IN (";
                    whereSql += getArray(currency);
                    whereSql += ")";
                    WHERE(whereSql);
                }
                if (!open_date_begin.equals("") && open_date_begin != null)
                    WHERE("OPEN_DATE >= #{open_date_begin}");
                if (!open_date_end.equals("") && open_date_end != null)
                    WHERE("OPEN_DATE <= #{open_date_end}");
                if (!maturity_date_begin.equals("") && maturity_date_begin != null)
                    WHERE("MATURITY_DATE >= #{maturity_date_begin}");
                if (!maturity_date_end.equals("") && maturity_date_end != null)
                    WHERE("MATURITY_DATE <= #{maturity_date_end}");
                if (!account_balance_min.equals(new BigDecimal(-1)))
                    WHERE("ACCOUNT_BALANCE >= #{account_balance_min}");
                if (!account_balance_max.equals(new BigDecimal(-1)))
                    WHERE("ACCOUNT_BALANCE <= #{account_balance_max}");
                if (account_status != null && account_status.length > 0){
                    String whereSql = "ACCOUNT_STATUS IN (";
                    whereSql += getArray(account_status);
                    whereSql += ")";
                    WHERE(whereSql);
                }
            }
        }.toString();
    }


    public String getDeposit_Sql(Map<String, Object> parameters) {
        String search = (String)parameters.get("search");
        DEPOSIT_ACCOUNT_INFO_Entity deposit_account_info_entity = new DEPOSIT_ACCOUNT_INFO_Entity();
        deposit_account_info_entity = (DEPOSIT_ACCOUNT_INFO_Entity)deposit_account_info_entity.parseJson(search, DEPOSIT_ACCOUNT_INFO_Entity.class);
        SQL sql = getDepositDtSql(deposit_account_info_entity, parameters);
        return sql.toString();
    }

    private SQL getDepositDtSql(DEPOSIT_ACCOUNT_INFO_Entity deposit_account_info_entity, Map<String, Object> parameters) {
        String customer_code = (String)parameters.get("customer_code");
        String orderCol = (String)parameters.get("orderCol");
        String orderDir = (String)parameters.get("orderDir");
        return new SQL() {
            {
                SELECT("BRANCH,DP_ACCOUNT_NO,ACCOUNT_TYPE,CURRENCY,OPEN_DATE,MATURITY_DATE,ACCOUNT_BALANCE,ACCOUNT_STATUS");
                FROM("DEPOSIT_ACCOUNT_INFO");
                WHERE("CUSTOMER_CODE = #{customer_code}");
                if (deposit_account_info_entity != null) {
                    String dp_account_no = deposit_account_info_entity.getDp_account_no();
                    String[] branch_array = deposit_account_info_entity.getBranch_array();
                    String[] account_type_array = deposit_account_info_entity.getAccount_type_array();
                    String[] currency_array = deposit_account_info_entity.getCurrency_array();
                    String open_date = deposit_account_info_entity.getOpen_date();
                    String open_date_max = deposit_account_info_entity.getOpen_date_max();
                    String maturity_date = deposit_account_info_entity.getMaturity_date();
                    String maturity_date_max = deposit_account_info_entity.getMaturity_date_max();
                    BigDecimal account_balance = deposit_account_info_entity.getAccount_balance();
                    BigDecimal account_balance_max = deposit_account_info_entity.getAccount_balance_max();
                    String[] account_status_array = deposit_account_info_entity.getAccount_status_array();
                    if (dp_account_no != null && !dp_account_no.equals("")) {
                        String dp_account_no_like = "%" + dp_account_no + "%";
                        WHERE("DP_ACCOUNT_NO LIKE '" + dp_account_no_like + "'");
                    }
                    if (branch_array != null && branch_array.length > 0) {
                        String whereSql = "BRANCH IN (";
                        whereSql += getArray(branch_array);
                        whereSql += ")";
                        WHERE(whereSql);
                    }

                    if (account_type_array != null && account_type_array.length > 0) {
                        String whereSql = "ACCOUNT_TYPE IN (";
                        whereSql += getArray(account_type_array);
                        whereSql += ")";
                        WHERE(whereSql);
                    }
                    if (currency_array != null && currency_array.length > 0) {
                        String whereSql = "CURRENCY IN (";
                        whereSql += getArray(currency_array);
                        whereSql += ")";
                        WHERE(whereSql);
                    }
                    if (open_date != null && !open_date.equals(""))
                        WHERE("OPEN_DATE >= '" + open_date + "'");
                    if (open_date_max != null && !open_date_max.equals(""))
                        WHERE("OPEN_DATE <= '" + open_date_max + "'");
                    if (maturity_date != null && !maturity_date.equals(""))
                        WHERE("MATURITY_DATE >= '" + maturity_date + "'");
                    if (maturity_date_max != null && !maturity_date_max.equals(""))
                        WHERE("MATURITY_DATE <= '" + maturity_date_max + "'");
                    if (account_balance != null && !account_balance.equals(""))
                        WHERE("ACCOUNT_BALANCE >= " + account_balance);
                    if (account_balance_max != null && !account_balance_max.equals(""))
                        WHERE("ACCOUNT_BALANCE <= " + account_balance_max);
                    if (account_status_array != null && account_status_array.length > 0) {
                        String whereSql = "ACCOUNT_STATUS IN (";
                        whereSql += getArray(account_status_array);
                        whereSql += ")";
                        WHERE(whereSql);
                    }
                }
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
        };
    }

}

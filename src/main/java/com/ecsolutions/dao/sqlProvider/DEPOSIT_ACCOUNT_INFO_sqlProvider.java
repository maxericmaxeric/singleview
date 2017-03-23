package com.ecsolutions.dao.sqlProvider;

import org.apache.ibatis.jdbc.SQL;

import java.math.BigDecimal;
import java.util.Map;

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

    private String getArray(String[] branch) {
        String ret = "";
        for (int i = 0; i < branch.length; i++) {
            if (i > 0) ret += ",";
            ret += "'";
            ret += branch[i];
            ret += "'";
        }
        return ret;
    }


/*    public String getDEPOSIT_ACCOUNT_INFO_Sql(String customer_code, String branch, String dp_account_no, String account_type, String currency, String open_date_begin, String open_date_end, String maturity_date_begin, String maturity_date_end, BigDecimal account_balance, String account_status
    ) {
//        String customer_code, String branch, String dp_account_no, String account_type, String currency, String open_date_begin, String open_date_end, String maturity_date_begin, String maturity_date_end, BigDecimal account_balance, String account_status
        String dp_account_no_like = "%" + dp_account_no + "%";
        return new SQL() {
            {
                SELECT("select BRANCH,DP_ACCOUNT_NO,ACCOUNT_TYPE,CURRENCY,OPEN_DATE,MATURITY_DATE,ACCOUNT_BALANCE,ACCOUNT_STATUS");
                FROM("DEPOSIT_ACCOUNT_INFO");
                WHERE("CUSTOMER_CODE = #{customer_code}");
                if (dp_account_no != "" && dp_account_no != null)
                    WHERE("DP_ACCOUNT_NO LIKE #{dp_account_no_like}");
                if (branch != "" && branch != null)
                    WHERE("BRANCH = #{branch}");
                if (account_type != "" && account_type != null)
                    WHERE("ACCOUNT_TYPE = #{account_type}");
                if (currency != "" && currency != null)
                    WHERE("CURRENCY = #{currency}");
                if (open_date_begin != "" && open_date_begin != null)
                    WHERE("OPEN_DATE >= #{open_date_begin}");
                if (open_date_end != "" && open_date_end != null)
                    WHERE("OPEN_DATE <= #{open_date_end}");
                if (maturity_date_begin != "" && maturity_date_begin != null)
                    WHERE("MATURITY_DATE >= #{maturity_date_begin}");
                if (maturity_date_end != "" && maturity_date_end != null)
                    WHERE("MATURITY_DATE <= #{maturity_date_end}");
                if (account_balance != null)
                    WHERE("ACCOUNT_BALANCE = #{account_balance}");
                if (account_status != "" && account_status != null)
                    WHERE("ACCOUNT_STATUS = #{account_status}");
            }
        }.toString();
    }*/


}

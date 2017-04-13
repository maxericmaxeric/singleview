package com.ecsolutions.dao.sqlProvider;

import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * Created by Administrator on 2017-3-17.
 */
public class DEPOSIT_INFO_SEARCH_Provider {
    public String searchInfoByCustCode(Map<String, Object> map)
    {
        String dp_account_no = (String) map.get("dp_account_no");  //acc no
        String ln_account_no = (String) map.get("ln_account_no");  //loan ref no
        String customer_code = (String) map.get("customer_code");  //cus code
        String customer_full_name = (String) map.get("customer_full_name");  //cus name
        String identity_no = (String) map.get("identity_no");  //id num
        //String userid = (String) map.get("userid");

        return new SQL()
        {
            {
                SELECT(" distinct c.Customer_Code,c.Customer_full_name,c.Identity_No");
                FROM("(select Customer_Code,customer_full_name,identity_no\n" +
                        "  from customer_info_main\n" +
                        " where internal_org_code in\n" +
                        "       (select internal_code\n" +
                        "          from organization_info\n" +
                        "         where trim(Organization_Code) in\n" +
                        "               (select trim(organization)\n" +
                        "                  from csvuser\n" +
                        "                 where userid = #{userid})\n" +
                        "        union\n" +
                        "        select internal_code\n" +
                        "          from (select a.*, b.organization\n" +
                        "                  from organization_info a,\n" +
                        "                       (select * from csvuser where userid = #{userid}) b)\n" +
                        "         start with trim(parent_organization_code) = trim(organization)\n" +
                        "        connect by prior\n" +
                        "                    trim(organization_code) = trim(parent_organization_code))) c");
                LEFT_OUTER_JOIN("DEPOSIT_ACCOUNT_INFO a on c.Customer_Code=a.Customer_Code");
                LEFT_OUTER_JOIN("LOAN_ACCOUNT_INFO b on b.Customer_Code=a.Customer_Code");
                if(!dp_account_no.equals("") && dp_account_no != null) {
                    WHERE("a.DP_ACCOUNT_NO like concat(concat('%',#{dp_account_no}),'%')");
                }
                if(!ln_account_no.equals("") && ln_account_no != null){
                    WHERE("b.LN_Account_No like concat(concat('%',#{ln_account_no}),'%')");
                }
                if(!customer_code.equals("") && customer_code != null){
                    WHERE("c.Customer_Code like concat(concat('%',#{customer_code}),'%')");
                }
                if(!customer_full_name.equals("") && customer_full_name != null){
                    WHERE("c.Customer_Full_Name like concat(concat('%',#{customer_full_name}),'%')");
                }
                if(!identity_no.equals("") && identity_no != null){
                    WHERE("c.Identity_No like concat(concat('%',#{identity_no}),'%')");
                }
            }
        } .toString();
    }
}

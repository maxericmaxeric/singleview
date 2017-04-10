package com.ecsolutions.dao.sqlProvider;

import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * Created by Administrator on 2017/4/10.
 */
public class User_sqlProvider {

    public String getSql(Map<String, Object> parameters) {
        String search = (String)parameters.get("search");
        String orderCol = (String)parameters.get("orderCol");
        String orderDir = (String)parameters.get("orderDir");
        SQL sql = null;
        sql = new SQL() {
            {
                SELECT("TRIM(USERID) USERID, TRIM(USERNAME) USERNAME, TRIM(PASSWORD) PASSWORD, TRIM(ORGANIZATION) ORGANIZATION, TRIM(GROUPID) GROUPID, TRIM(STATUS) STATUS, TRIM(ADMINFLAG) ADMINFLAG");
                FROM("CSVUSER");
                if (search != null && !search.equals("")) {
                    WHERE("USERID||USERNAME||ORGANIZATION||GROUPID||STATUS||ADMINFLAG LIKE '%" + search + "%'");
                }
                ORDER_BY(orderCol + " " +orderDir );
            }
        };
        return sql.toString();
    }
}

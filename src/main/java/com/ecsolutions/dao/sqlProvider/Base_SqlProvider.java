package com.ecsolutions.dao.sqlProvider;

import com.ecsolutions.entity.Base_Entity;
import com.ecsolutions.entity.CollateralMain_Entity;
import com.ecsolutions.entity.CreditLineMain_Entity;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * Created by Administrator on 2017/3/31.
 */
public abstract class Base_SqlProvider {
    public String getSql(Map<String, Object> parameters) {
        String search = (String)parameters.get("search");
        Base_SqlProvider sqlProvider = this.getSqlProvider();
        Base_Entity base_entity = null;
        Base_Entity search_entity = null;
        if (sqlProvider instanceof  CreditLineMain_sqlProvider) {
            base_entity = new CreditLineMain_Entity();
            search_entity = (CreditLineMain_Entity)base_entity.parseJson(search, CreditLineMain_Entity.class);
        } else if (sqlProvider instanceof  CollateralMain_sqlProvider) {
            base_entity = new CollateralMain_Entity();
            search_entity = (CollateralMain_Entity)base_entity.parseJson(search, CollateralMain_Entity.class);
        }

        String orderCol = (String)parameters.get("orderCol");
        String orderDir = (String)parameters.get("orderDir");
        SQL sql = null;
        try {
            sql = getDtSql(search_entity, orderCol, orderDir);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sql.toString();
    }

    abstract Base_SqlProvider getSqlProvider();
    abstract SQL getDtSql(Base_Entity base_entity, String orderCol, String orderDir) throws Exception;
}

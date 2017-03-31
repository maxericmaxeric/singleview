package com.ecsolutions.dao.sqlProvider;

import com.ecsolutions.entity.Base_Entity;
import com.ecsolutions.entity.CollateralMain_Entity;
import org.apache.ibatis.jdbc.SQL;

import java.math.BigDecimal;

import static com.ecsolutions.util.SqlProviderUtil.getArray;

/**
 * Created by Administrator on 2017/3/31.
 */
public class CollateralMain_sqlProvider extends Base_SqlProvider {
    @Override
    Base_SqlProvider getSqlProvider() {
        return this;
    }

    @Override
    SQL getDtSql(Base_Entity base_entity, String orderCol, String orderDir) throws Exception {
        CollateralMain_Entity collateralMain_entity = null;
        if (base_entity instanceof CollateralMain_Entity)
            collateralMain_entity = (CollateralMain_Entity)base_entity;
        else {
            throw new Exception("base_entity class type error!");
        }

        CollateralMain_Entity finalCollateralMain_entity = collateralMain_entity;
        return new SQL() {
            {
                SELECT("REF,COLLATERAL_NO,COLLATERAL_TYPE,ITEM_DESCRIPTION, VAL_CURRENCY ,VALUATION,VALUATION_DATE,LINE_NO");
                FROM("COLLATERAL_MAIN");
                WHERE("TRIM(CUSTOMER_CODE) = TRIM(#{customer_code})");
                if (finalCollateralMain_entity != null) {
                    String collateral_no = finalCollateralMain_entity.getCollateral_no();
                    String item_description = finalCollateralMain_entity.getItem_description();
                    BigDecimal valuation = finalCollateralMain_entity.getValuation();
                    String valuation_date = finalCollateralMain_entity.getValuation_date();
                    String line_no = finalCollateralMain_entity.getLine_no();
                    Boolean auto = finalCollateralMain_entity.getAuto();

                    String[] collateral_type_array = finalCollateralMain_entity.getCollateral_type_array();
                    String[] val_currency_array = finalCollateralMain_entity.getVal_currency_array();
                    BigDecimal valuation_max = finalCollateralMain_entity.getValuation_max();
                    String valuation_date_max = finalCollateralMain_entity.getValuation_date_max();
                    if (collateral_no != null && !collateral_no.equals("")) {
                        String collateral_no_like = "%" + collateral_no + "%";
                        WHERE("COLLATERAL_NO LIKE '" + collateral_no_like + "'");
                    }
                    if (item_description != null && !item_description.equals("")) {
                        String item_description_like = "%" + item_description + "%";
                        WHERE("ITEM_DESCRIPTION LIKE '" + item_description_like + "'");
                    }
                    if (line_no != null && !line_no.equals("")) {
                        if (auto)  WHERE(" LINE_NO = '" + line_no + "'");
                        else {
                            String line_no_like = "%" + line_no + "%";
                            WHERE("LINE_NO LIKE '" + line_no_like + "'");
                        }
                    }
                    if (valuation != null && !valuation.equals(""))
                        WHERE("VALUATION >= '" + valuation + "'");
                    if (valuation_max != null && !valuation_max.equals(""))
                        WHERE("VALUATION <= '" + valuation_max + "'");
                    if (valuation_date != null && !valuation_date.equals(""))
                        WHERE("VALUATION_DATE >= '" + valuation_date + "'");
                    if (valuation_date_max != null && !valuation_date_max.equals(""))
                        WHERE("VALUATION_DATE <= '" + valuation_date_max + "'");
                    if (collateral_type_array != null && collateral_type_array.length > 0) {
                        String whereSql = "COLLATERAL_TYPE IN (";
                        whereSql += getArray(collateral_type_array);
                        whereSql += ")";
                        WHERE(whereSql);
                    }
                    if (val_currency_array != null && val_currency_array.length > 0) {
                        String whereSql = "VAL_CURRENCY IN (";
                        whereSql += getArray(val_currency_array);
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

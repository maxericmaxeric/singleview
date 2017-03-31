package com.ecsolutions.dao.sqlProvider;

import com.ecsolutions.entity.Base_Entity;
import com.ecsolutions.entity.CreditLineMain_Entity;
import org.apache.ibatis.jdbc.SQL;

import java.math.BigDecimal;

import static com.ecsolutions.util.SqlProviderUtil.getArray;

/**
 * Created by Administrator on 2017/3/31.
 */
public class CreditLineMain_sqlProvider extends Base_SqlProvider{

    @Override
    Base_SqlProvider getSqlProvider() {
        return this;
    }

    @Override
    SQL getDtSql(Base_Entity base_entity, String orderCol, String orderDir) throws Exception {
        CreditLineMain_Entity creditLineMain_entity = null;
        if (base_entity instanceof CreditLineMain_Entity)
            creditLineMain_entity = (CreditLineMain_Entity)base_entity;
        else {
            throw new Exception("base_entity class type error!");
        }

        CreditLineMain_Entity finalCreditLineMain_entity = creditLineMain_entity;
        return new SQL() {
            {
                SELECT("CUSTOMER_CODE, CREDIT_LINE_NO,LINE_NAME,CREATE_DATE,EXPIRE_DATE,CURRENCY,LIMIT, UTILIZED_AMOUNT,BOOKING_AMOUNT,AVAILABLE_AMOUNT,REVOLVING_IND");
                FROM("CREDIT_LINE_MAIN");
                WHERE("CUSTOMER_CODE = #{customer_code}");
                if (finalCreditLineMain_entity != null) {
                    String credit_line_no = finalCreditLineMain_entity.getCredit_line_no();
                    String line_name = finalCreditLineMain_entity.getLine_name();
                    String create_date = finalCreditLineMain_entity.getCreate_date();
                    String create_date_max = finalCreditLineMain_entity.getCreate_date_max();
                    String expire_date = finalCreditLineMain_entity.getExpire_date();
                    String expire_date_max = finalCreditLineMain_entity.getExpire_date_max();
                    String[] currency_array = finalCreditLineMain_entity.getCurrency_array();
                    BigDecimal limit = finalCreditLineMain_entity.getLimit();
                    BigDecimal limit_max = finalCreditLineMain_entity.getLimit_max();
                    BigDecimal utilized_amount = finalCreditLineMain_entity.getUtilized_amount();
                    BigDecimal utilized_amount_max = finalCreditLineMain_entity.getUtilized_amount_max();
                    BigDecimal booking_amount = finalCreditLineMain_entity.getBooking_amount();
                    BigDecimal booking_amount_max = finalCreditLineMain_entity.getBooking_amount_max();
                    BigDecimal available_amount = finalCreditLineMain_entity.getAvailable_amount();
                    BigDecimal available_amount_max = finalCreditLineMain_entity.getAvailable_amount_max();
                    String[] revolving_ind_array = finalCreditLineMain_entity.getRevolving_ind_array();
                    if (credit_line_no != null && !credit_line_no.equals("")) {
                        String credit_line_no_like = "%" + credit_line_no + "%";
                        WHERE("CREDIT_LINE_NO LIKE '" + credit_line_no_like + "'");
                    }
                    if (line_name != null && !line_name.equals("")) {
                        String line_name_like = "%" + line_name + "%";
                        WHERE("LINE_NAME LIKE '" + line_name_like + "'");
                    }
                    if (create_date != null && !create_date.equals(""))
                        WHERE("CREATE_DATE >= '" + create_date + "'");
                    if (create_date_max != null && !create_date_max.equals(""))
                        WHERE("CREATE_DATE <= '" + create_date_max + "'");
                    if (expire_date != null && !expire_date.equals(""))
                        WHERE("EXPIRE_DATE >= '" + expire_date + "'");
                    if (expire_date_max != null && !expire_date_max.equals(""))
                        WHERE("EXPIRE_DATE <= '" + expire_date_max + "'");
                    if (currency_array != null && currency_array.length > 0) {
                        String whereSql = "CURRENCY IN (";
                        whereSql += getArray(currency_array);
                        whereSql += ")";
                        WHERE(whereSql);
                    }
                    if (limit != null && !limit.equals(""))
                        WHERE("LIMIT >= " + limit);
                    if (limit_max != null && !limit_max.equals(""))
                        WHERE("LIMIT <= " + limit_max);
                    if (utilized_amount != null && !utilized_amount.equals(""))
                        WHERE("UTILIZED_AMOUNT >= " + utilized_amount);
                    if (utilized_amount_max != null && !utilized_amount_max.equals(""))
                        WHERE("UTILIZED_AMOUNT <= " + utilized_amount_max);
                    if (booking_amount != null && !booking_amount.equals(""))
                        WHERE("BOOKING_AMOUNT >= " + booking_amount);
                    if (booking_amount_max != null && !booking_amount_max.equals(""))
                        WHERE("BOOKING_AMOUNT <= " + booking_amount_max);
                    if (available_amount != null && !available_amount.equals(""))
                        WHERE("AVAILABLE_AMOUNT >= " + available_amount);
                    if (available_amount_max != null && !available_amount_max.equals(""))
                        WHERE("AVAILABLE_AMOUNT <= " + available_amount_max);
                    if (revolving_ind_array != null && revolving_ind_array.length > 0) {
                        String whereSql = "REVOLVING_IND IN (";
                        whereSql += getArray(revolving_ind_array);
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

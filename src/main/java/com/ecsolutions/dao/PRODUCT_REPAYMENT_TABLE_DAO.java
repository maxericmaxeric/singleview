package com.ecsolutions.dao;

import com.ecsolutions.dao.sqlProvider.PRODUCT_REPAYMENT_TABLE_Provider;
import com.ecsolutions.entity.PRODUCT_REPAYMENT_TABLE_Entity;
import com.ecsolutions.entity.PRODUCT_TRANSACTION_DETAIL_Entity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017-3-23.
 */
@Repository
public interface PRODUCT_REPAYMENT_TABLE_DAO {
//    @Select("select OPEN_ITEM_NUM,INSTALMENT_NO,BRANCH,START_DATE,DUE_DATE,PAID_DATE,CURRENCY,INSTALMENT_AMOUNT,INTEREST_AMT,OVERDUE_FLAG from repayment")
//    @ResultType(PRODUCT_REPAYMENT_TABLE_Entity.class)
//    List<PRODUCT_REPAYMENT_TABLE_Entity> findRepaymentTable();
@SelectProvider(type = PRODUCT_REPAYMENT_TABLE_Provider.class, method = "getRepaymentSql")
@ResultType(PRODUCT_REPAYMENT_TABLE_Entity.class)
List<PRODUCT_REPAYMENT_TABLE_Entity> findRepaymentDetail(@Param("customer_code") String customer_code,
                                                                      @Param("search") String search,
                                                                      @Param("orderCol") String orderCol,
                                                                      @Param("orderDir") String orderDir);



    @Select("select count(*) from repayment where Customer_Code = #{customer_code}")
    @ResultType(PRODUCT_TRANSACTION_DETAIL_Entity.class)
    Long findDRepaymentTotalCount(@Param("customer_code") String customer_code);

    @Select("select distinct Branch from repayment where Customer_Code = #{customer_code}")
    @ResultType(String.class)
    List<String> findRepaymentBrachByCustCode(@Param("customer_code") String customer_code);

    @Select("select distinct Currency from repayment where Customer_Code = #{customer_code}")
    @ResultType(String.class)
    List<String> findRepaymentCcyByCustCode(@Param("customer_code") String customer_code);

    @Select("select distinct OVERDUE_FLAG from repayment where Customer_Code = #{customer_code}")
    @ResultType(String.class)
    List<String> findRepaymentOverdueFlagByCustCode(@Param("customer_code") String customer_code);
}

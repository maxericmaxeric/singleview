package com.ecsolutions.dao;

import com.ecsolutions.dao.sqlProvider.PRODUCT_TRANSACTION_DETAIL_Provider;
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
public interface PRODUCT_TRANSACTION_DETAIL_DAO {
//    @Select("select Branch,Dep_Serial_No,Transaction_Date,Transaction_Type,Account_No,Currency,DR_Indicator,Transaction_Amount from DEPOSIT_ACCOUNT_TRAN where Customer_Code = #{customer_code}")
//    @ResultType(PRODUCT_TRANSACTION_DETAIL_Entity.class)
//    List<PRODUCT_TRANSACTION_DETAIL_Entity> findTransactionDetailByCustcd(@Param("customer_code") String customer_code);

    @SelectProvider(type = PRODUCT_TRANSACTION_DETAIL_Provider.class, method = "getDpTranSql")
    @ResultType(PRODUCT_TRANSACTION_DETAIL_Entity.class)
    List<PRODUCT_TRANSACTION_DETAIL_Entity> findTransactionDetailByCustcd(@Param("customer_code") String customer_code,
                               @Param("search") String search,
                               @Param("orderCol") String orderCol,
                               @Param("orderDir") String orderDir);



    @Select("select count(*) from DEPOSIT_ACCOUNT_TRAN where Customer_Code = #{customer_code}")
    @ResultType(PRODUCT_TRANSACTION_DETAIL_Entity.class)
    Long findTransactionDetail_TotalByCustCode(@Param("customer_code") String customer_code);

    @Select("select distinct Branch from DEPOSIT_ACCOUNT_TRAN where Customer_Code = #{customer_code}")
    @ResultType(String.class)
    List<String> findTransactionBrachByCustCode(@Param("customer_code") String customer_code);

    @Select("select distinct Transaction_Type from DEPOSIT_ACCOUNT_TRAN where Customer_Code = #{customer_code}")
    @ResultType(String.class)
    List<String> findTransactionTypeByCustCode(@Param("customer_code") String customer_code);

    @Select("select distinct Currency from DEPOSIT_ACCOUNT_TRAN where Customer_Code = #{customer_code}")
    @ResultType(String.class)
    List<String> findTransactionCcyByCustCode(@Param("customer_code") String customer_code);

    @Select("select distinct DR_Indicator from DEPOSIT_ACCOUNT_TRAN where Customer_Code = #{customer_code}")
    @ResultType(String.class)
    List<String> findTransactionDrIndicatorByCustCode(@Param("customer_code") String customer_code);
}

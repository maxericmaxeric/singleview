package com.ecsolutions.dao;

import com.ecsolutions.entity.PRODUCT_REPAYMENT_DELIQUENCY_Entity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017-3-23.
 */
@Repository
public interface PRODUCT_REPAYMENT_DELIQUENCY_DAO {
//    @Select("select tbucket,amount from deliquency where Customer_Code like concat(concat('%',#{customer_code}),'%') and CCY like concat(concat('%',#{ccy}),'%')")
    @Select("select tbucket,amount from deliquency where Customer_Code = '${customer_code}' and CCY = '${ccy}'")
    @ResultType(PRODUCT_REPAYMENT_DELIQUENCY_Entity.class)
    List<PRODUCT_REPAYMENT_DELIQUENCY_Entity> findProductRepaymentDelByCustcdAndCcy(@Param("customer_code") String customer_code,@Param("ccy") String ccy);
}

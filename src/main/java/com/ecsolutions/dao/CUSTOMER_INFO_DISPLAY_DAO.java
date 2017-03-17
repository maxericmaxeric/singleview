package com.ecsolutions.dao;

import com.ecsolutions.entity.CUSTOMER_INFO_DISPLAY_Entity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017-3-17.
 */
@Repository
public interface CUSTOMER_INFO_DISPLAY_DAO {
    @Select("select c.Customer_Full_Name,c.Customer_Code,c.Relationship_Level,c.Credit_Rating,ROUND(sum(Account_Balance_LCY),2) ACCOUNT_BALANCE_LCY_SUM,ROUND(sum(Balance_LCY),2) balance_lcy_sum,ROUND(sum(Available_Amount_LCY),2) available_amount_lcy_sum from CUSTOMER_INFO_MAIN c left join DEPOSIT_ACCOUNT_INFO d on c.Customer_Code=d.Customer_Code left join  LOAN_ACCOUNT_INFO l on l.Customer_Code=c.Customer_Code left join CREDIT_LINE_MAIN cl on cl.Customer_Code=c.Customer_Code where c.Customer_Code=#{customer_code} group by c.Customer_Full_Name,c.Customer_Code,c.Relationship_Level,c.Credit_Rating")
    @ResultType(CUSTOMER_INFO_DISPLAY_Entity.class)
    List<CUSTOMER_INFO_DISPLAY_Entity> find_customer_info(@Param("customer_code") String customer_code);


}

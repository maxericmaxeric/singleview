package com.ecsolutions.dao;

import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017-3-23.
 */
@Repository
public interface PRODUCT_REPAYMENT_TIMEOVERDUE_DAO {
    @Select("select count(*) from sti05m00 where ovdsts = 1 and (to_date(to_char(sysdate,'yyyy/mm/dd'),'yyyy/mm/dd') - (to_date(duedate,'yyyymmdd') )<365)")
    @ResultType(Integer.class)
    int findProductRepaymentTimeoverdueCount();
}

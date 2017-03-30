package com.ecsolutions.dao;

import com.ecsolutions.entity.CustomerGroup_Entity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/3/30.
 */
@Repository
public interface CustomerGroup_DAO {
    @Select("SELECT CUSTCOD, PRTYNOP，PRTYNM\n" +
            "  FROM (SELECT C14.*, B.TOP\n" +
            "          FROM (SELECT * FROM CUSTOMER_GROUP WHERE TRIM(PRTYNOP) IS NOT NULL) C14,\n" +
            "               (SELECT A.CUSTCOD TOP\n" +
            "                FROM (SELECT *\n" +
            "                          FROM CUSTOMER_GROUP\n" +
            "                         START WITH TRIM(CUSTCOD) = TRIM(#{customer_code})\n" +
            "                        CONNECT BY PRIOR PRTYNOP = CUSTCOD) A\n" +
            "                 WHERE TRIM(A.PRTYNOP) = '0') B)\n" +
            " START WITH PRTYNOP = TOP\n" +
            "CONNECT BY PRIOR CUSTCOD = PRTYNOP\n" +
            "UNION\n" +
            "SELECT A.CUSTCOD ,A.PRTYNOP, A.PRTYNM\n" +
            "                  FROM (SELECT *\n" +
            "                          FROM CUSTOMER_GROUP\n" +
            "                         START WITH TRIM(CUSTCOD) = TRIM(#{customer_code})\n" +
            "                        CONNECT BY PRIOR PRTYNOP = CUSTCOD) A\n" +
            "                 WHERE TRIM(A.PRTYNOP) = '0'")
    @ResultType(CustomerGroup_Entity.class)
    List<CustomerGroup_Entity> findCustomerGroupByCustCode(@Param("customer_code") String customer_code);
}

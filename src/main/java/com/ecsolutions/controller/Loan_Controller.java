package com.ecsolutions.controller;

import com.ecsolutions.entity.*;
import com.ecsolutions.service.Loan_Service;
import com.ecsolutions.util.DatatableUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2017/3/22.
 */
@RestController
@RequestMapping("/Loan")
public class Loan_Controller {
    @Autowired
    private Loan_Service loan_service;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/getLoan_Ccy_SumByCustCode")
    public List<DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_Entity> getLoan_Ccy_SumByCustCode(@RequestParam(value="customer_code", defaultValue = "", required = true) String customer_code) {
        List<DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_Entity>  deposit_account_type_balance_lcy_sum_entities = loan_service.findLoan_Ccy_SumByCustCode(customer_code);
        return deposit_account_type_balance_lcy_sum_entities;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/getLoan_Type_SumByCustCode_CCY")
    public List<DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_Entity> getLoan_Type_SumByCustCode_CCY(@RequestParam(value="customer_code", defaultValue = "", required = true) String customer_code, @RequestParam(value="currency", defaultValue = "", required = true) String currency) {
        List<DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_Entity>  deposit_account_type_balance_lcy_sum_entities = loan_service.findLoan_Type_SumByCustCode_CCY(customer_code, currency);
        return deposit_account_type_balance_lcy_sum_entities;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/getLoanByCustCode")
    public List<Loan_Entity> getLoanByCustCode(@RequestParam(value = "customer_code", defaultValue = "", required = true) String customer_code,
                                                @RequestParam(value="page[Num]") Integer pageNum,
                                                @RequestParam(value="pageSize") Integer pageSize) {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        List<Loan_Entity> loan_entities = loan_service.findLoanByCustCode(customer_code);
        return loan_entities;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.POST, value = "/getTest", consumes="application/json", produces = "application/json")
    @ResponseBody
    public Test_Entity getTest(@RequestBody Test_Entity test) {
        return test;
    }

/*   @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/getTest2")
    public String getTest(@ModelAttribute JDTRequest_Entity req) {
        return req.getColumns().get(0).get("data");
    }*/

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/getLoanInfo")
    public DatatableResponse_Entity getLoanInfo(@RequestParam(value = "draw", required = true) Integer draw,
                                                @RequestParam(value = "start", required = true) Integer start,
                                                @RequestParam(value = "length", required = true) Integer length,
                                                @RequestParam(value = "orderCol", required = true) String orderCol,
                                                @RequestParam(value = "orderDir", required = true) String orderDir,
                                                @RequestParam(value = "search", required = true) String search,
                                                @RequestParam(value = "customer_code", required = true) String customer_code) {
        DatatableResponse_Entity datatableResponse_entity = new DatatableResponse_Entity();
        datatableResponse_entity.setDraw(draw);
        try {
            Long recordsTotal = this.loan_service.findLoan_TotalByCustCode(customer_code);
            datatableResponse_entity.setRecordsTotal(recordsTotal);

            Integer pageNum = start / length + 1;
            Integer pageSize = length;
            PageHelper.startPage(pageNum, pageSize);
            List<Loan_Entity> loan_entities = loan_service.findLoan(customer_code, search, orderCol, orderDir);
            PageInfo<Loan_Entity> pageInfo=new PageInfo<Loan_Entity>(loan_entities);
            datatableResponse_entity.setRecordsFiltered(pageInfo.getTotal());
            List<List<Object>> data = DatatableUtil.convertToArrayList(loan_entities);
            datatableResponse_entity.setData(data);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return datatableResponse_entity;
    }
}
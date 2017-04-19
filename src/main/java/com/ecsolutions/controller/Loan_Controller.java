package com.ecsolutions.controller;

import com.ecsolutions.entity.DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_Entity;
import com.ecsolutions.entity.DatatableResponse_Entity;
import com.ecsolutions.entity.Loan_Entity;
import com.ecsolutions.service.Loan_Service;
import com.github.pagehelper.PageHelper;
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

    public Loan_Service getLoan_service() {
        return loan_service;
    }

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
        DatatableResponse_Entity datatableResponse_entity = new DatatableResponse_Entity(this, draw,start,length,orderCol,orderDir,search,customer_code);
        return datatableResponse_entity;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/getLoan_BranchByCustCode/{customer_code}")
    public List<String> getLoan_BranchByCustCode(@PathVariable("customer_code") String customer_code) {
        List<String> ret = this.loan_service.findLoan_BranchByCustCode(customer_code);
        return ret;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/getLoan_TypeByCustCode/{customer_code}")
    public List<String> getLoan_TypeByCustCode(@PathVariable("customer_code") String customer_code) {
        List<String> ret = this.loan_service.findLoan_TypeByCustCode(customer_code);
        return ret;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/getLoan_PrinCCYByCustCode/{customer_code}")
    public List<String> getLoan_PrinCCYByCustCode(@PathVariable("customer_code") String customer_code) {
        List<String> ret = this.loan_service.findLoan_PrinCCYByCustCode(customer_code);
        return ret;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/getLoan_BalCCYByCustCode/{customer_code}")
    public List<String> getLoan_BalCCYByCustCode(@PathVariable("customer_code") String customer_code) {
        List<String> ret = this.loan_service.findLoan_BalCCYByCustCode(customer_code);
        return ret;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/getLoan_AccStatusByCustCode/{customer_code}")
    public List<String> getLoan_AccStatusByCustCode(@PathVariable("customer_code") String customer_code) {
        List<String> ret = this.loan_service.findLoan_AccStatusByCustCode(customer_code);
        return ret;
    }
}

package com.ecsolutions.controller;

import com.ecsolutions.entity.DEPOSIT_INFO_SEARCH_Entity;
import com.ecsolutions.service.DEPOSIT_INFO_SEARCH_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2017-3-16.
 */
@RestController
@RequestMapping("/DEPOSIT_INFO_SEARCH")
public class DEPOSIT_INFO_SEARCH_Controller {
    @Autowired
    private DEPOSIT_INFO_SEARCH_Service dEPOSIT_INFO_SEARCH_Service;
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/getSearchResult")
  //public List<DEPOSIT_INFO_SEARCH_Entity> getDEPOSIT_INFO_SEARCH(@PathVariable("dp_account_no") String DP_ACCOUNT_NO,@PathVariable("ln_account_no") String LN_Account_No,@PathVariable("customer_code") String Customer_Code,@PathVariable("customer_full_name") String Customer_Full_Name,@PathVariable("identity_no") String Identity_No){
    //public List<DEPOSIT_INFO_SEARCH_Entity> getDEPOSIT_INFO_SEARCH(@RequestBody DEPOSIT_INFO_SEARCH_Entity deposit_info_search_entity){
    public List<DEPOSIT_INFO_SEARCH_Entity> getDEPOSIT_INFO_SEARCH(@RequestParam(value="dp_account_no", defaultValue = "", required = false) String dp_account_no,
                                                                   @RequestParam(value="ln_account_no", defaultValue = "", required = false) String ln_account_no,
                                                                   @RequestParam(value="customer_code", defaultValue = "", required = false) String customer_code,
                                                                   @RequestParam(value="customer_full_name", defaultValue = "", required = false) String customer_full_name,
                                                                   @RequestParam(value="identity_no", defaultValue = "", required = false) String identity_no){
                                                                   //@RequestParam(value="pageNum") Integer pageNum,
                                                                   //@RequestParam(value="pageSize") Integer pageSize){
       // pageNum = pageNum == null ? 1 : pageNum;
       // pageSize = pageSize == null ? 10 : pageSize;
       // PageHelper.startPage(pageNum, pageSize);
        List<DEPOSIT_INFO_SEARCH_Entity> dEPOSIT_INFO_SEARCH_Entity = dEPOSIT_INFO_SEARCH_Service.searchInfoByCustCode(dp_account_no,ln_account_no,customer_code,customer_full_name,identity_no );
       // Page page = (Page) dEPOSIT_INFO_SEARCH_Entity;
       // List<DEPOSIT_INFO_SEARCH_Entity> dEPOSIT_INFO_SEARCH_Entitys = dEPOSIT_INFO_SEARCH_Service.findTutorByNameAndEmailSql(deposit_info_search_entity.getDp_account_no(),deposit_info_search_entity.getLn_account_no(),deposit_info_search_entity.getCustomer_code(),deposit_info_search_entity.getCustomer_full_name(),deposit_info_search_entity.getIdentity_no() );
       //     return page;
        return dEPOSIT_INFO_SEARCH_Entity;
    }

}

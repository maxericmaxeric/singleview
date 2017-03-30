package com.ecsolutions.entity;

import com.ecsolutions.controller.DEPOSIT_ACCOUNT_INFO_Controller;
import com.ecsolutions.controller.Loan_Controller;
import com.ecsolutions.controller.PRODUCT_REPAYMENT_TABLE_Controller;
import com.ecsolutions.controller.PRODUCT_TRANSACTION_DETAIL_Controller;
import com.ecsolutions.util.Converter;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by Administrator on 2017/3/27.
 */
public class DatatableResponse_Entity {
    private Integer draw;
    private long recordsTotal;
    private long recordsFiltered;
    private List<List<Object>> data;

    public DatatableResponse_Entity() {
    }

    public DatatableResponse_Entity(Object object, Integer draw, Integer start, Integer length, String orderCol, String orderDir, String search, String customer_code) {
        this.setDraw(draw);
        try {
            Long recordsTotal = null;
            Integer pageNum = start / length + 1;
            Integer pageSize = length;
            List<? extends Base_Entity> base_entities = null;
            PageInfo<? extends Base_Entity> pageInfo = null;
            if (object instanceof Loan_Controller) {
                Loan_Controller loan_controller = (Loan_Controller)object;
                recordsTotal = loan_controller.getLoan_service().findLoan_TotalByCustCode(customer_code);
                PageHelper.startPage(pageNum, pageSize);
                base_entities = loan_controller.getLoan_service().findLoan(customer_code, search, orderCol, orderDir);
                pageInfo= new PageInfo<Loan_Entity>((List<Loan_Entity>) base_entities);
            } else if (object instanceof DEPOSIT_ACCOUNT_INFO_Controller) {
                DEPOSIT_ACCOUNT_INFO_Controller deposit_account_info_controller = (DEPOSIT_ACCOUNT_INFO_Controller)object;
                recordsTotal = deposit_account_info_controller.getDeposit_account_info_service().findDeposit_TotalByCustCode(customer_code);
                PageHelper.startPage(pageNum, pageSize);
                base_entities = deposit_account_info_controller.getDeposit_account_info_service().findDeposit(customer_code, search, orderCol, orderDir);
                pageInfo= new PageInfo<DEPOSIT_ACCOUNT_INFO_Entity>((List<DEPOSIT_ACCOUNT_INFO_Entity>) base_entities);
            }
            else if (object instanceof PRODUCT_TRANSACTION_DETAIL_Controller) {
                PRODUCT_TRANSACTION_DETAIL_Controller product_transaction_detail_controller = (PRODUCT_TRANSACTION_DETAIL_Controller)object;
                recordsTotal = product_transaction_detail_controller.getPRODUCT_TRANSACTION_DETAIL_Service().findTransactionDetail_TotalByCustCode(customer_code);
                PageHelper.startPage(pageNum, pageSize);
                base_entities = product_transaction_detail_controller.getPRODUCT_TRANSACTION_DETAIL_Service().findTransactionDetailByCustcd(customer_code,search,orderCol,orderDir);
                pageInfo= new PageInfo<PRODUCT_TRANSACTION_DETAIL_Entity>((List<PRODUCT_TRANSACTION_DETAIL_Entity>) base_entities);
            }
            else if (object instanceof PRODUCT_REPAYMENT_TABLE_Controller) {
                PRODUCT_REPAYMENT_TABLE_Controller product_repayment_table_controller = (PRODUCT_REPAYMENT_TABLE_Controller)object;
                recordsTotal = product_repayment_table_controller.getPRODUCT_REPAYMENT_TABLE_Service().findDRepaymentTotalCount(customer_code);
                PageHelper.startPage(pageNum, pageSize);
                base_entities = product_repayment_table_controller.getPRODUCT_REPAYMENT_TABLE_Service().findRepaymentDetail(customer_code,search,orderCol,orderDir);
                pageInfo= new PageInfo<PRODUCT_REPAYMENT_TABLE_Entity>((List<PRODUCT_REPAYMENT_TABLE_Entity>) base_entities);
            }


            this.setRecordsTotal(recordsTotal);
            this.setRecordsFiltered(pageInfo.getTotal());
            List<List<Object>> data = Converter.convertToArrayList((List<Base_Entity>) base_entities);
            this.setData(data);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List<List<Object>> getData() {
        return data;
    }

    public void setData(List<List<Object>> data) {
        this.data = data;
    }

}

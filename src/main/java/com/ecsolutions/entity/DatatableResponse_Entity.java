package com.ecsolutions.entity;

import com.ecsolutions.controller.*;
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
            } else if (object instanceof RelatedParty_Controller) {
                RelatedParty_Controller relatedParty_controller = (RelatedParty_Controller)object;
                recordsTotal = relatedParty_controller.getRelatedParty_service().findRelatedParty_TotalByCustCode(customer_code);
                PageHelper.startPage(pageNum, pageSize);
                base_entities = relatedParty_controller.getRelatedParty_service().findRelatedParty(customer_code,search,orderCol,orderDir);
                pageInfo= new PageInfo<RelatedParty_Entity>((List<RelatedParty_Entity>) base_entities);
            }
            else if (object instanceof PRODUCT_REPAYMENT_TABLE_Controller) {
                PRODUCT_REPAYMENT_TABLE_Controller product_repayment_table_controller = (PRODUCT_REPAYMENT_TABLE_Controller)object;
                recordsTotal = product_repayment_table_controller.getPRODUCT_REPAYMENT_TABLE_Service().findDRepaymentTotalCount(customer_code);
                PageHelper.startPage(pageNum, pageSize);
                base_entities = product_repayment_table_controller.getPRODUCT_REPAYMENT_TABLE_Service().findRepaymentDetail(customer_code,search,orderCol,orderDir);
                pageInfo= new PageInfo<PRODUCT_REPAYMENT_TABLE_Entity>((List<PRODUCT_REPAYMENT_TABLE_Entity>) base_entities);
            } else if (object instanceof BackgroundCheck_Controller) {
                BackgroundCheck_Controller backgroundCheck_controller = (BackgroundCheck_Controller)object;
                recordsTotal = backgroundCheck_controller.getBackgroundCheck_service().findBackgroundCheck_TotalByCustCode(customer_code);
                PageHelper.startPage(pageNum, pageSize);
                base_entities = backgroundCheck_controller.getBackgroundCheck_service().findBackgroundCheck(customer_code,search,orderCol,orderDir);
                pageInfo= new PageInfo<BackgroundCheck_Entity>((List<BackgroundCheck_Entity>)base_entities);
            } else if (object instanceof CreditLineMain_Controller) {
                CreditLineMain_Controller creditLineMain_controller = (CreditLineMain_Controller)object;
                recordsTotal = creditLineMain_controller.getCreditLineMain_service().findCreditLineMain_TotalByCustCode(customer_code);
                PageHelper.startPage(pageNum, pageSize);
                base_entities = creditLineMain_controller.getCreditLineMain_service().findCreditLineMain(customer_code,search,orderCol,orderDir);
                pageInfo= new PageInfo<CreditLineMain_Entity>((List<CreditLineMain_Entity>) base_entities);
            } else if (object instanceof CollateralMain_Controller) {
                CollateralMain_Controller collateralMain_controller = (CollateralMain_Controller)object;
                recordsTotal = collateralMain_controller.getCollateralMain_service().findCollateralMain_TotalByCustCode(customer_code);
                PageHelper.startPage(pageNum, pageSize);
                base_entities = collateralMain_controller.getCollateralMain_service().findCollateralMain(customer_code,search,orderCol,orderDir);
                pageInfo= new PageInfo<CollateralMain_Entity>((List<CollateralMain_Entity>) base_entities);
            }
              else if (object instanceof PRICING_PREFERENTIAL_FEES_Controller) {
                PRICING_PREFERENTIAL_FEES_Controller pricing_preferential_fees_controller = (PRICING_PREFERENTIAL_FEES_Controller)object;
                recordsTotal = pricing_preferential_fees_controller.getpRICING_PREFERENTIAL_FEES_Service().findPreferentialFeesTotalByCustd(customer_code);
                PageHelper.startPage(pageNum, pageSize);
                base_entities = pricing_preferential_fees_controller.getpRICING_PREFERENTIAL_FEES_Service().findPreferentialFeesByCustd(customer_code,search,orderCol,orderDir);
                pageInfo= new PageInfo<PRICING_PREFERENTIAL_FEES_Entity>((List<PRICING_PREFERENTIAL_FEES_Entity>) base_entities);
            }
              else if (object instanceof PRICING_PREFERENTIAL_FX_RATE_Controller) {
                PRICING_PREFERENTIAL_FX_RATE_Controller pricing_preferential_fx_rate_controller = (PRICING_PREFERENTIAL_FX_RATE_Controller)object;
                recordsTotal = pricing_preferential_fx_rate_controller.getpRICING_PREFERENTIAL_FX_RATE_Service().findPreferentialFxTotalByCustd(customer_code);
                PageHelper.startPage(pageNum, pageSize);
                base_entities = pricing_preferential_fx_rate_controller.getpRICING_PREFERENTIAL_FX_RATE_Service().findPreferentialFxRateByCustd(customer_code, search, orderCol, orderDir);
                pageInfo= new PageInfo<PRICING_PREFERENTIAL_FX_RATE_Entity>((List<PRICING_PREFERENTIAL_FX_RATE_Entity>) base_entities);
            }
            else if (object instanceof PRICING_PREFERENTIAL_INTEREST_RATE_Controller) {
                PRICING_PREFERENTIAL_INTEREST_RATE_Controller pricing_preferential_interest_rate_controller = (PRICING_PREFERENTIAL_INTEREST_RATE_Controller)object;
                recordsTotal = pricing_preferential_interest_rate_controller.getPricing_Preferential_Interest_Rate_Service().findPreferentialIRTotalByCustd(customer_code);
                PageHelper.startPage(pageNum, pageSize);
                base_entities =pricing_preferential_interest_rate_controller.getPricing_Preferential_Interest_Rate_Service().findPreferentialInterestRateByCustd(customer_code, search, orderCol, orderDir);
                pageInfo= new PageInfo<PRICING_PREFERENTIAL_INTEREST_RATE_Entity>((List<PRICING_PREFERENTIAL_INTEREST_RATE_Entity>) base_entities);
            }
            else if (object instanceof PRICING_PRODUCT_INSTRUCTION_Controller) {
                PRICING_PRODUCT_INSTRUCTION_Controller pricing_product_instruction_controller = (PRICING_PRODUCT_INSTRUCTION_Controller)object;
                recordsTotal = pricing_product_instruction_controller.getPricing_Product_Instruction_Service().findPITotalByCustd(customer_code);
                PageHelper.startPage(pageNum, pageSize);
                base_entities =pricing_product_instruction_controller.getPricing_Product_Instruction_Service().findProductInstructionByCustd(customer_code, search, orderCol, orderDir);
                pageInfo= new PageInfo<PRICING_PRODUCT_INSTRUCTION_Entity>((List<PRICING_PRODUCT_INSTRUCTION_Entity>) base_entities);
            }
            else if (object instanceof PRICING_STANDING_INSTRUCTION_Controller) {
                PRICING_STANDING_INSTRUCTION_Controller pricing_standing_instruction_controller = (PRICING_STANDING_INSTRUCTION_Controller)object;
                recordsTotal = pricing_standing_instruction_controller.getPricing_Standing_Instruction_Service().findSITotalByCustd(customer_code);
                PageHelper.startPage(pageNum, pageSize);
                base_entities =pricing_standing_instruction_controller.getPricing_Standing_Instruction_Service().findStandingInstructionByCustd(customer_code, search, orderCol, orderDir);
                pageInfo= new PageInfo<PRICING_STANDING_INSTRUCTION_Entity>((List<PRICING_STANDING_INSTRUCTION_Entity>) base_entities);
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

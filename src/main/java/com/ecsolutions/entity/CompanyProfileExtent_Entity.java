package com.ecsolutions.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by Administrator on 2017/3/30.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompanyProfileExtent_Entity {

    private String Industry_Code_Head_Office;
    private String Industry_Code_Regulatory;
    private String Sales_Vol;
    private String Market_Share;
    private String Product_Array;
    private String Reputation;
    private String Network;
    private String Threats_Challenges;
    private String Success_Factors;
    private String Potential_Gap;

    private String Parent_Subsidiary_Type;
    private String Registration_Type;
    private String Registration_No;
    private String Registration_Date;
    private String Business_License_Exp_Date;
    private String Org_Code;
    private String Legal_Rep;
    private String Business_Area;
    private String Tax_No_National;
    private String Tax_No_Local;
    private String Registered_Capital;
    private String Listed_Company_Status;
    private String Stock_Exchange;
    private String Stock_Ticker;

    public String getIndustry_Code_Head_Office() {
        return Industry_Code_Head_Office;
    }

    public void setIndustry_Code_Head_Office(String industry_Code_Head_Office) {
        Industry_Code_Head_Office = industry_Code_Head_Office;
    }

    public String getIndustry_Code_Regulatory() {
        return Industry_Code_Regulatory;
    }

    public void setIndustry_Code_Regulatory(String industry_Code_Regulatory) {
        Industry_Code_Regulatory = industry_Code_Regulatory;
    }

    public String getSales_Vol() {
        return Sales_Vol;
    }

    public void setSales_Vol(String sales_Vol) {
        Sales_Vol = sales_Vol;
    }

    public String getMarket_Share() {
        return Market_Share;
    }

    public void setMarket_Share(String market_Share) {
        Market_Share = market_Share;
    }

    public String getProduct_Array() {
        return Product_Array;
    }

    public void setProduct_Array(String product_Array) {
        Product_Array = product_Array;
    }

    public String getReputation() {
        return Reputation;
    }

    public void setReputation(String reputation) {
        Reputation = reputation;
    }

    public String getNetwork() {
        return Network;
    }

    public void setNetwork(String network) {
        Network = network;
    }

    public String getThreats_Challenges() {
        return Threats_Challenges;
    }

    public void setThreats_Challenges(String threats_Challenges) {
        Threats_Challenges = threats_Challenges;
    }

    public String getSuccess_Factors() {
        return Success_Factors;
    }

    public void setSuccess_Factors(String success_Factors) {
        Success_Factors = success_Factors;
    }

    public String getPotential_Gap() {
        return Potential_Gap;
    }

    public void setPotential_Gap(String potential_Gap) {
        Potential_Gap = potential_Gap;
    }

    public String getParent_Subsidiary_Type() {
        return Parent_Subsidiary_Type;
    }

    public void setParent_Subsidiary_Type(String parent_Subsidiary_Type) {
        Parent_Subsidiary_Type = parent_Subsidiary_Type;
    }

    public String getRegistration_Type() {
        return Registration_Type;
    }

    public void setRegistration_Type(String registration_Type) {
        Registration_Type = registration_Type;
    }

    public String getRegistration_No() {
        return Registration_No;
    }

    public void setRegistration_No(String registration_No) {
        Registration_No = registration_No;
    }

    public String getRegistration_Date() {
        return Registration_Date;
    }

    public void setRegistration_Date(String registration_Date) {
        Registration_Date = registration_Date;
    }

    public String getBusiness_License_Exp_Date() {
        return Business_License_Exp_Date;
    }

    public void setBusiness_License_Exp_Date(String business_License_Exp_Date) {
        Business_License_Exp_Date = business_License_Exp_Date;
    }

    public String getOrg_Code() {
        return Org_Code;
    }

    public void setOrg_Code(String org_Code) {
        Org_Code = org_Code;
    }

    public String getLegal_Rep() {
        return Legal_Rep;
    }

    public void setLegal_Rep(String legal_Rep) {
        Legal_Rep = legal_Rep;
    }

    public String getBusiness_Area() {
        return Business_Area;
    }

    public void setBusiness_Area(String business_Area) {
        Business_Area = business_Area;
    }

    public String getTax_No_National() {
        return Tax_No_National;
    }

    public void setTax_No_National(String tax_No_National) {
        Tax_No_National = tax_No_National;
    }

    public String getTax_No_Local() {
        return Tax_No_Local;
    }

    public void setTax_No_Local(String tax_No_Local) {
        Tax_No_Local = tax_No_Local;
    }

    public String getRegistered_Capital() {
        return Registered_Capital;
    }

    public void setRegistered_Capital(String registered_Capital) {
        Registered_Capital = registered_Capital;
    }

    public String getListed_Company_Status() {
        return Listed_Company_Status;
    }

    public void setListed_Company_Status(String listed_Company_Status) {
        Listed_Company_Status = listed_Company_Status;
    }

    public String getStock_Exchange() {
        return Stock_Exchange;
    }

    public void setStock_Exchange(String stock_Exchange) {
        Stock_Exchange = stock_Exchange;
    }

    public String getStock_Ticker() {
        return Stock_Ticker;
    }

    public void setStock_Ticker(String stock_Ticker) {
        Stock_Ticker = stock_Ticker;
    }
}

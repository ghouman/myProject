package org.mybatis.weigao.domain;

import org.apache.log4j.Logger;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: ghm
 * Date: 13-11-16
 * Time: 下午3:12
 * To change this template use File | Settings | File Templates.
 */
public class CustomerSurvey implements Serializable {

    private static Logger logger = Logger.getLogger (CustomerSurvey.class);
    private static final long serialVersionUID = 1L;
    private int id;
    private int uid;
    private int select;
    private int disable;
    private String creator;
    private String creationDate;
    private String operator;
    private String operDate;
    private String surveyNo;//调研编号
    private String surveyDate; //调研起始日期
    private String surveyEndDate; //调研结束日期
    private String preparer;//填表人员
    private String preparerDate;
    private String checked;//是否提交
    private String checker;
    private String checkDate;
    private String submit;//是否初审
    private String submitUser;
    private String submitDate;
    private String verify;//是否复审
    private String verifier;
    private String verifyDate;
    private String Z9Final;
    private String Z9FinalUser;
    private String Z9FinalDate;
    private String customer;
    private int customerId;
    private Integer doctor; //医生人数
    private Integer nurse;
    private Integer engineer;
    private String chospitalMemo; //医院信息
    private String hospitalMemo; //调研备注
    private Integer hdfMachine;   //  现有血透机数
    private Integer hdfCapacity;   //  血透室空间可容纳最大床位数
    private Integer waterTreatment;    //现有水处理可带最大床位数
    private Integer hospitalSurgical;  //  医院手术量（例/年）
    private Integer renalClinic;   // 肾内科门诊量（人次/年）
    private String hd;
    private Integer hf;  //  血液滤过
    private Integer hdf; // 血液透析滤过
    private Integer crrt; //  CRRT
    private Integer hp;   //  血液灌流
    private Integer remedyMothly; //   月治疗次数
    private String channelDYMO;  //  耗材产品销售渠道：直销，分销
    private String channelDevice; //   设备销售产品渠道：直销，分销
    private Boolean ynProduct;//  是否存在产品投放
    private Integer productPeriod;  // 目前投放产品合作周期
    private Boolean ynPlan; //  目前是否有投放计划
    private String planDialys;// 计划投放透析机数量
    private Integer hdfF1; // 透析患者数
    private Integer nepdF1; //  腹透患者数
    private Integer hdfF2;   // 月透析人次
    private Integer nepdF2;  //  月腹透人次
    private Integer hdfF3;  //   最长透析龄
    private Integer nepdF3;  //   最长腹透龄
    private String feedback; //   客户评判：战略/重要/一般
    private String fbNote;  //    评判说明

    private String zect;
    private String port;
    private String province;
    private String clerk;
    private String salesRegion;
    private String labOffice;//所属科室
    private String labTel;
    private String customerName;

    private String coopType;
    private String address;
    private String website;
    private String healthClass;
    private String hierarchy;
    private String coop_DT;
    private String postalCode;
    private String custVal;

    private int fromIndex = 0;
    private int toIndex = 15;

    private String manager; //大区经理

    private String managerEng; //客服部

    private String preparerManager;//区域主管

    private String submitMemo;
    private String verifyMemo;
    private String returnCheck;

    public String getChospitalMemo() {
        return chospitalMemo;
    }

    public void setChospitalMemo(String chospitalMemo) {
        this.chospitalMemo = chospitalMemo;
    }

    public String getSurveyEndDate() {
        return surveyEndDate;
    }

    public void setSurveyEndDate(String surveyEndDate) {
        this.surveyEndDate = surveyEndDate;
    }

    public String getPreparerManager() {
        return preparerManager;
    }

    public void setPreparerManager(String preparerManager) {
        this.preparerManager = preparerManager;
    }

    public String getCustVal() {
        return custVal;
    }

    public void setCustVal(String custVal) {
        this.custVal = custVal;
    }

    public String getCoopType() {
        return coopType;
    }

    public void setCoopType(String coopType) {
        this.coopType = coopType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getHealthClass() {
        return healthClass;
    }

    public void setHealthClass(String healthClass) {
        this.healthClass = healthClass;
    }

    public String getHierarchy() {
        return hierarchy;
    }

    public void setHierarchy(String hierarchy) {
        this.hierarchy = hierarchy;
    }

    public String getCoop_DT() {
        return coop_DT;
    }

    public void setCoop_DT(String coop_DT) {
        this.coop_DT = coop_DT;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getReturnCheck() {
        return returnCheck;
    }

    public void setReturnCheck(String returnCheck) {
        this.returnCheck = returnCheck;
    }

    public String getSubmitMemo() {
        return submitMemo;
    }

    public void setSubmitMemo(String submitMemo) {
        this.submitMemo = submitMemo;
    }

    public String getVerifyMemo() {
        return verifyMemo;
    }

    public void setVerifyMemo(String verifyMemo) {
        this.verifyMemo = verifyMemo;
    }

    private String jsonString;

    public String getManagerEng() {
        return managerEng;
    }

    public void setManagerEng(String managerEng) {
        this.managerEng = managerEng;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getJsonString() {
        return jsonString;
    }

    public void setJsonString(String jsonString) {
        this.jsonString = jsonString;
    }

    public int getFromIndex() {
        return fromIndex;
    }

    public void setFromIndex(int fromIndex) {
        this.fromIndex = fromIndex;
    }

    public int getToIndex() {
        return toIndex;
    }

    public void setToIndex(int toIndex) {
        this.toIndex = toIndex;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getSelect() {
        return select;
    }

    public void setSelect(int select) {
        this.select = select;
    }

    public int getDisable() {
        return disable;
    }

    public void setDisable(int disable) {
        this.disable = disable;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }

    public String getSubmit() {
        return submit;
    }

    public void setSubmit(String submit) {
        this.submit = submit;
    }

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
    }

    public String getPreparer() {
        return preparer;
    }

    public void setPreparer(String preparer) {
        this.preparer = preparer;
    }

    public String getSurveyDate() {
        if(surveyDate==null||"".equals(surveyDate)){
            return surveyDate;
        }
        try{
            surveyDate = surveyDate.substring(0,10);
        }   catch (Exception e){
            logger.error("surveyDate:"+surveyDate+"   |surveyDate格式有误，解析错误："+e);
        }
        return  surveyDate;
    }

    public void setSurveyDate(String surveyDate) {
        this.surveyDate = surveyDate;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getZect() {
        return zect;
    }

    public void setZect(String zect) {
        this.zect = zect;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getClerk() {
        return clerk;
    }

    public void setClerk(String clerk) {
        this.clerk = clerk;
    }

    public String getSalesRegion() {
        return salesRegion;
    }

    public void setSalesRegion(String salesRegion) {
        this.salesRegion = salesRegion;
    }

    public String getSurveyNo() {

        return surveyNo;
    }

    public void setSurveyNo(String surveyNo) {
        this.surveyNo = surveyNo;
    }

    public String getLabOffice() {
        return labOffice;
    }

    public void setLabOffice(String labOffice) {
        this.labOffice = labOffice;
    }

    public String getLabTel() {
        return labTel;
    }

    public void setLabTel(String labTel) {
        this.labTel = labTel;
    }

    public Integer getDoctor() {
        return doctor;
    }

    public void setDoctor(Integer doctor) {
        this.doctor = doctor;
    }

    public Integer getNurse() {
        return nurse;
    }

    public void setNurse(Integer nurse) {
        this.nurse = nurse;
    }

    public Integer getEngineer() {
        return engineer;
    }

    public void setEngineer(Integer engineer) {
        this.engineer = engineer;
    }

    public String getHospitalMemo() {
        return hospitalMemo;
    }

    public void setHospitalMemo(String hospitalMemo) {
        this.hospitalMemo = hospitalMemo;
    }

    public Integer getHdfMachine() {
        return hdfMachine;
    }

    public void setHdfMachine(Integer hdfMachine) {
        this.hdfMachine = hdfMachine;
    }

    public Integer getHdfCapacity() {
        return hdfCapacity;
    }

    public void setHdfCapacity(Integer hdfCapacity) {
        this.hdfCapacity = hdfCapacity;
    }

    public Integer getWaterTreatment() {
        return waterTreatment;
    }

    public void setWaterTreatment(Integer waterTreatment) {
        this.waterTreatment = waterTreatment;
    }

    public Integer getHospitalSurgical() {
        return hospitalSurgical;
    }

    public void setHospitalSurgical(Integer hospitalSurgical) {
        this.hospitalSurgical = hospitalSurgical;
    }

    public Integer getRenalClinic() {
        return renalClinic;
    }

    public void setRenalClinic(Integer renalClinic) {
        this.renalClinic = renalClinic;
    }

    public Integer getHf() {
        return hf;
    }

    public void setHf(Integer hf) {
        this.hf = hf;
    }

    public Integer getHdf() {
        return hdf;
    }

    public void setHdf(Integer hdf) {
        this.hdf = hdf;
    }

    public Integer getCrrt() {
        return crrt;
    }

    public void setCrrt(Integer crrt) {
        this.crrt = crrt;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getRemedyMothly() {
        return remedyMothly;
    }

    public void setRemedyMothly(Integer remedyMothly) {
        this.remedyMothly = remedyMothly;
    }

    public String getChannelDYMO() {
        return channelDYMO;
    }

    public void setChannelDYMO(String channelDYMO) {
        this.channelDYMO = channelDYMO;
    }

    public String getChannelDevice() {
        return channelDevice;
    }

    public void setChannelDevice(String channelDevice) {
        this.channelDevice = channelDevice;
    }

    public Integer getProductPeriod() {
        return productPeriod;
    }

    public void setProductPeriod(Integer productPeriod) {
        this.productPeriod = productPeriod;
    }

    public String getPlanDialys() {
        return planDialys;
    }

    public void setPlanDialys(String planDialys) {
        this.planDialys = planDialys;
    }

    public Integer getHdfF1() {
        return hdfF1;
    }

    public void setHdfF1(Integer hdfF1) {
        this.hdfF1 = hdfF1;
    }

    public Integer getNepdF1() {
        return nepdF1;
    }

    public void setNepdF1(Integer nepdF1) {
        this.nepdF1 = nepdF1;
    }

    public Integer getHdfF2() {
        return hdfF2;
    }

    public void setHdfF2(Integer hdfF2) {
        this.hdfF2 = hdfF2;
    }

    public Integer getNepdF2() {
        return nepdF2;
    }

    public void setNepdF2(Integer nepdF2) {
        this.nepdF2 = nepdF2;
    }

    public Integer getHdfF3() {
        return hdfF3;
    }

    public void setHdfF3(Integer hdfF3) {
        this.hdfF3 = hdfF3;
    }

    public Integer getNepdF3() {
        return nepdF3;
    }

    public void setNepdF3(Integer nepdF3) {
        this.nepdF3 = nepdF3;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getFbNote() {
        return fbNote;
    }

    public void setFbNote(String fbNote) {
        this.fbNote = fbNote;
    }

    public Boolean getYnProduct() {
        return ynProduct;
    }

    public void setYnProduct(Boolean ynProduct) {
        this.ynProduct = ynProduct;
    }

    public Boolean getYnPlan() {
        return ynPlan;
    }

    public void setYnPlan(Boolean ynPlan) {
        this.ynPlan = ynPlan;
    }



    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperDate() {
        return operDate;
    }

    public void setOperDate(String operDate) {
        this.operDate = operDate;
    }

    public String getPreparerDate() {
        return preparerDate;
    }

    public void setPreparerDate(String preparerDate) {
        this.preparerDate = preparerDate;
    }

    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker;
    }

    public String getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
    }

    public String getSubmitUser() {
        return submitUser;
    }

    public void setSubmitUser(String submitUser) {
        this.submitUser = submitUser;
    }

    public String getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(String submitDate) {
        this.submitDate = submitDate;
    }

    public String getVerifier() {
        return verifier;
    }

    public void setVerifier(String verifier) {
        this.verifier = verifier;
    }

    public String getVerifyDate() {
        return verifyDate;
    }

    public void setVerifyDate(String verifyDate) {
        this.verifyDate = verifyDate;
    }

    public String getZ9Final() {
        return Z9Final;
    }

    public void setZ9Final(String z9Final) {
        Z9Final = z9Final;
    }

    public String getZ9FinalUser() {
        return Z9FinalUser;
    }

    public void setZ9FinalUser(String z9FinalUser) {
        Z9FinalUser = z9FinalUser;
    }

    public String getZ9FinalDate() {
        return Z9FinalDate;
    }

    public void setZ9FinalDate(String z9FinalDate) {
        Z9FinalDate = z9FinalDate;
    }

    public String getHd() {
        return hd;
    }

    public void setHd(String hd) {
        this.hd = hd;
    }
}

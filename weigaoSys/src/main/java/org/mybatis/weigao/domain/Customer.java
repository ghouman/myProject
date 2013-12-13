package org.mybatis.weigao.domain;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: ghm
 * Date: 13-11-22
 * Time: 下午10:14
 * To change this template use File | Settings | File Templates.
 */
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    private int uid;
    private String select;
    private String disable;
    private String creator;
    private String creationDate;
    private String operator;
    private String operDate;
    private String customerName;
    private String zect;
    private String coopType;
    private String custVal;
    private String feedback;
    private String address;
    private String website;
    private String healthClass;
    private String healtMemo;
    private String hierarchy;   //行政等级：省部级/地市级/区县级
    private String coop_DT;     //    合作时间
    private String openDt;
    private String portID;//  所在城市ID：FK，关联城市表b0Port.UID
    private String port;
    private String clerk;// 业务员
    private String manager;
    private String salesRegion;//  销售大区
    private String labOffice;
    private String labOMemo;
    private String labTEL;
    private String hospitalMemo;
    private String postalCode;// 邮编
    private String  active;
    private String direct;
    private String chargeLimit;
    private String verify;
    private String verifier;
    private String verifyDate;
    private String province;
    private String salesFloor;

    private int fromIndex = 0;
    private int toIndex = 15;

    private String managerEng; //客服部

    private String preparerManager;//区域主管

    private String jsonString;

    public String getPreparerManager() {
        return preparerManager;
    }

    public void setPreparerManager(String preparerManager) {
        this.preparerManager = preparerManager;
    }

    public String getSalesFloor() {
        return salesFloor;
    }

    public void setSalesFloor(String salesFloor) {
        this.salesFloor = salesFloor;
    }

    public String getJsonString() {
        return jsonString;
    }

    public void setJsonString(String jsonString) {
        this.jsonString = jsonString;
    }

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

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getSelect() {
        return select;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setSelect(String select) {
        this.select = select;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getCustVal() {
        return custVal;
    }

    public void setCustVal(String custVal) {
        this.custVal = custVal;
    }

    public String getDisable() {
        return disable;
    }

    public void setDisable(String disable) {
        this.disable = disable;
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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getZect() {
        return zect;
    }

    public void setZect(String zect) {
        this.zect = zect;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
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

    public String getPortID() {
        return portID;
    }

    public void setPortID(String portID) {
        this.portID = portID;
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

    public String getCoopType() {
        return coopType;
    }

    public void setCoopType(String coopType) {
        this.coopType = coopType;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getOpenDt() {
        return openDt;
    }

    public void setOpenDt(String openDt) {
        this.openDt = openDt;
    }

    public String getLabOffice() {
        return labOffice;
    }

    public void setLabOffice(String labOffice) {
        this.labOffice = labOffice;
    }

    public String getLabOMemo() {
        return labOMemo;
    }

    public void setLabOMemo(String labOMemo) {
        this.labOMemo = labOMemo;
    }

    public String getLabTEL() {
        return labTEL;
    }

    public void setLabTEL(String labTEL) {
        this.labTEL = labTEL;
    }

    public String getHospitalMemo() {
        return hospitalMemo;
    }

    public void setHospitalMemo(String hospitalMemo) {
        this.hospitalMemo = hospitalMemo;
    }

    public String getDirect() {
        return direct;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }

    public String getChargeLimit() {
        return chargeLimit;
    }

    public void setChargeLimit(String chargeLimit) {
        this.chargeLimit = chargeLimit;
    }

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
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

    public String getHealtMemo() {
        return healtMemo;
    }

    public void setHealtMemo(String healtMemo) {
        this.healtMemo = healtMemo;
    }
}

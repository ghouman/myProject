package org.mybatis.weigao.domain;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: ghm
 * Date: 13-11-26
 * Time: 上午1:35
 * To change this template use File | Settings | File Templates.
 */
public class SurveyDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    private boolean select;
    private boolean disable;
    private String creator;
    private String creationDate;

    private String operator;
    private String operDate;
    private int surveyID;//调研ID
    private String surveyNo;//调研编号
    private int partID;   //产品型号ID

    private int uid;//产品明细ID

    private int ahsca;  //数量
    private int aPrice; //价格
    private int bReUseNote;  //复用情况
    private String bInstallDate; //装机日期
    private String remark;

    private String category;
    private String brand;
    private String family;
    private String partNo;
    private String unit;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getPartNo() {
        return partNo;
    }

    public void setPartNo(String partNo) {
        this.partNo = partNo;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getSurveyNo() {
        return surveyNo;
    }

    public void setSurveyNo(String surveyNo) {
        this.surveyNo = surveyNo;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
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

    public int getSurveyID() {
        return surveyID;
    }

    public void setSurveyID(int surveyID) {
        this.surveyID = surveyID;
    }

    public int getaPrice() {
        return aPrice;
    }

    public void setaPrice(int aPrice) {
        this.aPrice = aPrice;
    }

    public int getPartID() {
        return partID;
    }

    public void setPartID(int partID) {
        this.partID = partID;
    }

    public int getAhsca() {
        return ahsca;
    }

    public void setAhsca(int ahsca) {
        this.ahsca = ahsca;
    }

    public int getbReUseNote() {
        return bReUseNote;
    }

    public void setbReUseNote(int bReUseNote) {
        this.bReUseNote = bReUseNote;
    }

    public String getbInstallDate() {
        return bInstallDate;
    }

    public void setbInstallDate(String bInstallDate) {
        this.bInstallDate = bInstallDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}

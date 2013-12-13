package org.mybatis.weigao.domain;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: ghm
 * Date: 13-11-22
 * Time: 下午10:14
 * To change this template use File | Settings | File Templates.
 */
public class Category implements Serializable {
    private static final long serialVersionUID = -1L;
    //产品
    private int uid;
    private String plate;
    private String category;
    private int isSelect;
    private int isDisable;
    private String creator;
    private String creationDate;
    private String operator;
    private String operDate;
    //品牌
    private int brandUid;
    private int categoryID;
    private String brand;
    private String code;
    //private String creator;
   // private String creationDate;
  //  private String operator;
   // private String OperDate;
    //规格
    private  int  familyUid;
    private int brandId;
    private String family;

    //型号
    private int partNoUid;
    private int familyId;
    private String partNo;
    private String unit;


    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getSelect() {
        return isSelect;
    }

    public void setSelect(int select) {
        isSelect = select;
    }

    public int getDisable() {
        return isDisable;
    }

    public void setDisable(int disable) {
        isDisable = disable;
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

    public int getBrandUid() {
        return brandUid;
    }

    public void setBrandUid(int brandUid) {
        this.brandUid = brandUid;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getFamilyUid() {
        return familyUid;
    }

    public void setFamilyUid(int familyUid) {
        this.familyUid = familyUid;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public int getPartNoUid() {
        return partNoUid;
    }

    public void setPartNoUid(int partNoUid) {
        this.partNoUid = partNoUid;
    }

    public int getFamilyId() {
        return familyId;
    }

    public void setFamilyId(int familyId) {
        this.familyId = familyId;
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
}

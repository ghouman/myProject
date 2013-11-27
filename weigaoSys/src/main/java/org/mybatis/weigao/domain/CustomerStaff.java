package org.mybatis.weigao.domain;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: ghm
 * Date: 13-11-23
 * Time: 下午9:25
 * To change this template use File | Settings | File Templates.
 */
public class CustomerStaff  implements Serializable {
    private static final long serialVersionUID = 1L;

    private int uid;
    private int isSelect;
    private int isDisable;
    private String creator;
    private String creationDate;
    private String operator;
    private String operDate;
    private String customerId;
    private String staff;
    private String staffDuty;
    private String staffTel;
    private String staffForce;
    private String staffFavor;
    private String staffImpact;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
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

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getStaff() {
        return staff;
    }

    public void setStaff(String staff) {
        this.staff = staff;
    }

    public String getStaffDuty() {
        return staffDuty;
    }

    public void setStaffDuty(String staffDuty) {
        this.staffDuty = staffDuty;
    }

    public String getStaffTel() {
        return staffTel;
    }

    public void setStaffTel(String staffTel) {
        this.staffTel = staffTel;
    }

    public String getStaffForce() {
        return staffForce;
    }

    public void setStaffForce(String staffForce) {
        this.staffForce = staffForce;
    }

    public String getStaffFavor() {
        return staffFavor;
    }

    public void setStaffFavor(String staffFavor) {
        this.staffFavor = staffFavor;
    }

    public String getStaffImpact() {
        return staffImpact;
    }

    public void setStaffImpact(String staffImpact) {
        this.staffImpact = staffImpact;
    }
}

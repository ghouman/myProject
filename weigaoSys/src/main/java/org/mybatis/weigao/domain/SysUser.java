package org.mybatis.weigao.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: ghm
 * Date: 13-11-27
 * Time: 下午10:51
 * To change this template use File | Settings | File Templates.
 */


public class SysUser
        implements Serializable {
    private static final long serialVersionUID = -1L;
    private Long no;
    private String userId;
    private String password;
    private String userName;
    private String roleWeb;
    private String depart;
    private boolean adapted;
    private String operator;
    private Date operDate;
    private String region;
    private boolean floor = false;
    private boolean isResearchAdmin;
    private boolean isSalesFloor ;

    public boolean isSalesFloor() {
        return isSalesFloor;
    }

    public void setSalesFloor(boolean salesFloor) {
        isSalesFloor = salesFloor;
    }

    public boolean isResearchAdmin() {
        return isResearchAdmin;
    }

    public void setResearchAdmin(boolean researchAdmin) {
        isResearchAdmin = researchAdmin;
    }

    public boolean isFloor() {
        return this.floor;
    }

    public void setFloor(boolean floor) {
        this.floor = floor;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRoleWeb() {
        return this.roleWeb;
    }

    public void setRoleWeb(String roleWeb) {
        this.roleWeb = roleWeb;
    }

    public Long getNo() {
        return this.no;
    }

    public void setNo(Long no) {
        this.no = no;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDepart() {
        return this.depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public boolean isAdapted() {
        return this.adapted;
    }

    public void setAdapted(boolean adapted) {
        this.adapted = adapted;
    }

    public String getOperator() {
        return this.operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Date getOperDate() {
        return this.operDate;
    }

    public void setOperDate(Date operDate) {
        this.operDate = operDate;
    }
}


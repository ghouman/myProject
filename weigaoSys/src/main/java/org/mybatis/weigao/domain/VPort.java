package org.mybatis.weigao.domain;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: ghm
 * Date: 13-12-7
 * Time: 下午9:47
 * To change this template use File | Settings | File Templates.
 */
public class VPort implements Serializable {

    private static final long serialVersionUID = -1L;
    private String provinceId;
    private String province;
    private String uid;
    private String port;

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}

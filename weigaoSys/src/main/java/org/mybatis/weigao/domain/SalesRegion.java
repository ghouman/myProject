package org.mybatis.weigao.domain;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: ghm
 * Date: 13-12-7
 * Time: 下午9:47
 * To change this template use File | Settings | File Templates.
 */
public class SalesRegion implements Serializable {

    private static final long serialVersionUID = -1L;
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

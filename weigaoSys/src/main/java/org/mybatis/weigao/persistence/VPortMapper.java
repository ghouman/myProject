package org.mybatis.weigao.persistence;

import org.mybatis.weigao.domain.VPort;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ghm
 * Date: 13-11-16
 * Time: 下午3:10
 * To change this template use File | Settings | File Templates.
 */
public interface VPortMapper {

    public List<VPort> getProvinceList();

    public List<VPort> getPortByProvinceId(VPort vPort);
}

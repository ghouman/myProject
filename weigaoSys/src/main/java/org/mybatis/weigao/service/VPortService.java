package org.mybatis.weigao.service;

import org.mybatis.weigao.domain.SysUser;
import org.mybatis.weigao.domain.VPort;
import org.mybatis.weigao.persistence.VPortMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VPortService {

    @Autowired
    private VPortMapper vPortMapper;

    public List<VPort> getProvinceList() {
        return vPortMapper.getProvinceList();
    }

    public List<VPort> getPortByProvinceId(VPort vPort) {
        return vPortMapper.getPortByProvinceId(vPort);
    }
}

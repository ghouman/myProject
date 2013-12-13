package org.mybatis.weigao.service;

import org.mybatis.weigao.domain.VPort;
import org.mybatis.weigao.persistence.ComponentMapper;
import org.mybatis.weigao.persistence.VPortMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComponentService {

    @Autowired
    private ComponentMapper componentMapper;

    public List getSalesRegionList() {
        return componentMapper.getSalesRegionList();
    }
}

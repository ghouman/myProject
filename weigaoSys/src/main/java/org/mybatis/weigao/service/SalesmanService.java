package org.mybatis.weigao.service;

import org.mybatis.weigao.domain.Salesman;
import org.mybatis.weigao.persistence.SalesmanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ghm
 * Date: 13-12-4
 * Time: 上午1:01
 * To change this template use File | Settings | File Templates.
 */
@Service
public class SalesmanService {
    @Autowired
    private SalesmanMapper salesmanMapper;

    public List<Salesman> getSalesmanByManagername(String managerName){
         return salesmanMapper.getSalesmanByManagername(managerName);
    }

}

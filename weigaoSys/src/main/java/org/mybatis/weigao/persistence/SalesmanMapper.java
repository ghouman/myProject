package org.mybatis.weigao.persistence;

import org.mybatis.weigao.domain.Salesman;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ghm
 * Date: 13-12-4
 * Time: 上午12:59
 * To change this template use File | Settings | File Templates.
 */
public interface SalesmanMapper {
      public List<Salesman> getSalesmanByManagername(String managerName);
}

package org.mybatis.weigao.persistence;

import org.mybatis.weigao.domain.Customer;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ghm
 * Date: 13-11-16
 * Time: 下午3:10
 * To change this template use File | Settings | File Templates.
 */
public interface CustomerMapper {

    public List<Customer> getCustomer(Customer customer);

    public void updateCustomer(Customer customer);

    public int countCustomerSize(Customer customer);
}

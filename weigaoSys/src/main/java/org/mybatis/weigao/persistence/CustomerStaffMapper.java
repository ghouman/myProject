package org.mybatis.weigao.persistence;

import org.mybatis.weigao.domain.CustomerStaff;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ghm
 * Date: 13-11-16
 * Time: 下午3:10
 * To change this template use File | Settings | File Templates.
 */
public interface CustomerStaffMapper {

    public List<CustomerStaff> getCustomerStaff(CustomerStaff customerStaff);

    public void delAllStaffByCustomerId(int customerId);

    public void addCustomerStaff(CustomerStaff customerStaff);
}

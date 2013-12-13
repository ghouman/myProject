package org.mybatis.weigao.service;

import org.mybatis.weigao.domain.Customer;
import org.mybatis.weigao.domain.CustomerStaff;
import org.mybatis.weigao.persistence.CustomerMapper;
import org.mybatis.weigao.persistence.CustomerStaffMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerStaffService {

  @Autowired
  private CustomerStaffMapper customerStaffMapper;

  public List<CustomerStaff> getCustomerStaff(CustomerStaff customerStaff) {
        return customerStaffMapper.getCustomerStaff(customerStaff);
  }

    public void delAllStaffByCustomerId(int customerId) {
        customerStaffMapper.delAllStaffByCustomerId(customerId);
    }

    public void addCustomerStaff(CustomerStaff customerStaff){
        customerStaffMapper.addCustomerStaff(customerStaff);
    }

}

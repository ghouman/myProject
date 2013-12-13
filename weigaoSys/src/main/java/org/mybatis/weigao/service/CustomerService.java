package org.mybatis.weigao.service;

import org.hsqldb.lib.StringUtil;
import org.mybatis.weigao.common.util.JsonUtil;
import org.mybatis.weigao.domain.Customer;
import org.mybatis.weigao.domain.CustomerStaff;
import org.mybatis.weigao.persistence.CustomerMapper;
import org.mybatis.weigao.persistence.CustomerStaffMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private CustomerStaffMapper customerStaffMapper;

    public List<Customer> getCustomer(Customer customer) {
        return customerMapper.getCustomer(customer);
    }

    //更新客户及客户负责人明细， 先删除在增加
    @Transactional
    public void updateCustomer(Customer customer) {
        customerMapper.updateCustomer(customer);
        customerStaffMapper.delAllStaffByCustomerId(customer.getUid());
        this.addCustomerStaff(customer.getJsonString());
    }

    public int countCustomerSize(Customer customer) {
        return customerMapper.countCustomerSize(customer);
    }

    public void addCustomerStaff(String jsonString) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!StringUtil.isEmpty(jsonString)) {
            List<CustomerStaff> customerStaffList = JsonUtil.getDTOList(jsonString, CustomerStaff.class);
            for (int i = 0; i < customerStaffList.size(); i++) {
                CustomerStaff customerStaff = customerStaffList.get(i);
                customerStaff.setCreator(auth.getName());
                customerStaff.setOperator(auth.getName());
                customerStaffMapper.addCustomerStaff(customerStaff);
            }
        }
    }

}

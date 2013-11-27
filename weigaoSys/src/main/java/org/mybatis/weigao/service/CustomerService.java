package org.mybatis.weigao.service;

import org.mybatis.weigao.domain.Customer;
import org.mybatis.weigao.persistence.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {

  @Autowired
  private CustomerMapper customerMapper;

  public List<Customer> getCustomer(Customer customer) {
        return customerMapper.getCustomer(customer);
  }

    public void updateCustomer(Customer customer){
        customerMapper.updateCustomer(customer);
    }

}

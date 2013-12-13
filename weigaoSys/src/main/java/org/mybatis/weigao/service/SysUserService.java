package org.mybatis.weigao.service;

import org.mybatis.weigao.domain.Customer;
import org.mybatis.weigao.domain.SysUser;
import org.mybatis.weigao.persistence.CustomerMapper;
import org.mybatis.weigao.persistence.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserService {

  @Autowired
  private SysUserMapper sysUserMapper;

  public List<SysUser> getSysUser(SysUser sysUser){
      return sysUserMapper.getSysUser(sysUser);
  }
}

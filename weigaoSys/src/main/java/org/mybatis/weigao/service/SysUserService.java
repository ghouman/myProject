package org.mybatis.weigao.service;

import org.mybatis.weigao.domain.Customer;
import org.mybatis.weigao.domain.SysUser;
import org.mybatis.weigao.persistence.CustomerMapper;
import org.mybatis.weigao.persistence.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    public List<SysUser> getSysUser(SysUser sysUser) {
        return sysUserMapper.getSysUser(sysUser);
    }

    /*public String getUserNameByUid(String uid) {
        SysUser sysUser = null;//new SysUser();
        if ("current".equals(uid)) {  //获取当前用户用户名
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            Collection collectionAuth = auth.getAuthorities();
            List<SysUser> sysUserList = sysUserMapper.getSysUserByUid(auth.getName());
            if (sysUserList.size() > 0) {
                sysUser = sysUserList.get(0);
            }
        } else {
            List<SysUser> sysUserList = sysUserMapper.getSysUserByUid(uid);
            if (sysUserList.size() > 0) {
                sysUser = sysUserList.get(0);
            }
        }
        return sysUser.getUserName();
    }*/
}

package org.mybatis.weigao.service;

import com.sun.net.httpserver.HttpContext;
import org.apache.log4j.Logger;
import org.mybatis.weigao.domain.SysUser;
import org.mybatis.weigao.persistence.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.*;

@Service
public class MyUserDetailService implements UserDetailsService {
    private static Logger logger = Logger.getLogger(MyUserDetailService.class);
    @Autowired
    private SysUserMapper sysUserMapper;


    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException, DataAccessException {
        Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
        GrantedAuthorityImpl auth2 = new GrantedAuthorityImpl("ROLE_LOGIN_USER");
        auths.add(auth2);
        List<SysUser> sysUserList = null;
        try {
            sysUserList = sysUserMapper.getSysUserByUid(username);
        } catch (DataAccessException e) {
            logger.error(e);
            throw e;
        }
        //String password = "";
        SysUser sysUser = null;
        if (sysUserList != null && sysUserList.size() > 0) {
            sysUser = sysUserList.get(0);

            //password = sysUser.getPassword();
            String roleWeb = sysUser.getRoleWeb();
            GrantedAuthorityImpl auth3 = null;
            if(roleWeb!=null){
                auth3 = new GrantedAuthorityImpl(sysUser.getRoleWeb());
            } else {
                //throw  new UsernameNotFoundException(username+"权限尚未开通，请联系管理员或重试！");
            }
            if ("客服部".equals(roleWeb) && sysUser.isResearchAdmin()) {
                auths.add(new GrantedAuthorityImpl("系统管理员"));
                // } else if (("大区经理".equals(roleWeb) || "工程师".equals(roleWeb)) && !sysUser.isSalesFloor()) {
                //auths.add(new GrantedAuthorityImpl("其它"));
            } else if ("客服部".equals(roleWeb) && !sysUser.isSalesFloor()) {
                auths.add(new GrantedAuthorityImpl("普通客服"));
            } else if ("业务员".equals(roleWeb) && sysUser.isSalesFloor()) {
                auths.add(new GrantedAuthorityImpl("区域主管"));
            } else {
                auths.add(auth3);
            }
            sysUser.setGrantedAuths(auths);

           /*  if("胡晓红".equals(username)||"黄小强".equals(username)){ //根据特殊需要，设置为管理员
                 auths.add(new GrantedAuthorityImpl("系统管理员"));
             } else {
                 auths.add(auth3);
             }*/
        } else {
             throw  new UsernameNotFoundException(username+"不存在！");
        }
        //User user = new User(username, password, true, true, true, true, auths);

        /* GrantedAuthorityImpl auth2=new GrantedAuthorityImpl("ROLE_ADMIN");
         auths.add(auth2);
        if(username.equals("robin1")){
             auths=new ArrayList<GrantedAuthority>();
             GrantedAuthorityImpl auth1=new GrantedAuthorityImpl("ROLE_ROBIN");
             auths.add(auth1);
         }

//         User(String username, String password, boolean enabled, boolean accountNonExpired,
//                     boolean credentialsNonExpired, boolean accountNonLocked, Collection<GrantedAuthority> authorities) {
         User user = new User(username,
                "robin", true, true, true, true, auths);*/
        return sysUser;
    }

/*    public SysUser loadSysUserByUid(String uid) {
        SysUser sysUser = null;//new SysUser();
        List<SysUser> sysUserList = sysUserMapper.getSysUserByUid(uid);
        if (sysUserList.size() > 0) {
            sysUser = sysUserList.get(0);
        }
        return sysUser;
    }*/

    /*public String getUserNameByUid(String uid) {
        SysUser sysUser = null;//new SysUser();
        if ("current".equals(uid)) {  //获取当前用户用户名
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            Collection collectionAuth = auth.getAuthorities();
            sysUser = this.loadSysUserByUid(auth.getName());
        } else {
            sysUser = this.loadSysUserByUid(uid);
        }
        return sysUser.getUserName();
    }*/
}

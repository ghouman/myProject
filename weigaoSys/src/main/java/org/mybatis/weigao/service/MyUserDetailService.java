package org.mybatis.weigao.service;

import org.mybatis.weigao.domain.SysUser;
import org.mybatis.weigao.persistence.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException, DataAccessException {
        Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
        GrantedAuthorityImpl auth2 = new GrantedAuthorityImpl("ROLE_LOGIN_USER");
        auths.add(auth2);


        List<SysUser> sysUserList = sysUserMapper.getSysUserByName(username);

        String password = "";
        if (sysUserList != null && sysUserList.size() > 0) {
            SysUser sysUser = sysUserList.get(0);
            password = sysUser.getPassword();
            String roleWeb = sysUser.getRoleWeb();
            GrantedAuthorityImpl auth3 = new GrantedAuthorityImpl(sysUser.getRoleWeb());
            if ("客服部".equals(roleWeb) && sysUser.isResearchAdmin()) {
                auths.add(new GrantedAuthorityImpl("系统管理员"));
            } else if (("大区经理".equals(roleWeb) || "工程师".equals(roleWeb)) && !sysUser.isSalesFloor()) {
                //auths.add(new GrantedAuthorityImpl("其它"));
            } else if ("业务员".equals(roleWeb) && sysUser.isSalesFloor()) {
                auths.add(new GrantedAuthorityImpl("区域主管"));
            } else {
                auths.add(auth3);
            }

           /*  if("胡晓红".equals(username)||"黄小强".equals(username)){ //根据特殊需要，设置为管理员
                 auths.add(new GrantedAuthorityImpl("系统管理员"));
             } else {
                 auths.add(auth3);
             }*/
        }
        User user = new User(username, password, true, true, true, true, auths);

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
        return user;
    }

}

package org.mybatis.weigao.persistence;

import org.mybatis.weigao.domain.Customer;
import org.mybatis.weigao.domain.SysUser;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ghm
 * Date: 13-11-16
 * Time: 下午3:10
 * To change this template use File | Settings | File Templates.
 */
public interface SysUserMapper {

    public List<SysUser> getSysUser(SysUser SysUser);


    public List<SysUser> getSysUserByUid(String userId);
}

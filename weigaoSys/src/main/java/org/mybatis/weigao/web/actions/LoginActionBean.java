package org.mybatis.weigao.web.actions;

import net.sf.json.JSONObject;
import net.sourceforge.stripes.action.*;
import net.sourceforge.stripes.integration.spring.SpringBean;
import org.mybatis.weigao.domain.SysUser;
import org.mybatis.weigao.service.SysUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.StringReader;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ghm
 * Date: 13-11-17
 * Time: 下午10:05
 * To change this template use File | Settings | File Templates.
 */

public class LoginActionBean extends AbstractActionBean {

    private static final long serialVersionUID = -1L;
    private static final String SIGNON = "/login.jsp";
    private static final String SIGNONSUCESS = "/WEB-INF/common/Main.jsp";
    public boolean authenticated;

    @SpringBean
    private transient SysUserService sysUserService;

    private List<SysUser> sysUserList;
    private SysUser sysUser;

    private String userName;
    private String password;

    public List<SysUser> getSysUserList() {
        return sysUserList;
    }

    public void setSysUserList(List<SysUser> sysUserList) {
        this.sysUserList = sysUserList;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    @DefaultHandler
    public Resolution signonForm() {
        return new ForwardResolution(SIGNON);
    }

  /*  public Resolution signon() {
        sysUser = new SysUser();
        sysUser.setUserName(userName);
        sysUser.setPassword(password);
        //sysUser = loginService.getAccount(getUsername(), getPassword());
        sysUserList = sysUserService.getSysUser(sysUser);

        if (sysUserList == null || sysUserList.size() == 0) {
            String value = "* 错误的用户名密码，请重新输入";
            setMessage(value);
            HttpServletRequest request = context.getRequest();
            request.setAttribute("errorMsg", value);
            clear();
            return new ForwardResolution(SIGNON);
        } else {
            //sysUser.setPassword(null);
            authenticated = true;
            HttpSession s = context.getRequest().getSession();
            // this bean is already registered as /actions/Account.action
            sysUser = sysUserList.get(0);
            s.setAttribute("USER", sysUser);
            s.setAttribute("authenticated", this.authenticated);
            return new RedirectResolution(CatalogActionBean.class);
        }
    }
*/
    public Resolution signoff() {
        HttpSession s = context.getRequest().getSession();
        s.invalidate();
        s.setAttribute("USER", null);
        s.setAttribute("authenticated", false);
        clear();
        return new RedirectResolution(CatalogActionBean.class);
    }

    public boolean isAuthenticated() {
        return authenticated && sysUser != null && sysUser.getUserName() != null;
    }

    public void clear() {
        sysUser = null;//new SysUser();
        authenticated = false;
    }
}

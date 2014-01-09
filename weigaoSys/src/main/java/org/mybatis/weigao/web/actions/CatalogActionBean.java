package org.mybatis.weigao.web.actions;

import net.sf.json.JSONObject;
import net.sourceforge.stripes.action.*;
import net.sourceforge.stripes.integration.spring.SpringBean;
import org.apache.log4j.Logger;
import org.mybatis.weigao.common.util.CommonUtil;
import org.mybatis.weigao.domain.SysUser;
import org.mybatis.weigao.service.MyUserDetailService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.StringReader;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class CatalogActionBean extends AbstractActionBean {

    private static final long serialVersionUID = 5849523372175050635L;
    private static Logger logger = Logger.getLogger(CatalogActionBean.class);
    private static final String MAIN = "/WEB-INF/jsp/catalog/Main.jsp";
    private static final String LOGIN = "/login.jsp";

    @SpringBean
    private transient MyUserDetailService myUserDetailService;

    @DefaultHandler
    public ForwardResolution viewMain() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Collection collectionAuth = auth.getAuthorities();
        //SysUser sysUser = (SysUser) auth.getPrincipal();
       /* SysUser sysUser = new SysUser();
        try {
            sysUser = myUserDetailService.loadSysUserByUid(auth.getName());
        } catch (Exception e) {
            logger.error(e);
            return new ForwardResolution(MAIN);
        }
        HttpSession session = context.getRequest().getSession();
        session.setAttribute("userName", sysUser.getUserName());*/
        logger.info("mail：" + auth.getName() + " ,角色：" + collectionAuth + " ,访问时间：" + CommonUtil.getCurrentTime() + ",auth:" + auth);

        return new ForwardResolution(MAIN);
    }

/*    public Resolution getSysUserInfo () throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        SysUser sysUser = null;//new SysUser();
        try {
            sysUser = myUserDetailService.loadSysUserByUid(auth.getName());
        } catch (Exception e) {
            logger.error(e);
            throw e;
        }
        String userName = sysUser.getUserName();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("sysUser", sysUser);
        return new StreamingResolution("text", new StringReader(jsonObj.toString()));
    }*/

    public void clear() {
    }

}

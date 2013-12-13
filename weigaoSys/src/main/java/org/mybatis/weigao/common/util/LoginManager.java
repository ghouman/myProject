package org.mybatis.weigao.common.util;

import org.mybatis.weigao.domain.SysUser;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: ghm
 * Date: 13-11-27
 * Time: 下午10:47
 * To change this template use File | Settings | File Templates.
 */
public abstract class LoginManager {
    public static final String USER_INFO = "user_info";
    public static final String USER_STUDY_INFO = "user_study_info";
    public static final int DEFAULT_COOKIE_EXPIRE = 2592000;
    public static final String COOKIE_ACCOUNT = "weigao_userid";


    public static void persistLogin(HttpServletRequest request, HttpServletResponse response, SysUser user, boolean isKeepAccount) {
        if (user == null) return;
        HttpSession session = request.getSession();
        session.setAttribute("user_info", user);

        if (isKeepAccount) {
            try {
                String account = user.getUserId();
                account = URLEncoder.encode(account, "UTF-8");
                setAccountCookie(response, COOKIE_ACCOUNT, account);
            } catch (Exception localException) {
            }
        } else {
            try {
                setAccountCookie(response, COOKIE_ACCOUNT, "");
            } catch (Exception localException1) {
            }
        }
    }


    public static void setAccountCookie(HttpServletResponse response, String key, String value) {
        Cookie cookie = new Cookie(key, value);
        cookie.setMaxAge(2592000);
        response.addCookie(cookie);
    }

    public static String getAccountCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return null;
        }

        for (Cookie item : cookies) {
            if (COOKIE_ACCOUNT.equals(item.getName())) {
                try {
                    String account = item.getValue();
                    return URLDecoder.decode(account, "UTF-8");
                } catch (Exception ex) {
                    return null;
                }
            }
        }

        return null;
    }

    public static SysUser userLoginInfo(HttpServletRequest request) {
        SysUser user = null;

        HttpSession session = request.getSession();
        if (session != null) {
            user = (SysUser) session.getAttribute("user_info");
            if (user != null) {
                return user;
            }
        }
        return user;
    }


    public static boolean isUserLogin(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object objUser = session.getAttribute("user_info");
        if (objUser != null) {
            SysUser user = (SysUser) objUser;
            if (user != null) {
                String userId = user.getUserId();
                if (!StringUtils.isWhiteSpace(userId)) {
                    return true;
                }
            }
        }

        return false;
    }


    public static void logout(HttpServletRequest request) {
        HttpSession sessoin = request.getSession();
        sessoin.removeAttribute("user_info");
    }

    public static void studyLogout(HttpServletRequest request) {
        HttpSession sessoin = request.getSession();
        sessoin.removeAttribute("user_study_info");
    }
}

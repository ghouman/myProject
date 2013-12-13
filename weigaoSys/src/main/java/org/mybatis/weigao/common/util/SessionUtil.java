package org.mybatis.weigao.common.util;

import org.mybatis.weigao.common.util.core.domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
/**
 * Created with IntelliJ IDEA.
 * User: ghm
 * Date: 13-11-27
 * Time: 下午11:10
 * To change this template use File | Settings | File Templates.
 */

public abstract class SessionUtil
{
  public static User getUserInfo(HttpServletRequest request)
  {
    Object obj = request.getSession().getAttribute("USER");
    if ((obj != null) && ((obj instanceof User))) {
      return (User)obj;
    }
    return null;
  }

  public static boolean isUserLogin(HttpServletRequest request)
  {
    boolean rtn = false;

    Object obj = request.getSession().getAttribute("USER");
    if ((obj != null) && ((obj instanceof User))) {
      User user = (User)obj;
      if ((user != null) && (user.getUserID() != -1) && (user.getUserName().length() != 0)) {
        rtn = true;
      }
    }

    return rtn;
  }

  public static void killSession(HttpServletRequest request)
  {
    if (request.getSession().getAttribute("USER") != null) {
      request.getSession().removeAttribute("USER");
    }
  }
}

package org.mybatis.weigao.common.util;

/**
 * Created with IntelliJ IDEA.
 * User: ghm
 * Date: 13-11-27
 * Time: 下午11:12
 * To change this template use File | Settings | File Templates.
 */

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class CookieUtils
{
  public static final int DEFAULT_COOKIE_EXPIRE = 604800;

  public static void writeCookie(HttpServletResponse response, String key, String value)
  {
    writeCookie(response, key, value, 604800);
  }

  public static void writeCookie(HttpServletResponse response, String key, String value, String domain)
  {
    writeCookie(response, key, value, domain, 604800, "/");
  }

  public static void writeCookie(HttpServletResponse response, String key, String value, int maxAge)
  {
    writeCookie(response, key, value, null, maxAge, "/");
  }

  public static void writeCookie(HttpServletResponse response, String key, String value, int maxAge, String path)
  {
    writeCookie(response, key, value, null, maxAge, path);
  }

  public static void writeCookie(HttpServletResponse response, String key, String value, String domain, int maxAge, String path)
  {
    Cookie cookie = new Cookie(key, value);
    cookie.setDomain(domain);
    cookie.setMaxAge(maxAge);
    if ((path != null) && (path.trim().length() > 0)) cookie.setPath(path);
    response.addCookie(cookie);
  }

  public static Map<String, Cookie> getCookie(HttpServletRequest request)
  {
    Map<String, Cookie> mapCookies = new HashMap();
    Cookie[] cookies = request.getCookies();

    if ((cookies != null) && (cookies.length > 0)) {
      for (Cookie cookie : cookies) {
        mapCookies.put(cookie.getName(), cookie);
      }

      return mapCookies;
    }
    return null;
  }

  public static Cookie getCookie(HttpServletRequest request, String key)
  {
    Cookie cookie = null;
    Map<String, Cookie> mapCookie = getCookie(request);
    if (mapCookie != null) {
      cookie = (Cookie)mapCookie.get(key);
    }

    return cookie;
  }

  public static String readCookie(HttpServletRequest request, String key, String domain)
  {
    return readCookie(request, key, domain, null);
  }

  public static String readCookie(HttpServletRequest request, String key, String domain, String defaultValue)
  {
    Cookie cookie = getCookie(request, key);
    if (cookie != null) {
      return cookie.getValue();
    }
    return defaultValue;
  }

  public static void clearAllCookie(HttpServletRequest request, HttpServletResponse response, String domain)
  {
    Cookie[] cookies = request.getCookies();
    clearCookie(response, cookies, domain);
  }

  public static void clearCookie(HttpServletResponse response, Cookie[] cookies, String domain)
  {
    if ((cookies != null) && (cookies.length > 0)) {
      for (Cookie cookie : cookies) {
        cookie.setMaxAge(0);
        cookie.setPath("/");
        cookie.setDomain(domain);
        response.addCookie(cookie);
      }
    }
  }

  public static void clearCookie(HttpServletResponse response, Cookie cookie, String domain)
  {
    cookie.setMaxAge(0);
    cookie.setPath("/");
    cookie.setDomain(domain);
    response.addCookie(cookie);
  }

  public static void clearCookie(HttpServletRequest request, HttpServletResponse response, String[] keys, String domain)
  {
    if ((keys == null) || (keys.length == 0)) {
      return;
    }

    for (String key : keys) {
      clearCookie(request, response, key, domain);
    }
  }

  public static void clearCookie(HttpServletRequest request, HttpServletResponse response, String key, String domain)
  {
    Cookie cookie = getCookie(request, key);
    if (cookie != null) {
      clearCookie(response, cookie, domain);
    }
  }
}

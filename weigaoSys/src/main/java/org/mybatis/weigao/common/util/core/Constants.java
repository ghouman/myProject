package org.mybatis.weigao.common.util.core;

/**
 * Created with IntelliJ IDEA.
 * User: ghm
 * Date: 13-11-27
 * Time: 下午11:08
 * To change this template use File | Settings | File Templates.
 */
public abstract class Constants
{
  public static final int PAGE_SIZE = 20;

  public static final String SESSION_USER_KEY = "USER";

  public static enum USER_LEVEL
  {
    GUEST,
    NORMAL_USER,
    VIP_USER,
    SYSTEM_USER;
  }
}

package org.mybatis.weigao.common.util.core.domain;

import org.mybatis.weigao.common.util.core.Constants;

/**
 * Created with IntelliJ IDEA.
 * User: ghm
 * Date: 13-11-27
 * Time: 下午11:09
 * To change this template use File | Settings | File Templates.
 */
public abstract class User
{
  private int userID;
  private String userName;
  private Constants.USER_LEVEL userLevel;

  public int getUserID()
  {
    return this.userID;
  }

  public void setUserID(int userID)
  {
    this.userID = userID;
  }

  public Constants.USER_LEVEL getUserLevel()
  {
    return this.userLevel;
  }

  public void setUserLevel(Constants.USER_LEVEL userLevel)
  {
    this.userLevel = userLevel;
  }

  public String getUserName()
  {
    return this.userName;
  }

  public void setUserName(String userName)
  {
    this.userName = userName;
  }
}


package org.mybatis.weigao.common.util;

import java.text.SimpleDateFormat;

/**
 * Created with IntelliJ IDEA.
 * User: ghm
 * Date: 13-12-1
 * Time: 下午8:00
 * To change this template use File | Settings | File Templates.
 */
public class CommonUtil {

    public static String getCurrentTime(){
        SimpleDateFormat sDateFormat   =   new   SimpleDateFormat("yyyy-MM-dd   hh:mm:ss");
        return sDateFormat.format(new   java.util.Date());
    }

    public static void main(String []args){
        System.out.println(CommonUtil.getCurrentTime());
    }
}

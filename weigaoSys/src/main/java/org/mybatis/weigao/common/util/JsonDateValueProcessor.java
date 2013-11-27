package org.mybatis.weigao.common.util;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

/**
 * Created with IntelliJ IDEA.
 * User: ghm
 * Date: 13-11-26
 * Time: 上午1:24
 * To change this template use File | Settings | File Templates.
 */
public class JsonDateValueProcessor implements JsonValueProcessor {
    private String format = "yyyy-MM-dd HH:mm:ss";

    public JsonDateValueProcessor() {

    }

    public Object processArrayValue(Object o, JsonConfig jsonConfig) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Object processObjectValue(String s, Object o, JsonConfig jsonConfig) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}

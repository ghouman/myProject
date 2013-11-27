package org.mybatis.weigao.common.util;

import net.sf.ezmorph.object.DateMorpher;
import net.sf.ezmorph.object.NumberMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;
import org.mybatis.weigao.domain.SurveyDetail;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: ghm
 * Date: 13-11-26
 * Time: 上午1:20
 * To change this template use File | Settings | File Templates.
 */
public class JsonUtil {

    /**
     * 页面传至后台时，json数据在request的参数名称
     */
    public final static String JSON_ATTRIBUTE = "json";
    public final static String JSON_ATTRIBUTE1 = "json1";
    public final static String JSON_ATTRIBUTE2 = "json2";
    public final static String JSON_ATTRIBUTE3 = "json3";
    public final static String JSON_ATTRIBUTE4 = "json4";

    /**
     * 从一个JSON 对象字符格式中得到一个java对象，形如：
     * {"id" : idValue, "name" : nameValue, "aBean" : {"aBeanId" : aBeanIdValue, ...}}
     *
     * @param --object
     * @param clazz
     * @return
     */
    public static Object getDTO(String jsonString, Class clazz) {
        JSONObject jsonObject = null;
        try {
            setDataFormat2JAVA();
            jsonObject = JSONObject.fromObject(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSONObject.toBean(jsonObject, clazz);
    }

    /**
     * 从一个JSON 对象字符格式中得到一个java对象，其中beansList是一类的集合，形如：
     * {"id" : idValue, "name" : nameValue, "aBean" : {"aBeanId" : aBeanIdValue, ...},
     * beansList:[{}, {}, ...]}
     *
     * @param jsonString
     * @param clazz
     * @param map        集合属性的类型 (key : 集合属性名, value : 集合属性类型class) eg: ("beansList" : Bean.class)
     * @return
     */
    public static Object getDTO(String jsonString, Class clazz, Map map) {
        JSONObject jsonObject = null;
        try {
            setDataFormat2JAVA();
            jsonObject = JSONObject.fromObject(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSONObject.toBean(jsonObject, clazz, map);
    }

    /**
     * 从一个JSON数组得到一个java对象数组，形如：
     * [{"id" : idValue, "name" : nameValue}, {"id" : idValue, "name" : nameValue}, ...]
     *
     * @param --object
     * @param clazz
     * @return
     */
    public static Object[] getDTOArray(String jsonString, Class clazz) {
        setDataFormat2JAVA();
        JSONArray array = JSONArray.fromObject(jsonString);
        Object[] obj = new Object[array.size()];
        for (int i = 0; i < array.size(); i++) {
            JSONObject jsonObject = array.getJSONObject(i);
            JSONUtils.getMorpherRegistry().registerMorpher(new NumberMorpher(Number.class));
            obj[i] = JSONObject.toBean(jsonObject, clazz);
        }
        return obj;
    }

    /**
     * 从一个JSON数组得到一个java对象数组，形如：
     * [{"id" : idValue, "name" : nameValue}, {"id" : idValue, "name" : nameValue}, ...]
     *
     * @param --object
     * @param clazz
     * @param map
     * @return
     */
    public static Object[] getDTOArray(String jsonString, Class clazz, Map map) {
        setDataFormat2JAVA();
        JSONArray array = JSONArray.fromObject(jsonString);
        Object[] obj = new Object[array.size()];
        for (int i = 0; i < array.size(); i++) {
            JSONObject jsonObject = array.getJSONObject(i);
            obj[i] = JSONObject.toBean(jsonObject, clazz, map);
        }
        return obj;
    }

    /**
     * 从一个JSON数组得到一个java对象集合
     *
     * @param ---object
     * @param clazz
     * @return
     */
    public static List getDTOList(String jsonString, Class clazz) {
        setDataFormat2JAVA();
        JSONArray array = JSONArray.fromObject(jsonString);
        List list = new ArrayList();
        for (Iterator iter = array.iterator(); iter.hasNext(); ) {
            JSONObject jsonObject = (JSONObject) iter.next();
            //JSONUtils.getMorpherRegistry().registerMorpher(new NumberMorpher(Number.class));
            //JSONUtils.getMorpherRegistry().registerMorpher(new NumberMorpher(String.class));
            list.add(JSONObject.toBean(jsonObject, clazz));
        }
        return list;
    }

    /**
     * 从一个JSON数组得到一个java对象集合，其中对象中包含有集合属性
     *
     * @param --object
     * @param clazz
     * @param map    集合属性的类型
     * @return
     */
    public static List getDTOList(String jsonString, Class clazz, Map map) {
        setDataFormat2JAVA();
        JSONArray array = JSONArray.fromObject(jsonString);
        List list = new ArrayList();
        for (Iterator iter = array.iterator(); iter.hasNext(); ) {
            JSONObject jsonObject = (JSONObject) iter.next();
            list.add(JSONObject.toBean(jsonObject, clazz, map));
        }
        return list;
    }

    /**
     * 从json HASH表达式中获取一个map，该map支持嵌套功能
     * 形如：{"id" : "johncon", "name" : "小强"}
     * 注意commons-collections版本，必须包含org.apache.commons.collections.map.MultiKeyMap
     *
     * @param --object
     * @return
     */
    public static Map getMapFromJson(String jsonString) {
        setDataFormat2JAVA();
        JSONObject jsonObject = JSONObject.fromObject(jsonString);
        Map map = new HashMap();
        for (Iterator iter = jsonObject.keys(); iter.hasNext(); ) {
            String key = (String) iter.next();
            map.put(key, jsonObject.get(key));
        }
        return map;
    }

    /**
     * 从json数组中得到相应java数组
     * json形如：["123", "456"]
     *
     * @param jsonString
     * @return
     */
    public static Object[] getObjectArrayFromJson(String jsonString) {
        JSONArray jsonArray = JSONArray.fromObject(jsonString);
        return jsonArray.toArray();
    }


    /**
     * 把数据对象转换成json字符串
     * DTO对象形如：{"id" : idValue, "name" : nameValue, ...}
     * 数组对象形如：[{}, {}, {}, ...]
     * map对象形如：{key1 : {"id" : idValue, "name" : nameValue, ...}, key2 : {}, ...}
     *
     * @param object
     * @return
     */
    public static String getJSONString(Object object) throws Exception {
        String jsonString = null;
//日期值处理器
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(java.util.Date.class, new JsonDateValueProcessor());
        if (object != null) {
            if (object instanceof Collection || object instanceof Object[]) {
                jsonString = JSONArray.fromObject(object, jsonConfig).toString();
            } else {
                jsonString = JSONObject.fromObject(object, jsonConfig).toString();
            }
        }
        return jsonString == null ? "{}" : jsonString;
    }

    private static void setDataFormat2JAVA() {
//设定日期转换格式
        JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(new String[]{"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss"}));
    }

    public static void main(String[] arg) throws Exception {
        String s = "{status : 'success'}";
        String jsonArray = "[{\"surveyNo\":\"VES20130220\",\"ahsca\":\"2\",\"aPrice\":\"14444\",\"partID\":\"80\",\"bReUseNote\":\"2\",\"bInstallDate\":\"2013-11-26\"},{\"surveyNo\":\"VES20130220\",\"ahsca\":\"4\",\"aPrice\":\"5\",\"partID\":\"53\",\"bReUseNote\":\"3\",\"bInstallDate\":\"\"}]";
        List<SurveyDetail> list =  JsonUtil.getDTOList(jsonArray, SurveyDetail.class);
        System.out.println(" list size : " + list.size());
        System.out.println(" object : " + JsonUtil.getJSONString(s));
    }
}



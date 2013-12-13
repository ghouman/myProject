package org.mybatis.weigao.security;

import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.AntUrlPathMatcher;
import org.springframework.security.web.util.UrlMatcher;

/**
 * 此类在初始化时，应该取到所有资源及其对应角色的定义
 *
 * @author Robin
 */
public class MyInvocationSecurityMetadataSource
        implements FilterInvocationSecurityMetadataSource {
    private UrlMatcher urlMatcher = new AntUrlPathMatcher();
    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

    public MyInvocationSecurityMetadataSource() {
        loadResourceDefine();
    }

    private void loadResourceDefine() {
        resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
        Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
        //ConfigAttribute ca = new SecurityConfig("系统管理员");
       // ConfigAttribute ca1 = new SecurityConfig("业务员");
        //ConfigAttribute ca2 = new SecurityConfig("大区经理");
        //atts.add(ca);
       // atts.add(ca1);
        //atts.add(ca2);
       // resourceMap.put("/login.jsp", atts);
        //resourceMap.put("/jsp/common/Main.jsp", atts);
        //resourceMap.put("/actions/Catalog.action", atts);

        //数据库权限配置，系统暂不支持
       /* ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SqlSessionFactory sessionFactory = (SqlSessionFactory) context.getBean("sqlSessionFactory");
        SqlSession session = sessionFactory.openSession();
        List<String> query = session.selectList("select RoleName from RoleList_WEB ");
        resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
        Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
        for (String auth : query) {
            ConfigAttribute ca = new SecurityConfig(auth);
            List<String> query1 = session.selectList("select resource_string " + "from Pub_Authorities_Resources,Pub_Resources,  Pub_authorities " + "where  Pub_Authorities_Resources.resource_id=Pub_Resources.resource_id and " + "  Pub_Authorities_Resources.resource_id=Pub_authorities.authority_id  and " + "   Authority_name='" + auth + "'");
            for (String res : query1) {
                String url = res;      // 判断资源文件和权限的对应关系，如果已经存在，要进行增加
                if (resourceMap.containsKey(url)) {
                    Collection<ConfigAttribute> value = resourceMap.get(url);
                    value.add(ca);
                    resourceMap.put(url, value);
                } else {
                    atts.add(ca);
                    resourceMap.put(url, atts);
                }
                resourceMap.put(url, atts);
            }
        }*/
    }

    // According to a URL, Find out permission configuration of this URL.
    public Collection<ConfigAttribute> getAttributes(Object object)
            throws IllegalArgumentException {
        // guess object is a URL.
        String url = ((FilterInvocation) object).getRequestUrl();
        Iterator<String> ite = resourceMap.keySet().iterator();
        while (ite.hasNext()) {
            String resURL = ite.next();
            if (urlMatcher.pathMatchesUrl(url, resURL)) {
                return resourceMap.get(resURL);
            }
        }
        return null;
    }

    public boolean supports(Class<?> clazz) {
        return true;
    }

    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

}

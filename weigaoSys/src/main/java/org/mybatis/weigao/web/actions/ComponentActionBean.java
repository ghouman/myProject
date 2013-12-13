package org.mybatis.weigao.web.actions;

import net.sf.json.JSONObject;
import net.sourceforge.stripes.action.StreamingResolution;
import net.sourceforge.stripes.integration.spring.SpringBean;
import org.mybatis.weigao.service.ComponentService;
import org.mybatis.weigao.service.VPortService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.StringReader;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ghm
 * Date: 13-12-7
 * Time: 下午10:11
 * To change this template use File | Settings | File Templates.
 */
public class ComponentActionBean extends AbstractActionBean {
    @SpringBean
    private transient ComponentService componentService;

    public StreamingResolution getSalesRegionList() {
              List salesRegionList = componentService.getSalesRegionList();
              JSONObject jsonObj = new JSONObject();
              jsonObj.put("salesRegionList", salesRegionList);
              return new StreamingResolution("text", new StringReader(jsonObj.toString()));
          }

}

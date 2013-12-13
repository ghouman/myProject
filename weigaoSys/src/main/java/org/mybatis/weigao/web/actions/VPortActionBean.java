package org.mybatis.weigao.web.actions;

import net.sf.json.JSONObject;
import net.sourceforge.stripes.action.StreamingResolution;
import net.sourceforge.stripes.integration.spring.SpringBean;
import org.apache.log4j.Logger;
import org.mybatis.weigao.domain.VPort;
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
public class VPortActionBean extends AbstractActionBean {
    Logger logger = Logger.getLogger(VPortActionBean.class);
    @SpringBean
    private transient VPortService vPortService;

    public StreamingResolution getProvinceList() {
        List vPortList = vPortService.getProvinceList();

        JSONObject jsonObj = new JSONObject();
        jsonObj.put("vPortList", vPortList);

        HttpServletResponse response = context.getResponse();
        //response.setCharacterEncoding("UTF-8");
        return new StreamingResolution("text", new StringReader(jsonObj.toString()));
    }

    public StreamingResolution getPortList() {
        HttpServletRequest request = context.getRequest();
        String provinceId =  request.getParameter("provinceId");
        List vPortList = null;
        if(provinceId!=null && !"".equals(provinceId)){
            try {
            VPort vPort = new VPort();
                vPort.setProvinceId(provinceId);
            vPortList = vPortService.getPortByProvinceId(vPort);
            } catch (Exception e){
                logger.error("获取城市 Exception:"+e.getMessage());
            }
        }

        JSONObject jsonObj = new JSONObject();
        jsonObj.put("vPortList", vPortList);

        HttpServletResponse response = context.getResponse();
        //response.setCharacterEncoding("UTF-8");
        return new StreamingResolution("text", new StringReader(jsonObj.toString()));
    }
}

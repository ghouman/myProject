package org.mybatis.weigao.web.actions;

import net.sf.json.JSONObject;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.StreamingResolution;
import net.sourceforge.stripes.integration.spring.SpringBean;
import org.mybatis.weigao.domain.Customer;
import org.mybatis.weigao.domain.Salesman;
import org.mybatis.weigao.service.SalesmanService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.StringReader;
import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ghm
 * Date: 13-11-17
 * Time: 下午10:05
 * To change this template use File | Settings | File Templates.
 */

public class SalesmanActionBean extends AbstractActionBean {


    @SpringBean
    private transient SalesmanService salesmanService;

    public StreamingResolution getSalesman() {
        HttpServletRequest request = context.getRequest();
        String managerName = request.getParameter("managerName");

        List<Salesman> salemansList = salesmanService.getSalesmanByManagername(managerName);
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("salemansList", salemansList);

        HttpServletResponse response = context.getResponse();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text;charset=UTF-8");
        return new StreamingResolution("text", new StringReader(jsonObj.toString()));

    }
}

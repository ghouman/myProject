package org.mybatis.weigao.web.actions;

import net.sf.json.JSONObject;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.StreamingResolution;
import net.sourceforge.stripes.integration.spring.SpringBean;
import org.mybatis.weigao.domain.CustomerStaff;
import org.mybatis.weigao.service.CustomerStaffService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.StringReader;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ghm
 * Date: 13-11-17
 * Time: 下午10:05
 * To change this template use File | Settings | File Templates.
 */
public class CustomerStaffActionBean extends AbstractActionBean {


    //private static final String LISTCUSTOMER = "/WEB-INF/jsp/weigao/listCustomer.jsp";

    @SpringBean
    private transient CustomerStaffService customerStaffService;

    private static List<CustomerStaff> customerStaffList;

    private CustomerStaff customerStaff;

    public static List<CustomerStaff> getCustomerStaffList() {
        return customerStaffList;
    }

    public static void setCustomerStaffList(List<CustomerStaff> customerStaffList) {
        CustomerStaffActionBean.customerStaffList = customerStaffList;
    }

    public CustomerStaff getCustomerStaff() {
        return customerStaff;
    }

    public void setCustomerStaff(CustomerStaff customerStaff) {
        this.customerStaff = customerStaff;
    }

    @DefaultHandler
    public ForwardResolution goCustomerStaff() {

        return new ForwardResolution("");
    }

    public StreamingResolution getCustomerStaffByCID() {
        HttpServletRequest request = context.getRequest();
        String customerId = request.getParameter("customerId");
        CustomerStaff customerStaff1 = new CustomerStaff();
        customerStaff1.setCustomerId(customerId);
        customerStaffList = customerStaffService.getCustomerStaff(customerStaff1);
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("customerStaffList", customerStaffList);

        HttpServletResponse response = context.getResponse();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text;charset=UTF-8");
        return new StreamingResolution("text", new StringReader(jsonObj.toString()));

    }

}

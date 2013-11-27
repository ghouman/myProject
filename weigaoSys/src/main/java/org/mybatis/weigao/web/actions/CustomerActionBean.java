package org.mybatis.weigao.web.actions;

import net.sf.json.JSONObject;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.StreamingResolution;
import net.sourceforge.stripes.integration.spring.SpringBean;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidateNestedProperties;
import org.mybatis.weigao.domain.Customer;
import org.mybatis.weigao.domain.CustomerSurvey;
import org.mybatis.weigao.service.CustomerService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ghm
 * Date: 13-11-17
 * Time: 下午10:05
 * To change this template use File | Settings | File Templates.
 */
public class CustomerActionBean extends AbstractActionBean {


    private static final String LISTCUSTOMER = "/WEB-INF/jsp/weigao/listCustomer.jsp";
    private static final String UPDATECUSTOMER = "/WEB-INF/jsp/weigao/updateCustomer.jsp";
    private static final String VIEWCUSTOMER = "/WEB-INF/jsp/weigao/viewCustomer.jsp";

    @SpringBean
    private transient CustomerService customerService;


    private static List<Customer> customerList;


    private Customer customer;

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }



    public ForwardResolution goCustomer() {

        return new ForwardResolution(LISTCUSTOMER);
    }

    @DefaultHandler
    public ForwardResolution listCustomer() {
        customerList = customerService.getCustomer(customer);
        return new ForwardResolution(LISTCUSTOMER);
    }

    public ForwardResolution viewCustomer() throws UnsupportedEncodingException {
        customerList = customerService.getCustomer(customer);
        return new ForwardResolution(VIEWCUSTOMER);
    }

    public StreamingResolution showCustomer() {
        HttpServletRequest request = context.getRequest();
        String customerName = request.getParameter("customerName");
        Customer customer1 = new Customer();
        customer1.setCustomerName(customerName);

        customerList = customerService.getCustomer(customer1);
        int size = customerList.size();
        if(size>20){
            customerList = customerService.getCustomer(customer1).subList(0, 20);//此方法最多显示20条
        }
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("customerList", customerList);

        HttpServletResponse response = context.getResponse();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text;charset=UTF-8");
        return new StreamingResolution("text", new StringReader(jsonObj.toString()));

    }

    public ForwardResolution goUpdateCustomer() {
        HttpServletRequest request = context.getRequest();
        int uid = Integer.parseInt(request.getParameter("uid"));
        Customer customer1 = new Customer();
        customer1.setUid(uid);
        customerList = customerService.getCustomer(customer1);
        customer =  customerList.get(0);
        return new ForwardResolution(UPDATECUSTOMER);
    }

    public Resolution updateCustomer(){
        customerService.updateCustomer(customer);
        return new ForwardResolution(VIEWCUSTOMER);
    }

}

package org.mybatis.weigao.web.actions;

import net.sf.json.JSONObject;
import net.sourceforge.stripes.action.*;
import net.sourceforge.stripes.integration.spring.SpringBean;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidateNestedProperties;
import org.apache.log4j.Logger;
import org.displaytag.pagination.PaginatedList;
import org.mybatis.weigao.common.util.core.domain.PaginatedListHelper;
import org.mybatis.weigao.domain.Customer;
import org.mybatis.weigao.domain.CustomerSurvey;
import org.mybatis.weigao.domain.SysUser;
import org.mybatis.weigao.service.CustomerService;
import org.mybatis.weigao.service.MyUserDetailService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ghm
 * Date: 13-11-17
 * Time: 下午10:05
 * To change this template use File | Settings | File Templates.
 */

public class CustomerActionBean extends AbstractActionBean {

    private static Logger logger = Logger.getLogger(CustomerActionBean.class);
    private static final String LISTCUSTOMER = "/WEB-INF/jsp/weigao/listCustomer.jsp";
    private static final String UPDATECUSTOMER = "/WEB-INF/jsp/weigao/updateCustomer.jsp";
    private static final String VIEWCUSTOMER = "/WEB-INF/jsp/weigao/viewCustomer.jsp";

    @SpringBean
    private transient CustomerService customerService;
    @SpringBean
    private transient MyUserDetailService myUserDetailService;


    private static List<Customer> customerList;
    private PaginatedListHelper paginatedList;

    public PaginatedList getPaginatedList() {
        return paginatedList;
    }

    public void setPaginatedList(PaginatedListHelper paginatedList) {
        this.paginatedList = paginatedList;
    }

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
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Collection collectionAuth = auth.getAuthorities();

        String userName = this.getSysUser().getUserName();

        if (customer == null) {
            customer = new Customer();
        }
        if (collectionAuth.toString().contains("业务员")) {
            customer.setClerk(userName);
        } else if (collectionAuth.toString().contains("区域主管")) {
            customer.setPreparerManager(userName);
        } else if (collectionAuth.toString().contains("大区经理")) {
            customer.setManager(userName);
        } else if (collectionAuth.toString().contains("客服部")||collectionAuth.toString().contains("普通客服")) {
            customer.setManagerEng(userName);
        }
        HttpServletRequest request = context.getRequest();
                /*
                      * 其中request中的page参数为displaytag中的默认当前页数,当然也可以使用*TableTagParameters.SORT_AMOUNT_PAGE来表示当前页数
                      */
        int pageSize;
        if (request.getParameter("pageSize") != null
                && !"".equals(request.getParameter("pageSize"))) {
            pageSize = Integer.parseInt(request.getParameter("pageSize"));
        } else {
            pageSize = 15;
        }
        int page = 1;
        if (request.getParameter("page") != null
                && !"".equals(request.getParameter("page"))) {
            page = Integer.parseInt(request.getParameter("page"));
        } else {
            page = 1;
        }
        int fromIndex = (page - 1) * pageSize;
        int toIndex = fromIndex + pageSize;
        customer.setFromIndex(fromIndex);
        customer.setToIndex(toIndex);

        int listSize = customerService.countCustomerSize(customer);
        if (listSize > 0) {
            customerList = customerService.getCustomer(customer);
        } else {
            customerList = null;
        }
        paginatedList = new PaginatedListHelper();
        ((PaginatedListHelper) paginatedList).setPageNumber(page);
        if (customerList != null && listSize != 0) {
            // System.out.println("getFullListSize: " + ListSize);
            // 总共有多少数据,他会根据所有数目和每页数目自动统计页数
            ((PaginatedListHelper) paginatedList).setFullListSize(listSize);
            ((PaginatedListHelper) paginatedList).setObjectsPerPage(pageSize);
            ((PaginatedListHelper) paginatedList).setList(customerList);
        } else {
            ((PaginatedListHelper) paginatedList).setFullListSize(0);
            ((PaginatedListHelper) paginatedList).setList(null);
        }
        return new ForwardResolution(LISTCUSTOMER);
    }

    public ForwardResolution viewCustomer() {
        HttpServletRequest request = context.getRequest();
        int uid = Integer.parseInt(request.getParameter("uid"));
        Customer customer1 = new Customer();
        customer1.setUid(uid);
        customer = customerService.getCustomer(customer1).get(0);
        return new ForwardResolution(VIEWCUSTOMER);
    }

    public StreamingResolution showCustomer() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Collection collectionAuth = auth.getAuthorities();
        String userName = this.getSysUser().getUserName();
        if (customer == null) {
            customer = new Customer();
        }
        if (collectionAuth.toString().contains("业务员")) {
            customer.setClerk(userName);
        } else if (collectionAuth.toString().contains("区域主管")) {
            customer.setPreparerManager(userName);
        } else if (collectionAuth.toString().contains("大区经理")) {
            customer.setManager(userName);
        } else if (collectionAuth.toString().contains("客服部")) {
            customer.setManagerEng(userName);
        }
        HttpServletRequest request = context.getRequest();
        String customerName = request.getParameter("customerName");
        int size = Integer.parseInt(request.getParameter("size"));//显示多少条
        customer.setCustomerName(customerName);
        customer.setFromIndex(0);
        customer.setToIndex(size); //此方法最多显示前10条


        customerList = customerService.getCustomer(customer);

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
        if (customerList != null) {
            customer = customerList.get(0);
        }
        return new ForwardResolution(UPDATECUSTOMER);
    }

    public Resolution updateCustomer() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Collection collectionAuth = auth.getAuthorities();
        String userName = this.getSysUser().getUserName();
        if (collectionAuth.toString().contains("业务员")) {
            customer.setOperator(userName);
            customer.setClerk(userName);
        }
        customerService.updateCustomer(customer, userName);
        return new ForwardResolution("/WEB-INF/jsp/weigao/redriect.jsp?flag=customer");
    }


    public SysUser getSysUser() {
        SysUser sysUser = (SysUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return sysUser;
    }
}

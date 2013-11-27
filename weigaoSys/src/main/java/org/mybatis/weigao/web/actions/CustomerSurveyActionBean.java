package org.mybatis.weigao.web.actions;

import net.sf.json.JSONObject;
import net.sourceforge.stripes.action.*;
import net.sourceforge.stripes.integration.spring.SpringBean;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidateNestedProperties;
import org.displaytag.pagination.PaginatedList;
import org.displaytag.properties.SortOrderEnum;
import org.mybatis.weigao.domain.Customer;
import org.mybatis.weigao.domain.CustomerSurvey;
import org.mybatis.weigao.domain.SurveyDetail;
import org.mybatis.weigao.service.CustomerSurveyService;

import javax.servlet.http.HttpServletRequest;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: ghm
 * Date: 13-11-17
 * Time: 下午10:05
 * To change this template use File | Settings | File Templates.
 */
public class CustomerSurveyActionBean extends AbstractActionBean {


    private static final String LISTCUSTOMERSURVEY = "/WEB-INF/jsp/weigao/listCustomerSurvey.jsp";
    private static final String VIEWCUSTOMERSURVEY = "/WEB-INF/jsp/weigao/viewCustomerSurvey.jsp";
    private static final String ADDCUSTOMERSURVEY = "/WEB-INF/jsp/weigao/addCustomerSurvey.jsp";
    private static final String LISTCUSTOMER = "/WEB-INF/jsp/weigao/listCustomer.jsp";
    private static final String GOUPDATECUSTOMER = "/WEB-INF/jsp/weigao/updateCustomerSurvey.jsp";

    @SpringBean
    private transient CustomerSurveyService customerSurveyService;

/*    @SpringBean
            private transient CustomerService customerService;*/

    //for 分页
    private String sort = "id";
    private String dir = "asc";
    private int page = 1;

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    private static List<CustomerSurvey> customerSurveys;
    private List<SurveyDetail> surveyDetailList;

    public List<SurveyDetail> getSurveyDetailList() {
        return surveyDetailList;
    }

    public void setSurveyDetailList(List<SurveyDetail> surveyDetailList) {
        this.surveyDetailList = surveyDetailList;
    }

    @ValidateNestedProperties({
            @Validate(field = "surveyNo")
    })
    private CustomerSurvey customerSurvey;

    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CustomerSurvey getCustomerSurvey() {
        return customerSurvey;
    }

    public void setCustomerSurvey(CustomerSurvey customerSurvey) {
        this.customerSurvey = customerSurvey;
    }

    public List<CustomerSurvey> getCustomerSurveys() {
        return customerSurveys;
    }

    public void setCustomerSurveys(List<CustomerSurvey> customerSurveys) {
        this.customerSurveys = customerSurveys;
    }

    public static List<CustomerSurvey> subList(int start, int len) {
        if (start + len > customerSurveys.size()) {
            return customerSurveys.subList(start, customerSurveys.size());
        }
        return customerSurveys.subList(start, start + len);
    }


    public ForwardResolution goCustomer() throws UnsupportedEncodingException {

        return new ForwardResolution(LISTCUSTOMERSURVEY);
    }

    public ForwardResolution goAddCustomerSurvey() {
        String surveyNo = customerSurveyService.getSurveyNo();
        customerSurvey = new CustomerSurvey();
        customerSurvey.setSurveyNo(surveyNo);
        return new ForwardResolution(ADDCUSTOMERSURVEY);
    }

    public ForwardResolution goListCustomer() throws UnsupportedEncodingException {

        return new ForwardResolution(CustomerActionBean.class);
    }

    @DefaultHandler
    public ForwardResolution viewCustomer() throws UnsupportedEncodingException {
        customerSurveys = customerSurveyService.getCustomerSurvey(customerSurvey);
        return new ForwardResolution(LISTCUSTOMERSURVEY);
    }

    //根据 UD 查询客户调研
    public ForwardResolution viewCustomerSurveyByUID() throws UnsupportedEncodingException {
        HttpServletRequest request = context.getRequest();
        int uid = Integer.parseInt(request.getParameter("uid"));
        CustomerSurvey customerSurvey1 = new CustomerSurvey();
        customerSurvey1.setUid(uid);
        customerSurveys = customerSurveyService.getCustomerSurvey(customerSurvey1);
        customerSurvey = customerSurveys.get(0);
        surveyDetailList = customerSurveyService.getSurveyDetail(uid);
        return new ForwardResolution(VIEWCUSTOMERSURVEY);
    }

    //添加客户调研
    public Resolution addCustomerSurvey() {
        customerSurveyService.addCustomerSurvey(customerSurvey);

        return new ForwardResolution(LISTCUSTOMERSURVEY);
    }


    //修改客户调研
    public Resolution updateCustomerSurvey() {
        customerSurveyService.updateCustomerSurvey(customerSurvey);

        return new ForwardResolution(LISTCUSTOMERSURVEY);
    }

    //重定向客户调研修改页面
    public ForwardResolution goUpdateCustomerSurvey() throws UnsupportedEncodingException {
        HttpServletRequest request = context.getRequest();
        int uid = Integer.parseInt(request.getParameter("uid"));
        CustomerSurvey customerSurvey1 = new CustomerSurvey();
        customerSurvey1.setUid(uid);
        customerSurveys = customerSurveyService.getCustomerSurvey(customerSurvey1);
        customerSurvey = customerSurveys.get(0);
        surveyDetailList = customerSurveyService.getSurveyDetail(uid);
        return new ForwardResolution(GOUPDATECUSTOMER);
    }


    //更新客户调研状态
    public Resolution updateCustomerStatus() {
        HttpServletRequest request = context.getRequest();
        int uid = Integer.parseInt(request.getParameter("uid"));
        String checked = request.getParameter("checked");
        String submit = request.getParameter("submit");
        String verify = request.getParameter("verify");
        String surveyNo = request.getParameter("surveyNo");
        CustomerSurvey customerSurvey1 = new CustomerSurvey();

        customerSurvey1.setUid(uid);
        customerSurvey1.setChecked(checked);
        customerSurvey1.setSubmit(submit);
        customerSurvey1.setVerify(verify);
        customerSurvey1.setSurveyNo(surveyNo);
        customerSurveyService.updateCustomerSurveyStatus(customerSurvey1);
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("customerSurvey", customerSurvey1);
        return new StreamingResolution("text", new StringReader(jsonObj.toString()));
    }

    class FirstnameComparator implements Comparator<CustomerSurvey> {

        public int compare(CustomerSurvey o1, CustomerSurvey o2) {
            return o1.getCustomer().compareTo(o2.getCustomer());
        }
    }

    class LastnameComparator implements Comparator<CustomerSurvey> {

        public int compare(CustomerSurvey o1, CustomerSurvey o2) {
            return o1.getPreparer().compareTo(o2.getPreparer());
        }
    }

    class ResultList implements PaginatedList {

        public List getList() {
            List<CustomerSurvey> list = customerSurveys.subList((getPageNumber() - 1) * getObjectsPerPage(), getObjectsPerPage());

            if (getSortCriterion().equals("customer")) {
                Collections.sort(list, new FirstnameComparator());
            } else if (getSortCriterion().equals("preparer")) {
                Collections.sort(list, new LastnameComparator());
            }
            if (getSortDirection().equals(SortOrderEnum.DESCENDING)) {
                Collections.reverse(list);
            }

            return list;
        }

        public int getPageNumber() {
            return page;
        }

        public int getObjectsPerPage() {
            return 20;
        }

        public int getFullListSize() {
            return customerSurveys.size();
        }

        public String getSortCriterion() {
            return sort;
        }

        public SortOrderEnum getSortDirection() {
            if (dir.equals("desc")) {
                return SortOrderEnum.DESCENDING;
            }
            return SortOrderEnum.ASCENDING;
        }

        public String getSearchId() {
            return null;
        }
    }
}

package org.mybatis.weigao.web.actions;

import net.sf.json.JSONObject;
import net.sourceforge.stripes.action.*;
import net.sourceforge.stripes.integration.spring.SpringBean;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidateNestedProperties;
import org.apache.log4j.Logger;
import org.displaytag.pagination.PaginatedList;
import org.mybatis.weigao.common.util.core.domain.PaginatedListHelper;
import org.mybatis.weigao.domain.*;
import org.mybatis.weigao.service.CustomerSurveyService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletRequest;
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

public class CustomerSurveyActionBean extends AbstractActionBean {

    private static Logger logger = Logger.getLogger(CustomerSurveyActionBean.class);
    private static final String LISTCUSTOMERSURVEY = "/WEB-INF/jsp/weigao/listCustomerSurvey.jsp";
    private static final String VIEWCUSTOMERSURVEY = "/WEB-INF/jsp/weigao/viewCustomerSurvey.jsp";
    private static final String ADDCUSTOMERSURVEY = "/WEB-INF/jsp/weigao/addCustomerSurvey.jsp";
    private static final String LISTCUSTOMER = "/WEB-INF/jsp/weigao/listCustomer.jsp";
    private static final String GOUPDATECUSTOMER = "/WEB-INF/jsp/weigao/updateCustomerSurvey.jsp";
    private static final String SIGNON = "/login.jsp";

    @SpringBean
    private transient CustomerSurveyService customerSurveyService;

/*    @SpringBean
            private transient CustomerService customerService;*/

    //for 分页
    private String sort = "id";
    private String dir = "asc";
    private int page = 1;

    private PaginatedListHelper paginatedList;

    public PaginatedList getPaginatedList() {
        return paginatedList;
    }

    public void setPaginatedList(PaginatedListHelper paginatedList) {
        this.paginatedList = paginatedList;
    }

    public CustomerSurveyService getCustomerSurveyService() {
        return customerSurveyService;
    }

    public void setCustomerSurveyService(CustomerSurveyService customerSurveyService) {
        this.customerSurveyService = customerSurveyService;
    }

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

    public ForwardResolution goCustomer() throws UnsupportedEncodingException {

        return new ForwardResolution(LISTCUSTOMERSURVEY);
    }

    public ForwardResolution goAddCustomerSurvey() {
       /* String surveyNo = customerSurveyService.getSurveyNo();
        customerSurvey = new CustomerSurvey();
        customerSurvey.setSurveyNo(surveyNo);*/
        return new ForwardResolution(ADDCUSTOMERSURVEY);
    }

    public ForwardResolution goListCustomer() {
        return new ForwardResolution(CustomerActionBean.class);
    }

    @DefaultHandler
    public ForwardResolution viewCustomer() throws UnsupportedEncodingException {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Collection collectionAuth = auth.getAuthorities();
        logger.debug("collectionAuth:" + collectionAuth + " name:" + auth.getName() + " viewCustomer ");
        if (customerSurvey == null) {
            customerSurvey = new CustomerSurvey();
        }
        if (collectionAuth.toString().contains("业务员")) {
            customerSurvey.setPreparer(auth.getName());
        } else if (collectionAuth.toString().contains("区域主管")) {
            customerSurvey.setPreparerManager(auth.getName());
        } else if (collectionAuth.toString().contains("大区经理")) {
            customerSurvey.setManager(auth.getName());
        } else if (collectionAuth.toString().contains("客服部")) {
            customerSurvey.setManagerEng(auth.getName());
        }
        if(customerSurvey.getChecked()==null){
            customerSurvey.setChecked("0");//默认为否
        } else if ("否".equals(customerSurvey.getChecked())) {
            customerSurvey.setChecked("0");
        } else if ("是".equals(customerSurvey.getChecked())) {
            customerSurvey.setChecked("1");
        } else if ("all".equals(customerSurvey.getChecked())){
            customerSurvey.setChecked(null);
        }
        if ("否".equals(customerSurvey.getSubmit())) {
            customerSurvey.setSubmit("0");
        } else if ("是".equals(customerSurvey.getSubmit())) {
            customerSurvey.setSubmit("1");
        }
        if ("否".equals(customerSurvey.getVerify())) {
            customerSurvey.setVerify("0");
        } else if ("是".equals(customerSurvey.getVerify())) {
            customerSurvey.setVerify("1");
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

        // 获得每次查询的总记录数
        int ListSize = customerSurveyService.countSurveySize(customerSurvey);//DAO中实现
        // 此页要显示的list数据
        customerSurvey.setFromIndex(fromIndex);
        customerSurvey.setToIndex(toIndex);
        if (ListSize > 0) {
            customerSurveys = customerSurveyService.getCustomerSurvey(customerSurvey);
        } else {
            customerSurveys = null;
        }
        paginatedList = new PaginatedListHelper();
        ((PaginatedListHelper) paginatedList).setPageNumber(page);
        if (customerSurveys != null && ListSize != 0) {
            // System.out.println("getFullListSize: " + ListSize);
            // 总共有多少数据,他会根据所有数目和每页数目自动统计页数
            ((PaginatedListHelper) paginatedList).setFullListSize(ListSize);
            ((PaginatedListHelper) paginatedList).setObjectsPerPage(pageSize);
            ((PaginatedListHelper) paginatedList).setList(customerSurveys);
        } else {
            ((PaginatedListHelper) paginatedList).setFullListSize(0);
            ((PaginatedListHelper) paginatedList).setList(null);
        }
        // 如果你只设定这几个参数,那么其余的参数将会默认为你实现类中所赋的初值
        // 最后,你还需要将这个实例放入到request或session中去,好让displaytag知道这个是外部分页
        //request.setAttribute("list",paginatedList);
        //request.setAttribute("resultSize",ListSize);


        return new ForwardResolution(LISTCUSTOMERSURVEY);
    }

    //根据 UD 查询客户调研
    public ForwardResolution viewCustomerSurveyByUID() {
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
        //SysUser sysUser = this.getSysUser();
        /*if(sysUser == null){
            return new ForwardResolution(SIGNON);
        }*/
        if(customerSurvey==null){
            customerSurvey = new CustomerSurvey();
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        customerSurvey.setCreator(auth.getName());
        customerSurvey.setPreparer(auth.getName());
        try {
            customerSurveyService.addCustomerSurvey(customerSurvey);
        } catch (Exception e) {
            logger.error("添加客户调研异常：" + e.getMessage());
            if(e.getMessage().indexOf("IX_oSurvey")>-1){
                return new ForwardResolution("/WEB-INF/jsp/weigao/redriect.jsp?flag=addCustomerSurveyFail_IX");
            }
            return new ForwardResolution("/WEB-INF/jsp/weigao/redriect.jsp?flag=addCustomerSurveyFail");
        }

        return new ForwardResolution("/WEB-INF/jsp/weigao/redriect.jsp?flag=customerSurvey");
    }


    //修改客户调研
    public Resolution updateCustomerSurvey() {
/*        SysUser sysUser = this.getSysUser();
        if(sysUser == null){
            return new ForwardResolution(SIGNON);
        }*/
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Collection collectionAuth = auth.getAuthorities();
        customerSurvey.setOperator(auth.getName());

        customerSurveyService.updateCustomerSurvey(customerSurvey);
        if (collectionAuth.toString().contains("业务员")) {
            customerSurvey.setPreparer(auth.getName());
        }
        return new ForwardResolution("/WEB-INF/jsp/weigao/redriect.jsp?flag=customerSurvey");
    }

    //重定向客户调研修改页面
    public ForwardResolution goUpdateCustomerSurvey() throws UnsupportedEncodingException {
       /* SysUser sysUser = this.getSysUser();
        if(sysUser == null){
            return new ForwardResolution(SIGNON);
        }*/
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
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Collection collectionAuth = auth.getAuthorities();
        String name = auth.getName();

        HttpServletRequest request = context.getRequest();
        int uid = Integer.parseInt(request.getParameter("uid"));
        String checked = request.getParameter("checked");
        String submit = request.getParameter("submit");
        String verify = request.getParameter("verify");
        String surveyNo = request.getParameter("surveyNo");
        String submitMemo = request.getParameter("submitMemo");
        String verifyMemo = request.getParameter("verifyMemo");
        String returnCheckRemark = request.getParameter("returnCheckRemark");
        CustomerSurvey customerSurvey1 = new CustomerSurvey();
        customerSurvey1.setOperator(name);

        if (collectionAuth.toString().contains("业务员")) {
            customerSurvey1.setChecked(checked);
            customerSurvey1.setChecker(name);
        } else if (collectionAuth.toString().contains("区域主管")) {
            if (checked != null) {
                customerSurvey1.setChecked(checked);
                customerSurvey1.setChecker(name);
            } else if (submit != null) {
                customerSurvey1.setSubmit(submit);
                customerSurvey1.setSubmitMemo(submitMemo);
                customerSurvey1.setSubmitUser(name);
            } else if (returnCheckRemark != null) {
                customerSurvey1.setReturnCheck("true");
                customerSurvey1.setSubmitMemo(returnCheckRemark);
                customerSurvey1.setSubmitUser(name);
            }
        } else if (collectionAuth.toString().contains("大区经理") || collectionAuth.toString().contains("客服部")) {
            if (returnCheckRemark != null) {
                customerSurvey1.setReturnCheck("true");
                customerSurvey1.setSubmitMemo(returnCheckRemark);
            } else {
                customerSurvey1.setSubmit(submit);
                customerSurvey1.setSubmitMemo(submitMemo);
            }
            customerSurvey1.setSubmitUser(name);
        } else if (collectionAuth.toString().contains("系统管理员")) {
            if (returnCheckRemark != null) {
                customerSurvey1.setReturnCheck("true");
                customerSurvey1.setVerifyMemo(returnCheckRemark);
            } else {
                customerSurvey1.setVerify(verify);
                customerSurvey1.setVerifyMemo(verifyMemo);
            }
            customerSurvey1.setVerifier(name);
        }
        customerSurvey1.setUid(uid);
        customerSurvey1.setSurveyNo(surveyNo);
        customerSurveyService.updateCustomerSurveyStatus(customerSurvey1);
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("customerSurvey", customerSurvey1);
        return new StreamingResolution("text", new StringReader(jsonObj.toString()));
    }

    public Resolution getSurveyNo() { //获取当前最新调研编号
        String surveyNo = customerSurveyService.getSurveyNo();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("surveyNo", surveyNo);
        return new StreamingResolution("text", new StringReader(jsonObj.toString()));
    }


    public Resolution getNoCheckCount() { //获取未提交订单数量
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Collection collectionAuth = auth.getAuthorities();
        String name = auth.getName();
        CustomerSurvey customerSurvey1 = new CustomerSurvey();
        if (collectionAuth.toString().contains("业务员")) {
            customerSurvey1.setPreparer(name);
            customerSurvey1.setChecked("0");
        }
        int size = customerSurveyService.countSurveySize(customerSurvey1);
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("size", size);
        return new StreamingResolution("text", new StringReader(jsonObj.toString()));
    }

    public void clear() {
        customer = new Customer();
        customerSurvey = new CustomerSurvey();

    }
}

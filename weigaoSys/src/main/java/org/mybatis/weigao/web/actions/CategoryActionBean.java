package org.mybatis.weigao.web.actions;

import net.sf.json.JSONObject;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.StreamingResolution;
import net.sourceforge.stripes.integration.spring.SpringBean;
import org.mybatis.weigao.domain.Category;
import org.mybatis.weigao.domain.CustomerStaff;
import org.mybatis.weigao.service.CategoryService;
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
public class CategoryActionBean extends AbstractActionBean {


    //private static final String LISTCUSTOMER = "/WEB-INF/jsp/weigao/listCustomer.jsp";

    @SpringBean
    private transient CategoryService categoryService;

    private List<Category> categoryList;

    private Category category;

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @DefaultHandler
    public ForwardResolution goCustomerStaff() {

        return new ForwardResolution("");
    }

    //获取所有产品类别
    public StreamingResolution getAllCategory() {
        HttpServletRequest request = context.getRequest();
        String plate = request.getParameter("plate");
        categoryList = categoryService.getAllCategory(plate);

        JSONObject jsonObj = new JSONObject();
        jsonObj.put("categoryList", categoryList);

        HttpServletResponse response = context.getResponse();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text;charset=UTF-8");
        return new StreamingResolution("text", new StringReader(jsonObj.toString()));

    }

    //获取所有产品品牌
    public StreamingResolution getBrandByCID() {
        HttpServletRequest request = context.getRequest();
        String categoryId = request.getParameter("categoryId");
        categoryList = categoryService.getBrandByCategoryId(categoryId);
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("brandList", categoryList);

        HttpServletResponse response = context.getResponse();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text;charset=UTF-8");
        return new StreamingResolution("text", new StringReader(jsonObj.toString()));
    }

    //获取所有品牌规格
    public StreamingResolution getFamilyByBID() {
        HttpServletRequest request = context.getRequest();
        String brandId = request.getParameter("brandId");
        categoryList = categoryService.getFamilyByBrandId(brandId);
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("familyList", categoryList);

        HttpServletResponse response = context.getResponse();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text;charset=UTF-8");
        return new StreamingResolution("text", new StringReader(jsonObj.toString()));
    }

    //获取所有规格型号
    public StreamingResolution getPartNoByFID() {
        HttpServletRequest request = context.getRequest();
        String familyId = request.getParameter("familyId");
        categoryList = categoryService.getPartNoByFamilyId(familyId);
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("partNoList", categoryList);

        HttpServletResponse response = context.getResponse();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text;charset=UTF-8");
        return new StreamingResolution("text", new StringReader(jsonObj.toString()));
    }
}

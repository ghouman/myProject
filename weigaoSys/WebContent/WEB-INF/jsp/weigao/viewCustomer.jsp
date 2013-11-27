<%@ include file="../common/IncludeTop.jsp" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<script src="../js/weigao/updateCustomerSurvey.js"></script>
<%--
<link href="../displayTag/css/maven-base.css" rel="stylesheet">
<link href="../displayTag/css/maven-theme.css" rel="stylesheet">
<link href="../displayTag/css/site.css" rel="stylesheet">
<link href="../displayTag/css/screen.css" rel="stylesheet">
--%>
<style type="text/css">
</style>
<div class="container">

    <ol class="breadcrumb">
        <li><a href="#">客户详细信息</a></li>
        <li><a href="Customer.action">返回</a></li>
    </ol>
</div>
<div class="container">
    <div style="display: none">
        <input type="text" value="${actionBean.customer.uid}" id="customerId"/>
    </div>
    <%--<stripes:form beanclass="org.mybatis.weigao.web.actions.CustomerActionBean" class="form-inline"> --%>
        <table class="table table-bordered">
            <tr>
                <th>客户名称：</th>
                <td>${actionBean.customer.customerName}</td>
                <th>所属医院：</th>
                <td>${actionBean.customer.zect}</td>
                <th>客户类型：</th>
                <td>${actionBean.customer.custVal}</td>
            </tr>
            <tr>
                <th>客户地址：</th>
                <td>${actionBean.customer.address}</td>
                <th>所在城市：</th>
                <td>${actionBean.customer.port}</td>
                <th>客户网址：</th>
                <td>${actionBean.customer.website}</td>
            </tr>
            <tr>
                <th>业务员：</th>
                <td>${actionBean.customer.clerk}</td>
                <th>销售大区：</th>
                <td>${actionBean.customer.salesRegion}</td>
                <th>行政等级：</th>
                <td>${actionBean.customer.hierarchy}</td>
            </tr>
            <tr>
                <th>合作时间：</th>
                <td>${actionBean.customer.coop_DT}</td>
                <th>邮编：</th>
                <td>${actionBean.customer.postalCode}</td>
                <th>医院等级：</th>
                <td>${actionBean.customer.healthClass}</td>
            </tr>
        </table>
    <hr/>
    <!--相关负责人-->
    <table class="table table-bordered">
        <tbody>
        <tr>
            <th width='15%'>负责人：</th>

            <th width='15%'>职务：</th>

            <th width='15%'>联系方式：</th>

            <th width='15%'>决策范围：</th>

            <th width='20%'>个人爱好：</th>

            <th width='20%'>学术影响力：</th>

        </tr>
        <tr id="tr_customerStaff"></tr>
        </tbody>
    </table>
    <hr/>
    <%--</stripes:form> --%>
</div>
<%@ include file="../common/IncludeBottom.jsp" %>

<script type="text/javascript">

</script>



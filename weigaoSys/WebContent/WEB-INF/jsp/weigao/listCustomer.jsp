<%@ include file="../common/IncludeTop.jsp" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%--
<link href="../displayTag/css/maven-base.css" rel="stylesheet">
<link href="../displayTag/css/maven-theme.css" rel="stylesheet">
<link href="../displayTag/css/site.css" rel="stylesheet">
<link href="../displayTag/css/screen.css" rel="stylesheet">
--%>
<style type="text/css">
    span.pagebanner {
        background-color: #eee;
        border: 1px dotted #999;
        padding: 2px 4px 2px 4px;
        width: 100%;
        margin-top: 10px;
        display: block;
        border-bottom: none;
    }

    span.pagelinks {
        background-color: #eee;
        border: 1px dotted #999;
        padding: 2px 4px 2px 4px;
        width: 100%;
        display: block;
        border-top: none;
    }
</style>
<div class="container">


    <ol class="breadcrumb">
        <li><a href="#">客户选择</a></li>
    </ol>

    <stripes:form beanclass="org.mybatis.weigao.web.actions.CustomerActionBean" class="form-inline">

        <div class="form-group" style="margin-bottom: 10px">
            <label for="customerName">客户名称:</label>
            <stripes:text name="customer.customerName" class="form-control" id="customerName"/>
            <label for="salesRegion" style="margin-left: 5px" >销售大区:</label>
            <stripes:text name="customer.salesRegion" class="form-control" id="salesRegion"/>
        </div>
        <div class="form-group" style="margin-bottom: 10px">
            <label for="clerk">负责专员:</label>
            <stripes:text name="customer.clerk" class="form-control" id="clerk"/>
            <label for="port" style="margin-left: 5px" >所在城市:</label>
            <stripes:text name="customer.port" class="form-control" id="port"/>
            <stripes:submit name="listCustomer" value="查询" id="query" class="btn btn-primary" style="margin-left: 5px"/>
        </div>
    </stripes:form>

    <display:table id="row" defaultsort="1" pagesize="30" sort="external" name="actionBean.customerList"
                   requestURI="Customer.action" class="table table-striped">
        <%--
        <display:column title="选择" scope="request">
            <input type="radio" name="uid" value="${row.uid}" onclick="getValue(this)">
        </display:column>       --%>
        <display:column property="customerName" title="客户名称"/>
        <display:column property="zect" sortable="false" sortName="customerName" title="所属医院"/>
        <display:column property="custVal" sortable="false" sortName="customerName" title="客户类型"/>
        <display:column property="address" title="客户地址"/>
        <display:column property="port" title="所在城市"/>
        <display:column property="clerk" title="业务员"/>
        <display:column property="salesRegion" title="销售大区"/>
        <display:column title="操作">

            <stripes:link class="btn btn-link" beanclass="org.mybatis.weigao.web.actions.CustomerActionBean"
                             event="goUpdateCustomer">
                   修改
                   <stripes:param name="uid" value="${row.uid}"/>
            </stripes:link>
        </display:column>
    </display:table>

</div>
</div>

<%@ include file="../common/IncludeBottom.jsp" %>

<script type="text/javascript">
    $(function () {

    })

    function getValue(obj) {
        alert(obj.value);
    }


</script>



<%@ include file="../common/IncludeTop.jsp" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
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
        <li><a href="#">修改客户信息</a></li>
    </ol>
</div>
<div class="container">
    <stripes:form beanclass="org.mybatis.weigao.web.actions.CustomerActionBean" class="form-inline">
        <table class="table table-bordered">
            <tr>
                 <th>客户名称：</th>
                 <td><input type="text" name="customer.customerName" class="form-control" id="customerName"  placeholder="请输入客户名称"
        value="${actionBean.customer.customerName}" required>
        <%--<stripes:text name="customer.customerName" class="form-control" id="customerName"/>--%></td>
 <th>所属医院：</th>
 <td><input type="text" name="customer.zect" class="form-control" id="zect"  placeholder="请输入所属医院"
        value="${actionBean.customer.zect}" required>
        <%--<stripes:text name="customer.zect" class="form-control" id="zect"/>--%></td>
 <th>客户类型：</th>
 <td><stripes:select name="customer.custVal" id="custVal" class="form-control">
        <stripes:option value="现有客户">现有客户</stripes:option>
        <stripes:option value="近期潜在客户">近期潜在客户</stripes:option>
        <stripes:option value="远期潜在客户">远期潜在客户</stripes:option>
        <stripes:option value="其他">其他</stripes:option>
     </stripes:select>
     <%--<stripes:text name="customer.custVal" class="form-control" id="custVal"/>--%></td>
</tr>
<tr>
<th>客户地址：</th>
<td><stripes:text name="customer.address" class="form-control" id="address"/></td>
<th>所在城市：</th>
<td><stripes:text name="customer.port" class="form-control" id="port"/></td>
<th>客户网址：</th>
<td><stripes:text name="customer.website" class="form-control" id="website"/></td>
</tr>
<tr>
<th>业务员：</th>
<td><stripes:text name="customer.clerk" class="form-control" id="clerk"/></td>
<th>销售大区：</th>
<td><%--<select id="salesRegion" name="customer.salesRegion" class="form-control">
    <option value="原销售大区" selected="selected">"${actionBean.customer.salesRegion}"</option>
    <%
        List<salesRegion > list= testBizImpl.getAllTest();
        for(int i=0;i<list.size();i++){ %>
    <option value="<%=list.get(i).getId() %>">
        <%=list.get(i).getName() %>
    </option>
    <%  }    %>
    </select>--%>
        <input type="text" name="customer.salesRegion" class="form-control" id="salesRegion"  placeholder="请输入销售大区"
            value="${actionBean.customer.salesRegion}" required>
        <%--<stripes:text name="customer.salesRegion" class="form-control" id="salesRegion"/>--%></td>
<th>行政等级：</th>
<td><stripes:select name="customer.hierarchy" id="hierarchy" class="form-control">
        <stripes:option value="省部级">省部级</stripes:option>
        <stripes:option value="地市级">地市级</stripes:option>
        <stripes:option value="区县级">区县级</stripes:option>
        <stripes:option value="其他">其他</stripes:option>
    </stripes:select>
        <%--<stripes:text name="customer.hierarchy" class="form-control" id="hierarchy"/>--%></td>
   </tr>
   <tr>
   <th>合作时间：</th>
    <td><stripes:text name="customer.coop_DT" class="form-control" id="coop_DT"/></td>
    <th>邮编：</th>
    <td><stripes:text name="customer.postalCode" class="form-control" id="postalCode"/></td>
    <th>医院等级：</th>
    <td><stripes:select name="customer.healthClass" id="healthClass" class="form-control">
        <stripes:option value="三甲">三甲</stripes:option>
        <stripes:option value="三乙">三乙</stripes:option>
        <stripes:option value="三丙">三丙</stripes:option>
        <stripes:option value="二甲">二甲</stripes:option>
        <stripes:option value="二乙">二乙</stripes:option>
        <stripes:option value="二丙">二丙</stripes:option>
        <stripes:option value="一甲">一甲</stripes:option>
        <stripes:option value="一乙">一乙</stripes:option>
        <stripes:option value="一丙">一丙</stripes:option>
        <stripes:option value="其他">其他</stripes:option>
    </stripes:select>
    <%--<stripes:text name="customer.healthClass" class="form-control" id="healthClass"/>--%></td>
   </tr>
   </table>
   <div style="display: none">
   <stripes:text name="customer.uid" class="form-control" id="uid"/>
   <stripes:text name="customer.disable" class="form-control" id="disable"/>
   <stripes:text name="customer.creator" class="form-control" id="creator"/>
   <stripes:text name="customer.creationDate" class="form-control" id="creationDate"/>
   <stripes:text name="customer.operator" class="form-control" id="operator"/>
   <stripes:text name="customer.feedback" class="form-control" id="feedback"/>
   <stripes:text name="customer.healtMemo" class="form-control" id="healtMemo"/>
   <stripes:text name="customer.openDt" class="form-control" id="openDt"/>
   <stripes:text name="customer.portID" class="form-control" id="portID"/>
   <stripes:text name="customer.clerk" class="form-control" id="clerk"/>
   <stripes:text name="customer.labOffice" class="form-control" id="labOffice"/>
   <stripes:text name="customer.labOMemo" class="form-control" id="labOMemo"/>
   <stripes:text name="customer.labTEL" class="form-control" id="labTEL"/>
   <stripes:text name="customer.hospitalMemo" class="form-control" id="hospitalMemo"/>
   <stripes:text name="customer.active" class="form-control" id="active"/>
   <stripes:text name="customer.direct" class="form-control" id="direct"/>
   <stripes:text name="customer.chargeLimit" class="form-control" id="chargeLimit"/>
   <stripes:text name="customer.verifier" class="form-control" id="verifier"/>
   <stripes:text name="customer.verifyDate" class="form-control" id="verifyDate"/>
   </div>
   <stripes:submit name="updateCustomer" value="修改" id="query" class="btn btn-primary"
   style="margin-left: 5px"/>
   </stripes:form>
   </div>
   <%@ include file="../common/IncludeBottom.jsp" %>





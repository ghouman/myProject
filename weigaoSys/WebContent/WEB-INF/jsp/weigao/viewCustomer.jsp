<%@ include file="../common/IncludeTop.jsp" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<script src="../js/weigao/customerCommon.js"></script>

<%--
<link href="../displayTag/css/maven-base.css" rel="stylesheet">
<link href="../displayTag/css/maven-theme.css" rel="stylesheet">
<link href="../displayTag/css/site.css" rel="stylesheet">
<link href="../displayTag/css/screen.css" rel="stylesheet">
--%>
<style type="text/css">
</style>
<div class="container">

    <ol class="breadcrumb" style="margin-top: 5px">
        <li><a href="#">客户详细信息</a></li>
        <li><a href="javascript:history.go(-1);">返回<i class="icon-share-alt"></i></a>
    </ol>
</div>
<div class="container">
    <div style="display: none">
        <input type="text" value="${actionBean.customer.uid}" id="customerId"/>
    </div>
    <%--<stripes:form beanclass="org.mybatis.weigao.web.actions.CustomerActionBean" class="form-inline"> --%>
    <table class="table table-bordered">
        <tr>
            <th width=80>客户名称：</th>
            <td  width="25%">${actionBean.customer.customerName}</td>
            <th width=105>组织机构代码：</th>
            <td  width="25%">${actionBean.customer.zect}</td>
            <th width=80>客户类型：</th>
            <td>${actionBean.customer.custVal}</td>
        </tr>
        <tr>
            <th>客户地址：</th>
            <td>${actionBean.customer.address}</td>
            <th>所在城市：</th>
            <td>${actionBean.customer.port}</td>
            <th>所属省份：</th>
            <td>${actionBean.customer.province}</td>

        </tr>
        <tr>
            <th>客户网址：</th>
            <td>
                <c:if test="${actionBean.customer.website!='-' and fn:substring(actionBean.customer.website, 0, 4)!='http'}">
                    <a href="http://${actionBean.customer.website}" target="_blank">${actionBean.customer.website}</a>
                </c:if>
                <c:if test="${actionBean.customer.website!='-' and fn:substring(actionBean.customer.website, 0, 4)=='http'}">
                    <a href="${actionBean.customer.website}" target="_blank">${actionBean.customer.website}</a>
                </c:if>
                <c:if test="${actionBean.customer.website=='-'}">${actionBean.customer.website}</c:if>
            </td>
            <th>负责专员：</th>
            <td>${actionBean.customer.clerk}</td>
            <th>销售大区：</th>
            <td>${actionBean.customer.salesRegion}</td>

        </tr>
        <tr>
            <th>大区经理：</th>
            <td>${actionBean.customer.manager }</td>
            <th>区域主管：</th>
            <td>${actionBean.customer.salesFloor }</td>
            <th>医院等级：</th>
            <td>${actionBean.customer.healthClass}</td>
        </tr>
        <tr>
            <th>行政级别：</th>
            <td>${actionBean.customer.hierarchy}</td>
            <th>执业许可证：</th>
            <td>${actionBean.customer.coop_DT}</td>
            <th>邮编：</th>
            <td>${actionBean.customer.postalCode}</td>

        </tr>
        <tr>
            <th>所属科室：</th>
            <td>
                ${actionBean.customer.labOffice}
            </td>
            <th>血透室电话：</th>
            <td>
                ${actionBean.customer.labTEL}
            </td>
            <th>是否审核：</th>
            <td>
                ${actionBean.customer.verify}
            </td>
        </tr>
        <tr>
            <th>医院信息：</th>
            <td colspan="5" style="height: 50px">
                ${actionBean.customer.hospitalMemo}
            </td>
        </tr>
    </table>
    <hr/>
    <!--相关负责人-->
    <table class="table table-bordered">
        <tbody>
        <tr>
            <th width='10%'>负责人：</th>

            <th width='15%'>职务：</th>

            <th width='10%'>联系方式：</th>

            <th width='15%'>决策范围：</th>

            <th width='20%'>个人爱好：</th>

            <th width='20%'>学术影响力：</th>
            <th width='10%'>身份证/生日：</th>

        </tr>
        <tr id="tr_customerStaff"></tr>
        </tbody>
    </table>

    <hr/>

    <%--</stripes:form> --%>
</div>
<%@ include file="../common/IncludeBottom.jsp" %>

<script type="text/javascript">
    var uid = $("#customerId").val();
    loadStaffInfo(uid);
</script>



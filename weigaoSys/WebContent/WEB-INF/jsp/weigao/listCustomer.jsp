<%@ include file="../common/IncludeTop.jsp" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<link href="../css/magicsuggest-1.3.1.css" rel="stylesheet">
<script src="../js/common/magicsuggest-1.3.1.js"></script>
<script src="../js/weigao/wegoCommon.js"></script>

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

    .form-control {
        width: 180px;
    }
</style>
<div class="container">

    <input type="hidden" id="page" value="customerList">
    <ol class="breadcrumb" style="margin-top: 5px">
        <li><a href="#">客户名单列表</a></li>
    </ol>

    <stripes:form beanclass="org.mybatis.weigao.web.actions.CustomerActionBean" class="form-inline">


        <table class="table-condensed">
            <tr>
                <td><label for="customerName">客户名称:</label></td>
                <td><stripes:text name="customer.customerName" class="form-control" id="customerName"/></td>

                <td><label for="preparerManager" >区域主管:</label></td>
                <td><stripes:text name="customer.preparerManager" class="form-control" id="preparerManager"/></td>
                <td><label for="clerk" >负责专员:</label></td>
                <td><stripes:text name="customer.clerk" class="form-control" id="clerk"/></td>
                <td></td>
            </tr>
            <tr>
                <td><label for="salesRegion" >销售大区:</label></td>

                <td><stripes:text name="customer.salesRegion" class="form-control" id="salesRegion"/>
                </td>
                <td><label for="province">所在省份:</label></td>
                <td><stripes:text name="customer.province" class="form-control" id="province"/></td>
                <td><label for="port" >所在城市:</label></td>
                <td><stripes:text name="customer.port" class="form-control" id="port"/></td>
                <td>    <stripes:submit name="listCustomer" value="查询" id="query" class="btn btn-primary"
                                    style="margin-left: 5px"/></td>


            </tr>
        </table>

        <div class="form-group" style="margin-bottom: 10px">

        </div>

    </stripes:form>

    <display:table id="row" defaultsort="1" pagesize="15" sort="external" name="actionBean.paginatedList"
                   requestURI="Customer.action" class="table table-striped" export="false">
        <%--
        <display:column title="选择" scope="request">
            <input type="radio" name="uid" value="${row.uid}" onclick="getValue(this)">
        </display:column>       --%>
        <display:column property="customerName" title="客户名称" style="width:15%"/>
        <display:column property="zect" sortable="false" sortName="customerName" title="组织机构代码" style="width:15%"/>
        <display:column property="custVal" sortable="false" sortName="customerName" title="客户类型" style="width:10%"/>
        <display:column property="address" title="客户地址" style="width:20%"/>
        <display:column property="port" title="所在城市" style="width:8%"/>
        <display:column property="clerk" title="负责专员" style="width:7%"/>
        <display:column title="是否审核" property="verify" style="width:7%"></display:column>
        <display:column title="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;操作" style="width:15%;">


            <button type="button" class="btn btn-link"
                    onclick="updateCustomer('${row.uid}','${row.verify}')" id="update" style="display: none">
                修改
            </button>
            <stripes:link class="btn btn-link" beanclass="org.mybatis.weigao.web.actions.CustomerActionBean"
                          event="viewCustomer" name="view">
                查看
                <stripes:param name="uid" value="${row.uid}"/>
            </stripes:link>
        </display:column>
    </display:table>

</div>
</div>

<%@ include file="../common/IncludeBottom.jsp" %>

<script type="text/javascript">

    $(function () {
        //$.showProvinceList();
        loadSalesRegion();
        loadProvinceList();
        if (WEGO.roleWeb == "业务员") {
            $("#row>tbody>tr").each(
                    function () {
                        $(this).find("#update").show();
                    }
            )
            $("#clerk").attr("readonly", "true");
        } else if (WEGO.roleWeb == "区域主管") {
            $("#row>tbody>tr").each(
                    function () {
                        $(this).find("#update").show();
                    }
            )
            //$("#clerk").attr("readonly", "true");
        } else if (WEGO.roleWeb == "其他"){
                 $("[name='view']").hide();
            }
    })

    function updateCustomer(uid, verify) {
        if (verify != '否') {
            alert("客户名单已经审核，不能修改");
            return;
        }
        window.location.href = "/actions/Customer.action?goUpdateCustomer=&uid=" + uid;
    }


</script>



<%@ include file="../common/IncludeTop.jsp" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<script src="../js/weigao/addCustomerSurvey.js"></script>
<script src="../js/weigao/customerSurveyCommon.js"></script>
<%--
<link href="../displayTag/css/maven-base.css" rel="stylesheet">
<link href="../displayTag/css/maven-theme.css" rel="stylesheet">
<link href="../displayTag/css/site.css" rel="stylesheet">
<link href="../displayTag/css/screen.css" rel="stylesheet">
--%>
<style type="text/css">
    .form-control {
        width: 100px;
    }
</style>
<div class="container">


    <ol class="breadcrumb" style="margin-top: 5px">
        <li><a href="#">添加客户调研记录</a></li>
        <li><a href="javascript:history.go(-1);">返回<i class="icon-share-alt"></i></a></li>
    </ol>
</div>
<div class="container">
<stripes:form id="customerSurveyForm" beanclass="org.mybatis.weigao.web.actions.CustomerSurveyActionBean"
              class="form-inline" action="CustomerSurvey.action?addCustomerSurvey">
<div style="display: none">
    <stripes:text name="customerSurvey.customerId" class="form-control" id="customerId"/>
</div>


<table class="table table-bordered">
    <tr>
        <th width="80">客户名称：</th>
        <td id="customer" width="25%"></td>
        <th width="105">组织机构代码：</th>
        <td id="zect"  width="25%"></td>
        <th width="80">客户类型：</th>
        <td id="custVal" width="215"></td>
    </tr>
    <tr>
        <th>客户地址：</th>
        <td id="address"></td>
        <th>所在城市：</th>
        <td id="port"></td>
        <th>所属省份：</th>
        <td id="province"></td>
    </tr>
    <tr>
        <th width="80">客户网址：</th>
        <td id="webSite"></td>
        <th>负责专员：</th>
        <td id="clerk"></td>
        <th>销售大区：</th>
        <td id="salesRegion"></td>
    </tr>
    <tr>
        <th width="80">大区经理：</th>
                          <td id="manager"></td>
                          <th width="80">区域主管：</th>
                          <td id="preparerManager"></td>
        <th width="80">医院等级：</th>
        <td id="healthClass"></td>

    </tr>
    <tr>  <th width="80">行政级别：</th>
            <td id="hierarchy"></td>
            <th>执业许可证：</th>
            <td id="coop_DT"></td>
        <th>所属科室：</th>
        <td id="labOffice"></td>

    </tr>
    <tr>
        <th>血透室电话：</th>
                <td id="labTel"></td>
                <th>邮编：</th>
                <td id="postalCode"></td>
        <th></th>
        <td></td>
    </tr>
    <tr>
                <th>医院信息</th>
                <td colspan="5" id="chospitalMemo">
                    ${actionBean.customerSurvey.chospitalMemo}
                </td>
            </tr>
</table>
<hr>
<!--相关负责人-->
<table class="table table-bordered">
    <tbody>
    <tr>
        <th width='10%'>负责人：</th>
        <th width='10%'>职务：</th>
        <th width='10%'>联系方式：</th>
        <th width='15%'>决策范围：</th>
        <th width='15%'>个人爱好：</th>
        <th width='20%'>学术影响力：</th>
        <th width='10%'>身份证/生日：</th>


    </tr>
    <tr id="tr_customerStaff"></tr>
    </tbody>
</table>
<hr>
<table class="table table-bordered">
    <tr>
        <th>客户调研编号</th>
        <td>
            <input type="text" name="customerSurvey.surveyNo" id="surveyNo" class="form-control"
                   value="${actionBean.customerSurvey.surveyNo}" readonly="true">
        </td>
        <th>调研日期</th>
        <td colspan="3">
            <input type="text" name="customerSurvey.surveyDate" class="datepicker form-control" id="surveyDate"
                   readonly="true" required>
        </td>

    </tr>

    <tr>
        <th>医生人数：</th>
        <td><input type="number" name="customerSurvey.doctor" class="form-control" id="doctor" value="0"
                   placeholder="请输入医生人数" required number:true></td>
        <th>护士人数：</th>
        <td><input type="number" name="customerSurvey.nurse" class="form-control" id="nurse" value="0"
                   placeholder="请输入护士人数" required number:true></td>
        <th>工程师人数：</th>
        <td><input type="number" name="customerSurvey.engineer" class="form-control" id="engineer" value="0"
                   placeholder="请输入工程师人数" required></td>
    </tr>


    <tr>
        <th>现有血透机数：</th>
        <td>
            <input type="number" name="customerSurvey.hdfMachine" class="form-control" id="hdfMachine" value="0"
                   placeholder="请输入现有血透机数" required>
        </td>
        <th>血透室空间可容纳最大床位数：</th>
        <td>
            <input type="number" name="customerSurvey.hdfCapacity" class="form-control" id="hdfCapacity" value="0"
                   placeholder="请输入血透室空间可容纳最大床位数" required>
        </td>
        <th>现有水处理可带最大床位数：</th>
        <td>
            <input type="number" name="customerSurvey.waterTreatment" class="form-control" id="waterTreatment" value="0"
                   placeholder="请输入现有水处理可带最大床位数" required>
        </td>

    </tr>
    <tr>
        <th>医院手术量（例/年）：</th>
        <td><input type="number" name="customerSurvey.hospitalSurgical" class="form-control" id="hospitalSurgical"
                   value="0" placeholder="请输入医院手术量（例/年)"
                   required>
                <%--<stripes:text name="customerSurvey.hospitalSurgical" class="form-control" id="hospitalSurgical"/>--%>
        </td>
        <th>肾内科门诊量（人次/年）：</th>
        <td><input type="number" name="customerSurvey.renalClinic" class="form-control" id="renalClinic" value="0"
                   placeholder="请输入肾内科门诊量（人次/年）"
                   required>
                <%--<stripes:text name="customerSurvey.renalClinic" class="form-control" id="renalClinic"/>--%></td>
        <th>血液透析：</th>
        <td><input type="number" name="customerSurvey.hd" class="form-control" id="hd" placeholder="请输入血液透析"
                   value="0" required>
        </td>
    </tr>
    <tr>
        <th>血液滤过：</th>
        <td><input type="number" name="customerSurvey.hf" class="form-control" id="hf" placeholder="请输入血液滤过"
                   value="0" required>
                <%--<stripes:text name="customerSurvey.hf" class="form-control" id="hf"/>--%></td>
        <th>血液透析滤过：</th>
        <td><input type="number" name="customerSurvey.hdf" class="form-control" id="hdf" placeholder="请输入血液透析滤过"
                   value="0" required>
                <%--<stripes:text name="customerSurvey.hdf" class="form-control" id="hdf"/>--%></td>
        <th>CRRT：</th>
        <td><input type="number" name="customerSurvey.crrt" class="form-control" id="crrt" placeholder="请输入CRRT"
                   value="0" required>
                <%--<stripes:text name="customerSurvey.crrt" class="form-control" id="crrt"/>--%></td>

    <tr>
            <%--<th>月治疗次数：</th>
            <td><stripes:text name="customerSurvey.remedyMothly" class="form-control" id="remedyMothly"/></td>--%>
        <th>血液灌流：</th>
        <td><input type="number" name="customerSurvey.hp" class="form-control" id="hp" placeholder="请输入血液灌流"
                   value="0" required>
                <%--<stripes:text name="customerSurvey.hp" class="form-control" id="hp"/>--%></td>
        <th>耗材产品销售渠道：</th>
        <td>
            <input type="radio" name="customerSurvey.channelDYMO" value="全部" class="form-control"
                   checked="true">全部
            <input type="radio" name="customerSurvey.channelDYMO" value="直销" class="form-control"
                   checked="true">&nbsp;直销
            <input type="radio" name="customerSurvey.channelDYMO" value="分销" class="form-control"
                   id="channelDYMO1">&nbsp;分销
        </td>
        <th>设备销售产品渠道：</th>
        <td>
            <input type="radio" name="customerSurvey.channelDevice" value="全部" class="form-control"
                   checked="true">全部
            <input type="radio" name="customerSurvey.channelDevice" value="直销" class="form-control"
                    >&nbsp;直销
            <input type="radio" name="customerSurvey.channelDevice" value="分销" class="form-control"
                    >&nbsp;分销
        </td>
    </tr>
    <tr>
        <th>是否存在产品投放：</th>
        <td>
            <input type="radio" name="customerSurvey.ynProduct" value="1" class="form-control" id="ynProduct"
                   checked="true"> &nbsp;是&nbsp;&nbsp;
            <input type="radio" name="customerSurvey.ynProduct" value="0" class="form-control" id="ynProduct1">&nbsp; 否
        </td>
        <th>目前投放产品合作周期：</th>
        <td><input type="text" name="customerSurvey.productPeriod" value="0" class="form-control" id="productPeriod"
                   placeholder="请输入目前投放产品合作周期"
                   value="${actionBean.customerSurvey.productPeriod}" required>
        </td>
        <th>目前是否有投放计划：</th>
        <td>
            <input type="radio" name="customerSurvey.ynPlan" value="1" class="form-control" id="ynPlan" checked="true">
            &nbsp;是&nbsp;&nbsp;
            <input type="radio" name="customerSurvey.ynPlan" value="0" class="form-control" id="ynPlan1"> &nbsp; 否
        </td>
    </tr>
    <tr>
        <th>计划投放透析机数量：</th>
        <td><input type="number" name="customerSurvey.planDialys" class="form-control" id="planDialys"
                   placeholder="请输入计划投放透析机数量"
                   value="0" required>
                <%--<stripes:text name="customerSurvey.planDialys" class="form-control" id="planDialys"/>--%></td>
        <th>透析患者数：</th>
        <td><input type="number" name="customerSurvey.hdfF1" class="form-control" id="hdfF1" placeholder="请输入透析患者数"
                   value="0" required>
                <%--<stripes:text name="customerSurvey.hdfF1" class="form-control" id="hdfF1"/>--%></td>
        <th>腹透患者数：</th>
        <td><input type="number" name="customerSurvey.nepdF1" class="form-control" id="nepdF1" placeholder="请输入腹透患者数"
                   value="0" required>
                <%--<stripes:text name="customerSurvey.nepdF1" class="form-control" id="nepdF1"/>--%></td>

    </tr>
    <tr>
        <th>月透析人次：</th>
        <td><input type="number" name="customerSurvey.hdfF2" class="form-control" id="hdfF2" placeholder="请输入月透析人次"
                   value="0" required>
                <%--<input type="text" name="customerSurvey.hdfF2" class="form-control" id="hdfF2" placeholder="月透析人次" required >--%>
        </td>
        <th>月腹透人次：</th>
        <td><input type="number" name="customerSurvey.nepdF2" class="form-control" id="nepdF2" placeholder="请输入月腹透人次"
                   value="0" required>
                <%--<stripes:text name="customerSurvey.nepdF2" class="form-control" id="nepdF2"/>--%></td>
        <th>最长透析龄：</th>
        <td><input type="number" name="customerSurvey.hdfF3" class="form-control" id="hdfF3" placeholder="请输入最长透析龄"
                   value="0" required>
                <%--<stripes:text name="customerSurvey.hdfF3" class="form-control" id="hdfF3"/>--%></td>

    </tr>
    <tr>
        <th>最长腹透龄：</th>
        <td><input type="number" name="customerSurvey.nepdF3" class="form-control" id="nepdF3" placeholder="请输入最长腹透龄"
                   value="0" required>
                <%--<stripes:text name="customerSurvey.nepdF3" class="form-control" id="nepdF3"/>--%></td>
        <th>客户评判：</th>
        <td colspan="3">
            <input type="radio" name="customerSurvey.feedback" value="战略" class="form-control"
                   checked="true">战略
            <input type="radio" name="customerSurvey.feedback" value="重要" class="form-control"
                    >&nbsp;重要
            <input type="radio" name="customerSurvey.feedback" value="一般" class="form-control"
                    >&nbsp;一般
        </td>

    </tr>
    <tr>
        <th>评判说明：</th>
        <td colspan="5">
            <stripes:textarea rows="3" style="width:90%" name="customerSurvey.fbNote" class=" form-control"
                              id="fbNote" value="${actionBean.customerSurvey.fbNote}"/>

        </td>
    </tr>
    <tr>
        <th>调研备注：</th>
        <td colspan="5">
            <stripes:textarea rows="3" style="width:90%" name="customerSurvey.hospitalMemo" class=" form-control"
                              id="hospitalMemo" value="${actionBean.customerSurvey.hospitalMemo}"/>

        </td>
    </tr>
</table>


<div class="form-inline">
    业务板块：
    <select id='prodType' onchange='loadProInfo()' style="width: 70px;">
        <option value='耗材' selected="selected">耗材</option>
        <option value='设备'>设备</option>
    </select>
    产品类别:
    <select id='category' onchange='loadBrand()' style="width: 150px;">

    </select>
    品牌:
    <select id='brand' onchange='loadFamily()' style="width: 150px;">

    </select>
    规格:
    <select id='family' onchange='loadPartNo()' style="width: 100px;">

    </select>
    型号：
    <select id='partNo' style="width: 90px;">

    </select>


    <div class="btn btn-primary" value="" onclick="addProdLine()" id="addProdLine">增加产品行</div>
</div>

<hr/>
<table class="table table-bordered">
    <tbody id="tr_category">

    <tr id="0">
        <th width='8%'>产品类别</th>

        <th width='8%'>品牌</th>

        <th width='8%'>规格</th>

        <th width='8%'>产品型号</th>

        <th width='10%'>数量/复用人次</th>
        <th width='10%'>复用次数</th>
        <th width='8%'>市场价格</th>
        <th width='8%'>初次使用时间</th>
        <th width='10%'>销售公司</th>
        <th>备注</th>
        <th width='7%'>操作</th>
    </tr>
    <c:forEach var="surveyDetail" items="${actionBean.surveyDetailList}" varStatus="status">
        <tr id="${status.count}">
            <td><input type="hidden" id="uid" value="${surveyDetail.uid}"> ${surveyDetail.category}</td>
            <td>${surveyDetail.brand}</td>
            <td>${surveyDetail.family}</td>
            <td>${surveyDetail.partNo}</td>
            <td>

                <input type="number" style='width:60px' name="surveyDetail.ahsca" id="amount"
                       placeholder="请输入数量"
                       value="${surveyDetail.ahsca}" required>
            </td>
            <td>
                <input type="number" style='width:60px' name="surveyDetail.bReUseNote"
                       id="reUseInfo"
                       placeholder="请输入复用情况"
                       value="${surveyDetail.bReUseNote}">
            </td>
            <td>
                <input type="number" style='width:60px' name="surveyDetail.aPrice" id="price"
                       placeholder="请输入价格"
                       value="${surveyDetail.aPrice}" required>
            </td>

            <td>
                <input type="text" style='width:100px' name="surveyDetail.bInstallDate" class="datepicker form-control"
                       id="bInstallDate"
                       placeholder="请选择装机时间"
                       value="${surveyDetail.bInstallDate}">
            </td>
            <td>
                <textarea name="surveyDetail.bInstallDate" style='width:90%' id="salesAgency"
                          placeholder="请输入销售公司"
                        >${surveyDetail.salesAgency}</textarea>
            </td>
            <td>
                <textarea name="surveyDetail.bInstallDate" style='width:90%' id="remark"
                          placeholder="请输入备注"
                        >${surveyDetail.remark}</textarea>
            </td>
            <input type='hidden' id='partNoUid' value='${surveyDetail.partID}'>
            <td>
                <div class='btn btn-primary' onclick='removeProd("${status.count}")'>移除</div>
            </td>
                <%--
                <td><fmt:formatDate value="${order.orderDate}"
                    pattern="yyyy/MM/dd hh:mm:ss" /></td>
                <td><fmt:formatNumber value="${order.totalPrice}"
                    pattern="$#,##0.00" /></td>   --%>
        </tr>
    </c:forEach>
    </tbody>
</table>


<input type="hidden" name="customerSurvey.jsonString" value="" id="jsonString">

<div>
    <button class="btn btn-primary btn-large" id="operate" onclick="getCustomerSurveyDetail()"/>
    保存</button>
</div>
<!--
<button class="btn btn-lg btn-primary btn-block" >添加</button>
-->
</stripes:form>


</div>
<%@ include file="../common/IncludeBottom.jsp" %>

<script type="text/javascript">
    $(function () {
        $('.datepicker').datepicker({format: "yyyy-mm-dd"});
        $('.datepicker').val(getCurrentDate());
    })
</script>



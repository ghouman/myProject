<%@ include file="../common/IncludeTop.jsp" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<script src="../js/weigao/addCustomerSurvey.js"></script>
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
        <li><a href="#">添加客户调研记录</a></li>
    </ol>
</div>
<div class="container">
<stripes:form id="addCustomerSurveyForm" beanclass="org.mybatis.weigao.web.actions.CustomerSurveyActionBean" class="form-inline" action="CustomerSurvey.action?addCustomerSurvey">
<div style="display: none">
    <stripes:text name="customerSurvey.customerId" class="form-control" id="customerId" />
</div>


<table class="table table-bordered">
    <tr>
        <th>客户名称：</th>
        <td colspan="2" id="customer"></td>
        <th>所属医院：</th>
        <td colspan="2" id="zect"></td>
    </tr>
    <tr>
        <th>客户类型：</th>
        <td id="custVal"></td>
        <th>客户地址：</th>
        <td colspan="3" id="address"></td>
    </tr>
    <tr>
        <th>客户网址：</th>
        <td id="webSite"></td>
        <th>医院等级：</th>
        <td id="healthClass"></td>
        <th>行政等级：</th>
        <td id="hierarchy"></td>
    </tr>
    <tr>
        <th>合作时间：</th>
        <td id="coop_DT"></td>
        <th>邮编：</th>
        <td id="postalCode"></td>
        <th>所在城市：</th>
        <td id="port"></td>
    </tr>
    <tr>
        <th>省份：</th>
        <td id="province"></td>
        <th>业务员：</th>
        <td id="clerk"></td>
        <th>销售大区：</th>
        <td id="salesRegion"></td>
    </tr>

    <tr>
        <th>所属科室：</th>
        <td id="labOffice"></td>
        <th>所属科室电话：</th>
        <td colspan="3" id="labTel"></td>
    </tr>
    </table>
    <table class="table table-bordered">
    <tr>
                 <th>客户调研编号</th>
                 <td>
                     <input type="text" name="customerSurvey.surveyNo" id="surveyNo" class="form-control" value="${actionBean.customerSurvey.surveyNo}"  readonly="true">
                 </td>
                 <th>调研日期</th>
                 <td >
                     <input type="text" name="customerSurvey.surveyDate" class="datepicker form-control" id="surveyDate" readonly="true" required >
                     </td>
           <th>医院信息：</th>
                   <td>
                       <textarea class="form-control" rows="3" name="customerSurvey.hospitalMemo"  id="hospitalMemo"></textarea>
                   </td>
             </tr>
    <tr>
        <th>医生人数：</th>
        <td><input type="text" name="customerSurvey.doctor" class="form-control" id="doctor" placeholder="请输入医生人数" required ></td>
        <th>护士人数：</th>
        <td><input type="number" name="customerSurvey.nurse" class="form-control" id="nurse" placeholder="请输入护士人数" required ></td>
        <th>工程师人数：</th>
        <td><input type="number" name="customerSurvey.engineer" class="form-control" id="engineer" placeholder="请输入工程师人数" required ></td>
    </tr>


    <tr>
        <th>现有血透机数：</th>
        <td>
            <input type="number" name="customerSurvey.hdfMachine" class="form-control" id="hdfMachine" placeholder="请输入现有血透机数" required >
        </td>
        <th>血透室空间可容纳最大床位数：</th>
        <td>
            <input type="number" name="customerSurvey.hdfCapacity" class="form-control" id="hdfCapacity" placeholder="请输入血透室空间可容纳最大床位数" required >
        </td>
        <th>现有水处理可带最大床位数：</th>
        <td>
            <input type="number" name="customerSurvey.waterTreatment" class="form-control" id="waterTreatment" placeholder="请输入现有水处理可带最大床位数" required >
        </td>

    </tr>
    <tr>
        <th>医院手术量（例/年）：</th>
        <td><input type="number" name="customerSurvey.hospitalSurgical" class="form-control" id="hospitalSurgical" placeholder="请输入医院手术量（例/年)"
            value="${actionBean.customerSurvey.hospitalSurgical}" required>
            <%--<stripes:text name="customerSurvey.hospitalSurgical" class="form-control" id="hospitalSurgical"/>--%>
        </td>
        <th>肾内科门诊量（人次/年）：</th>
        <td><input type="number" name="customerSurvey.renalClinic" class="form-control" id="renalClinic" placeholder="请输入肾内科门诊量（人次/年）"
            value="${actionBean.customerSurvey.renalClinic}" required>
            <%--<stripes:text name="customerSurvey.renalClinic" class="form-control" id="renalClinic"/>--%></td>
        <th>血液透析：</th>
        <td><input type="number" name="customerSurvey.hd" class="form-control" id="hd" placeholder="请输入血液透析"
        value="${actionBean.customerSurvey.hd}" required>
        </td>
</tr>
<tr>
    <th>血液滤过：</th>
    <td><input type="number" name="customerSurvey.hf" class="form-control" id="hf" placeholder="请输入血液滤过"
    value="${actionBean.customerSurvey.hf}" required>
    <%--<stripes:text name="customerSurvey.hf" class="form-control" id="hf"/>--%></td>
<th>血液透析滤过：</th>
<td><input type="number" name="customerSurvey.hdf" class="form-control" id="hdf" placeholder="请输入血液透析滤过"
value="${actionBean.customerSurvey.hdf}" required>
<%--<stripes:text name="customerSurvey.hdf" class="form-control" id="hdf"/>--%></td>
<th>CRRT：</th>
<td><input type="number" name="customerSurvey.crrt" class="form-control" id="crrt" placeholder="请输入CRRT"
                value="${actionBean.customerSurvey.crrt}" required>
        <%--<stripes:text name="customerSurvey.crrt" class="form-control" id="crrt"/>--%></td>

<tr>
<%--<th>月治疗次数：</th>
<td><stripes:text name="customerSurvey.remedyMothly" class="form-control" id="remedyMothly"/></td>--%>
    <th>血液灌流：</th>
    <td><input type="number" name="customerSurvey.hp" class="form-control" id="hp" placeholder="请输入血液灌流"
               value="${actionBean.customerSurvey.hp}" required>
            <%--<stripes:text name="customerSurvey.hp" class="form-control" id="hp"/>--%></td>
    </tr>
<th>耗材产品销售渠道：</th>
<td>
<input type="radio" name="customerSurvey.channelDYMO" value="直销" class="form-control" id="channelDYMO" checked="true">&nbsp;直销&nbsp;&nbsp;
<input type="radio" name="customerSurvey.channelDYMO" value="分销" class="form-control" id="channelDYMO1">&nbsp;分销
</td>
<th>设备销售产品渠道：</th>
<td>
<input type="radio" name="customerSurvey.channelDevice" value="直销" class="form-control" id="channelDevice" checked="true">&nbsp;直销&nbsp;&nbsp;
<input type="radio" name="customerSurvey.channelDevice" value="分销" class="form-control" id="channelDevice1">&nbsp;分销
</td>
</tr>
<tr>
<th>是否存在产品投放：</th>
<td>
<input type="radio" name="customerSurvey.ynProduct" value="1" class="form-control" id="ynProduct" checked="true"> &nbsp;是&nbsp;&nbsp;
<input type="radio" name="customerSurvey.ynProduct" value="0" class="form-control" id="ynProduct1">&nbsp; 否</td>
<th>目前投放产品合作周期：</th>
<td><input type="text" name="customerSurvey.productPeriod" class="form-control" id="productPeriod" placeholder="请输入目前投放产品合作周期"
value="${actionBean.customerSurvey.productPeriod}" required>
<%--<stripes:text name="customerSurvey.productPeriod" class="form-control" id="productPeriod"/>--%></td>
<th>目前是否有投放计划：</th>
<td>
<input type="radio" name="customerSurvey.ynPlan" value="1" class="form-control" id="ynPlan" checked="true">  &nbsp;是&nbsp;&nbsp;
<input type="radio" name="customerSurvey.ynPlan" value="0" class="form-control" id="ynPlan1"> &nbsp; 否
</td>
</tr>
<tr>
<th>计划投放透析机数量：</th>
<td><input type="number" name="customerSurvey.planDialys" class="form-control" id="planDialys" placeholder="请输入计划投放透析机数量"
    value="${actionBean.customerSurvey.planDialys}" required>
    <%--<stripes:text name="customerSurvey.planDialys" class="form-control" id="planDialys"/>--%></td>
<th>透析患者数：</th>
<td><input type="number" name="customerSurvey.hdfF1" class="form-control" id="hdfF1" placeholder="请输入透析患者数"
value="${actionBean.customerSurvey.hdfF1}" required>
<%--<stripes:text name="customerSurvey.hdfF1" class="form-control" id="hdfF1"/>--%></td>
<th>腹透患者数：</th>
<td><input type="number" name="customerSurvey.nepdF1" class="form-control" id="nepdF1" placeholder="请输入腹透患者数"
value="${actionBean.customerSurvey.nepdF1}" required>
<%--<stripes:text name="customerSurvey.nepdF1" class="form-control" id="nepdF1"/>--%></td>

</tr>
<tr>
<th>月透析人次：</th>
<td><input type="number" name="customerSurvey.hdfF2" class="form-control" id="hdfF2" placeholder="请输入月透析人次"
value="${actionBean.customerSurvey.hdfF2}" required>
<%--<input type="text" name="customerSurvey.hdfF2" class="form-control" id="hdfF2" placeholder="月透析人次" required >--%></td>
<th>月腹透人次：</th>
<td><input type="number" name="customerSurvey.nepdF2" class="form-control" id="nepdF2" placeholder="请输入月腹透人次"
value="${actionBean.customerSurvey.nepdF2}" required>
<%--<stripes:text name="customerSurvey.nepdF2" class="form-control" id="nepdF2"/>--%></td>
<th>最长透析龄：</th>
<td><input type="number" name="customerSurvey.hdfF3" class="form-control" id="hdfF3" placeholder="请输入最长透析龄"
value="${actionBean.customerSurvey.hdfF3}" required>
<%--<stripes:text name="customerSurvey.hdfF3" class="form-control" id="hdfF3"/>--%></td>

</tr>
<tr>
<th>最长腹透龄：</th>
<td><input type="number" name="customerSurvey.nepdF3" class="form-control" id="nepdF3" placeholder="请输入最长腹透龄"
value="${actionBean.customerSurvey.nepdF3}" required>
<%--<stripes:text name="customerSurvey.nepdF3" class="form-control" id="nepdF3"/>--%></td>
<th>客户评判：</th>
<td>
<stripes:select name="customerSurvey.feedback" id="feedback">
<stripes:option value="战略">战略</stripes:option>
<stripes:option value="重要">重要</stripes:option>
<stripes:option value="一般">一般</stripes:option>
</stripes:select>
</td>
<th>评判说明：</th>
<td colspan="5"><stripes:text name="customerSurvey.fbNote" class="form-control" id="fbNote"/></td>

</tr>

</table>
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
<!--
<tr>
<td><stripes:text style="width:140px" name="customerSurvey.staff" class="form-control"
id="staff"/></td>
<td><stripes:text style="width:140px" name="customerSurvey.staffDuty" class="form-control"
id="staffDuty"/></td>
<td><stripes:text style="width:140px" name="customerSurvey.staffTel" class="form-control"
id="staffTel"/></td>
<td><stripes:text style="width:140px" name="customerSurvey.staffForce" class="form-control"
id="staffForce"/></td>
<td><stripes:text style="width:190px" name="customerSurvey.staffFavor" class="form-control"
id="staffFavor"/></td>
<td><stripes:text style="width:190px" name="customerSurvey.staffImpact" class="form-control"
id="staffImpact"/></td>
</tr>  -->
</tbody>
</table>
<hr/>
<div class="form-inline" >
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


<div class="btn btn-primary" value="" onclick="addProdLine()">增加产品行</div>
<div class="btn btn-primary" value="" onclick="removeLastProd('tr_category')">移除最末行</div>
</div>

<hr/>
<table class="table table-bordered">
<tbody id="tr_category">

<tr id="0">
<th width='10%'>产品类别：</th>

<th width='10%'>品牌：</th>

<th width='10%'>规格：</th>

<th width='10%'>产品型号：</th>

<th width='10%'>数量/使用量：</th>

<th width='10%'>市场价格：</th>

<th width='10%'>复用情况：</th>

<th width='20%'>装机时间：</th>
</tr>
<!--
<tr>
<th width='10%'><select id='prodType' onchange='loadProInfo()' style="width: 70px;">
<option value='耗材' selected="selected">耗材</option>
<option value='设备'>设备</option>
</select></th>

<th width='10%'><select id='category' onchange='loadBrand()' style="width: 150px;">

</select></th>

<th width='10%'><select id='brand' onchange='loadFamily()' style="width: 130px;">

</select></th>

<th width='10%'><select id='family' onchange='loadPartNo()' style="width: 100px;">

</select></th>

<th width='10%'><select id='partNo' style="width: 100px;">

</select></th>

<th width='10%'></th>

<th width='10%'></th>

<th width='10%'></th>
<th width='20%'></th>
</tr>
-->
</tbody>
</table>


<input type="hidden" name="customerSurvey.jsonString" value="" id="jsonString" >
<button class="btn btn-primary "  onclick="addCustomerSurvey()" />
添加</button>
<!--
<button class="btn btn-lg btn-primary btn-block"  >添加</button>
-->
</stripes:form>


</div>
<%@ include file="../common/IncludeBottom.jsp" %>

<script type="text/javascript">
    $(function () {
        $('.datepicker').datepicker();
    })
</script>



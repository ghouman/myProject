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
        <li><a href="#">客户调研记录查看</a></li>
        <li><a href="CustomerSurvey.action">返回</a></li>
    </ol>
</div>
<div class="container">
    <table class="table table-bordered">
        <tr>
            <th>客户：</th>
            <td >${actionBean.customerSurvey.customer}</td>
            <th>所属医院：</th>
                        <td colspan="3">${actionBean.customerSurvey.zect}</td>
        </tr>
        <tr>
            <th>所属省市：</th>
            <td>${actionBean.customerSurvey.province} ${actionBean.customerSurvey.port}</td>
            <th>所属区域：</th>
            <td colspan="3">${actionBean.customerSurvey.salesRegion}</td>
        </tr>
        <tr>
            <th>所属科室：</th>
            <td>${actionBean.customerSurvey.labOffice} </td>
            <th>所属科室电话：</th>
            <td colspan="3">${actionBean.customerSurvey.labTel}</td>
        </tr>
    </table>
    <table class="table table-bordered">
        <tr>
            <th>医生人数：</th>
            <td>${actionBean.customerSurvey.doctor} </td>
            <th>护士人数：</th>
            <td>${actionBean.customerSurvey.nurse}</td>
            <th>工程师人数：</th>
            <td>${actionBean.customerSurvey.engineer}</td>
        </tr>
        <tr>
            <th>医院信息：</th>
            <td colspan="5">${actionBean.customerSurvey.hospitalMemo} </td>
        </tr>
        <tr>
            <th>现有血透机数：</b></td>
                <td>${actionBean.customerSurvey.hdfMachine}</td>
            <th>血透室空间可容纳最大床位数：</th>
            <td>${actionBean.customerSurvey.hdfCapacity}</td>
            <th>现有水处理可带最大床位数：</th>
            <td>${actionBean.customerSurvey.waterTreatment} </td>

        </tr>
        <tr>
            <th>医院手术量（例/年）：</th>
            <td>${actionBean.customerSurvey.hospitalSurgical}</td>
            <th>肾内科门诊量（人次/年）：</th>
            <td>${actionBean.customerSurvey.renalClinic}</td>
            <th>血液滤过：</th>
            <td>${actionBean.customerSurvey.hf} </td>

        </tr>
        <tr>
            <th>血液透析滤过：</th>
            <td>${actionBean.customerSurvey.hdf}</td>
            <th>CRRT：</th>
            <td>${actionBean.customerSurvey.crrt}</td>
            <th>血液灌流：</th>
            <td>${actionBean.customerSurvey.hp} </td>

        </tr>
        <tr>
            <th>月治疗次数：</th>
            <td>${actionBean.customerSurvey.remedyMothly}</td>
            <th>耗材产品销售渠道：直销，分销：</th>
            <td>${actionBean.customerSurvey.channelDYMO}</td>
            <th>设备销售产品渠道：直销，分销：</th>
            <td>${actionBean.customerSurvey.channelDevice} </td>

        </tr>
        <tr>
            <th>是否存在产品投放：</th>
            <td>${actionBean.customerSurvey.ynProduct}</td>
            <th>目前投放产品合作周期：</th>
            <td>${actionBean.customerSurvey.productPeriod}</td>
            <th>目前是否有投放计划：</th>
            <td>${actionBean.customerSurvey.ynPlan} </td>

        </tr>
        <tr>
            <th>计划投放透析机数量：</th>
            <td>${actionBean.customerSurvey.planDialys}</td>
            <th>透析患者数：</th>
            <td>${actionBean.customerSurvey.hdfF1}</td>
            <th>腹透患者数：</th>
            <td>${actionBean.customerSurvey.nepdF1} </td>

        </tr>
        <tr>
            <th>月透析人次：</th>
            <td>${actionBean.customerSurvey.hdfF2}</td>
            <th>月腹透人次：</th>
            <td>${actionBean.customerSurvey.nepdF2}</td>
            <th>最长透析龄：</th>
            <td>${actionBean.customerSurvey.hdfF3} </td>

        </tr>
        <tr>
            <th>最长腹透龄：</th>
            <td>${actionBean.customerSurvey.nepdF3}</td>
            <th>客户评判：</th>
            <td>${actionBean.customerSurvey.feedback}</td>
            <th>评判说明：</th>
            <td colspan="5">${actionBean.customerSurvey.fbNote} </td>

        </tr>
    </table>

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


        <c:forEach var="surveyDetail" items="${actionBean.surveyDetailList}">
            <tr>
                <td>${surveyDetail.category}</td>
                <td>${surveyDetail.brand}</td>
                <td>${surveyDetail.family}</td>
                <td>${surveyDetail.partNo}</td>
                <td>
                    ${surveyDetail.ahsca}
                </td>
                <td>
                   ${surveyDetail.aPrice}
                </td>
                <td>
                    ${surveyDetail.bReUseNote}
                </td>
                <td>
                    ${surveyDetail.bInstallDate}
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
</div>
<%@ include file="../common/IncludeBottom.jsp" %>

<script type="text/javascript">

</script>



<%@ include file="../common/IncludeTop.jsp" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%--
<link href="../displayTag/css/maven-base.css" rel="stylesheet">
<link href="../displayTag/css/maven-theme.css" rel="stylesheet">
<link href="../displayTag/css/site.css" rel="stylesheet">
<link href="../displayTag/css/screen.css" rel="stylesheet">
--%>
<script src="../js/weigao/customerSurveyCommon.js"></script>
<style type="text/css">

</style>
<div class="container">


    <ol class="breadcrumb" style="margin-top: 5px">
        <li><a href="#">客户调研记录查看</a></li>
        <li><a href="javascript:history.go(-1);">返回<i class="icon-share-alt"></i></a></li>
    </ol>
</div>
<div class="container">
<div style="display: none">

    <input type="text" value="${actionBean.customerSurvey.customerId}" class="form-control" id="customerId"/>
</div>
<table class="table table-bordered">
    <tr>
        <th width="80">客户名称：</th>
        <td width="25%">${actionBean.customerSurvey.customer}</td>
        <th width="105">组织机构代码：</th>
        <td width="25%">${actionBean.customerSurvey.zect}</td>
        <th width="80">客户类型：</th>
        <td>${actionBean.customerSurvey.custVal}</td>
    </tr>
    <tr>
        <th>客户地址：</th>
        <td>${actionBean.customerSurvey.address}</td>
        <th>所在城市：</th>
        <td>${actionBean.customerSurvey.port}</td>
        <th>所属省份：</th>
        <td>${actionBean.customerSurvey.province}</td>
    </tr>
    <tr>
        <th width="80">客户网址：</th>
        <td>
            <c:if test="${actionBean.customerSurvey.website!='-' and fn:substring(actionBean.customerSurvey.website, 0, 4)!='http'}">
                <a href="http://${actionBean.customerSurvey.website}"
                   target="_blank">${actionBean.customerSurvey.website}</a>
            </c:if>
            <c:if test="${actionBean.customerSurvey.website!='-' and fn:substring(actionBean.customerSurvey.website, 0, 4)=='http'}">
                <a href="${actionBean.customerSurvey.website}" target="_blank">${actionBean.customerSurvey.website}</a>
            </c:if>
            <c:if test="${actionBean.customerSurvey.website=='-'}">${actionBean.customerSurvey.website}</c:if>
        </td>
        <th>负责专员：</th>
        <td> ${actionBean.customerSurvey.clerk}</td>
        <th>销售大区：</th>
        <td>${actionBean.customerSurvey.salesRegion}</td>

    </tr>
    <tr>
        <th width="80">大区经理：</th>
        <td>${actionBean.customerSurvey.manager}</td>
        <th width="80">区域主管：</th>
        <td>${actionBean.customerSurvey.preparerManager}</td>
        <th width="80">医院等级：</th>
        <td>${actionBean.customerSurvey.healthClass}</td>

    </tr>
    <tr>
        <th width="80">行政级别：</th>
        <td>${actionBean.customerSurvey.hierarchy}</td>
        <th>执业许可证：</th>
        <td>${actionBean.customerSurvey.coop_DT}</td>
        <th>所属科室：</th>
        <td>${actionBean.customerSurvey.labOffice} </td>

    </tr>
    <tr>
        <th>血透室电话：</th>
        <td>${actionBean.customerSurvey.labTel}</td>
        <th>邮编：</th>
        <td>${actionBean.customerSurvey.postalCode}</td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <th>医院信息</th>
        <td colspan="5">
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
        <th width="18%">客户调研编号</th>
        <td width="12%">
            ${actionBean.customerSurvey.surveyNo}
        </td>
        <td width="18%"></td>
        <td width="12%"></td>
        <th width="18%">调研日期</th>
        <td width="12%">
            ${actionBean.customerSurvey.surveyDate}
        </td>
    </tr>
    <tr>
        <th>提交人员：</th>
        <td width="100">${actionBean.customerSurvey.checker} </td>
        <th>提交状态：</th>
        <td width="100">${actionBean.customerSurvey.checked} </td>
        <th>提交日期：</th>
        <td width="100">${fn:substring(actionBean.customerSurvey.checkDate, 0, 10)}</td>

    </tr>
    <tr>
        <th style="color: red; width: 180px">初审备注</th>
        <td colspan="5" style="color: red;font-weight: bolder;">
            ${actionBean.customerSurvey.submitMemo}
        </td>
    </tr>
    <tr>
        <th>初审人员：</th>
        <td width="100">${actionBean.customerSurvey.submitUser} </td>
        <th>初审状态：</th>
        <td width="100">${actionBean.customerSurvey.submit} </td>
        <th>初审日期：</th>
        <td width="100">${fn:substring(actionBean.customerSurvey.submitDate, 0, 10)}</td>
    </tr>
    <tr>
        <th style="color: red;">复审备注</th>
        <td colspan="5" style="color: red;font-weight: bolder;">
            ${actionBean.customerSurvey.verifyMemo}
        </td>
    </tr>
    <tr>
        <th>复审人员：</th>
        <td width="100">${actionBean.customerSurvey.verifier}</td>
        <th>复审状态：</th>
        <td width="100">${actionBean.customerSurvey.verify}</td>
        <th>复审日期：</th>
        <td width="100">${fn:substring(actionBean.customerSurvey.verifyDate, 0, 10)}</td>
    </tr>

    <tr>
        <th>医生人数：</th>
        <td width="100">${actionBean.customerSurvey.doctor} </td>
        <th>护士人数：</th>
        <td width="100">${actionBean.customerSurvey.nurse}</td>
        <th>工程师人数：</th>
        <td width="100">${actionBean.customerSurvey.engineer}</td>
    </tr>

    <tr>
        <th>现有血透机数：</td>
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

        <th>血液透析：</th>
        <td>${actionBean.customerSurvey.hd}</td>
    </tr>
    <tr>
        <th>血液滤过：</th>
        <td>${actionBean.customerSurvey.hf} </td>
        <th>血液透析滤过：</th>
        <td>${actionBean.customerSurvey.hdf}</td>
        <th>CRRT：</th>
        <td>${actionBean.customerSurvey.crrt}</td>
    </tr>
    <tr>
        <th>血液灌流：</th>
        <td>${actionBean.customerSurvey.hp} </td>
        <th>耗材产品销售渠道：</th>
        <td>${actionBean.customerSurvey.channelDYMO}</td>
        <th>设备销售产品渠道：</th>
        <td>${actionBean.customerSurvey.channelDevice} </td>

    </tr>
    <tr>
        <th>是否存在产品投放：</th>
        <td><c:if test="${actionBean.customerSurvey.ynProduct}">是</c:if><c:if
                test="${actionBean.customerSurvey.ynProduct==false}">否</c:if></td>
        <th>目前投放产品合作周期：</th>
        <td>${actionBean.customerSurvey.productPeriod}</td>
        <th>目前是否有投放计划：</th>
        <td><c:if test="${actionBean.customerSurvey.ynPlan}">是</c:if><c:if
                test="${actionBean.customerSurvey.ynPlan==false}">否</c:if></td>

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
        <td colspan="3">${actionBean.customerSurvey.feedback}</td>
    </tr>
    <tr>
        <th>评判说明：</th>
        <td colspan="5">${actionBean.customerSurvey.fbNote} </td>
    </tr>
    <tr>
        <th width="100">调研备注：</th>
        <td colspan="5">
            ${actionBean.customerSurvey.hospitalMemo}
        </td>
    </tr>
</table>

<hr/>
<table class="table table-bordered">
    <tbody id="tr_category">
    <tr id="0">
        <th width='10%'>产品类别：</th>

        <th width='10%'>品牌：</th>

        <th width='10%'>规格：</th>

        <th width='10%'>产品型号：</th>

        <th width='10%'>数量/复用人次：</th>

        <th width='10%'>复用次数：</th>

        <th width='10%'>市场价格：</th>

        <th width='8%'>初次使用时间：</th>

        <th>销售公司</th>

        <th>备注</th>
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
                    ${surveyDetail.bReUseNote}
            </td>
            <td>
                    ${surveyDetail.aPrice}
            </td>
            <td>
                    ${surveyDetail.bInstallDate}
            </td>
            <td>
                    ${surveyDetail.salesAgency}
            </td>
            <td>
                    ${surveyDetail.remark}
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
    $(function () {
        var customerId = $("#customerId").val();
        loadStaffInfo(customerId);
    })
</script>



<%@ include file="../common/IncludeTop.jsp" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<div class="container">

</div>
<%@ include file="../common/IncludeBottom.jsp" %>

<script type="text/javascript">
    if ("${param.flag}" == "customer") {
        window.location.href = "/actions/Customer.action";
    } else if ("${param.flag}" == "customerSurvey") {
        window.location.href = "/actions/CustomerSurvey.action";
    } else if ("${param.flag}" == "addCustomerSurveyFail_IX") {
            alert("调研编号已被其他业务员同时使用，系统重新为您生成编号，请重新添加！");
            window.history.go(-1);
            //window.location.reload();
        }
    else if ("${param.flag}" == "addCustomerSurveyFail") {
        alert("添加失败，请重试！");
        window.history.go(-1);
        //window.location.reload();
    }
    else {
        window.location.href = "/actions/Catalog.action";
    }

</script>



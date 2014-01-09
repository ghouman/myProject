<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="/WEB-INF/jsp/common/noLoginTop.jsp" %>

<div class="container">
    <div class="jumbotron masthead">
        <h2>系统异常，请重试或联系管理员!</h2>

        <p style="font-size: 14px"><stripes:messages/>
            ${exception}
            <!--
           <a class="btn btn-success btn-large "   href="CustomerSurvey.action">客户调研列表</a>
           <a class="btn btn-success btn-large"   href="Customer.action">客户名单列表</a>
            -->
        </p>
        <ul class="masthead-links">
            <li>
                <a>©2013 ghouman and/or its affiliates. All rights reserved.</a>
            </li>
            <li>

            </li>
            <li>
                xiaoqiang.huang@wgbp.net
            </li>
            <li>
                Version 1.0
            </li>
        </ul>
    </div>
    <div class="bs-docs-social">
        <div class="container">
            <ul class="bs-docs-social-buttons">

            </ul>
        </div>
    </div>
</div>

<script type="text/javascript">
    //delCookie ('SPRING_SECURITY_REMEMBER_ME_COOKIE');
</script>



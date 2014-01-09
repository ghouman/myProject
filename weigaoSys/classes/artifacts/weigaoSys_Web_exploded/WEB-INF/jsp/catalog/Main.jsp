<%@ include file="../common/IncludeTop.jsp"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<div class="container-fluid">

<div id="Main" class="row-fluid">


<%--<%@ include file="../common/nav.jsp"%>   --%>
    <div class="jumbotron masthead" >
        <div class="container">
      <h2>欢迎使用威高血液净化公司客户调研管理系统!</h2>
      <p style="font-size: 20px;margin-top: 50px">请使用IE8以上浏览器或谷歌,火狐等主流浏览器</p>
            <p style="font-size: 25px;margin-top: 50px;font-weight: bolder;color: #ffff00" id="reminder">

            </p>
      <p style="height: 120px">
          <a href="CustomerSurvey.action" class="btn btn-primary btn-large">客户调研列表</a>
          <a href="/actions/Customer.action" class="btn btn-primary btn-large">客户名单列表</a>
      </p>
        <ul class="masthead-links">
              <li>
                <a >©2013 ghouman and/or its affiliates. All rights reserved.</a>
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
    </div>

    <div class="bs-docs-social">
      <div class="container">
        <ul class="bs-docs-social-buttons">

        </ul>
      </div>
    </div>




</div>

<%@ include file="../common/IncludeBottom.jsp"%>
<script type="text/javascript">
    function initReminder(){
        if (WEGO.roleWeb == "业务员") {
                $.ajax({
                    type: "POST",
                    url: "/actions/CustomerSurvey.action?getNoCheckCount=",
                    data: "",
                    contentType: "application/x-www-form-urlencoded; charset=utf-8",
                    dataType: "json",
                    success: function (obj) {
                        var size = obj.size;
                        $("#reminder").text("");
                        $("#reminder").text('温馨提示：亲！您有'+size+'个调研单未提交！赶快去处理吧。');
                    },
                    error: function () {

                    }
                });
            }
    }

</script>

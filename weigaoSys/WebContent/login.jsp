<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="stripes"
           uri="http://stripes.sourceforge.net/stripes.tld" %>


<html xmlns="http://www.w3.org/1999/xhtml" lang="en">

<head>
    <base href="<%=basePath%>">
    <meta name="generator"
          content="HTML Tidy for Linux/x86 (vers 1st November 2002), see www.w3.org"/>
    <meta content="text/html" charset="utf-8" http-equiv="Content-Type"/>
    <meta http-equiv="Cache-Control" content="max-age=0"/>
    <meta http-equiv="Cache-Control" content="no-cache"/>
    <title>威高调研管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="ghouman <ghouman@cisco.com>">

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
<link href="../bootstrap/css/bootstrap.css" rel="stylesheet">
<script src="../bootstrap/js/jquery.js"></script>
<script src="../bootstrap/js/bootstrap.js"></script>
<script src="../js/common/jquery.validate.js"></script>
<script src="../js/common/messages_zh.js"></script>

<style type="text/css">

    * {
        margin: 0;
        padding: 0;
    }

    body {
        background: #444 url(../images/2.png)
    }

    .loginBox {
        width: 420px;
        height: 230px;
        padding: 0 20px;
        border: 1px solid #fff;
        color: #000;
        margin-top: 40px;
        border-radius: 8px;
        background: white;
        box-shadow: 0 0 15px #222;
        background: -moz-linear-gradient(top, #fff, #efefef 8%);
        background: -webkit-gradient(linear, 0 0, 0 100%, from(#f6f6f6), to(#f4f4f4));
        font: 11px/1.5em 'Microsoft YaHei';
        position: absolute;
        left: 50%;
        top: 50%;
        margin-left: -210px;
        margin-top: -115px;
    }

    .loginBox h2 {
        height: 45px;
        font-size: 20px;
        font-weight: normal;
    }

    .loginBox .left {
        border-right: 1px solid #ccc;
        height: 100%;
        padding-right: 20px;
    }
    .alert {
        margin-bottom: 0px;
    }
</style>

</head>
<body>
<c:if test="${SPRING_SECURITY_LAST_EXCEPTION.message!=null}">
<div class="alert alert-block alert-error fade in" >
            <button type="button" class="close" data-dismiss="alert">×</button>
            <h4 class="alert-heading">登录信息!</h4>
            <p>
			${SPRING_SECURITY_LAST_EXCEPTION.message}
			</p>

          </div>
</div>
</c:if>
<div id="global" style="display:none">
<div class="alert alert-block alert-error fade in">
            <button type="button" class="close" data-dismiss="alert">×</button>
            <h4 class="alert-heading">您的浏览器版本过低!</h4>
            <p>
			系统不支持您当前使用的浏览器，为了您更好体验本系统，请使用新版谷歌，火狐或IE8以上浏览器，请及时更新您的浏览器。
			</p>
            
          </div>
</div>
<img src="../images/102.jpg" class="img-responsive" alt="log image"/>
<div class="container">

    <section class="loginBox row-fluid">
        <section class="span7 left">
        <%--
       <stripes:form id="loginForm" beanclass="org.mybatis.weigao.web.actions.LoginActionBean" class="form-inline" >
            <h2>用户登录</h2>
            <p style="color: red">${errorMsg} </p>
            <p><input type="text" name="userName" placeholder="请输入用户名" required/></p>

            <p><input type="password" name="password" placeholder="请输入密码" required/></p>

            <section class="row-fluid">
                <section class="span8 lh30"><!--<label><input type="checkbox" name="rememberme"/>下次自动登录</label>--></section>
                <section class="span1"><input type="submit" id="login" name="signon" value=" 登录 " class="btn btn-primary"></section>
            </section>
       </stripes:form>
    --%>
            <form id="submitForm" action="<%=path %>/j_spring_security_check" method="post">
                <h2>用户登录</h2>

                <c:if test="${param.error == 'true'}">
                    <p style="color: red"> 登录失败，请重试! </p>
                </c:if>
                <p><input type="text" name="j_username" id="bestLoginUsername" value="${SPRING_SECURITY_LAST_USERNAME}" placeholder="邮箱" required/></p>
                <p>  <input type="password" name="j_password" id="bestLoginPassword" value="" placeholder="密码" required/></p>
                <section class="row-fluid">
                               <section class="span8 lh30"><label><input type="checkbox" name="_spring_security_remember_me"/>下次自动登录</label></section>
                               <section class="span1"><input type="submit" id="login"  value=" 登录 " class="btn btn-primary"></section>
                           </section>
                </form>
        </section>
        <section class="span5 right">
            <h2>系统提示</h2>
            <section>
                <p style="color: red">
                    本系统采用WEB技术HTML5,为了您更好体验本系统，请使用最新版谷歌，火狐或IE8以上浏览器,请设置您的浏览器为自动更新。
                </p>
                <!--<p><input type="button" value=" 注册 " class="btn"></p> -->
            </section>
        </section>
    </section>
    <!-- /loginBox -->
</div>

<!-- /container -->
</body>
<script type="text/javascript">
    function getCookie(Name)
    {
        var search = Name + "="
        if(document.cookie.length > 0)
        {
            offset = document.cookie.indexOf(search)
            if(offset != -1)
            {
                offset += search.length
                end = document.cookie.indexOf(";", offset)
                if(end == -1) end = document.cookie.length
                return unescape(document.cookie.substring(offset, end))
            }
            else return ""
        }
    }
    if(getCookie('SPRING_SECURITY_REMEMBER_ME_COOKIE')){
        var cookieVal =  getCookie('SPRING_SECURITY_REMEMBER_ME_COOKIE');
        window.location.href='/actions/Catalog.action';
    }

    if($.browser.msie && $.browser.version<10){
           $("#submitForm").validate();
    }
	
	
	if(($.browser.msie && parseFloat($.browser.version)>=8)|| ($.browser.mozilla && parseFloat($.browser.version)>=10) || ($.browser.chrome && parseFloat($.browser.version) >= 26) || ($.browser.safari && parseFloat($.browser.version) >= 5) ){
	} else {
		$("#global").show();
	}
</script>
</html>
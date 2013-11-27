<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="stripes"
           uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" lang="en">

<head>
    <meta name="generator"
          content="HTML Tidy for Linux/x86 (vers 1st November 2002), see www.w3.org"/>
    <title>JPetStore Demo</title>
    <meta content="text/html" charset="utf-8" http-equiv="Content-Type"/>
    <meta http-equiv="Cache-Control" content="max-age=0"/>
    <meta http-equiv="Cache-Control" content="no-cache"/>
    <meta http-equiv="expires" content="0"/>
    <meta http-equiv="Expires" content="Tue, 01 Jan 1980 1:00:00 GMT"/>
    <meta http-equiv="Pragma" content="no-cache"/>
    <script src="../bootstrap/js/jquery.js"></script>
    <script src="../js/common/common.js"></script>
    <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le styles -->
    <link href="../bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="../default/bootstrap-responsive.min.css" rel="stylesheet">
    <link href="../bootstrap/css/docs.css" rel="stylesheet">
    <link href="../bootstrap/css/datepicker.css" rel="stylesheet">
    <link href="../bootstrap/css/bootstrap-modal.css" rel="stylesheet">
    <link href="../bootstrap/js/google-code-prettify/prettify.css" rel="stylesheet">

    <link href="../bootstrap/css/scojs.css" rel="stylesheet">
    <style type="text/css">
        <!--
        #pagebody {
            clear: both;
            min-height: 590px;
            margin-bottom: 40px;
        }

        #wrapper {
            background: white;
            width: 100%;
            min-width: 980px;
        }


        .container .credit {
            margin: 20px 0;
        }  -->
    </style>

</head>

<body id="pagebody">

<!-- Navbar
================================================== -->

    <div class="navbar navbar-fixed-top">
        <div class="navbar-inner">
            <div class="container-fluid">
                <a class="btn btn-navbar" data-toggle="collapse"
                   data-target=".nav-collapse"> <span class="icon-bar"></span> <span
                        class="icon-bar"></span> <span class="icon-bar"></span>
                </a> <a class="brand" href="#">威高血液净化公司客户调研管理系统</a>

                <div class="nav-collapse" id="main-menu">
                    <ul class="nav" id="main-menu-left">
                        <li><a href="Catalog.action">主页</a></li>
                        <li><a id="swatch-link" href="CustomerSurvey.action">客户调研列表</a></li>
                        <li><a id="swatch-link1" href="Customer.action">客户名单列表</a></li>
                        <!--
                        <li class="dropdown"><a class="dropdown-toggle"
                                                data-toggle="dropdown" href="CustomerSurvey.action">客户调研列表<b class="caret"></b></a>
                            <ul class="dropdown-menu" id="swatch-menu">
                                <li><a href="#">Amelia</a></li>
                                <li><a href="#">Cerulean</a></li>
                                <li><a href="#">United</a></li>
                                <li><a href="Catalog.action">Enter the Store</a></li>
                            </ul>
                        </li>
                        <li class="dropdown" id="preview-menu"><a
                                class="dropdown-toggle" data-toggle="dropdown" href="#">Download
                            <b class="caret"></b>
                        </a>
                            <ul class="dropdown-menu">
                                <li><a target="_blank" href="bootstrap.min.css">bootstrap.min.css</a></li>
                                <li><a target="_blank" href="bootstrap.css">bootstrap.css</a></li>
                                <li class="divider"></li>
                                <li><a target="_blank" href="variables.less">variables.less</a></li>
                                <li><a target="_blank" href="bootswatch.less">bootswatch.less</a></li>
                            </ul>
                        </li>   -->
                    </ul>
                    <ul class="nav pull-right" id="main-menu-right">

                        <li><a rel="tooltip" target="_blank"
                               href="#"
                               title="Welcome">Welcome
                            <i class="icon-share-alt"></i>
                        </a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>

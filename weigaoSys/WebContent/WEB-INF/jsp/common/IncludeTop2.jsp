<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Bootstrap, from Twitter</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="../bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="../bootstrap/css/docs.css" rel="stylesheet">
    <link href="../bootstrap/js/google-code-prettify/prettify.css" rel="stylesheet">
    <style type="text/css">

            /* top nav bar --------------------------------------------------------------- */

            /* Navigation Bar Background Color */
        .navbar-inverse .navbar-inner {
            background: #00AEE9;
            background: -moz-linear-gradient(100% 100% 90deg, #0085DA, #00AEE9);
            background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#00AEE9), to(#0085DA));
            background: -o-linear-gradient(top, #00AEE9 0%, #0085DA 100%); /* Opera11.10+ */
            filter: progid:DXImageTransform.Microsoft.Gradient(gradientType = 0, startColorStr = #00AEE9, endColorStr = #0085DA);
            background: -ms-linear-gradient(top, #00AEE9, #0085DA);
            border-bottom: 1px solid #006AAE; /*#IE10*/
        }

        .navbar-inverse .brand {
            color: white;
        }

        .navbar-inverse .brand, .navbar-inverse .nav > li > a {
            color: white;
            text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.25);
        }

        .navbar-inverse .nav .active > a, .navbar-inverse .nav .active > a:hover, .navbar-inverse .nav .active > a:focus {
            background: #007ACC;
            background: -moz-linear-gradient(100% 100% 90deg, #007ACC, #00457F);
            background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#00457F), to(#007ACC));
            background: -o-linear-gradient(top, #00457F 0%, #007ACC 100%);
            filter: progid:DXImageTransform.Microsoft.Gradient(gradientType = 0, startColorStr = #00457F, endColorStr = #007ACC);
            background: -ms-linear-gradient(top, #00457F, #007ACC);
        }

        .navbar-inverse .nav li.dropdown.open > .dropdown-toggle, .navbar-inverse .nav li.dropdown.active > .dropdown-toggle, .navbar-inverse .nav li.dropdown.open.active > .dropdown-toggle {
            background: #2093F5;
            background: -moz-linear-gradient(100% 100% 90deg, #2093F5, #46D3FF);
            background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#46D3FF), to(#2093F5));
            background: -o-linear-gradient(top, #46D3FF 0%, #2093F5 100%); /* Opera11.10+ */
            filter: progid:DXImageTransform.Microsoft.Gradient(gradientType = 0, startColorStr = #46D3FF, endColorStr = #2093F5);
            background: -ms-linear-gradient(top, #46D3FF, #2093F5);
        }

            /* ------------------------------------------------*/
    </style>
    <link href="../bootstrap/css/bootstrap-responsive.css" rel="stylesheet">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Fav and touch icons -->
    <link rel="shortcut icon" href="../assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
</head>

<body>

<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container-fluid">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="#">Project name</a>

            <div class="nav-collapse collapse">
                <ul class="nav">
                    <li class="active"><a href="#">Home</a></li>
                    <li><a href="#systemSet" onclick="loadContent('systemSet',this)">系统设置</a></li>
                    <li><a href="#contact">Contact</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Action</a></li>
                            <li><a href="#">Another action</a></li>
                            <li><a href="#">Something else here</a></li>
                            <li class="divider"></li>
                            <li class="nav-header">Nav header</li>
                            <li><a href="#">Separated link</a></li>
                            <li><a href="#">One more separated link</a></li>
                        </ul>
                    </li>
                </ul>
                <form class="navbar-form pull-right">
                    <input class="span2" type="text" placeholder="Email">
                    <input class="span2" type="password" placeholder="Password">
                    <button type="submit" class="btn">Sign in</button>
                </form>
            </div>
            <!--/.nav-collapse -->
        </div>
    </div>
</div>
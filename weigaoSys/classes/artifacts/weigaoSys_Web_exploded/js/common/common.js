
$(function ($) {
    $.getUrlParam = function (name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]);
        return null;
    };

    SetCookie = function (name, value)//两个参数，一个是cookie的名子，一个是值
    {
        var Days = 30; //此 cookie 将被保存 30 天
        var exp = new Date();    //new Date("December 31, 9998");
        exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
        document.cookie = name + "=" + escape(value) + ";expires=" + exp.toGMTString();
    }

    getCookie = function (name)//取cookies函数
    {
        var arr = document.cookie.match(new RegExp("(^| )" + name + "=([^;]*)(;|$)"));
        if (arr != null) return unescape(arr[2]);
        return null;

    }

    delCookie = function(name)//删除cookie
    {
        var exp = new Date();
        exp.setTime(exp.getTime() - 1);
        var cval = getCookie(name);
        if (cval != null) document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
    }


    getCurrentDate = function () {
        var date = new Date();
        var month = date.getMonth() + 1;
        var strDate = date.getDate();
        if (month >= 1 && month <= 9) {
            month = "0" + month;
        }
        if (strDate >= 0 && strDate <= 9) {
            strDate = "0" + strDate;
        }
        var currentdate = date.getFullYear() + "-" + month + "-" + strDate;
        return currentdate;
    };

    $.showProvinceList = function () {
        var vPortList = getProvinceList();

        $("#province").children().remove();
        var option_ca = "<option value=''>请选择</option>";
        $(vPortList).each(function () {
            var that = this;
            option_ca = option_ca + "<option value='" + that.provinceId + "' >" + that.province + "</option>";
        });
        $("#province").append(option_ca);
    }

});

function getProvinceList() {
    var province = $("#provinceId").val();
    var provinceId;
    $.ajax({
        type: "POST",
        url: "/actions/VPort.action?getProvinceList=",
        data: "",
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        dataType: "json",
        success: function (obj) {
            var vPortList = obj.vPortList;
            $("#province").children().remove();
            var option_ca = "<option value=''>请选择</option>";
            $(vPortList).each(function () {
                var that = this;
                option_ca = option_ca + "<option value='" + that.provinceId + "' >" + that.province + "</option>";
            });
            $("#province").append(option_ca);
            //loadPort(provinceId);
        }
    });
}

function loadPort(provinceId) {
    if (provinceId == undefined) {
        var objS = document.getElementById("province");
        provinceId = objS.options[objS.selectedIndex].value;
    }
    $.ajax({
        type: "POST",
        url: "/actions/VPort.action?getPortList=",
        data: "provinceId=" + provinceId,
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        dataType: "json",
        success: function (obj) {
            var vPortList = obj.vPortList;
            var option_ca = "";
            $("#portID").children().remove();
            $(vPortList).each(function () {
                var that = this;
                option_ca = option_ca + "<option value='" + that.uid + "' >" + that.port + "</option>";
            });
            $("#portID").append(option_ca);
        }
    });
}

function logout() {
    $("#userName").val('');
    $("#authenticated").val('');
    $("#roleWeb").val('');
    WEGO.authenticated = '';
    WEGO.roleWeb = '';
    WEGO.userName = '';
    //window.location.href="/Login.action?signoff="
    window.location.href = "/logout";
}



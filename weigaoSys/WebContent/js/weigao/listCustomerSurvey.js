var roleWeb = WEGO.roleWeb;


$(function () {

    //loadUserInfo();
    loadSalesRegion();
    loadProvinceList();

    $('#surveyDate').datepicker({format: "yyyy-mm-dd"});
    //var startDate = $("#startDate").val();
    $('#surveyDate').val($("#startDate").val());
    $('#surveyDate').datepicker()
        .on('changeDate', function (ev) {
            var surveyDate = new Date(ev.date);
            var year = surveyDate.getFullYear();  //获取年
            var month = (surveyDate.getMonth() + 1) > 9 ? (surveyDate.getMonth() + 1) : '0' + (surveyDate.getMonth() + 1);    //获取月
            var day = surveyDate.getDate() > 9 ? surveyDate.getDate() : '0' + surveyDate.getDate(); //获取日
            var date = year + "-" + month + "-" + day;
            $("#startDate").val(date);
        });
    $('#surveyEndDate').datepicker({format: "yyyy-mm-dd"});
    $('#surveyEndDate').val($("#endDate").val());
    $('#surveyEndDate').datepicker()
        .on('changeDate', function (ev) {
            var surveyDate = new Date(ev.date);
            var year = surveyDate.getFullYear();  //获取年
            var month = (surveyDate.getMonth() + 1) > 9 ? (surveyDate.getMonth() + 1) : '0' + (surveyDate.getMonth() + 1);    //获取月
            var day = surveyDate.getDate() > 9 ? surveyDate.getDate() : '0' + surveyDate.getDate(); //获取日
            var date = year + "-" + month + "-" + day;
            $("#endDate").val(date);
        });

    if (roleWeb == "业务员") {
        $("#addCustomerSurvey").show();
        $("[name='dochecked']").show();
        $("[name='doupdate']").show();
        $("#row>tbody>tr").each(
            function () {
                $(this).find("#dochecked").show();
            }
        )
        //$("#preparer").replaceWith("<input type='text' id='preparer' name='customerSurvey.preparer'/>");
        $("#preparer").attr("readonly", "true");
        //$("#preparer").val(WEGO.userName);
    } else if (roleWeb == "区域主管") {
        $("#addCustomerSurvey").show();
        $("[name='dochecked']").show();
        $("[name='doupdate']").show();
        $("#row>tbody>tr").each(
            function () {
                $(this).find("#dochecked").show();
            }
        )
        //$("#preparerManager").attr("readonly", "true");
        $("[name='dosubmit']").show();
        $("[name='resetStatus']").show();
    } else if (roleWeb == "大区经理") {
        $("[name='dosubmit']").show();
        $("[name='resetStatus']").show();
        //getSelesmanByManagername(WEGO.userName);
    } else if (roleWeb == "客服部") {
        $("[name='dosubmit']").show();
        $("[name='resetStatus']").show();
        //getSelesmanByManagername(WEGO.userName);
    } else if (roleWeb == "系统管理员") {
        $("[name='doverify']").show();
        $("[name='resetStatus']").show();
        $("[name='doupdate']").hide();
    } else if (roleWeb == "其他") {
        $("[name='view']").hide();
    }

})
function query() {
    var customer = $("#customer").val();
    var url = "/actions/CustomerSurvey.action?viewCustomer=&customer=" + customer;
    window.location.href = encodeURI(url);
}
//修改调研记录
function update(uid, isChecked, isSubmit) {

    if (isChecked == '是') {
        alert("此记录已经提交，不能修改");
        return;

    } else if (isSubmit == '是') {
        alert("此记录已经初审，不能修改");
        return;
    }
    window.location.href = "/actions/CustomerSurvey.action?goUpdateCustomerSurvey=&uid=" + uid;
}

function showModal(uid, surveyNo, operate, isUpdate, status) {
    $("#errorMsg2").hide();
    if (operate == "submit") {
        $('#operateModal').find('#status_title').text("初审");
        if (isUpdate == '否') {
            alert("此记录还未提交，不能初审。");
            return;
        } else if (status == '是') {
            alert("此记录已经初审。");
            return;
        } else {
            bindModal(uid, surveyNo, operate, isUpdate);
        }
    } else if (operate == "verify") {
        $('#operateModal').find('#status_title').text("复审");
        if (isUpdate == '否') {
            alert("此记录还未初审，不能复审。");
            return;
        } else if (status == '是') {
            alert("此记录已经复审。");
            return;
        } else {
            bindModal(uid, surveyNo, operate, isUpdate);
        }
    } else if (operate == "returnCheck") {
        $('#operateModal').find('#status_title').text("打回至未提交状态");
        if (status == '否') {
            alert("此记录还未提交，不需要打回。");
            return;
        } else if (roleWeb != '系统管理员' && isUpdate == "是") {
            alert("此记录已经复审，您不能打回。");
            return;
        } else {
            bindModal(uid, surveyNo, operate, isUpdate);
        }
    }
}

function bindModal(uid, surveyNo, operate, isUpdate) {
    $('#operateModal').on('show', function (e) {
        $("#dosubmit").click(function (e) {
            if (operate == 'returnCheck') {
                if ($.trim($("#remark").val()) == "" || $("#remark").val() == null) {
                    $("#errorMsg2").show();
                    $("#remark").focus();
                    e.preventDefault();
                    return;
                }
            }
            $(this).attr("disabled", "disabled");
            updateStaus(uid, surveyNo, operate, isUpdate, e);
            e.preventDefault();
        });
    });
    $('#operateModal').modal({
        backdrop: 'static',
        show: true
    });
    //$('#operateModal').modal('show');
}
//修改调研记录状态
function updateStaus(uid, surveyNo, operate, isUpdate, e, name) {

    var param;
    var remark = $("#remark").val();
    if (operate == "checked") {
        if (WEGO.userName != name) {
            alert("您只能提交自己的调研单!");
            e != undefined ? e.preventDefault() : '';
            return;
        }
        if (isUpdate == '是') {
            e != undefined ? e.preventDefault() : '';
            alert("此记录已经提交,不能重复提交！");
            return;
        }
        param = 'checked=1';

    } else if (operate == "submit") {
        if (isUpdate == '否') {
            alert("此记录还未提交，不能初审。");
            e != undefined ? e.preventDefault() : '';
            return;
        }
        param = 'submit=1&submitMemo=' + remark;
    } else if (operate == "verify") {
        if (isUpdate == '否') {
            alert("此记录还未初审，不能复审。");
            e != undefined ? e.preventDefault() : '';
            return;
        }
        param = 'verify=1&verifyMemo=' + remark;
    } else if (operate == "returnCheck") {
        param = 'returnCheckRemark=' + remark;
    }
    $.ajax({
        type: "POST",
        url: "/actions/CustomerSurvey.action?updateCustomerStatus=",
        data: param + "&uid=" + uid,
        success: function (obj) {
            var customerSurvey = obj.customerSurvey;
            $("#surveyNo").val(surveyNo);
            $("#checked").val('');
            $("#verify").val('all');
            $("#submit").val('');
            //$(".alert").alert();
            alert("操作成功");
            e != undefined ? e.preventDefault() : '';
            $("#query").click();
            e != undefined ? e.preventDefault() : '';
        },
        error: function (e) {
            console.log("提交失败，请重试或联系管理员,错误码：" + e.status);
        }
    });
}

var customerObj;
function findCustomer() {
    var customerName_M = $("#customerName_M").val();
    if (customerName_M == '') {
        $("#errorMsg").show();
        return;
    }
    $("#errorMsg").hide();

    $.ajax({
        type: "POST",
        url: "/actions/Customer.action?showCustomer=",
        data: "customerName=" + customerName_M + '&size=10',
        contentType: "application/x-www-form-urlencoded; charset=utf-8",

        dataType: "json",
        success: function (obj) {
            var customerList = obj.customerList;
            // var tr_html;
            var tbody_customer = '<tbody id="tr_customer"><tr><th></th><th>客户名称</th> <th>所属医院</th><th>业务员</th><th>销售大区</th></tr>';
            if ($("#tr_customer")) {
                $("#tr_customer").remove();
            }
            // $("#tr_customer").val('');
            $(customerList).each(function () {
                var that = this;
                tbody_customer = tbody_customer + '<tr><td><input type="hidden" id="uid" value="' + that.uid + '">' +
                    '<input type="hidden" id="surveyId" value="' + that.surveyId + '">' +
                    '<input type="hidden" id="isCheck" value="' + that.check + '">' +
                    '<input type="hidden" id="c_surveyNo" value="' + that.surveyNo + '">' +
                    '<input type="hidden" id="salesFloor" value="' + that.salesFloor + '">' +
                    ' <input type="radio" name="selectRadio" id="selectRadio" ' +
                    'value="' + JSON.stringify(JSON.stringify(that)) + '"/> <span style="display: none" id="spanObj">' + JSON.stringify(that) + '</span></td><td>'
                    + that.customerName + '</td><td>' + that.zect + '</td><td>' + that.clerk + '</td><td>' + this.salesRegion + '</td></tr>';
            });
            tbody_customer = tbody_customer + '</tbody>';
            $("#tab_customer").append(tbody_customer);

        }
    });
}

function selectCustomer() {
    var obj = $("input[name='selectRadio']:checked").next("#spanObj").html();
    if (!obj) {
        alert('请选择一个客户');
        return;
    }
    //var surveyNo = $("input[name='selectRadio']:checked").prev("#c_surveyNo").val();
    var isCheck = $("input[name='selectRadio']:checked").parent().find("#isCheck").val();
    var surveyId = $("input[name='selectRadio']:checked").parent().find("#surveyId").val();
    var customerUid = $("input[name='selectRadio']:checked").parent().find("#uid").val();
    if (surveyId == null || surveyId == '') {
        window.location.href = '/actions/CustomerSurvey.action?goAddCustomerSurvey=&obj=' + encodeURI(encodeURI(obj)) + '&customerUid=' + customerUid;
    } else if (isCheck == 'true') {
        alert('此客户已经已有提交的调研记录，系统重定向到查看界面');
        window.location.href = '/actions/CustomerSurvey.action?viewCustomerSurveyByUID=&uid=' + surveyId;
    } else {
        alert('此客户已经已有未提交的调研记录，系统重定向到修改界面');
        update(surveyId, isCheck, '');
        //window.location.href = '/actions/CustomerSurvey.action?goAddCustomerSurvey=&obj=' + encodeURI(encodeURI(obj));
        /* $("#surveyForm").find("input").each(function(){
         $(this).val('');
         });
         $("#surveyNo").val(surveyNo);
         $("#query").click();*/
    }
}

function getSelesmanByManagername(managerName) {
    $.ajax({
        type: "POST",
        url: "/actions/Salesman.action?getSalesman=",
        data: "managerName=" + managerName,
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        dataType: "json",
        success: function (obj) {
            var preparerList = obj.salemansList;
            var select_prepare = document.getElementById('preparer');
            var option_prepare;
            $(preparerList).each(function () {
                select_prepare.add(new Option(this.clerk, this.clerk));
            });
        }
    });
}

function clearVal(){
    $("#surveyDate").val('');
    $("#surveyEndDate").val('');
    $("#startDate").val('');
    $("#endDate").val('');
}
$(function () {
    var roleWeb = WEGO.roleWeb;
    var userName = WEGO.userName;
    loadSalesRegion();
    loadProvinceList();

    $('.datepicker').datepicker({format: "yyyy-mm-dd"});

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
        $("#preparer").val(userName);
    } else if (roleWeb == "区域主管") {
        $("#addCustomerSurvey").show();
        $("[name='dochecked']").show();
        $("[name='doupdate']").show();
        $("#row>tbody>tr").each(
            function () {
                $(this).find("#dochecked").show();
            }
        )
        //$("#preparer").replaceWith("<input type='text' id='preparer' name='customerSurvey.preparer'/>");
        $("[name='dosubmit']").show();
        $("[name='resetStatus']").show();
    } else if (roleWeb == "大区经理") {
        $("[name='dosubmit']").show();
        $("[name='resetStatus']").show();
        //getSelesmanByManagername(userName);
    } else if (roleWeb == "客服部") {
        $("[name='dosubmit']").show();
        $("[name='resetStatus']").show();
        //getSelesmanByManagername(userName);
    } else if (roleWeb == "系统管理员") {
        $("[name='doverify']").show();
        $("[name='resetStatus']").show();
        $("[name='doupdate']").hide();
    }

})
function query() {
    var customer = $("#customer").val();
    var url = "/actions/CustomerSurvey.action?viewCustomer=&customer=" + customer;
    window.location.href = encodeURI(url);
}
//修改调研记录
function update(uid, isChecked, isSubmit) {

    if ( isChecked == '是') {
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
        $("#dosubmit").click(function () {
            if (operate == 'returnCheck') {
                if ($.trim($("#remark").val()) == "" || $("#remark").val() == null) {
                    $("#errorMsg2").show();
                    $("#remark").focus();
                    return;
                }
            }
            $(this).attr("disabled", "disabled");
            updateStaus(uid, surveyNo, operate, isUpdate)
        });
    });
    $('#operateModal').modal('show');
}
//修改调研记录状态
function updateStaus(uid, surveyNo, operate, isUpdate) {

    var param;
    var remark = $("#remark").val();
    if (operate == "checked") {
        if (isUpdate == '是') {
            alert("此记录已经提交,不能重复提交！");
            return;
        }
        param = 'checked=1';

    } else if (operate == "submit") {
        if (isUpdate == '否') {
            alert("此记录还未提交，不能初审。");
            return;
        }
        param = 'submit=1&submitMemo=' + remark;
    } else if (operate == "verify") {
        if (isUpdate == '否') {
            alert("此记录还未初审，不能复审。");
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
            $("#verify").val('');
            $("#submit").val('');
            $(".alert").alert();
            alert("操作成功");
            $("#query").click();
        },
        error: function (e) {
            alert("提交失败，请重试或联系管理员,错误码：" + e.status);
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
                tbody_customer = tbody_customer + '<tr><td><input type="radio" name="selectRadio" id="selectRadio" value="' + JSON.stringify(JSON.stringify(that)) + '"/> <span style="display: none" id="spanObj">' + JSON.stringify(that) + '</span></td><td>'
                    + that.customerName + '</td><td>' + that.zect + '</td><td>' + that.clerk + '</td><td>' + this.salesRegion + '</td></tr>';

                // $("#tr_customer").append('<tr><td><input type="radio" name="selectRadio" id="selectRadio" onclick="goAddCustomer(this)"/> </td><td>'
                //       +this.customerName+'</td><td>'+this.zect+'</td><td>'+this.clerk+'</td><td>'+this.salesRegion+'</td></tr>');
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
    //obj = $("input[name='selectRadio']:checked").next("#spanObj").html();
    window.location.href = '/actions/CustomerSurvey.action?goAddCustomerSurvey=&obj=' + encodeURI(encodeURI(obj));
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
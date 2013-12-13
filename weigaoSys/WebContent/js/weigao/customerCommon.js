
function loadUpdateStaffInfo(uid) {
    //加载负责人信息
    var tr_id = 0;

    $.ajax({
        type: "POST",
        url: "/actions/CustomerStaff.action?getCustomerStaffByCID=",
        data: "customerId=" + uid,
        contentType: "application/x-www-form-urlencoded; charset=utf-8",

        dataType: "json",
        success: function (obj) {
            var customerStaffList = obj.customerStaffList;
            var tr_customerStaff = "";

            $(customerStaffList).each(function () {
                tr_id++;
                var that = this;
                tr_customerStaff = tr_customerStaff + '<tr id=' + tr_id + '>' +
                    '<td ><input type="text" style="width:90%" id="staff" required value=' + that.staff + ' ></td>' +
                    '<td ><input type="text" style="width:90%" id="staffDuty"' +
                    'data-provide="typeahead" data-source=["院长","副院长","设备负责人","财务负责人","血透室主任","肾内科主任","护士长","工程师"] value=' + that.staffDuty + '></td>' +
                    '<td ><input type="text" style="width:90%" id="staffTel" value=' + that.staffTel + '></td>' +
                    '<td ><input type="text" style="width:90%" id="staffForce" value=' + this.staffForce + '></td>' +
                    '<td ><input type="text" style="width:90%" id="staffFavor" value=' + this.staffFavor + '></td>' +
                    '<td ><input type="text" style="width:90%" id="staffImpact" value=' + this.staffImpact + '></td>' +
                    '<td ><input type="text" style="width:90%" id="staffBirth" value=' + this.staffBirth + '></td>' +
                    '<td ><div width="80%" class="btn btn-primary" onclick="removeProd(' + tr_id + ')">移除</div></td></tr>';
            });
            //$('#staffBirth').datepicker();
            $("#tr_customerStaff").replaceWith(tr_customerStaff);
        },
        error: function () {
            alert("加载负责人失败,请重试");
        }
    });
}

function loadStaffInfo(uid) {
    //加载负责人信息
    var tr_id = 0;

    $.ajax({
        type: "POST",
        url: "/actions/CustomerStaff.action?getCustomerStaffByCID=",
        data: "customerId=" + uid,
        contentType: "application/x-www-form-urlencoded; charset=utf-8",

        dataType: "json",
        success: function (obj) {
            var customerStaffList = obj.customerStaffList;
            var tr_customerStaff = "";

            $(customerStaffList).each(function () {
                tr_id++;
                var that = this;
                tr_customerStaff = tr_customerStaff + '<tr id=' + tr_id + '>' +
                    '<td >' + that.staff + '</td>' +
                    '<td >' + that.staffDuty + '</td>' +
                    '<td >' + that.staffTel + '</td>' +
                    '<td >' + this.staffForce + '</td>' +
                    '<td >' + this.staffFavor + '</td>' +
                    '<td >' + this.staffImpact + '</td>' +
                    '<td >' + this.staffBirth + '</td>' +
                    '</tr>';
            });
            //$('#staffBirth').datepicker();
            $("#tr_customerStaff").replaceWith(tr_customerStaff);
        },
        error: function () {
            alert("加载负责人失败,请重试");
        }
    });
}

function addCustomerLine() {
    var tr_id = $("#tr_category>tbody>tr:last").attr("id");
    tr_id++;
    var tr_html = '<tr id=' + tr_id + '>' +
        '<td ><input type="text" style="width:90%" id="staff" required></td>' +
        '<td ><input type="text" style="width:90%" id="staffDuty" ' +
        'data-provide="typeahead" data-source=["院长","副院长","设备负责人","财务负责人","血透室主任","肾内科主任","护士长","工程师"]></td>' +
        '<td ><input type="text" style="width:90%" id="staffTel" ></td>' +
        '<td ><input type="text" style="width:90%" id="staffForce" ></td>' +
        '<td ><input type="text" style="width:90%" id="staffFavor" ></td>' +
        '<td ><input type="text" style="width:90%" id="staffImpact" /></td>' +
        '<td ><input type="text" style="width:90%" id="staffBirth" ></td>' +
        '<td ><div width="width:80%" class="btn btn-primary" onclick="removeProd(' + tr_id + ')">移除</div></td></tr>';
    $("#tr_category").append(tr_html);
}
//按tr ID 移除行
function removeProd(tr_id) {
    $('#' + tr_id).remove();
}

function getCustomerStaffDetail() {
    //收集客户负责人明细
    //var jsonObj = {};
    //$("#operate").attr("disabled","disabled");
    //$("#operate").removeClass('btn-primary');
    var arrayObj = [];
    var isAddProd = false;
    var customerId = $("#uid").val();
    $("#tr_category>tbody>tr").each(
        function () {
            if (this.id != 0) {
                var obj = {};
                obj.customerId = customerId;
                obj.staff = $(this).find("#staff").val();
                obj.staffDuty = $(this).find("#staffDuty").val();
                obj.staffTel = $(this).find("#staffTel").val();
                obj.staffForce = $(this).find("#staffForce").val();
                obj.staffFavor = $(this).find("#staffFavor").val();
                obj.staffImpact = $(this).find("#staffImpact").val();
                obj.staffBirth = $(this).find("#staffBirth").val();
                isAddProd = true;
                arrayObj.push(obj);
            }
        });
    $("#jsonString").val('');
    if (isAddProd) {
        $("#jsonString").val(JSON.stringify(arrayObj));
    }
    //$("#customerForm").submit();
    return;
}

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
            var option_ca = "";
            $("#province").children().remove();
            $(vPortList).each(function () {
                var that = this;
                if(province == that.province){
                    provinceId =   that.provinceId;
                    option_ca = option_ca + "<option selected='selected' value='" + that.provinceId + "' >" + that.province + "</option>";
                } else {
                    option_ca = option_ca + "<option value='" + that.provinceId + "' >" + that.province + "</option>";
                }
            });
            $("#province").append(option_ca);
            loadPort(provinceId);
        }
    });
}

function loadPort(provinceId){
    if(provinceId==undefined){
        var objS = document.getElementById("province");
            provinceId = objS.options[objS.selectedIndex].value;
    }
    $.ajax({
            type: "POST",
            url: "/actions/VPort.action?getPortList=",
            data: "provinceId="+provinceId,
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            dataType: "json",
            success: function (obj) {
                var vPortList = obj.vPortList;
                var option_ca = "";
                $("#portID").children().remove();
                $(vPortList).each(function () {
                    var that = this;
                    if($("#port").val()==that.uid){
                        option_ca = option_ca + "<option selected='selected' value='" + that.uid + "' >" + that.port + "</option>";
                    } else {
                        option_ca = option_ca + "<option value='" + that.uid + "' >" + that.port + "</option>";
                    }
                });
                $("#portID").append(option_ca);
            }
        });
}

function showProvinceList() {
    var vPortList = getProvinceList();
    var option_ca = "<option value=''>请选择</option>";
    $("#province").children().remove();
    $(vPortList).each(function () {
        var that = this;
        option_ca = option_ca + "<option value='" + that.provinceId + "' >" + that.province + "</option>";
    });
    $("#province").append(option_ca);
}
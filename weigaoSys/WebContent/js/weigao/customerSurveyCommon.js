function getSurveyNo(){
    $.ajax({
            type: "POST",
            url: "/actions/CustomerSurvey.action?getSurveyNo=",
            data: "",
            contentType: "application/x-www-form-urlencoded; charset=utf-8",

            dataType: "json",
            success: function (obj) {
                var surveyNo = obj.surveyNo;
                $("#surveyNo").val(surveyNo);
            },
            error: function () {
                alert("获取调研编号失败,请重试");
            }
        });
}

function loadStaffInfo(uid) {
    //加载负责人信息
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
                var that = this;
                tr_customerStaff = tr_customerStaff + '<tr><td>'
                    + that.staff + '</td><td>' + that.staffDuty + '</td><td>' + that.staffTel +
                    '</td><td>' + this.staffForce + '</td><td>' + this.staffFavor
                    + '</td><td>' + this.staffImpact + '</td><td>' + this.staffBirth + '</td></tr>';
            });

            $("#tr_customerStaff").replaceWith(tr_customerStaff);
        },
        error: function () {
            alert("加载负责人失败,请重试");
        }
    });
}

function initCustomer(jsonObj) {
    $('#customerId').val(jsonObj.uid);
    $('#customer').append(jsonObj.customerName);
    $('#zect').append(jsonObj.zect);
    $('#custVal').append(jsonObj.custVal);
    $('#address').append(jsonObj.address);
    $('#webSite').append(jsonObj.website);
    $('#healthClass').append(jsonObj.healthClass);
    $('#hierarchy').append(jsonObj.hierarchy);
    $('#coop_DT').append(jsonObj.coop_DT);
    $('#postalCode').append(jsonObj.postalCode);
    $('#port').append(jsonObj.port);
    $('#province').append(jsonObj.province);
    $('#clerk').append(jsonObj.clerk);
    $('#salesRegion').append(jsonObj.salesRegion);
    $('#labOffice').append(jsonObj.labOffice);
    $('#labTel').append(jsonObj.labTEL);
    $('#hospitalMemo').append(jsonObj.hospitalMemo);

    //$('#surveyDate').datepicker();
    // var currentDate = getCurrentDate();
    //$('#surveyDate').val(currentDate);
}

function loadProInfo() {

    var plate;
    var objS = document.getElementById("prodType");
    plate = objS.options[objS.selectedIndex].value;
    //加载产品下拉列表
    $.ajax({
        type: "POST",
        url: "/actions/Category.action?getAllCategory=",
        data: "plate=" + plate,
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        dataType: "json",
        beforeSend: function () {
            $("#addProdLine").css("disabled", "true");
        },
        success: function (obj) {
            var categoryList = obj.categoryList;
            var option_ca = "<option value=''>请选择</option>";
            $("#category").children().remove();
            $(categoryList).each(function () {
                var that = this;
                option_ca = option_ca + "<option value='" + that.uid + "' >" + that.category + "</option>";
            });

            $("#category").append(option_ca);
            $("#addProdLine").css("disabled", "false");
        },
        complete: function () {

        }
    });
}
//加载产品品牌下拉列表
function loadBrand() {
    var categoryId;
    var objS = document.getElementById("category");
    categoryId = objS.options[objS.selectedIndex].value;

    $.ajax({
        type: "POST",
        url: "/actions/Category.action?getBrandByCID=",
        data: "categoryId=" + categoryId,
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        dataType: "json",
        beforeSend: function () {
            $("#addProdLine").attr("disabled", "true");
            $("#addProdLine").removeClass("btn-primary");
        },
        success: function (obj) {
            var brandList = obj.brandList;
            var option_ca = "<option value=''>请选择</option>";
            $("#brand").children().remove();
            $(brandList).each(function () {
                var that = this;
                option_ca = option_ca + "<option value='" + that.brandUid + "'>" + that.brand + "</option>";
            });

            $("#brand").append(option_ca);
            $("#addProdLine").removeAttr("disabled");
            $("#addProdLine").addClass("btn-primary");
        }
    });
}
//加载产品品牌规格下拉列表
function loadFamily() {
    var brandId;
    var objS = document.getElementById("brand");
    brandId = objS.options[objS.selectedIndex].value;

    //加载产品下拉列表
    $.ajax({
        type: "POST",
        url: "/actions/Category.action?getFamilyByBID=",
        data: "brandId=" + brandId,
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        dataType: "json",
        success: function (obj) {
            var familyList = obj.familyList;
            var option_ca = "<option value=''>请选择</option>";
            $("#family").children().remove();
            $(familyList).each(function () {
                var that = this;
                option_ca = option_ca + "<option value='" + that.familyUid + "'>" + that.family + "</option>";
            });

            $("#family").append(option_ca);
        }
    });
}
//加载产品品牌规格型号下拉列表
function loadPartNo() {
    var familyId;
    var objS = document.getElementById("family");
    familyId = objS.options[objS.selectedIndex].value;

    //加载产品下拉列表
    $.ajax({
        type: "POST",
        url: "/actions/Category.action?getPartNoByFID=",
        data: "familyId=" + familyId,
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        dataType: "json",
        success: function (obj) {
            var partNoList = obj.partNoList;
            var option_ca = "<option value=''>请选择</option>";
            $("#partNo").children().remove();
            $(partNoList).each(function () {
                var that = this;
                option_ca = option_ca + "<option value='" + that.partNoUid + "'>" + that.partNo + "</option>";
            });

            $("#partNo").append(option_ca);
        }
    });
}
function addProdLine() {
    var category = $("#category").find("option:selected").text();
    var brand = $("#brand").find("option:selected").text();
    var family = $("#family").find("option:selected").text();
    var partNo = $("#partNo").find("option:selected").text();
    var partNoUid = $("#partNo").val();
    if (category == "请选择" || category == null) {
        alert("请选择产品类别");
        return;
    }
    if (brand == "请选择" || brand == null) {
        alert("请选择产品品牌");
        return;
    }
    if (family == "请选择" || family == null) {
        alert("请选择产品规格");
        return;
    }
    if (partNo == "请选择" || partNo == null) {
        alert("请选择产品型号");
        return;
    }
    tr_id = $("#tr_category>tr:last").attr("id");
    tr_id++;
    var tr_html = "<tr id=" + tr_id + "><td>" + category + "</td><td>" + brand + "</td><td>" + family + "</td><td>" + partNo +
        "</td><td><input type='number' required value='0' style='width:60px' id='amount'/></td>" +
        "<td><input type='number' style='width:60px' id='reUseInfo'/></td>" +
        "<td><input type='number' value='0' required style='width:60px' id='price'/></td>" +
        "<td><input type='text' class='datepicker' style='width:100px'  id='date" + tr_id + "'" +
        " /></td>" +
        "<td><textarea  id='remark' style='width:90%' placeholder='请输入备注'></textarea></td>" +
        "<input type='hidden' id='partNoUid' value='" + partNoUid + "'>" +
        "<td><div class='btn btn-primary' onclick='removeProd(" + tr_id + ")'>移除</div></td></tr>"

    $("#tr_category").append(tr_html);
    //var currentDate = getCurrentDate();
    $('#date' + tr_id).datepicker({format:"yyyy-mm-dd"});
    //$('#date' + tr_id).val(currentDate);
}
//移除最末行
function removeLastProd(id) {
    var tr_id = $("#" + id + ">tr:last").attr("id");
    if (tr_id > 0) {
        $('#' + tr_id).remove();
    }
}

//按tr ID 移除行
function removeProd(tr_id) {
    $('#' + tr_id).remove();
}

function getCustomerSurveyDetail() {
    //收集调研产品明细
    //var jsonObj = {};
    //$("#operate").attr("disabled","disabled");
    //$("#operate").removeClass('btn-primary');
    var arrayObj = [];
    var isAddProd = false;
    var surveyNo = $("#surveyNo").val();
    $("#tr_category>tr").each(
        function () {
            if (this.id != 0) {
                var obj = {};
                obj.surveyNo = surveyNo;
                obj.ahsca = $(this).find("#amount").val();//数量
                obj.aPrice = $(this).find("#price").val(); //价格
                obj.partID = $(this).find("#partNoUid").val(); //规格ID
                obj.bReUseNote = $(this).find("#reUseInfo").val();//复用说明
                obj.bInstallDate = $(this).find(".datepicker").val(); //装机日期
                obj.remark = $(this).find("#remark").val();
                isAddProd = true;
                arrayObj.push(obj);
            }
        });
    //jsonObj.arrayObj = arrayObj;
    //console.log("***JSON.stringify(jsonObj)***:"+JSON.stringify(jsonObj));
    $("#jsonString").val('');
    if (isAddProd) {
        $("#jsonString").val(JSON.stringify(arrayObj));
    }

    //$("#customerSurveyForm").submit();
    return;
}
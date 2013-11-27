$(function () {
    var customerId = $("#customerId").val();
    loadStaffInfo(customerId);

});

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
                        + '</td><td>' + this.staffImpact + '</td></tr>';
                });

                $("#tr_customerStaff").replaceWith(tr_customerStaff);
            }
        });
    }

function updateCustomerSurvey() {
    //收集调研产品明细
    //var jsonObj = {};
    var arrayObj = [];
    var isAddProd = false;
   var surveyNo =  $("#surveyNo").val();
    $("#tr_category>tr").each(
        function () {
            if (this.id != 0) {
                var obj = {};
                obj.uid = $(this).find("#uid").val();;
                obj.ahsca = $(this).find("#amount").val();//数量
                obj.aPrice = $(this).find("#price").val(); //价格
                obj.partID = $(this).find("#partNoUid").val(); //规格ID
                obj.bReUseNote = $(this).find("#reUseInfo").val();//复用说明
                obj.bInstallDate = $(this).find(".datepicker").val(); //装机日期
                isAddProd = true;
                arrayObj.push(obj);
            }
        });
    //jsonObj.arrayObj = arrayObj;
    //console.log("***JSON.stringify(jsonObj)***:"+JSON.stringify(jsonObj));
    $("#jsonString").val('');
    if(isAddProd){
        $("#jsonString").val(JSON.stringify(arrayObj));
    }
    return;
}


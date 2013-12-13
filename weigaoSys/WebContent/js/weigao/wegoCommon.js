function loadSalesRegion() {
    var jsonData = [];
    $.ajax({
        type: "POST",
        url: "/actions/Component.action?getSalesRegionList=",
        data: "",
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        dataType: "json",
        success: function (obj) {
            jsonData = obj.salesRegionList;
            var ms = $('#salesRegion').magicSuggest({
                width: 190,
                data: jsonData,
                emptyText: '请输入或选择',
                resultAsString: true,
                maxSelection: 1,
                valueField: 'name',
                maxSelectionRenderer: function () {
                }
            });
            $(ms).on('selectionchange', function (event, combo, selection) {
                //$("#salesRegion_v").val(selection[0].name);
            });
        }
    });
}


function loadProvinceList() {
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
            var ms = $('#province').magicSuggest({
                width: 190,
                data: vPortList,
                resultAsString: true,
                maxSelection: 1,
                emptyText: '请输入或选择',
                valueField: 'province',
                displayField: 'province',
                maxSelectionRenderer: function () {
                }
            });
            $(ms).on('selectionchange', function (event, combo, selection) {
                //$("#salesRegion_v").val(selection[0].name);
                loadPortList(selection[0].provinceId);
            });
            //loadPort(provinceId);
        }
    });
}

function loadPortList(provinceId) {

    $.ajax({

        type: "POST",
        url: "/actions/VPort.action?getPortList=",
        data: "provinceId=" + provinceId,
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        dataType: "json",
        success: function (obj) {
            $('#port').replaceWith('<input id="port" name="customer.port" class="form-control" type="text">');
            $('#port').magicSuggest({
                width: 190,
                   data: obj.vPortList,
                   resultAsString: true,
                   maxSelection: 1,
                    emptyText: '请输入或选择',
                   valueField: 'port',
                   displayField: 'port',
                   maxSelectionRenderer: function () {
                   }
               });
        }
    });

}
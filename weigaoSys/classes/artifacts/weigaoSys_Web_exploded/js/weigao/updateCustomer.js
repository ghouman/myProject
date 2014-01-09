$(function () {
    var uid = $("#uid").val();
    loadUpdateStaffInfo(uid);
    showProvinceList();
    $('.datepicker').datepicker({format:"yyyy-mm-dd"});
    if ($.browser.msie && $.browser.version < 10) {
        setTimeout(
            function(){
                $("#customerForm").validate();
        },500)
    }

    /*$('#province').typeahead({
        source: function (query, process) {
            return $.getJSON('/actions/VPort.action?getProvinceList=', {
                query: query
            }, function (data) {
                return process(data.vPortList);
            });
        },
        property: 'Province',
        items: 11,
        onselect: function (obj) {
            var obj = JSON.parse(obj);
            // You still can use the ProvinceID here
            console.log(obj.ProvinceID);
            return obj.Province;
        }
    });*/

});

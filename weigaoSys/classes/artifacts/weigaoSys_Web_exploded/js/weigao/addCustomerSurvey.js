
$(function () {
    var obj = $.getUrlParam('obj');
    var jsonObj = JSON.parse(decodeURIComponent(obj));
    getSurveyNo();//获取调研编号
    initCustomer(jsonObj);
    loadStaffInfo(jsonObj.uid);
    loadProInfo();
    /*$('#addCustomerSurveyForm').scojs_valid({
        rules: {doctor : ['not_empty']

        }
    });*/
    if($.browser.msie && $.browser.version<10){
        $("#customerSurveyForm").validate();
    }


});





$(function () {
    var customerId = $("#customerId").val();
    loadStaffInfo(customerId);
    loadProInfo();
    if($.browser.msie && $.browser.version<10){
           $("#customerSurveyForm").validate();
    }
});

<%@ include file="../common/IncludeTop.jsp" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>

<%--
<link href="../displayTag/css/maven-base.css" rel="stylesheet">
<link href="../displayTag/css/maven-theme.css" rel="stylesheet">
<link href="../displayTag/css/site.css" rel="stylesheet">
<link href="../displayTag/css/screen.css" rel="stylesheet">
--%>
<style type="text/css">
    span.pagebanner {
        background-color: #eee;
        border: 1px dotted #999;
        padding: 2px 4px 2px 4px;
        width: 100%;
        margin-top: 10px;
        display: block;
        border-bottom: none;
    }

    span.pagelinks {
        background-color: #eee;
        border: 1px dotted #999;
        padding: 2px 4px 2px 4px;
        width: 100%;
        display: block;
        border-top: none;
    }
</style>

<div id="responsive" class="modal hide fade alert alert-info" tabindex="-1" data-width="760">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h4>查询客户并选择（添加之前选择客户）</h4>
    </div>
    <div class="modal-body">
        <div class="form-inline" style="margin-bottom: 10px">
            <label for="customer">客户名称:</label>
            <input type="text" name="customerName_M" class="form-control" id="customerName_M" required>
            <label style='display:none;color:red;font-size: 10px' id='errorMsg'>*客户名称不能为空</label>
            <button type="button" class="btn btn-primary" onclick="findCustomer()">查询</button>
            <button type="button" class="btn btn-primary" onclick="selectCustomer()">选择</button>
            <label style='font-size: 10px' id='msg'> 提示：此页最多显示20条</label>
        </div>
        <table class="table table-striped" id="tab_customer">

        </table>
    </div>
    <div class="modal-footer">
        <button type="button" data-dismiss="modal" class="btn">关闭</button>
        <button type="button" class="btn btn-primary" onclick="selectCustomer()">选择</button>
    </div>
</div>

<div class="container">


    <ol class="breadcrumb">
        <li><a href="#">客户调研列表</a></li>
    </ol>

    <stripes:form beanclass="org.mybatis.weigao.web.actions.CustomerSurveyActionBean" class="form-inline">
        <div class="form-group" style="margin-bottom: 10px">
            <label for="customer">客户名称:</label>
            <input type="text" name="customerSurvey.customer" class="form-control" id="customer"
                   value="${actionBean.customerSurvey.customer}">
            <label style="margin-left: 5px" for="surveyNo">调查编号:</label>
            <stripes:text name="customerSurvey.surveyNo" class="form-control" id="surveyNo"/>
            <label style="margin-left: 5px" for="preparer">填表人员:</label>
            <stripes:text name="customerSurvey.preparer" class="form-control" id="preparer"/>
        </div>
        <div class="form-group" style="margin-bottom: 10px">
            <label class="sr-only" for="checked">是否提交:</label>
            <stripes:select name="customerSurvey.checked" id="checked">
                <stripes:option value="">请选择</stripes:option>
                <stripes:option value="0">否</stripes:option>
                <stripes:option value="1">是</stripes:option>

            </stripes:select>
            <label style="margin-left: 5px" for="checked">是否初审:</label>
            <stripes:select name="customerSurvey.submit" id="submit">
                <stripes:option value="">请选择</stripes:option>
                <stripes:option value="0">否</stripes:option>
                <stripes:option value="1">是</stripes:option>

            </stripes:select>
            <label style="margin-left: 5px" for="checked">是否复审:</label>
            <stripes:select name="customerSurvey.verify" id="verify">
                <stripes:option value="">请选择</stripes:option>
                <stripes:option value="0">否</stripes:option>
                <stripes:option value="1">是</stripes:option>

            </stripes:select>


        </div>
        <div class="form-group">
            <label for="surveyDate">调研日期:</label>
            <input type="text" name="customerSurvey.surveyDate" class="datepicker form-control" id="surveyDate">
            <stripes:submit name="viewCustomerSurvey" value="查询" id="query" class="btn btn-primary"
                            style="margin-left: 5px"/>
            <button class=" btn btn-primary" data-toggle="modal" href="#responsive">添加</button>
            <!-- <input type="reset"   class="btn btn-primary" value="重置" >-->

            </button>
        </div>
    </stripes:form>
    <display:table id="row" defaultsort="1" pagesize="30" sort="external" name="actionBean.customerSurveys"
                   requestURI="CustomerSurvey.action" class="table table-striped">
        <display:column property="surveyNo" title="调研编号"/>
        <display:column property="customer" sortable="false" sortName="customer" title="客户名称"/>
        <display:column property="checked" title="是否提交" paramId="checked"/>
        <display:column property="submit" title="是否初审" paramId="submit"/>
        <display:column property="verify" title="是否复审"/>
        <display:column property="preparer" sortable="false" sortName="preparer" title="填表人员"/>
        <display:column title="操作">

            <button type="button" class="btn btn-link" name="doupdate"
                    onclick="update('${row.uid}','${row.checked}','${row.submit}')">
                修改
            </button>
            <stripes:link class="btn btn-link" beanclass="org.mybatis.weigao.web.actions.CustomerSurveyActionBean"
                          event="viewCustomerSurveyByUID" id="view">
                查看
                <stripes:param name="uid" value="${row.uid}"/>
            </stripes:link>
            <button type="button" class="btn btn-link" name="dochecked" style="display:none"
                    onclick="updateStaus('${row.uid}','${row.surveyNo}','checked','${row.checked}')">
                提交
            </button>
            <button type="button" class="btn btn-link" name="dosubmit" style="display:none"
                    onclick="updateStaus('${row.uid}','${row.surveyNo}','submit','${row.checked}')">
                初审
            </button>
            <button type="button" class="btn btn-link" name="doverify" style="display:none"
                    onclick="updateStaus('${row.uid}','${row.surveyNo}','verify','${row.submit}')">
                复审
            </button>

        </display:column>
    </display:table>
    <%--
        <table class="table table-striped">
            <tr>
                <th>客户名称</th>
                <th>所属医院</th>
                <th>城市</th>
                <th>业务员</th>
                <th>销售大区</th>
            </tr>
            <c:forEach var="customerSurvey" items="${actionBean.customerSurveys}">
                <tr>
                    <td>
                            ${customerSurvey.customer}
                    </td>
                    <td>${customerSurvey.zect}</td>
                    <td>${customerSurvey.province}${customerSurvey.port}</td>
                    <td>${customerSurvey.clerk}</td>
                    <td>${customerSurvey.salesRegion}</td>
                </tr>
            </c:forEach>
        </table>
         --%>
</div>
</div>


<%@ include file="../common/IncludeBottom.jsp" %>


<script type="text/javascript">
    var roleWeb = WEGO.roleWeb;
            var userName = WEGO.userName;
    $(function () {

         $('.datepicker').datepicker();

        if (roleWeb == "业务员") {
            $("[name='dochecked']").show()
            $("#row>tbody>tr").each(
                    function () {
                        $(this).find("#dochecked").show();
                    }
            )
            $("#preparer").attr("readonly", "true");
        } else if (roleWeb == "大区经理") {
            $("[name='dosubmit']").show();
        } else if (roleWeb == "系统管理员") {
            $("[name='doverify']").show();
            $("[name='doupdate']").hide();
        }

    })
    function query() {
        var customer = $("#customer").val();
        var url = "/actions/CustomerSurvey.action?viewCustomer=&customer=" + customer;
        window.location.href = encodeURI(url);
    }

    function update(uid, isChecked, isSubmit) {
        if (roleWeb == "业务员" && isChecked == '是') {
            alert("您已经提交，不能修改");
            return;

        } else if (roleWeb == "大区经理" && isSubmit == '是') {
            alert("您已经初审，不能修改");
            return;
        }
        window.location.href="/actions/CustomerSurvey.action?goUpdateCustomerSurvey=&uid="+uid;
    }

    function updateStaus(uid, surveyNo, status, isUpdate) {
        var param;
        if (status == "checked") {
            param = 'checked=1&';
        } else if (status == "submit") {
            if (isUpdate == '否') {
                alert("此记录还未提交，不能初审。");
                return;
            }
            param = 'submit=1&';
        } else if (status == "verify") {
            if (isUpdate == '否') {
                alert("此记录还未初审，不能复审。");
                return;
            }
            param = 'verify=1&';
        }
        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/actions/CustomerSurvey.action?updateCustomerStatus=",
            data: param + "uid=" + uid,
            success: function (obj) {
                var customerSurvey = obj.customerSurvey;
                $("#surveyNo").val(surveyNo);
                $("#checked").val('');
                $("#verify").val('');
                $("#submit").val('');
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
            url: "${pageContext.request.contextPath}/actions/Customer.action?showCustomer=",
            data: "customerName=" + customerName_M,
            contentType: "application/x-www-form-urlencoded; charset=utf-8",

            dataType: "json",
            success: function (obj) {
                //debugger;
                var customerList = obj.customerList;
                // var tr_html;
                var tbody_customer = '<tbody id="tr_customer"><tr><th></th><th>客户名称</th> <th>合作公司</th><th>业务员</th><th>销售大区</th></tr>';
                if ($("#tr_customer")) {
                    $("#tr_customer").remove();
                }
                // $("#tr_customer").val('');
                $(customerList).each(function () {
                    var that = this;
                    //alert('<td>'+this.customerName+'</td><td>'+this.zect+'</td><td>'+this.clerk+'</td><td>'+this.salesRegion+'</td>');
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
        window.location.href = '${pageContext.request.contextPath}/actions/CustomerSurvey.action?goAddCustomerSurvey=&obj=' + encodeURI(encodeURI(obj));
    }

</script>



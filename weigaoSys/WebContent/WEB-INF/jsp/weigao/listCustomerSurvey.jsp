<%@ include file="../common/IncludeTop.jsp" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<script src="../js/weigao/listCustomerSurvey.js"></script>
<link href="../css/magicsuggest-1.3.1.css" rel="stylesheet">
<script src="../js/common/magicsuggest-1.3.1.js"></script>
<script src="../js/weigao/wegoCommon.js"></script>
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

    .form-control {
            width: 180px;
        }
</style>

<div id="responsive" class="modal hide fade" role="dialog" tabindex="-1" data-width="760" aria-hidden="true">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">×</button>
        <h4>查询客户并选择（添加之前选择客户）</h4>
    </div>
    <div class="modal-body">
        <div class="form-inline" style="margin-bottom: 10px">
            <label for="customer">客户名称:</label>
            <input type="text" name="customerName_M" class="form-control" id="customerName_M" required>
            <label style='display:none;color:red;font-size: 10px' id='errorMsg'>*客户名称不能为空</label>
            <button type="button" class="btn btn-primary" onclick="findCustomer()">查询</button>
            <button type="button" class="btn btn-primary" onclick="selectCustomer()">选择</button>
            <label style='font-size: 10px' id='msg'> 提示：此页最多显示10条</label>
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


    <ol class="breadcrumb" style="margin-top: 5px">
        <li><a href="#">客户调研列表</a></li>
    </ol>

    <stripes:form beanclass="org.mybatis.weigao.web.actions.CustomerSurveyActionBean" class="form-inline">
        <table class="table-condensed">
            <tr>
                <td><label for="customer">客户名称:</label></td>
                <td><input type="text" name="customerSurvey.customer" class="form-control" id="customer"
                           value="${actionBean.customerSurvey.customer}"></td>
                <td><label for="surveyNo">调查编号:</label></td>
                <td><stripes:text name="customerSurvey.surveyNo" class="form-control" id="surveyNo"
                                  value="${actionBean.customerSurvey.surveyNo}"/>
                </td>
                <td><label  for="preparer">负责专员:</label></td>
                <td><input type='text' id='preparer' name='customerSurvey.preparer'
                           value="${actionBean.customerSurvey.preparer}" class="form-control"/></td>
            </tr>
            <tr>
                <td><label class="sr-only" for="checked">是否提交:</label></td>
                <td><stripes:select name="customerSurvey.checked" id="checked" style="width:192px">
                    <stripes:option value="all">请选择</stripes:option>
                    <stripes:option value="0" selected="selected">否</stripes:option>
                    <stripes:option value="1">是</stripes:option>
                </stripes:select></td>
                <td><label  for="submit">是否初审:</label></td>
                <td><stripes:select name="customerSurvey.submit" id="submit" style="width:192px">
                    <stripes:option value="">请选择</stripes:option>
                    <stripes:option value="0">否</stripes:option>
                    <stripes:option value="1">是</stripes:option>

                </stripes:select></td>
                <td><label  for="verify">是否复审:</label></td>
                <td><stripes:select name="customerSurvey.verify" id="verify" style="width:192px">
                    <stripes:option value="">请选择</stripes:option>
                    <stripes:option value="0">否</stripes:option>
                    <stripes:option value="1">是</stripes:option>

                </stripes:select></td>
            </tr>
            <tr>
                <td><label for="salesRegion">销售大区:</label>
                </td>
                <td><stripes:text name="customerSurvey.salesRegion" class="form-control" id="salesRegion"/></td>
                <td><label for="province">所在省份:</label></td>
                <td><stripes:text name="customerSurvey.province" class="form-control" id="province"/></td>
                <td><label for="port">所在城市:</label></td>
                <td><stripes:text name="customerSurvey.port" class="form-control" id="port"/></td>
            </tr>
            <tr>
                <td><label for="preparerManager">区域主管:</label></td>
                <td><input type='text' id='preparerManager' name='customerSurvey.preparerManager'
                           value="${actionBean.customerSurvey.preparerManager}" class="form-control"/></td>

                <td><label for="surveyDate" >调研日期:</label></td>
                <td><input type="text" readonly="true" name="customerSurvey.surveyDate" class="datepicker form-control"
                           id="surveyDate" class="form-control"></td>
                <td><stripes:submit name="viewCustomerSurvey" value="查询" id="query" class="btn btn-primary"
                                    style="margin-left: 5px"/></td>
                <td></td>

            </tr>
        </table>

    </stripes:form>

    <display:table name="actionBean.paginatedList" id="row"
                   sort="external" size="15" class='table table-striped'
                   requestURI="CustomerSurvey.action">
        <display:column property="surveyNo" title="调研编号"/>
        <display:column property="customer" sortable="false" sortName="customer" title="客户名称"/>
        <display:column property="checked" title="提交" paramId="checked"/>
        <display:column property="submit" title="初审" paramId="submit"/>
        <display:column property="verify" title="复审"/>
        <display:column title="调研日期"> <c:out value='${fn:substring(row.surveyDate, 0, 10)}'/></display:column>
        <display:column property="preparer" sortable="false" sortName="preparer" title="负责专员"/>
        <display:column title="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;操作">

            <button type="button" class="btn btn-link" name="doupdate" style="display: none"
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
                    onclick="showModal('${row.uid}','${row.surveyNo}','submit','${row.checked}','${row.submit}')">
                初审
            </button>
            <button type="button" class="btn btn-link" name="doverify" style="display:none"
                    onclick="showModal('${row.uid}','${row.surveyNo}','verify','${row.submit}','${row.verify}')">
                复审
            </button>
            <button type="button" class="btn btn-link" name="resetStatus" style="display:none"
                    onclick="showModal('${row.uid}','${row.surveyNo}','returnCheck','${row.verify}','${row.checked}')">
                打回
            </button>
        </display:column>
    </display:table>

    <%--   <table class="table table-striped">
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

<div id="operateModal" class="modal hide fade alert alert-info" tabindex="-1" data-width="560">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h4><span id="status_title">初审</span></h4>
    </div>
    <div class="modal-body">
        <div class="form-inline" style="margin-bottom: 10px">
            <label for="customer">备注:</label>
            <textarea id="remark" rows="5" style="width:500px"></textarea>
            <label style='display:none;color:red;font-size: 10px' id='errorMsg2'>*备注不能为空</label>

        </div>

    </div>
    <div class="modal-footer">
        <button type="button" data-dismiss="modal" class="btn">取消</button>
        <button type="button" class="btn btn-primary" id="dosubmit">确认</button>
    </div>
</div>

<div id="returnCheckModal" class="modal hide fade alert alert-info" tabindex="-1" data-width="560">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h4>打回至未提交状态</h4>
    </div>
    <div class="modal-body">
        <div class="form-inline" style="margin-bottom: 10px">
            <label for="customer">备注:</label>
            <textarea id="returnCheckMark" rows="5"></textarea>
            <label style='display:none;color:red;font-size: 10px' id='errorMsg3'>*备注不能为空</label>

        </div>

    </div>
    <div class="modal-footer">
        <button type="button" data-dismiss="modal" class="btn">取消</button>
        <button type="button" class="btn btn-primary" id="returnCheck">确认</button>
    </div>
</div>

<%@ include file="../common/IncludeBottom.jsp" %>

<script type="text/javascript">


</script>



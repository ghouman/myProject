<%@ include file="../common/IncludeTop.jsp" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<script src="../js/common/jquery.validate.js"></script>
<script src="../js/common/messages_zh.js"></script>
<script src="../js/weigao/customerCommon.js"></script>
<script src="../js/weigao/updateCustomer.js"></script>
<%--
<link href="../displayTag/css/maven-base.css" rel="stylesheet">
<link href="../displayTag/css/maven-theme.css" rel="stylesheet">
<link href="../displayTag/css/site.css" rel="stylesheet">
<link href="../displayTag/css/screen.css" rel="stylesheet">
--%>
<style type="text/css">
</style>
<div class="container">


    <ol class="breadcrumb" style="margin-top: 5px">
        <li><a href="#">修改客户信息</a></li>
        <li><a href="javascript:history.go(-1);">返回<i class="icon-share-alt"></i></a>
    </ol>
</div>
<div class="container">
    <stripes:form beanclass="org.mybatis.weigao.web.actions.CustomerActionBean" class="form-inline"
                  id="customerForm" action="Customer.action?updateCustomer">

        <table class="table table-bordered">
            <tr>
                <th width="80">客户名称：</th>
                <td  width="25%"><input type="text" name="customer.customerName" class="form-control" id="customerName"
                           placeholder="请输入客户名称"
                           value="${actionBean.customer.customerName}" readonly="true" required>
                        <%--<stripes:text name="customer.customerName" class="form-control" id="customerName"/>--%></td>
                <th width="80">组织机构代码：</th>
                <td  width="25%"><input type="text" name="customer.zect" class="form-control" id="zect" placeholder="请输入组织机构代码"
                           value="${actionBean.customer.zect}" required>
                        <%--<stripes:text name="customer.zect" class="form-control" id="zect"/>--%></td>
                <th width="80">客户类型：</th>
                <td><stripes:select name="customer.custVal" id="custVal" value="${actionBean.customer.custVal}"
                                    class="form-control">
                    <stripes:option value="现有客户">现有客户</stripes:option>
                    <stripes:option value="潜在客户">潜在客户</stripes:option>
                </stripes:select>
                        <%--<stripes:text name="customer.custVal" class="form-control" id="custVal"/>--%></td>
            </tr>
            <tr>
                <th>客户地址：</th>
                <td><stripes:text name="customer.address" value="${actionBean.customer.address}" class="form-control"
                                  id="address"/></td>
                <th>所属省份：</th>
                <td>
                    <input type="hidden" value="${actionBean.customer.province}" class="form-control" id="provinceId"
                           data-provide="typeahead"/>
                    <stripes:select name="customer.province" value="${actionBean.customer.province}"
                                    onchange='loadPort()' class="form-control" id="province">
                    </stripes:select>
                </td>
                <th>所属城市：</th>
                <td>
                    <input type="hidden" value="${actionBean.customer.portID}" class="form-control" id="port"
                           data-provide="typeahead"/>
                    <stripes:select name="customer.portID" value="${actionBean.customer.portID}" class="form-control"
                                    id="portID">
                    </stripes:select>
                </td>
            </tr>
            <tr>
                <th>客户网址：</th>
                <td><stripes:text name="customer.website" value="${actionBean.customer.website}" class="form-control"
                                  id="website"/></td>

                <th>负责专员：</th>
                <td>${actionBean.customer.clerk}</td>
                <th>销售大区：</th>
                <td>
                        <%--<input type="text" name="customer.salesRegion" class="form-control" id="salesRegion"  placeholder="请输入销售大区"
                            value="${actionBean.customer.salesRegion}" required>  --%>
                        ${actionBean.customer.salesRegion}
            </tr>

            <tr>
                <th>大区经理：</th>
                <td>${actionBean.customer.manager }</td>
                <th>区域主管：</th>
                <td>${actionBean.customer.salesFloor }</td>
                <th>医院等级：</th>
                <td>
                    <stripes:select name="customer.healthClass" value="${actionBean.customer.healthClass}"
                                    id="healthClass" class="form-control">
                    <stripes:option value="三甲">三甲</stripes:option>
                    <stripes:option value="三乙">三乙</stripes:option>
                    <stripes:option value="三丙">三丙</stripes:option>
                    <stripes:option value="二甲">二甲</stripes:option>
                    <stripes:option value="二乙">二乙</stripes:option>
                    <stripes:option value="二丙">二丙</stripes:option>
                    <stripes:option value="一甲">一甲</stripes:option>
                    <stripes:option value="一乙">一乙</stripes:option>
                    <stripes:option value="一丙">一丙</stripes:option>
                    <stripes:option value="其他">其他</stripes:option>
                </stripes:select>
                        <%--<stripes:text name="customer.healthClass" class="form-control" id="healthClass"/>--%></td>
            </tr>
            <tr>
                <th>行政级别：</th>
                <td><stripes:select name="customer.hierarchy" value="${actionBean.customer.hierarchy}" id="hierarchy"
                                    class="form-control">
                    <stripes:option value="省部级">省部级</stripes:option>
                    <stripes:option value="地市级">地市级</stripes:option>
                    <stripes:option value="区县级">区县级</stripes:option>
                    <stripes:option value="其他">其他</stripes:option>
                </stripes:select>
                        <%--<stripes:text name="customer.hierarchy" class="form-control" id="hierarchy"/>--%></td>
                <th>执业许可证：</th>
                <td>
                    <input type="text" name="customer.coop_DT" value="${actionBean.customer.coop_DT}"
                           class="datepicker form-control" id="coop_DT">
                </td>
                <th>邮编：</th>
                <td><stripes:text name="customer.postalCode" maxlength="6" value="${actionBean.customer.postalCode}"
                                  class="form-control" id="postalCode"/></td>


            </tr>
            <tr>
                <th>所属科室：</th>
                <td>
                    <stripes:select name="customer.labOffice" value="${actionBean.customer.labOffice}"
                                    class="form-control" id="labOffice">
                        <stripes:option value="肾内科">肾内科</stripes:option>
                        <stripes:option value="泌尿外科">泌尿外科</stripes:option>
                        <stripes:option value="独立血液净化中心">独立血液净化中心</stripes:option>
                        <stripes:option value="其他">其他</stripes:option>
                    </stripes:select>

                </td>
                <th>血透室电话：</th>
                <td>
                    <stripes:text name="customer.labTEL" maxlength="12" value="${actionBean.customer.labTEL}"
                                  class="form-control" id="labTEL"/>
                </td>
                <th>是否审核：</th>
                <td>
                        ${actionBean.customer.verify}
                </td>
            </tr>
            <tr>
                <th>医院信息：</th>
                <td colspan="5">
                    <stripes:textarea rows="3" style="width:90%" name="customer.hospitalMemo" class=" form-control"
                                      id="hospitalMemo" value=" ${actionBean.customer.hospitalMemo}"/>

                </td>
            </tr>
        </table>
        <hr/>
        <div style="margin-bottom: 5px">
            <input type="button" onclick="addCustomerLine()" class="btn btn-primary" value="增加一行负责人">
        </div>
        <!--相关负责人-->
        <table class="table table-bordered" id="tr_category">
            <tbody>
            <tr id="0">
                <th width='7%'>负责人：</th>
                <th width='11%'>职务：</th>
                <th width='10%'>联系方式：</th>
                <th width='10%'>决策范围：</th>
                <th width='15%'>个人爱好：</th>
                <th width='15%'>学术影响力：</th>
                <th width='10%'>身份证/生日：</th>
                <th width='7%'>操作：</th>

            </tr>
            <tr id="tr_customerStaff"></tr>
            </tbody>
        </table>
        <div style="display: none">
            <stripes:text name="customer.jsonString" class="form-control" id="jsonString"/>
            <stripes:text name="customer.uid" class="form-control" id="uid" value="${actionBean.customer.uid}"/>
                <%--
                <stripes:text name="customer.operator" class="form-control" id="operator"/>
                <stripes:text name="customer.feedback" class="form-control" id="feedback"/>
                <stripes:text name="customer.healtMemo" class="form-control" id="healtMemo"/>
                <stripes:text name="customer.openDt" class="form-control" id="openDt"/>
                <stripes:text name="customer.portID" class="form-control" id="portID"/>
                <stripes:text name="customer.clerk" class="form-control" id="clerk"/>
                <stripes:text name="customer.labOffice" class="form-control" id="labOffice"/>
                <stripes:text name="customer.labOMemo" class="form-control" id="labOMemo"/>
                <stripes:text name="customer.labTEL" class="form-control" id="labTEL"/>
                <stripes:text name="customer.hospitalMemo" class="form-control" id="hospitalMemo"/>
                <stripes:text name="customer.active" class="form-control" id="active"/>
                <stripes:text name="customer.direct" class="form-control" id="direct"/>
                <stripes:text name="customer.chargeLimit" class="form-control" id="chargeLimit"/>
                <stripes:text name="customer.verifier" class="form-control" id="verifier"/>
                <stripes:text name="customer.verifyDate" class="form-control" id="verifyDate"/>
                --%>
        </div>
        <div>
            <button class="btn btn-primary btn-large" id="operate" onclick="getCustomerStaffDetail()"/>
            修改保存</button>
        </div>
    </stripes:form>
</div>
<%@ include file="../common/IncludeBottom.jsp" %>





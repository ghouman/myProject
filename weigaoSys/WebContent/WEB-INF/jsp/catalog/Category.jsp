<%@ include file="../common/IncludeTop.jsp"%>
<div class="container">
<div id="BackLink"><stripes:link
	beanclass="org.mybatis.weigao.web.actions.CatalogActionBean">
	Return to Main Menu</stripes:link></div>

<div id="Catalog">

<h2>${actionBean.category.name}</h2>

<table>
	<tr>
		<th>Product ID</th>
		<th>Name</th>
	</tr>
	<c:forEach var="product" items="${actionBean.productList}">
		<tr>
			<td><stripes:link
				beanclass="org.mybatis.weigao.web.actions.CatalogActionBean"
				event="viewProduct">
				<stripes:param name="productId" value="${product.productId}" />
				${product.productId}
			</stripes:link></td>
			<td>${product.name}</td>
		</tr>
	</c:forEach>
</table>

</div>
</div>
<%@ include file="../common/IncludeBottom.jsp"%>



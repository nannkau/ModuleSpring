<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form class="form-search" method="post">
	<c:if test="${search != null}"></c:if>
	<input type="text" placeholder="Search..." name="search" value="${ search}">
	<button class="btn btn-primary">Search</button>
</form>
<div class="product">
	<c:forEach var="o" items="${list}">
		<div class="col-4">
			<div class="item">
				<img alt="${o.title}"
					src="${pageContext.request.contextPath}/upload/${o.imageUrl}">
				<div class="info">
					<a
						href="${pageContext.request.contextPath}/home/detail.html/${o.id}">${o.title}</a>
				</div>
			</div>
		</div>
		<div class="clear"></div>
	</c:forEach>
</div>
<ul class="pagination">
	<c:forEach begin="1" end="${n}" step="1" var="i">
		<li class="page-item"><a class="page-link"
			href="${pageContext.request.contextPath}/home/index.html?p=${i}&search=${search}">${i}</a>
		</li>
	</c:forEach>
</ul>
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<h2>Multiple Upload File</h2>
<form method="post" enctype="multipart/form-data">
<p>
<label>Select File</label>
<input multiple="multiple" type="file" name="f">
</p>
<p>
<button>Upload</button>
</p>
</form>
<c:forEach var="name" items="${list}">
<img src="${pageContext.request.contextPath}/upload/${name}">
</c:forEach>
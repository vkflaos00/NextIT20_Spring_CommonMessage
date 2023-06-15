<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NextIT</title>
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath }/images/nextit_log.jpg" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/common.css">
</head>
<body>

<%-- <div class="container">
	<h3>성공,실패</h3>
	<div>
		<p>성공,실패 메시지</p>
		<div class="btn-area">
			<c:choose>
				<c:when test="">
					<button type="button" onclick="">확인</button>
				</c:when>
				<c:otherwise>
					<button type="button" onclick="history.back();">뒤로가기</button>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</div>  --%>

<div class="container">
	<h3>${resultMessageVO.title}</h3> <!--성공, 실패   -->
	<div>
		<p>${resultMessageVO.message }</p> <!--성공, 실패 안내 메시지  -->
		<div class="btn-area">
			<c:if test="${not resultMessageVO.result }">
				<button type="button" onclick="history.back();">뒤로가기</button>
			</c:if>
		</div>
	</div>


</div>


 
</body>
</html>
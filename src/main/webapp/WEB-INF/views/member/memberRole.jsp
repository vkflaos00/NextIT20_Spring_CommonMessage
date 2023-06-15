<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NextIT</title>
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath }/images/nextit_log.jpg" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/header.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/memberView.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/footer.css">
<!-- <script src="http://code.jquery.com/jquery-latest.min.js"></script> -->
</head>
<body>
<div id="wrap">
	 <div class="header">
         <div class="top_nav">
             <!-- header 영역 -->
             <%@ include file="/WEB-INF/views/header/header.jsp" %>
             
         </div>
     </div>
     <!-- header e -->

     <div class="intro_bg">
         <div class="intro_text">
             <h1>NextIT</h1>
             <h4>넥스트아이티</h4>
         </div>
     </div>
     <!-- intro_bg e -->

     <!-- 전체 영역잡기 -->
     <div class="contents">
         <!-- 사용할 영역잡기 -->
         <div class="content01">
             <div class="content01_h1">
                 <h1>회원 정보 상세</h1>
             </div>
             <!-- 회원 정보 테이블 -->
             <div id="div_table">
             
             	<c:choose>
             		<c:when test="${bne ne null or de ne null}">	
             			<h3>회원 정보 조회 실패</h3>
						<div class="alert alert-success">
							<p>회원 정보 조회 실패 하였습니다. 전산실에 문의 부탁드립니다. 042-719-8850</p>
							<div class="btn-area">
								<button type="button" onclick="history.back();">뒤로가기</button>
							</div>
						</div>
					</c:when>
						
					<c:when test="${bne eq null and de eq null}">
						<form name="memberRoleForm" 
							action="${pageContext.request.contextPath}/member/memberRoleUpdate"
							method="post">
							
							<input type="hidden" name="memId" value="${member.memId }">
						
							<table>
								<tbody>
									<tr>
										<td class="td_left">아이디</td>
										<td class="td_right">
											<c:out value="${member.memId }"></c:out>	
										</td>
									</tr>
									<tr>
										<td class="td_left">회원명</td>
										<td class="td_right">
											<c:out value="${member.memName }"></c:out>	
										</td>
									</tr>
							 		<tr>
										<td class="td_left">권한</td>
										<td class="td_right">
											<%-- ${member.userRoleList } --%>
											<c:forEach items="${roleInfoList}" var="roleInfo">
												<label for="${roleInfo.roleCode }">${roleInfo.roleKor }</label>
												<input type="checkbox" 
													id="${roleInfo.roleCode }"
													name="userRole"
													value="${roleInfo.roleCode }">	
											</c:forEach>
											
											<c:forEach items="${member.userRoleList }" var="role">
												<input type="hidden" name="role" 
													value="${role.userRole }">
											</c:forEach>
											
										</td>
									</tr>
								</tbody>
							</table>
						
							<div class="div_button">
			                     <input type="button" onclick="location.href='${pageContext.request.contextPath}/member/memberList.do'" value="목록">
			                     <input type="button" onclick="fn_submit()" value="수정">
		                 </div>
						</form>
	                </c:when>
               	</c:choose>
               	
             </div>
         </div>
     </div>

     <!-- footer -->
     <footer id="page_footer">
         <%@ include file="/WEB-INF/views/footer/footer.jsp" %>
     </footer>

</div>

<script type="text/javascript">

$("input[name='role']").each(function(index, item){
	console.log( "index : ", index, " , itme : ", $(item).val());
	
	$("#"+$(item).val()).prop("checked", true);
});


function fn_submit(){
	//alert("fn_submit");
	let result = confirm("권한을 수정하시겠습니까?");
	if(result){
		let f = $("form[name='memberRoleForm']");
		console.log("f : ", f);
		f.submit();
	}
	
}

</script>
</body>
</html>
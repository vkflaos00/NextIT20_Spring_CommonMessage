<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NextIT</title>
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath }/images/nextit_log.jpg" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/header.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/freeBoardView.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/footer.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
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
                <h1>자유게시판</h1>
            </div>
            <form:form id="freeForm" action="${pageContext.request.contextPath }/free/freeRegister" method="post" modelAttribute="freeBoard">
                  <div id="div_table">
                      <table>
                          <colgroup>
                              <col width="200">
                              <col width="400">
                          </colgroup>
                          <tr>
                              <td class="td_left">제목</td>
                              <td class="td_right">
                                  <form:input path="boTitle" autocomplete="off"/> 
                                  <form:errors path="boTitle"></form:errors>
                              </td>
                          </tr>
                          <tr>
                              <td class="td_left">작성자</td>
                              <td class="td_right">
                                  <input type="hidden" name="boWriter" value="${memberVO.memId}" >
                                  <c:out value="${memberVO.memId}"/> 
								  <form:errors path="boWriter"></form:errors>
                                  
                              </td>
                          </tr>
                          <tr>
                              <td class="td_left">글 비번</td>
                              <td class="td_right">
                                  <form:password path="boPass" autocomplete="off" />
		  						 		수정 또는 삭제시에 필요합니다.
  						 		  <form:errors path="boPass"></form:errors>	
                              </td>
                          </tr>
                          <tr>
                              <td class="td_left">글 분류</td>
                              <td class="td_right">
								<form:select path="boCategory">
									<form:option value="">-- 선택하세요--</form:option>
									<form:options items="${categoryList}" itemLabel="commNm" itemValue="commCd"/>
								</form:select>
								<form:errors path="boCategory"></form:errors>
                              </td>
                          </tr>
                          <tr>
                              <td class="td_left">IP</td>
                              <td class="td_right">
								${pageContext.request.remoteAddr}
								<input type="hidden" name="boIp" value="${pageContext.request.remoteAddr}">
								<form:errors path="boIp"></form:errors>	
                              </td>
                          </tr>
                          <tr>
                              <td class="td_left">내용</td>
                              <td class="td_right">
                                  <form:textarea path="boContent" rows="10"/>
                                  <form:errors path="boContent"></form:errors>
                              </td>
                          </tr>
                      </table>
                  </div>
                  <!-- 버튼 -->
                  <div class="div_button">
                      <input type="button" onclick="location.href='${pageContext.request.contextPath}/free/freeList'" value="목록">
                      <input type="submit" value="등록">
                  </div>
       		</form:form>
        </div>
    </div>

	<!-- footer -->
	<footer id="page_footer">
		<!-- footer영역 -->
		<%@ include file="/WEB-INF/views/footer/footer.jsp" %>
    </footer>
</div>  
</body>
</html>
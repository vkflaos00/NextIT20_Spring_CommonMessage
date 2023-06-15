<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NextIT</title>
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath }/images/nextit_log.jpg" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/header.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/freeBoardForm.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/footer.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<style>
/* modal css */
#modal_div1{
	width: 100%;
	height: 100%;
	position: fixed; 
	top: 0; right: 0; bottom: 0; left: 0;
	background-color: rgba(0,0,0,0.4);	
	z-index: 1;
	display: none;
}
#modal_div2{
	width: 400px;
	height: 200px;
	background-color: lightgrey;
	text-align: center;
	position: fixed;
	left: calc(50% - 200px);
	top: calc(50% - 200px);
}
#modal_div2 > p {
	margin-top: 50px;
}
#modal_div2 > a {
	margin-left: 300px;
}
form[name="deleteForm"]{
	width: 350px;
    height: 350px;
    /* background-color: tomato; */
    margin-top: 20px;
}
.int-area{
    width: 300px;
    height: 150px;
    /* background-color: lightblue; */ 
}
.int-area:first-child{
	padding-top: 40px;
}
.int-area input{
    width: 80%;
    padding: 30px 10px 10px;
    background-color: transparent;
    border: none;
    border-bottom: 1px solid #999;
    font-size: 18px;
    color: #fff;
}
.btn-area > button{
    width: 40%;
    height: 40px;
    color: #fff;
    font-size: 20px;
    border: none;
    border-radius: 15px;
    background-color: lightpink;
    position: relative;
    top: -50px
}
/* 버튼클릭액션 */
.btn-area > button:active{
	color: gray;
}


/*댓글 적용하기02			css 입히기  */
.content02{
	width: 1280px;
	height: 100%;
}
#reply_div{
	width: 1280px;
    height: 100px;
    text-align: center;
}
#reply_div label{
    position: relative;
    left: 75px;
    top: -15px;
}
#reply_div textarea{
    position: relative;
    left: 150px;
	resize:none;
   	border-radius: 10px;
  	padding-left: 10px;
  	padding-right: 10px;
  	padding-top:5px
}
#reply_div button{
	position: relative;
    left: 160px;
    top: -15px;
    border: none;
    border-radius: 5px;
    padding: 5px;
}
/* 버튼액션추가 */
#reply_div button:active{
    transform:translate(2px,2px);
}
/* 댓글 목록 css 입히기  */
#reply_list_div{
	width: 1280px;
}
.replyList_row{
   	width: 100%;
    /* height: 100px; */
    min-height: 70px;
}
.replyList_row > div{
	display: inline-block;
}

.replyList_row > div:last-child{
	display: block;
}
.replyList_row span{
    display: block;
    width: 10px;
    height: 10px;
    border-bottom: 1px solid blue;
    border-left: 1px solid blue;
    position: relative;
    top:-3px;
}
.replyList_row > div:first-child{
	margin-left : 450px;	
	margin
}
.replyList_row > div:last-child{
	margin-left : 470px;	
   	margin-top: 10px;
}
.reply_button{
	float: right;
   	margin-right: 100px;
}
.reply_button > button{
    border: none;
    border-radius: 5px;
    padding: 3px;
    margin-left: 5px;
}
.reply_button > button:first-child{
	position: absolute;
	right:240px;
}
.reply_button > button:last-child{
	position: absolute;
    right: 200px;
}
.reply_button button:active{
    transform:translate(2px,2px);
}
/*댓글 적용하기30			댓글 페이징 css 입히기  */
.div_paging{
    width: 100%;
    /* height: 100px; */
    height: 100%;
    /* background-color: lightcyan; */
    margin-bottom: 20px;
    margin-left: 150px;
}
.pagination{
    width: 300px;
    /* height: 30px; */
    height: 100%;
    /* background-color: lightpink; */
    text-align: center;
    display: flex;
}
.pagination > li{
	width: 20px;
}
.pagination a{
   padding-left:7px
}
.pagination a:hover {
   color: lightskyblue;
   font-weight:bold;
}
.curPage_a{
	color: red;
   	font-weight:bold;
}

.reply_content textarea{
    position: relative;
    left: 50px;
	resize:none;
   	border-radius: 10px;
  	padding-left: 10px;
  	padding-right: 10px;
  	padding-top:5px
}
</style>




<script>
function fn_freeDelete(){
	console.log("fn_freeDelete");
	$("#modal_div1").fadeIn();
}
function fn_Cancel(){
	console.log("fn_Cancel");
	$("#modal_div1").fadeOut();
}
function fn_freeHide(){
	//alert("fn_freeHide");
	let f = $("form[name='freeHide']");
	f.submit();
}
</script>
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
            
			<!-- 해당 정보를 불러오지 못한 경우 처리 -->
				<c:if test="${bne ne null or de ne null }">
					<div class="alert alert-warning">
							해당글을 불러오지 못하였습니다. 전산실에 문의 부탁드립니다. 042-719-8850
					</div>	
					<div class="div_button">
	                      <input type="button" onclick="location.href='${pageContext.request.contextPath}/free/freeList'" value="목록">
	                </div>
                </c:if>
            
            <!-- 해당 정보를 올바르게 불러온 경우 처리  -->
            	<c:if test="${bne eq null and de eq null }">
                  <div id="div_table">
                      <table>
                          <colgroup>
                              <col width="200">
                              <col width="400">
                          </colgroup>
                          <tr>
                              <td class="td_left">글 번호</td>
                              <td class="td_right">
                                  ${freeBoard.boNo }
                              </td>
                          </tr>
                          <tr>
                              <td class="td_left">글 제목</td>
                              <td class="td_right">
                                 ${freeBoard.boTitle }
                              </td>
                          </tr>
                          <tr>
                              <td class="td_left">글 분류</td>
                              <td class="td_right">
                                  ${freeBoard.boCategoryNm }
                              </td>
                          </tr>
                          <tr>
                              <td class="td_left">작성자명</td>
                              <td class="td_right">
								  ${freeBoard.boWriter }
                              </td>
                          </tr>
                          <tr>
                              <td class="td_left">글 내용</td>
                              <td class="td_right">
                              		${freeBoard.boContent }
                              </td>
                          </tr>
                          <tr>
                              <td class="td_left">IP</td>
                              <td class="td_right">
                              		${freeBoard.boIp }
                              </td>
                          </tr>
                          <tr>
                              <td class="td_left">조회수</td>
                              <td class="td_right">
                                  ${freeBoard.boHit }
                              </td>
                          </tr>
                          <tr>
                              <td class="td_left">최근 등록 일자</td>
                              <td class="td_right">
                                  ${freeBoard.boModDate ne null ? freeBoard.boModDate : freeBoard.boRegDate }
                              </td>
                          </tr>
                      </table>
                  </div>
                  <!-- 버튼 -->
                  <div class="div_button">
                      <input type="button" onclick="location.href='${pageContext.request.contextPath }/free/freeList?searchType=${searchVO.searchType}&searchWord=${searchVO.searchWord}&searchCategory=${searchVO.searchCategory}&curPage=${searchVO.curPage}&rowSizePerPage=${searchVO.rowSizePerPage}'" value="목록">

                      <c:if test="${freeBoard.boWriter eq memberVO.memId  }">
                      	<input type="button" onclick="location.href='${pageContext.request.contextPath }/free/freeEdit?boNo=${freeBoard.boNo }'" value="수정">
                      	<input type="button" onclick="fn_freeDelete()" value="삭제">
                      </c:if>
						<c:forEach items="${memberVO.userRoleList }" var="roleList">
							<c:if test="${roleList.userRole eq 'AD' }">
								<input type="button" onclick="fn_freeHide()" value="숨김">
								<form name="freeHide" action="${pageContext.request.contextPath }/free/freeHide" method="post">
									<input type="hidden" name="memId" value="${memberVO.memId }" />	
									<input type="hidden" name="boNo" value="${freeBoard.boNo }" />	
								</form>
							</c:if>
						</c:forEach>
                  </div>
             </c:if>
             
        </div>
        
         <!--댓글 html 코드 작성하기-->
		 <!--댓글 s -->
			<div class="content02">
				<!--댓글 등록 영역 s  -->
				<div id="reply_div">
					<form name="reply_form" method="post">
						<input type="hidden" name="reCategory" value="FREE">
						<input type="hidden" name="reParentNo" value="${freeBoard.boNo}">	
						<input type="hidden" name="reMemId" value="${memberVO.memId }">
						<input type="hidden" name="reIp" value="${pageContext.request.remoteAddr}">
						<div>
							<label>댓글</label>
							<textarea name="reContent" rows="2" cols="70"></textarea>
							<button id="btn_reply_regist">댓글등록</button>
								<!--button에 type 속성이 없으면 submit으로 처리된다.  -->	        			
						</div>
					</form>
				</div><!--댓글 등록영역 e  -->
				
				<!--댓글 목록 영역  s -->
				<div id="reply_list_div">
					<!-- 댓글 리스트  -->
				</div><!--댓글 목록 영역  e -->
			</div><!--댓글 e-->
        	
    </div><!--contents	e  -->


	<!-- 글삭제 모달 -->
	<div id="modal_div1" >
		<div id="modal_div2" >
			<form name="deleteForm" action="${pageContext.request.contextPath }/free/freeDelete" method="post">
				<input type="hidden" id="boNo" name="boNo" value="${freeBoard.boNo }"/>
				<input type="hidden" id="boWriter" name="boWriter" value="${memberVO.memId }"/>
	            <div class="int-area">
	                <input type="password" id="boPass" name="boPass" value="" placeholder="PASSWORD" autocomplete="off" required/>
	            </div>
	            <div class="btn-area">
	                <button type="submit" >삭제</button>
	                <button type="button" onclick="fn_Cancel()">취소</button>
	            </div>
	        </form>
		</div>
	</div>


	<!-- footer -->
	<footer id="page_footer">
		<!-- footer영역 -->
		<%@ include file="/WEB-INF/views/footer/footer.jsp" %>
		
    </footer>
</div>  

<script type="text/javascript">
$("#btn_reply_regist").on("click", function(e){
	e.preventDefault();
	//alert("btn_reply_regist");
	
	let replyForm = $("form[name='reply_form']");
	console.log("replyForm.serialize()", replyForm.serialize());
	
	$.ajax({
		//url: "${pageContext.request.contextPath}/reply/replyRegister"
		url:"<c:url value='/reply/replyRegister'  />"
		,type:"post"
		,data: replyForm.serialize()
		,success:function(){
			//alert("success");
			$("textarea[name='reContent']").val("");
			
			$("#reply_list_div").html("");
			fn_reply_list();
		} 
		,error:function(){
			alert("error");
		}
	});
});

function fn_reply_list(curPage){
	//alert("fn_reply_list");
	
	$.ajax({
		url: "<c:url value='/reply/replyList' />"
		,type:"post"
		,data:{"reCategory":"FREE"
			, "reParentNo": "${freeBoard.boNo}" 
			, "curPage": curPage}
		,success:function(data){
			//alert("success");
			console.log("data", data);
			$.each(data.replyList, function(i, element){
				let str='';
				str +=' 	<div class="replyList_row" data-reNo="'+element.reNo+'"> ';
				str +='		<div><span clas="reply_span"></span></div>	';   // "ㄴ" 표시
				str +='		<div>'+ element.reMemId +'</div>				';
				str +='		<div> ('+ element.reRegDate +' )</div>			';
				if(element.reMemId == "${memberVO.memId}"){
					str+=' 	<div class="reply_button">' ;
					str+='    		<button type="button" name="btn_reply_edit">수정</button>';
					str+='    		<button type="button" name="btn_reply_delete">삭제</button>';
					str+='		</div>'	; 
				}
				str +='		<div class="reply_content">'	;
				str +='			<pre>'+element.reContent+'</pre>' ;	
				str +='		</div>' ;
				str +='	</div> '	;
				
				$("#reply_list_div").append(str);
			});
			
			console.log("data.firstPage: "+ data.firstPage);
			console.log("data.curPage: "+ data.curPage);
			
			let paging_str ='';
			paging_str +='	<div class="div_paging">';
			paging_str +='		<ul class="pagination">';
			if(data.firstPage >10){
				paging_str +='		<li><a href="javascript:fn_paging('+(data.firstPage-1)+')">&laquo;</a></li>'
			}
			if(data.curPage != 1){
				paging_str +='		<li><a href="javascript:fn_paging('+(data.curPage-1)+')">&lt;</a></li>'
			}
			for(let i = data.firstPage; i<= data.lastPage; i++){
				if(data.curPage != i){
					paging_str +='	<li><a href="javascript:fn_paging('+(i)+')">'+ i +'</a></li>'
				}else{
					paging_str +='	<li class="curPage_a">'+ i +'</li>'
				}
			}
			if(data.lastPage != data.totalPageCount){
				paging_str +='		<li><a href="javascript:fn_paging('+(data.curPage+1)+')">&gt;</a></li>'
				paging_str +='		<li><a href="javascript:fn_paging('+(data.lastPage+1)+')">&raquo;</a></li>'
			}
			paging_str +='		</ul>';
			paging_str +='	</div>';
						
			$("#reply_list_div").append(paging_str);			
		}
		,error:function(){
			alert("error");
		}
	});
}


$(function(){   // $(document).ready(function(){})
	fn_reply_list();
	
	/* $("button[name='btn_reply_delete']").on("click", function(){
		alert("삭제버튼");
	}); */
	
	$("#reply_list_div")
		.on("click", "button[name='btn_reply_delete']", function(e){
			//alert("삭제버튼");
			let reNo = $(this).closest(".replyList_row").data("reno");
			alert("reNo: "+ reNo);
			
			let reMemId = "${memberVO.memId}";
			let param = {"reNo": reNo, "reMemId": reMemId};
			
			let ret = confirm("댓글을 정말 삭제하시겠습니까?");
			if(ret){
				$.ajax({
					url:"<c:url value='/reply/replyDelete' />"
					,type: "post"
					,data: param
					,success: function(data){
						//alert("success");
						//console.log("data: ", data);
						console.log("data.result: ", data.result);
						if(data.result){
							alert("댓글이 삭제 되었습니다.");
							$("#reply_list_div").html("");
							fn_reply_list();
						}else{
							alert("처리도중 에러가 발생하였습니다. 전산실에 문의 부탁드립니다. 042-719-8850");
							$("#reply_list_div").html("");
							fn_reply_list();
						}
					}
					,error:function(){
						//alert("error");
						alert("처리도중 에러가 발생하였습니다. 전산실에 문의 부탁드립니다. 042-719-8850");
					}
				});
			}
	});
	
	
	
//수정 버튼 클릭하면  저장, 취소 버튼 변경 하고 사용자가 댓글 수정할수 있게 변경하기
	let temp_content ="";
	$("#reply_list_div").on('click', 'button[name="btn_reply_edit"]', function(e){   
	
		let reNo = $(this).closest(".replyList_row").data('reno');  
		console.log("reNo : ", reNo	);
		
		let reMemId = "${memberVO.memId }";  
		console.log("reMemId : ", reMemId);
		
		let ret = confirm("댓글을 수정 하시겠습니까?");
		if(ret){
 			let reply_button = $(this).parent()
 			let reply_content = reply_button.next();
 			console.log(reply_content);

 			temp_content = reply_content.find("pre").text();
 			console.log("temp_content", temp_content);
 			
 			reply_content.html("");
 			
 			let str1 = '';
 			str1 += '<form name="reply_update" method="post"> ';
			str1 += '	<input type="hidden" name="reCategory" value="FREE"> ';
		 	str1 += '	<input type="hidden" name="reNo" value=""> ';  
		 	str1 += '	<input type="hidden" name="reMemId" value=""> ';  
			str1 += '	<div> ';
			str1 += '		<textarea name="reContent" rows="2" cols="70">'+temp_content+'</textarea> ';
			str1 += '	</div>';
 			str1 += '</form>';
 			
			reply_content.append(str1);
 			
			
			reply_button.html("")
			let str2 = '';
			str2 += '<button type="button" name="btn_reply_update">저장</button>';
			str2 += '<button type="button" name="btn_reply_cancel">취소</button>';
			reply_button.append(str2);
			
		}
	});
	
//취소버튼을 클릭하면 이전 상태로 변경하기
	$("#reply_list_div").on('click', 'button[name="btn_reply_cancel"]', function(e){  
		
		let reNo = $(this).closest(".replyList_row").data('reno');
		console.log("reNo : ", reNo	);
		
		let reMemId = "${memberVO.memId }";  
		console.log("reMemId : ", reMemId);
		
		let ret = confirm("댓글을 취소 하시겠습니까?");
		if(ret){
 			let reply_button = $(this).parent()
 			let reply_content = reply_button.next();
 			console.log(reply_content);

 			console.log("temp_content", temp_content);
 			
 			reply_content.html("");
 			
 			let str1 = '';
			str1 += '	<div> ';
			str1 += '		<pre>'+temp_content+'</pre> ';
			str1 += '	</div>';
 			
			reply_content.append(str1);
 			
			
			reply_button.html("")
			let str2 = '';
			str2 += '<button type="button" name="btn_reply_edit">수정</button>';
			str2 += '<button type="button" name="btn_reply_delete">삭제</button>';
			reply_button.append(str2);
			
		}
	});
	
//댓글을 수정한 후 저장 버튼을 클릭하면 수정한 내용 저장하기 
	$("#reply_list_div").on('click', 'button[name="btn_reply_update"]', function(e){ 
		
		let replyListRow = $(this).closest(".replyList_row")
		let replyNo = replyListRow.data('reno');
		console.log("replyNo", replyNo);
		
		let replyUpdate = replyListRow.find("form[name='reply_update']");
		replyUpdate.find("input[name='reNo']").val(replyNo);
		
		let reMemId = $("form[name='reply_form']").find("input[name='reMemId']").val();		
		replyUpdate.find("input[name='reMemId']").val(reMemId);
		
		console.log("replyUpdate.serialize(): ", replyUpdate.serialize());

	 	$.ajax({
			url:"<c:url value='/reply/replyUpdate'/>"  
			,type:"post"
			,data: replyUpdate.serialize()
			,success: function(data){
				console.log("btn_reply_update success");
			 	
				if(data.result){
					alert("댓글이 수정 되었습니다.");
					$("#reply_list_div").html("");
					fn_reply_list();
				}else{
					alert("처리도중 에러가 발생하였습니다. 전산실에 문의 부탁드립니다. 042-719-8850");
					$("#reply_list_div").html("");
					fn_reply_list();
				}
				
				
			}
			,error: function(err){
				console.log("err.status : ", err.status);
				alert("댓글 수정에 실패하였습니다. 전산실에 문의 부탁드립니다. 042-719-8850");
			}
			
			
		});
	});
	
});

function fn_paging(curPage){
	//alert("curPage: "+ curPage);
	
	$("#reply_list_div").html("");
	fn_reply_list(curPage);
	
}

</script>

</body>
</html>
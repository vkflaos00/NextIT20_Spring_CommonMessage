<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NextIT</title>
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath }/images/nextit_log.jpg" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/login.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
function fn_login(){
	//alert("fn_login");
	
	let f = document.loginForm;
	console.log(" f : ", f);
	f.action = "${pageContext.request.contextPath}/login/loginCheck";
	f.submit();
}

$(function(){
	//alert("$(function(){})");
	window.setTimeout(function(){
		//alert("window.setTimeout");
		let lc = $("#loginCheck").val();
		if(lc == 'fail'){
			alert("로그인 실패하였습니다. ID 또는 PASSWORD를 확인해주세요.");
		}else if( lc == 'none'){
			alert("로그인 하셔야 이용 가능합니다.");
		}else if( lc == 'error'){
			alert("처리도중 에러가 발생하였습니다. 전산실에 문의 부탁드립니다. 042-719-8850");
		}else if( lc == 'sign'){
			alert("정상적으로 회원등록되었습니다. 확인을 누르시고 로그인을 진행해주세요");
		}else if( lc == 'quit'){
			alert("회원탈퇴되었습니다. 다시 가입을 원하시면 join을 누르시고 회원가입 해주세요");
		}
	},200);
});
</script>
</head>
<body>
<input type="hidden" id="loginCheck" value="${msg }">
<section class="login_form">
    <h1>NextIT</h1>
    <form name="loginForm" method="post">
        <div class="int-area">
            <input type="text" id="memId" name="memId" value="${memId}" autocomplete="off" required>  
            <label for="memId">USER ID</label>
        </div>
        <div class="int-area">
            <input type="password" id="memPass" name="memPass" autocomplete="off" required>
            <label for="memPass">PASSWORD</label>
        </div>
        <div class="div_rememberMe">
      		<label for="rememberMe">
				<input type="checkbox" id="rememberMe" name="rememberMe"  value="Y" ${checkBox } />&nbsp;&nbsp;ID 기억하기
			</label>
        </div>
        <div class="btn-area">
            <button type="button" id="btn_id" name="btn_id" onclick="fn_login()">LOGIN</button>
        </div>
    </form>
    <div class="caption">
        <ul class="caption_ul">
            <li>
                <a href="#" 
                	onclick="location.href='${pageContext.request.contextPath}/login/join'">join</a>
            </li>
            <li>
                <a href="#" onclick="">FORGOT PASSWORD</a>
            </li>
        </ul>
    </div>
</section> 
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8'>
<title>NextIT</title>
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath }/images/nextit_log.jpg" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/join.css">
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<style type="text/css">
span{
	color: white;
	display: block;
	width:260px;
	text-align:left;
}
#memId+span{
	position:absolute;
	top:60px;
	right:-300px;
}
#memName+span{
	position:absolute;
	top:110px;
	right:-300px;
}
#memPass+span{
	position:absolute;
	top:160px;
	right:-300px;
}
#memZip+span{
	position:absolute;
	top:250px;
	right:-300px;
}
#memBir+span{
	position:absolute;
	top:410px;
	right:-300px;
}
#memMail+span{
	position:absolute;
	top:460px;
	right:-300px;
} 
#memHp+span{
	position:absolute;
	top:505px;
	right:-300px;
}
#memJob+span{
	position:absolute;
	top:570px;
	right:-300px;
}
#memHobby+span{
	position:absolute;
	top:620px;
	right:-300px;
}
/*버튼 css 입히기  */
#check_id{
	position: absolute;
	top: 55px;
	left: 350px;
	width: 50px;
	height: 20px;	
    color: #fff;
    border: none;
    border-radius: 5px;
    background-color: #166cea;
}
</style>

<script>

$(function(){
	$("#memId").click(function(){
    	$(this).next().removeClass("warning");
    });   
    $("#memName").click(function(){
    	$(this).next().removeClass("warning");
    });
    $("#memPass").click(function(){
    	$(this).next().removeClass("warning");
    });
    $("#memPassCheck").click(function(){
    	$(this).next().removeClass("warning");
    });
    $("#memZip").click(function(){
    	$(this).next().removeClass("warning");
    });
    $("#memAdd1").click(function(){
    	$(this).next().removeClass("warning");
    });
    $("#memBir").click(function(){
    	$(this).next().removeClass("warning");
    });
    $("#memMail").click(function(){
    	$(this).next().removeClass("warning");
    });
    $("#memHp").click(function(){
    	$(this).next().removeClass("warning");
	});
    
    
    /* $(function(){}) 에 처리  */   
	$("input, select").click(function(){
		$(this).next("span").remove();
	});
	$("input").change(function(){
		if($(this).val() == ""){
			//alert("234");
			$(this).nextAll("label").removeAttr("style");
		}
	});
	window.setTimeout(function(){
		if($("#memId").val() !=""){
			$("label[for='memId']").css({"top": "35px", "font-size":"13px", "color":"#166cea"});
		}
		if($("#memName").val() !=""){
			$("label[for='memName']").css({"top": "90px", "font-size":"13px", "color":"#166cea"});
		}
		if($("#memPass").val() !=""){
			$("label[for='memPass']").css({"top": "145px", "font-size":"13px", "color":"#166cea"});
		}
		if($("#memZip").val() !=""){
			$("label[for='memZip']").css({"top": "245px", "font-size":"13px", "color":"#166cea"});
		}
		if($("#memMail").val() !=""){
			$("label[for='memMail']").css({"top": "450px", "font-size":"13px", "color":"#166cea"});
		}
		if($("#memHp").val() !=""){
			$("label[for='memHp']").css({"top": "500px", "font-size":"13px", "color":"#166cea"});
		}
	},500);

});

let idCheck = false;
function join(){
    //alert("join");
    console.log("join");
    
    
    //값 유무 검증
    /*let memId = $("#memId");
    let memName = $("#memName");
    let memPass = $("#memPass");
    let memPassCheck = $("#memPassCheck");
    let memZip = $("#memZip");
    let memAdd1 = $("#memAdd1");
    let memBir = $("#memBir");
    let memMail = $("#memMail");
    let memHp = $("#memHp");
    
    if( memId.val() == ""){
    	alert("ID를 입력해주세요");
    	memId.next("label").addClass("warning");
    	return;
    }else if(memName.val()==""){
    	alert("이름을 입력해주세요");
    	memName.next("label").addClass("warning");
    	return;
    }else if(memPass.val()==""){
    	alert("패스워드 입력해주세요");
    	memPass.next("label").addClass("warning");
    	return;
    }else if(memPassCheck.val()==""){
    	alert("패스워드 재확인 값을 입력해주세요");
    	memPassCheck.next("label").addClass("warning");
    	return;
    }else if(memZip.val()==""){
    	alert("우편번호를 입력해주세요");
    	memZip.next("label").addClass("warning");
    	return;
    }else if(memAdd1.val()==""){
    	alert("주소를 입력해주세요");
    	memAdd1.next("label").addClass("warning");
    	return;
    }else if(memBir.val()==""){
    	alert("생년월일을 입력해주세요");
    	memBir.next("label").addClass("warning");
    	return;
    }else if(memMail.val()==""){
    	alert("메일을 입력해주세요");
    	memMail.next("label").addClass("warning");
    	return;
    }else if(memHp.val()==""){
    	alert("휴대폰번호를 입력해주세요");
    	memHp.next("label").addClass("warning");
    	return;
    }
    
    
    //아이디, 이름, 패스워드 공백 검증
    let checkBlank =  /\s/;
    
    console.log("checkBlank : ", checkBlank.test(memId.val()) );
    console.log("checkBlank : ", checkBlank.test(memId.val()) );
    
    if( checkBlank.test(memId.val())  ){
    	alert("ID에 공백이 존재합니다. 다시입력해주세요");
    	memId.val("");
    	memId.next("label").addClass("warning");
    	return;
    }else if(checkBlank.test(memName.val())){
    	alert("이름에 공백이 존재합니다. 다시입력해주세요");
    	memName.val("");
    	memName.next("label").addClass("warning");
    	return;
    }else if(checkBlank.test(memPass.val())){
    	alert("패스워드에 공백이 존재합니다. 다시입력해주세요");
    	memPass.val("");
    	memPass.next("label").addClass("warning");
    	return;
    }
    
    // 아이디, 패스워드 글자수 및 영문 , 숫자, 한글제외 검증
    let checkWord = /^\w{4,10}$/;
    //console.log("checkWord: ", checkWord.test(memId.val()));
    
    if(! checkWord.test(memId.val())){
    	alert("ID는 최소 4글자 이상 10글자 이하 이어야 합니다.");
    	memId.val("");
    	memId.next("label").addClass("warning");
    	return;
    }else if(! checkWord.test(memPass.val())){
    	alert("패스워드는 최소 4글자 이상 10글자 이하 이어야 합니다.");
    	memPass.val("");
    	memPassCheck.val("");
    	memPass.next("label").addClass("warning");
    	memPassCheck.next("label").addClass("warning");
    	return;
    }
    
    // 패스워드 와 재확인 패스워드 비교 검증
    if(memPass.val() != memPassCheck.val()){
    	alert("재확인 패스워드가 올바르지 않습니다. 다시 입력해주세요");
    	memPassCheck.val("");
    	memPassCheck.next("label").addClass("warning");
    	return;
    }
    
    //우편번호
    let checkMemZip = /^\d{5}$/;
    //console.log("checkMemZip: ", checkMemZip.test(memZip.val()));
    
    if( ! checkMemZip.test(memZip.val())){
    	alert("우편번호는 숫자 5자리입니다. 다시 입력해주세요");
    	memZip.val("");
    	memZip.next("label").addClass("warning");
    	return;
    }
    
  //6차  메일검증
    let checkMemMail = /^[-_a-zA-z0-9]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,4}$/i;
    console.log("checkMemMail: ", checkMemMail.test(memMail.val()) );
    if( ! checkMemMail.test(memMail.val()) ){
    	alert("이메일 양식이 틀립니다. 다시 입력해주세요"); 
    	memMail.val("");    	
    	memMail.next("label").addClass("warning");
        return;
    }
    
	//7차   휴대폰 번호 검증
    let checkMemHp = /^[0-9]{10,11}$/;
    if( ! memHp.val().match(checkMemHp)){
    	alert("휴대폰번호는 숫자를 사용하여 10~11 자리 입력 주세요."); 
    	memHp.val("");    	
    	memHp.next("label").addClass("warning");
        return;
    }
    
    */
    
    //fn_checkId();
    
   let memId = $("#memId").val();
	console.log("memId:", memId);
	$.ajax({
		url: "<c:url  value='/join/idCheck' />"
		,type:"post"
		,data:{"memId": memId}
		,async:false
		,success:function(data){
			//alert("success");
			console.log("data: ", data);
			if(data){
				idCheck = true;
			}else{
				$("#memId").val("");
				alert("이미 사용중인 아이디 입니다. 다른아이디를 사용해주세요");
			}
		}
		,error:function(){
			alert("error");
		}
	});
	
	
    if(!idCheck){
    	return;
    }
    
    let f =  document.loginForm;
    f.action = "${pageContext.request.contextPath}/member/memberRegister";
    f.submit();
};
 
function fn_checkId(){
	//alert("fn_checkId");
	
	let memId = $("#memId").val();
	console.log("memId:", memId);
	
	$.ajax({
		url: "<c:url  value='/join/idCheck' />"
		,type:"post"
		,data:{"memId": memId}
		,success:function(data){
			//alert("success");
			console.log("data: ", data);
			if(data){
				alert("사용가능한 아이디 입니다.");
				idCheck = true;
			}else{
				$("#memId").val("");
				alert("이미 사용중인 아이디 입니다. 다른아이디를 사용해주세요");
			}
		}
		,error:function(){
			alert("error");
		}
		
	});
}
 
</script>
</head>
<body>
    <section class="login_form">
        <h1>NextIT</h1> 
        <%-- <form name="loginForm"  method="post"> --%>
        <form:form name="loginForm"  method="post" modelAttribute="member">
            <div class="int-area">
                <!-- <input type="text" 
	                	id="memId" 
	                	name="memId" 
	                	value="" 
	                	autocomplete="off" 
	                	required="required"> -->
					<form:input path="memId" autocomplete="off"/>
                	<form:errors path="memId"></form:errors>
                 <label for=memId>USER ID</label>
                	<button type="button" id="check_id" 
                		name="check_id" onclick="fn_checkId()">ID확인</button>
            </div>
            <div class="int-area">
                <!-- <input type="text" id="memName" name="memName" value="" autocomplete="off" required="required"> -->
                	<form:input path="memName" autocomplete="off"/>
                	<form:errors path="memName"/>
                <label for=memName>USER NAME</label>
            </div>
            <div class="int-area">
                <!-- <input type="password" id="memPass" name="memPass" value="" autocomplete="off" required="required"> -->
                	<form:password path="memPass" autocomplete="off"/>
                	<form:errors path="memPass"/>
                <label for=memPass>PASSWORD</label>
            </div>
            <div class="int-area">
                <input type="password" id="memPassCheck" name="memPassCheck" value=""  autocomplete="off" required="required">
                <label for=memPassCheck>RECONFIRM PASSWORD</label>
            </div>
            
            <div class="int-area">
                <!-- <input type="text" id="memZip" name="memZip" value="" autocomplete="off" required="required"> -->
                	<form:input path="memZip" autocomplete="off"/>
                	<form:errors path="memZip"/>
                <label for=memZip>ZIP CODE</label>
            </div>
            <div class="int-area">
                <input type="text" id="memAdd1" name="memAdd1" value="" autocomplete="off" required="required">
                <label for=memAdd1>ADDRESS 1</label>
            </div> 
            <div class="int-area">
                <input type="text" id="memAdd2" name="memAdd2" value="" autocomplete="off" required="required">
                <label for=memAdd2>ADDRESS 2</label>
            </div> 
            <div class="int-area">
                <input type="date" id="memBir" name="memBir" 
                		value="${member.memBir }" autocomplete="off" required="required">
                <form:errors path="memBir"/>
                <label for=memBir>BIRTHDAY</label>
            </div> 
            <div class="int-area">
                <!-- <input type="text" id="memMail" name="memMail" value="" autocomplete="off" required="required"> -->
					<form:input path="memMail" autocomplete="off"/>
					<form:errors path="memMail"/>                	
                <label for=memMail>E-MAIL</label>
            </div> 
            <div class="int-area">
                <!-- <input type="text" id="memHp" name="memHp" value="" autocomplete="off" required="required"> -->
                	<form:input path="memHp" autocomplete="off"/>
					<form:errors path="memHp"/>
                <label for=memHp>PHONE</label>
            </div> 
            <div class="int-area int-area-select">
					<%-- <select name="memJob" required="required">
						<option value="">-- 직업 선택 --</option>
						<c:forEach items="${jobList }" var="job">
							<option value="${job.commCd}">${job.commNm}</option>			
						</c:forEach>
					</select> --%>
					
					<form:select path="memJob">
						<form:option value="">-- 직업 선택 --</form:option>
						<form:options items="${jobList }"
							itemLabel="commNm" itemValue="commCd"/>
					</form:select>
					<form:errors path="memJob"/>
				<label for=memJob>JOB</label>	
            </div>
            
            <div class="int-area int-area-select">
					<%-- <select name="memHobby" required="required">
						<option value="">-- 취미 선택 --</option>
						<c:forEach items="${hobbyList }" var="hobby">
							<option value="${hobby.commCd}">${hobby.commNm}</option>			
						</c:forEach>
					</select> --%>
					
					<form:select path="memHobby">
						<form:option value="">-- 직업 선택 --</form:option>
						<form:options items="${hobbyList }"
							itemLabel="commNm" itemValue="commCd"/>
					</form:select>
					<form:errors path="memHobby"/>
					
				<label for=memHobby>HOBBY</label>	
            </div>
            
            <div class="btn-area">
                <button type="button"  id="btn_join"name="btn_join" onclick="join()">JOIN</button>
            </div>
        </form:form>    
    </section>
    
</body>
</html>
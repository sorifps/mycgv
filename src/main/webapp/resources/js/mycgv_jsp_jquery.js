$(document).ready(function(){
	
	/*********************************
	
	*********************************/
	
	/*******************************************
						게시판 - 삭제 폼
	********************************************/
	$("#btnBoardDelete").click(function(){
		if($("#btitle").val() == "") {
			alert("제목을 입력하세요.");
			$("#btitle").focus();
			return false;
		}else {
			deleteForm.submit();
		}
	});
	
	
	
	
	
	
	/*******************************************
					게시판 - 수정 폼
    ********************************************/
	$("#btnBoardUpdate").click(function(){
		if($("#btitle").val() == "") {
			alert("제목을 입력하세요.");
			$("#btitle").focus();
			return false;
		}else {
			updateForm.submit();
		}
	});
	
	
	
	
	
	
	
	/*******************************************
		게시판 - 등록폼
	********************************************/
	$("#btnBoardWrite").click(function(){
		if($("#btitle").val() == "") {
			alert("제목을 입력하세요.");
			$("#btitle").focus();
			return false;
		}else {
			writeForm.submit();
		}
	});
	
	
	
	
	/*******************************
	     회원가입 폼 체크 - 중복체크
    *******************************/
	$("#btnIdCheck").click(function(){
		if($("#id").val() == "") {
			alert("아이디를 입력해주세요.");
			$("#id").focus();
			return false;
		}else { 
			$.ajax({url: "id_check.do?id="+$("#id").val(), success: function(result){
				if(result == 1) {
					$("#idCheck_msg").text("이미 사용중인 아이디입니다. 다시 입력해주세요.").css("color","red").css("font-size","12px").css("display","block")
					.css("padding","5px 0");
					$("#id").val("").focus();
				}else {
					$("#idCheck_msg").text("사용 가능한 아이디입니다.").css("color","blue").css("font-size","12px").css("display","block")
					.css("padding","5px 0");
					$("#pass").focus();
				}
			}});
		}
	});
	
	
	
	/*******************************************
		회원가입 폼 체크 - 주소찾기 : daum API 
	********************************************/
	$("#btnSearchAddr").click(function(){
		new daum.Postcode({
	        oncomplete: function(data) {
	        	//alert(data.address);
	        	$("#addr1").val("("+data.zonecode+") "+ data.address);
	        	$("#addr2").focus();
	        }
	    }).open();
		
	}); //search address
	
	/*******************************************
		회원가입 폼 체크 - 이메일 체크 
	********************************************/
	$("#email3").on("change", function(){
		if($("#email3").val() == "default"){
			alert("이메일을 선택해주세요");
			$("#email2").val("");
			$("#email3").focus();
		}else if($("#email3").val() == "self"){
			$("#email2").val("").focus();
		}else{
			$("#email2").val($("#email3").val());
		}		
		
	}); //email address change
	
	/*******************************************
		회원가입 폼 체크 - 비밀번호 & 비밀번호 확인 
	********************************************/
	$("#cpass").on("blur", function(){		
		if($("#pass").val() != "" && $("#cpass").val() != ""){
			if($("#pass").val() == $("#cpass").val()){
				$("#cmsg").text("비밀번호가 동일합니다").css("color","blue")
					.css("font-size","11px").css("display","block");
				$("#name").focus();
			}else{
				$("#cmsg").text("비밀번호가 동일하지 않습니다. 다시  입력해주세요")
				.css("color","red").css("font-size","11px").css("display","block");
				
				$("#pass").val("").focus();
				$("#cpass").val("");
			}
		}
	}); //cpass blur
	
	/*******************************
		회원가입 폼 체크 - 유효성체크(값의 유무만 확인)
	*******************************/
	$("#btnJoin").click(function(){
		if($("#id").val() == ""){
			alert("아이디를 입력해주세요");
			$("#id").focus();
			return false;
		}else if($("#idCheck_msg").text() == ""){
			alert("중복체크를 진행해주세요");
			$("#btnIdCheck").focus();
			return false;
		}else if($("#pass").val() == ""){
			alert("패스워드를 입력해주세요");
			$("#pass").focus();
			return false;
		}else if($("#cpass").val() == ""){
			alert("패스워드 확인을 입력해주세요");
			$("#cpass").focus();
			return false;
		}else if($("#name").val() == ""){
			alert("성명을 입력해주세요");
			$("#name").focus();
			return false;
		}else if($("input[name='gender']:checked").length == 0){
			alert("성별을 선택해주세요");
			return false;
		}else if($("#email1").val() == ""){
			alert("이메일 주소를 입력해주세요");
			$("#email1").focus();
			return false;
		}else if($("#email2").val() == ""){
			alert("이메일 주소를 선택해주세요");
			$("#email3").focus();
			return false;
		}else if($("#addr1").val() == ""){
			alert("주소를 선택해주세요");
			$("#btnSearchAddr").css("border","1px solid gray");
			return false;
		}else if($("#addr2").val() == ""){
			alert("상세주소를 입력해주세요");
			$("#addr2").focus();
			return false;
		}else if($("input[name='tel']:checked").length == 0){
			alert("통신사를 선택해주세요");
			return false;
		}else if($("#phone1").val() == "default"){
			alert("폰번호를 선택해주세요");
			$("#phone1").focus();
			return false;
		}else if($("#phone2").val() == ""){
			alert("폰번호를 입력해주세요");
			$("#phone2").focus();
			return false;
		}else if($("#phone3").val() == ""){
			alert("폰번호를 입력해주세요");
			$("#phone3").focus();
			return false;
		}else if($("input[name='hobby']:checked").length == 0){
			alert("취미를 선택해주세요");
			return false;
		}else{
			//서버전송
			joinForm.submit();
		}
	});	//btnJoin
	
	
	/*******************************
		로그인 폼 체크
	*******************************/
	$("#btnLogin").click(function(){
		if($("#id").val() == ""){
			alert("아이디를 입력해주세요");
			$("#id").focus();
			return false;
		}else if($("#pass").val() == ""){
			alert("패스워드를 입력해주세요");
			$("#pass").focus();
			return false;			
		}else{
			//서버전송
			loginForm.submit();
		}
	});	//btnLogin click
	
	/*******************************
		로그인 폼 - 다시쓰기 
	*******************************/
	$("#btnLoginReset").click(function(){
		$("#id").val("").focus();
		$("#pass").val("");
	}); //btnLoginReset click

	
	
	
	
	
	
}); //ready






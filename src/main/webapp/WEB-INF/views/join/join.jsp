<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MYCGV</title>
<link rel="stylesheet" href="http://localhost:9000/mycgv_jsp/css/mycgv_jsp.css">
<script src="http://localhost:9000/mycgv_jsp/js/jquery-3.6.4.min.js"></script>
<script src="http://localhost:9000/mycgv_jsp/js/mycgv_jsp_jquery.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
	<!-- header -->
	<!-- <iframe src="http://localhost:9000/mycgv_jsp/header.jsp"
			scrolling="no" width="100%" height="149px" frameborder=0></iframe> -->
	<jsp:include page="../header.jsp"></jsp:include>
	
	<!-- content -->
	<div class="content">
		<section class="join">
			<h1 class="title">회원가입</h1>
			<form name="joinForm" action="join_proc.do" method="post">
				<ul>
					<li>
						<label>아이디</label>
						<input type="text" name="id" 
							placeholder="*8자 이상 영문으로 입력해주세요" class="input1"
							id="id" >
						<button type="button" class="btn_style2" id="btnIdCheck">중복체크</button>
						<span id="idCheck_msg"></span>	
					</li>
					<li>
						<label>비밀번호</label>
						<input type="password" name="pass" class="input1" id="pass">
					</li>
					<li>
						<label>비밀번호 확인</label>
						<input type="password" name="cpass" class="input1" id="cpass">
                        <span id="cmsg"></span>						     
					</li>
					<li>
						<label>성명</label>
						<input type="text" name="name" class="input1" id="name">
					</li>
					<li>
						<label>성별</label>
						<input type="radio" name="gender" value="m"><span>남자</span> 
						<input type="radio" name="gender" value="f"><span>여자</span>
					</li>
					<li>
						<label>이메일</label>
						<input type="text" name="email1" id="email1"> @
						<input type="text" name="email2" id="email2">
						<select id="email3" id="email3">
							<option value="default">선택</option>
							<option value="naver.com">네이버</option>
							<option value="gmail.com">구글</option>
							<option value="daum.net">다음</option>
							<option value="korea.com">코리아</option>
							<option value="self">직접입력</option>
						</select>
					</li>
					<li>
						<label>주소</label>
						<input type="text" name="addr1" class="input1" id="addr1">
						<button type="button" class="btn_style2" id="btnSearchAddr">주소찾기</button>
					</li>
					<li>
						<label>상세주소</label>
						<input type="text" name="addr2" class="input1" id="addr2">
					</li>
					<li>
						<label>휴대폰</label>
						<input type="radio" name="tel" value="skt"><span>SKT</span>
						<input type="radio" name="tel" value="lgu+"><span>LGU+</span>
						<input type="radio" name="tel" value="kt"><span>KT</span>
						<select name="phone1" id="phone1">
							<option value="default">선택</option>
							<option value="011">011</option>
							<option value="010">010</option>
							<option value="017">017</option>
						</select>
						- <input type="text" name="phone2" id="phone2">
						- <input type="text" name="phone3" id="phone3">				
					</li>
					<li>
						<label>취미</label>
						<input type="checkbox" name="hobby" value="영화보기"><span>영화보기</span>
						<input type="checkbox" name="hobby" value="등산하기"><span>등산하기</span>
						<input type="checkbox" name="hobby" value="게임하기"><span>게임하기</span>
						<input type="checkbox" name="hobby" value="잠자기"><span>잠자기</span>
					</li>
					<li>
						<label>자기소개</label>
						<textarea name="intro" placeholder="*200자 이내로 작성해주세요"></textarea>
					</li>
					<li>
						<button type="button" class="btn_style" id="btnJoin">가입하기</button>
						<button type="reset" class="btn_style">다시입력</button>
					</li>			
				</ul>
			</form>
		</section>
	</div>
	
	<!-- footer -->
	<!-- <iframe src="http://localhost:9000/mycgv_jsp/footer.jsp"
			scrolling="no" width="100%" height="500px" frameborder=0></iframe> -->	
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>

















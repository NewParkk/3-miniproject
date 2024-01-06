<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../insertUser.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script> 

<style>
body,h1 {font-family: "Raleway", sans-serif}
body, html {height: 100%}
.bgimg {
  background-image: url('https://cdn.pixabay.com/photo/2015/09/05/20/02/coding-924920_1280.jpg');
  min-height: 100%;
  background-position: center;
  background-size: cover;
}
</style>
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

<div class="bgimg w3-display-container w3-animate-opacity w3-text-white">
  <div class="w3-display-topleft w3-padding-large w3-xlarge"  style="opacity: 0.7;">
    TEAM3
  </div>
  <div class="w3-display-middle" style="background-color: rgba(255, 255, 255, 0.55); padding: 20px; border-radius: 10px; color:black;">
    <h1 class="w3-jumbo w3-animate-top", align="center" >WELCOME</h1>
    <hr class="w3-border-grey" style="margin:auto;width:40%">
    <p class="w3-large w3-center">로그인을 해주세요</p>
    <form action="login.do" method="POST">
	<table align="center" cellpadding="5" cellspacing="1" width="600" border="1">
	    <tr>
	        <td width="1220" height="20" colspan="2" bgcolor="#336666">
	            <p align="center">
	            </p>
	        </td>
	    </tr>
	    <tr>
	        <td width="150" height="20">
	            <p align="center"><b><span style="font-size:12pt;">아이디</span></b></p>
	        </td>
	        <td width="450" height="20" align="center">
	        	<b>
	        		<span style="font-size:12pt;">
	        			<input id="userId" type="text" name="userId" size="30">
	        		</span>
	        		<span>
	        			<button id="check-userId">check</button>
	        		</span>
        			<div id="show-msg"/>
	        	</b>
	        </td>
	    </tr>
	    <tr>
	        <td width="150" height="20">
	            <p align="center"><b><span style="font-size:12pt;">비밀번호</span></b></p>
	        </td>
	        <td width="450" height="20" align="center">
	        	<b>
	        		<span style="font-size:12pt;">
	        			<!-- input 박스 -->
	        			<input type="password" name="password" size="30">
	        		</span>
	        	</b>
	        </td>
	    </tr>
	    <tr>
	        <td width="150" height="20">
	            <p><b><span style="font-size:12pt;">&nbsp;</span></b></p>
	        </td>
	        <td width="450" height="20" align="center">
	        	<b>
	        		<span style="font-size:12pt;">
						<input type="submit" value="로그인">
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="reset" value="다시작성">
					</span>
				</b>
			</td>
	    </tr>
	</table>
</form>
  </div>
</div>

</body>
</html>

<script>
const checkBtn = document.getElementById('check-userId');
checkBtn.addEventListener('click', (e) => {
	e.preventDefault();
	const inputuserId = document.getElementById('userId');
	const showMsg = document.getElementById('show-msg');
    axios.get('http://localhost:8081/servletMini/api/getUser', 
    		{params : {userId : inputuserId.value}})
            .then(response => response.data)
            .then(result => {
            	if(result.msg === '존재') {
            		showMsg.innerHTML = '해당 아이디로 로그인 가능';
            	}else {
            		showMsg.innerHTML = '해당 아이디가 없습니다 아이디 재확인 필요';
            	}
            })
})

</script>
</body>
</html>
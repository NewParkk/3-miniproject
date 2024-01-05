<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<style>
body,h1 {font-family: "Raleway", sans-serif}
body, html {height: 100%}
.bgimg {
  background-image: url('data:image/jpeg;base64,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');
  min-height: 100%;
  background-position: center;
  background-size: cover;
}
</style>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
</head>
<body>

<div class="bgimg w3-display-container w3-animate-opacity w3-text-white">
  <div class="w3-display-topleft w3-padding-large w3-xlarge">
    TEAM3
  </div>
  <div class="w3-display-middle">
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
	        			<input type="text" name="password" size="30">
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
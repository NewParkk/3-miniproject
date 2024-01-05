<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>W3.CSS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script> 
</head>
<body>

<div align="right" class="w3-container">
  <!-- 로그인 버튼 -->
  <button onclick="document.getElementById('id01').style.display='block'" class="w3-button w3-blue w3-large">회원가입</button>

  <div id="id01" class="w3-modal">
    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:600px">
  
  		<!-- 이곳에 img 넣을수있음
      <div class="w3-center"><br>
        <span onclick="document.getElementById('id01').style.display='none'" class="w3-button w3-xlarge w3-transparent w3-display-topright" title="Close Modal">×</span>
        <img src="img_avatar4.png" alt="Avatar" style="width:30%" class="w3-circle w3-margin-top">
      </div> -->

      <form class="w3-container" action="insertUser.do" method="POST">
        <div class="w3-section">
          <label><b>UserId</b></label>
          <input class="w3-input w3-border w3-margin-bottom" id="userId" type="text" placeholder="Enter UserId" name="userId" required>
          <div id="show-msg"/></div>
          <label><b>Password</b></label>
          <input class="w3-input w3-border" type="password" placeholder="Enter Password" name="password" required>
          <label><b>YourName</b></label>
          <input class="w3-input w3-border" type="text" placeholder="Your Name" name="userName" required>
          <button class="w3-button w3-block w3-blue w3-section w3-padding" type="submit">회원가입</button>
          <span><input type="reset" class="w3-button w3-green value="초기화"></span>
          
        </div>
      </form>

      <div align="left" class="w3-container w3-border-top w3-padding-16 w3-light-grey">
        <button  onclick="document.getElementById('id01').style.display='none'" type="button" class="w3-button w3-green">Cancel</button>
        <span class="w3-right w3-padding w3-hide-small"> <a href="login.jsp">로그인</a></span>
      </div>

    </div>
  </div>
</div>

<script>
const inputUserId = document.getElementById('userId');
	inputUserId.addEventListener('blur', (e) => {
	e.preventDefault();
	const showMsg = document.getElementById('show-msg');
    axios.get('http://localhost:8081/servletMini/api/getUser', 
    		{params : {userId : inputUserId.value}})
            .then(response => response.data)
            .then(result => {
            	if(result.msg === '존재') {
            		showMsg.innerHTML = '사용가능한 ID입니다';
            		showMsg.style.color = 'blue'; 
                } else {
                    showMsg.innerHTML = '사용중인 ID입니다';
                    showMsg.style.color = 'red';
                }
            })
})
</script>
            
</body>
</html>
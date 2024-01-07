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
  <div id="id01" class="w3-modal">
	<div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:600px; margin-top:12%;">
  
      <form class="w3-container" action="../insertUser" method="POST">
        <div class="w3-section">
          <label><b>UserId</b></label>
          <input class="w3-input w3-border w3-margin-bottom" id="getId" type="text" placeholder="Enter UserId" name="getId" required>
          <div id="show"/></div>
          <label><b>Password</b></label>
          <input class="w3-input w3-border" type="password" placeholder="Enter Password" name="password" required>
          <label><b>YourName</b></label>
          <input class="w3-input w3-border" type="text" placeholder="Your Name" name="userName" required>
          <button class="w3-button w3-block w3-blue w3-section w3-padding" type="submit">회원가입</button>
	      <div align="left" class="w3-container w3-border-top w3-padding-16 w3-white">
	        <button onclick="document.getElementById('id01').style.display='none'" type="button" class="w3-button w3-green">Cancel</button>
	          <span align="right" style="float: right;"><input type="reset" class="w3-button w3-green value="초기화"></span>
	      </div>
        </div>
      </form>


    </div>
  </div>
</div>

<script>
const inputUserId = document.getElementById('getId');
	inputUserId.addEventListener('blur', (e) => {
	e.preventDefault();
	const showMsg = document.getElementById('show');
    axios.get('http://localhost:8081/servletMini/api/getId', 
    		{params : {getId : inputUserId.value}})
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp" %>

<div class="container mt20">
	<h2>글쓰기</h2>
	<form action="insertboard.do" method="POST" id="insertForm" onsubmit="checkData()">
		<!-- 제목 -->
		<div style="display : flex; margin-top: 20px;">
			<p style="width: 10%;">제목<b><span style="color: red;">*</span></b></p>
			<input type="text" class="form-control" name="boardtitle" placeholder="제목을 입력하세요." value="">
		</div>
		<!-- 내용 -->
		<div style="display : flex; margin-top: 20px;">
			<p style="width: 10%;">내용<b><span style="color: red;">*</span></b></p>
			<textarea class="form-control" style="height: 300px;" name="boardcontent" placeholder="내용을 입력하세요."></textarea>
		</div>
		<!-- 버튼 -->
		<div style="width: 100%; text-align: right; margin-top: 20px;">
			<button type="submit" class="btn btn-primary">글쓰기</button>
			<button type="button" class="btn btn-light" style="border: 1px solid black;" onclick="location.href = 'getboardlist.do';">목록</button>
		</div>
	</form>
</div>
<script type="text/javascript">
function checkData() {
    let insertForm = document.getElementById('insertForm');
    
    if (insertForm.boardtitle.value === "" || insertForm.boardcontent.value === "") {
        return false;
    }
    return true;
}	

</script>
	
<%@ include file="../../footer.jsp" %>
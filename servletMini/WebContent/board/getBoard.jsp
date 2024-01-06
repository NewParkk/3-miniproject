<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp" %>

<div class="container">
	<div style="margin: 20px 0;">
		<span style="width: 10%;">  </span>
		<h2 style="display: inline;">메인게시판</h2><hr/>
	</div>
	<form action="updateform.do" method="POST" id="insertForm" onsubmit="checkData();">
	<input type="hidden" name="noticeid" value="${requestScope.board.noticeId}">
	<!-- 제목 -->
		<div style="display : flex; margin-top: 20px; margin-right: 30px;">
			<input type="text" class="form-control" name="boardtitle" readonly value="${requestScope.board.noticeTitle}">
		</div>
		<!-- 내용 -->
		<div style="display : flex; margin-top: 20px; margin-right: 30px;">
			<textarea class="form-control" style="height: 300px;" readonly name="boardcontent">${requestScope.board.noticeContent}</textarea>
		</div>
		<!-- 버튼 -->
		<div style="width: 100%; text-align: right; margin-top: 20px;">
			<button type="button" class="btn btn-light" style="border: 1px solid black;" onclick="location.href = 'getboardlist.do'">목록</button>
			<button type="submit" class="btn btn-primary">글수정</button>
			<button type="button" class="btn btn-primary" style="margin-right: 20px;"onclick="location.href = 'deleteboard.do'">글삭제</button>
			
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
	
<%@ include file="../common/footer.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp" %>

<div class="insertboard.do">
	<!-- 제목 -->
	<form action="updateboard.do" method="POST" id="insertForm" onsubmit="checkData(); return false;">
		<div style="display : flex; margin-top: 20px; margin-right: 30px;">
			<p style="width: 10%; text-align: center">제목</p>
			<input type="text" class="form-control" readonly value="${requestScope.board.noticeTitle}">
		</div>
		<!-- 내용 -->
		<div style="display : flex; margin-top: 20px; margin-right: 30px;">
			<p style="width: 10%; text-align: center">내용</p>
			<textarea class="form-control" style="height: 300px;" readonly name="boardcontent">${requestScope.board.noticeContent}</textarea>
		</div>
		<!-- 버튼 -->
		<div style="width: 100%; text-align: right; margin-top: 20px;">
			<button type="button" class="btn btn-light" style="border: 1px solid black;" onclick="goToBoardList()">목록</button>
			<button type="submit" class="btn btn-primary">글수정</button>
			<button type="button" class="btn btn-primary" style="margin-right: 20px;"onclick="goTodelete()">글삭제</button>
			
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
function goToBoardList() {
    location.href = 'getboardlist.do';
  }
function goTodelete() {
    location.href='deleteboard.do?noticeId=${board.noticeId}';
  }
</script>
	
<%@ include file="../../footer.jsp" %>
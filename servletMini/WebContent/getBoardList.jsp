<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp" %>

<div class="container">
	
    <h2 style="width: 100%; text-align: left; margin-top: 20px;">게시판</h2>
    
    <div class="row">
        <div class="table-responsive" style="width: 100%;">
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="col-1" style="background-color: #eeeeee; text-align: center;">글번호</th>
                        <th class="col-6" style="background-color: #eeeeee; text-align: center;">제목</th>
                        <th class="col-2" style="background-color: #eeeeee; text-align: center;">Date</th>
                        <th class="col-1" style="background-color: #eeeeee; text-align: center;">작성자</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="board" items="${requestScope.boardList}">
                        <tr>
                            <td class="col-1" style="text-align: center;">${board.noticeId}</td>
                            <td><a href="getboard.do?noticeId=${board.noticeId}">${board.noticeTitle}</a></td>
                            <td>${board.noticeDate}</td>
                            <td>${board.userId}</td>                 
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <div style="width: 100%; text-align: right; margin-top: 20px;">
        <button class="btn btn-primary" onclick="location.href='insertform.do'">글쓰기</button>
    </div>
</div>

<%@ include file="../../footer.jsp" %>
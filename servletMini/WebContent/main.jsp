<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../../header.jsp" %>
<%@ include file="../css/insertUser.jsp" %>

	<div class="container">
		<div class="row">
			<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th style="background-color: #eeeeee; text-align: center;">번호</th>
						<th style="background-color: #eeeeee; text-align: center;">제목</th>
						<th style="background-color: #eeeeee; text-align: center;">작성자</th>
						<th style="background-color: #eeeeee; text-align: center;">작성일</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>rownum</td>					
						<td>notice_title</td>					
						<td>user_id</td>					
						<td>notice_date</td>			
					</tr>
				</tbody>
			</table>
		</div>
		<div style="width: 100%; text-align: right; margin-top: 20px;">
			<button class="btn btn-primary" onclick="location.href='insertform.do'">글쓰기</button>
		</div>
	</div>

<%@ include file="../../footer.jsp" %>
package board.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.dao.BoardDAO;
import noticeBoard.dto.NoticeBoardDTO;
import user.dao.UserDAO;

@WebServlet("/deleteboard.do")
public class DeleltBoardContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "common/errors.jsp";
		String noticeId = request.getParameter("noticeId");
		HttpSession session = request.getSession();
		NoticeBoardDTO board = null;
		String sessionId = (String) session.getAttribute("userId");
		
		try {
			board = BoardDAO.getBoardByBoardId(noticeId);
			if(board == null) {
			
						  
							
		
				request.setAttribute("error", "존재하지 않는 게시글입니다");
				request.getRequestDispatcher(url).forward(request, response);
			} 
			if(board != null) {
				if(board.getUserId().equals(sessionId)) {
					BoardDAO.deleteBoardByBoardId(noticeId);
					url = "getboardlist.do";
					response.sendRedirect(url);
					return;
				} else {
				request.setAttribute("error", "다른사람의 게시글입니다");
				request.getRequestDispatcher(url).forward(request, response);
			}
			}				
		} catch (SQLException e) {
					  
			request.setAttribute("error", "게시글 삭제 실패");
			request.getRequestDispatcher(url).forward(request, response);
		}
		
			
			
		
		
	}

}

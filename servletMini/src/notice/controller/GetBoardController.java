package notice.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;
import noticeBoard.dto.NoticeBoardDTO;

@WebServlet("/getboard.do")
public class GetBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "errors.jsp";
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String noticeId = request.getParameter("noticeId");
		
		NoticeBoardDTO board = null;
		
		try {
			board = BoardDAO.getBoardByBoardId(noticeId);

			if (board != null) {
				request.setAttribute("board", board);
				
				url = "getboard.jsp";
				
				request.getRequestDispatcher(url).forward(request, response);
				
			}else {
				request.setAttribute("error", "존재하지 않는 부서");
				request.getRequestDispatcher(url).forward(request, response);
			}
	
		
		} catch (SQLException e) {
			request.setAttribute("error", "존재하지 않는 부서");
			request.getRequestDispatcher(url).forward(request, response);
		}
		
	}
}

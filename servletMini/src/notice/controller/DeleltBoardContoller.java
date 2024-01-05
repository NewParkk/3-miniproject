package notice.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;
import user.dao.UserDAO;

@WebServlet("/deleteboard.do")
public class DeleltBoardContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String url = "errors.jsp";
			String userId = request.getParameter("userId");
			boolean result;
			try {
				result = BoardDAO.deleteBoardByUserId(userId);
				
				if(result) {
					url = "main.jsp"; // 임시url 변경 필수!!
					response.sendRedirect(url);
				} else {
					request.setAttribute("error", "존재하지 않는 게시글입니다");
					request.getRequestDispatcher(url).forward(request, response);
				}
				
			} catch (SQLException e) {
//				e.printStackTrace();
				request.setAttribute("error", "게시글 삭제 실패");
				request.getRequestDispatcher(url).forward(request, response);
			}
			
			
		
		
	}

}

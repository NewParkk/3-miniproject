package notice.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.dao.BoardDAO;

@WebServlet("/insertboard.do")
public class InsertBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String noticetitle = request.getParameter("boardtitle");
		String noticecontent = request.getParameter("boardcontent");
		
		HttpSession session = request.getSession();
	    String userId = (String) session.getAttribute("userId");
		
		String url = "errors.jsp";
		
//		System.out.println(noticetitle);
//		System.out.println(noticecontent);
		
		boolean result = false;
		
		if (noticetitle == null || noticetitle.equals("")) {
			request.setAttribute("error", "제목을 입력해 주세요");
			request.getRequestDispatcher(url).forward(request, response);
		}
				
		else if (noticecontent == null || noticecontent.equals("")) {
			request.setAttribute("error", "내용을 입력해 주세요");
			request.getRequestDispatcher(url).forward(request, response);
		}
		
		else {
			
			try {
				
				result = BoardDAO.insertBoard(noticetitle, noticecontent, userId);
			
				System.out.println(result);
				
				if (result) {
					url = "getboardlist.do";
					response.sendRedirect(url);
					return;
				}else {
					request.setAttribute("error", "글 작성 실패");
					request.getRequestDispatcher(url).forward(request, response);
				}
				
			
			} catch (SQLException e) {
				e.printStackTrace();
				request.setAttribute("error", "글 작성 오류" + e.getMessage());
				request.getRequestDispatcher(url).forward(request, response);
			}
		}
		

	}
}

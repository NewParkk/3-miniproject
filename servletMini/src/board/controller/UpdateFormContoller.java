package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/updateform.do")
public class UpdateFormContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
	    String userId = (String) session.getAttribute("userId");
		
	    String url = "";
	    // sessionid != noticeuserid 에러페이지
	    url = "common/errors.jsp";
	    
	    
		String noticeid =  request.getParameter("noticeid");
		String boardtitle = request.getParameter("boardtitle");
		String boardcontent = request.getParameter("boardcontent");
		String noticeuserid = request.getParameter("userid");
		
		request.setAttribute("userId", noticeuserid);
		request.setAttribute("noticeid", noticeid);
		request.setAttribute("boardtitle", boardtitle);
		request.setAttribute("boardcontent", boardcontent);
		
		
		if (!noticeuserid.equals(userId)) {
            request.setAttribute("error", "다른 사람의 게시글입니다");
            request.getRequestDispatcher(url).forward(request, response);
            return;
        }
		
		// id값 일치할 시
		url = "board/update.jsp";
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher(url).forward(request, response);
		
	}
}

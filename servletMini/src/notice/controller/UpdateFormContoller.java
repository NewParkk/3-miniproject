package notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateform.do")
public class UpdateFormContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String noticeid =  request.getParameter("noticeid");
		String boardtitle = request.getParameter("boardtitle");
		String boardcontent = request.getParameter("boardcontent");
		
		request.setAttribute("noticeid", noticeid);
		request.setAttribute("boardtitle", boardtitle);
		request.setAttribute("boardcontent", boardcontent);
		
		String url = "update.jsp";
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher(url).forward(request, response);
		
	}
}

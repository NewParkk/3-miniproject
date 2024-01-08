package login.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout.do")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("logout");
		String url = "login/login.jsp";
		
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			session.invalidate();
			session = null;
			response.sendRedirect(url);
			return;
		}else {
			response.sendRedirect(url);
			return;
		}
	}	

}

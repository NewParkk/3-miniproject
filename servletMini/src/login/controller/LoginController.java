package login.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.dao.UserDAO;
import user.dto.UserDTO;

@WebServlet("/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String pw = request.getParameter("password");
		UserDTO user = null;
		
		String url = "common/loginErrors.jsp";
		
		if(userId == null || userId == "" ) {
			request.setAttribute("error", "아이디를 재확인해주세요");
			request.getRequestDispatcher(url).forward(request, response);
		}else if (pw == null || pw == "") {
			request.setAttribute("error", "비밀번호를 재확인해주세요");
			request.getRequestDispatcher(url).forward(request, response);
		} else {
		try {
			System.out.println(userId);
			user = UserDAO.getUserByUserIdandPassword(userId, pw);
			System.out.println(user);
			
			if (user == null) {
				request.setAttribute("error", "아이디와 비밀번호가 맞지 않습니다.");
				request.getRequestDispatcher(url).forward(request, response);
			} else {
				
				HttpSession session = request.getSession();
				session.setAttribute("userId", user.getUserId());
				session.setAttribute("password", user.getPassword());
				
				url = "getboardlist.do";
				response.sendRedirect(url);
				
			}
				return;
			}
		
		catch (SQLException e) {
			request.setAttribute("error", "존재하지 않는 아이디입니다.");
			request.getRequestDispatcher(url).forward(request, response);
		}
		}
	}
}

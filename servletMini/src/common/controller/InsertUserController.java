package common.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.UserDAO;
import user.dto.UserDTO;

@WebServlet("/insertUser.do")
public class InsertUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "errors/error.jsp";
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		boolean result = false;
		
		System.out.println(userId);
		System.out.println(userName);
		System.out.println(password);
		UserDTO user = new UserDTO(userId, userName, password);
		
		try {
			result = UserDAO.insertUser(user);
			if(result) {
				url = "login.jsp";
				response.sendRedirect(url);
				System.out.println("데이터는 들어간");
				return;
			} else {
				request.setAttribute("error", "회원가입 실패");
				request.getRequestDispatcher(url).forward(request, response);
			}
			
		} catch (SQLException e) {
			request.setAttribute("error", "회원가입 오류");
			request.getRequestDispatcher(url).forward(request, response);
		}
	}
}
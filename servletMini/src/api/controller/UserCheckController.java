// Source code is decompiled from a .class file using FernFlower decompiler.
package api.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.UserDAO;
import user.dto.UserDTO;

@WebServlet({"/api/getUser"})
public class UserCheckController extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public UserCheckController() {
   }

   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String userId = request.getParameter("userId");
      UserDTO user = null;
      PrintWriter out = null;
      try {
    	 user = UserDAO.getUserByUserId(userId);
         response.setContentType("application/json; charset=UTF-8");
         System.out.println(user);
         out = response.getWriter();
         if (user == null) {
            out.print("{\"msg\" : \"존재\"}");
         } else {
            out.print("{\"msg\" : \"미존재\"}");
         }
      } catch (SQLException e) {
         out.print("{\"msg\" : \"" + e.getMessage() + "\"}");
      }

   }
}

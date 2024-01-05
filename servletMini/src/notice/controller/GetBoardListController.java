package notice.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;
import noticeBoard.dto.NoticeBoardDTO;

@WebServlet("/getboardlist.do")
public class GetBoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<NoticeBoardDTO> boardList = null;
		
		try {
			boardList =  BoardDAO.getBoardList();
			if (boardList != null) {
//				System.out.println(boardList);
				request.setAttribute("boardList", boardList);
				request.getRequestDispatcher("getBoardList.jsp").forward(request, response);
			}else {
				request.setAttribute("error", "글 목록을 불러올 수 없습니다.");
				request.getRequestDispatcher("errors.jsp").forward(request, response);
			}
			

		
		} catch (SQLException e) {
			request.setAttribute("error", "글 목록을 불러올 수 없습니다.");
			request.getRequestDispatcher("errors.jsp").forward(request, response);
		}
	
		
	}
}

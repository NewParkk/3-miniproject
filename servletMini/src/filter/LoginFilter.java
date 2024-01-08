package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"*.do"})
public class LoginFilter implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		HttpSession session = httpRequest.getSession(false); 	// 매핑된 세션객체를 리턴하는데 없으면 새로 생성해서 리턴. false 쓰면 세션을 새로 생성하지 X
		
		String path = httpRequest.getRequestURI();
//		System.out.println(path);
		
		if(!path.contains("/login.do")) {
			if(session == null || session.getAttribute("userId") == null) {
				httpResponse.sendRedirect("login/login.jsp");
				return;
			} 
		}
		chain.doFilter(request, response);
	}

}
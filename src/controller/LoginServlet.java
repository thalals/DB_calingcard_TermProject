package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.LoginService;
import vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String id=request.getParameter("UserID");
			String passwd=request.getParameter("UserPW");
			LoginService loginService=new LoginService();
			Member loginMember=loginService.getLoginMember(id,passwd);
			
			
			if(loginMember != null) {
				HttpSession session=request.getSession();
				PrintWriter out = response.getWriter();
				session.setAttribute("id", id);
				session.setAttribute("pw", id);
				System.out.println(id + "로그인 됨");
				out.println("<script>");
				out.println("location.href='maintest2.jsp'");
				out.println("</script>");
				//response.sendRedirect("maintest2.jsp");
			}
			else {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('로그인 실패')");
				out.println("history.back()");
				out.println("</script>");
			}
	
	}

}

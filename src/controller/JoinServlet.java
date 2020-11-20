package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.JoinDAO;
import svc.JoinService;
import vo.Member;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/join")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		// TODO Auto-generated method stub
		Member member=new Member();
		member.setUserName(request.getParameter("UserName"));
		member.setUserID(request.getParameter("UserID"));
		member.setUserPW(request.getParameter("UserPW"));
		member.setUserEmail(request.getParameter("UserEmail"));
		
		
		JoinDAO joinDAO = new JoinDAO();
		joinDAO.setJoinMember(member);
		
		/*String name=request.getParameter("UserName");
		String id=request.getParameter("UserID");
		String pw=request.getParameter("UserPW");
		String email=request.getParameter("UserEmail");*/
		
		//JoinService joinService=new JoinService();
		//boolean joinResult=joinService.joinMember(member);
		
	
		if(joinDAO == null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('ȸ�����Խ���')");
			out.println("history.back()");
			out.println("</script>");
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}
	}

}

package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrgDAO;
import vo.Org;

/**
 * Servlet implementation class OrgServlet
 */
@WebServlet("/org_info")
public class OrgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrgServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		PrintWriter out= response.getWriter();
		String button=request.getParameter("btn");
	
		if("생성".equals(button)) {
			System.out.println("2");
			Org org=new Org();
			
			org.setOrgName(request.getParameter("OrgName"));
			org.setOrgAddress(request.getParameter("OrgAddress"));
			org.setOrgZipCode(request.getParameter("OrgZipCode"));
			org.setOrgemail(request.getParameter("Orgemail"));
			org.setOrgfax(request.getParameter("Orgfax"));
			
			OrgDAO orgDAO = new OrgDAO();
			orgDAO.addOrganization(org);
			
			if (orgDAO != null) {
				response.sendRedirect("orgselect.jsp");
			}
			
			else {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out1 = response.getWriter();
				out1.println("<script>");
				out1.println("alert('회사추가실패");
				out1.println("history.back()");
				out1.println("</script>");
			}
		}else if("추가".equals(button)) {
			
			System.out.println("회사 추가");
			
			response.sendRedirect("orgcreate.jsp");
			
		}
		else if("다음".equals(button)) {
			System.out.println("다음");
			OrgDAO orgDAO = new OrgDAO();
			String name=request.getParameter("choice");
			
			int num=orgDAO.getOrgN(name);
			request.setAttribute("Org_Number", num);
			response.setContentType("text/html;charset=UTF-8");
			//request.setCharacterEncoding("utf-8"); 
			
			
			ServletContext context=getServletContext();
			RequestDispatcher dispatcher=context.getRequestDispatcher("/card_create.jsp");
			System.out.println(num);
			dispatcher.forward(request,response);
			//response.sendRedirect("card_create.jsp");
		}else if("명함 생성".equals(button)) {
			response.sendRedirect("orgselect.jsp");
		}
		
			
		
	}

}
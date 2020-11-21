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


import dao.CardDAO;
import dao.OrgDAO;
import vo.Card;
import vo.Org;
import vo.OrgCallNumber;

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
		
//		PrintWriter out= response.getWriter();
		String button=request.getParameter("btn");
		
		System.out.println("회사 버튼  : "+button);
		if("회사생성".equals(button)) {
			System.out.println("회사 생성");
			Org org=new Org();
			OrgCallNumber orgcall = new OrgCallNumber();
			
			org.setOrgName(request.getParameter("OrgName"));
			org.setOrgAddress(request.getParameter("OrgAddress"));
			org.setOrgZipCode(request.getParameter("OrgZipCode"));
			org.setOrgemail(request.getParameter("Orgemail"));
			org.setOrgfax(request.getParameter("Orgfax"));
			
			
			OrgDAO orgDAO = new OrgDAO();
			orgDAO.addOrganization(org);
			
			ServletContext context=getServletContext();
			
			System.out.println("회사 개수 : " +orgDAO.Count());
			request.setAttribute("Org_number",orgDAO.Count() );
			
			RequestDispatcher rd=request.getRequestDispatcher("/addOrgnumber.jsp");
			rd.forward(request, response);
			
			
			if(orgDAO == null) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out1 = response.getWriter();
				out1.println("<script>");
				out1.println("alert('회사추가실패')");
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
			String number=(String)request.getParameter("choice");
			
			System.out.println("org서블릿 회사 넘버 : "+ number);
			
			request.setAttribute("Org_Number", number);
			
 

			RequestDispatcher rd=request.getRequestDispatcher("/card_create.jsp");
			rd.forward(request, response);
			
//			response.sendRedirect("card_create.jsp");
		}
		else if("명함 생성".equals(button)) {
			response.sendRedirect("orgselect.jsp");
		}
		else if("회사 전화 번호 추가".equals(button)) {
			System.out.println("회사번호 추가");
			OrgDAO orgDAO = new OrgDAO();
			
			int Org_id = Integer.parseInt(request.getParameter("id"));
			String org_call1 = (String)request.getParameter("number1");
			String org_call2 = (String)request.getParameter("number2");
			
			System.out.println("회사번호 추가 서블릿 : 회사 넘버 "+Org_id);
			System.out.println("1번 번호 :" + org_call1 + "2번 번호 : "+ org_call2);
			
			if(!org_call1.equals(null))
				orgDAO.add_orgnum(Org_id, org_call1);
			
			if(!org_call1.equals(null))
				orgDAO.add_orgnum(Org_id, org_call2);
			
			request.setAttribute("Org_number",orgDAO.Count() );
			response.sendRedirect("orgselect.jsp");
		}
		
		else if("수정".equals(button)) {
			Org org = new Org();
			OrgDAO orgDAO = new OrgDAO();
			
			String id=(String)request.getParameter("choice");  
			System.out.println("수정할 회사번호 : " + id);
			 
			ServletContext context=getServletContext();
			RequestDispatcher dispatcher=context.getRequestDispatcher("/updateOrg.jsp");
			
			request.setAttribute("org_number", id);
			
			dispatcher.forward(request,response);
		}
		
		else if("회사 수정".equals(button)) {
			System.out.println("회사 수정");
			Org org=new Org();
			

			String id=(String)request.getParameter("upid");  

			org.setOrgName(request.getParameter("upOrgName"));
			org.setOrgAddress(request.getParameter("upOrgAddress"));
			org.setOrgZipCode(request.getParameter("upOrgZipCode"));
			org.setOrgemail(request.getParameter("upOrgemail"));
			org.setOrgfax(request.getParameter("upOrgfax"));

			org.setOrg_Number(Integer.parseInt(id));
			
			OrgDAO orgDAO = new OrgDAO();
			orgDAO.upOrganization(org);
			
			ServletContext context=getServletContext();
			
			request.setAttribute("Org_number",Integer.parseInt(request.getParameter("upid") ));

			RequestDispatcher rd=request.getRequestDispatcher("/upOrgnumber.jsp");
			rd.forward(request, response);
		}
		
		else if ("회사 전화 번호 수정".equals(button)) {
			System.out.println("회사 전화 번호 수정");
			
			PrintWriter out=response.getWriter(); //getWriter() 출력스트림
				
			OrgCallNumber orgcall = new OrgCallNumber();
			OrgDAO orgdao = new OrgDAO();
			
			orgcall.setOrgNumber(Integer.parseInt(request.getParameter("upid")));
			orgcall.setCallNumber(request.getParameter("upnumber1"));
			
			String number = (String)request.getParameter("number1");
			
			if(!number.equals(null)) {
				orgdao.upOrg_num(orgcall, request.getParameter("number1"));
			}else {
				orgdao.add_orgnum(Integer.parseInt(request.getParameter("upid")), request.getParameter("upnumber1"));
			}
			
			orgcall.setCallNumber(request.getParameter("upnumber2"));
			
			number = (String)request.getParameter("number2");

			if(!number.equals(null)) {
				orgdao.upOrg_num(orgcall, request.getParameter("number2"));
			}
			else if(number.equals(null) && !request.getParameter("upnumber2").equals(null)) {
				orgdao.add_orgnum(Integer.parseInt(request.getParameter("upid")), request.getParameter("upnumber2"));
			}
			
			System.out.println("회사번호 수정 완료");
			
			out.println("<script>");
			out.println("alert('번호가 수정 되었습니다.')");
			out.println("</script>");
			
			response.sendRedirect("orgselect.jsp");

		}
	}

}
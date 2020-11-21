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
import javax.servlet.http.HttpSession;

import dao.CardDAO;
import dao.OrgDAO;
import vo.Card;
import vo.Org;

/**
 * Servlet implementation class CardAddServlet
 */
@WebServlet("/card_create")
public class CardAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CardAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
//		response.setCharacterEncoding("euc-kr");
		
		
		String button = request.getParameter("btn");
		System.out.println("버튼 : "+button);
		
		if(button.equals("삭제")) {
			Card card = new Card();
			CardDAO cardDAO = new CardDAO();
			
			String id=request.getParameter("card_number"); 
			
			System.out.println("id:"+id);
            cardDAO.delCard(id); 
            request.setAttribute("msg", "deleted"); 
            
            System.out.println("a");
            response.sendRedirect("maintest2.jsp");
		}
		else if(button.equals("수정")) {
			Card card = new Card();
			CardDAO cardDAO = new CardDAO();
			
			String id=request.getParameter("card_number");
			
			System.out.println("수정할 카드번호 : " + id);
			 
			ServletContext context=getServletContext();
			RequestDispatcher dispatcher=context.getRequestDispatcher("/updateCard.jsp");
			
			System.out.println("수정수정");
			request.setAttribute("card", card);
			request.setAttribute("card_number", id);
			
			dispatcher.forward(request,response);

		}
		else if(button.equals("카드수정")) {			
			Card card = new Card();
			CardDAO cardDAO = new CardDAO();
			
			System.out.println("업데이트 아이디: "+request.getParameter("upid"));
			System.out.println("업데이트 경력 : "+request.getParameter("upCarrer"));
			
			card.setName(request.getParameter("upName"));
			card.setPhoneNumber(request.getParameter("upPhoneNumber"));
			card.setTeam(request.getParameter("upTeam"));
			card.setPosition(request.getParameter("upPosition"));
			card.setEmail(request.getParameter("upEmail"));
			card.setCareer(request.getParameter("upCarrer"));
			card.setCardNumber(Integer.parseInt(request.getParameter("upid")));
			
			System.out.println("업데이트 카드 : "+card.getCardNumber() );
			cardDAO.upCard(card);
	
		
			if (cardDAO != null) {
				response.sendRedirect("maintest2.jsp");
			}
			else {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('ī�� ���� ����')");
				out.println("history.back()");
				out.println("</script>");
			}
		}
		
		else if(button.equals("카드추가")) {
			Card card = new Card();
			CardDAO cardDAO = new CardDAO();
			card.setUserID(request.getParameter("user_id"));
			card.setOrgNumber(Integer.parseInt(request.getParameter("Org_number")));
			card.setName(request.getParameter("Name"));
			card.setPhoneNumber(request.getParameter("PhoneNumber"));
			card.setTeam(request.getParameter("Team"));
			card.setPosition(request.getParameter("Position"));
			card.setEmail(request.getParameter("Email"));
			card.setCareer(request.getParameter("Career"));
			
			cardDAO.addCard(card);
			
			
		
			if (cardDAO != null) {
				response.sendRedirect("maintest2.jsp");
			}
			else {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('�α��� ����')");
				out.println("history.back()");
				out.println("</script>");
			}
		}
		else if(button.equals("로그아웃")) {
			HttpSession session=request.getSession();
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			session.invalidate();
			out.println("<script>");
			out.println("location.href='index.jsp'");
			out.println("alert('로그아웃되었습니다.')");
			out.println("</script>");
			
			
		}
		else if(button.equals("회사 정보")) {
			
			
			response.setCharacterEncoding("utf-8");
			System.out.println(request.getParameter("org_number"));
			System.out.println(request.getParameter("card_number"));
			/*
			int OrgN=Integer.parseInt(request.getParameter("org_num"));
			System.out.println(OrgN);
			Org org = new Org();
			OrgDAO orgDAO=new OrgDAO();
			*/
			/*org=orgDAO.getOrg(OrgN);
			request.setAttribute("Name", org.getOrgName());
			request.setAttribute("Address", org.getOrgAddress());
			request.setAttribute("Zipcode", org.getOrgZipCode());
			request.setAttribute("Eamil", org.getOrgemail());
			request.setAttribute("Fax", org.getOrgfax());
			System.out.println(OrgN);
			request.setAttribute("OrgN", OrgN);
			ServletContext context=getServletContext();
			RequestDispatcher dispatcher=context.getRequestDispatcher("/orginfo.jsp");
			dispatcher.forward(request,response);
*/
		}
	}
}

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
import vo.Card;

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
			
//			card = cardDAO.selectCard(id);
			
//			request.setAttribute("id", id);
//
//			response.sendRedirect("updateCard.jsp");
			 
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
	}
}

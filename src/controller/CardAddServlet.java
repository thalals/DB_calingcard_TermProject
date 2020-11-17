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
		
		
		Card card = new Card();
		CardDAO cardDAO = new CardDAO();

		//��ư
		String button = request.getParameter("btn");
		System.out.println("��ư�̸�: "+button);
		
		if(button.equals("����")) {
			String id=request.getParameter("id"); // ������ ID�� �޾ƿ�
			System.out.println("id:"+id);
            cardDAO.delCard(id); // DAO��  delMember
            request.setAttribute("msg", "deleted"); // ���� �Ϸ� �޼��� ����
            
            System.out.println("a");
            response.sendRedirect("maintest2.jsp");
		}
		else if(button.equals("����")) {
			String id=request.getParameter("id");  
			
			card = cardDAO.selectCard(id);
			ServletContext context=getServletContext();
			RequestDispatcher dispatcher=context.getRequestDispatcher("/updateCard.jsp");
			
			System.out.println("��������");
			request.setAttribute("card", card);
			request.setAttribute("id", id);
			
			dispatcher.forward(request,response);

		}
		else if(button.equals("ī�����")) {			
			
			System.out.println("���� ī��ѹ� �Ѿ���� : "+request.getParameter("id"));
			System.out.println("���� ��� �Ѿ���� : "+request.getParameter("Carrer"));
			
			card.setName(request.getParameter("Name"));
			card.setPhoneNumber(request.getParameter("PhoneNumber"));
			card.setTeam(request.getParameter("Team"));
			card.setPosition(request.getParameter("Position"));
			card.setEmail(request.getParameter("Email"));
			card.setCareer(request.getParameter("Carrer"));
			card.setCardNumber(Integer.parseInt(request.getParameter("id")));
			
			System.out.println("��a : "+card.getCardNumber() );
			cardDAO.upCard(card);
	
		
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
		
		else if(button.equals("ī���߰�")) {
			card.setName(request.getParameter("Name"));
			card.setPhoneNumber(request.getParameter("PhoneNumber"));
			card.setTeam(request.getParameter("Team"));
			card.setPosition(request.getParameter("Position"));
			card.setEmail(request.getParameter("Email"));
			card.setCareer(request.getParameter("Carrer"));
			
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

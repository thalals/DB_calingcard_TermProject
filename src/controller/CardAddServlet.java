package controller;

import java.io.IOException;
import java.io.PrintWriter;

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
		
		card.setName(request.getParameter("Name"));
		card.setPhoneNumber(request.getParameter("PhoneNumber"));
		card.setTeam(request.getParameter("Team"));
		card.setPosition(request.getParameter("Position"));
		card.setEmail(request.getParameter("Email"));
		card.setCareer(request.getParameter("Carrer"));
		
		CardDAO cardDAO = new CardDAO();
		cardDAO.addCard(card);
//		String name = request.getParameter("Name");
//		String phonenumber = request.getParameter("PhoneNumber");
//		String team = request.getParameter("Team");
//		String position = request.getParameter("Position");
//		String email = request.getParameter("Email");
//		String carrer = request.getParameter("Carrer");
//		
//		CardCreateService cardcreateService = new CardCreateService();
		
//		Card createCard = CardCreateService.getCard(name,phonenumber,team, position, email, carrer);
	
		if (cardDAO != null) {
			response.sendRedirect("maintest.jsp");
		}
		else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인실패')");
			out.println("history.back()");
			out.println("</script>");
		}
	}

}

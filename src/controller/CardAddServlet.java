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
		CardDAO cardDAO = new CardDAO();

		//버튼
		String button = request.getParameter("btn");
		System.out.println("버튼버튼버튼 : "+button);
		
		if(button.equals("삭제")) {
			String id=request.getParameter("id"); // 삭제할 ID를 받아옴
            cardDAO.delCard(id); // DAO의  delMember
            request.setAttribute("msg", "deleted"); // 삭제 완료 메세지 전달
            
            System.out.println("a");
            response.sendRedirect("maintest2.jsp");
		}
		
		else {
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
				out.println("alert('로그인실패')");
				out.println("history.back()");
				out.println("</script>");
			}
		}
	}
	
    private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String nextPage = null;
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String action = request.getPathInfo();
        System.out.println("action:" + action);
        
		CardDAO cardDAO = new CardDAO();

        if(action.equals("/delete.do")){
            String id=request.getParameter("id"); // 삭제할 ID를 받아옴
            cardDAO.delCard(id); // DAO의  delMember
            request.setAttribute("msg", "deleted"); // 삭제 완료 메세지 전달
            nextPage="/members/listMembers.do";
       }
    }

}

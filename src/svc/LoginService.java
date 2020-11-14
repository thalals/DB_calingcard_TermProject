package svc;


import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.LoginDAO;
import vo.Member;


public class LoginService {
	public Member getLoginMember(String UserID,String UserPW) {
		LoginDAO loginDAO=LoginDAO.getInstance();
		Connection con=getConnection();
		loginDAO.setConnection(con);
		Member loginMember=loginDAO.selectLoginMember(UserID,UserPW);
		close(con);
		return loginMember;
	}
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static db.JdbcUtil.*;
import vo.Member;

public class LoginDAO {
	private static LoginDAO loginDAO;
	private Connection con;
	
	private LoginDAO() {	
	}
	
	public static LoginDAO getInstance() {
		if(loginDAO == null) {
			loginDAO = new LoginDAO();
		}
		return loginDAO;
	}
	public void setConnection(Connection con) {
		this.con=con;
	}
	public Member selectLoginMember(String UserID,String UserPW) {
		Member loginMember=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=con.prepareStatement("SELECT * FROM user WHERE UserID=? AND UserPW=?");
			pstmt.setString(1, UserID);
			pstmt.setString(2, UserPW);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				loginMember=new Member();
				loginMember.setUserName(rs.getNString("UserName"));
				loginMember.setUserID(rs.getNString("UserID"));
				loginMember.setUserPW(rs.getNString("UserPW"));
				loginMember.setUserEmail(rs.getNString("UserEmail"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return loginMember;
	}
}

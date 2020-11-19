package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import vo.Member;

public class JoinDAO {
	private static JoinDAO joinDAO;
	private Connection con;
	
	
	public void getJoin() {	
		try {
			Context initCtx=new InitialContext();
			DataSource ds=(DataSource)initCtx.lookup("java:comp/env/jdbc/detol");
			con = ds.getConnection();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
		
	public void setJoinMember(Member member) {
		getJoin();
		PreparedStatement pstmt=null;
		
		try {
			pstmt=con.prepareStatement("INSERT INTO user VALUES(?,?,?,?)");
			pstmt.setString(1,member.getUserName());
			pstmt.setString(2,member.getUserID());
			pstmt.setString(3,member.getUserPW());
			pstmt.setString(4,member.getUserEmail());
			pstmt.executeUpdate();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

	}
}

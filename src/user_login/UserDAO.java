package user_login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UserDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public UserDAO() {
		try {
			//dbURL입력할때 로컬호스트:~~/디비이름? 써줘야함
			String jdbcURL = "jdbc:mysql://localhost:3306/detol?serverTimezone=UTC";
			String dbID = "root";
			String dbPassword = "1234";
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcURL, "root", "1234");
		}	catch(Exception e) {
			e.printStackTrace(); 
		}
	}
	
	public int login(String UserID, String UserPW) {
		String SQL = "SELECT UserPW FROM user WHERE UserID = ? ";
		try {
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, UserID);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(UserPW))
					return 1; //로그인 성공 
				else
					return 0; //비밀번호 불일치
			}
			return -1; //아이디가 없음
		}catch(Exception e){
			e.printStackTrace();
		}
		return -2; //데이터베이스 오류
	}
	
	//User.java의 함수 사용
	public int join(User user) {
		String SQL = "INSERT INTO USER VALUES (?,?,?,?)";
		try {
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1,user.getUserName());
			pstmt.setString(2,user.getUserID());
			pstmt.setString(3,user.getUserPW());
			pstmt.setString(4,user.getUserEmail());
			return pstmt.executeUpdate();	//결과가 반드시 0이상의 숫자가 반환
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1; //데이터베이스 오류
	}
}

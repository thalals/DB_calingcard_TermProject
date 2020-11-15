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
			//dbURL�Է��Ҷ� ����ȣ��Ʈ:~~/����̸�? �������
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
					return 1; //�α��� ���� 
				else
					return 0; //��й�ȣ ����ġ
			}
			return -1; //���̵� ����
		}catch(Exception e){
			e.printStackTrace();
		}
		return -2; //�����ͺ��̽� ����
	}
	
	//User.java�� �Լ� ���
	public int join(User user) {
		String SQL = "INSERT INTO USER VALUES (?,?,?,?)";
		try {
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1,user.getUserName());
			pstmt.setString(2,user.getUserID());
			pstmt.setString(3,user.getUserPW());
			pstmt.setString(4,user.getUserEmail());
			return pstmt.executeUpdate();	//����� �ݵ�� 0�̻��� ���ڰ� ��ȯ
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1; //�����ͺ��̽� ����
	}
}

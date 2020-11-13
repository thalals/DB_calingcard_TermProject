package card;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.sql.DataSource;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

public class CardDAO {
	
	private Connection conn;	//디비 접근
//	private PreparedStatement pstmt;	//sql 명령어를 실행하기(담기?) 위한 객체
	private ResultSet rs;	//결과값 담기
	
	//생성자 - 자동 실행
	public CardDAO() {
//		 DataSource dataSource = null;


		try {
			//mysql 접속 url
			String url = "jdbc:mysql://localhost:3306/detol?serverTimezone=UTC";
			String id = "root";
			String password ="akzmtlqkf12@";
			Class.forName("com.mysql.jdbc.Driver");	//mysql 드라이버 찾기
			conn = DriverManager.getConnection(url,"root","akzmtlqkf12@"); //conn객체 안에 접속정보
		}catch(Exception e) {
			e.printStackTrace(); //오류 출력
		}
	}
	//행 갯수
	public int Count() {
		String sql = "SELECT COUNT(*) FROM card";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);	//sql 명령어를 실행하기(담기?) 위한 객체
			rs = pstmt.executeQuery();	//쿼리 실행
			//결과가 있을때
			if(rs.next()) {
				int num = rs.getInt(1);
				return num;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	//저장일자
	public String getDate() {
		String sql = "SELECT NOW()";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);	//sql 명령어를 실행하기(담기?) 위한 객체
			rs = pstmt.executeQuery();	//쿼리 실행
			//결과가 있을때
			if(rs.next()) {
				return rs.getNString(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "오류 ";
	}
	
	
	//카드 생성
	public int addCard(Card card) {
//		Card cd = new Card();
		String sql = "INSERT INTO Card (Name, PhoneNumber, Team, Position, Email, Career) VALUES (?,?,?,?,?,?)";
		//System.out.println("넘어왔는지 확인1번 : " +card.getName() + card.getPosition());

		try {
			System.out.println("넘어왔는지 확인  2번 : " +card.getName() + card.getPosition());

			PreparedStatement pstmt = conn.prepareStatement(sql);	//sql 명령어를 실행하기(담기?) 위한 객체
			System.out.println("넘어왔는지 확인  3번 : " +card.getName() + card.getPosition());

			pstmt.setString(1, card.getName());
			pstmt.setString(2, card.getPhoneNumber());
			pstmt.setString(3, card.getTeam());
			pstmt.setString(4, card.getPosition());
			pstmt.setString(5, card.getEmail());
			pstmt.setString(6, card.getCareer());

//			rs = pstmt.executeQuery();
			return pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public ArrayList<Card> getList(){
		String sql = "SELECT * FROM Card;";
		ArrayList<Card> list = new ArrayList<Card>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);	//sql 명령어를 실행하기(담기?) 위한 객체
			rs = pstmt.executeQuery();	//쿼리 실행
			System.out.println("뭐라도 리스트 출력해봐 : "+rs.getString(4));

			//결과가 있을때
			if(rs.next()) {
				Card card = new Card();
				System.out.println("뭐라도 리스트 출력해봐 : "+rs.getString(4));
				card.setCardNumber(rs.getInt(1));
				card.setUserNumber(rs.getInt(2));
				card.setOrgNumber(rs.getInt(3));
				card.setName(rs.getString(4));
				card.setPhoneNumber(rs.getString(5));
				card.setTeam(rs.getString(6));
				card.setPosition(rs.getString(7));
				card.setEmail(rs.getString(8));
				card.setCareer(rs.getString(9));
				card.setSaveDate(rs.getString(10));
				list.add(card);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	//게시글 번호???
//	public String getNext() {
//		String sql = "SELECT CardNumber FROM ";
//		try {
//			PreparedStatement pstmt = conn.prepareStatement(sql);	//sql 명령어를 실행하기(담기?) 위한 객체
//			rs = pstmt.executeQuery();	//쿼리 실행
//			//결과가 있을때
//			if(rs.next()) {
//				return rs.getNString(1);
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return "오류 ";
//	}
	
}
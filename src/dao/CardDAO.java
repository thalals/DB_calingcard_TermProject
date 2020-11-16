package dao;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.sql.DataSource;

import vo.Card;

import java.sql.*;
import java.util.ArrayList;

import javax.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import static db.JdbcUtil.close;

public class CardDAO {
	
	private static Connection conn;	
	private static PreparedStatement pstmt;	
	private static ResultSet rs;	
	private static CardDAO cardDAO;
	
	public static void getCard() {	
		try {
			Context initCtx=new InitialContext();
			DataSource ds=(DataSource)initCtx.lookup("java:comp/env/jdbc/detol");
			conn = ds.getConnection();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void addCard(Card card) {
		getCard();
		PreparedStatement pstmt=null;
		
		try {			
			System.out.println("생성됩니까? : " +card.getName() + card.getPosition());
			pstmt=conn.prepareStatement("INSERT INTO card (Name, PhoneNumber, Team, Position, Email, Career) VALUES (?,?,?,?,?,?)");
				
			pstmt.setString(1, card.getName());
			pstmt.setString(2, card.getPhoneNumber());
			pstmt.setString(3, card.getTeam());
			pstmt.setString(4, card.getPosition());
			pstmt.setString(5, card.getEmail());
			pstmt.setString(6, card.getCareer());

			int a = pstmt.executeUpdate();	//생성되면 0이상의 값 반환
			
			System.out.println("생성됬나요 ~~ 행이 몆개인가여 : "+a);
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
		
	}
	
	
	public int Count() {
		String sql = "SELECT COUNT(*) FROM card";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);	
			rs = pstmt.executeQuery();	
			if(rs.next()) {
				int num = rs.getInt(1);
				return num;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public String getDate() {
		String sql = "SELECT NOW()";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);	
			rs = pstmt.executeQuery();	
			
			if(rs.next()) {
				return rs.getNString(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "�삤瑜� ";
	}
	
	
	
	public ArrayList<Card> getList(){
		String sql = "SELECT * FROM Card;";
		ArrayList<Card> list = new ArrayList<Card>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);	
			rs = pstmt.executeQuery();	
			System.out.println("萸먮씪�룄 由ъ뒪�듃 異쒕젰�빐遊� : "+rs.getString(4));

			if(rs.next()) {
				Card card = new Card();
				System.out.println("萸먮씪�룄 由ъ뒪�듃 異쒕젰�빐遊� : "+rs.getString(4));
				card.setCardNumber(rs.getInt(1));
				card.setUserID(rs.getInt(2));
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
	

}
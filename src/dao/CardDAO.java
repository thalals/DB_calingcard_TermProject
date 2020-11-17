package dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.*;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import vo.Card;

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
	//카드 컬럼 선택
	public static Card selectCard(String id) {
		getCard();
		PreparedStatement pstmt=null;
		Card card = new Card();
		
		

		try {
			pstmt=conn.prepareStatement("select * from card where CardNumber = ?");
			pstmt.setNString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				card.setCardNumber(rs.getInt(1));
				card.setUserID(rs.getString(2));
				card.setOrgNumber(rs.getInt(3));
				card.setName(rs.getString(4));
				card.setPhoneNumber(rs.getString(5));
				card.setTeam(rs.getString(6));
				card.setPosition(rs.getString(7));
				card.setEmail(rs.getString(8));
				card.setCareer(rs.getString(9));
				card.setSaveDate(rs.getString(10));
				
			}
			System.out.println("카드 선택 확인 : " + card.getName());
			return card;
			
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
		
		return card;
	}
	//카드 리스트 가져오기
	public static ArrayList<Card> getCardlist() {
		getCard();
		PreparedStatement pstmt=null;
		ArrayList<Card> list = new ArrayList<Card>();

		try {
			pstmt=conn.prepareStatement("select * from card");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Card card = new Card();

				card.setCardNumber(rs.getInt(1));
				card.setUserID(rs.getString(2));
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
		finally {
			try {
				rs.close();
				pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	//카드 추가
	public static void addCard(Card card) {
		getCard();
		PreparedStatement pstmt=null;
		
		try {			
			System.out.println("생성됩니까? : " +card.getName() + card.getPosition());
			pstmt=conn.prepareStatement("INSERT INTO card (Name, PhoneNumber, Team, Position, Email, Career, UserID, Org_Number, save_date) VALUES (?,?,?,?,?,?,?,?,now())");
				
			pstmt.setString(1, card.getName());
			pstmt.setString(2, card.getPhoneNumber());
			pstmt.setString(3, card.getTeam());
			pstmt.setString(4, card.getPosition());
			pstmt.setString(5, card.getEmail());
			pstmt.setString(6, card.getCareer());
			pstmt.setString(7, card.getUserID());
			pstmt.setInt(8, card.getOrgNumber());
			
			int a = pstmt.executeUpdate();	//생성되면 0이상의 값 반환
			System.out.println(card.getCareer());
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
	
	//삭제
	public void delCard(String id) {
		getCard();
		PreparedStatement pstmt=null;
		
        try {
            pstmt=conn.prepareStatement("delete from card where CardNumber=?");
			
           
            pstmt.setString(1, id);
            int a = pstmt.executeUpdate();
            System.out.println("삭제된 행 수: " + a);
        }
        catch (Exception e) {
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
	
	//카드 수정
	public void upCard(Card card) {
		getCard();
		PreparedStatement pstmt=null;
		
		String sql="UPDATE card SET Name = ?, PhoneNumber = ?,Team = ?,Position = ?,Email = ?,Career = ?, save_date = now() WHERE CardNumber = ?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			System.out.println("cardDAO 수저 : " + card.getCareer() );
			pstmt.setString(1, card.getName());
			pstmt.setString(2, card.getPhoneNumber());
			pstmt.setString(3, card.getTeam());
			pstmt.setString(4, card.getPosition());
			pstmt.setString(5, card.getEmail());
			pstmt.setString(6, card.getCareer());
			pstmt.setString(7,  Integer.toString(card.getCardNumber()));
	
			int a = pstmt.executeUpdate();	//생성되면 0이상의 값 반환
			
			System.out.println("수정됬나요 ~~ 행이 몆개인가여 : "+a);
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

}
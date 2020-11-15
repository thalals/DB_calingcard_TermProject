package card;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

import javax.sql.DataSource;
import javax.*;
import javax.naming.Context;
import javax.naming.InitialContext;

public class CardDAO {
	
	private Connection conn;	//�뵒鍮� �젒洹�
	private PreparedStatement pstmt;	//sql 紐낅졊�뼱瑜� �떎�뻾�븯湲�(�떞湲�?) �쐞�븳 媛앹껜
	private ResultSet rs;	//寃곌낵媛� �떞湲�
	
	//�깮�꽦�옄 - �옄�룞 �떎�뻾
	public CardDAO() {
		Connection con=null;


		try {
			//mysql �젒�냽 url
//			String url = "jdbc:mysql://localhost:3306/detol?serverTimezone=UTC";
//			String id = "root";
//			String password ="1234";
//			Class.forName("com.mysql.cj.jdbc.Driver");	//mysql �뱶�씪�씠踰� 李얘린
//			conn = DriverManager.getConnection(url,"root","1234"); //conn媛앹껜 �븞�뿉 �젒�냽�젙蹂�
			
			Context initCtx=new InitialContext();

			DataSource ds=(DataSource)initCtx.lookup("java:comp/env/jdbc/detol");
			con=ds.getConnection();
			con.setAutoCommit(false);
			System.out.println("connect success");
		}catch(Exception e) {
			e.printStackTrace(); //�삤瑜� 異쒕젰
		}
	}
	//�뻾 媛��닔
	public int Count() {
		String sql = "SELECT COUNT(*) FROM card";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);	//sql 紐낅졊�뼱瑜� �떎�뻾�븯湲�(�떞湲�?) �쐞�븳 媛앹껜
			rs = pstmt.executeQuery();	//荑쇰━ �떎�뻾
			//寃곌낵媛� �엳�쓣�븣
			if(rs.next()) {
				int num = rs.getInt(1);
				return num;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	//���옣�씪�옄
	public String getDate() {
		String sql = "SELECT NOW()";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);	//sql 紐낅졊�뼱瑜� �떎�뻾�븯湲�(�떞湲�?) �쐞�븳 媛앹껜
			rs = pstmt.executeQuery();	//荑쇰━ �떎�뻾
			//寃곌낵媛� �엳�쓣�븣
			if(rs.next()) {
				return rs.getNString(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "�삤瑜� ";
	}
	
	
	//移대뱶 �깮�꽦
	public int addCard(Card card) {
//		Card cd = new Card();
		String sql = "INSERT INTO Card (Name, PhoneNumber, Team, Position, Email, Career) VALUES (?,?,?,?,?,?)";
		//System.out.println("�꽆�뼱�솕�뒗吏� �솗�씤1踰� : " +card.getName() + card.getPosition());

		try {
			System.out.println("�꽆�뼱�솕�뒗吏� �솗�씤  2踰� : " +card.getName() + card.getPosition());

			PreparedStatement pstmt = conn.prepareStatement(sql);	//sql 紐낅졊�뼱瑜� �떎�뻾�븯湲�(�떞湲�?) �쐞�븳 媛앹껜
			System.out.println("�꽆�뼱�솕�뒗吏� �솗�씤  3踰� : " +card.getName() + card.getPosition());

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
			PreparedStatement pstmt = conn.prepareStatement(sql);	//sql 紐낅졊�뼱瑜� �떎�뻾�븯湲�(�떞湲�?) �쐞�븳 媛앹껜
			rs = pstmt.executeQuery();	//荑쇰━ �떎�뻾
			System.out.println("萸먮씪�룄 由ъ뒪�듃 異쒕젰�빐遊� : "+rs.getString(4));

			//寃곌낵媛� �엳�쓣�븣
			if(rs.next()) {
				Card card = new Card();
				System.out.println("萸먮씪�룄 由ъ뒪�듃 異쒕젰�빐遊� : "+rs.getString(4));
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
	
	
	//寃뚯떆湲� 踰덊샇???
//	public String getNext() {
//		String sql = "SELECT CardNumber FROM ";
//		try {
//			PreparedStatement pstmt = conn.prepareStatement(sql);	//sql 紐낅졊�뼱瑜� �떎�뻾�븯湲�(�떞湲�?) �쐞�븳 媛앹껜
//			rs = pstmt.executeQuery();	//荑쇰━ �떎�뻾
//			//寃곌낵媛� �엳�쓣�븣
//			if(rs.next()) {
//				return rs.getNString(1);
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return "�삤瑜� ";
//	}
	
}
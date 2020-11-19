package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import vo.Card;
import vo.Org;
import vo.OrgCallNumber;

public class OrgDAO {
	private static Connection conn;	
	private static PreparedStatement pstmt;	
	private static ResultSet rs;	
	private static OrgDAO orgDAO;
	
	//DB �뿰�룞
	public static void getOrg() {	
		try {
			Context initCtx=new InitialContext();
			DataSource ds=(DataSource)initCtx.lookup("java:comp/env/jdbc/detol");
			conn = ds.getConnection();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//회사 번호 체크
	public int Count() {
		String sql = "SELECT COUNT(*) FROM organization";
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
	
	//회사번호 추가
	public static void add_orgnum(int Org_num, String num) {
		getOrg();
		
		System.out.println("전화번호 추가되는 회사 번호 1:  " + num);
		System.out.println("전화번호 추가되는 아이디:  " + Org_num);

		Connection conn =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			Context cp = new InitialContext();
			DataSource ds = (DataSource)cp.lookup("java:comp/env/jdbc/detol");
			conn = ds.getConnection();
			
			String sql ="insert into orgcallnum (OrgNumber, CallNumber) values (?, ?)";
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, Org_num);
			ps.setString(2, num);
			
			ps.executeUpdate();
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
	
	public static void addOrganization(Org org) {
		getOrg();
		PreparedStatement pstmt=null;
		
//		request.setCharacterEncoding("utf-8");
		try {			
			System.out.println("회사 생성 되나영?");
			pstmt=conn.prepareStatement("INSERT INTO organization(OrgName, OrgAddress, OrgZipCode, Orgemail, Orgfax) VALUES (?,?,?,?,?)");
				
			pstmt.setString(1, org.getOrgName());
			pstmt.setString(2, org.getOrgAddress());
			pstmt.setString(3, org.getOrgZipCode());
			pstmt.setString(4, org.getOrgemail());
			pstmt.setString(5, org.getOrgfax());
			
			int a = pstmt.executeUpdate();
			System.out.println("회사 생성되는 행 : "+a);

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
	public static int getOrgN(String text) {
		PreparedStatement pstmt=null;
		int x=0;
		try {
			pstmt=conn.prepareStatement("SELECT Org_Number from organization WHERE OrgName=?");
			pstmt.setNString(1, text);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				x=rs.getInt(1);
			}
			
			return x;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public static ArrayList<OrgCallNumber> getOrgnum_list(int num){
		
		getOrg();
		PreparedStatement pstmt=null;
		ArrayList<OrgCallNumber> list = new ArrayList<OrgCallNumber>();

		try {
			pstmt=conn.prepareStatement("select * from orgcallnum where OrgNumber = ?");
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				OrgCallNumber org=new OrgCallNumber();

				org.setCallNumber(rs.getString(1));
				org.setOrgNumber((int)rs.getInt(2));
				
				list.add(org);
			}
		}
		catch(Exception e) {
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
	
	public static ArrayList<Org> getOrglist() {
		getOrg();
		PreparedStatement pstmt=null;
		ArrayList<Org> list = new ArrayList<Org>();

		try {
			pstmt=conn.prepareStatement("select * from organization");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Org org=new Org();
				
				org.setOrg_Number((int)rs.getInt(1));
				org.setOrgName(rs.getString(2));
				org.setOrgAddress(rs.getString(3));
				org.setOrgZipCode(rs.getString(4));
				org.setOrgfax(rs.getString(5));
				org.setOrgemail(rs.getString(6));
				list.add(org);
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
	
	
}
	

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
		}finally {
			try {
				pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	public static ArrayList<Org> getOrglist() {
		getOrg();
		PreparedStatement pstmt=null;
		ArrayList<Org> list = new ArrayList<Org>();

		try {
			pstmt=conn.prepareStatement("select OrgName from organization");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Org org=new Org();
				org.setOrgName(rs.getNString(1));
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
	

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import vo.Org;

public class OrgDAO {
	private static Connection conn;	
	private static PreparedStatement pstmt;	
	private static ResultSet rs;	
	private static OrgDAO orgDAO;
	
	//DB 연동
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
		//request.setCharacterEncoding("utf-8");
		try {			
			pstmt=conn.prepareStatement("INSERT INTO organization(OrgName, OrgAddress, OrgZipCode, Orgemail, Orgfax) VALUES (?,?,?,?,?)");
				
			pstmt.setString(1, org.getOrgName());
			pstmt.setString(2, org.getOrgAddress());
			pstmt.setString(3, org.getOrgZipCode());
			pstmt.setString(4, org.getOrgemail());
			pstmt.setString(5, org.getOrgfax());
			
			pstmt.executeUpdate();
			
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
	

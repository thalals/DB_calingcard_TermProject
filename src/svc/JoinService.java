package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.JoinDAO;
import vo.Member;

public class JoinService {
	public boolean joinMember(Member member) {
		boolean joinSuccess=false;
//		JoinDAO joinDAO = JoinDAO.getInstance();
		Connection con = getConnection();
//		joinDAO.setConnection(con);
//		int insertCount=joinDAO.setJoinMember(member);
////		if(insertCount>0) {
//			joinSuccess=true;
//		}
//		close(con);
		return joinSuccess;
	}

	
}

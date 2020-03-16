package maskAppointment.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import maskAppointment.pojo.Citizen;
import maskAppointment.util.DBUtil;

public class CitizenDAOImpl implements CitizenDAO{

	private Connection conn=null;
	private Statement stmt=null;
	private ResultSet rs=null;
	
	public Citizen hasOne(String idNum) {
		Citizen c=null;
		try {
			conn=DBUtil.getConnection();
			stmt=conn.createStatement();
			String sql="select from citizen where idNumber='"+idNum+"'";
			rs=stmt.executeQuery(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, stmt, conn);
		}
		return c;
	}
	
	public boolean insert(Citizen c) {
		try {
			conn=DBUtil.getConnection();
			stmt=conn.createStatement();
			String sql="insert into citizen value('"+c.getIdNumber()+"','"+c.getName()+"','"+c.getPhone()+"',"+c.getOrderNum()+","+c.getLastRound()+")";
			return stmt.execute(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, stmt, conn);
		}
		return false;
	}
}

package maskAppointment.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import maskAppointment.pojo.OrderInformation;
import maskAppointment.util.DBUtil;

public class OrderInformationDAOImpl implements OrderInformationDAO{
	
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	public OrderInformation select(String idNum,int round) {
		OrderInformation oi=null;
		try {
			conn=DBUtil.getConnection();
			stmt=conn.createStatement();
			String sql="select * from orderInformation where idNumber='"+idNum+"' AND orderRound="+round;
			rs=stmt.executeQuery(sql);
			if(rs.next())
				oi=new OrderInformation(String.valueOf(rs.getInt("orderId")),rs.getString("idNumber"),rs.getInt("orderRound"));
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, stmt, conn);
		}
		return oi;
	}
	
	public boolean insert(OrderInformation oi) {
		try {
			conn=DBUtil.getConnection();
			stmt=conn.createStatement();
			String sql="insert into orderInformation value("+String.valueOf(oi.getOrderId())+",'"+oi.getIdNumber()+"',"+String.valueOf(oi.getOrderRound());
			return stmt.execute(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, stmt, conn);
		}
		return false;
	}
}

package maskAppointment.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import maskAppointment.pojo.Proof;
import maskAppointment.util.DBUtil;

public class ProofDAOImpl implements ProofDAO{

	@Override
	public List<Proof> getList() {
		// TODO Auto-generated method stub
		List<Proof> proofs = new ArrayList<Proof>();
		Connection conn;
		try {
			conn = DBUtil.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "select * from proof";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Proof proof = new Proof();
				proof.setOrderId(rs.getString("orderId"));
				proof.setName(rs.getString("name"));
				proof.setIdNumber(rs.getString("idNumber"));
				proof.setPhone(rs.getString("phone"));
				proof.setOrderNum(rs.getInt("orderNum"));
				proofs.add(proof);
			}
			DBUtil.close(rs, stmt, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return proofs;
	}

}

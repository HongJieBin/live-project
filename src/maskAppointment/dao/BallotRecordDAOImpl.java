package maskAppointment.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import maskAppointment.pojo.BallotRecord;
import maskAppointment.util.DBUtil;

public class BallotRecordDAOImpl implements BallotRecordDAO {
	public List<BallotRecord> getList() {
		// TODO Auto-generated method stub
		List<BallotRecord> ballotRecords = new ArrayList<BallotRecord>();
		Connection conn;
		try {
			conn = DBUtil.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "select * from ballotRecord";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				BallotRecord ballotRecord = new BallotRecord();
				ballotRecord.setBallotRound(rs.getInt("ballotRound"));
				ballotRecord.setIdNumber(rs.getString("idNumber"));
				ballotRecord.setRecordId(rs.getString("recordid"));
				ballotRecords.add(ballotRecord);
			}
			DBUtil.close(rs, stmt, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ballotRecords;
	}
}

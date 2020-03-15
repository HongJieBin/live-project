package maskAppointment.dao;

import java.sql.ResultSet;

public interface OrderInformationDAO {
	
	public ResultSet select(String idNum,int round) ;
}

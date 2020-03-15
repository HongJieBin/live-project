package maskAppointment.dao;

import java.sql.ResultSet;

import maskAppointment.pojo.OrderInformation;

public interface OrderInformationDAO {
	
	public OrderInformation select(String idNum,int round) ;
}

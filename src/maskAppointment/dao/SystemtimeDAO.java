package maskAppointment.dao;

import java.sql.*;

import maskAppointment.pojo.Systemtime;
import maskAppointment.util.DBUtil;

public interface SystemTimeDAO {
	
	public int getTotal();
	//设置信息
	public void set(Systemtime systemtime);
	
	//�޸ĸ���ʱ��
	public void update(Systemtime systemtime);
}

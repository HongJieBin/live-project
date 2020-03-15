package maskAppointment.dao;
import maskAppointment.pojo.Citizen;

public interface CitizenDAO {
	
	public Citizen hasOne(String idNum);
	
	public boolean insert(Citizen c);
}

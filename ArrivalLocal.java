package interfaces;

import java.sql.Date;

import javax.ejb.Local;

@Local
public interface ArrivalLocal {
	public void AddArrival(Date d,int id);
}

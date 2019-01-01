package interfaces;

import java.sql.Date;

import javax.ejb.Remote;

@Remote
public interface ArrivalRemote {
	public void AddArrival(Date d,int id);
}

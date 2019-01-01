package interfaces;

import java.sql.Date;
import java.util.List;

import javax.ejb.Remote;

import model.Applicant;
import model.User;

@Remote
public interface ApplicantRemote {
	public List<Applicant> PreEmployed();
	public void FixRDV(int id,Date d,int idr);
}

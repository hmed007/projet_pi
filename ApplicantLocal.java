package interfaces;

import java.sql.Date;
import java.util.List;

import javax.ejb.Local;

import model.Applicant;
import model.User;

@Local
public interface ApplicantLocal {
	public List<Applicant> PreEmployed();
	public void FixRDV(int id,Date d,int idr);
}

package dao;

import org.springframework.stereotype.Repository;

@Repository
public interface InstallmentDAO {
	
	double calculateEMI(int duration);
	double calculateNewBal(double emi, double bal);
	double getRemCredits(double cred, double price);

}

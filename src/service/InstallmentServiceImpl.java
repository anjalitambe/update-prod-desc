package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.InstallmentDAO;

@Service
public class InstallmentServiceImpl implements IInstallmentService {
	
	@Autowired
	private InstallmentDAO installmentDAO;

	@Override
	public double calculateEMI(int duration) {

		return installmentDAO.calculateEMI(duration);
	}

	@Override
	public double calculateNewBal(double emi, double bal) {
		// TODO Auto-generated method stub
		return installmentDAO.calculateNewBal(emi,bal);
	}

	@Override
	public double getRemCredits(double cred, double price) {
		// TODO Auto-generated method stub
		return installmentDAO.calculateNewBal(cred,price);
	}

}

package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InstallmentDAOImpl implements InstallmentDAO{
	
	private static final Logger logger = 			
			LoggerFactory.getLogger(InstallmentDAOImpl.class);
	
	
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	
	

	@Override
	public double calculateEMI(int duration) {
		// TODO Auto-generated method stub
		return 0;
	}




	@Override
	public double calculateNewBal(double emi, double bal) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
	
		double newbal= bal-emi;
		
		tx.commit();
		session.close();
		return newbal;
	}




	@Override
	public double getRemCredits(double cred, double price) {
		double remcred= cred-price;
		 return remcred;
	}

}

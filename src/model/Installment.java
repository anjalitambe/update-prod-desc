package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Installment")
public class Installment implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int installmentID;
	private int duration;
	private int customerId;
	private int productId;
	private int perMonthAmount;
	private boolean paidStatus;
	double amountToPay;

	
	public Installment(int installmentID, int duration, int customerId, int productId, int perMonthAmount,
			boolean paidStatus, double amountToPay) {
		super();
		this.installmentID = installmentID;
		this.duration = duration;
		this.customerId = customerId;
		this.productId = productId;
		this.perMonthAmount = perMonthAmount;
		this.paidStatus = paidStatus;
		this.amountToPay = amountToPay;
	}
	public double getAmountToPay() {
		return amountToPay;
	}
	public void setAmountToPay(double amountToPay) {
		this.amountToPay = amountToPay;
	}
	public int getInstallmentID() {
		return installmentID;
	}
	public void setInstallmentID(int installmentID) {
		this.installmentID = installmentID;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getPerMonthAmount() {
		return perMonthAmount;
	}
	public void setPerMonthAmount(int perMonthAmount) {
		this.perMonthAmount = perMonthAmount;
	}
	public boolean isPaidStatus() {
		return paidStatus;
	}
	public void setPaidStatus(boolean paidStatus) {
		this.paidStatus = paidStatus;
	}


	@Override
	public String toString() {
		return "Installment [installmentID=" + installmentID + ", duration=" + duration + ", customerId=" + customerId
				+ ", productId=" + productId + ", perMonthAmount=" + perMonthAmount + ", paidStatus=" + paidStatus
				+ ", amountToPay=" + amountToPay + "]";
	}
	public Installment(int installmentID, int duration, int customerId, int productId, int perMonthAmount,
			boolean paidStatus) {
		super();
		this.installmentID = installmentID;
		this.duration = duration;
		this.customerId = customerId;
		this.productId = productId;
		this.perMonthAmount = perMonthAmount;
		this.paidStatus = paidStatus;
	}
	public Installment() {
		super();
	}
	
	


}

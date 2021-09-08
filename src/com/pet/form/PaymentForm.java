package com.pet.form;

import java.util.Date;
import java.util.List;

import com.pet.model.Doctor;
import com.pet.model.Payment;
import com.pet.model.Schedule;
import com.pet.model.Schedule.Day;

public class PaymentForm {
	private String frmVoucherNo;
	private String frmPaymentDate;
	private String frmPaymentAmt;
	private String frmPaymentStatus;
	
	private List<Payment> frmPaymentList;
	
	public List<Payment> getFrmPaymentList() {
		return frmPaymentList;
	}
	public void setFrmPaymentList(List<Payment> frmPaymentList) {
		this.frmPaymentList = frmPaymentList;
	}
	public String getFrmVoucherNo() {
		return frmVoucherNo;
	}
	public void setFrmVoucherNo(String frmVoucherNo) {
		this.frmVoucherNo = frmVoucherNo;
	}
	public String getFrmPaymentDate() {
		return frmPaymentDate;
	}
	public void setFrmPaymentDate(String frmPaymentDate) {
		this.frmPaymentDate = frmPaymentDate;
	}
	public String getFrmPaymentAmt() {
		return frmPaymentAmt;
	}
	public void setFrmPaymentAmt(String frmPaymentAmt) {
		this.frmPaymentAmt = frmPaymentAmt;
	}
	public String getFrmPaymentStatus() {
		return frmPaymentStatus;
	}
	public void setFrmPaymentStatus(String frmPaymentStatus) {
		this.frmPaymentStatus = frmPaymentStatus;
	}
	
}
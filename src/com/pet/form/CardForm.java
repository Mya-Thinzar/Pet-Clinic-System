package com.pet.form;

import java.util.Date;
import java.util.List;

import com.pet.model.Doctor;
import com.pet.model.Payment;
import com.pet.model.Schedule;
import com.pet.model.Schedule.Day;

public class CardForm {
	private String frmCardId;
	private String frmCardNumber;
	
	private Payment frmPayment;
	private String frmVoucherNo;
	
	public CardForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CardForm(String frmCardId, String frmCardNumber, Payment frmPayment, String frmVoucherNo) {
		super();
		this.frmCardId = frmCardId;
		this.frmCardNumber = frmCardNumber;
		this.frmPayment = frmPayment;
		this.frmVoucherNo = frmVoucherNo;
	}
	public String getFrmCardId() {
		return frmCardId;
	}
	public void setFrmCardId(String frmCardId) {
		this.frmCardId = frmCardId;
	}
	public String getFrmCardNumber() {
		return frmCardNumber;
	}
	public void setFrmCardNumber(String frmCardNumber) {
		this.frmCardNumber = frmCardNumber;
	}
	public Payment getFrmPayment() {
		return frmPayment;
	}
	public void setFrmPayment(Payment frmPayment) {
		this.frmPayment = frmPayment;
	}
	public String getFrmVoucherNo() {
		return frmVoucherNo;
	}
	public void setFrmVoucherNo(String frmVoucherNo) {
		this.frmVoucherNo = frmVoucherNo;
	}
}
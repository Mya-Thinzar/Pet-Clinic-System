package com.pet.model;

import java.util.Date;

public class Payment {
	private String voucherNo;
	private Date paymentDate;
	private int paymentAmt;
	public enum Status{cash,card} ;
	private Status paymentStatus;
	
	private Card card;
	private Integer cardId;

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Payment(String voucherNo, Date paymentDate, int paymentAmt, Status paymentStatus, Card card,
			Integer cardId) {
		super();
		this.voucherNo = voucherNo;
		this.paymentDate = paymentDate;
		this.paymentAmt = paymentAmt;
		this.paymentStatus = paymentStatus;
		this.card = card;
		this.cardId = cardId;
	}
	public Status getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(Status paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	public Integer getCardId() {
		return cardId;
	}
	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}
	public String getVoucherNo() {
		return voucherNo;
	}
	public void setVoucherNo(String voucherNo) {
		this.voucherNo = voucherNo;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public int getPaymentAmt() {
		return paymentAmt;
	}
	public void setPaymentAmt(int paymentAmt) {
		this.paymentAmt = paymentAmt;
	}
}

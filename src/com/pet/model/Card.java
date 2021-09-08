package com.pet.model;

import java.util.Date;

public class Card {
	private Integer cardId;
	private String cardNumber;
	
	private Payment cardPayment;
	private String voucherNo;
	
	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Card(Integer cardId, String cardNumber, Payment cardPayment, String voucherNo) {
		super();
		this.cardId = cardId;
		this.cardNumber = cardNumber;
		this.cardPayment = cardPayment;
		this.voucherNo = voucherNo;
	}
	public Integer getCardId() {
		return cardId;
	}
	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public Payment getCardPayment() {
		return cardPayment;
	}
	public void setCardPayment(Payment cardPayment) {
		this.cardPayment = cardPayment;
	}
	public String getVoucherNo() {
		return voucherNo;
	}
	public void setVoucherNo(String voucherNo) {
		this.voucherNo = voucherNo;
	}
	
}

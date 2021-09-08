package com.pet.model;

public class PetUserLogin {
	private String loginId;
	private String loginPassword;
	
	public PetUserLogin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PetUserLogin(String loginId, String loginPassword) {
		super();
		this.loginId = loginId;
		this.loginPassword = loginPassword;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getloginPassword() {
		return loginPassword;
	}
	public void setloginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
}

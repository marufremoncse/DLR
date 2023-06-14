package com.codingsense.model;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Route {
	private String apiRoot = "https://api.mnpspbd.com";
	private String userIdParam = "user";
	private String passParam = "password";
	private String msisdnParam = "GSM";
	private String senderParam = "sender";
	private String smsTextParam = "SMSText";
	private String userIdValue;
	private String passValue;
	private String senderValue = "";

	public String getApiRoot() {
		return apiRoot;
	}

	public void setApiRoot(String apiRoot) {
		this.apiRoot = apiRoot;
	}

	public String getUserIdParam() {
		return userIdParam;
	}

	public void setUserIdParam(String userIdParam) {
		this.userIdParam = userIdParam;
	}

	public String getPassParam() {
		return passParam;
	}

	public void setPassParam(String passParam) {
		this.passParam = passParam;
	}

	public String getMsisdnParam() {
		return msisdnParam;
	}

	public void setMsisdnParam(String msisdnParam) {
		this.msisdnParam = msisdnParam;
	}

	public String getSenderParam() {
		return senderParam;
	}

	public void setSenderParam(String senderParam) {
		this.senderParam = senderParam;
	}

	public String getSmsTextParam() {
		return smsTextParam;
	}

	public void setSmsTextParam(String smsTextParam) {
		this.smsTextParam = smsTextParam;
	}

	public String getUserIdValue() {
		return userIdValue;
	}

	public void setUserIdValue(String userIdValue) {
		this.userIdValue = userIdValue;
	}

	public String getPassValue() {
		return passValue;
	}

	public void setPassValue(String passValue) {
		this.passValue = passValue;
	}

	public String getSenderValue() {
		return senderValue;
	}

	public void setSenderValue(String senderValue) {
		this.senderValue = senderValue;
	}
}
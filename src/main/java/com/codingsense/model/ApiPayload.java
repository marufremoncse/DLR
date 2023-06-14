package com.codingsense.model;

import org.springframework.stereotype.Service;

@Service
public class ApiPayload {
	private String username;
	private String password;
	private String messageId;
	private String status;
	private String errorCode;
	private String mobile;
	private String shortMessage;
	private String submitDate;
	private String doneDate;

	public ApiPayload() {
		
	}

	public ApiPayload(String username, String password, String messageId, String status, String errorCode,
			String mobile, String shortMessage, String submitDate, String doneDate) {
		this.username = username;
		this.password = password;
		this.messageId = messageId;
		this.status = status;
		this.errorCode = errorCode;
		this.mobile = mobile;
		this.shortMessage = shortMessage;
		this.submitDate = submitDate;
		this.doneDate = doneDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getShortMessage() {
		return shortMessage;
	}

	public void setShortMessage(String shortMessage) {
		this.shortMessage = shortMessage;
	}

	public String getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
	}

	public String getDoneDate() {
		return doneDate;
	}

	public void setDoneDate(String doneDate) {
		this.doneDate = doneDate;
	}
}

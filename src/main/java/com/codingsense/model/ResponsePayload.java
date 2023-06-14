package com.codingsense.model;

import java.util.HashMap;

public class ResponsePayload {
	private String statusInfo;
	private String statusCode;
	private String errordescription;
	private String clienttransid;
	private HashMap<String, String> messageIDs;

	public ResponsePayload() {
		super();
	}

	public ResponsePayload(String statusInfo, String statusCode, String errordescription, String clienttransid,
			HashMap<String, String> messageIDs) {
		super();
		this.statusInfo = statusInfo;
		this.statusCode = statusCode;
		this.errordescription = errordescription;
		this.clienttransid = clienttransid;
		this.messageIDs = messageIDs;
	}

	public String getStatusInfo() {
		return statusInfo;
	}

	public void setStatusInfo(String statusInfo) {
		this.statusInfo = statusInfo;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getErrordescription() {
		return errordescription;
	}

	public void setErrordescription(String errordescription) {
		this.errordescription = errordescription;
	}

	public String getClienttransid() {
		return clienttransid;
	}

	public void setClienttransid(String clienttransid) {
		this.clienttransid = clienttransid;
	}

	public HashMap<String, String> getMessageIDs() {
		return messageIDs;
	}

	public void setMessageIDs(HashMap<String, String> messageIDs) {
		this.messageIDs = messageIDs;
	}

	@Override
	public String toString() {
		return "ResponsePayload [statusInfo=" + statusInfo + ", statusCode=" + statusCode + ", errordescription="
				+ errordescription + ", clienttransid=" + clienttransid + ", messageIDs=" + messageIDs + "]";
	}

}
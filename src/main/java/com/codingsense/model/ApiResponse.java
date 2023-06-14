package com.codingsense.model;


public class ApiResponse {
	private String statusInfo;
	private String statusCode;
	private String errordescription;
	
	public ApiResponse() {
		super();
	}

	public ApiResponse(String statusInfo, String statusCode, String errordescription) {
		super();
		this.statusInfo = statusInfo;
		this.statusCode = statusCode;
		this.errordescription = errordescription;
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
}


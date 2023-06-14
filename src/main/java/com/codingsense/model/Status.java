package com.codingsense.model;

public class Status {
	private String status;
	private long tt;
	private String trid;
	private String response;

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getTt() {
		return tt;
	}

	public void setTt(long tt) {
		this.tt = tt;
	}

	public String getTrid() {
		return trid;
	}

	public void setTrid(String trid) {
		this.trid = trid;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "TRID: " + getTrid() + ", Status: " + getStatus() + ", Response: " + getResponse();
	}
}
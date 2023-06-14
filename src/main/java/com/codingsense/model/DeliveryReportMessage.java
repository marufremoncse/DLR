package com.codingsense.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "message")
@XmlAccessorType(XmlAccessType.FIELD)
public class DeliveryReportMessage {
    @XmlAttribute(name = "id")
    private String id;
    
    @XmlAttribute(name = "sentdate")
    private String sentDate;
    
    @XmlAttribute(name = "donedate")
    private String doneDate;
    
    @XmlAttribute(name = "status")
    private String status;
    
    @XmlAttribute(name = "gsmerror")
    private String gsmError;
    
    @XmlAttribute(name = "price")
    private String price;
    
    @XmlAttribute(name = "pducount")
    private String pduCount;
    
    @XmlAttribute(name = "shortmessage")
    private String shortMessage;
    
    @XmlAttribute(name = "mobile")
    private String mobile;
    
	public DeliveryReportMessage(String id, String sentDate, String doneDate, String status, String gsmError,
			String price, String pduCount, String shortMessage, String mobile) {
		this.id = id;
		this.sentDate = sentDate;
		this.doneDate = doneDate;
		this.status = status;
		this.gsmError = gsmError;
		this.price = price;
		this.pduCount = pduCount;
		this.shortMessage = shortMessage;
		this.mobile = mobile;
	}
	
	public String getShortmessage() {
		return shortMessage;
	}

	public void setShortMessage(String shortMessage) {
		this.shortMessage = shortMessage;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSentdate() {
		return sentDate;
	}

	public void setSentdate(String sentDate) {
		this.sentDate = sentDate;
	}

	public String getDonedate() {
		return doneDate;
	}

	public void setDonedate(String doneDate) {
		this.doneDate = doneDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getGsmerror() {
		return gsmError;
	}

	public void setGsmerror(String gsmerror) {
		this.gsmError = gsmerror;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPducount() {
		return pduCount;
	}

	public void setPducount(String pduCount) {
		this.pduCount = pduCount;
	}

	@Override
	public String toString() {
		return "DeliveryReportMessage [id=" + id + ", sentDate=" + sentDate + ", doneDate=" + doneDate + ", status="
				+ status + ", gsmError=" + gsmError + ", price=" + price + ", pduCount=" + pduCount + ", shortMessage="
				+ shortMessage + ", mobile=" + mobile + "]";
	}
    
}
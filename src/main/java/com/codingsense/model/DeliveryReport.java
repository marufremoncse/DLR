package com.codingsense.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DeliveryReport")
@XmlAccessorType(XmlAccessType.FIELD)
public class DeliveryReport {
    @XmlElement(name = "message")
    private DeliveryReportMessage message;
	
	public DeliveryReport() {
		
	}
	
	public DeliveryReport(DeliveryReportMessage message) {
		this.message = message;
	}

	public DeliveryReportMessage getMessage() {
		return message;
	}

	public void setMessage(DeliveryReportMessage message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "DeliveryReport [message=" + message + "]";
	}
	
	
}
package com.codingsense.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingsense.model.ApiPayload;
import com.codingsense.model.DeliveryReport;
import com.codingsense.model.DeliveryReportMessage;
import com.codingsense.model.ResponsePayload;
import com.codingsense.model.Route;
import com.codingsense.model.Status;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(path = "/api/v2/")
public class ApiController {

	@Autowired
	Route route;

	@Autowired
	ApiPayload apiPayload;

	@PostMapping("MessageStatus")

	public HashMap<String, Object> callProcess(@RequestBody DeliveryReport deliveryReport) {
		HashMap<String, Object> responseMap = new HashMap<>();
		HashMap<String, Object> statusInfo = new HashMap<>();
		try {
			UUID uuid = UUID.randomUUID();
			//System.out.println("IATLID: " + uuid + " " +"REQUEST_PAYLOAD: " + deliveryReport.toString());
			
			LinkedHashMap<String, Object> main = new LinkedHashMap<>();
			DeliveryReportMessage message = deliveryReport.getMessage();
			if(message!=null) {
				String id = message.getId();
		        String sentDate = message.getSentdate();
		        String doneDate = message.getDonedate();
		        String status = message.getStatus();
		        String gsmError = message.getGsmerror();
		        String price = message.getPrice();
		        String pduCount = message.getPducount();
		        String shortMessage = message.getShortmessage();
		        String mobile = message.getMobile();
		        
		        System.out.println("IATLID: " + uuid + " " +"REQUEST_PAYLOAD: " + message.toString());
		        
		        String username = "RanksITT_admin";
		        String password = "ritt@359-!";
		        
		        
				apiPayload.setUsername(username);
				apiPayload.setPassword(password);
				apiPayload.setMessageId(id);
				apiPayload.setStatus(status);
				apiPayload.setErrorCode(gsmError);
				apiPayload.setMobile(mobile);
				apiPayload.setShortMessage(shortMessage);
				apiPayload.setSubmitDate(sentDate);
				apiPayload.setDoneDate(doneDate);

				System.out.println("IATLID: " + uuid + " " +"API_PAYLOAD: " + apiPayload.toString());
				
				main.put("username", apiPayload.getUsername());
				main.put("password", apiPayload.getPassword());
				main.put("messageId", apiPayload.getMessageId());
				
				String deliveryStatus = "";
				
				switch(apiPayload.getStatus()) {
					case "DELIVERED":
						deliveryStatus = "Delivered";
						break;
					case "NOT_DELIVERED":
						deliveryStatus = "Undelivered";
						break;
					default:
						deliveryStatus = "Delivery Pending";
						break;
				}
				main.put("status", deliveryStatus);
				main.put("errorCode", apiPayload.getErrorCode());
				main.put("mobile", apiPayload.getMobile());
				main.put("shortMesssage", apiPayload.getShortMessage());
				main.put("submitDate", apiPayload.getSubmitDate());
				main.put("doneDate", apiPayload.getDoneDate());

				ResponsePayload responsePayload = new ResponsePayload();
				responsePayload = process(responsePayload, main, route, uuid);

				statusInfo.put("statusCode", responsePayload.getStatusCode());
				statusInfo.put("errordescription", responsePayload.getErrordescription());
				responseMap.put("statusInfo", statusInfo);
			}
			else {
				statusInfo.put("statusCode", "1020");
				statusInfo.put("errordescription", "Internal Server Error");
				responseMap.put("statusInfo", statusInfo);
			}
		} catch (Exception e) {
			statusInfo.put("statusCode", "1020");
			statusInfo.put("errordescription", "Internal Server Error");
			responseMap.put("statusInfo", statusInfo);
			e.printStackTrace();
		}
		return responseMap;
	}

	public ResponsePayload process(ResponsePayload responsePayload,
			HashMap<String, Object> jsonInput, Route route, UUID uuid) {

		Status st = new Status();
		st.setStatus("");
		String SMS_RESPONSE = "";
		String status = "";
		long tm = System.currentTimeMillis();
		try {
			String urlString = route.getApiRoot() + "/a2p-proxy-api-iptsp/api/v1/MessageStatus";
			URL url = new URL(urlString);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			con.setConnectTimeout(20000);
			con.setReadTimeout(20000);

			var objectMapper = new ObjectMapper();
			String jsonInputString = objectMapper.writeValueAsString(jsonInput);

			System.out.println("IATLID: " + uuid + " " +"PAYLOAD_JSON: " + jsonInputString);

			try (OutputStream os = con.getOutputStream()) {
				byte[] input = jsonInputString.getBytes("utf-8");
				os.write(input, 0, input.length);
			}
			try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
				StringBuilder response = new StringBuilder();
				String responseLine = null;
				while ((responseLine = br.readLine()) != null) {
					response.append(responseLine.trim());
				}
				SMS_RESPONSE = response.toString();
				System.out.println("IATLID: " + uuid + " " +"RESPONSE: " + SMS_RESPONSE);
			}

			JSONParser j = new JSONParser();
			JSONObject o = (JSONObject) j.parse(SMS_RESPONSE);
			JSONObject statusInfo = (JSONObject) o.get("statusInfo");

			String statusCode = (String) statusInfo.get("statusCode");
		    String errordescription = (String) statusInfo.get("errordescription");
		    
			responsePayload.setStatusCode(statusCode);
			responsePayload.setErrordescription(errordescription);
		} catch (Exception e) {
			e.printStackTrace();
			responsePayload.setStatusCode("1020");
			responsePayload.setErrordescription("Internal Server Error");
		}

		long tmt = System.currentTimeMillis();

		//st.setTrid(String.valueOf(apiPayload.getId()));
		st.setStatus(status);
		st.setTt(tmt - tm);

		return responsePayload;
	}

}

package com.scb.omega.utils;

import java.io.File;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
public class MGSample {
	 // ...
	public static JsonNode sendSimpleMessage() throws UnirestException {
		HttpResponse<JsonNode> request = Unirest.
				post("https://api.mailgun.net/v3/sandbox421d32a2cf1a4688ad593d29f570808c.mailgun.org/messages")
			.basicAuth("api", "65713e844896ac30b9fc22bdb1a1aa51-9776af14-d8a4f586")
			.queryString("from", "Excited User zartab@sandbox421d32a2cf1a4688ad593d29f570808c.mailgun.org")
			.queryString("to", "nzartab@gmail.com")
			.queryString("subject", "hello")
			.queryString("text", "testing")
			.asJson();
		return request.getBody();
	}
	
	
	public static void main(String[] args) throws UnirestException {
		MGSample.sendSimpleMessage();
	}
}
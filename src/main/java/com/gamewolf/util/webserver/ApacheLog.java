package com.gamewolf.util.webserver;

import java.util.Date;

public class ApacheLog {
	
	String domainName;

	String ipAddress;
	Date time;
	String method;
	String resource;
	String fullUrl;
	String httpVersion;
	String responceCode;
	int bytesCount;
	String refer;
	String browser;
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getFullUrl() {
		return fullUrl;
	}
	public void setFullUrl(String fullUrl) {
		this.fullUrl = fullUrl;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	public String getHttpVersion() {
		return httpVersion;
	}
	public void setHttpVersion(String httpVersion) {
		this.httpVersion = httpVersion;
	}
	public String getResponceCode() {
		return responceCode;
	}
	public void setResponceCode(String responceCode) {
		this.responceCode = responceCode;
	}
	public int getBytesCount() {
		return bytesCount;
	}
	public void setBytesCount(int bytesCount) {
		this.bytesCount = bytesCount;
	}
	public String getRefer() {
		return refer;
	}
	public void setRefer(String refer) {
		this.refer = refer;
	}
	public String getBrowser() {
		return browser;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	
	public String getDomainName() {
		return domainName;
	}
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	

}

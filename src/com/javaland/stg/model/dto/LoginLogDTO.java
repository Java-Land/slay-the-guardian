package com.javaland.stg.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class LoginLogDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7098764385614743652L;
	
	private int loginNo;
	private String loginId;
	private java.sql.Date loginConnectTime;
	private java.sql.Date loginTime;
	private java.sql.Date logoutTime;
	
	public LoginLogDTO() {
	}
	
	public LoginLogDTO(int loginNo, String loginId, Date loginConnectTime, Date loginTime, Date logoutTime) {
		this.loginNo = loginNo;
		this.loginId = loginId;
		this.loginConnectTime = loginConnectTime;
		this.loginTime = loginTime;
		this.logoutTime = logoutTime;
	}
	
	public int getLoginNo() {
		return loginNo;
	}
	public void setLoginNo(int loginNo) {
		this.loginNo = loginNo;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public java.sql.Date getLoginConnectTime() {
		return loginConnectTime;
	}
	public void setLoginConnectTime(java.sql.Date loginConnectTime) {
		this.loginConnectTime = loginConnectTime;
	}
	public java.sql.Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(java.sql.Date loginTime) {
		this.loginTime = loginTime;
	}
	public java.sql.Date getLogoutTime() {
		return logoutTime;
	}
	public void setLogoutTime(java.sql.Date logoutTime) {
		this.logoutTime = logoutTime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "LoginLogDTO [loginNo=" + loginNo + ", loginId=" + loginId + ", loginConnectTime=" + loginConnectTime
				+ ", loginTime=" + loginTime + ", logoutTime=" + logoutTime + "]";
	}
	
	
	
	
}

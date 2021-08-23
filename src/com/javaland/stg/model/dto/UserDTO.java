package com.javaland.stg.model.dto;

import java.io.Serializable;

public class UserDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5086562440091331705L;

	private String userId;
	private String userPwd;
	private int deathCnt;
	private String blackListYN;
	
	public UserDTO() {
	}
	
	public UserDTO(String userId, String userPwd, int deathCnt, String blackListYN) {
		this.userId = userId;
		this.userPwd = userPwd;
		this.deathCnt = deathCnt;
		this.blackListYN = blackListYN;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public int getDeathCnt() {
		return deathCnt;
	}
	public void setDeathCnt(int deathCnt) {
		this.deathCnt = deathCnt;
	}
	public String getBlackListYN() {
		return blackListYN;
	}
	public void setBlackListYN(String blackListYN) {
		this.blackListYN = blackListYN;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", userPwd=" + userPwd + ", deathCnt=" + deathCnt + ", blackListYN="
				+ blackListYN + "]";
	}
	
}
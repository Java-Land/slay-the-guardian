package com.javaland.stg.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class UserListDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7873466412067377475L;

	private String id;
	private java.sql.Date playTime;
	private int level;
	private int exp;
	private int gold;
	private int maxHp;
	private int sp;
	private int dp;
	private String blackListYN;
	
	public UserListDTO() {
	}

	public UserListDTO(String id, Date playTime, int level, int exp, int gold, int maxHp, int sp, int dp,
			String blackListYN) {
		this.id = id;
		this.playTime = playTime;
		this.level = level;
		this.exp = exp;
		this.gold = gold;
		this.maxHp = maxHp;
		this.sp = sp;
		this.dp = dp;
		this.blackListYN = blackListYN;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public java.sql.Date getPlayTime() {
		return playTime;
	}

	public void setPlayTime(java.sql.Date playTime) {
		this.playTime = playTime;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public int getSp() {
		return sp;
	}

	public void setSp(int sp) {
		this.sp = sp;
	}

	public int getDp() {
		return dp;
	}

	public void setDp(int dp) {
		this.dp = dp;
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
		return "UserListDTO [id=" + id + ", playTime=" + playTime + ", level=" + level + ", exp=" + exp + ", gold="
				+ gold + ", maxHp=" + maxHp + ", sp=" + sp + ", dp=" + dp + ", blackListYN=" + blackListYN + "]";
	}
		
}



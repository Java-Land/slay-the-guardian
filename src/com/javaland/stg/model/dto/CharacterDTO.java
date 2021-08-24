package com.javaland.stg.model.dto;

import java.io.Serializable;
import java.sql.Date;

import com.javaland.stg.common.Monster;

public class CharacterDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5508771761130946917L;
	
	private int code;
	private String id;
	private int hp;
	private int maxHp;
	private int sp;
	private int dp;
	private int gold;
	private int exp;
	private int level;
	private java.sql.Date playTime;
	private String liveYN;
	private String stage1ClearYN;
	private String stage2ClearYN;
	
	public CharacterDTO() {
		super();
	}

	public CharacterDTO(int code, String id, int hp, int maxHp, int sp, int dp, int gold, int exp, int level,
			Date playTime, String liveYN, String stage1ClearYN, String stage2ClearYN) {
		super();
		this.code = code;
		this.id = id;
		this.hp = hp;
		this.maxHp = maxHp;
		this.sp = sp;
		this.dp = dp;
		this.gold = gold;
		this.exp = exp;
		this.level = level;
		this.playTime = playTime;
		this.liveYN = liveYN;
		this.stage1ClearYN = stage1ClearYN;
		this.stage2ClearYN = stage2ClearYN;
	}

	public void attackMonster(Monster monster) {
		if(this.sp - monster.getDp() > 0) {
			monster.setHp(monster.getHp() - (this.sp - monster.getDp()));
		} else {
			
		}
	}
	
	public void victoryBattle(Monster enemy) {
		this.exp += enemy.getDropExp();
		this.gold += enemy.getDropGold();
	}
	
	public void checkLevelUp() {
		if(exp > (level * 100)) {
			maxHp += 100;
			hp = maxHp;
			sp += 10;
			dp += 5;
			level += 1;
			exp = 0;
		}
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
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

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public java.sql.Date getPlayTime() {
		return playTime;
	}

	public void setPlayTime(java.sql.Date playTime) {
		this.playTime = playTime;
	}

	public String getLiveYN() {
		return liveYN;
	}

	public void setLiveYN(String liveYN) {
		this.liveYN = liveYN;
	}

	public String getStage1ClearYN() {
		return stage1ClearYN;
	}

	public void setStage1ClearYN(String stage1ClearYN) {
		this.stage1ClearYN = stage1ClearYN;
	}

	public String getStage2ClearYN() {
		return stage2ClearYN;
	}

	public void setStage2ClearYN(String stage2ClearYN) {
		this.stage2ClearYN = stage2ClearYN;
	}

	@Override
	public String toString() {
		return "CharacterDTO [code=" + code + ", id=" + id + ", hp=" + hp + ", maxHp=" + maxHp + ", sp=" + sp + ", dp="
				+ dp + ", gold=" + gold + ", exp=" + exp + ", level=" + level + ", playTime=" + playTime + ", liveYN="
				+ liveYN + ", stage1ClearYN=" + stage1ClearYN + ", stage2ClearYN=" + stage2ClearYN + "]";
	}
	
}
package com.javaland.stg.common;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.javaland.stg.model.dto.CharacterDTO;

public class Monster {
	
	private Image img;
	private int imgX;
	private int imgY;
	private String name;
	private int maxHp;
	private int hp = 0;
	private int sp;
	private int dp;
	private int dropExp;
	private int dropGold;
	
	public Monster() {
		super();
	}
	
	public Monster(String name) {
		this.name = name;
		
		switch (name) {
		case "slime":
			this.img = new ImageIcon("image/SlimeMonsterImg.png").getImage();
			this.imgX = 800;
			this.imgY = 600;
			this.maxHp = 10;
			this.dp = 2;
			this.sp = 7;
			this.dropExp = 4;
			this.dropGold = 15;
			break;
		case "jawWorm":
			this.img = new ImageIcon("image/JawWormMonsterImg.png").getImage();
			this.imgX = 840;
			this.imgY = 580;
			this.maxHp = 10;
			this.dp = 2;
			this.sp = 7;
			this.dropExp = 4;
			this.dropGold = 15;
			break;
		case "gremlin":
			this.img = new ImageIcon("image/GremlinMonsterImg.png").getImage();
			this.imgX = 750;
			this.imgY = 350;
			this.maxHp = 10;
			this.dp = 2;
			this.sp = 7;
			this.dropExp = 4;
			this.dropGold = 15;
			break;
		case "champion":
			this.img = new ImageIcon("image/ChampionBossImg.png").getImage();
			this.imgX = 1100;
			this.imgY = 200;
			this.maxHp = 10;
			this.dp = 2;
			this.sp = 7;
			this.dropExp = 4;
			this.dropGold = 15;
			break;
		case "parasite":
			this.img = new ImageIcon("image/ParasiteMonsterImg.png").getImage();
			this.imgX = 800;
			this.imgY = 500;
			this.maxHp = 10;
			this.dp = 2;
			this.sp = 7;
			this.dropExp = 4;
			this.dropGold = 15;
			break;
		case "snecko":
			this.img = new ImageIcon("image/SneckoMonsterImg.png").getImage();
			this.imgX = 750;
			this.imgY = 450;
			this.maxHp = 10;
			this.dp = 2;
			this.sp = 7;
			this.dropExp = 4;
			this.dropGold = 15;
			break;
		case "book":
			this.img = new ImageIcon("image/bookMonsterImg.png").getImage();
			this.imgX = 750;
			this.imgY = 350;
			this.maxHp = 10;
			this.dp = 2;
			this.sp = 7;
			this.dropExp = 4;
			this.dropGold = 15;
			break;
		case "timeEater":
			this.img = new ImageIcon("image/timeEaterBossImg.png").getImage();
			this.imgX = 1100;
			this.imgY = 200;
			this.maxHp = 10;
			this.dp = 2;
			this.sp = 7;
			this.dropExp = 4;
			this.dropGold = 15;
			break;
		case "transienter":
			this.img = new ImageIcon("image/TransienterMonsterImg.png").getImage();
			this.imgX = 750;
			this.imgY = 360;
			this.maxHp = 10;
			this.dp = 2;
			this.sp = 7;
			this.dropExp = 4;
			this.dropGold = 15;
			break;
		case "writhingMass":
			this.img = new ImageIcon("image/WrithingMassMonsterImg.png").getImage();
			this.imgX = 750;
			this.imgY = 500;
			this.maxHp = 10;
			this.dp = 2;
			this.sp = 7;
			this.dropExp = 4;
			this.dropGold = 15;
			break;
		case "nemesis":
			this.img = new ImageIcon("image/NemesisMonsterImg.png").getImage();
			this.imgX = 800;
			this.imgY = 320;
			this.maxHp = 10;
			this.dp = 2;
			this.sp = 7;
			this.dropExp = 4;
			this.dropGold = 15;
			break;
		case "theGuardian":
			this.img = new ImageIcon("image/TheGuardianBossImg.png").getImage();
			this.imgX = 1070;
			this.imgY = 250;
			this.maxHp = 10;
			this.dp = 2;
			this.sp = 7;
			this.dropExp = 4;
			this.dropGold = 15;
			break;
		}
	}
	
	public void attackCharacter(CharacterDTO character) {
		if(this.sp - character.getDp() > 0) {
			character.setHp(character.getHp() - (this.sp - character.getDp()));
		} else {
			
		}
	}
	
	public void reSpawn() {
		this.hp = this.maxHp;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public int getImgX() {
		return imgX;
	}

	public void setImgX(int imgX) {
		this.imgX = imgX;
	}

	public int getImgY() {
		return imgY;
	}

	public void setImgY(int imgY) {
		this.imgY = imgY;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
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

	public int getDropExp() {
		return dropExp;
	}

	public void setDropExp(int dropExp) {
		this.dropExp = dropExp;
	}

	public int getDropGold() {
		return dropGold;
	}

	public void setDropGold(int dropGold) {
		this.dropGold = dropGold;
	}

	@Override
	public String toString() {
		return "Monster [img=" + img + ", imgX=" + imgX + ", imgY=" + imgY + ", name=" + name + ", maxHp=" + maxHp
				+ ", hp=" + hp + ", sp=" + sp + ", dp=" + dp + ", dropExp=" + dropExp + ", dropGold=" + dropGold + "]";
	}
	
}

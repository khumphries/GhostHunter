package edu.virignia.cs2110.team21.ghosthunterproject;

import android.graphics.Bitmap;

public class Player extends Character {
	int money, life;
	boolean hasBomb, hasLife, hasSpeed;

	public int getMoney() {
		return money;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public void speedBoost() {
		PlayGame.speed = 6;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public void addMoney(int m) {
		this.money += m;
	}

	public boolean hasBomb() {
		return hasBomb;
	}

	public void setHasBomb(boolean hasBomb) {
		this.hasBomb = hasBomb;
	}

	public boolean hasLife() {
		return hasLife;
	}

	public void setHasLife(boolean hasLife) {
		this.hasLife = hasLife;
	}

	public boolean isHasSpeed() {
		return hasSpeed;
	}

	public void hasSpeed(boolean hasSpeed) {
		this.hasSpeed = hasSpeed;
	}

	public Player(double posx, double posy, String col, Bitmap picture) {
		super(posx, posy, col, picture);
		this.money = 0;
	}

	public Player(Player p) {
		super(p.getPx(), p.getPy(), p.getColor(), p.getPicture());
		this.money = 0;
	}

}

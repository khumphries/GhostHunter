package edu.virignia.cs2110.team21.ghosthunterproject;

import java.util.Random;

import android.graphics.Bitmap;

public class Ghost extends Character {
	boolean isHostile;

	public Ghost(double posx, double posy, String col, Bitmap picture) {
		super(posx, posy, col, picture);
		Random rand = new Random();
		int randomNumX = rand.nextInt((800 - 0) + 1);
		int randomNumY = rand.nextInt((950 - 0) + 1);
		this.px = (double) randomNumX;
		this.py = (double) randomNumY;
		isHostile = false;
	}

	public Ghost(Ghost g) {
		super(g.getPx(), g.getPy(), g.getColor(), g.getPicture());
		isHostile = false;
	}

	public void idle() {
		double rando = (double) Math.random();
		double velrando = (double) Math.random() * .5;
		if (rando >= 0 && rando < .25) {
			this.setV(0.0, velrando);
		}
		if (rando >= .25 && rando < .50) {
			this.setV(velrando, 0.0);
		}
		if (rando >= .50 && rando < .75) {
			this.setV(0.0, -velrando);
		}
		if (rando >= .75 && rando < 1) {
			this.setV(-velrando, 0.0);
		}
	}

	public void attack(Character that) {
		if(this.getPy()>that.getPy() && this.getPx()>that.getPx()){
			this.setV(-this.getVx()-4, -this.getVy()-4);
		}
		if(this.getPy()>that.getPy() && this.getPx()<that.getPx()){
			this.setV(-this.getVx()+4, -this.getVy()-4);
		}
		if(this.getPy()<that.getPy() && this.getPx()>that.getPx()){
			this.setV(-this.getVx()-4, -this.getVy()+4);
		}
		if(this.getPy()<that.getPy() && this.getPx()<that.getPx()){
			this.setV(-this.getVx()+4, -this.getVy()+4);
		}
		

	}
}

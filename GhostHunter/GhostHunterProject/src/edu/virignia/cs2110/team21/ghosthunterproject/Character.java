package edu.virignia.cs2110.team21.ghosthunterproject;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;

public class Character {

	double px, py, vx, vy;
	CollisionBox hitBox;
	Bitmap picture;
	String color;
	boolean canMove;

	public Character(double posx, double posy, String col, Bitmap picture) {
		this.px = posx;
		this.py = posy;
		this.color = col;
		this.vx = 0;
		this.vy = 0;
		this.canMove = true;
		this.hitBox = new CollisionBox(this.px + 75, this.py + 75, 150, 150);
		this.picture = picture;
	}

	public Character(Character c) {
		this.px = c.getPx();
		this.py = c.getPy();
		this.color = c.getColor();
		this.vx = 0;
		this.vy = 0;
		this.canMove = true;
		this.hitBox = new CollisionBox(c.getPx() + 75, c.getPy() + 75, 150, 150);
		this.picture = c.getPicture();
	}

	public void resizePicture(Bitmap bm, int newHeight, int newWidth) {
		int width = bm.getWidth();
		int height = bm.getHeight();
		float scaleWidth = ((float) newWidth) / width;
		float scaleHeight = ((float) newHeight) / height;
		// create a matrix for the manipulation
		Matrix matrix = new Matrix();
		// resize the bit map
		matrix.postScale(scaleWidth, scaleHeight);
		// recreate the new Bitmap
		Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height,
				matrix, false);
		this.picture = resizedBitmap;
	}

	public void draw(Canvas c) {
		c.drawBitmap(this.getPicture(), (float) this.getPx(),
				(float) this.getPy(), null);
	}

	 public CollisionBox getHitBox() {
	 return hitBox;
	 }

	public Bitmap getPicture() {
		return picture;
	}

	public void setPicture(Bitmap picture) {
		this.picture = picture;
	}

	 public void setHitBox(CollisionBox hitBox) {
	 this.hitBox = hitBox;
	 }

	public void setV(double velx, double vely) {
		this.vx += velx;
		this.vy += vely;
	}

	public void move() {
		if (canMove) {
			this.px += vx;
			this.py += vy;
		}
	}

	public boolean isSameColor(Character that) {
		return (this.color.equals(that.color));
	}

	public double getPx() {
		return px;
	}

	public void setPx(double px) {
		this.px = px;
	}

	public double getPy() {
		return py;
	}

	public void setPy(double py) {
		this.py = py;
	}

	public double getVx() {
		return vx;
	}

	public double getVy() {
		return vy;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isCanMove() {
		return canMove;
	}

	public void setCanMove(boolean canMove) {
		this.canMove = canMove;
	}

}

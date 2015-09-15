package edu.virignia.cs2110.team21.ghosthunterproject;

import android.graphics.Rect;

public class CollisionBox {
	private Rect hitBox;

	CollisionBox(double x, double y, double width, double height) {
		this.hitBox = new Rect((int) x, (int) y, (int) width, (int) height);
	}

	public Rect getRect() {
		return hitBox;
	}

	// Bounds
	public boolean hitBoundsRight() {
		if ((this.hitBox.exactCenterX() + (this.hitBox.width() / 2)) >= 800) {
			return true;
		} else
			return false;
	}

	public boolean hitBoundsLeft() {
		if ((this.hitBox.exactCenterX() - (this.hitBox.width() / 2)) < 0) {
			return true;
		} else
			return false;
	}

	public boolean hitBoundsTop() {
		if ((this.hitBox.exactCenterY() + (this.hitBox.height() / 2)) < 0) {
			return true;
		} else
			return false;
	}

	public boolean hitBoundsBottom() {
		if (this.hitBox.exactCenterY() - (this.hitBox.height() / 2) > 950) {
			return true;
		} else
			return false;
	}

	// Walls
	public boolean hitWallRight(CollisionBox that) {
		if (this.hitBox.intersect(that.hitBox)
				&& this.hitBox.exactCenterX() + (this.hitBox.width() / 2) > that.hitBox
						.exactCenterX() - (this.hitBox.width() / 2)
				&& this.hitBox.exactCenterX() - (this.hitBox.width() / 2) < that.hitBox
						.exactCenterX() - (this.hitBox.width() / 2)) {
			return true;
		} else
			return false;
	}

	public boolean hitWallLeft(CollisionBox that) {
		if (this.hitBox.intersect(that.hitBox)
				&& this.hitBox.exactCenterX() - (this.hitBox.width() / 2) < that.hitBox
						.exactCenterX() + (this.hitBox.width() / 2)
				&& this.hitBox.exactCenterX() + (this.hitBox.width() / 2) > that.hitBox
						.exactCenterX() + (this.hitBox.width() / 2)) {
			return true;
		} else
			return false;
	}

	public boolean hitWallTop(CollisionBox that) {
		if (this.hitBox.intersect(that.hitBox)
				&& this.hitBox.exactCenterY() > that.hitBox.centerY()
				&& this.hitBox.exactCenterY() + (this.hitBox.height() / 2) < that.hitBox
						.exactCenterY() - (this.hitBox.height() / 2)
				&& this.hitBox.exactCenterY() - (this.hitBox.height() / 2) > that.hitBox
						.exactCenterY() - (this.hitBox.height() / 2)) {
			return true;
		} else
			return false;
	}

	public boolean hitWallBottom(CollisionBox that) {
		if (this.hitBox.intersect(that.hitBox)
				&& this.hitBox.exactCenterY() < that.hitBox.centerY()
				&& this.hitBox.exactCenterY() - (this.hitBox.height() / 2) > that.hitBox
						.exactCenterY() + (this.hitBox.height() / 2)
				&& this.hitBox.exactCenterY() + (this.hitBox.height() / 2) < that.hitBox
						.exactCenterY() + (this.hitBox.height() / 2)) {
			return true;
		} else
			return false;
	}

	// Characters
	public boolean hitCharacterLeft(Character that) {
		if (this.hitBox.intersect(that.getHitBox().getRect())
				&& this.hitBox.exactCenterX() - (this.hitBox.width() / 2) < that
						.getHitBox().getRect().exactCenterX()
						+ (this.hitBox.width() / 2)
				&& this.hitBox.exactCenterX() + (this.hitBox.width() / 2) > that
						.getHitBox().getRect().exactCenterX()
						+ (this.hitBox.width() / 2)) {
			return true;
		} else
			return false;
	}

	public boolean hitCharacterRight(Character that) {
		if (Rect.intersects(this.getRect(), that.getHitBox().getRect())) {
			return true;
		} else
			return false;
	}

	public boolean isHigher(Character that) {
		if (this.hitBox.intersect(that.getHitBox().getRect())
				&& this.hitBox.centerY() < that.getHitBox().getRect()
						.exactCenterY()
						+ (this.hitBox.height() / 2)
				&& this.hitBox.exactCenterX() > that.getHitBox().getRect()
						.exactCenterX()
						- (this.hitBox.width() / 2)
				&& this.hitBox.exactCenterX() < that.getHitBox().getRect()
						.exactCenterX()
						+ (this.hitBox.width() / 2)) {
			return true;
		} else {
			return false;
		}
	}
}
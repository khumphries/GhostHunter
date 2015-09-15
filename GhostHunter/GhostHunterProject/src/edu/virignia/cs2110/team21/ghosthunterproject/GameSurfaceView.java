package edu.virignia.cs2110.team21.ghosthunterproject;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameSurfaceView extends SurfaceView implements
		SurfaceHolder.Callback {
	// GLOBAL VARIABLES
	private CanvasThread canvasthread;

	// Variable used to hold our bitmap
	Bitmap whiteninja;
	Bitmap blueninja;
	Bitmap greenninja;
	Bitmap orangeninja;
	Bitmap purpleninja;
	Bitmap blueghost;
	Bitmap greenghost;
	Bitmap orangeghost;
	Bitmap purpleghost;
	Bitmap background;
	Bitmap greenstar;
	Bitmap nunchucks;
	Bitmap orangesword;
	Bitmap purplehammer;
	Bitmap tombstone1;
	Bitmap tombstone2;
	Bitmap tombstone3;
	Bitmap heartdown;

	static Player player;
	ArrayList<Ghost> enemies;
	Ghost one;
	Ghost two;
	Ghost three;
	Ghost four;

	// END GLOBAL VARIABLES

	public GameSurfaceView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub

		getHolder().addCallback(this);
		canvasthread = new CanvasThread(getHolder(), this);
		setFocusable(true);
		// Here we load our Bitmap variable with the graphic ship.png in the
		// drawable-hdpi folder.
		background = BitmapFactory.decodeResource(getResources(),
				R.drawable.background);
		whiteninja = BitmapFactory.decodeResource(getResources(),
				R.drawable.whiteninja);
		blueninja = BitmapFactory.decodeResource(getResources(),
				R.drawable.blueninja);
		greenninja = BitmapFactory.decodeResource(getResources(),
				R.drawable.greenninja);
		orangeninja = BitmapFactory.decodeResource(getResources(),
				R.drawable.orangeninja);
		purpleninja = BitmapFactory.decodeResource(getResources(),
				R.drawable.purpleninja);
		blueghost = BitmapFactory.decodeResource(getResources(),
				R.drawable.blueghost);
		greenghost = BitmapFactory.decodeResource(getResources(),
				R.drawable.greenghost);
		orangeghost = BitmapFactory.decodeResource(getResources(),
				R.drawable.orangeghost);
		purpleghost = BitmapFactory.decodeResource(getResources(),
				R.drawable.purpleghost);
		greenstar = BitmapFactory.decodeResource(getResources(),
				R.drawable.greenstar);
		nunchucks = BitmapFactory.decodeResource(getResources(),
				R.drawable.nunchucks);
		orangesword = BitmapFactory.decodeResource(getResources(),
				R.drawable.orangesword);
		purplehammer = BitmapFactory.decodeResource(getResources(),
				R.drawable.purplehammer);
		tombstone1 = BitmapFactory.decodeResource(getResources(),
				R.drawable.tombstone1);
		tombstone2 = BitmapFactory.decodeResource(getResources(),
				R.drawable.tombstone2);
		tombstone3 = BitmapFactory.decodeResource(getResources(),
				R.drawable.tombstone3);

		player = new Player(400, 450, "white", whiteninja);
		enemies = new ArrayList<Ghost>();
		one = new Ghost(0, 0, "blue", blueghost);
		two = new Ghost(0, 0, "green", greenghost);
		three = new Ghost(0, 0, "orange", orangeghost);
		four = new Ghost(0, 0, "purple", purpleghost);
		player.resizePicture(player.getPicture(), 150, 150);
		one.resizePicture(one.getPicture(), 150, 150);
		two.resizePicture(two.getPicture(), 150, 150);
		three.resizePicture(three.getPicture(), 150, 150);
		four.resizePicture(four.getPicture(), 150, 150);
		background = this.resizePicture(background, 1500, 1100);//950, 800 for tablet
		greenstar = this.resizePicture(greenstar, 150, 150);
		nunchucks = this.resizePicture(nunchucks, 150, 150);
		orangesword = this.resizePicture(orangesword, 150, 150);
		purplehammer = this.resizePicture(purplehammer, 150, 150);
		whiteninja = this.resizePicture(whiteninja, 1500, 1100);
		greenninja = this.resizePicture(greenninja, 150, 150);
		blueninja = this.resizePicture(blueninja, 150, 150);
		orangeninja = this.resizePicture(orangeninja, 150, 150);
		purpleninja = this.resizePicture(purpleninja, 150, 150);
		tombstone1 = this.resizePicture(tombstone1, 100, 100);
		tombstone2 = this.resizePicture(tombstone2, 150, 100);
		tombstone3 = this.resizePicture(tombstone3, 150, 150);
		heartdown = BitmapFactory.decodeResource(getResources(),R.drawable.heartdown);
		heartdown = this.resizePicture(heartdown, 150, 150);


		enemies.add(one);
		enemies.add(two);
		enemies.add(three);
		enemies.add(four);

	}

	public Bitmap resizePicture(Bitmap bm, int newHeight, int newWidth) {
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
		return resizedBitmap;
	}

	public GameSurfaceView(Context context) {
		super(context);
		getHolder().addCallback(this);

		setFocusable(true);

	}

	public GameSurfaceView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);

	}

	@Override
	public void onDraw(Canvas canvas) {

		update();

		// canvas.drawColor(Color.RED);
		canvas.drawBitmap(background, 0, 0, null);
		canvas.drawBitmap(greenstar, 0, 0, null);
		canvas.drawBitmap(nunchucks, 1100 - 150, 0, null);
		canvas.drawBitmap(orangesword, 0, 1500 - 150, null);
		canvas.drawBitmap(purplehammer, 1100 - 150, 1500 - 150, null);
		canvas.drawBitmap(tombstone1, 200, 200, null);

		for (Ghost g : enemies) {
			g.draw(canvas);
		}
		player.draw(canvas);
		// canvas.drawBitmap(whiteninja, x, y, null);

	}

	public void update() {

		player.setV(player.getVx() * -0.03, 0);
		player.setV(0, player.getVy() * -0.03);
		for (Ghost g : enemies) {
			g.idle();
		}
		if (player.getPx() <= 150 && player.getPy() <= 150) {
			player.setColor("green");
			player.setPicture(greenninja);
		}
		if (player.getPx() >= 1100 - 150 && player.getPy() <= 150) {
			player.setColor("blue");
			player.setPicture(blueninja);
		}
		if (player.getPx() <= 150 && player.getPy() >= 1500 - 150) {
			player.setColor("orange");
			player.setPicture(orangeninja);
		}
		if (player.getPx() >= 1100 - 150 && player.getPy() >= 1500 - 150) {
			player.setColor("purple");
			player.setPicture(purpleninja);
		}
		if (player.getPx() >= 1100 - 75) {
			player.setV(-player.getVx() - 2, 0);
			player.setPx(1100 - 75);
		}
		if (player.getPx() <= 0) {
			player.setV(-player.getVx() + 2, 0);
			player.setPx(0);
		}
		if (player.getPy() >= 1500 - 75) {
			player.setV(0, -player.getVy() - 2);
			player.setPy(1500 - 75);
		}
		if (player.getPy() <= 0) {
			player.setV(0, -player.getVy() + 2);
			player.setPy(0);
		}
		for (Ghost g : enemies) {
			if (Math.sqrt(((player.getPx() - g.getPx()) * (player.getPx() - g
					.getPx()))
					- ((player.getPy() - g.getPy()) * (player.getPy() - g
							.getPy()))) < 100) {
				g.attack(player);
			}
		}
		for (Ghost g : enemies) {
			if (g.getPx() >= 1100 - 75) {
				g.setV(-g.getVx() - 2, 0);
				g.setPx(1100 - 75);
			}
			if (g.getPx() <= 0) {
				g.setV(-g.getVx() + 2, 0);
				g.setPx(0);
			}
			if (g.getPy() >= 1500 - 75) {
				g.setV(0, -g.getVy() - 2);
				g.setPy(1500 - 75);
			}
			if (g.getPy() <= 0) {
				g.setV(0, -g.getVy() + 2);
				g.setPy(0);
			}
		}
		if (player.getPx() + 75 >= one.getPx()
				&& player.getPx() + 75 <= one.getPx() + 75
				&& player.getPy() <= one.getPy() + 75
				&& player.getPy() >= one.getPy()) {
			player.setV(-player.getVx() - 2, 0);
			// g.setPx(1100 - 75);
			one.setV(-one.getVx() + 2, 0);
			// g.setPx(0);
			if (player.getColor().equals(one.getColor())) {
				// g.setPx(10000);
				enemies.remove(one);
				player.addMoney(1);
			}
			else if (!player.getColor().equals(one.getColor())) {
				player.setPicture(heartdown);
				PlayGame.wilhelm.start();
			}
		}
		if (player.getPx() <= 200 + 100
				&& player.getPx() >= 200
				&& (player.getPy() + 75 >= 200 && player.getPy() + 75 <= 200 + 100)) {

			player.setV(-player.getVx() + 2, 0);

		}
		// for (Ghost g : enemies) {
		if (player.getPx() + 75 >= 200 && player.getPx() + 75 <= 200 + 100
				&& player.getPy() <= 200 + 100 && player.getPy() >= 200) {
			player.setV(-player.getVx() - 2, 0);

		}
		if (player.getPx() <= one.getPx() + 75
				&& player.getPx() >= one.getPx()
				&& (player.getPy() + 75 >= one.getPy() && player.getPy() + 75 <= one
						.getPy() + 75)) {
			one.setV(-one.getVx() - 2, 0);
			// g.setPx(1100 - 75);
			player.setV(-player.getVx() + 2, 0);
			// g.setPx(0);
			if (player.getColor().equals(one.getColor())) {
				// g.setPx(10000);
				enemies.remove(one);
				player.addMoney(2);
				PlayGame.mp.start();
			}
			else if (!player.getColor().equals(one.getColor())) {
				player.setPicture(heartdown);
				PlayGame.wilhelm.start();
			}
		}
		if (player.getPx() + 75 >= two.getPx()
				&& player.getPx() + 75 <= two.getPx() + 75
				&& player.getPy() <= two.getPy() + 75
				&& player.getPy() >= two.getPy()) {
			player.setV(-player.getVx() - 2, 0);
			// g.setPx(1100 - 75);
			two.setV(-two.getVx() + 2, 0);
			// g.setPx(0);
			if (player.getColor().equals(two.getColor())) {
				// g.setPx(10000);
				enemies.remove(two);
				player.addMoney(2);
				PlayGame.mp.start();
			}
			else if (!player.getColor().equals(one.getColor())) {
				player.setPicture(heartdown);
				PlayGame.wilhelm.start();
			}
		}
		if (player.getPx() <= two.getPx() + 75
				&& player.getPx() >= two.getPx()
				&& (player.getPy() + 75 >= two.getPy() && player.getPy() + 75 <= two
						.getPy() + 75)) {
			two.setV(-two.getVx() - 2, 0);
			// g.setPx(1100 - 75);
			player.setV(-player.getVx() + 2, 0);
			// g.setPx(0);
			if (player.getColor().equals(two.getColor())) {
				// g.setPx(10000);
				enemies.remove(two);
				player.addMoney(2);
				PlayGame.mp.start();
			}
			else if (!player.getColor().equals(one.getColor())) {
				player.setPicture(heartdown);
				PlayGame.wilhelm.start();
			}
		}
		if (player.getPx() + 75 >= three.getPx()
				&& player.getPx() + 75 <= three.getPx() + 75
				&& player.getPy() <= three.getPy() + 75
				&& player.getPy() >= three.getPy()) {
			player.setV(-player.getVx() - 2, 0);
			// g.setPx(1100 - 75);
			three.setV(-three.getVx() + 2, 0);
			// g.setPx(0);
			if (player.getColor().equals(three.getColor())) {
				// g.setPx(10000);
				enemies.remove(three);
				player.addMoney(2);
				PlayGame.mp.start();
			}
			else if (!player.getColor().equals(one.getColor())) {
				player.setPicture(heartdown);
				PlayGame.wilhelm.start();
			}
		}
		if (player.getPx() <= three.getPx() + 75
				&& player.getPx() >= three.getPx()
				&& (player.getPy() + 75 >= three.getPy() && player.getPy() + 75 <= three
						.getPy() + 75)) {
			three.setV(-three.getVx() - 2, 0);
			// g.setPx(1100 - 75);
			player.setV(-player.getVx() + 2, 0);
			// g.setPx(0);
			if (player.getColor().equals(three.getColor())) {
				// g.setPx(10000);
				enemies.remove(three);
				player.addMoney(2);
				PlayGame.mp.start();
			}
			else if (!player.getColor().equals(one.getColor())) {
				player.setPicture(heartdown);
				PlayGame.wilhelm.start();
			}
		}
		if (player.getPx() + 75 >= four.getPx()
				&& player.getPx() + 75 <= four.getPx() + 75
				&& player.getPy() <= four.getPy() + 75
				&& player.getPy() >= four.getPy()) {
			player.setV(-player.getVx() - 2, 0);
			// g.setPx(1100 - 75);
			four.setV(-four.getVx() + 2, 0);
			// g.setPx(0);
			if (player.getColor().equals(four.getColor())) {
				// g.setPx(10000);
				enemies.remove(four);
				player.addMoney(2);
				PlayGame.mp.start();
			}
			else if (!player.getColor().equals(one.getColor())) {
				player.setPicture(heartdown);
				PlayGame.wilhelm.start();
			}
		}
		if (player.getPx() <= four.getPx() + 75
				&& player.getPx() >= four.getPx()
				&& (player.getPy() + 75 >= four.getPy() && player.getPy() + 75 <= four
						.getPy() + 75)) {
			four.setV(-four.getVx() - 2, 0);
			// g.setPx(1100 - 75);
			player.setV(-player.getVx() + 2, 0);
			// g.setPx(0);
			if (player.getColor().equals(four.getColor())) {
				// g.setPx(10000);
				enemies.remove(four);
				player.addMoney(2);
				PlayGame.mp.start();
			}
			else if (!player.getColor().equals(one.getColor())) {
				player.setPicture(heartdown);
				PlayGame.wilhelm.start();
			}
		}
		// }
		for (Ghost g : enemies) {
			g.setV(g.getVx() * -0.03, 0);
			g.setV(0, g.getVy() * -0.03);
			g.move();
		}
		player.move();

	}

	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub

	}

	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		canvasthread = new CanvasThread(getHolder(), this);
		canvasthread.setRunning(true);
		canvasthread.start();

	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		boolean retry = true;
		canvasthread.setRunning(false);
		while (retry) {
			try {
				canvasthread.join();
				retry = false;
			} catch (InterruptedException e) {
				// we will try it again and again...
			}
		}

	}

}
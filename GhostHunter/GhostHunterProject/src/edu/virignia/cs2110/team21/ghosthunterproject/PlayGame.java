//T102-Team21
//Chandrika Rao,crr8ra 
//Brian Kelly, bck2z 
//Kyle Humphries, knh4vu 
//Michael Spoonhoward, mas4bs
//.wav files came from www.soundbible.com
//code assistance from stackoverflow.com
package edu.virignia.cs2110.team21.ghosthunterproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class PlayGame extends Activity implements OnClickListener {
	Button pause;
	Button left;
	Button up;
	Button down;
	Button right;
	Button item;
	static MediaPlayer mp;
	MediaPlayer mp1;
	static MediaPlayer wilhelm;
	public static int speed = 2;
	GameSurfaceView gameScreen;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game_space);
		
		mp= MediaPlayer.create(getApplicationContext(), R.raw.decapitation);
		mp1= MediaPlayer.create(getApplicationContext(), R.raw.creepylaugh);
		wilhelm= MediaPlayer.create(getApplicationContext(), R.raw.wilhelm);

		mp1.start();
		

		gameScreen = (GameSurfaceView) this.findViewById(R.id.game_screen);

		// Display display = getWindowManager().getDefaultDisplay();
		// Point size = new Point();
		// display.getSize(size);
		// width = size.x;
		// height = size.y;

		pause = (Button) findViewById(R.id.pausebutton);
		left = (Button) findViewById(R.id.leftbutton);
		up = (Button) findViewById(R.id.upbutton);
		down = (Button) findViewById(R.id.downbutton);
		right = (Button) findViewById(R.id.rightbutton);
		item = (Button) findViewById(R.id.itembutton);

		pause.setOnClickListener(this);
		left.setOnClickListener(this);
		up.setOnClickListener(this);
		down.setOnClickListener(this);
		right.setOnClickListener(this);
		item.setOnClickListener(this);

	}

	@Override
	protected void onResume() {
		super.onResume();

	}

	@Override
	protected void onPause() {

		super.onPause();

	}

	@Override
	public void onClick(View v) {

		// Perform action on click
		switch (v.getId()) {
		case R.id.pausebutton:
			startActivity(new Intent(
					"edu.virignia.cs2110.team21.ghosthunterproject.STOREMENU"));
			break;
		case R.id.leftbutton:

			gameScreen.player.setV(-speed, 0);

			break;
		case R.id.upbutton:
			// Context context1 = getApplicationContext();
			// CharSequence text1 = "Move's Character Up";
			// int duration1 = Toast.LENGTH_SHORT;
			// Toast toast1 = Toast.makeText(context1, text1, duration1);
			// toast1.show();
			gameScreen.player.setV(0, -speed);
			// ObjectStorage.upPressed = 1;

			break;
		case R.id.downbutton:
			// Context context2 = getApplicationContext();
			// CharSequence text2 = "Move's Character Down";
			// int duration2 = Toast.LENGTH_SHORT;
			// Toast toast2 = Toast.makeText(context2, text2, duration2);
			// toast2.show();
			gameScreen.player.setV(0, speed);
			// ObjectStorage.downPressed = 1;

			break;
		case R.id.rightbutton:
			// Context context3 = getApplicationContext();
			// CharSequence text3 = "Move's Character Right";
			// int duration3 = Toast.LENGTH_SHORT;
			// Toast toast3 = Toast.makeText(context3, text3, duration3);
			// toast3.show();
			gameScreen.player.setV(speed, 0);
			// ObjectStorage.rightPressed = 1;

			break;
		case R.id.itembutton:
			Context context4 = getApplicationContext();
			CharSequence text4 = "You've no item in your inventory";
			int duration4 = Toast.LENGTH_SHORT;
			Toast toast4 = Toast.makeText(context4, text4, duration4);
			if (gameScreen.player.hasBomb()) {
				// gameScreen.player.bomb();
			} else if (gameScreen.player.isHasSpeed()) {
				gameScreen.player.speedBoost();
			} else {
				toast4.show();
			}
			break;
		}

	}

}

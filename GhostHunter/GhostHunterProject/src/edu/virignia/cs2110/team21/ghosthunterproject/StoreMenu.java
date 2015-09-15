package edu.virignia.cs2110.team21.ghosthunterproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class StoreMenu extends Activity implements OnClickListener {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.store_menu);

		Button barrier = (Button) findViewById(R.id.barrier_button);
		Button bomb = (Button) findViewById(R.id.bomb_button);
		Button immortality = (Button) findViewById(R.id.immortality_button);
		Button speed = (Button) findViewById(R.id.speed_button);

		barrier.setOnClickListener(this);
		bomb.setOnClickListener(this);
		immortality.setOnClickListener(this);
		speed.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		// Perform action on click
		switch (v.getId()) {
		case R.id.barrier_button:
			Context context3 = getApplicationContext();
			CharSequence text3 = "Purchased a Barrier";
			int duration3 = Toast.LENGTH_SHORT;
			Toast toast3 = Toast.makeText(context3, text3, duration3);
			toast3.show();
			break;
		case R.id.bomb_button:
			Context context = getApplicationContext();
			CharSequence text = "Purchased a Bomb";
			int duration = Toast.LENGTH_SHORT;
			Toast toast = Toast.makeText(context, text, duration);
			if (GameSurfaceView.player.getMoney() >= 20) {
				GameSurfaceView.player.setHasBomb(true);
				toast.show();
			}
			break;
		case R.id.immortality_button:
			Context context1 = getApplicationContext();
			CharSequence text1 = "Purchased a Potion of Immortality";
			int duration1 = Toast.LENGTH_SHORT;
			Toast toast1 = Toast.makeText(context1, text1, duration1);
			if (GameSurfaceView.player.getMoney() >= 10) {
				GameSurfaceView.player
						.setLife(GameSurfaceView.player.getLife() + 1);
				toast1.show();
			}
			break;
		case R.id.speed_button:
			Context context2 = getApplicationContext();
			CharSequence text2 = "Purchased a Speed Boost";
			int duration2 = Toast.LENGTH_SHORT;
			Toast toast2 = Toast.makeText(context2, text2, duration2);
			if (GameSurfaceView.player.getMoney() >= 5) {
				GameSurfaceView.player.hasSpeed(true);
				toast2.show();
			}
			break;
		}

	}
}
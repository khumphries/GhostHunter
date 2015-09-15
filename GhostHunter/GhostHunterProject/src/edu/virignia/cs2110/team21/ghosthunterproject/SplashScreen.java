package edu.virignia.cs2110.team21.ghosthunterproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_screen);
		Thread logoTimer=new Thread(){
			@Override
			public void run(){
				try{
					sleep(2000);
					startActivity(new Intent("edu.virignia.cs2110.team21.ghosthunterproject.MAIN"));
				}catch(InterruptedException e){
					e.printStackTrace();
				}finally{
					finish();
				}
			}
		};
		logoTimer.start();
	}

}

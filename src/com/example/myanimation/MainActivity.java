package com.example.myanimation;

import android.R.integer;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;

public class MainActivity extends Activity {
	// 色定数 (ApiDemosより)
    private static final int RED = 0xffFF8080;
    private static final int BLUE = 0xff8080FF;
    private static final int CYAN = 0xff80ffff;
    private static final int GREEN = 0xff80ff80;

    // ボタン押下時
	public void buttonMethod(View button){
		// ObjectAnimatorによる色アニメーション
		ObjectAnimator colorAnim = ObjectAnimator.ofInt(button, "backgroundColor", RED, BLUE);
		colorAnim.setDuration(3000);
		colorAnim.setEvaluator(new ArgbEvaluator());
		colorAnim.setRepeatCount(ValueAnimator.INFINITE);
		colorAnim.setRepeatMode(ValueAnimator.REVERSE);
		colorAnim.start();
		
		// ObjectAnimatorによるアルファアニメーション
		ObjectAnimator alphaAnim = ObjectAnimator.ofFloat(button, "alpha", 1f, 0f);
		alphaAnim.setDuration(3000);
		alphaAnim.start();

		// ObjectAnimatorによるスケールアニメーション
		ObjectAnimator scaleAnimX = ObjectAnimator.ofFloat(button, "scaleX", 1f, 0f);
		scaleAnimX.setDuration(3000);
		scaleAnimX.start();
		ObjectAnimator scaleAnimY = ObjectAnimator.ofFloat(button, "scaleY", 1f, 0f);
		scaleAnimY.setDuration(3000);
		scaleAnimY.start();
		/* これはダメっぽい
		ObjectAnimator scaleAnim = ObjectAnimator.ofFloat(button, "scale", 1f, 0f);
		scaleAnim.setDuration(3000);
		scaleAnim.start();
		*/
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

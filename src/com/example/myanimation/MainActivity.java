package com.example.myanimation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;

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
		ObjectAnimator alphaAnim = ObjectAnimator.ofFloat(button, "alpha", 1f, 0.5f);
		alphaAnim.setDuration(3000);
		alphaAnim.setRepeatCount(ValueAnimator.INFINITE);
		alphaAnim.setRepeatMode(ValueAnimator.REVERSE);
		alphaAnim.start();

		// ObjectAnimatorによるスケールアニメーション
		ObjectAnimator scaleAnimX = ObjectAnimator.ofFloat(button, "scaleX", 1f, 0.5f);
		scaleAnimX.setDuration(3000);
		scaleAnimX.setRepeatCount(ValueAnimator.INFINITE);
		scaleAnimX.setRepeatMode(ValueAnimator.REVERSE);
		scaleAnimX.start();
		ObjectAnimator scaleAnimY = ObjectAnimator.ofFloat(button, "scaleY", 1f, 0.5f);
		scaleAnimY.setDuration(3000);
		scaleAnimY.setRepeatCount(ValueAnimator.INFINITE);
		scaleAnimY.setRepeatMode(ValueAnimator.REVERSE);
		scaleAnimY.start();
		
		// イベント
		final Button b = (Button)button;
		colorAnim.addListener(new AnimatorListener() {
			@Override
			public void onAnimationStart(Animator animation) {
				b.setText("START");
			}
			
			@Override
			public void onAnimationRepeat(Animator animation) {
				Integer i = (Integer)b.getTag();
				if(i == null){
					i = Integer.valueOf(0);
				}
				b.setText("REPEAT " + i);
				i++;
				b.setTag(i);
			}
			
			@Override
			public void onAnimationEnd(Animator animation) {
				b.setText("END");
			}
			
			@Override
			public void onAnimationCancel(Animator animation) {
				b.setText("CANCEL");
			}
		});
		colorAnim.addUpdateListener(new AnimatorUpdateListener() {
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				// TODO Auto-generated method stub
			}
		});
	}
	
	public void buttonMethod2(View button){
		// ObjectAnimatorによる色アニメーション
		ObjectAnimator colorAnim = ObjectAnimator.ofInt(button, "backgroundColor", RED, BLUE);
		colorAnim.setDuration(3000);
		colorAnim.setEvaluator(new ArgbEvaluator());
		colorAnim.setRepeatCount(ValueAnimator.INFINITE);
		colorAnim.setRepeatMode(ValueAnimator.REVERSE);
		colorAnim.start();
		
		// ObjectAnimatorによるスケールアニメーション
		ObjectAnimator scaleAnimX = ObjectAnimator.ofFloat(button, "scaleX", 1f, 0.5f);
		scaleAnimX.setDuration(1500);
		ObjectAnimator scaleAnimY = ObjectAnimator.ofFloat(button, "scaleY", 1f, 0f);
		scaleAnimY.setDuration(1500);
		
		// ObjectAnimatorによるアルファアニメーション
		ObjectAnimator alphaAnim = ObjectAnimator.ofFloat(button, "alpha", 1f, 0f);
		alphaAnim.setDuration(1500);

		// イベント
		final Button b = (Button)button;
		scaleAnimX.addListener(new AnimatorListener() {
			@Override
			public void onAnimationStart(Animator animation) {
				b.setText("START");
			}
			
			@Override
			public void onAnimationRepeat(Animator animation) {
				b.setText("REPEAT");
			}
			
			@Override
			public void onAnimationEnd(Animator animation) {
				b.setText("END");
			}
			
			@Override
			public void onAnimationCancel(Animator animation) {
				b.setText("CANCEL");
			}
		});
		
		// 順次実行
		AnimatorSet animSet = new AnimatorSet();
		animSet.play(alphaAnim).after(scaleAnimX);
		animSet.play(scaleAnimX);
		animSet.play(scaleAnimY).after(scaleAnimX);
		animSet.start();

	}
	
	public void buttonMethod3(View button){
		// ObjectAnimatorによるスケールアニメーション
		ObjectAnimator scaleAnimX = ObjectAnimator.ofFloat(button, "scaleX", 1f, 0f, 1f);
		scaleAnimX.setDuration(500);
		scaleAnimX.start();
	}

	public void buttonMethod4(View button){
		// ObjectAnimatorによるスケールアニメーション
		ObjectAnimator scaleAnimX = ObjectAnimator.ofFloat(button, "rotationX", 0f, 360f);
		scaleAnimX.setDuration(1000);
		scaleAnimX.setInterpolator(new LinearInterpolator());
		scaleAnimX.setRepeatCount(10);
		scaleAnimX.start();

		ObjectAnimator scaleAnimY = ObjectAnimator.ofFloat(button, "rotationY", 0f, 360f);
		scaleAnimY.setDuration(10000);
		scaleAnimY.setInterpolator(new LinearInterpolator());
		scaleAnimY.start();
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

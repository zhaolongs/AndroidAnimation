package com.studyyoun.androidanimationapplication;

import android.graphics.drawable.AnimationDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class AlphaAnimationActivity extends AppCompatActivity {
	
	private ImageView mImageView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_frame_animation);
		mImageView = findViewById(R.id.imageview);
		
		Button lButton = findViewById(R.id.bt_xml_start);
		
		lButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				start1();
			}
		});
		
		Button lJavaButton = findViewById(R.id.bt_java_start);
		
		lJavaButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				start2();
			}
		});
		
		

		
	}
	
	private void start2() {
		//创建透明动画
		Animation lAnimation = new AlphaAnimation(0.0f,1.0f);
		lAnimation.setDuration(3000);
		mImageView.startAnimation(lAnimation);
	}
	
	public void start1(){
		Animation lAnimation = AnimationUtils.loadAnimation(this,R.anim.alpha);
		
		mImageView.startAnimation(lAnimation);
		
	}
	
	
}
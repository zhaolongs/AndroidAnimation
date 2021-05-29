package com.studyyoun.androidanimationapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button lFrameButton = findViewById(R.id.frame_button);
		lFrameButton.setOnClickListener(this);
		Button lJavaFrameButton = findViewById(R.id.frame_java_button);
		lJavaFrameButton.setOnClickListener(this);
		
		Button lAlphaButton = findViewById(R.id.alpha_button);
		lAlphaButton.setOnClickListener(this);
		
		Button lTranslateButton = findViewById(R.id.translate_button);
		lTranslateButton.setOnClickListener(this);
		
		Button lScaleButton = findViewById(R.id.scale_button);
		lScaleButton.setOnClickListener(this);
		
		Button lRoateButton = findViewById(R.id.rote_button);
		lRoateButton.setOnClickListener(this);
		
		
		Button lTestButton = findViewById(R.id.test_button);
		lTestButton.setOnClickListener(this);
		
		Button lObjButton = findViewById(R.id.obj_button);
		lObjButton.setOnClickListener(this);
		
		
		Button lValueButton = findViewById(R.id.value_button);
		lValueButton.setOnClickListener(this);
		
		
		
	}
	
	
	@Override
	public void onClick(View v) {
		Intent lIntent = null;
		switch (v.getId()) {
			case R.id.frame_button:
				lIntent = new Intent(this, FrameAnimationActivity.class);
				break;
			case R.id.frame_java_button:
				lIntent = new Intent(this, FrameJavaAnimationActivity.class);
				break;
			case R.id.alpha_button:
				lIntent = new Intent(this, AlphaAnimationActivity.class);
				break;
			case R.id.translate_button:
				lIntent = new Intent(this, TranslateAnimationActivity.class);
				break;
			case R.id.scale_button:
				lIntent = new Intent(this, ScaleAnimationActivity.class);
				break;
			case R.id.rote_button:
				lIntent = new Intent(this, RoateAnimationActivity.class);
				break;
			case R.id.obj_button:
				lIntent = new Intent(this, ObjectAnimatorActivity.class);
				break;
			case R.id.value_button:
				lIntent = new Intent(this, ValueAnimatorActivity.class);
				break;
			
			
			case R.id.test_button:
				lIntent = new Intent(this, TestAnimationActivity.class);
				break;
			
		}
		if (lIntent != null) {
			startActivity(lIntent);
		}
		
	}
	
}
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
		}
		if (lIntent != null) {
			startActivity(lIntent);
		}
		
	}
	
}
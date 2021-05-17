package com.studyyoun.androidanimationapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ImageView lImageView = findViewById(R.id.imageview);
		//设置图片
		lImageView.setImageResource(R.drawable.loading);
		//动
		AnimationDrawable lAnimationDrawable = (AnimationDrawable) lImageView.getDrawable();
		
		lAnimationDrawable.start();
		
	}
}
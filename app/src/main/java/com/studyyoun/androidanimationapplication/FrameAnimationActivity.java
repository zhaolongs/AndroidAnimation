package com.studyyoun.androidanimationapplication;

import android.graphics.drawable.AnimationDrawable;
import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

/**
 * 帧动画  xml 方式实现
 * 各种开始动画效果的方式
 */
public class FrameAnimationActivity extends AppCompatActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_frame_animation);
		
		//start1();
		//start2();
		//start3();
		
		ImageView lImageView = findViewById(R.id.imageview);
		//设置图片
		lImageView.setImageResource(R.drawable.loading);
		//动
		mAnimationDrawable = (AnimationDrawable) lImageView.getDrawable();
	}
	
	public void start1() {
		ImageView lImageView = findViewById(R.id.imageview);
		//设置图片
		lImageView.setImageResource(R.drawable.loading);
		//动
		AnimationDrawable lAnimationDrawable = (AnimationDrawable) lImageView.getDrawable();
		
		lAnimationDrawable.start();
	}
	
	public void start2() {
		ImageView lImageView = findViewById(R.id.imageview);
		//设置图片
		lImageView.setImageResource(R.drawable.loading);
		//动
		AnimationDrawable lAnimationDrawable = (AnimationDrawable) lImageView.getDrawable();
		
		ViewTreeObserver.OnPreDrawListener lOnPreDrawListener = new ViewTreeObserver.OnPreDrawListener() {
			@Override
			public boolean onPreDraw() {
				lAnimationDrawable.start();
				return true; //注意此行返回的值
			}
		};
		
		//绑定视图观察者
		lImageView.getViewTreeObserver().addOnPreDrawListener(lOnPreDrawListener);
		
	}
	
	
	private AnimationDrawable mAnimationDrawable;
	
	public void start3() {
		ImageView lImageView = findViewById(R.id.imageview);
		//设置图片
		lImageView.setImageResource(R.drawable.loading);
		//动
		mAnimationDrawable = (AnimationDrawable) lImageView.getDrawable();
		
		RunAnim runAnim = new RunAnim();
		runAnim.execute("");
		
		
	}
	
	class RunAnim extends AsyncTask<String, String, String> {
		@Override
		protected String doInBackground(String... params) {
			if (!mAnimationDrawable.isRunning()) {
				mAnimationDrawable.stop();
				mAnimationDrawable.start();
			}
			return "";
		}
	}
	
	@Override
	public void onWindowFocusChanged(boolean hasFocus)
	{
		mAnimationDrawable.start();
		super.onWindowFocusChanged(hasFocus);
	}
}
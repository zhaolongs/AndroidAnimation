package com.studyyoun.androidanimationapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class FrameJavaAnimationActivity extends AppCompatActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_frame_animation);
		
		start1();
		
		ImageView lImageView = findViewById(R.id.imageview);
		loadResImage(lImageView);
	}
	
	public void start1() {
		ImageView lImageView = findViewById(R.id.imageview);
		//设置图片
		lImageView.setImageResource(R.drawable.loading);
		//动
		AnimationDrawable lAnimationDrawable = (AnimationDrawable) lImageView.getDrawable();
		
		lAnimationDrawable.start();
		
		CustomAnimationDrawable.animateRawManuallyFromXML(R.drawable.loading,
				lImageView, new Runnable() {
					
					@Override
					public void run() {
						// TODO onStart
						// 动画开始时回调
						Log.d("Android动画专题","帧动画开始执行");
						
					}
				}, new Runnable() {
					
					@Override
					public void run() {
						// TODO onComplete
						// 动画结束时回调
						Log.d("Android动画专题","帧动画执行结束");
						
					}
				});
	}
	
	private void loadResImage(ImageView imageView) {
		BitmapFactory.Options options = new BitmapFactory.Options();
		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.banner1, options);
		//Bitmap bitmap = BitmapFactory.decodeFile("mnt/sdcard/weixin.png", options);
		
		//获取图片占用的内存大小
		int lByteCount = bitmap.getByteCount();
		
		int lAllocationByteCount = bitmap.getAllocationByteCount();
		
		imageView.setImageBitmap(bitmap);
		Log.i("图片占用的内存大小", "图片占用的内存大小：ByteCount = " + lByteCount+ ":::bitmap：AllocationByteCount = " +lAllocationByteCount);
		Log.i("!!!!!!", "width:" + bitmap.getWidth() + ":::height:" + bitmap.getHeight());
		Log.i("!!!!!!", "inDensity:" + options.inDensity + ":::inTargetDensity:" + options.inTargetDensity);
		Log.i("!!!!!!", "imageview.width:" + imageView.getWidth() + ":::imageview.height:" + 	imageView.getHeight());
	}
	
}
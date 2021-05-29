package com.studyyoun.androidanimationapplication;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


/**
 * 旋转动画效果
 * 1 补间动画
 */
public class RoateAnimationActivity extends AppCompatActivity implements View.OnClickListener {
	
	private ImageView mImageView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_translate_animation);
		mImageView = findViewById(R.id.imageview);
		
		Button lButton = findViewById(R.id.bt_bujian_xml_start);
		Button lJavaButton = findViewById(R.id.bt_bujian_java_start);
		
		lJavaButton.setOnClickListener(this);
		lButton.setOnClickListener(this);
		
		
	}
	
	
	//补间动画方式 - xml
	public void start1() {
		//第一步 创建 xml
		
		//第二步 加载 xml
		
		
		//第三步开启动画
		
		
	}
	
	//补间动画方式 - java
	private void start2() {
		
		//第一步就是创建旋转动画
		//参数一 旋转开始角度
		//参数二 旋转结束角度
		//RotateAnimation lRotateAnimation = new RotateAnimation(0,360);
		//RotateAnimation lRotateAnimation = new RotateAnimation(0,360,100,100);
		
//		如果pivotXType=Animation.ABSOLUTE，像素；
//
//		如果pivotXType=Animation.RELATIVE_TO_PARENT，
//		如果pivotXType=Animation.RELATIVE_TO_SELF，
		RotateAnimation lRotateAnimation = new RotateAnimation(
				0,360,
				Animation.ABSOLUTE,100,
				Animation.ABSOLUTE,100);
		//第二步 设置属性
		lRotateAnimation.setDuration(2000);
		
		//第三步 开启动画
		mImageView.startAnimation(lRotateAnimation);
		
	
	}
	
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.bt_bujian_xml_start:
				start1();
				break;
			case R.id.bt_bujian_java_start:
				start2();
				break;
			
		}
	}
}
package com.studyyoun.androidanimationapplication;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


/**
 * 缩放动画效果
 * 1 补间动画
 */
public class TestAnimationActivity extends AppCompatActivity implements View.OnClickListener {
	
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
		Animation lAnimation = AnimationUtils.loadAnimation(this,R.anim.test);
		
		//第三步开启动画
		mImageView.startAnimation(lAnimation);
	
	}
	
	//补间动画方式 - java
	private void start2() {
		
		//创建旋转动画
//		RotateAnimation animation = new RotateAnimation(0, 359);
		//RotateAnimation animation = new RotateAnimation(0, 359,100,100);
		//Animation.ABSOLUTE 相对于自己的左上角
		RotateAnimation animation = new RotateAnimation(
				0, 359,
				Animation.RELATIVE_TO_PARENT,0.1f,
				Animation.RELATIVE_TO_PARENT,0.1f);
		animation.setDuration(20000);
		animation.setRepeatCount(1);//动画的反复次数
		animation.setFillAfter(true);//设置为true，动画转化结束后被应用
		mImageView.startAnimation(animation);//開始动画
	
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
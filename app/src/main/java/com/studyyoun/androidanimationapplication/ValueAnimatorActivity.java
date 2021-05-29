package com.studyyoun.androidanimationapplication;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


/**
 * 属性动画 ValueAnimator
 */
public class ValueAnimatorActivity extends AppCompatActivity implements View.OnClickListener {
	
	private ImageView mImageView;
	private Button mJavaButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_obj_animation);
		mImageView = findViewById(R.id.imageview);
		
		Button lButton = findViewById(R.id.bt_bujian_xml_start);
		mJavaButton = findViewById(R.id.bt_bujian_java_start);
		
		mJavaButton.setOnClickListener(this);
		lButton.setOnClickListener(this);
		
		
	}
	
	
	private void start2() {
		
		//实现一个旋转动画
		//第一步
		ValueAnimator lValueAnimator = ValueAnimator.ofFloat(0f,360f);
		
		//第二步 设置一些属性
		// 动画时间
		lValueAnimator.setDuration(2000);
		// 动画执行次数
		lValueAnimator.setRepeatCount(0);
		// 动画重复模式
		lValueAnimator.setRepeatMode(ValueAnimator.RESTART);
		
		//第三步设置刷新监听 更新属性
		lValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				
				//获取值
				float currentValue = (float) animation.getAnimatedValue();
				
				//为图片设置旋转
				mImageView.setRotation(currentValue);
				
			}
		});
		
		//第四步 开启动画
		lValueAnimator.start();
		

	
		
	}
	
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.bt_bujian_java_start:
				start2();
				break;
			
		}
	}
}

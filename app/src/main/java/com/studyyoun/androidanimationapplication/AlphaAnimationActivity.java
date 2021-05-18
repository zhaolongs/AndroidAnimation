package com.studyyoun.androidanimationapplication;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 透明渐变动画效果
 * 1 补间动画
 * 2 属性动画
 */
public class AlphaAnimationActivity extends AppCompatActivity implements View.OnClickListener {
	
	private ImageView mImageView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_frame_animation);
		mImageView = findViewById(R.id.imageview);
		
		Button lButton = findViewById(R.id.bt_bujian_xml_start);
		Button lJavaButton = findViewById(R.id.bt_bujian_java_start);
		
		Button lValueXmlButton = findViewById(R.id.bt_value_xml_start);
		Button lValueJavaButton = findViewById(R.id.bt_value_java_start);
		
		Button lObjXmlButton = findViewById(R.id.bt_obj_java_start);
		Button lObjJavaButton = findViewById(R.id.bt_obj_xml_start);
		
		lJavaButton.setOnClickListener(this);
		lButton.setOnClickListener(this);
		
		lValueXmlButton.setOnClickListener(this);
		lValueJavaButton.setOnClickListener(this);
		
		lObjXmlButton.setOnClickListener(this);
		lObjJavaButton.setOnClickListener(this);
		
		
		
	}

	
	//补间动画方式 - xml
	public void start1() {
		//加载动画xml
		Animation lAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha);
		//设置并开启动画
		mImageView.startAnimation(lAnimation);
		
	}
	//补间动画方式 - java
	private void start2() {
		//创建透明动画
		Animation lAnimation = new AlphaAnimation(0.0f, 1.0f);
		//设置动画时间
		lAnimation.setDuration(3000);
		//设置动画
		mImageView.startAnimation(lAnimation);
	}

	
	
	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.bt_bujian_xml_start:
				start1();
				break;
			case R.id.bt_bujian_java_start:
				start2();
				break;
			case R.id.bt_value_xml_start:
				start3();
				break;
			case R.id.bt_value_java_start:
				start4();
				break;
			case R.id.bt_obj_xml_start:
				start5();
				break;
			case R.id.bt_obj_java_start:
				start6();
				break;
		}
	}
	
	//属性动画方式 - ValueAnimator - xml
	public void start3() {
		//第二步 加载xml
		ValueAnimator lValueAnimator = (ValueAnimator) AnimatorInflater.loadAnimator(this,R.animator.alpha_animator);
	
		//第三步 设置 动画刷新监听
		lValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				//第四步 设置值更新
				
				//获取值
				int currentValue = (int) animation.getAnimatedValue();
				
				Log.d("属性动画","当前的值 是 "+currentValue);
				
				//更新透明度  0-255
				mImageView.setImageAlpha(currentValue);
			}
		});
		
		//第五步 开启动画
		lValueAnimator.start();
	}
	//属性动画方式 - ValueAnimator - java
	public void start4() {
		
		//第一步创建 实例
		ValueAnimator lValueAnimator = ValueAnimator.ofInt(0,255);
		//第二步 设置一些常用属性
		//动画时间
		lValueAnimator.setDuration(3000);
		//重复执行1次
		lValueAnimator.setRepeatCount(1);
		//重复方式
		lValueAnimator.setRepeatMode(ValueAnimator.REVERSE);
		//第三步绑定监听
		lValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				int currentValue = (int) animation.getAnimatedValue();
				mImageView.setImageAlpha(currentValue);
			}
		});
		
		//第五步 开启
		lValueAnimator.start();
	}
	//属性动画方式 - ObjectAnimator - xml
	public void start5() {
		//加载xml
		Animator lAnimator = AnimatorInflater.loadAnimator(this,R.animator.alpha_object_animator);
		//设置动画对象
		lAnimator.setTarget(mImageView);
		//开启动画
		lAnimator.start();
	
	
	}
	//属性动画方式 - ObjectAnimator - java
	public void start6() {
		
		//创建实例
		ObjectAnimator lObjectAnimator = ObjectAnimator.ofFloat(mImageView,"alpha",0.0f,1.0f);
		
		//一些属性设置
		lObjectAnimator.setDuration(2000);
		lObjectAnimator.setRepeatCount(1);
		lObjectAnimator.setRepeatMode(ValueAnimator.RESTART);
		
		//开启
		lObjectAnimator.start();
		
		
	
	}
}
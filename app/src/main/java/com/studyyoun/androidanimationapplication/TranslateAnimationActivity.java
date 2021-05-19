package com.studyyoun.androidanimationapplication;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


/**
 * 平移动画效果
 * 1 补间动画
 */
public class TranslateAnimationActivity extends AppCompatActivity implements View.OnClickListener {
	
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
		//第一步定义 xml
		//第二步加载 xml
		Animation lAnimation = AnimationUtils.loadAnimation(this,R.anim.translate);
		//第三步开启动画
		mImageView.startAnimation(lAnimation);
	}
	//补间动画方式 - java
	private void start2() {
		//第一步创建实例
		/*
		参数一 int fromXType x开始相对位置
				Animation.RELATIVE_TO_SELF 相对于组件自己
               Animation.RELATIVE_TO_PARENT 相对于父组件
		 参数二 float fromXValue x 开始位置 ,
		 参数三 int toXType x 结束位置参考类型
		 参数四 float toXValue, x 结束值
		  
          int fromYType, float fromYValue, int toYType, float toYValue
          
          Animation.RELATIVE_TO_SELF  值是当前View大小的百分比
          Animation.ABSOLUTE  值是像素
		 */
		TranslateAnimation lTranslateAnimation = new TranslateAnimation(
				Animation.RELATIVE_TO_SELF,0,
				//Animation.RELATIVE_TO_SELF,0.5f,//相当于是自身 宽 width 的一半
				//Animation.ABSOLUTE,100,//相当于是移动了 100像素
				Animation.RELATIVE_TO_PARENT,0.5f,//相当于是 父组件宽 width 的一半
				Animation.RELATIVE_TO_SELF,0,
				Animation.RELATIVE_TO_SELF,0
				);
		//第二步属性设置
		lTranslateAnimation.setDuration(2000);
		lTranslateAnimation.setFillAfter(true);
		//第三步开启动画
		mImageView.startAnimation(lTranslateAnimation);

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
			
		}
	}
}
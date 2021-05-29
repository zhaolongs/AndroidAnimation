package com.studyyoun.androidanimationapplication;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


/**
 * 属性动画 ObjectAnimator
 */
public class ObjectAnimatorActivity extends AppCompatActivity implements View.OnClickListener {
	
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
		
		//第一步创建实例
		// X轴平移 translationX ; y 轴平移 translationY
		// 透明度  alpha
		// 旋转 rotation 绕 Z 轴旋转 ； rotationX rotationY
		// 缩放 scaleX  scaleY
		ObjectAnimator lObjectAnimator = ObjectAnimator.ofFloat(mImageView,
				"scaleX",0.0f,1.0f);
		
		//第二步设置属性
		lObjectAnimator.setDuration(2000);
		
		//第三步开启动画
		//lObjectAnimator.start();
		
		
		//组合多个动画
		ObjectAnimator lObjectAnimator1 = ObjectAnimator.ofArgb(mJavaButton,"backgroundColor", Color.BLUE,Color.RED);
		ObjectAnimator lObjectAnimator2 = ObjectAnimator.ofFloat(mJavaButton,"scaleX",0.5f,1.0f);
		ObjectAnimator lObjectAnimator3 = ObjectAnimator.ofFloat(mJavaButton,"scaleY",0.2f,1.0f);
		ObjectAnimator lObjectAnimator4 = ObjectAnimator.ofFloat(mJavaButton,"translationX", 0,100f);
		
		AnimatorSet lAnimatorSet = new AnimatorSet();
		
		//四个动画一起执行
		//lAnimatorSet.playTogether(lObjectAnimator1,lObjectAnimator2,lObjectAnimator3,lObjectAnimator4);
		//先后执行
		//lAnimatorSet.playSequentially(lObjectAnimator1,lObjectAnimator2,lObjectAnimator3,lObjectAnimator4);
		
		lAnimatorSet.play(lObjectAnimator1).before(lObjectAnimator2).with(lObjectAnimator3);
		lAnimatorSet.setDuration(2000);
//		lAnimatorSet.start();
		
		//获取ViewPropertyAnimator
		ViewPropertyAnimator lAnimator = mImageView.animate();
		
		lAnimator.setDuration(2000);
		//线性动画插值器
		lAnimator.setInterpolator(new LinearInterpolator());
		//从0 向右移动 200 （相对View自己）
		lAnimator.translationX(200f);
//		//相对于上一次的位置移动 （初始是0）
//		lAnimator.translationXBy(300f);
////
//		//移动到指定位置
//		lAnimator.x(200f);
//		//在当前位置 的基础上增加
//		lAnimator.xBy(200f);
		
		lAnimator.setListener(new Animator.AnimatorListener() {
			@Override
			public void onAnimationStart(Animator animation) {
				Log.d("动画","动画开始");
			}
			
			@Override
			public void onAnimationEnd(Animator animation) {
				Log.d("动画","动画结束");
			}
			
			@Override
			public void onAnimationCancel(Animator animation) {
			
			}
			
			@Override
			public void onAnimationRepeat(Animator animation) {
			
			}
		});
		
		lAnimator.setUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				Log.d("动画","动画执行中"+animation.getAnimatedValue());
			}
		});
		
		lAnimator.start();
		
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

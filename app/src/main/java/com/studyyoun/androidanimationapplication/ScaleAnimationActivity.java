package com.studyyoun.androidanimationapplication;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


/**
 * 缩放动画效果
 * 1 补间动画
 */
public class ScaleAnimationActivity extends AppCompatActivity implements View.OnClickListener {
	
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
		Animation lAnimation = AnimationUtils.loadAnimation(this,R.anim.scale);
		
		//第三步开启动画
		mImageView.startAnimation(lAnimation);
	
	}
	
	//补间动画方式 - java
	private void start2() {
		
		//第一步 创建实例
		/**
		 * @param fromX 参数一 x 方向开始的位置 1.0f 为执行动画的 View 的宽度 width
		 * @param toX 参数二 x 方向结束的位置
		 */
		ScaleAnimation lScaleAnimation1 = new ScaleAnimation(0,1.0f,0,1.0f);
		/**
		 * @param pivotX 缩放中心 x
		 * @param pivotY 缩放中心 y
		 */
		ScaleAnimation lScaleAnimation2 = new ScaleAnimation(0,1.0f,0,1.0f,mImageView.getWidth()*0.5f,mImageView.getHeight()*0.5f);
		
		//相对中心位置
		
		/**
		 * @param pivotX 缩放中心 x
		 * @param pivotYType 缩放中心 y 相对的位置
		 *                   Animation.RELATIVE_TO_SELF 相对于View自身
		 *                   Animation.RELATIVE_TO_PARENT 相对于父View
		 *                   Animation.ABSOLUTE 相对于当前位置
		 *
		 * @param pivotY 缩放中心 y
		 */
		ScaleAnimation lScaleAnimation3 = new ScaleAnimation(
				0,1.0f,//x 方向的缩放空间
				0,1.0f,//y 方向的缩放空间
				Animation.RELATIVE_TO_SELF,mImageView.getWidth()*0.5f,//缩放中心
				Animation.RELATIVE_TO_SELF,mImageView.getHeight()*0.5f);
		
		//第二步 设置属性
		lScaleAnimation2.setDuration(1000);
		//第三步 开启动画
		mImageView.startAnimation(lScaleAnimation2);
	
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
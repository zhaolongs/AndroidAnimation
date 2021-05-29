package com.studyyoun.androidanimationapplication;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;


/**
 * 缩放动画效果
 * 1 补间动画
 */
public class TestAnimationActivity extends AppCompatActivity implements View.OnClickListener {
	
	private ImageView mImageView;
	private Button mJavaButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test_animation);
		mImageView = findViewById(R.id.imageview);
		
		Button lButton = findViewById(R.id.bt_bujian_xml_start);
		mJavaButton = findViewById(R.id.bt_bujian_java_start);
		
		mJavaButton.setOnClickListener(this);
		lButton.setOnClickListener(this);
		
		
	}
	
	
	public void start1() {
		//第一步 创建 xml
		
		
	}
	
	//补间动画方式 - java
	private void start2() {
//		objectEvaluator();
		//ballEvaluator();
		// 步骤1：设置动画属性的初始值 & 结束值
		// 0xffffff00, 0xff0000ff
		// 100 500
//		ValueAnimator anim = ValueAnimator.ofInt(0xffffffff,0xff00ffff);
		ValueAnimator anim = ValueAnimator.ofFloat(0,360);
		// ofInt（）作用有两个
		// 1. 创建动画实例
		// 2. 将传入的多个Int参数进行平滑过渡:此处传入0和1,表示将值从0平滑过渡到1
		// 如果传入了3个Int参数 a,b,c ,则是先从a平滑过渡到b,再从b平滑过渡到C，以此类推
		// ValueAnimator.ofInt()内置了整型估值器,直接采用默认的.不需要设置，即默认设置了如何从初始值 过渡到 结束值
		// 关于自定义插值器我将在下节进行讲解
		// 下面看看ofInt()的源码分析 ->>关注1
		
		// 步骤2：设置动画的播放各种属性
		anim.setDuration(12000);
		// 设置动画运行的时长
		anim.setStartDelay(100);
		// 设置动画延迟播放时间
		anim.setRepeatCount(0);
		// 设置动画重复播放次数 = 重放次数+1
		// 动画播放次数 = infinite时,动画无限重复
		
		anim.setRepeatMode(ValueAnimator.RESTART);
		// 设置重复播放动画模式
		// ValueAnimator.RESTART(默认):正序重放
		// ValueAnimator.REVERSE:倒序回放

// 步骤3：将改变的值手动赋值给对象的属性值：通过动画的更新监听器
		// 设置 值的更新监听器
		// 即：值每次改变、变化一次,该方法就会被调用一次
		anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				
//				int currentValue = (Integer) animation.getAnimatedValue();
//				// 获得改变后的值
//
//				System.out.println(currentValue);
//				// 输出改变后的值
//
//				// 步骤4：将改变后的值赋给对象的属性值，下面会详细说明
////				mImageView.getLayoutParams().width = currentValue;
//				mJavaButton.setBackgroundColor(currentValue);
//				// 步骤5：刷新视图，即重新绘制，从而实现动画效果
//				mJavaButton.requestLayout();
				
				
				float currentValue = (Float) animation.getAnimatedValue();
				
//				mJavaButton.setAlpha(currentValue);
//				mJavaButton.setRotationX(currentValue);
				mJavaButton.setRotation(currentValue);
				mJavaButton.setRotationY(currentValue);
				
			}
		});
		
		anim.start();
		// 启动动画
	}
	
	private void ballEvaluator() {
		LinearLayout.LayoutParams lLayoutParams = (LinearLayout.LayoutParams) mJavaButton.getLayoutParams();
		int lLeft = mJavaButton.getLeft();
		int lTop = mJavaButton.getTop();
		//定义了球的位置
		ValueAnimator valueAnimator = ValueAnimator.ofObject(new FallingBallEvaluator(), new Point(lLeft, lTop), new Point(lLeft, 0));
		valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				//获取当前动画的值==>获取到当前x 和 y 位置
				Point curValue = (Point) animation.getAnimatedValue();
				//将球移动到指定位置
				mJavaButton.layout(curValue.x, curValue.y, curValue.x + mJavaButton.getWidth(), curValue.y + mJavaButton.getHeight());
			}
		});
		// 弹跳插值器，模拟了控件自由落地后回弹的效果
		valueAnimator.setInterpolator(new BounceInterpolator());
		valueAnimator.setDuration(3000);
		valueAnimator.start();
	}
	private void objectEvaluator() {
		//我们要实现的动画效果是从字母A到字母Z
		ValueAnimator valueAnimator = ValueAnimator.ofObject(new CharEvaluator(), 'A', 'Z');
		
		valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				//获取当前动画的值==>获取到当前字母
				char curValue = (char) animation.getAnimatedValue();
				mJavaButton.setText(String.valueOf(curValue));
			}
		});
		//动画匀速==>线性变化
		valueAnimator.setInterpolator(new LinearInterpolator());
		valueAnimator.setDuration(5000);
		valueAnimator.start();
	}
	// 关注1：ofInt（）源码分析
	public static ValueAnimator ofInt(int... values) {
		// 允许传入一个或多个Int参数
		// 1. 输入一个的情况（如a）：从0过渡到a；
		// 2. 输入多个的情况（如a，b，c）：先从a平滑过渡到b，再从b平滑过渡到C
		
		ValueAnimator anim = new ValueAnimator();
		// 创建动画对象
		anim.setIntValues(values);
		// 将传入的值赋值给动画对象
		return anim;
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

/**
 * 蹦蹦求 从空中落到地面上
 */
class FallingBallEvaluator implements TypeEvaluator<Point> {
	
	//蹦蹦求返回值
	private Point mPoint = new Point();
	
	@Override
	public Point evaluate(float fraction, Point startValue, Point endValue) {
		int x = (int) (startValue.x + (fraction * (endValue.x - startValue.x)));
		mPoint.x = x;
		int y = (int) (startValue.y + (fraction * (endValue.y - startValue.y)));
		mPoint.y = y;
		return mPoint;
	}
	
}

/**
 * 动画求值器从字母A到字母Z
 */
 class CharEvaluator implements TypeEvaluator<Character> {
	
	@Override
	public Character evaluate(float fraction, Character startValue, Character endValue) {
		int startInt = startValue; //A = 65
		int endInt = endValue;     //Z = 90
		Log.d("动画","startInt "+startInt+" endInt "+endInt+"  fraction "+fraction);
		return (char) (startInt + fraction * (endInt - startInt)); //当前字符
	}
	
}
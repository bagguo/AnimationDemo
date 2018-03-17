package com.syc.a16_tweenanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView ivHouzi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivHouzi = (ImageView) findViewById(R.id.iv_houzi);
    }

    /**
     * 方法直接被button onclic
     * k调用
     * @param view
     */
    //透明度动画
    public void alpha(View view) {
        //透明度动画对象
        AlphaAnimation aa = new AlphaAnimation(0, 0.5f);
        //设置动画的持续时间.
        aa.setDuration(2000);
        //设置动画的重复次数
        aa.setRepeatCount(2);
        //设置重复模式
        aa.setRepeatMode(Animation.RESTART);
        //保持结束时的状态
        aa.setFillAfter(true);
        //开始动画
        ivHouzi.startAnimation(aa);
    }

    //平移动画
    public void translate(View view) {
        //坐标系有两种:①.屏幕坐标系:(0,0);②.View的坐标系:控件自身的坐标系.
        //TranslateAnimation ta=new TranslateAnimation(0,-300,0,300);
        //from:RELATIVE_TO_SELF,0---->0
        //to:RELATIVE_TO_SELF,2--->0+2*控件的width
        TranslateAnimation ta=new TranslateAnimation(Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,2,Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,0);
        ta.setDuration(3000);
        ta.setRepeatCount(2);
        ta.setRepeatMode(Animation.REVERSE);
        ivHouzi.startAnimation(ta);
    }

    //缩放动画
    public void scale(View view) {
        //ScaleAnimation sa=new ScaleAnimation(1,2,1,2);
        ScaleAnimation sa=new ScaleAnimation(Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,2,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,3);
        sa.setDuration(3000);
        sa.setRepeatCount(2);
        sa.setFillAfter(true);
        ivHouzi.startAnimation(sa);
    }

    //旋转动画
    public void rotate(View view) {
        //RotateAnimation ra=new RotateAnimation(0,180);
        RotateAnimation ra=new RotateAnimation(0,360,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        ra.setDuration(3000);
        ra.setRepeatCount(2);
        ra.setFillAfter(true);
        ivHouzi.startAnimation(ra);
    }

    //动画集合
    public void set(View view) {
        AnimationSet set = new AnimationSet(true);
        AlphaAnimation aa = new AlphaAnimation(0, 0.5f);
        TranslateAnimation ta=new TranslateAnimation(Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,2,Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,0);
        RotateAnimation ra=new RotateAnimation(0,360,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        ScaleAnimation sa=new ScaleAnimation(Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,2,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,3);

        //添加动画
        set.addAnimation(aa);
        set.addAnimation(ta);
        set.addAnimation(ra);
        set.addAnimation(sa);

        set.setDuration(3000);
        set.setRepeatCount(2);
        ivHouzi.startAnimation(set);
    }

}

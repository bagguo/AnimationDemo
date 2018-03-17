package com.syc.a16_propertyanimation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView ivHouzi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivHouzi = (ImageView) findViewById(R.id.iv_houzi);

        ivHouzi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "大圣在此!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void alpha(View view) {
        //alpha
        ObjectAnimator oa = ObjectAnimator.ofFloat(ivHouzi, "alpha", 0, 0.5f, 0.8f, 1f, 0.5f, 0.2f);
        oa.setDuration(3000);
        oa.start();
    }

    public void translate(View view) {
        //translationX
        ObjectAnimator oaX = ObjectAnimator.ofFloat(ivHouzi, "translationX", 0, 200, 400, 600);
        //ObjectAnimator oaY = ObjectAnimator.ofFloat(ivHouzi, "translationY", 0, 300, -400, 600);
        oaX.setDuration(3000);
        oaX.setRepeatCount(2);
        oaX.setRepeatMode(ObjectAnimator.RESTART);
        //oaY.setDuration(3000);
        //oaY.setRepeatCount(2);
        //oaY.setRepeatMode(ObjectAnimator.RESTART);
        //开始
        oaX.start();
        //oaY.start();
        //oa.cancel();
        //oa.resume();

        //        oaX.addListener(new Animator.AnimatorListener() {
        //            @Override
        //            public void onAnimationStart(Animator animation) {
        //
        //            }
        //
        //            @Override
        //            public void onAnimationEnd(Animator animation) {
        //
        //            }
        //
        //            @Override
        //            public void onAnimationCancel(Animator animation) {
        //
        //            }
        //
        //            @Override
        //            public void onAnimationRepeat(Animator animation) {
        //
        //            }
        //        });

        //ObjectAnimator--->ValueAnimator--->Animator
        //ObjectAnimator:提供了具体的动画效果;
        //ValueAnimator:并没有提供具体的动画效果,只是用来产生一些数值的."数值生成器"
        //添加动画的监听器
        oaX.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                ValueAnimator animator = (ValueAnimator) animation;
                float animatedValue = (float) animator.getAnimatedValue();
                Log.i("TAG", "value=" + animatedValue);
            }
        });

    }

    public void rotate(View view) {
        //rotationX
        ObjectAnimator oaX = ObjectAnimator.ofFloat(ivHouzi, "rotationX", 0, 360);
        ObjectAnimator oaY = ObjectAnimator.ofFloat(ivHouzi, "rotationY", 0, 360);
        oaX.setDuration(3000);
        oaX.setRepeatCount(2);
        oaX.start();
        oaY.setDuration(3000);
        oaY.setRepeatCount(2);
        oaY.start();
    }

    public void scale(View view) {
        //scaleX
        ObjectAnimator oaX = ObjectAnimator.ofFloat(ivHouzi, "scaleX", 1, 2, 1, 3, 1, 4);
        ObjectAnimator oaY = ObjectAnimator.ofFloat(ivHouzi, "scaleY", 1, 2, 1, 3, 1, 4);
        oaX.setDuration(3000);
        oaX.setRepeatCount(2);
        oaX.start();
        oaY.setDuration(3000);
        oaY.setRepeatCount(2);
        oaY.start();
    }

    public void set(View view) {
        //Animator:是所有属性动画的父类
        AnimatorSet set = new AnimatorSet();
        ObjectAnimator alphaOa = ObjectAnimator.ofFloat(ivHouzi, "alpha", 0, 0.5f, 0.8f, 1f, 0.5f, 0.2f);
        ObjectAnimator transOa = ObjectAnimator.ofFloat(ivHouzi, "translationX", 0, 200, 400, 600);
        ObjectAnimator rotateOa = ObjectAnimator.ofFloat(ivHouzi, "rotationY", 0, 360);
        ObjectAnimator scaleOa = ObjectAnimator.ofFloat(ivHouzi, "scaleX", 1, 2, 1, 3, 1, 4);

        //属性动画,实现动画集合方式有几种:
        //①.play(alphaOa).with(transOa).after(rotateOa)
        //set.play(alphaOa).with(transOa).after(rotateOa).after(scaleOa);

        //②.播放一序列的动画
        //set.playSequentially(alphaOa,transOa,rotateOa,scaleOa);

        //③. set.playSequentially(animtors);添加一个集合
        //List<Animator> animtors=new ArrayList<>();
        //        animtors.add(alphaOa);
        //        animtors.add(transOa);
        //        animtors.add(rotateOa);
        //        animtors.add(scaleOa);
        //        set.playSequentially(animtors);

        //④.playTogether();
        set.playTogether(alphaOa, transOa, rotateOa, scaleOa);

        set.setDuration(4000);
        set.start();
    }
}

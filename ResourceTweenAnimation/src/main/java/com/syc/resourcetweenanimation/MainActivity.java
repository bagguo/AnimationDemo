package com.syc.resourcetweenanimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView ivHouzi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivHouzi = (ImageView) findViewById(R.id.iv_houzi);
    }

    //透明度动画
    public void alpha(View view) {
        //引入动画资源
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha_anim);
        //开始动画
        ivHouzi.startAnimation(animation);
    }

    //平移动画
    public void translate(View view) {
        //引入动画资源
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.trans_anim);
        //开始动画
        ivHouzi.startAnimation(animation);
    }

    //缩放动画
    public void scale(View view) {
        //引入动画资源
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale_anim);
        //开始动画
        ivHouzi.startAnimation(animation);
    }

    //旋转动画
    public void rotate(View view) {
        //引入动画资源
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);
        //开始动画
        ivHouzi.startAnimation(animation);
    }

    //动画集合
    public void set(View view) {
        //引入动画资源
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.set_anim);
        //开始动画
        ivHouzi.startAnimation(animation);
    }

}

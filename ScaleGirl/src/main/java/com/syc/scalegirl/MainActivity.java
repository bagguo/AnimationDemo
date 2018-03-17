package com.syc.scalegirl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    //缩小动画
    private ScaleAnimation sa1 = new ScaleAnimation(1, 0, 1, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
    //放大动画
    private ScaleAnimation sa2 = new ScaleAnimation(0, 1, 1, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

    private ImageView ivA, ivB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout rlContainer = (RelativeLayout) findViewById(R.id.activity_main);
        ivA = (ImageView) findViewById(R.id.iv_a);
        ivB = (ImageView) findViewById(R.id.iv_b);

        init();

        rlContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ivA.getVisibility() == View.VISIBLE) {
                    ivA.startAnimation(sa1);
                } else {
                    ivB.startAnimation(sa1);
                }
            }
        });
    }

    private void init() {
        sa1.setDuration(2000);
        sa2.setDuration(2000);

        showImageA();

        //动画的监听方法
        sa1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (ivA.getVisibility() == View.VISIBLE) {
                    ivA.setAnimation(null);
                    showImageB();
                    ivB.startAnimation(sa2);
                } else {
                    ivB.setAnimation(null);
                    showImageA();
                    ivA.startAnimation(sa2);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    private void showImageA() {
        ivA.setVisibility(View.VISIBLE);
        ivB.setVisibility(View.GONE);
    }

    private void showImageB() {
        ivB.setVisibility(View.VISIBLE);
        ivA.setVisibility(View.GONE);
    }
}

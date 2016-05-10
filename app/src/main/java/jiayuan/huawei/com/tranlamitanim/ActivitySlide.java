package jiayuan.huawei.com.tranlamitanim;

import android.animation.Animator;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

public class ActivitySlide extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide);
        setupWindowAnimations();

//        getWindow().getDecorView().addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
//            @Override
//            public void onViewAttachedToWindow(View v) {
//
//            }
//
//            @Override
//            public void onViewDetachedFromWindow(View v) {
//
//            }
//        });

    }

    private void setupWindowAnimations() {

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            // Re-enter transition is executed when returning to this activity
            Slide slideTransition = new Slide();//滑出，fade 也可以，什么效果自己上
            slideTransition.setSlideEdge(Gravity.LEFT);//滑出的方向
            slideTransition.setInterpolator(new DecelerateInterpolator());
            slideTransition.setDuration(500);//动画持续时间
//            getWindow().setReenterTransition(slideTransition);//
            getWindow().setEnterTransition(slideTransition);
            getWindow().setExitTransition(slideTransition);
        }

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
//            finishAfterTransition();
//        }
//        close();
    }


    private void close(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            final View view = getWindow().getDecorView();
            Animator anim = ViewAnimationUtils.createCircularReveal(getWindow().getDecorView(),
                    view.getWidth() / 2, view.getHeight() / 2, view.getWidth(), 0);

            anim.setDuration(600);
            anim.setInterpolator(new AccelerateInterpolator());
            anim.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    view.setVisibility(View.INVISIBLE);
                    finish();
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
            anim.start();
        }


    }

}

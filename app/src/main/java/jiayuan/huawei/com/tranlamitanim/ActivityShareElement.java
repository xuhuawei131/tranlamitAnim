package jiayuan.huawei.com.tranlamitanim;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.view.Gravity;
import android.view.animation.DecelerateInterpolator;

public class ActivityShareElement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.share_element);
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
//            getWindow().setExitTransition(slideTransition);

        }

    }


    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            finishAfterTransition();
        }
    }



}

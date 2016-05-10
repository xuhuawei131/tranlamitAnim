package jiayuan.huawei.com.tranlamitanim;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.view.animation.DecelerateInterpolator;

public class ActivityExplode extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.explode);
        setupWindowAnimations();
    }

    private void setupWindowAnimations() {

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Explode explodeIn = new Explode();
            explodeIn.setDuration(500);
            explodeIn.setInterpolator(new DecelerateInterpolator());
            getWindow().setEnterTransition(explodeIn);
            getWindow().setExitTransition(explodeIn);
        }

    }

    @Override
    public void onBackPressed() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            finishAfterTransition();
        }
    }
}

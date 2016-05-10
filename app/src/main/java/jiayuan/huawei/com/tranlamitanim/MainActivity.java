package jiayuan.huawei.com.tranlamitanim;

import android.animation.Animator;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements View.OnClickListener{
    private Button btnSlide;
    private Button btnExplode;
    private Button btnShareElement;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSlide = (Button) findViewById(R.id.slide);
        btnExplode = (Button) findViewById(R.id.explode);
        btnShareElement = (Button) findViewById(R.id.share_element);
        imageView = (ImageView) findViewById(R.id.img);


        btnSlide.setOnClickListener(this);
        btnExplode.setOnClickListener(this);
        btnShareElement.setOnClickListener(this);
        imageView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.slide:
                startActivity(ActivitySlide.class,null);
//                animat(btnSlide);
                break;
            case R.id.explode:
                startActivity(ActivityExplode.class,null);
                break;
            case R.id.share_element:
            case R.id.img:
                Pair<View, String>[] pairs = new Pair[]{Pair.create(v,"share")};
                startActivity(ActivityShareElement.class,pairs);
                break;

        }
    }


    private void startActivity(Class target, Pair<View, String>[] pairs) {
        Intent intent = new Intent(MainActivity.this, target);
        ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this, pairs);
        //可以指定共享元素，这里为null
        if(pairs == null||pairs.length>0){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN
                    && Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
               startActivity(intent, transitionActivityOptions.toBundle());
            }else{
                startActivity(intent);
            }
        }else{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                startActivity(intent, transitionActivityOptions.toBundle());
            }else{
               startActivity(intent);
            }
        }
    }


    private void animat(View view ){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Animator anim = ViewAnimationUtils.createCircularReveal(view,
                    view.getWidth() / 2, view.getHeight() / 2,  0,view.getWidth());

            anim.setDuration(1500);
            anim.setInterpolator(new DecelerateInterpolator());

            anim.start();
        }


    }

}

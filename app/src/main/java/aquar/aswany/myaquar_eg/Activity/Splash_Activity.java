package aquar.aswany.myaquar_eg.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.androidnetworking.model.Progress;

import aquar.aswany.myaquar_eg.R;

public class Splash_Activity extends AppCompatActivity {
    private ImageView logo;
    private ProgressBar pro;
    private LinearLayout ll;
    private static int splashTimeOut = 3000;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        pro = (ProgressBar) findViewById(R.id.prog);
        logo = (ImageView) findViewById(R.id.logo);
        ll = (LinearLayout) findViewById(R.id.lina_id);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Splash_Activity.this, Home_Activity.class);
                startActivity(i);
                finish();
            }
        }, splashTimeOut);

        Animation myanim3 = AnimationUtils.loadAnimation(this, R.anim.lina_anemation);
        ll.startAnimation(myanim3);

        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.mysplashanimation);
        logo.startAnimation(myanim);

        Animation myanim2 = AnimationUtils.loadAnimation(this, R.anim.mysplashanimation);
        pro.startAnimation(myanim2);



    }


}




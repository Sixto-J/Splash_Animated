package com.example.splash_animated;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class SplashActivity extends AppCompatActivity {

    public static final String GAME_PREFERENCES = "GamePrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.splash);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setTitle(R.string.app_name);
        setSupportActionBar(myToolbar);

        //parte no necesaria
        TextView logo1 = (TextView) findViewById(R.id.TextViewTopTitle);
        Animation fade1 = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        logo1.startAnimation(fade1);

        // Animacion heredada para todos los elementos child de TableRow
        Animation spinin = AnimationUtils.loadAnimation(this, R.anim.custom_anim);
        LayoutAnimationController controller =
                new LayoutAnimationController(spinin);
        TableLayout table = (TableLayout) findViewById(R.id.TableLayout01);
        for (int i = 0; i < table.getChildCount(); i++) {
            TableRow row = (TableRow) table.getChildAt(i);
            row.setLayoutAnimation(controller);
        }

        Animation fade2 = AnimationUtils.loadAnimation(this, R.anim.fade_in2);
        // Fade in bottom title after a built-in delay.
        TextView logo2 = (TextView) findViewById(R.id.TextViewBottomTitle);
        logo2.startAnimation(fade2);


        fade2.setAnimationListener(new Animation.AnimationListener() {

            public void onAnimationEnd(Animation animation) {

                startActivity(new Intent(SplashActivity.this, MenuActivity.class));

                SplashActivity.this.finish();
            }

            @Override
            public void onAnimationStart(Animation animation) {

            }


            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


    }




    @Override
    protected void onPause() {
        super.onPause();

        TextView logo1 = (TextView) findViewById(R.id.TextViewTopTitle);
        logo1.clearAnimation();

        TextView logo2 = (TextView) findViewById(R.id.TextViewBottomTitle);
        logo2.clearAnimation();

        TableLayout table = (TableLayout) findViewById(R.id.TableLayout01);
        for (int i = 0; i < table.getChildCount(); i++) {
            TableRow row = (TableRow) table.getChildAt(i);
            row.clearAnimation();
        }

    }

    @Override
    protected void onResume() {
        super.onResume();

        // Start animating at the beginning so we get the full splash screen experience
        //startAnimating();
    }
}
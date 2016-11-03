package com.dofun.myactivitydemo;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class makeScaleUpAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_scale_up_animation);
        final Button btn_open = (Button) findViewById(R.id.btn_open);
        btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                launch(btn_open);
            }
        });

    }


    private void launch(View view) { ActivityOptionsCompat compat =
            ActivityOptionsCompat.makeScaleUpAnimation(view, view.getWidth() / 2, view.getHeight() / 2, 0, 0);
        ActivityCompat.startActivity(this, new Intent(this, MainActivity.class), compat.toBundle());
    }






}

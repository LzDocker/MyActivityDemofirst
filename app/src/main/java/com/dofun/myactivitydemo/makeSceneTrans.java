package com.dofun.myactivitydemo;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class makeSceneTrans extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_scene_trans);


        imageView = (ImageView) findViewById(R.id.image);
        textView = (TextView) findViewById(R.id.text);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launch2();
            }
        });
    }
    private void launch2() {
        Pair<View, String> imagePair = Pair.create((View) imageView, getString(R.string.image));
        Pair<View, String> textPair = Pair.create((View) textView, getString(R.string.name));

        ActivityOptionsCompat compat = ActivityOptionsCompat
                .makeSceneTransitionAnimation(this, imagePair, textPair);
        ActivityCompat.startActivity(this, new Intent(this, MainActivity.class),
                compat.toBundle());
    }
}

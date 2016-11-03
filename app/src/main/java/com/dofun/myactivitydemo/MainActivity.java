package com.dofun.myactivitydemo;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_open, btn_open2, btn_open3, btn_open4, btn_change1, btn_change2;
    ImageView imageView;
    TextView textView;
    ProgressBar pb1, pb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CircularAnim.init(700, 500, R.color.colorPrimary);

        btn_open = (Button) findViewById(R.id.btn_open);
        btn_open2 = (Button) findViewById(R.id.btn_open2);
        btn_open.setOnClickListener(this);
        btn_open2.setOnClickListener(this);


        imageView = (ImageView) findViewById(R.id.image);
        textView = (TextView) findViewById(R.id.text);
        imageView.setOnClickListener(this);

        btn_open3 = (Button) findViewById(R.id.btn_open3);
        btn_open4 = (Button) findViewById(R.id.btn_open4);
        btn_change1 = (Button) findViewById(R.id.btn_change1);
        btn_change2 = (Button) findViewById(R.id.btn_change2);

        btn_open3.setOnClickListener(this);
        btn_open4.setOnClickListener(this);
        btn_change1.setOnClickListener(this);
        btn_change2.setOnClickListener(this);


        pb1 = (ProgressBar) findViewById(R.id.pb1);
        pb2 = (ProgressBar) findViewById(R.id.pb2);
        pb1.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn_open:
                Intent intent = new Intent(MainActivity.this, OvActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.next_in, R.anim.next_out);
                break;

            case R.id.btn_open2:
                launch(btn_open2);
                break;

            case R.id.image:
                launch2();
                break;

            case R.id.btn_open3:
                // 图片覆盖

                CircularAnim.fullActivity(MainActivity.this, btn_open3)
                        .colorOrImageRes(R.drawable.ic_avatar3)
                        .go(new CircularAnim.OnAnimationEndListener() {
                            @Override
                            public void onAnimationEnd() {
                                startActivity(new Intent(MainActivity.this, ListActivity.class));
                            }
                        });

                break;

            case R.id.btn_open4:
                // 颜色覆盖
                // 先将颜色展出铺满，然后启动新的Activity
                CircularAnim.fullActivity(MainActivity.this, btn_open4)
                        .colorOrImageRes(R.color.colorPrimary)  //注释掉，因为该颜色已经在App.class 里配置为默认色
                        .go(new CircularAnim.OnAnimationEndListener() {
                            @Override
                            public void onAnimationEnd() {
                                startActivity(new Intent(MainActivity.this, ListActivity.class));
                            }
                        });

                break;

            case R.id.btn_change1:

                // 变换  btn__pb

                CircularAnim.hide(btn_change1).go();
                pb1.setVisibility(View.VISIBLE);

                break;

            case R.id.btn_change2:
                // login

                CircularAnim.hide(btn_change2)
                        .endRadius(pb2.getHeight() / 2)
                        .go(new CircularAnim.OnAnimationEndListener() {
                            @Override
                            public void onAnimationEnd() {
                                pb2.setVisibility(View.VISIBLE);
                                pb2.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        CircularAnim.fullActivity(MainActivity.this, pb2)
                                                .go(new CircularAnim.OnAnimationEndListener() {
                                                    @Override
                                                    public void onAnimationEnd() {
                                                        startActivity(new Intent(MainActivity.this, ListActivity.class));
                                                        // finish();
                                                    }
                                                });
                                    }
                                }, 3000);
                            }
                        });


                break;

            case R.id.pb1:
                // 变换 pb__btn
                CircularAnim.show(btn_change1).go();
                pb1.setVisibility(View.GONE);
                break;

        }
    }


    private void launch(View view) {
        ActivityOptionsCompat compat =
                ActivityOptionsCompat.makeScaleUpAnimation(view, view.getWidth() / 2, view.getHeight() / 2, 0, 0);
        ActivityCompat.startActivity(this, new Intent(this, makeScaleUpAnimationActivity.class), compat.toBundle());
    }


    private void launch2() {
        Pair<View, String> imagePair = Pair.create((View) imageView, getString(R.string.image));
        Pair<View, String> textPair = Pair.create((View) textView, getString(R.string.name));

        ActivityOptionsCompat compat = ActivityOptionsCompat
                .makeSceneTransitionAnimation(this, imagePair, textPair);
        ActivityCompat.startActivity(this, new Intent(this, makeSceneTrans.class),
                compat.toBundle());
    }


}

package com.dofun.myactivitydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ListActivity extends AppCompatActivity {


    Button btn_close;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        btn_close = (Button) findViewById(R.id.btn_close);
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                /*CircularAnim.fullActivity(ListActivity.this, v)
                       .colorOrImageRes(R.color.colorPrimary)
                        .go(new CircularAnim.OnAnimationEndListener() {
                            @Override
                            public void onAnimationEnd() {
                                startActivity(new Intent(ListActivity.this, MainActivity.class));
                                finish();
                            }
                        });*/
            }
        });
    }
}

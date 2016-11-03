package com.dofun.myactivitydemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OvActivity extends AppCompatActivity {

    Button btn_open;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ov);

        btn_open = (Button) findViewById(R.id.btn_open);
        btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(OvActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.pre_in, R.anim.pre_out);
            }
        });

    }



}

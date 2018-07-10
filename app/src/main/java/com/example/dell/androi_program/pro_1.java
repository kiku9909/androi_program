package com.example.dell.androi_program;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class pro_1 extends AppCompatActivity {

    private FloatingActionButton info_toast_btn;
    private TextView information_static;
    private Toolbar p1toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro_1);
        p1toolbar = (Toolbar) findViewById(R.id.p1toolbar);
        setSupportActionBar(p1toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        info_toast_btn = (FloatingActionButton) findViewById(R.id.info_btn);
        information_static = (TextView) findViewById(R.id.info_tv);

        info_toast_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(pro_1.this, "Hello, welcome to Android Lab", Toast.LENGTH_LONG).show();
                information_static.setText("second Practical compeleted :)");
            }
        });
    }
}

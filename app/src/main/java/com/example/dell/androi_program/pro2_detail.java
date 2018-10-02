package com.example.dell.androi_program;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class pro2_detail extends AppCompatActivity {

    private TextView un,em,ph,cn,st,gn,in,dob_d,dob_t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro2_detail);
        Toolbar tb = findViewById(R.id.toolbar2);
        setSupportActionBar(tb);
        getSupportActionBar().setTitle("Detail");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        un = (TextView) findViewById(R.id.un);
        un.setText(intent.getStringExtra("un"));
        em = (TextView) findViewById(R.id.em);
        em.setText(intent.getStringExtra("em"));
        ph = (TextView) findViewById(R.id.ph);
        ph.setText(intent.getStringExtra("ph"));
        cn = (TextView) findViewById(R.id.cnt);
        cn.setText(intent.getStringExtra("cn"));
        st = (TextView) findViewById(R.id.st);
        st.setText(intent.getStringExtra("st"));
        gn = (TextView) findViewById(R.id.gn);
        gn.setText(intent.getStringExtra("gn"));
        in = (TextView) findViewById(R.id.inter);
        in.setText(intent.getStringExtra("in"));
        dob_d = (TextView) findViewById(R.id.dob_d);
        dob_d.setText(intent.getStringExtra("db_d"));
        dob_t = (TextView) findViewById(R.id.dob_t);
        dob_t.setText(intent.getStringExtra("db_d"));
    }
}

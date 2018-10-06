package com.example.dell.androi_program;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

public class Pro3 extends AppCompatActivity implements View.OnClickListener {

    Button btn_c, btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_po;
    Button btn_d, btn_mu, btn_m, btn_p, btn_e;
    TextView ans_tv;
    EditText input_box;
    private boolean isFirstSet = false, isOprSet = false;
    private double num1, num2, ans;
    private char opr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro3);
        Toolbar tb = findViewById(R.id.toolbar3);
        setSupportActionBar(tb);
        getSupportActionBar().setTitle("Calculator");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ans_tv = (TextView) findViewById(R.id.ans);
        btn_c = (Button) findViewById(R.id.btn_c);
        btn_0 = (Button) findViewById(R.id.btn_0);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_9 = (Button) findViewById(R.id.btn_9);

        btn_po = (Button) findViewById(R.id.btn_po);
        btn_po.setOnClickListener(this);
        btn_d = (Button) findViewById(R.id.btn_d);
        btn_d.setOnClickListener(this);
        btn_mu = (Button) findViewById(R.id.btn_mu);
        btn_mu.setOnClickListener(this);
        btn_m = (Button) findViewById(R.id.btn_m);
        btn_m.setOnClickListener(this);
        btn_p = (Button) findViewById(R.id.btn_p);
        btn_p.setOnClickListener(this);
        btn_e = (Button) findViewById(R.id.btn_e);
        btn_e.setOnClickListener(this);
        input_box = (EditText) findViewById(R.id.inp_box);

        btn_c.setOnClickListener(this);
        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_c:
                input_box.setText("");
                isFirstSet = false;
                isOprSet = false;
                num1 = 0;
                num2 = 0;
                opr = '\0';
                break;
            case R.id.btn_0:
                input_box.append("0");
                assingNumber(0);
                break;
            case R.id.btn_1:
                input_box.append("1");
                assingNumber(1);
                break;
            case R.id.btn_2:
                input_box.append("2");
                assingNumber(2);
                break;
            case R.id.btn_3:
                input_box.append("3");
                assingNumber(3);
                break;
            case R.id.btn_4:
                input_box.append("4");
                assingNumber(4);
                break;
            case R.id.btn_5:
                input_box.append("5");
                assingNumber(5);
                break;
            case R.id.btn_6:
                input_box.append("6");
                assingNumber(6);
                break;
            case R.id.btn_7:
                input_box.append("7");
                assingNumber(7);
                break;
            case R.id.btn_8:
                input_box.append("8");
                assingNumber(8);
                break;
            case R.id.btn_9:
                input_box.append("9");
                assingNumber(9);
                break;
            case R.id.btn_po:
                input_box.append(".");
                assingNumber(0.0);
                break;
            case R.id.btn_d:
                input_box.append("/");
                operationOpr('/');
                break;
            case R.id.btn_mu:
                input_box.append("*");
                operationOpr('*');
                break;
            case R.id.btn_m:
                input_box.append("-");
                operationOpr('-');
                break;
            case R.id.btn_p:
                input_box.append("+");
                operationOpr('+');
                break;
            case R.id.btn_e:
                if (!input_box.getText().toString().equals("") && !input_box.getText().toString().equals(null)) {
                    perform();
                    ans_tv.setText(String.valueOf(ans));
                } else {
                    Snackbar.make(view, "there no input!", Snackbar.LENGTH_LONG).show();
                }
                break;
        }
    }

    private void operationOpr(char op) {
        if (isOprSet) {
            perform();
            num1 = ans;
        }
        this.opr = op;
        isFirstSet = true;
        isOprSet = true;
    }

    private void perform() {
        switch (opr) {
            case '+':
                ans = num1 + num2;
                break;
            case '-':
                ans = num1 - num2;
                break;
            case '*':
                ans = num1 * num2;
                break;
            case '/':
                ans = num1 / num2;
                break;
        }
        num1 = 0;
        num2 = 0;
        num1 = ans;
        isFirstSet = true;
        isOprSet = false;
    }

    private void assingNumber(double num) {
        if (isFirstSet) {
            if (num2 > 0) {
                num2 *= 10;
            }
            num2 += num;
        } else {
            if (num1 > 0) {
                num1 *= 10;
            }
            num1 += num;
        }
    }
}

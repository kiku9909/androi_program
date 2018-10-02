package com.example.dell.androi_program;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.DateTimeKeyListener;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class Pro2 extends AppCompatActivity {

    private EditText dob_et, uname, password, Email, phone, intrest;
    private Spinner contury, state;
    private RadioGroup gender;
    private Calendar mCalendar;
    private EditText dob_time;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro2);

        mCalendar = Calendar.getInstance();
        dob_et = (EditText) findViewById(R.id.dob);
        dob_time = (EditText) findViewById(R.id.dob_time);
        uname = (EditText) findViewById(R.id.uname);
        password = (EditText) findViewById(R.id.password);
        Email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        intrest = (EditText) findViewById(R.id.Interest);

        contury = (Spinner) findViewById(R.id.conutry);
        state = (Spinner) findViewById(R.id.state);

        gender = (RadioGroup) findViewById(R.id.gender);


        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                mCalendar.set(Calendar.YEAR, year);
                mCalendar.set(Calendar.MONTH, month + 1);
                mCalendar.set(Calendar.DAY_OF_MONTH, day);
//                Toast.makeText(Pro2.this, mCalendar.get(Calendar.YEAR)+"-"+mCalendar.get(Calendar.MONTH)+"-"+mCalendar.get(Calendar.DAY_OF_MONTH), Toast.LENGTH_SHORT).show();
                dob_et.setText(year + "/" + month + 1 + "/" + day);
            }
        };
        dob_et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(Pro2.this, date, mCalendar.get(Calendar.YEAR), mCalendar.get(Calendar.MONTH), mCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        final TimePickerDialog.OnTimeSetListener time = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hr, int min) {
                dob_time.setText(hr + ":" + min);
            }
        };
        dob_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TimePickerDialog(Pro2.this, time, mCalendar.get(Calendar.HOUR_OF_DAY), mCalendar.get(Calendar.MINUTE), false).show();
            }
        });

        submit = (Button) findViewById(R.id.submit_btn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!(uname.getText().toString().equals("")) || !(password.getText().toString().equals("")) || !(Email.getText().toString().equals("")) || !(phone.getText().toString().equals("")) || !(intrest.getText().toString().equals("")) || !(dob_et.getText().toString().equals("")) || !(dob_time.getText().toString().equals(""))) {
                    if (!(uname.getText().toString().equals(null)) || !(password.getText().toString().equals(null)) || !(Email.getText().toString().equals(null)) || !(phone.getText().toString().equals(null)) || !(intrest.getText().toString().equals(null)) || !(dob_et.getText().toString().equals(null)) || !(dob_time.getText().toString().equals(null))) {
                        Intent dataIntent = new Intent(Pro2.this, pro2_detail.class);
                        dataIntent.putExtra("un", uname.getText().toString());
                        dataIntent.putExtra("em", Email.getText().toString());
                        dataIntent.putExtra("ph", phone.getText().toString());
                        dataIntent.putExtra("cn", contury.getSelectedItem().toString());
                        dataIntent.putExtra("st", state.getSelectedItem().toString());
                        RadioButton radioButton = (RadioButton) findViewById(gender.getCheckedRadioButtonId());
                        dataIntent.putExtra("gn", radioButton.getText().toString());
                        dataIntent.putExtra("in", intrest.getText().toString());
                        dataIntent.putExtra("db_d", dob_et.getText().toString());
                        dataIntent.putExtra("db_t", dob_time.getText().toString());
                        startActivity(dataIntent);
                    } else {
                        Snackbar.make(view, "fill the form first!", Snackbar.LENGTH_LONG).show();
                    }
                } else {
                    Snackbar.make(view, "fill the form first!", Snackbar.LENGTH_LONG).show();
                }
            }
        });
    }
}

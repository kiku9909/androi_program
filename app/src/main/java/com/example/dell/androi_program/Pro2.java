package com.example.dell.androi_program;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.DateTimeKeyListener;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class Pro2 extends AppCompatActivity {

    private EditText dob_et;
    private Calendar mCalendar;
    private EditText dob_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro2);

        mCalendar = Calendar.getInstance();
        dob_et = (EditText) findViewById(R.id.dob);
        dob_time = (EditText) findViewById(R.id.dob_time);
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
                new TimePickerDialog(Pro2.this, time, mCalendar.get(Calendar.HOUR_OF_DAY), mCalendar.get(Calendar.MINUTE),false).show();
            }
        });
    }
}

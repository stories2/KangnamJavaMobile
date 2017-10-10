package com.java.kangnam.jex5;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends Activity implements View.OnClickListener,
                                                        RadioGroup.OnCheckedChangeListener,
                                                        CalendarView.OnDateChangeListener,
                                                        TimePicker.OnTimeChangedListener{

    final int LAYOUT_NUMBER = 2;

    Chronometer chronometerTimer;
    Button btnStartTimer, btnStop;
    RadioGroup radioGroupDateTime;
    RadioButton radioDate, radioTime;
    CalendarView calDate;
    TimePicker timePicker;
    TextView txtYear, txtMonth, txtDay, txtHour, txtMin, txtSec;

    int year, month, day, hour, min, sec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        if(LAYOUT_NUMBER == 2) {
            Init();
        }
    }

    public void Init() {
        chronometerTimer = (Chronometer) findViewById(R.id.chronometerTimer);

        btnStartTimer = (Button) findViewById(R.id.btnStartTimer);
        btnStop = (Button) findViewById(R.id.btnStop);

        radioGroupDateTime = (RadioGroup) findViewById(R.id.radioGroupDateTime);

        radioDate = (RadioButton) findViewById(R.id.radioDate);
        radioTime = (RadioButton) findViewById(R.id.radioTime);

        calDate = (CalendarView) findViewById(R.id.calDate);

        timePicker = (TimePicker) findViewById(R.id.timePicker);

        txtYear = (TextView) findViewById(R.id.txtYear);
        txtMonth = (TextView) findViewById(R.id.txtMonth);
        txtDay = (TextView) findViewById(R.id.txtDay);
        txtHour = (TextView) findViewById(R.id.txtHour);
        txtMin = (TextView) findViewById(R.id.txtMin);
        txtSec = (TextView) findViewById(R.id.txtSec);

        btnStartTimer.setOnClickListener(this);
        btnStop.setOnClickListener(this);

        calDate.setVisibility(View.INVISIBLE);
        timePicker.setVisibility(View.INVISIBLE);

        radioGroupDateTime.setOnCheckedChangeListener(this);

        calDate.setOnDateChangeListener(this);
        timePicker.setOnTimeChangedListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStartTimer:
                StartTimer();
                break;
            case R.id.btnStop:
                StopTimer();
                break;
            default:
                break;
        }
    }

    public void StartTimer() {
        chronometerTimer.setBase(SystemClock.elapsedRealtime());
        chronometerTimer.start();
        chronometerTimer.setTextColor(Color.RED);
    }

    public void StopTimer() {
        chronometerTimer.stop();
        chronometerTimer.setTextColor(Color.BLUE);

        txtYear.setText(String.format("%2d", year));
        txtMonth.setText(String.format("%2d", month + 1));
        txtDay.setText(String.format("%2d", day));

        txtHour.setText(String.format("%2d", hour));
        txtMin.setText(String.format("%2d", min));
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.radioDate:
                ShowDate();
                break;
            case R.id.radioTime:
                ShowTime();
                break;
            default:
                break;
        }
    }

    public void ShowDate() {
        calDate.setVisibility(View.VISIBLE);
        timePicker.setVisibility(View.INVISIBLE);
    }

    public void ShowTime() {
        calDate.setVisibility(View.INVISIBLE);
        timePicker.setVisibility(View.VISIBLE);
    }

    @Override
    public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
        this.year = year;
        this.month = month;
        this.day = dayOfMonth;
    }

    @Override
    public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
        this.hour = hourOfDay;
        this.min = minute;
    }
}

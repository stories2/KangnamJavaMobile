package com.example.user.jex9;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;

public class MainActivity extends Activity {

    DatePicker dateDairy;
    EditText etxtDairy;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Init1();
    }

    public void Init1() {
        dateDairy = (DatePicker)findViewById(R.id.dateDairy);
        etxtDairy = (EditText)findViewById(R.id.etxtDairy);
        btnSave = (Button)findViewById(R.id.btnSave);

        Date date = new Date();
        int year = date.getYear();
        int month = date.getMonth();
        int day = date.getDay();

        Log.d("Test", "" + year + "" + month + "" + day + " now");

        SetDiaryText("" + (2000 + year - 100) + "" + (month + 1) + "" + day + ".txt");

        dateDairy.init(2000 + year - 100, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int month, int day) {
                SetDiaryText("" + year + "" + (month + 1) + "" + day + ".txt");
            }
        });
    }

    public void SetDiaryText(String fileName) {
        String diaryText = ReadDiary(fileName);
        if(diaryText != null) {
            etxtDairy.setText(diaryText);
        }
        else {
            etxtDairy.setText("");
            etxtDairy.setHint("no diary exist");
        }
    }

    public void SaveDiary(String fileName, String diaryText) {
        Log.d("Test", "fila name: " + fileName);
        try {
            FileOutputStream fileOutputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
            fileOutputStream.write(diaryText.getBytes());
            fileOutputStream.close();
            Log.d("Test", "file saved");
        }
        catch (Exception err) {
            Log.d("Test", "file save error");
        }
    }

    public String ReadDiary(String fileName) {
        try {
            Log.d("Test", "fila name: " + fileName);
            FileInputStream fileInputStream = openFileInput(fileName);
            byte[] txt = new byte[512];
            fileInputStream.read(txt);
            String result = (new String(txt)).trim();
            btnSave.setText("Modify");
            return result;
        }
        catch (Exception err) {
            Log.d("Test", "no such file exist: " + fileName);
            btnSave.setText("Save");
        }
        return null;
    }

    public void BtnOnWriteDiary(View view) {
        int year = dateDairy.getYear();
        int month = dateDairy.getMonth() + 1;
        int day = dateDairy.getDayOfMonth();
        SaveDiary("" + year + "" + month + "" + day + ".txt", etxtDairy.getText().toString());
    }

    public void BtnOnMakeNewFile(View view) {
        try {
            FileOutputStream fileOutputStream = openFileOutput("echo.txt", Context.MODE_PRIVATE);
            String echoStr = "echo";
            fileOutputStream.write(echoStr.getBytes());
            fileOutputStream.close();

            Toast.makeText(getApplicationContext(), "made new file", Toast.LENGTH_SHORT).show();
        }
        catch (Exception err) {
            Toast.makeText(getApplicationContext(), "made new file fail", Toast.LENGTH_SHORT).show();
        }
    }

    public void BtnOnReadFile(View view) {
        try {
            FileInputStream fileInputStream = openFileInput("echo.txt");
            byte[] txt = new byte[30];
            fileInputStream.read(txt);
            Toast.makeText(getApplicationContext(), "read ok: " + new String(txt), Toast.LENGTH_SHORT).show();
        }
        catch (Exception err) {
            Toast.makeText(getApplicationContext(), "read failed", Toast.LENGTH_SHORT).show();
        }
    }
}

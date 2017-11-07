package com.example.user.jex9;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

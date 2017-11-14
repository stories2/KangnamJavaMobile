package com.example.user.jex11;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.InputStream;

public class MainActivity extends Activity {

    EditText etxtRawFileText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Init1();
    }

    public void Init1() {
        etxtRawFileText = (EditText)findViewById(R.id.etxtRawFileText);
    }

    public void btnOnReadRawFileClick(View view) {
        try {
            Resources resources = getResources();
            InputStream inputStream = resources.openRawResource(R.raw.test);
            byte[] text = new byte[inputStream.available()];
            Log.d("jex11", "file size: " + inputStream.available());
            inputStream.read(text);
            etxtRawFileText.setText(new String(text));
            inputStream.close();
        }
        catch (Exception err) {
            Log.d("jex11", "Error: " + err.getMessage());
        }
    }
}

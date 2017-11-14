package com.example.user.jex11;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    EditText etxtRawFileText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etxtRawFileText = (EditText)findViewById(R.id.etxtRawFileText);
    }

    public void btnOnReadRawFileClick(View view) {
        
    }
}

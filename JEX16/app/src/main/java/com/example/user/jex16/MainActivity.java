package com.example.user.jex16;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    final int ADD_REQUEST_RESULT = 0;

    EditText etxtA, etxtB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Init1();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK) {
            switch (requestCode) {
                case ADD_REQUEST_RESULT:
                    Toast.makeText(getApplicationContext(), "result: " + data.getIntExtra("Sum", 0), Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

    public void Init1() {

        etxtA = (EditText)findViewById(R.id.etxtA);
        etxtB = (EditText)findViewById(R.id.etxtB);
    }

    public void btnOnAddClick(View view) {
        Intent intent = new Intent(this, AddActivity.class);
        intent.putExtra("A", Integer.parseInt(etxtA.getText().toString()));
        intent.putExtra("B", Integer.parseInt(etxtB.getText().toString()));
        startActivityForResult(intent, ADD_REQUEST_RESULT);
    }
}

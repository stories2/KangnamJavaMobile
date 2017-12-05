package com.example.user.jex16;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {

    public static final int ADD_REQUEST_RESULT = 0, MINUS_REQUEST_RESULT = 1, MULTIPLE_REQUEST_RESULT = 2, DIVIDE_REQUEST_RESULT = 3;

    EditText etxtA, etxtB;
    RadioGroup radioGroup;
    int calculateType;

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
                    Toast.makeText(getApplicationContext(), "result: " + data.getDoubleExtra("Sum", 0), Toast.LENGTH_SHORT).show();
                    break;
                case MINUS_REQUEST_RESULT:
                    Toast.makeText(getApplicationContext(), "result: " + data.getDoubleExtra("Sum", 0), Toast.LENGTH_SHORT).show();
                    break;
                case MULTIPLE_REQUEST_RESULT:
                    Toast.makeText(getApplicationContext(), "result: " + data.getDoubleExtra("Sum", 0), Toast.LENGTH_SHORT).show();
                    break;
                case DIVIDE_REQUEST_RESULT:
                    Toast.makeText(getApplicationContext(), "result: " + data.getDoubleExtra("Sum", 0), Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

    public void Init1() {

        etxtA = (EditText)findViewById(R.id.etxtA);
        etxtB = (EditText)findViewById(R.id.etxtB);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);

        calculateType = ADD_REQUEST_RESULT;

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioAdd:
                        calculateType = ADD_REQUEST_RESULT;
                        break;
                    case R.id.radioMinus:
                        calculateType = MINUS_REQUEST_RESULT;
                        break;
                    case R.id.radioMultiple:
                        calculateType = MULTIPLE_REQUEST_RESULT;
                        break;
                    case R.id.radioDivide:
                        calculateType = DIVIDE_REQUEST_RESULT;
                        break;
                }
            }
        });
    }

    public void btnOnAddClick(View view) {
        Intent intent = new Intent(this, AddActivity.class);
        intent.putExtra("A", Integer.parseInt(etxtA.getText().toString()));
        intent.putExtra("B", Integer.parseInt(etxtB.getText().toString()));
        startActivityForResult(intent, ADD_REQUEST_RESULT);
    }

    public void btnOnCalculateClick(View view) {
        Intent intent = new Intent(this, AddActivity.class);
        intent.putExtra("A", Integer.parseInt(etxtA.getText().toString()));
        intent.putExtra("B", Integer.parseInt(etxtB.getText().toString()));
        intent.putExtra("Request", calculateType);
        startActivityForResult(intent, calculateType);
    }
}

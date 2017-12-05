package com.example.user.jex16;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import static com.example.user.jex16.MainActivity.ADD_REQUEST_RESULT;
import static com.example.user.jex16.MainActivity.DIVIDE_REQUEST_RESULT;
import static com.example.user.jex16.MainActivity.MINUS_REQUEST_RESULT;
import static com.example.user.jex16.MainActivity.MULTIPLE_REQUEST_RESULT;

/**
 * Created by User on 2017-12-05.
 */

public class AddActivity extends Activity {

    int request = ADD_REQUEST_RESULT;
    double sum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        request = intent.getIntExtra("Request", ADD_REQUEST_RESULT);
        switch (request) {
            case ADD_REQUEST_RESULT:
                sum = (double)intent.getIntExtra("A", 0) + intent.getIntExtra("B", 0);
                break;
            case MINUS_REQUEST_RESULT:
                sum = (double)intent.getIntExtra("A", 0) - intent.getIntExtra("B", 0);
                break;
            case MULTIPLE_REQUEST_RESULT:
                sum = (double)intent.getIntExtra("A", 0) * intent.getIntExtra("B", 0);
                break;
            case DIVIDE_REQUEST_RESULT:
                sum = (double)intent.getIntExtra("A", 0) / intent.getIntExtra("B", 1);
                break;
        }
    }

    public void btnOnBackClick(View view) {
        Intent resultIntent = new Intent(getApplicationContext(), MainActivity.class);
        resultIntent.putExtra("Sum", sum);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}

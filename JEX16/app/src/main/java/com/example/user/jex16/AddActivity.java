package com.example.user.jex16;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by User on 2017-12-05.
 */

public class AddActivity extends Activity {

    int sum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        sum = intent.getIntExtra("A", 0) + intent.getIntExtra("B", 0);
    }

    public void btnOnBackClick(View view) {
        Intent resultIntent = new Intent(getApplicationContext(), MainActivity.class);
        resultIntent.putExtra("Sum", sum);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}

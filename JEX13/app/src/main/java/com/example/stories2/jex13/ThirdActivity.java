package com.example.stories2.jex13;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by stories2 on 2017. 11. 28..
 */

public class ThirdActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    public void btnGoBack(View view) {
        finish();
    }
}

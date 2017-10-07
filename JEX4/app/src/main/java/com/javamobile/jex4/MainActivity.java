package com.javamobile.jex4;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends Activity implements View.OnClickListener{

    final String TAG = "JEX4";
    LinearLayout linearFirstLayout, linearSecondLayout, linearThirdLayout, linearFourthLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Init();
    }

    public void Init() {
        linearFirstLayout = (LinearLayout)findViewById(R.id.linearFirstLayout);
        linearSecondLayout = (LinearLayout)findViewById(R.id.linearSecondLayout);
        linearThirdLayout = (LinearLayout)findViewById(R.id.linearThirdLayout);
        linearFourthLayout = (LinearLayout)findViewById(R.id.linearFourthLayout);

        linearFirstLayout.setOnClickListener(this);
        linearSecondLayout.setOnClickListener(this);
        linearThirdLayout.setOnClickListener(this);
        linearFourthLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        LinearLayout linearLayout = (LinearLayout)view;
        switch (linearLayout.getId()){
            case R.id.linearFirstLayout:
                Log.d(TAG, "first layout clicked");
                break;
            case R.id.linearSecondLayout:
                Log.d(TAG, "second layout clicked");
                break;
            case R.id.linearThirdLayout:
                Log.d(TAG, "third layout clicked");
                break;
            case R.id.linearFourthLayout:
                Log.d(TAG, "fourth layout clicked");
                break;
            default:
                break;
        }
    }
}

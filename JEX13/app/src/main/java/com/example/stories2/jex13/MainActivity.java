package com.example.stories2.jex13;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

public class MainActivity extends Activity {

    RadioGroup radioGroupActivity;
    int activityTarget = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroupActivity = (RadioGroup)findViewById(R.id.radioGroupActivity);

        radioGroupActivity.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId) {
                    case R.id.radioSecond:
                        break;
                    case R.id.radioThird:
                        break;
                }
            }
        });
    }

    public void btnGoActivity(View view) {
        if(activityTarget == 0) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        }
        else if(activityTarget == 1) {
            Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
            startActivity(intent);
        }
    }
}

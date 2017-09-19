package com.javamobile.jex1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {

    LinearLayout viewRadioGroup, viewResult;
    CheckBox enableRadio;
    RadioGroup radioGroup;
    RadioButton radioCat, radioDog, radioRabbit;
    Button btnDone;
    ImageView imgPicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        InitActivityMain2();
        EventActivityMain2();
    }

    public void EventActivityMain2() {
        enableRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean enable) {
                if(enable) {
                    viewRadioGroup.setVisibility(View.VISIBLE);
                    viewResult.setVisibility(View.VISIBLE);
                }
                else {
                    viewRadioGroup.setVisibility(View.INVISIBLE);
                    viewResult.setVisibility(View.INVISIBLE);
                }
            }
        });

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.radioCat:
                        Toast.makeText(getApplicationContext(), "cat", Toast.LENGTH_SHORT).show();
                        imgPicture.setImageResource(R.drawable.cat);
                        break;
                    case R.id.radioDog:
                        Toast.makeText(getApplicationContext(), "dog", Toast.LENGTH_SHORT).show();
                        imgPicture.setImageResource(R.drawable.dog);
                        break;
                    case R.id.radioRabbit:
                        Toast.makeText(getApplicationContext(), "rabbit", Toast.LENGTH_SHORT).show();
                        imgPicture.setImageResource(R.drawable.rabbit);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "select something", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    public void InitActivityMain2() {
        viewRadioGroup = (LinearLayout) findViewById(R.id.viewRadioGroup);
        viewResult = (LinearLayout) findViewById(R.id.viewResult);

        enableRadio = (CheckBox) findViewById(R.id.enableRadio);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        radioCat = (RadioButton) findViewById(R.id.radioCat);
        radioDog = (RadioButton) findViewById(R.id.radioDog);
        radioRabbit = (RadioButton) findViewById(R.id.radioRabbit);

        btnDone = (Button) findViewById(R.id.btnDone);

        imgPicture = (ImageView) findViewById(R.id.imgPicture);

        viewRadioGroup.setVisibility(View.INVISIBLE);
        viewResult.setVisibility(View.INVISIBLE);
    }
}

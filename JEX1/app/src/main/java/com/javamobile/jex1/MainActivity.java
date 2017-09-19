package com.javamobile.jex1;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends Activity {

    LinearLayout viewRadioGroup, viewResult;
    CheckBox enableRadio;
    Switch switchEnable;
    RadioGroup radioGroup;
    RadioButton radioCat, radioDog, radioRabbit, radioLol, radioMa, radioNu;
    Button btnDone;
    ImageView imgPicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main5);

        //InitActivityMain2();
        //EventActivityMain2();
        //InitActivityMain3();
        //EventActivityMain3();

        ManualLayout();
    }

    public void ManualLayout() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        );
        LinearLayout baseLinearLayout = new LinearLayout(this);
        baseLinearLayout.setOrientation(LinearLayout.VERTICAL);
        baseLinearLayout.setBackgroundColor(Color.rgb(0, 255, 0));
        setContentView(baseLinearLayout, layoutParams);

        Button manualButton = new Button(this);
        manualButton.setText("This is button");
        manualButton.setBackgroundColor(Color.MAGENTA);

        baseLinearLayout.addView(manualButton);

        manualButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "You click manual button", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void EventActivityMain3() {
        switchEnable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
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

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioLol:
                        Toast.makeText(getApplicationContext(), "Loli", Toast.LENGTH_SHORT).show();
                        imgPicture.setImageResource(R.drawable.lollipop);
                        break;
                    case R.id.radioMa:
                        Toast.makeText(getApplicationContext(), "Marsh", Toast.LENGTH_SHORT).show();
                        imgPicture.setImageResource(R.drawable.marshmallow);
                        break;
                    case R.id.radioNu:
                        Toast.makeText(getApplicationContext(), "Nougat", Toast.LENGTH_SHORT).show();
                        imgPicture.setImageResource(R.drawable.nougat2);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "select something", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    public void InitActivityMain3() {
        viewRadioGroup = (LinearLayout) findViewById(R.id.viewRadioGroup);
        viewResult = (LinearLayout) findViewById(R.id.viewResult);

        switchEnable = (Switch) findViewById(R.id.switchEnable);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        radioLol = (RadioButton) findViewById(R.id.radioLol);
        radioMa = (RadioButton) findViewById(R.id.radioMa);
        radioNu = (RadioButton) findViewById(R.id.radioNu);

        imgPicture = (ImageView) findViewById(R.id.imgPicture);

        viewRadioGroup.setVisibility(View.INVISIBLE);
        viewResult.setVisibility(View.INVISIBLE);
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

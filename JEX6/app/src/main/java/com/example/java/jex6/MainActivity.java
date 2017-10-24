package com.example.java.jex6;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.ViewFlipper;

public class MainActivity extends Activity {

    AutoCompleteTextView autoTextView;
    MultiAutoCompleteTextView multiAutoTextView;
    ViewFlipper viewFilpImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Init1();
        Init2();
    }

    public void OnBtnStartAutoSwap(View view) {
        viewFilpImage.startFlipping();
    }

    public void OnBtnStopAutoSwap(View view) {
        viewFilpImage.stopFlipping();
    }

    public void Init2() {
        viewFilpImage = (ViewFlipper)findViewById(R.id.viewFilpImage);
        viewFilpImage.setFlipInterval(1000);
    }

    public void Init1() {

        autoTextView = (AutoCompleteTextView) findViewById(R.id.autoTextView);
        multiAutoTextView = (MultiAutoCompleteTextView)findViewById(R.id.multiAutoTextView);

        String[] items = new String[]{"abc", "abcd", "abcde"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        autoTextView.setAdapter(adapter);

        MultiAutoCompleteTextView.CommaTokenizer commaTokenizer = new MultiAutoCompleteTextView.CommaTokenizer();
        multiAutoTextView.setTokenizer(commaTokenizer);
        multiAutoTextView.setAdapter(adapter);
    }
}

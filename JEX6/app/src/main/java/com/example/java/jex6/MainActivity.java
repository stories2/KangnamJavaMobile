package com.example.java.jex6;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends Activity {

    AutoCompleteTextView autoTextView;
    MultiAutoCompleteTextView multiAutoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

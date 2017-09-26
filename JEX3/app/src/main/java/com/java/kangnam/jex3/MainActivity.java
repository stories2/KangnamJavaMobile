package com.java.kangnam.jex3;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    public static final String TAG = "Test";

    EditText etxtCalc;
    String[] buffer;
    int inputCounter;
    int type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        etxtCalc = (EditText)findViewById(R.id.etxtCalc);

        buffer = new String[2];
        buffer[0] = "";
        buffer[1] = "";
        inputCounter = 0;
        type = 0;
    }

    public void onClick(View view) {
        Button pressedButton = ((Button)view);
        Log.d(TAG, "pressed: " + pressedButton.getText().toString());

        String pressBtnText = pressedButton.getText().toString();

        switch (pressBtnText) {
            case "Clear":
                etxtCalc.setText("");
                type = 0;
                inputCounter = 0;
                buffer[0] = "";
                buffer[1] = "";
                break;
            case "OK":
                Log.d(TAG, "buffer 0 : " + buffer[0] + " buffer 1 : " + buffer[1]);
                double a = Double.parseDouble(buffer[0]);
                double b = Double.parseDouble(buffer[1]);
                double result = 0;
                if(type == 0) {
                    result = a + b;
                }
                else if(type == 1) {
                    result = a - b;
                }
                else if(type == 2) {
                    result = a * b;
                }
                else if(type == 3) {
                    result = a / b;
                }
                etxtCalc.setText("" + result);
                type = 0;
                inputCounter = 0;
                buffer[0] = "";
                buffer[1] = "";
                break;
            case "+":
                inputCounter += 1;
                etxtCalc.append(pressBtnText);
                type = 0;
                break;
            case "-":
                inputCounter += 1;
                etxtCalc.append(pressBtnText);
                type = 1;
                break;
            case "*":
                inputCounter += 1;
                etxtCalc.append(pressBtnText);
                type = 2;
                break;
            case "/":
                inputCounter += 1;
                etxtCalc.append(pressBtnText);
                type = 3;
                break;
            default:
                buffer[inputCounter] += pressBtnText;
                etxtCalc.append(pressBtnText);
                break;
        }
    }
}

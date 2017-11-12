package com.mobile.jex10;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class MainActivity extends Activity {

    RadioGroup radioGroupAnimal;
    final String TAG = "JEX10";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroupAnimal = (RadioGroup) findViewById(R.id.radioGroupAnimal);
    }

    public void BtnOnPictureShowClick(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        LayoutInflater layoutInflater = getLayoutInflater();
        View popUpDialog = layoutInflater.inflate(R.layout.pop_up_dialog, null);
        ImageView imageViewAnimal = (ImageView) popUpDialog.findViewById(R.id.imageViewAnimal);

        alertDialogBuilder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        switch (radioGroupAnimal.getCheckedRadioButtonId()) {
            case R.id.radioDog:
                Log.d(TAG, "picture show: dog");
                imageViewAnimal.setImageResource(R.drawable.dog);
                alertDialogBuilder.setTitle(getString(R.string.dog));
                break;
            case R.id.radioCat:
                Log.d(TAG, "picture show: cat");
                imageViewAnimal.setImageResource(R.drawable.cat);
                alertDialogBuilder.setTitle(getString(R.string.cat));
                break;
            case R.id.radioRabbit:
                Log.d(TAG, "picture show: rabbit");
                imageViewAnimal.setImageResource(R.drawable.rabbit);
                alertDialogBuilder.setTitle(getString(R.string.rabbit));
                break;
            case R.id.radioHorse:
                Log.d(TAG, "picture show: horse");
                imageViewAnimal.setImageResource(R.drawable.horse);
                alertDialogBuilder.setTitle(getString(R.string.horse));
                break;
            default:
                Log.d(TAG, "picture show: default_image");
                imageViewAnimal.setImageResource(R.drawable.default_image);
                alertDialogBuilder.setTitle(getString(R.string.not_available));
                break;
        }
        alertDialogBuilder.setIcon(null);
        alertDialogBuilder.setView(popUpDialog);
        alertDialogBuilder.show();
    }
}

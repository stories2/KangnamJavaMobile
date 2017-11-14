package com.example.user.jex11;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.FileInputStream;
import java.io.InputStream;

public class MainActivity extends Activity {

    EditText etxtRawFileText;
    ImageView imageViewFromSD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Init2();
    }

    public void btnOnReadImageFileClick(View view) {
        try {
            FileInputStream fileInputStream = new FileInputStream("/storage/emulated/0/Download/IMG_0031.png");
            Bitmap bitmap = BitmapFactory.decodeStream(fileInputStream);
            fileInputStream.close();

            imageViewFromSD.setImageBitmap(convertBitmap(bitmap));
        }
        catch (Exception err) {
            Log.d("jex11", "Error: " + err.getMessage());
        }
    }

    public Bitmap convertBitmap(Bitmap bitmap) {
        int width = bitmap.getWidth(), height = bitmap.getHeight();
        double resolution = (double)height / width;
        int convertWidth = 1000;
        int convertHeight = (int)(convertWidth * resolution);

        Log.d("jex11", "w: " + width + " h: " + height + " res: " + resolution + " cw: " + convertWidth + " ch: " + convertHeight);
        Bitmap convertedBitmap = Bitmap.createScaledBitmap(bitmap, convertWidth, convertHeight, false);
        return convertedBitmap;
    }

    public void Init2() {
        imageViewFromSD = (ImageView) findViewById(R.id.imageViewFromSD);

        if(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(
                    new String[] {
                            Manifest.permission.READ_EXTERNAL_STORAGE
                    }, MODE_PRIVATE);
        }
    }

    public void Init1() {
        etxtRawFileText = (EditText)findViewById(R.id.etxtRawFileText);
    }

    public void btnOnReadRawFileClick(View view) {
        try {
            Resources resources = getResources();
            InputStream inputStream = resources.openRawResource(R.raw.test);
            byte[] text = new byte[inputStream.available()];
            Log.d("jex11", "file size: " + inputStream.available());
            inputStream.read(text);
            etxtRawFileText.setText(new String(text));
            inputStream.close();
        }
        catch (Exception err) {
            Log.d("jex11", "Error: " + err.getMessage());
        }
    }
}

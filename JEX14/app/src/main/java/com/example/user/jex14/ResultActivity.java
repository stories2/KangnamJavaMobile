package com.example.user.jex14;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by User on 2017-11-28.
 */

public class ResultActivity extends Activity {

    TextView txtName1, txtName2, txtName3, txtName4, txtName5, txtName6, txtName7, txtName8, txtName9;
    RatingBar rateImage1, rateImage2, rateImage3, rateImage4, rateImage5, rateImage6, rateImage7, rateImage8, rateImage9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txtName1 = (TextView)findViewById(R.id.txtName1);
        txtName2 = (TextView)findViewById(R.id.txtName2);
        txtName3 = (TextView)findViewById(R.id.txtName3);
        txtName4 = (TextView)findViewById(R.id.txtName4);
        txtName5 = (TextView)findViewById(R.id.txtName5);
        txtName6 = (TextView)findViewById(R.id.txtName6);
        txtName7 = (TextView)findViewById(R.id.txtName7);
        txtName8 = (TextView)findViewById(R.id.txtName8);
        txtName9 = (TextView)findViewById(R.id.txtName9);

        rateImage1 = (RatingBar)findViewById(R.id.rateImage1);
        rateImage2 = (RatingBar)findViewById(R.id.rateImage2);
        rateImage3 = (RatingBar)findViewById(R.id.rateImage3);
        rateImage4 = (RatingBar)findViewById(R.id.rateImage4);
        rateImage5 = (RatingBar)findViewById(R.id.rateImage5);
        rateImage6 = (RatingBar)findViewById(R.id.rateImage6);
        rateImage7 = (RatingBar)findViewById(R.id.rateImage7);
        rateImage8 = (RatingBar)findViewById(R.id.rateImage8);
        rateImage9 = (RatingBar)findViewById(R.id.rateImage9);

        Intent intent = getIntent();

        int[] voteData = intent.getIntArrayExtra("vote");
        String[] imageNames = intent.getStringArrayExtra("name");

        txtName1.setText(imageNames[0]);
        txtName2.setText(imageNames[1]);
        txtName3.setText(imageNames[2]);
        txtName4.setText(imageNames[3]);
        txtName5.setText(imageNames[4]);
        txtName6.setText(imageNames[5]);
        txtName7.setText(imageNames[6]);
        txtName8.setText(imageNames[7]);
        txtName9.setText(imageNames[8]);

        rateImage1.setRating(voteData[0]);
        rateImage2.setRating(voteData[1]);
        rateImage3.setRating(voteData[2]);
        rateImage4.setRating(voteData[3]);
        rateImage5.setRating(voteData[4]);
        rateImage6.setRating(voteData[5]);
        rateImage7.setRating(voteData[6]);
        rateImage8.setRating(voteData[7]);
        rateImage9.setRating(voteData[8]);
    }
}

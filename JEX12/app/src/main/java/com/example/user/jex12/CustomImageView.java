package com.example.user.jex12;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

/**
 * Created by User on 2017-11-21.
 */

public class CustomImageView extends View {
    public CustomImageView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap picture = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);

        int centerX = this.getWidth() / 2, centerY = this.getHeight() / 2, pictureX = (this.getWidth() - picture.getWidth()) / 2, pictureY = (this.getHeight() - picture.getHeight()) / 2;

        Log.d("jex12", "cen x: " + centerX + " y: " + centerY + " pic x: " + pictureX + " y: " + pictureY);

        //canvas.rotate(0, centerX, centerY);
        //canvas.translate(-150, 200);
        canvas.scale(2, 2, centerX, centerY);
        //canvas.skew(0.3f, 0.3f);

        Paint paint = new Paint();
        BlurMaskFilter blurMaskFilter = new BlurMaskFilter(30, BlurMaskFilter.Blur.NORMAL);
        paint.setMaskFilter(blurMaskFilter);
        canvas.drawBitmap(picture, pictureX, pictureY, paint);
    }
}

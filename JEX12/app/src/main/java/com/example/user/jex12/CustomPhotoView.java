package com.example.user.jex12;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by User on 2017-11-21.
 */

public class CustomPhotoView extends View {

    float scale = 1, angle = 0, color = 1, satur = 1, blur = 0, embo = 0;

    public CustomPhotoView(Context context) {
        super(context);
    }

    public CustomPhotoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public void setColor(float color) {
        this.color = color;
    }

    public void setSatur(float satur) {
        this.satur = satur;
    }

    public void setBlur(float blur) {
        this.blur = blur;
    }

    public void setEmbo(float embo) {
        this.embo = embo;
    }

    public float getEmbo() {
        return embo;
    }

    public float getBlur() {
        return blur;
    }

    public float getScale() {
        return scale;
    }

    public float getAngle() {
        return angle;
    }

    public float getColor() {
        return color;
    }

    public float getSatur() {
        return satur;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test);

        int pictureX = (this.getWidth() - bitmap.getWidth()) / 2,
                pictureY = (this.getHeight() - bitmap.getHeight()) / 2,
                centerX = (this.getWidth() / 2), centerY = (this.getHeight() / 2);
        Paint paint = new Paint();
        paint.setColor(Color.GRAY);
        if(blur == 1) {
            BlurMaskFilter blurMaskFilter = new BlurMaskFilter(30, BlurMaskFilter.Blur.NORMAL);
            paint.setMaskFilter(blurMaskFilter);
        }
        if(embo == 1) {
            EmbossMaskFilter embossMaskFilter = new EmbossMaskFilter(new float[]{3, 3, 3}, 0.5f, 5, 10);
            paint.setMaskFilter(embossMaskFilter);
        }

        canvas.scale(scale, scale, centerX, centerY);
        canvas.rotate(angle, centerX, centerY);
        float colorMatrixArray[] = {
                color, 0, 0, 0, 0,
                0, color, 0, 0, 0,
                0, 0, color, 0, 0,
                0, 0,     0, 1, 0
        };
        ColorMatrix colorMatrix = new ColorMatrix(colorMatrixArray);
        colorMatrix.setSaturation(satur);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, pictureX, pictureY, paint);
        bitmap.recycle();
    }
}

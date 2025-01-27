package com.vivo.advv.vaf.virtualview.view.image;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;

/* loaded from: classes4.dex */
public class RoundViewDelegate {
    private Context mContext;
    private final Paint mMaskPaint;
    private final RectF mRoundRect = new RectF();
    private View mView;
    private final Paint mZonePaint;

    public RoundViewDelegate(View view, Context context) {
        Paint paint = new Paint();
        this.mMaskPaint = paint;
        Paint paint2 = new Paint();
        this.mZonePaint = paint2;
        this.mView = view;
        this.mContext = context;
        paint.setAntiAlias(true);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        paint2.setAntiAlias(true);
        paint2.setColor(-1);
    }

    public void canvasSetLayer(Canvas canvas, float[] fArr) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            canvas.saveLayer(this.mRoundRect, this.mZonePaint);
        } else {
            canvas.saveLayer(this.mRoundRect, this.mMaskPaint, 31);
        }
        if (fArr != null && fArr.length == 8) {
            Path path = new Path();
            path.addRoundRect(this.mRoundRect, fArr, Path.Direction.CW);
            canvas.clipPath(path);
        }
        canvas.drawPaint(this.mZonePaint);
        if (i2 >= 21) {
            canvas.saveLayer(this.mRoundRect, this.mMaskPaint);
        } else {
            canvas.saveLayer(this.mRoundRect, this.mMaskPaint, 31);
        }
    }

    public void roundRectSet(int i2, int i3) {
        this.mRoundRect.set(0.0f, 0.0f, i2, i3);
    }
}

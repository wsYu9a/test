package com.vivo.ad.view.w;

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
public class a {

    /* renamed from: a */
    private final RectF f27118a = new RectF();

    /* renamed from: b */
    private final Paint f27119b;

    /* renamed from: c */
    private final Paint f27120c;

    public a(View view, Context context) {
        Paint paint = new Paint();
        this.f27119b = paint;
        Paint paint2 = new Paint();
        this.f27120c = paint2;
        paint.setAntiAlias(true);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        paint2.setAntiAlias(true);
        paint2.setColor(-1);
    }

    public void a(int i2, int i3) {
        this.f27118a.set(0.0f, 0.0f, i2, i3);
    }

    public void a(Canvas canvas, float[] fArr) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            canvas.saveLayer(this.f27118a, this.f27120c);
        } else {
            canvas.saveLayer(this.f27118a, this.f27119b, 31);
        }
        if (fArr != null && fArr.length == 8) {
            Path path = new Path();
            path.addRoundRect(this.f27118a, fArr, Path.Direction.CW);
            canvas.clipPath(path);
        }
        canvas.drawPaint(this.f27120c);
        if (i2 >= 21) {
            canvas.saveLayer(this.f27118a, this.f27119b);
        } else {
            canvas.saveLayer(this.f27118a, this.f27119b, 31);
        }
    }
}

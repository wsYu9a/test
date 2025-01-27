package com.ss.android.downloadlib.guide.install;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: classes4.dex */
public class ClipImageView extends ImageView {

    /* renamed from: a */
    private boolean f21673a;

    /* renamed from: b */
    private Path f21674b;

    /* renamed from: c */
    private RectF f21675c;

    /* renamed from: d */
    private Paint f21676d;

    /* renamed from: e */
    private float[] f21677e;

    public ClipImageView(Context context) {
        super(context);
        this.f21673a = true;
        a(context);
    }

    public void a(Context context) {
        this.f21674b = new Path();
        this.f21675c = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f21673a) {
            this.f21674b.reset();
            this.f21675c.set(0.0f, 0.0f, getWidth(), getHeight());
            float[] fArr = this.f21677e;
            if (fArr != null) {
                this.f21674b.addRoundRect(this.f21675c, fArr, Path.Direction.CW);
            }
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            canvas.clipPath(this.f21674b);
            Paint paint = this.f21676d;
            if (paint != null) {
                canvas.drawPath(this.f21674b, paint);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        Paint paint = new Paint(1);
        this.f21676d = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f21676d.setColor(i10);
    }

    public void setClip(boolean z10) {
        this.f21673a = z10;
    }

    public void setRadius(float[] fArr) {
        if (fArr == null || fArr.length != 8) {
            return;
        }
        this.f21677e = fArr;
    }

    public void setRoundRadius(int i10) {
        if (i10 > 0) {
            float f10 = i10;
            setRadius(new float[]{f10, f10, f10, f10, f10, f10, f10, f10});
        }
    }

    public ClipImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21673a = true;
        a(context);
    }

    public ClipImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f21673a = true;
        a(context);
    }
}

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

    /* renamed from: g */
    private Paint f24252g;

    /* renamed from: i */
    private RectF f24253i;

    /* renamed from: j */
    private boolean f24254j;
    private float[] q;
    private Path zx;

    public ClipImageView(Context context) {
        super(context);
        this.f24254j = true;
        j(context);
    }

    protected void j(Context context) {
        this.zx = new Path();
        this.f24253i = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f24254j) {
            this.zx.reset();
            this.f24253i.set(0.0f, 0.0f, getWidth(), getHeight());
            float[] fArr = this.q;
            if (fArr != null) {
                this.zx.addRoundRect(this.f24253i, fArr, Path.Direction.CW);
            }
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            canvas.clipPath(this.zx);
            Paint paint = this.f24252g;
            if (paint != null) {
                canvas.drawPath(this.zx, paint);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        Paint paint = new Paint(1);
        this.f24252g = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f24252g.setColor(i2);
    }

    public void setClip(boolean z) {
        this.f24254j = z;
    }

    public void setRadius(float[] fArr) {
        if (fArr == null || fArr.length != 8) {
            return;
        }
        this.q = fArr;
    }

    public void setRoundRadius(int i2) {
        if (i2 > 0) {
            float f2 = i2;
            setRadius(new float[]{f2, f2, f2, f2, f2, f2, f2, f2});
        }
    }

    public ClipImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24254j = true;
        j(context);
    }

    public ClipImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f24254j = true;
        j(context);
    }
}

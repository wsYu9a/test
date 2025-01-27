package com.vivo.mobilead.unified.base.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

/* loaded from: classes4.dex */
public class l extends View {

    /* renamed from: a */
    private int f29889a;

    /* renamed from: b */
    private int f29890b;

    /* renamed from: c */
    private Paint f29891c;

    /* renamed from: d */
    private int f29892d;

    /* renamed from: e */
    private float f29893e;

    public l(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i2 = this.f29892d;
        if (i2 <= 0) {
            return;
        }
        float f2 = this.f29890b / 2;
        canvas.drawLine(0.0f, f2, i2, f2, this.f29891c);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f29889a = i2;
        this.f29890b = i3;
        this.f29891c.setStrokeWidth(i3);
        this.f29892d = (int) (this.f29889a * this.f29893e);
    }

    public void setProgress(float f2) {
        this.f29893e = f2;
        this.f29892d = (int) (this.f29889a * f2);
        invalidate();
    }

    public l(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public l(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Paint paint = new Paint();
        this.f29891c = paint;
        paint.setColor(Color.parseColor("#415FFF"));
        this.f29891c.setStyle(Paint.Style.FILL);
        this.f29891c.setAntiAlias(true);
    }
}

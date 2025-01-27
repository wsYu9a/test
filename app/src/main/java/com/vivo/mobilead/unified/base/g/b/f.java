package com.vivo.mobilead.unified.base.g.b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.vivo.advv.vaf.virtualview.core.IView;

/* loaded from: classes4.dex */
class f extends View implements IView {

    /* renamed from: a */
    private int f29797a;

    /* renamed from: b */
    private int f29798b;

    /* renamed from: c */
    private Paint f29799c;

    /* renamed from: d */
    private int f29800d;

    /* renamed from: e */
    private float f29801e;

    public f(Context context) {
        this(context, null);
    }

    public void a(float f2) {
        this.f29801e = f2;
        this.f29800d = (int) (this.f29797a * f2);
        invalidate();
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public void comLayout(int i2, int i3, int i4, int i5) {
        layout(i2, i3, i4, i5);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public int getComMeasuredHeight() {
        return getMeasuredHeight();
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public int getComMeasuredWidth() {
        return getMeasuredWidth();
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public void measureComponent(int i2, int i3) {
        measure(i2, i3);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public void onComLayout(boolean z, int i2, int i3, int i4, int i5) {
        onLayout(z, i2, i3, i4, i5);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public void onComMeasure(int i2, int i3) {
        onMeasure(i2, i3);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i2 = this.f29800d;
        if (i2 <= 0) {
            return;
        }
        float f2 = this.f29798b / 2;
        canvas.drawLine(0.0f, f2, i2, f2, this.f29799c);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f29797a = i2;
        this.f29798b = i3;
        this.f29799c.setStrokeWidth(i3);
        this.f29800d = (int) (this.f29797a * this.f29801e);
    }

    public f(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public f(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Paint paint = new Paint();
        this.f29799c = paint;
        paint.setColor(Color.parseColor("#456FFF"));
        this.f29799c.setStyle(Paint.Style.FILL);
        this.f29799c.setAntiAlias(true);
    }

    public void a(int i2) {
        this.f29799c.setColor(i2);
    }
}

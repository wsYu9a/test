package com.martian.ttbook.b.a.q;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

/* loaded from: classes4.dex */
public class e extends View {

    /* renamed from: a */
    private Paint f15155a;

    /* renamed from: b */
    private int f15156b;

    /* renamed from: c */
    private int f15157c;

    /* renamed from: d */
    private int f15158d;

    public e(Context context) {
        this(context, null);
    }

    public e(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public e(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    private void a() {
        Paint paint = new Paint();
        this.f15155a = paint;
        paint.setDither(true);
        this.f15155a.setAntiAlias(true);
        this.f15155a.setStrokeWidth(10.0f);
        this.f15155a.setColor(-65536);
    }

    public void b(int i2) {
        this.f15155a.setColor(i2);
    }

    public void c(int i2) {
        this.f15158d = i2;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawRect(0.0f, 0.0f, (this.f15156b * this.f15158d) / 100, this.f15157c, this.f15155a);
        super.onDraw(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.f15156b = i2;
        this.f15157c = i3;
        super.onSizeChanged(i2, i3, i4, i5);
    }
}

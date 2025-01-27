package com.martian.mibook.ui.reader;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.martian.libmars.d.h;

/* loaded from: classes4.dex */
public class ReaderRoundColorView extends View {

    /* renamed from: a */
    private Paint f14828a;

    /* renamed from: b */
    private int f14829b;

    /* renamed from: c */
    private RectF f14830c;

    /* renamed from: d */
    private int f14831d;

    public ReaderRoundColorView(Context context) {
        super(context);
        a();
    }

    private void a() {
        this.f14829b = getContext().getResources().getColor(R.color.transparent);
        Paint paint = new Paint();
        this.f14828a = paint;
        paint.setColor(this.f14829b);
        this.f14828a.setAntiAlias(true);
        this.f14831d = h.b(17.0f);
        this.f14830c = new RectF(0.0f, 0.0f, h.b(34.0f), h.b(34.0f));
    }

    public void b(int color, int circleRadius) {
        this.f14829b = color;
        this.f14831d = h.b(circleRadius);
        float f2 = circleRadius * 2;
        this.f14830c = new RectF(0.0f, 0.0f, h.b(f2), h.b(f2));
        this.f14828a.reset();
        this.f14828a.setColor(color);
        this.f14828a.setAntiAlias(true);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF = this.f14830c;
        int i2 = this.f14831d;
        canvas.drawRoundRect(rectF, i2, i2, this.f14828a);
    }

    public ReaderRoundColorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        a();
    }

    public ReaderRoundColorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        a();
    }
}

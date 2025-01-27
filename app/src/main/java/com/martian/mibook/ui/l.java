package com.martian.mibook.ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;

/* loaded from: classes4.dex */
public class l extends ReplacementSpan {

    /* renamed from: a */
    private final int f14268a;

    /* renamed from: b */
    private final int f14269b;

    public l(int bgColor, int textColor) {
        this.f14268a = bgColor;
        this.f14269b = textColor;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        int color = paint.getColor();
        paint.setColor(this.f14268a);
        canvas.drawRoundRect(new RectF(x + com.martian.libmars.d.h.b(2.0f), top, x + ((int) paint.measureText(text, start, end)) + com.martian.libmars.d.h.b(6.0f), bottom), com.martian.libmars.d.h.b(2.0f), com.martian.libmars.d.h.b(2.0f), paint);
        paint.setColor(this.f14269b);
        canvas.drawText(text, start, end, x + com.martian.libmars.d.h.b(4.0f), y, paint);
        paint.setColor(color);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        return ((int) paint.measureText(text, start, end)) + com.martian.libmars.d.h.b(7.0f);
    }
}

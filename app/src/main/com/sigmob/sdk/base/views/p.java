package com.sigmob.sdk.base.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

/* loaded from: classes4.dex */
public class p extends View {

    /* renamed from: a */
    public Paint f18832a;

    /* renamed from: b */
    public Path f18833b;

    public p(Context context) {
        super(context);
        Paint paint = new Paint(1);
        this.f18832a = paint;
        paint.setColor(-12303292);
        this.f18832a.setStyle(Paint.Style.STROKE);
        this.f18832a.setStrokeWidth(3.0f);
        this.f18832a.setPathEffect(new DashPathEffect(new float[]{10.0f, 5.0f}, 0.0f));
        this.f18833b = new Path();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.f18833b.reset();
        getHeight();
        getWidth();
        this.f18833b.moveTo(0.0f, 0.0f);
        this.f18833b.lineTo(0.0f, getHeight());
        canvas.drawPath(this.f18833b, this.f18832a);
    }
}

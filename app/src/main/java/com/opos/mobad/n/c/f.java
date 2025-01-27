package com.opos.mobad.n.c;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;

/* loaded from: classes4.dex */
public class f extends i {

    /* renamed from: c */
    private float f22029c;

    public f(Context context, float f2) {
        super(context);
        this.f22029c = f2;
    }

    @Override // com.opos.mobad.n.c.i
    protected void a(Canvas canvas, int i2, int i3) {
        RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        float f2 = this.f22029c;
        canvas.drawRoundRect(rectF, f2, f2, this.f22032a);
    }
}

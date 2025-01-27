package com.opos.cmn.e.a.a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;

/* loaded from: classes4.dex */
public class c extends d {

    /* renamed from: c */
    private float f16925c;

    public c(Context context, float f2) {
        super(context);
        this.f16925c = f2;
    }

    @Override // com.opos.cmn.e.a.a.d
    protected void a(Canvas canvas, int i2, int i3) {
        RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        float f2 = this.f16925c;
        canvas.drawRoundRect(rectF, f2, f2, this.f16926a);
    }
}

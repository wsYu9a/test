package com.opos.mobad.interstitial.a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;

/* loaded from: classes4.dex */
public class l extends com.opos.cmn.e.a.a.d {

    /* renamed from: c */
    private float f21064c;

    public l(Context context, float f2) {
        super(context);
        this.f21064c = f2;
    }

    @Override // com.opos.cmn.e.a.a.d
    protected void a(Canvas canvas, int i2, int i3) {
        float f2 = i2;
        float f3 = i3;
        RectF rectF = new RectF(0.0f, 0.0f, f2, f3 - this.f21064c);
        float f4 = this.f21064c;
        canvas.drawRoundRect(rectF, f4, f4, this.f16926a);
        canvas.drawRect(new RectF(0.0f, f3 - (this.f21064c * 2.0f), f2, f3), this.f16926a);
    }
}

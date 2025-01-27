package com.sigmob.sdk.base.views;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import com.sigmob.sdk.base.views.r;

/* loaded from: classes4.dex */
public class k extends h {

    /* renamed from: a */
    public final Paint f18725a;

    /* renamed from: b */
    public final float f18726b;

    public k() {
        this(8.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int width = getBounds().width();
        int height = getBounds().height();
        float f10 = this.f18726b;
        float f11 = f10 + 0.0f;
        float f12 = height;
        float f13 = width;
        canvas.drawLine(f11, f12 - f10, f13 - f10, f11, this.f18725a);
        float f14 = this.f18726b;
        float f15 = f14 + 0.0f;
        canvas.drawLine(f15, f15, f13 - f14, f12 - f14, this.f18725a);
    }

    @Override // com.sigmob.sdk.base.views.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // com.sigmob.sdk.base.views.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i10) {
        super.setAlpha(i10);
    }

    @Override // com.sigmob.sdk.base.views.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    public k(float f10) {
        this.f18726b = f10 / 2.0f;
        Paint paint = new Paint();
        this.f18725a = paint;
        paint.setColor(-1);
        paint.setStrokeWidth(f10);
        paint.setStrokeCap(r.a.f18870f);
    }
}

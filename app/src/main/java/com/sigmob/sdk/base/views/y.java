package com.sigmob.sdk.base.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.views.r;

/* loaded from: classes4.dex */
public class y extends h {

    /* renamed from: a */
    public final Paint f18943a;

    /* renamed from: b */
    public final Paint f18944b;

    /* renamed from: c */
    public int f18945c;

    /* renamed from: d */
    public int f18946d;

    /* renamed from: e */
    public int f18947e;

    /* renamed from: f */
    public int f18948f;

    /* renamed from: g */
    public float f18949g;

    /* renamed from: h */
    public final int f18950h;

    public y(Context context) {
        Paint paint = new Paint();
        this.f18943a = paint;
        paint.setColor(-1);
        paint.setAlpha(128);
        paint.setStyle(r.b.f18875e);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f18944b = paint2;
        paint2.setColor(r.b.f18876f);
        paint2.setAlpha(255);
        paint2.setStyle(r.b.f18878h);
        paint2.setAntiAlias(true);
        this.f18950h = Dips.dipsToIntPixels(4.0f, context);
    }

    public final void a() {
        this.f18947e = this.f18945c;
    }

    @Deprecated
    public int b() {
        return this.f18947e;
    }

    @Deprecated
    public float c() {
        return this.f18949g;
    }

    public void d() {
        this.f18948f = 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.drawRect(getBounds(), this.f18943a);
        int i10 = this.f18945c;
        canvas.drawRect(getBounds().left, getBounds().top, getBounds().right * (i10 > 0 ? this.f18947e / i10 : 0.0f), getBounds().bottom, this.f18944b);
        int i11 = this.f18946d;
        if (i11 <= 0 || i11 >= this.f18945c) {
            return;
        }
        float f10 = getBounds().right * this.f18949g;
        canvas.drawRect(f10, getBounds().top, f10 + this.f18950h, getBounds().bottom, this.f18944b);
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

    public void a(int i10, int i11) {
        this.f18945c = i10;
        this.f18946d = i11;
        this.f18949g = i10 > 0 ? i11 / i10 : 0.0f;
    }

    @SuppressLint({"DefaultLocale"})
    public void a(int i10) {
        int i11 = this.f18948f;
        if (i10 >= i11) {
            this.f18947e = i10;
            this.f18948f = i10;
        } else if (i10 != 0) {
            SigmobLog.d(String.format("Progress not monotonically increasing: last = %d, current = %d", Integer.valueOf(i11), Integer.valueOf(i10)));
            a();
        }
        invalidateSelf();
    }
}

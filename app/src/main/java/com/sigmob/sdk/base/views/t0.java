package com.sigmob.sdk.base.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: classes4.dex */
public class t0 extends View {

    /* renamed from: a */
    public Paint f18905a;

    /* renamed from: b */
    public Path f18906b;

    /* renamed from: c */
    public int f18907c;

    /* renamed from: d */
    public RectF f18908d;

    /* renamed from: e */
    public RectF f18909e;

    /* renamed from: f */
    public RectF f18910f;

    /* renamed from: g */
    public int f18911g;

    /* renamed from: h */
    public int f18912h;

    public t0(Context context) {
        super(context);
    }

    public final void a(Canvas canvas) {
        this.f18906b.reset();
        this.f18905a.setColor(-1);
        this.f18905a.setStyle(Paint.Style.FILL);
        Path path = this.f18906b;
        RectF rectF = this.f18910f;
        float f10 = this.f18911g;
        path.addRoundRect(rectF, f10, f10, Path.Direction.CW);
        Path path2 = this.f18906b;
        RectF rectF2 = this.f18909e;
        float f11 = this.f18912h;
        Path.Direction direction = Path.Direction.CCW;
        path2.addRoundRect(rectF2, f11, f11, direction);
        Path path3 = this.f18906b;
        RectF rectF3 = this.f18908d;
        float f12 = this.f18912h;
        path3.addRoundRect(rectF3, f12, f12, direction);
        this.f18906b.close();
        canvas.drawPath(this.f18906b, this.f18905a);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        a();
    }

    public t0(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void a() {
        this.f18905a = new Paint();
        this.f18906b = new Path();
        int width = getWidth();
        int height = getHeight();
        int dipsToIntPixels = Dips.dipsToIntPixels(1.0f, getContext());
        float f10 = dipsToIntPixels;
        this.f18905a.setStrokeWidth(f10);
        float f11 = width;
        float f12 = f11 / (100.0f * f10);
        this.f18911g = (int) (15.0f * f12);
        this.f18912h = (int) (6.0f * f12);
        this.f18907c = Math.max((int) (f12 * f10 * 3.0f), dipsToIntPixels * 2);
        float f13 = height;
        float f14 = 0.4f * f13;
        float f15 = (10.0f * f14) / 16.0f;
        float f16 = (f11 - f15) / 2.0f;
        float f17 = (f13 - f14) / 2.0f;
        this.f18910f = new RectF(f16, f17, f15 + f16, f14 + f17);
        RectF rectF = this.f18910f;
        float f18 = rectF.left;
        float f19 = this.f18907c;
        this.f18909e = new RectF(f18 + f19, rectF.top + f19, rectF.right - f19, rectF.bottom - (r3 * 3));
        RectF rectF2 = this.f18910f;
        float f20 = rectF2.left;
        float width2 = rectF2.width();
        float f21 = this.f18907c * 2;
        float f22 = f20 + ((width2 - f21) / 2.2f);
        RectF rectF3 = this.f18910f;
        this.f18908d = new RectF(f22, rectF3.bottom - f21, rectF3.right - ((rectF3.width() - (r6 * 2)) / 2.2f), this.f18910f.bottom - this.f18907c);
    }

    public t0(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}

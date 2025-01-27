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
public class s0 extends View {

    /* renamed from: a */
    public Paint f18897a;

    /* renamed from: b */
    public Path f18898b;

    /* renamed from: c */
    public int f18899c;

    /* renamed from: d */
    public RectF f18900d;

    /* renamed from: e */
    public RectF f18901e;

    /* renamed from: f */
    public RectF f18902f;

    public s0(Context context) {
        super(context);
    }

    public final void a(Canvas canvas, RectF rectF) {
        this.f18898b.reset();
        this.f18897a.setColor(-1);
        this.f18897a.setStyle(Paint.Style.STROKE);
        this.f18898b.addArc(this.f18901e, 90.0f, 180.0f);
        canvas.drawPath(this.f18898b, this.f18897a);
    }

    public final void b(Canvas canvas, RectF rectF) {
        this.f18898b.reset();
        this.f18897a.setColor(-1);
        this.f18897a.setStyle(Paint.Style.STROKE);
        this.f18898b.addArc(this.f18902f, 90.0f, -180.0f);
        canvas.drawPath(this.f18898b, this.f18897a);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas, this.f18900d);
        b(canvas, this.f18900d);
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        a();
    }

    public s0(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void a() {
        this.f18897a = new Paint();
        this.f18898b = new Path();
        float dipsToIntPixels = Dips.dipsToIntPixels(1.0f, getContext());
        this.f18897a.setStrokeWidth(dipsToIntPixels);
        this.f18899c = (int) ((getWidth() / (100.0f * dipsToIntPixels)) * dipsToIntPixels * 20.0f);
        int width = getWidth() - this.f18899c;
        int height = getHeight();
        this.f18897a.setStyle(Paint.Style.STROKE);
        this.f18897a.setColor(-1);
        this.f18897a.setAntiAlias(true);
        float f10 = height;
        float f11 = f10 / 2.2f;
        this.f18900d = new RectF(this.f18899c, f11, width / 2, f10 - f11);
        float f12 = this.f18899c;
        RectF rectF = this.f18900d;
        this.f18901e = new RectF(f12, rectF.top, rectF.right, rectF.bottom);
        float width2 = this.f18900d.right + this.f18901e.width();
        RectF rectF2 = this.f18900d;
        this.f18902f = new RectF(width2, rectF2.top, rectF2.right + rectF2.width() + this.f18901e.width(), this.f18900d.bottom);
    }

    public s0(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}

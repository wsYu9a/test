package com.sigmob.sdk.base.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: classes4.dex */
public class j extends View {

    /* renamed from: i */
    public static float f18695i;

    /* renamed from: a */
    public Paint f18696a;

    /* renamed from: b */
    public Path f18697b;

    /* renamed from: c */
    public PointF f18698c;

    /* renamed from: d */
    public float f18699d;

    /* renamed from: e */
    public float f18700e;

    /* renamed from: f */
    public float f18701f;

    /* renamed from: g */
    public boolean f18702g;

    /* renamed from: h */
    public Paint f18703h;

    public j(Context context) {
        super(context);
        b();
    }

    public final void a() {
        double d10 = 0.62831855f;
        this.f18699d = ((this.f18700e / 2.0f) * ((float) Math.tan(d10))) / ((float) Math.sin(d10));
        this.f18698c = new PointF(this.f18700e / 2.0f, this.f18699d + Dips.dipsToIntPixels(30.0f, getContext()));
        this.f18697b = new Path();
        PointF pointF = this.f18698c;
        float f10 = pointF.x;
        float f11 = this.f18699d;
        float f12 = pointF.y;
        this.f18697b.addArc(new RectF(f10 - f11, f12 - f11, f10 + f11, f12 + f11), 0.0f, -180.0f);
    }

    public final void b() {
        this.f18696a = new Paint();
        this.f18703h = new Paint();
        f18695i = Dips.dipsToIntPixels(6.0f, getContext());
        this.f18696a.setColor(-1);
        this.f18696a.setStrokeWidth(f18695i);
        this.f18696a.setStyle(Paint.Style.STROKE);
        this.f18696a.setAntiAlias(true);
        this.f18703h.setAntiAlias(true);
        this.f18703h.setColor(-16777216);
        this.f18703h.setStyle(Paint.Style.FILL);
        this.f18703h.setAlpha(51);
    }

    public float getLineWidth() {
        return this.f18696a.getStrokeWidth();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f18702g) {
            canvas.drawPath(this.f18697b, this.f18703h);
        }
        canvas.drawPath(this.f18697b, this.f18696a);
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f18700e = i10;
        this.f18701f = i11;
        a();
    }

    public void setLineWidth(float f10) {
        this.f18696a.setStrokeWidth(f10);
        invalidate();
    }

    public j(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public void a(boolean z10) {
        this.f18702g = z10;
    }

    public j(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        b();
    }
}

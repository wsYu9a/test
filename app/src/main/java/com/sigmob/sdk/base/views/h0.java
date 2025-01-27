package com.sigmob.sdk.base.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: classes4.dex */
public class h0 extends View {

    /* renamed from: a */
    public int f18668a;

    /* renamed from: b */
    public int f18669b;

    /* renamed from: c */
    public Paint f18670c;

    /* renamed from: d */
    public Path f18671d;

    public h0(Context context) {
        super(context);
        a();
    }

    public final void a() {
    }

    public final void b() {
        int width = getWidth();
        int height = getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        this.f18668a = Dips.dipsToIntPixels(5.0f, getContext());
        this.f18669b = height / 2;
        this.f18671d = new Path();
        Paint paint = new Paint(1);
        this.f18670c = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f18670c.setStrokeWidth(this.f18668a);
        this.f18670c.setColor(-1);
        a(this.f18671d, new PointF(width / 2, this.f18669b));
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.f18671d, this.f18670c);
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        b();
    }

    public h0(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public final void a(Path path, PointF pointF) {
        float tan = (float) (pointF.x - (this.f18669b * Math.tan(2.0943951023931953d)));
        float f10 = pointF.y;
        int i10 = this.f18669b;
        float f11 = f10 + i10;
        float tan2 = (float) (pointF.x + (i10 * Math.tan(2.0943951023931953d)));
        float f12 = pointF.y + this.f18669b;
        path.moveTo(tan, f11);
        path.lineTo(pointF.x, pointF.y);
        path.lineTo(tan2, f12);
    }

    public h0(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        a();
    }
}

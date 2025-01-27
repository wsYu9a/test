package com.sigmob.sdk.base.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: classes4.dex */
public class e extends View {

    /* renamed from: a */
    public Paint f18526a;

    /* renamed from: b */
    public Paint f18527b;

    /* renamed from: c */
    public Paint f18528c;

    /* renamed from: d */
    public Paint f18529d;

    /* renamed from: e */
    public Path f18530e;

    /* renamed from: f */
    public Path f18531f;

    /* renamed from: g */
    public Path f18532g;

    /* renamed from: h */
    public Path f18533h;

    /* renamed from: i */
    public RectF f18534i;

    /* renamed from: j */
    public float f18535j;

    /* renamed from: k */
    public float f18536k;

    /* renamed from: l */
    public float f18537l;

    /* renamed from: m */
    public PointF f18538m;

    /* renamed from: n */
    public int f18539n;

    /* renamed from: o */
    public PointF f18540o;

    /* renamed from: p */
    public PointF f18541p;

    /* renamed from: q */
    public PathMeasure f18542q;

    /* renamed from: r */
    public PathMeasure f18543r;

    /* renamed from: s */
    public float f18544s;

    /* renamed from: t */
    public Path f18545t;

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            e.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            e.this.a();
        }
    }

    public e(Context context) {
        super(context);
        this.f18544s = 0.2f;
        Paint paint = new Paint(1);
        this.f18526a = paint;
        paint.setColor(-3355444);
        Paint paint2 = this.f18526a;
        Paint.Style style = Paint.Style.STROKE;
        paint2.setStyle(style);
        Paint paint3 = new Paint(1);
        this.f18527b = paint3;
        paint3.setColor(-1);
        this.f18527b.setStyle(style);
        Paint paint4 = new Paint(1);
        this.f18528c = paint4;
        paint4.setColor(-1);
        this.f18528c.setStyle(style);
        Paint paint5 = new Paint(1);
        this.f18529d = paint5;
        paint5.setColor(-3355444);
        this.f18529d.setStyle(Paint.Style.FILL);
        this.f18545t = new Path();
        this.f18530e = new Path();
        this.f18531f = new Path();
        this.f18532g = new Path();
        this.f18533h = new Path();
        this.f18542q = new PathMeasure();
        this.f18543r = new PathMeasure();
        b();
    }

    public final void b(Path path, PointF pointF, PointF pointF2, float f10) {
        float f11 = (pointF2.y - pointF.y) / (pointF2.x - pointF.x);
        float f12 = 0.5f * f10;
        double d10 = f11;
        PointF pointF3 = new PointF(pointF2.x + (((float) Math.sin(1.5707963267948966d - Math.atan(d10))) * f12), pointF2.y + (((float) Math.cos(1.5707963267948966d - Math.atan(d10))) * f12));
        PointF pointF4 = new PointF(pointF2.x - (((float) Math.sin(1.5707963267948966d - Math.atan(d10))) * f12), pointF2.y - (f12 * ((float) Math.cos(1.5707963267948966d - Math.atan(d10)))));
        double d11 = 1.0f / f11;
        PointF pointF5 = new PointF(pointF4.x + (((float) Math.sin(Math.atan(d11) + 2.0943951023931953d)) * f10), pointF4.y + (f10 * ((float) Math.cos(Math.atan(d11) + 2.0943951023931953d))));
        path.moveTo(pointF3.x, pointF3.y);
        path.lineTo(pointF4.x, pointF4.y);
        path.lineTo(pointF5.x, pointF5.y);
        path.close();
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Paint paint;
        int i10;
        super.onDraw(canvas);
        if (this.f18534i == null) {
            return;
        }
        double degrees = Math.toDegrees(this.f18536k);
        float f10 = (float) (180.0d - (2.0d * degrees));
        canvas.drawArc(this.f18534i, (float) (degrees + 180.0d), f10, false, this.f18526a);
        this.f18530e.reset();
        this.f18530e.lineTo(0.0f, 0.0f);
        this.f18545t.reset();
        this.f18545t.lineTo(0.0f, 0.0f);
        this.f18530e.arcTo(this.f18534i, -90.0f, (-f10) / 2.0f, true);
        this.f18542q.setPath(this.f18530e, false);
        this.f18542q.getSegment(0.0f, this.f18542q.getLength() * this.f18544s, this.f18545t, true);
        canvas.drawPath(this.f18545t, this.f18527b);
        this.f18531f.reset();
        this.f18531f.lineTo(0.0f, 0.0f);
        this.f18545t.reset();
        this.f18545t.lineTo(0.0f, 0.0f);
        this.f18531f.arcTo(this.f18534i, -90.0f, f10 / 2.0f, true);
        this.f18543r.setPath(this.f18531f, false);
        this.f18543r.getSegment(0.0f, this.f18543r.getLength() * this.f18544s, this.f18545t, true);
        canvas.drawPath(this.f18545t, this.f18528c);
        if (this.f18544s == 1.0f) {
            paint = this.f18529d;
            i10 = -1;
        } else {
            paint = this.f18529d;
            i10 = -3355444;
        }
        paint.setColor(i10);
        this.f18532g.reset();
        this.f18532g.lineTo(0.0f, 0.0f);
        a(this.f18532g, this.f18538m, this.f18540o, this.f18537l);
        canvas.drawPath(this.f18532g, this.f18529d);
        this.f18533h.reset();
        this.f18533h.lineTo(0.0f, 0.0f);
        b(this.f18533h, this.f18538m, this.f18541p, this.f18537l);
        canvas.drawPath(this.f18533h, this.f18529d);
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        b();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
    }

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18544s = 0.2f;
        b();
    }

    public final void a(Path path, PointF pointF, PointF pointF2, float f10) {
        float f11 = (pointF2.y - pointF.y) / (pointF2.x - pointF.x);
        float f12 = 0.5f * f10;
        double d10 = f11;
        PointF pointF3 = new PointF(pointF2.x + (((float) Math.sin(1.5707963267948966d - Math.atan(d10))) * f12), pointF2.y + (((float) Math.cos(1.5707963267948966d - Math.atan(d10))) * f12));
        PointF pointF4 = new PointF(pointF2.x - (((float) Math.sin(1.5707963267948966d - Math.atan(d10))) * f12), pointF2.y - (f12 * ((float) Math.cos(1.5707963267948966d - Math.atan(d10)))));
        double d11 = 1.0f / f11;
        PointF pointF5 = new PointF(pointF4.x - (((float) Math.sin(1.0471975511965976d - Math.atan(d11))) * f10), pointF4.y + (f10 * ((float) Math.cos(1.0471975511965976d - Math.atan(d11)))));
        path.moveTo(pointF3.x, pointF3.y);
        path.lineTo(pointF4.x, pointF4.y);
        path.lineTo(pointF5.x, pointF5.y);
        path.close();
    }

    public final void b() {
        getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    public e(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f18544s = 0.2f;
        b();
    }

    public final void a() {
        int height = getHeight();
        int width = getWidth();
        if (height == 0 || width == 0) {
            return;
        }
        int dipsToIntPixels = Dips.dipsToIntPixels(1.0f, getContext());
        float f10 = height;
        float f11 = dipsToIntPixels;
        float f12 = f10 / (100.0f * f11);
        float max = Math.max((int) (f12 * 3.0f * f11), dipsToIntPixels * 2);
        this.f18535j = max;
        this.f18539n = (int) (f12 * (0.4f / f12) * f10);
        this.f18536k = 0.7853982f;
        this.f18537l = 3.0f * max;
        this.f18527b.setStrokeWidth(max);
        this.f18526a.setStrokeWidth(this.f18535j);
        this.f18528c.setStrokeWidth(this.f18535j);
        float f13 = f10 / 2.0f;
        float f14 = f13 - ((this.f18537l * f10) / this.f18539n);
        this.f18538m = new PointF(width / 2.0f, f13);
        PointF pointF = this.f18538m;
        float f15 = pointF.x;
        float f16 = pointF.y;
        this.f18534i = new RectF(f15 - f14, f16 - f14, f15 + f14, f16 + f14);
        this.f18540o = new PointF(this.f18538m.x - ((float) (Math.cos(this.f18536k) * (this.f18534i.width() / 2.0f))), this.f18538m.y - ((float) (Math.sin(this.f18536k) * (this.f18534i.height() / 2.0f))));
        this.f18541p = new PointF(this.f18538m.x + ((float) (Math.cos(this.f18536k) * (this.f18534i.width() / 2.0f))), this.f18538m.y - ((float) (Math.sin(this.f18536k) * (this.f18534i.height() / 2.0f))));
    }

    public void a(float f10) {
        this.f18544s = f10;
        invalidate();
    }
}

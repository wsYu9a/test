package com.sigmob.sdk.base.views;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.czhj.sdk.common.utils.Dips;
import com.sigmob.sdk.base.common.y;

/* loaded from: classes4.dex */
public class l0 extends View {

    /* renamed from: a */
    public Paint f18737a;

    /* renamed from: b */
    public Paint f18738b;

    /* renamed from: c */
    public RectF f18739c;

    /* renamed from: d */
    public RectF f18740d;

    /* renamed from: e */
    public float f18741e;

    /* renamed from: f */
    public Float f18742f;

    /* renamed from: g */
    public float f18743g;

    /* renamed from: h */
    public Paint f18744h;

    /* renamed from: i */
    public float f18745i;

    /* renamed from: j */
    public PointF f18746j;

    /* renamed from: k */
    public Path f18747k;

    /* renamed from: l */
    public Paint f18748l;

    /* renamed from: m */
    public int f18749m;

    /* renamed from: n */
    public int f18750n;

    /* renamed from: o */
    public float f18751o;

    /* renamed from: p */
    public float f18752p;

    /* renamed from: q */
    public PointF f18753q;

    /* renamed from: r */
    public float f18754r;

    /* renamed from: s */
    public float f18755s;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l0.this.a();
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            l0.this.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public l0(Context context) {
        super(context);
        this.f18741e = 0.0f;
        this.f18743g = 3.0f;
        a(context);
    }

    public final void b() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new b());
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ofFloat.setDuration(y.f.f18076n);
        ofFloat.start();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f18748l == null) {
            return;
        }
        this.f18747k.reset();
        a(this.f18747k, this.f18746j);
        canvas.drawPath(this.f18747k, this.f18748l);
        this.f18747k.reset();
        a(this.f18747k, this.f18753q);
        canvas.drawPath(this.f18747k, this.f18748l);
        float f10 = this.f18743g;
        float f11 = this.f18749m;
        float f12 = this.f18751o;
        float f13 = this.f18752p;
        float f14 = (f11 - f12) - f13;
        this.f18739c.set(f10, f14, this.f18750n - f10, (f12 + f14) - (f13 * 2.0f));
        RectF rectF = this.f18739c;
        float f15 = this.f18752p;
        canvas.drawRoundRect(rectF, f15, f15, this.f18737a);
        float f16 = this.f18741e;
        float f17 = f16 > 0.98f ? this.f18743g - this.f18752p : this.f18743g + ((1.0f - f16) * this.f18751o);
        Log.d("", "onDraw: " + f17);
        float f18 = f17 + f14;
        float f19 = this.f18751o + f14;
        float f20 = this.f18743g;
        float f21 = f19 + f20;
        if (this.f18741e > 0.2f) {
            f21 = f19 - f20;
        }
        this.f18740d.set(f10 + this.f18752p, f18, this.f18750n - f20, f21);
        canvas.drawRect(this.f18740d, this.f18738b);
        float min = Math.min(this.f18754r * Dips.dipsToIntPixels(3.0f, getContext()), this.f18743g);
        int i10 = this.f18750n;
        float f22 = i10 > 0 ? i10 / 5 : this.f18743g;
        float f23 = (i10 - f22) / 2.0f;
        float f24 = ((f14 + this.f18751o) - min) - this.f18743g;
        canvas.drawRect(f23, f24, f23 + f22, f24 + min, this.f18744h);
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f18749m = i11;
        this.f18750n = i10;
        a();
    }

    public l0(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18741e = 0.0f;
        this.f18743g = 3.0f;
        a(context);
    }

    public final void a(Path path, PointF pointF) {
        float tan = (float) (pointF.x - (this.f18745i * Math.tan(0.7853981633974483d)));
        float f10 = pointF.y;
        float f11 = this.f18745i;
        float f12 = f10 + f11;
        float tan2 = (float) (pointF.x + (f11 * Math.tan(0.7853981633974483d)));
        float f13 = pointF.y + this.f18745i;
        path.moveTo(tan, f12);
        path.lineTo(pointF.x, pointF.y);
        path.lineTo(tan2, f13);
        path.lineTo(pointF.x, pointF.y + (this.f18745i / 2.0f));
        path.close();
    }

    public l0(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f18741e = 0.0f;
        this.f18743g = 3.0f;
        a(context);
    }

    public final void a() {
        if (this.f18737a == null) {
            Paint paint = new Paint(1);
            this.f18737a = paint;
            paint.setColor(-1);
            this.f18737a.setStyle(Paint.Style.STROKE);
            float dipsToIntPixels = Dips.dipsToIntPixels(this.f18743g, getContext());
            this.f18743g = dipsToIntPixels;
            this.f18737a.setStrokeWidth(dipsToIntPixels);
            Paint paint2 = new Paint(1);
            this.f18738b = paint2;
            paint2.setColor(-3355444);
            Paint paint3 = this.f18738b;
            Paint.Style style = Paint.Style.FILL;
            paint3.setStyle(style);
            Paint paint4 = new Paint(1);
            this.f18744h = paint4;
            paint4.setColor(-1);
            this.f18744h.setStyle(style);
            float dipsToIntPixels2 = (this.f18749m * 1.0f) / Dips.dipsToIntPixels(92.0f, getContext());
            this.f18754r = dipsToIntPixels2;
            this.f18745i = dipsToIntPixels2 * Dips.dipsToIntPixels(11.0f, getContext());
            this.f18739c = new RectF();
            this.f18740d = new RectF();
            this.f18746j = new PointF(getWidth() / 2, 0.0f);
            this.f18753q = new PointF(getWidth() / 2, this.f18745i);
            this.f18747k = new Path();
            Paint paint5 = new Paint(1);
            this.f18748l = paint5;
            paint5.setStyle(style);
            this.f18748l.setColor(-1);
            this.f18751o = this.f18749m - (this.f18745i * 3.0f);
            this.f18752p = this.f18743g / 2.0f;
        }
    }

    public final void a(Context context) {
        com.sigmob.sdk.base.utils.e.a(this, new a());
    }

    public void a(float f10) {
        if (this.f18748l == null) {
            return;
        }
        float max = Math.max(0.2f, f10);
        this.f18741e = max;
        float min = Math.min(1.0f, max);
        this.f18741e = min;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "rotationX", min * 40.0f, f10 * 40.0f);
        ofFloat.setDuration(50L);
        ofFloat.start();
        this.f18748l.setAlpha((int) (this.f18741e * 255.0f));
        invalidate();
    }
}

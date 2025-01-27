package com.sigmob.sdk.base.views;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
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
public class j0 extends View {

    /* renamed from: a */
    public Paint f18704a;

    /* renamed from: b */
    public Paint f18705b;

    /* renamed from: c */
    public RectF f18706c;

    /* renamed from: d */
    public RectF f18707d;

    /* renamed from: e */
    public float f18708e;

    /* renamed from: f */
    public Float f18709f;

    /* renamed from: g */
    public float f18710g;

    /* renamed from: h */
    public Paint f18711h;

    /* renamed from: i */
    public float f18712i;

    /* renamed from: j */
    public PointF f18713j;

    /* renamed from: k */
    public Path f18714k;

    /* renamed from: l */
    public Paint f18715l;

    /* renamed from: m */
    public int f18716m;

    /* renamed from: n */
    public int f18717n;

    /* renamed from: o */
    public float f18718o;

    /* renamed from: p */
    public float f18719p;

    /* renamed from: q */
    public float f18720q;

    /* renamed from: r */
    public PointF f18721r;

    /* renamed from: s */
    public float f18722s;

    /* renamed from: t */
    public float f18723t;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            j0.this.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public j0(Context context) {
        super(context);
        this.f18708e = 0.0f;
        this.f18710g = 1.0f;
    }

    public final void a(Path path, PointF pointF) {
        float tan = (float) (pointF.x - (this.f18712i * Math.tan(0.7853981633974483d)));
        float f10 = pointF.y;
        float f11 = this.f18712i;
        float f12 = f10 + f11;
        float tan2 = (float) (pointF.x + (f11 * Math.tan(0.7853981633974483d)));
        float f13 = pointF.y + this.f18712i;
        path.moveTo(tan, f12);
        path.lineTo(pointF.x, pointF.y);
        path.lineTo(tan2, f13);
        path.lineTo(pointF.x, pointF.y + (this.f18712i / 2.0f));
        path.close();
    }

    public final void b() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new a());
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ofFloat.setDuration(y.f.f18076n);
        ofFloat.start();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f18704a == null) {
            return;
        }
        this.f18714k.reset();
        a(this.f18714k, this.f18713j);
        canvas.drawPath(this.f18714k, this.f18715l);
        this.f18714k.reset();
        a(this.f18714k, this.f18721r);
        canvas.drawPath(this.f18714k, this.f18715l);
        float f10 = this.f18717n / 2;
        float f11 = this.f18719p;
        float f12 = f10 - (f11 / 2.0f);
        float f13 = this.f18716m;
        float f14 = this.f18718o;
        float f15 = this.f18720q;
        float f16 = this.f18710g;
        float f17 = ((f13 - f14) - f15) - (15.0f * f16);
        this.f18706c.set(f12 + f15, f17, (f11 + f12) - f15, f14 + f17 + f16);
        RectF rectF = this.f18706c;
        float f18 = this.f18720q;
        canvas.drawRoundRect(rectF, f18, f18, this.f18704a);
        float f19 = this.f18708e;
        float f20 = f19 > 0.98f ? this.f18710g : this.f18710g + ((1.0f - f19) * this.f18718o);
        Log.d("", "onDraw: " + f20);
        float f21 = f20 + f17;
        float f22 = this.f18706c.bottom;
        float f23 = this.f18710g;
        float f24 = f22 - f23;
        if (f21 >= f24) {
            f21 = f24;
        }
        this.f18707d.set(this.f18720q + f12, f21, (f12 + this.f18719p) - (f23 * 2.0f), f22);
        canvas.drawRect(this.f18707d, this.f18705b);
        float min = Math.min(this.f18722s * Dips.dipsToIntPixels(3.0f, getContext()), this.f18710g * 2.0f);
        float f25 = this.f18719p;
        float f26 = f25 > 0.0f ? f25 / 5.0f : this.f18710g * 3.0f;
        float f27 = (this.f18717n - f26) / 2.0f;
        float f28 = this.f18718o;
        float f29 = (f17 + f28) - (f28 / 4.0f);
        canvas.drawRect(f27, f29, f27 + f26, f29 + min, this.f18711h);
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f18716m = i11;
        this.f18717n = i10;
        a();
    }

    public j0(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18708e = 0.0f;
        this.f18710g = 1.0f;
    }

    public final void a() {
        Paint paint = new Paint(1);
        this.f18704a = paint;
        paint.setColor(-1);
        this.f18704a.setStyle(Paint.Style.STROKE);
        float dipsToIntPixels = Dips.dipsToIntPixels(1.0f, getContext());
        this.f18710g = dipsToIntPixels;
        this.f18704a.setStrokeWidth((this.f18716m / (dipsToIntPixels * 100.0f)) * 3.0f * dipsToIntPixels);
        Paint paint2 = new Paint(1);
        this.f18705b = paint2;
        paint2.setColor(Color.parseColor("#B7B7B7"));
        Paint paint3 = this.f18705b;
        Paint.Style style = Paint.Style.FILL;
        paint3.setStyle(style);
        Paint paint4 = new Paint(1);
        this.f18711h = paint4;
        paint4.setColor(-1);
        this.f18711h.setStyle(style);
        int dipsToIntPixels2 = Dips.dipsToIntPixels(92.0f, getContext());
        float f10 = this.f18716m;
        float f11 = (1.0f * f10) / dipsToIntPixels2;
        this.f18722s = f11;
        float f12 = this.f18710g;
        this.f18712i = f11 * (f10 / (100.0f * f12)) * 11.0f * f12;
        this.f18706c = new RectF();
        this.f18707d = new RectF();
        this.f18713j = new PointF(getWidth() / 2, this.f18710g * 15.0f);
        this.f18721r = new PointF(getWidth() / 2, this.f18712i + (this.f18710g * 15.0f));
        this.f18714k = new Path();
        Paint paint5 = new Paint(1);
        this.f18715l = paint5;
        paint5.setStyle(style);
        this.f18715l.setColor(-1);
        float f13 = this.f18716m - (this.f18712i * 3.0f);
        float f14 = this.f18710g;
        float f15 = f13 - ((15.0f * f14) * 2.0f);
        this.f18718o = f15;
        this.f18719p = (f15 / 60.0f) * 55.0f;
        this.f18720q = f14 * 2.0f;
    }

    public j0(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f18708e = 0.0f;
        this.f18710g = 1.0f;
    }

    public void a(float f10) {
        if (this.f18715l != null) {
            float max = Math.max(0.0f, f10);
            this.f18708e = max;
            float min = Math.min(1.0f, max);
            this.f18708e = min;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "rotationX", min * 40.0f, f10 * 40.0f);
            ofFloat.setDuration(50L);
            ofFloat.start();
            this.f18715l.setAlpha((int) (this.f18708e * 255.0f));
            invalidate();
        }
    }
}

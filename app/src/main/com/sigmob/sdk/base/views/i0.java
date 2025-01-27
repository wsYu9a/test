package com.sigmob.sdk.base.views;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: classes4.dex */
public class i0 extends View {

    /* renamed from: a */
    public float f18680a;

    /* renamed from: b */
    public Paint f18681b;

    /* renamed from: c */
    public Paint f18682c;

    /* renamed from: d */
    public Paint f18683d;

    /* renamed from: e */
    public Path f18684e;

    /* renamed from: f */
    public Path f18685f;

    /* renamed from: g */
    public Path f18686g;

    /* renamed from: h */
    public PointF f18687h;

    /* renamed from: i */
    public PointF f18688i;

    /* renamed from: j */
    public PointF f18689j;

    /* renamed from: k */
    public float f18690k;

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        public final /* synthetic */ PointF f18691a;

        public a(PointF pointF) {
            this.f18691a = pointF;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f18691a.y = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            i0.this.c();
            i0.this.invalidate();
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        public final /* synthetic */ Paint f18693a;

        public b(Paint paint) {
            this.f18693a = paint;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f18693a.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
            i0.this.invalidate();
        }
    }

    public i0(Context context) {
        super(context);
        a();
    }

    public void b() {
        AnimatorSet a10 = a(this.f18687h, this.f18681b, 2);
        AnimatorSet a11 = a(this.f18688i, this.f18682c, 2);
        AnimatorSet a12 = a(this.f18689j, this.f18683d, 2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(a10, a11, a12);
        animatorSet.start();
    }

    public final void c() {
        this.f18684e.reset();
        this.f18685f.reset();
        this.f18686g.reset();
        a(this.f18684e, this.f18687h);
        a(this.f18685f, this.f18688i);
        a(this.f18686g, this.f18689j);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.f18684e, this.f18681b);
        canvas.drawPath(this.f18685f, this.f18682c);
        canvas.drawPath(this.f18686g, this.f18683d);
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        float f10 = i10 / 2.0f;
        float f11 = i11;
        float dipsToIntPixels = Dips.dipsToIntPixels(13.0f, getContext());
        this.f18687h = new PointF(f10, this.f18680a + f11);
        this.f18688i = new PointF(f10, this.f18680a + f11 + dipsToIntPixels);
        this.f18689j = new PointF(f10, f11 + this.f18680a + (dipsToIntPixels * 2.0f));
        c();
        b();
    }

    public i0(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public final AnimatorSet a(PointF pointF, Paint paint, int i10) {
        int alpha = paint.getAlpha();
        float f10 = pointF.y;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f10, (f10 - getHeight()) - this.f18680a);
        ofFloat.addUpdateListener(new a(pointF));
        ofFloat.setRepeatCount(-1);
        ValueAnimator ofInt = ValueAnimator.ofInt(alpha, 0);
        ofInt.addUpdateListener(new b(paint));
        ofInt.setRepeatCount(-1);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(i10 * 1000);
        animatorSet.setInterpolator(new LinearInterpolator());
        animatorSet.playTogether(ofFloat, ofInt);
        return animatorSet;
    }

    public i0(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        a();
    }

    public final void a(Path path, PointF pointF) {
        float tan = (float) (pointF.x - (this.f18690k * Math.tan(2.0943951023931953d)));
        float f10 = pointF.y;
        float f11 = this.f18690k;
        float f12 = f10 + f11;
        float tan2 = (float) (pointF.x + (f11 * Math.tan(2.0943951023931953d)));
        float f13 = pointF.y + this.f18690k;
        path.moveTo(tan, f12);
        path.lineTo(pointF.x, pointF.y);
        path.lineTo(tan2, f13);
    }

    public final void a() {
        float dipsToIntPixels = Dips.dipsToIntPixels(5.0f, getContext());
        this.f18680a = dipsToIntPixels;
        this.f18690k = dipsToIntPixels * 2.0f;
        Paint paint = new Paint(1);
        this.f18681b = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.f18681b.setStrokeWidth(this.f18680a);
        this.f18681b.setColor(-1);
        this.f18681b.setAlpha(255);
        Paint paint2 = new Paint(1);
        this.f18682c = paint2;
        paint2.setStyle(style);
        this.f18682c.setStrokeWidth(this.f18680a);
        this.f18682c.setColor(-1);
        this.f18682c.setAlpha(127);
        Paint paint3 = new Paint(1);
        this.f18683d = paint3;
        paint3.setStyle(style);
        this.f18683d.setStrokeWidth(this.f18680a);
        this.f18683d.setColor(-1);
        this.f18683d.setAlpha(76);
        this.f18684e = new Path();
        this.f18685f = new Path();
        this.f18686g = new Path();
    }
}

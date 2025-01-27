package com.sigmob.sdk.base.views;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import com.czhj.sdk.common.utils.Dips;
import com.martian.libmars.widget.FoldedTextView;

/* loaded from: classes4.dex */
public class a0 extends View {

    /* renamed from: a */
    public Paint f18435a;

    /* renamed from: b */
    public Paint f18436b;

    /* renamed from: c */
    public Paint f18437c;

    /* renamed from: d */
    public Paint f18438d;
    private String description;

    /* renamed from: e */
    public Paint f18439e;

    /* renamed from: f */
    public RectF f18440f;

    /* renamed from: g */
    public RectF f18441g;

    /* renamed from: h */
    public RectF f18442h;

    /* renamed from: i */
    public Path f18443i;

    /* renamed from: j */
    public float f18444j;

    /* renamed from: k */
    public float f18445k;

    /* renamed from: l */
    public float f18446l;

    /* renamed from: m */
    public float f18447m;

    /* renamed from: n */
    public float f18448n;

    /* renamed from: o */
    public float f18449o;

    /* renamed from: p */
    public Handler f18450p;

    /* renamed from: q */
    public int f18451q;

    /* renamed from: r */
    public int f18452r;
    private String title;

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        public final /* synthetic */ RectF f18453a;

        /* renamed from: b */
        public final /* synthetic */ RectF f18454b;

        public a(RectF rectF, RectF rectF2) {
            this.f18453a = rectF;
            this.f18454b = rectF2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            a0.this.a(this.f18453a, this.f18454b, ((Float) valueAnimator.getAnimatedValue()).floatValue());
            a0.this.invalidate();
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        public final /* synthetic */ Paint f18456a;

        public b(Paint paint) {
            this.f18456a = paint;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f18456a.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
            a0.this.invalidate();
        }
    }

    public class c implements Animator.AnimatorListener {

        public class a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ Animator f18459a;

            public a(Animator animator) {
                this.f18459a = animator;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f18459a.start();
            }
        }

        public c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a0.this.f18450p.postDelayed(new a(animator), 300L);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public a0(Context context) {
        super(context);
        this.f18450p = new Handler(Looper.getMainLooper());
        this.f18451q = Color.parseColor("#FF5A57");
        b();
    }

    public final void b() {
        this.f18452r = Dips.dipsToIntPixels(2.0f, getContext());
        Paint paint = new Paint(1);
        this.f18435a = paint;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        this.f18435a.setStrokeWidth(this.f18452r);
        this.f18435a.setColor(-1);
        this.f18448n = Dips.dipsToIntPixels(20.0f, getContext());
        this.f18436b = new Paint(this.f18435a);
        Paint paint2 = new Paint(this.f18435a);
        this.f18437c = paint2;
        paint2.setStyle(style);
        this.f18437c.setColor(this.f18451q);
        Paint paint3 = new Paint(1);
        this.f18438d = paint3;
        paint3.setColor(-1);
        this.f18438d.setTypeface(Typeface.DEFAULT);
        this.f18438d.setTextSize(TypedValue.applyDimension(2, 20.0f, getResources().getDisplayMetrics()));
        Paint paint4 = new Paint(1);
        this.f18439e = paint4;
        paint4.setColor(-1);
        this.f18439e.setAlpha(127);
        this.f18439e.setStyle(style);
        this.f18443i = new Path();
        this.f18440f = new RectF();
        this.f18441g = new RectF();
        this.f18442h = new RectF();
    }

    public void c() {
        Animator a10 = a(this.f18440f, this.f18435a, 1000, 0);
        Animator a11 = a(this.f18441g, this.f18436b, 800, 400);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(a10, a11);
        animatorSet.addListener(new c());
        animatorSet.start();
    }

    public void d() {
        this.f18440f.set(0.0f, 0.0f, getWidth(), getHeight());
        this.f18441g.set(0.0f, 0.0f, getWidth(), getHeight());
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Handler handler = this.f18450p;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.f18440f;
        canvas.drawRoundRect(rectF, rectF.height() / 2.0f, this.f18440f.height() / 2.0f, this.f18435a);
        RectF rectF2 = this.f18441g;
        canvas.drawRoundRect(rectF2, rectF2.height() / 2.0f, this.f18441g.height() / 2.0f, this.f18436b);
        RectF rectF3 = this.f18442h;
        canvas.drawRoundRect(rectF3, rectF3.height() / 2.0f, this.f18442h.height() / 2.0f, this.f18437c);
        float width = (getWidth() / 2) + (this.f18446l / 2.0f) + (this.f18452r * 2);
        if (!TextUtils.isEmpty(this.title)) {
            float width2 = (getWidth() / 2) - (this.f18446l / 2.0f);
            canvas.drawText(this.title, width2, ((getHeight() / 2) - (this.f18447m / 2.0f)) - this.f18438d.ascent(), this.f18438d);
            width = width2 + this.f18438d.measureText(this.title) + (this.f18452r * 2);
        }
        float height = (getHeight() / 2) - (this.f18449o / 2.0f);
        canvas.save();
        canvas.translate(width, height);
        canvas.drawPath(this.f18443i, this.f18439e);
        canvas.restore();
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        float f10 = i10;
        float f11 = f10 / 4.0f;
        this.f18444j = f11;
        float f12 = i11;
        float f13 = f12 / 3.0f;
        this.f18445k = f13;
        float f14 = f11 / 2.0f;
        float f15 = f13 / 2.0f;
        this.f18440f.set(f14, f15, f10 - f14, f12 - f15);
        RectF rectF = this.f18441g;
        float f16 = this.f18444j / 2.0f;
        float f17 = this.f18445k / 2.0f;
        rectF.set(f16, f17, f10 - f16, f12 - f17);
        RectF rectF2 = this.f18442h;
        float f18 = this.f18444j / 2.0f;
        float f19 = this.f18445k / 2.0f;
        rectF2.set(f18, f19, f10 - f18, f12 - f19);
        if (!TextUtils.isEmpty(this.title)) {
            int i14 = 5;
            while (true) {
                if (i14 >= this.title.length()) {
                    break;
                }
                float measureText = this.f18438d.measureText(this.title, 0, i14);
                RectF rectF3 = this.f18440f;
                if (measureText > (rectF3.right - rectF3.left) - (this.f18448n * 4.0f)) {
                    this.title = this.title.substring(0, i14 - 2) + FoldedTextView.f12585y;
                    break;
                }
                i14++;
            }
            this.f18446l = this.f18438d.measureText(this.title);
            this.f18447m = this.f18438d.descent() - this.f18438d.ascent();
        }
        this.f18449o = this.f18447m * 0.6f;
        a();
        c();
    }

    public void setButtonColor(int i10) {
        this.f18451q = i10;
    }

    public a0(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18450p = new Handler(Looper.getMainLooper());
        this.f18451q = Color.parseColor("#FF5A57");
        b();
    }

    public a0(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f18450p = new Handler(Looper.getMainLooper());
        this.f18451q = Color.parseColor("#FF5A57");
        b();
    }

    public final Animator a(RectF rectF, Paint paint, int i10, int i11) {
        AnimatorSet animatorSet = new AnimatorSet();
        RectF rectF2 = new RectF(rectF.left, rectF.top, rectF.right, rectF.bottom);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, Dips.dipsToIntPixels(20.0f, getContext()));
        long j10 = i11;
        ofFloat.setStartDelay(j10);
        ofFloat.setDuration(i10);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.addUpdateListener(new a(rectF2, rectF));
        ValueAnimator ofInt = ValueAnimator.ofInt(255, 0);
        ofInt.setStartDelay(j10);
        ofInt.setDuration((long) (i10 * 0.8f));
        ofInt.setInterpolator(new AccelerateInterpolator());
        ofInt.addUpdateListener(new b(paint));
        animatorSet.playTogether(ofFloat, ofInt);
        return animatorSet;
    }

    public final void a() {
        this.f18443i.reset();
        this.f18443i.moveTo(0.0f, 0.0f);
        this.f18443i.lineTo(0.0f, this.f18449o);
        Path path = this.f18443i;
        float f10 = this.f18449o / 2.0f;
        path.lineTo(f10, f10);
        this.f18443i.close();
    }

    public final void a(RectF rectF, RectF rectF2, float f10) {
        rectF2.left = rectF.left - f10;
        rectF2.top = rectF.top - f10;
        rectF2.right = rectF.right + f10;
        rectF2.bottom = rectF.bottom + f10;
    }

    public void a(String str, String str2) {
        this.title = str;
        this.description = str2;
        invalidate();
    }
}

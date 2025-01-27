package com.vivo.mobilead.lottie.g;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.vivo.mobilead.lottie.LottieComposition;

/* loaded from: classes4.dex */
public class a<T> {

    /* renamed from: a */
    public final T f29463a;

    /* renamed from: b */
    public T f29464b;

    /* renamed from: c */
    public final Interpolator f29465c;

    /* renamed from: d */
    public final float f29466d;

    /* renamed from: e */
    public Float f29467e;

    /* renamed from: f */
    public PointF f29468f;

    /* renamed from: g */
    public PointF f29469g;

    /* renamed from: h */
    private final LottieComposition f29470h;

    /* renamed from: i */
    private float f29471i;

    /* renamed from: j */
    private float f29472j;
    private int k;
    private int l;
    private float m;
    private float n;

    public a(LottieComposition lottieComposition, T t, T t2, Interpolator interpolator, float f2, Float f3) {
        this.f29471i = -3987645.8f;
        this.f29472j = -3987645.8f;
        this.k = 784923401;
        this.l = 784923401;
        this.m = Float.MIN_VALUE;
        this.n = Float.MIN_VALUE;
        this.f29468f = null;
        this.f29469g = null;
        this.f29470h = lottieComposition;
        this.f29463a = t;
        this.f29464b = t2;
        this.f29465c = interpolator;
        this.f29466d = f2;
        this.f29467e = f3;
    }

    public a(T t) {
        this.f29471i = -3987645.8f;
        this.f29472j = -3987645.8f;
        this.k = 784923401;
        this.l = 784923401;
        this.m = Float.MIN_VALUE;
        this.n = Float.MIN_VALUE;
        this.f29468f = null;
        this.f29469g = null;
        this.f29470h = null;
        this.f29463a = t;
        this.f29464b = t;
        this.f29465c = null;
        this.f29466d = Float.MIN_VALUE;
        this.f29467e = Float.valueOf(Float.MAX_VALUE);
    }

    public boolean a(float f2) {
        return f2 >= c() && f2 < d();
    }

    public float c() {
        LottieComposition lottieComposition = this.f29470h;
        if (lottieComposition == null) {
            return 0.0f;
        }
        if (this.m == Float.MIN_VALUE) {
            this.m = (this.f29466d - lottieComposition.getStartFrame()) / this.f29470h.getDurationFrames();
        }
        return this.m;
    }

    public float d() {
        if (this.f29470h == null) {
            return 1.0f;
        }
        if (this.n == Float.MIN_VALUE) {
            if (this.f29467e == null) {
                this.n = 1.0f;
            } else {
                this.n = c() + ((this.f29467e.floatValue() - this.f29466d) / this.f29470h.getDurationFrames());
            }
        }
        return this.n;
    }

    public boolean e() {
        return this.f29465c == null;
    }

    public float f() {
        if (this.f29471i == -3987645.8f) {
            this.f29471i = ((Float) this.f29463a).floatValue();
        }
        return this.f29471i;
    }

    public float g() {
        if (this.f29472j == -3987645.8f) {
            this.f29472j = ((Float) this.f29464b).floatValue();
        }
        return this.f29472j;
    }

    public int h() {
        if (this.k == 784923401) {
            this.k = ((Integer) this.f29463a).intValue();
        }
        return this.k;
    }

    public int i() {
        if (this.l == 784923401) {
            this.l = ((Integer) this.f29464b).intValue();
        }
        return this.l;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.f29463a + ", endValue=" + this.f29464b + ", startFrame=" + this.f29466d + ", endFrame=" + this.f29467e + ", interpolator=" + this.f29465c + '}';
    }
}

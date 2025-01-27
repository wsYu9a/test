package com.vivo.mobilead.lottie.f;

import android.view.Choreographer;
import com.vivo.mobilead.lottie.LottieComposition;

/* loaded from: classes4.dex */
public class e extends a implements Choreographer.FrameCallback {

    /* renamed from: i */
    private LottieComposition f29443i;

    /* renamed from: b */
    private float f29436b = 1.0f;

    /* renamed from: c */
    private boolean f29437c = false;

    /* renamed from: d */
    private long f29438d = 0;

    /* renamed from: e */
    private float f29439e = 0.0f;

    /* renamed from: f */
    private int f29440f = 0;

    /* renamed from: g */
    private float f29441g = -2.1474836E9f;

    /* renamed from: h */
    private float f29442h = 2.1474836E9f;

    /* renamed from: a */
    protected boolean f29435a = false;

    private float q() {
        LottieComposition lottieComposition = this.f29443i;
        if (lottieComposition == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / lottieComposition.getFrameRate()) / Math.abs(this.f29436b);
    }

    private boolean r() {
        return h() < 0.0f;
    }

    private void s() {
        if (this.f29443i == null) {
            return;
        }
        float f2 = this.f29439e;
        if (f2 < this.f29441g || f2 > this.f29442h) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.f29441g), Float.valueOf(this.f29442h), Float.valueOf(this.f29439e)));
        }
    }

    public void a(float f2) {
        a(this.f29441g, f2);
    }

    public void a(float f2, float f3) {
        if (f2 > f3) {
            throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f2), Float.valueOf(f3)));
        }
        LottieComposition lottieComposition = this.f29443i;
        float startFrame = lottieComposition == null ? -3.4028235E38f : lottieComposition.getStartFrame();
        LottieComposition lottieComposition2 = this.f29443i;
        float endFrame = lottieComposition2 == null ? Float.MAX_VALUE : lottieComposition2.getEndFrame();
        this.f29441g = g.b(f2, startFrame, endFrame);
        this.f29442h = g.b(f3, startFrame, endFrame);
        a((int) g.b(this.f29439e, f2, f3));
    }

    public void a(int i2) {
        float f2 = i2;
        if (this.f29439e == f2) {
            return;
        }
        this.f29439e = g.b(f2, m(), n());
        this.f29438d = 0L;
        c();
    }

    public void a(LottieComposition lottieComposition) {
        float startFrame;
        float endFrame;
        boolean z = this.f29443i == null;
        this.f29443i = lottieComposition;
        if (z) {
            startFrame = (int) Math.max(this.f29441g, lottieComposition.getStartFrame());
            endFrame = Math.min(this.f29442h, lottieComposition.getEndFrame());
        } else {
            startFrame = (int) lottieComposition.getStartFrame();
            endFrame = lottieComposition.getEndFrame();
        }
        a(startFrame, (int) endFrame);
        float f2 = this.f29439e;
        this.f29439e = 0.0f;
        a((int) f2);
    }

    public void b(float f2) {
        this.f29436b = f2;
    }

    public void b(int i2) {
        a(i2, (int) this.f29442h);
    }

    protected void c(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.f29435a = false;
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void cancel() {
        b();
        p();
    }

    public float d() {
        LottieComposition lottieComposition = this.f29443i;
        if (lottieComposition == null) {
            return 0.0f;
        }
        return (this.f29439e - lottieComposition.getStartFrame()) / (this.f29443i.getEndFrame() - this.f29443i.getStartFrame());
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j2) {
        o();
        if (this.f29443i == null || !isRunning()) {
            return;
        }
        float q = (this.f29438d != 0 ? j2 - r0 : 0L) / q();
        float f2 = this.f29439e;
        if (r()) {
            q = -q;
        }
        float f3 = f2 + q;
        this.f29439e = f3;
        boolean z = !g.c(f3, m(), n());
        this.f29439e = g.b(this.f29439e, m(), n());
        this.f29438d = j2;
        c();
        if (z) {
            if (getRepeatCount() == -1 || this.f29440f < getRepeatCount()) {
                a();
                this.f29440f++;
                if (getRepeatMode() == 2) {
                    this.f29437c = !this.f29437c;
                    g();
                } else {
                    this.f29439e = r() ? n() : m();
                }
                this.f29438d = j2;
            } else {
                this.f29439e = this.f29436b < 0.0f ? m() : n();
                p();
                b(r());
            }
        }
        s();
    }

    public float e() {
        return this.f29439e;
    }

    public void f() {
        this.f29443i = null;
        this.f29441g = -2.1474836E9f;
        this.f29442h = 2.1474836E9f;
    }

    public void g() {
        b(-h());
    }

    @Override // android.animation.ValueAnimator
    public float getAnimatedFraction() {
        float f2;
        float m;
        if (this.f29443i == null) {
            return 0.0f;
        }
        if (r()) {
            f2 = n();
            m = this.f29439e;
        } else {
            f2 = this.f29439e;
            m = m();
        }
        return (f2 - m) / (n() - m());
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(d());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        LottieComposition lottieComposition = this.f29443i;
        if (lottieComposition == null) {
            return 0L;
        }
        return (long) lottieComposition.getDuration();
    }

    public float h() {
        return this.f29436b;
    }

    public void i() {
        this.f29435a = true;
        a(r());
        a((int) (r() ? n() : m()));
        this.f29438d = 0L;
        this.f29440f = 0;
        o();
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.f29435a;
    }

    public void j() {
        p();
        b(r());
    }

    public void k() {
        p();
    }

    public void l() {
        float m;
        this.f29435a = true;
        o();
        this.f29438d = 0L;
        if (r() && e() == m()) {
            m = n();
        } else if (r() || e() != n()) {
            return;
        } else {
            m = m();
        }
        this.f29439e = m;
    }

    public float m() {
        LottieComposition lottieComposition = this.f29443i;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f2 = this.f29441g;
        return f2 == -2.1474836E9f ? lottieComposition.getStartFrame() : f2;
    }

    public float n() {
        LottieComposition lottieComposition = this.f29443i;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f2 = this.f29442h;
        return f2 == 2.1474836E9f ? lottieComposition.getEndFrame() : f2;
    }

    protected void o() {
        if (isRunning()) {
            c(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    protected void p() {
        c(true);
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i2) {
        super.setRepeatMode(i2);
        if (i2 == 2 || !this.f29437c) {
            return;
        }
        this.f29437c = false;
        g();
    }
}

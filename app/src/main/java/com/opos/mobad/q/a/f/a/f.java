package com.opos.mobad.q.a.f.a;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

/* loaded from: classes4.dex */
public class f {

    /* renamed from: a */
    private ObjectAnimator f23285a;

    /* renamed from: b */
    private ObjectAnimator f23286b;

    /* renamed from: c */
    private AnimatorSet f23287c;

    /* renamed from: d */
    private View f23288d;

    /* renamed from: e */
    private float f23289e;

    /* renamed from: f */
    private float f23290f;

    /* renamed from: g */
    private long f23291g;

    public f(View view, float f2, float f3, long j2) {
        this.f23289e = 1.0f;
        this.f23290f = 1.1f;
        this.f23291g = 1500L;
        this.f23288d = view;
        if (f2 > 0.0f) {
            this.f23289e = f2;
        }
        if (f3 > 0.0f) {
            this.f23290f = f3;
        }
        if (j2 > 0) {
            this.f23291g = j2;
        }
        c();
    }

    private void c() {
        try {
            View view = this.f23288d;
            if (view == null) {
                return;
            }
            float f2 = this.f23289e;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", f2, this.f23290f, f2);
            this.f23285a = ofFloat;
            ofFloat.setRepeatCount(-1);
            View view2 = this.f23288d;
            float f3 = this.f23289e;
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, "scaleY", f3, this.f23290f, f3);
            this.f23286b = ofFloat2;
            ofFloat2.setRepeatCount(-1);
            AnimatorSet animatorSet = new AnimatorSet();
            this.f23287c = animatorSet;
            animatorSet.play(this.f23285a).with(this.f23286b);
            this.f23287c.setDuration(this.f23291g);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("ScaleAnimator", "", (Throwable) e2);
        }
    }

    public void a() {
        try {
            if (this.f23288d == null) {
                return;
            }
            this.f23287c.start();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("ScaleAnimator", "", (Throwable) e2);
        }
    }

    public void b() {
        try {
            if (this.f23288d == null) {
                return;
            }
            this.f23287c.cancel();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("ScaleAnimator", "", (Throwable) e2);
        }
    }
}

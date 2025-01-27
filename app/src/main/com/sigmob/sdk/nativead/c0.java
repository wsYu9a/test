package com.sigmob.sdk.nativead;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;

/* loaded from: classes4.dex */
public class c0 {

    /* renamed from: a */
    public ViewGroup f19934a;

    /* renamed from: b */
    public b0 f19935b;

    /* renamed from: c */
    public b0 f19936c;

    /* renamed from: d */
    public long f19937d;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ViewGroup.LayoutParams layoutParams = c0.this.f19934a.getLayoutParams();
            layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            c0.this.f19934a.setLayoutParams(layoutParams);
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ViewGroup.LayoutParams layoutParams = c0.this.f19934a.getLayoutParams();
            layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            c0.this.f19934a.setLayoutParams(layoutParams);
        }
    }

    public c0(ViewGroup viewGroup, b0 b0Var, b0 b0Var2, long j10) {
        this.f19934a = viewGroup;
        this.f19935b = b0Var;
        this.f19936c = b0Var2;
        this.f19937d = j10;
    }

    public void a() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f19934a, "x", this.f19935b.c(), this.f19936c.c());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f19934a, "y", this.f19935b.d(), this.f19936c.d());
        ValueAnimator ofInt = ValueAnimator.ofInt(this.f19935b.b(), this.f19936c.b());
        ValueAnimator ofInt2 = ValueAnimator.ofInt(this.f19935b.a(), this.f19936c.a());
        ofInt.addUpdateListener(new a());
        ofInt2.addUpdateListener(new b());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2, ofInt, ofInt2);
        animatorSet.setDuration(this.f19937d);
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.start();
    }
}

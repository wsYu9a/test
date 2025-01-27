package com.sigmob.sdk.base.views;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: classes4.dex */
public class i extends FrameLayout {

    /* renamed from: d */
    public static float f18672d = 0.0f;

    /* renamed from: e */
    public static final int f18673e = 1700;

    /* renamed from: a */
    public j f18674a;

    /* renamed from: b */
    public j f18675b;

    /* renamed from: c */
    public j f18676c;

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        public final /* synthetic */ j f18677a;

        public a(j jVar) {
            this.f18677a = jVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f18677a.setLineWidth(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public class b implements Animator.AnimatorListener {
        public b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            animator.start();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public i(Context context) {
        super(context);
        a();
    }

    public final void a() {
        f18672d = Dips.dipsToIntPixels(6.0f, getContext());
        j jVar = new j(getContext());
        this.f18674a = jVar;
        addView(jVar, new ViewGroup.LayoutParams(-1, -1));
        j jVar2 = new j(getContext());
        this.f18675b = jVar2;
        addView(jVar2, new ViewGroup.LayoutParams(-1, -1));
        j jVar3 = new j(getContext());
        this.f18676c = jVar3;
        jVar3.a(true);
        addView(this.f18676c, new ViewGroup.LayoutParams(-1, -1));
        a(this.f18674a, 0);
        a(this.f18675b, 566);
    }

    public i(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public void a(j jVar, int i10) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(jVar, "translationY", 0.0f, Dips.dipsToIntPixels(-30.0f, getContext()));
        ofFloat.setDuration(1700L);
        long j10 = i10;
        ofFloat.setStartDelay(j10);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(jVar, "alpha", 1.0f, 0.1f);
        ofFloat2.setDuration(1700L);
        ofFloat2.setStartDelay(j10);
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(f18672d, Dips.dipsToIntPixels(1.0f, getContext()));
        ofFloat3.addUpdateListener(new a(jVar));
        ofFloat3.setDuration(1360L);
        ofFloat3.setStartDelay(j10 + 340);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        animatorSet.addListener(new b());
        animatorSet.start();
    }

    public i(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        a();
    }
}

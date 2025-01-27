package com.google.android.material.m;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public final class e implements v {

    /* renamed from: a */
    static final float f7529a = 0.35f;

    static class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        final /* synthetic */ View f7530a;

        /* renamed from: b */
        final /* synthetic */ float f7531b;

        /* renamed from: c */
        final /* synthetic */ float f7532c;

        /* renamed from: d */
        final /* synthetic */ float f7533d;

        /* renamed from: e */
        final /* synthetic */ float f7534e;

        a(View view, float f2, float f3, float f4, float f5) {
            this.f7530a = view;
            this.f7531b = f2;
            this.f7532c = f3;
            this.f7533d = f4;
            this.f7534e = f5;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f7530a.setAlpha(u.l(this.f7531b, this.f7532c, this.f7533d, this.f7534e, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
        }
    }

    private static Animator c(View view, float f2, float f3, @FloatRange(from = 0.0d, to = 1.0d) float f4, @FloatRange(from = 0.0d, to = 1.0d) float f5) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new a(view, f2, f3, f4, f5));
        return ofFloat;
    }

    @Override // com.google.android.material.m.v
    @Nullable
    public Animator a(@NonNull ViewGroup viewGroup, @NonNull View view) {
        return c(view, 1.0f, 0.0f, 0.0f, f7529a);
    }

    @Override // com.google.android.material.m.v
    @Nullable
    public Animator b(@NonNull ViewGroup viewGroup, @NonNull View view) {
        return c(view, 0.0f, 1.0f, f7529a, 1.0f);
    }
}

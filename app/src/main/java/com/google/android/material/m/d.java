package com.google.android.material.m;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public final class d implements v {

    /* renamed from: a */
    private float f7523a = 1.0f;

    static class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        final /* synthetic */ View f7524a;

        /* renamed from: b */
        final /* synthetic */ float f7525b;

        /* renamed from: c */
        final /* synthetic */ float f7526c;

        /* renamed from: d */
        final /* synthetic */ float f7527d;

        /* renamed from: e */
        final /* synthetic */ float f7528e;

        a(View view, float f2, float f3, float f4, float f5) {
            this.f7524a = view;
            this.f7525b = f2;
            this.f7526c = f3;
            this.f7527d = f4;
            this.f7528e = f5;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f7524a.setAlpha(u.l(this.f7525b, this.f7526c, this.f7527d, this.f7528e, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
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
        return c(view, 1.0f, 0.0f, 0.0f, 1.0f);
    }

    @Override // com.google.android.material.m.v
    @Nullable
    public Animator b(@NonNull ViewGroup viewGroup, @NonNull View view) {
        return c(view, 0.0f, 1.0f, 0.0f, this.f7523a);
    }

    public float d() {
        return this.f7523a;
    }

    public void e(float f2) {
        this.f7523a = f2;
    }
}

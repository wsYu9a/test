package com.google.android.material.m.w;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class d implements w {

    /* renamed from: a */
    private float f7596a = 1.0f;

    static class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        final /* synthetic */ View f7597a;

        /* renamed from: b */
        final /* synthetic */ float f7598b;

        /* renamed from: c */
        final /* synthetic */ float f7599c;

        /* renamed from: d */
        final /* synthetic */ float f7600d;

        /* renamed from: e */
        final /* synthetic */ float f7601e;

        a(View view, float f2, float f3, float f4, float f5) {
            this.f7597a = view;
            this.f7598b = f2;
            this.f7599c = f3;
            this.f7600d = f4;
            this.f7601e = f5;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f7597a.setAlpha(v.l(this.f7598b, this.f7599c, this.f7600d, this.f7601e, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
        }
    }

    private static Animator c(View view, float f2, float f3, @FloatRange(from = 0.0d, to = 1.0d) float f4, @FloatRange(from = 0.0d, to = 1.0d) float f5) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new a(view, f2, f3, f4, f5));
        return ofFloat;
    }

    @Override // com.google.android.material.m.w.w
    @Nullable
    public Animator a(@NonNull ViewGroup viewGroup, @NonNull View view) {
        return c(view, 1.0f, 0.0f, 0.0f, 1.0f);
    }

    @Override // com.google.android.material.m.w.w
    @Nullable
    public Animator b(@NonNull ViewGroup viewGroup, @NonNull View view) {
        return c(view, 0.0f, 1.0f, 0.0f, this.f7596a);
    }

    public float d() {
        return this.f7596a;
    }

    public void e(float f2) {
        this.f7596a = f2;
    }
}

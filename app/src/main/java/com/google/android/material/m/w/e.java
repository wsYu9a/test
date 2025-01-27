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
public final class e implements w {

    /* renamed from: a */
    static final float f7602a = 0.35f;

    static class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        final /* synthetic */ View f7603a;

        /* renamed from: b */
        final /* synthetic */ float f7604b;

        /* renamed from: c */
        final /* synthetic */ float f7605c;

        /* renamed from: d */
        final /* synthetic */ float f7606d;

        /* renamed from: e */
        final /* synthetic */ float f7607e;

        a(View view, float f2, float f3, float f4, float f5) {
            this.f7603a = view;
            this.f7604b = f2;
            this.f7605c = f3;
            this.f7606d = f4;
            this.f7607e = f5;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f7603a.setAlpha(v.l(this.f7604b, this.f7605c, this.f7606d, this.f7607e, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
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
        return c(view, 1.0f, 0.0f, 0.0f, f7602a);
    }

    @Override // com.google.android.material.m.w.w
    @Nullable
    public Animator b(@NonNull ViewGroup viewGroup, @NonNull View view) {
        return c(view, 0.0f, 1.0f, f7602a, 1.0f);
    }
}

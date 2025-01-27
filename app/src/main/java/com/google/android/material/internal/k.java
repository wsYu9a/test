package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.StateSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<b> f7358a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private b f7359b = null;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    ValueAnimator f7360c = null;

    /* renamed from: d, reason: collision with root package name */
    private final Animator.AnimatorListener f7361d = new a();

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            k kVar = k.this;
            if (kVar.f7360c == animator) {
                kVar.f7360c = null;
            }
        }
    }

    static class b {

        /* renamed from: a, reason: collision with root package name */
        final int[] f7363a;

        /* renamed from: b, reason: collision with root package name */
        final ValueAnimator f7364b;

        b(int[] iArr, ValueAnimator valueAnimator) {
            this.f7363a = iArr;
            this.f7364b = valueAnimator;
        }
    }

    private void b() {
        ValueAnimator valueAnimator = this.f7360c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f7360c = null;
        }
    }

    private void e(@NonNull b bVar) {
        ValueAnimator valueAnimator = bVar.f7364b;
        this.f7360c = valueAnimator;
        valueAnimator.start();
    }

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        b bVar = new b(iArr, valueAnimator);
        valueAnimator.addListener(this.f7361d);
        this.f7358a.add(bVar);
    }

    public void c() {
        ValueAnimator valueAnimator = this.f7360c;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.f7360c = null;
        }
    }

    public void d(int[] iArr) {
        b bVar;
        int size = this.f7358a.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                bVar = null;
                break;
            }
            bVar = this.f7358a.get(i2);
            if (StateSet.stateSetMatches(bVar.f7363a, iArr)) {
                break;
            } else {
                i2++;
            }
        }
        b bVar2 = this.f7359b;
        if (bVar == bVar2) {
            return;
        }
        if (bVar2 != null) {
            b();
        }
        this.f7359b = bVar;
        if (bVar != null) {
            e(bVar);
        }
    }
}

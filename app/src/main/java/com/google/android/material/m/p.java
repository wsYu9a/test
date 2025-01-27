package com.google.android.material.m;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.transition.TransitionValues;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public final class p extends q<v> {
    public static final int Z = 0;
    public static final int a0 = 1;
    public static final int b0 = 2;
    private final int c0;
    private final boolean d0;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface a {
    }

    public p(int i2, boolean z) {
        super(N(i2, z), O());
        this.c0 = i2;
        this.d0 = z;
    }

    private static v N(int i2, boolean z) {
        if (i2 == 0) {
            return new s(z ? 8388613 : 8388611);
        }
        if (i2 == 1) {
            return new s(z ? 80 : 48);
        }
        if (i2 == 2) {
            return new r(z);
        }
        throw new IllegalArgumentException("Invalid axis: " + i2);
    }

    private static v O() {
        return new e();
    }

    @Override // com.google.android.material.m.q
    @NonNull
    public /* bridge */ /* synthetic */ v K() {
        return super.K();
    }

    @Override // com.google.android.material.m.q
    @Nullable
    public /* bridge */ /* synthetic */ v L() {
        return super.L();
    }

    @Override // com.google.android.material.m.q
    public /* bridge */ /* synthetic */ void M(@Nullable v vVar) {
        super.M(vVar);
    }

    public int P() {
        return this.c0;
    }

    public boolean Q() {
        return this.d0;
    }

    @Override // com.google.android.material.m.q, androidx.transition.Visibility
    public /* bridge */ /* synthetic */ Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.onAppear(viewGroup, view, transitionValues, transitionValues2);
    }

    @Override // com.google.android.material.m.q, androidx.transition.Visibility
    public /* bridge */ /* synthetic */ Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.onDisappear(viewGroup, view, transitionValues, transitionValues2);
    }
}

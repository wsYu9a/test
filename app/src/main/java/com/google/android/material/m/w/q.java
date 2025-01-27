package com.google.android.material.m.w;

import android.animation.Animator;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class q extends r<w> {

    /* renamed from: c */
    public static final int f7673c = 0;

    /* renamed from: d */
    public static final int f7674d = 1;

    /* renamed from: e */
    public static final int f7675e = 2;

    /* renamed from: f */
    private final int f7676f;

    /* renamed from: g */
    private final boolean f7677g;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface a {
    }

    public q(int i2, boolean z) {
        super(e(i2, z), f());
        this.f7676f = i2;
        this.f7677g = z;
    }

    private static w e(int i2, boolean z) {
        if (i2 == 0) {
            return new t(z ? 8388613 : 8388611);
        }
        if (i2 == 1) {
            return new t(z ? 80 : 48);
        }
        if (i2 == 2) {
            return new s(z);
        }
        throw new IllegalArgumentException("Invalid axis: " + i2);
    }

    private static w f() {
        return new e();
    }

    @Override // com.google.android.material.m.w.r
    @NonNull
    public /* bridge */ /* synthetic */ w b() {
        return super.b();
    }

    @Override // com.google.android.material.m.w.r
    @Nullable
    public /* bridge */ /* synthetic */ w c() {
        return super.c();
    }

    @Override // com.google.android.material.m.w.r
    public /* bridge */ /* synthetic */ void d(@Nullable w wVar) {
        super.d(wVar);
    }

    public int g() {
        return this.f7676f;
    }

    public boolean h() {
        return this.f7677g;
    }

    @Override // com.google.android.material.m.w.r, android.transition.Visibility
    public /* bridge */ /* synthetic */ Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.onAppear(viewGroup, view, transitionValues, transitionValues2);
    }

    @Override // com.google.android.material.m.w.r, android.transition.Visibility
    public /* bridge */ /* synthetic */ Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.onDisappear(viewGroup, view, transitionValues, transitionValues2);
    }
}

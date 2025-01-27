package com.google.android.material.m.w;

import android.animation.Animator;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class n extends r<s> {

    /* renamed from: c */
    private static final float f7668c = 0.85f;

    /* renamed from: d */
    private final boolean f7669d;

    public n(boolean z) {
        super(e(z), f());
        this.f7669d = z;
    }

    private static s e(boolean z) {
        s sVar = new s(z);
        sVar.m(f7668c);
        sVar.l(f7668c);
        return sVar;
    }

    private static w f() {
        return new d();
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

    public boolean g() {
        return this.f7669d;
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

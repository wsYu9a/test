package com.google.android.material.m.w;

import android.animation.Animator;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class o extends r<d> {

    /* renamed from: c */
    private static final float f7670c = 0.8f;

    /* renamed from: d */
    private static final float f7671d = 0.3f;

    public o() {
        super(e(), f());
    }

    private static d e() {
        d dVar = new d();
        dVar.e(f7671d);
        return dVar;
    }

    private static w f() {
        s sVar = new s();
        sVar.o(false);
        sVar.l(f7670c);
        return sVar;
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

    @Override // com.google.android.material.m.w.r, android.transition.Visibility
    public /* bridge */ /* synthetic */ Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.onAppear(viewGroup, view, transitionValues, transitionValues2);
    }

    @Override // com.google.android.material.m.w.r, android.transition.Visibility
    public /* bridge */ /* synthetic */ Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.onDisappear(viewGroup, view, transitionValues, transitionValues2);
    }
}

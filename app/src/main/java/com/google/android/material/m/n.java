package com.google.android.material.m;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.transition.TransitionValues;

/* loaded from: classes.dex */
public final class n extends q<d> {
    private static final float Z = 0.8f;
    private static final float a0 = 0.3f;

    public n() {
        super(N(), O());
    }

    private static d N() {
        d dVar = new d();
        dVar.e(a0);
        return dVar;
    }

    private static v O() {
        r rVar = new r();
        rVar.o(false);
        rVar.l(Z);
        return rVar;
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

    @Override // com.google.android.material.m.q, androidx.transition.Visibility
    public /* bridge */ /* synthetic */ Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.onAppear(viewGroup, view, transitionValues, transitionValues2);
    }

    @Override // com.google.android.material.m.q, androidx.transition.Visibility
    public /* bridge */ /* synthetic */ Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.onDisappear(viewGroup, view, transitionValues, transitionValues2);
    }
}

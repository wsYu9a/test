package com.google.android.material.m;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.transition.TransitionValues;

/* loaded from: classes.dex */
public final class m extends q<r> {
    private static final float Z = 0.85f;
    private final boolean a0;

    public m(boolean z) {
        super(N(z), O());
        this.a0 = z;
    }

    private static r N(boolean z) {
        r rVar = new r(z);
        rVar.m(Z);
        rVar.l(Z);
        return rVar;
    }

    private static v O() {
        return new d();
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

    public boolean P() {
        return this.a0;
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

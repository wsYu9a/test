package com.google.android.material.m;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.transition.TransitionValues;
import androidx.transition.Visibility;
import com.google.android.material.m.v;
import java.util.ArrayList;

/* loaded from: classes.dex */
abstract class q<P extends v> extends Visibility {
    private final P X;

    @Nullable
    private v Y;

    protected q(P p, @Nullable v vVar) {
        this.X = p;
        this.Y = vVar;
        setInterpolator(com.google.android.material.a.a.f6608b);
    }

    private Animator J(ViewGroup viewGroup, View view, boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        Animator b2 = z ? this.X.b(viewGroup, view) : this.X.a(viewGroup, view);
        if (b2 != null) {
            arrayList.add(b2);
        }
        v vVar = this.Y;
        if (vVar != null) {
            Animator b3 = z ? vVar.b(viewGroup, view) : vVar.a(viewGroup, view);
            if (b3 != null) {
                arrayList.add(b3);
            }
        }
        com.google.android.material.a.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    @NonNull
    public P K() {
        return this.X;
    }

    @Nullable
    public v L() {
        return this.Y;
    }

    public void M(@Nullable v vVar) {
        this.Y = vVar;
    }

    @Override // androidx.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return J(viewGroup, view, true);
    }

    @Override // androidx.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return J(viewGroup, view, false);
    }
}

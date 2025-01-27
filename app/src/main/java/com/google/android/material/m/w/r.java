package com.google.android.material.m.w;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.material.m.w.w;
import java.util.ArrayList;

@RequiresApi(21)
/* loaded from: classes.dex */
abstract class r<P extends w> extends Visibility {

    /* renamed from: a */
    private final P f7678a;

    /* renamed from: b */
    @Nullable
    private w f7679b;

    protected r(P p, @Nullable w wVar) {
        this.f7678a = p;
        this.f7679b = wVar;
        setInterpolator(com.google.android.material.a.a.f6608b);
    }

    private Animator a(ViewGroup viewGroup, View view, boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        Animator b2 = z ? this.f7678a.b(viewGroup, view) : this.f7678a.a(viewGroup, view);
        if (b2 != null) {
            arrayList.add(b2);
        }
        w wVar = this.f7679b;
        if (wVar != null) {
            Animator b3 = z ? wVar.b(viewGroup, view) : wVar.a(viewGroup, view);
            if (b3 != null) {
                arrayList.add(b3);
            }
        }
        com.google.android.material.a.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    @NonNull
    public P b() {
        return this.f7678a;
    }

    @Nullable
    public w c() {
        return this.f7679b;
    }

    public void d(@Nullable w wVar) {
        this.f7679b = wVar;
    }

    @Override // android.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return a(viewGroup, view, true);
    }

    @Override // android.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return a(viewGroup, view, false);
    }
}

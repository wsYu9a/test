package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import com.google.android.material.a.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
abstract class b implements f {

    /* renamed from: a */
    private final Context f7177a;

    /* renamed from: b */
    @NonNull
    private final ExtendedFloatingActionButton f7178b;

    /* renamed from: c */
    private final ArrayList<Animator.AnimatorListener> f7179c = new ArrayList<>();

    /* renamed from: d */
    private final a f7180d;

    /* renamed from: e */
    @Nullable
    private h f7181e;

    /* renamed from: f */
    @Nullable
    private h f7182f;

    b(@NonNull ExtendedFloatingActionButton extendedFloatingActionButton, a aVar) {
        this.f7178b = extendedFloatingActionButton;
        this.f7177a = extendedFloatingActionButton.getContext();
        this.f7180d = aVar;
    }

    @Override // com.google.android.material.floatingactionbutton.f
    public final h a() {
        h hVar = this.f7182f;
        if (hVar != null) {
            return hVar;
        }
        if (this.f7181e == null) {
            this.f7181e = h.d(this.f7177a, g());
        }
        return (h) Preconditions.checkNotNull(this.f7181e);
    }

    @Override // com.google.android.material.floatingactionbutton.f
    @Nullable
    public h c() {
        return this.f7182f;
    }

    @Override // com.google.android.material.floatingactionbutton.f
    public final void e(@NonNull Animator.AnimatorListener animatorListener) {
        this.f7179c.remove(animatorListener);
    }

    @Override // com.google.android.material.floatingactionbutton.f
    @CallSuper
    public void f() {
        this.f7180d.b();
    }

    @Override // com.google.android.material.floatingactionbutton.f
    public final void h(@NonNull Animator.AnimatorListener animatorListener) {
        this.f7179c.add(animatorListener);
    }

    @Override // com.google.android.material.floatingactionbutton.f
    @CallSuper
    public void i() {
        this.f7180d.b();
    }

    @Override // com.google.android.material.floatingactionbutton.f
    public final void j(@Nullable h hVar) {
        this.f7182f = hVar;
    }

    @Override // com.google.android.material.floatingactionbutton.f
    public AnimatorSet k() {
        return n(a());
    }

    @Override // com.google.android.material.floatingactionbutton.f
    @NonNull
    public final List<Animator.AnimatorListener> l() {
        return this.f7179c;
    }

    @NonNull
    AnimatorSet n(@NonNull h hVar) {
        ArrayList arrayList = new ArrayList();
        if (hVar.j("opacity")) {
            arrayList.add(hVar.f("opacity", this.f7178b, View.ALPHA));
        }
        if (hVar.j("scale")) {
            arrayList.add(hVar.f("scale", this.f7178b, View.SCALE_Y));
            arrayList.add(hVar.f("scale", this.f7178b, View.SCALE_X));
        }
        if (hVar.j("width")) {
            arrayList.add(hVar.f("width", this.f7178b, ExtendedFloatingActionButton.A));
        }
        if (hVar.j("height")) {
            arrayList.add(hVar.f("height", this.f7178b, ExtendedFloatingActionButton.B));
        }
        AnimatorSet animatorSet = new AnimatorSet();
        com.google.android.material.a.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    @Override // com.google.android.material.floatingactionbutton.f
    @CallSuper
    public void onAnimationStart(Animator animator) {
        this.f7180d.c(animator);
    }
}

package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
class a {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private Animator f7176a;

    a() {
    }

    public void a() {
        Animator animator = this.f7176a;
        if (animator != null) {
            animator.cancel();
        }
    }

    public void b() {
        this.f7176a = null;
    }

    public void c(Animator animator) {
        a();
        this.f7176a = animator;
    }
}

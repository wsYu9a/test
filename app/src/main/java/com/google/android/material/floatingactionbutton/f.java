package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.a.h;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import java.util.List;

/* loaded from: classes.dex */
interface f {
    h a();

    void b();

    @Nullable
    h c();

    boolean d();

    void e(@NonNull Animator.AnimatorListener animatorListener);

    void f();

    @AnimatorRes
    int g();

    void h(@NonNull Animator.AnimatorListener animatorListener);

    void i();

    void j(@Nullable h hVar);

    AnimatorSet k();

    List<Animator.AnimatorListener> l();

    void m(@Nullable ExtendedFloatingActionButton.h hVar);

    void onAnimationStart(Animator animator);
}

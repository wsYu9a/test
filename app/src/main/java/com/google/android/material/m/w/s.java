package com.google.android.material.m.w;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class s implements w {

    /* renamed from: a */
    private float f7680a;

    /* renamed from: b */
    private float f7681b;

    /* renamed from: c */
    private float f7682c;

    /* renamed from: d */
    private float f7683d;

    /* renamed from: e */
    private boolean f7684e;

    /* renamed from: f */
    private boolean f7685f;

    public s() {
        this(true);
    }

    private static Animator c(View view, float f2, float f3) {
        return ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_X, f2, f3), PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_Y, f2, f3));
    }

    @Override // com.google.android.material.m.w.w
    @Nullable
    public Animator a(@NonNull ViewGroup viewGroup, @NonNull View view) {
        if (this.f7685f) {
            return this.f7684e ? c(view, this.f7680a, this.f7681b) : c(view, this.f7683d, this.f7682c);
        }
        return null;
    }

    @Override // com.google.android.material.m.w.w
    @Nullable
    public Animator b(@NonNull ViewGroup viewGroup, @NonNull View view) {
        return this.f7684e ? c(view, this.f7682c, this.f7683d) : c(view, this.f7681b, this.f7680a);
    }

    public float d() {
        return this.f7683d;
    }

    public float e() {
        return this.f7682c;
    }

    public float f() {
        return this.f7681b;
    }

    public float g() {
        return this.f7680a;
    }

    public boolean h() {
        return this.f7684e;
    }

    public boolean i() {
        return this.f7685f;
    }

    public void j(boolean z) {
        this.f7684e = z;
    }

    public void k(float f2) {
        this.f7683d = f2;
    }

    public void l(float f2) {
        this.f7682c = f2;
    }

    public void m(float f2) {
        this.f7681b = f2;
    }

    public void n(float f2) {
        this.f7680a = f2;
    }

    public void o(boolean z) {
        this.f7685f = z;
    }

    public s(boolean z) {
        this.f7680a = 1.0f;
        this.f7681b = 1.1f;
        this.f7682c = 0.8f;
        this.f7683d = 1.0f;
        this.f7685f = true;
        this.f7684e = z;
    }
}

package com.google.android.material.m;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public final class r implements v {

    /* renamed from: a */
    private float f7573a;

    /* renamed from: b */
    private float f7574b;

    /* renamed from: c */
    private float f7575c;

    /* renamed from: d */
    private float f7576d;

    /* renamed from: e */
    private boolean f7577e;

    /* renamed from: f */
    private boolean f7578f;

    public r() {
        this(true);
    }

    private static Animator c(View view, float f2, float f3) {
        return ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_X, f2, f3), PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_Y, f2, f3));
    }

    @Override // com.google.android.material.m.v
    @Nullable
    public Animator a(@NonNull ViewGroup viewGroup, @NonNull View view) {
        if (this.f7578f) {
            return this.f7577e ? c(view, this.f7573a, this.f7574b) : c(view, this.f7576d, this.f7575c);
        }
        return null;
    }

    @Override // com.google.android.material.m.v
    @Nullable
    public Animator b(@NonNull ViewGroup viewGroup, @NonNull View view) {
        return this.f7577e ? c(view, this.f7575c, this.f7576d) : c(view, this.f7574b, this.f7573a);
    }

    public float d() {
        return this.f7576d;
    }

    public float e() {
        return this.f7575c;
    }

    public float f() {
        return this.f7574b;
    }

    public float g() {
        return this.f7573a;
    }

    public boolean h() {
        return this.f7577e;
    }

    public boolean i() {
        return this.f7578f;
    }

    public void j(boolean z) {
        this.f7577e = z;
    }

    public void k(float f2) {
        this.f7576d = f2;
    }

    public void l(float f2) {
        this.f7575c = f2;
    }

    public void m(float f2) {
        this.f7574b = f2;
    }

    public void n(float f2) {
        this.f7573a = f2;
    }

    public void o(boolean z) {
        this.f7578f = z;
    }

    public r(boolean z) {
        this.f7573a = 1.0f;
        this.f7574b = 1.1f;
        this.f7575c = 0.8f;
        this.f7576d = 1.0f;
        this.f7578f = true;
        this.f7577e = z;
    }
}

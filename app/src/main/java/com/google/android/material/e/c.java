package com.google.android.material.e;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a */
    @NonNull
    private final View f7129a;

    /* renamed from: b */
    private boolean f7130b = false;

    /* renamed from: c */
    @IdRes
    private int f7131c = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public c(b bVar) {
        this.f7129a = (View) bVar;
    }

    private void a() {
        ViewParent parent = this.f7129a.getParent();
        if (parent instanceof CoordinatorLayout) {
            ((CoordinatorLayout) parent).dispatchDependentViewsChanged(this.f7129a);
        }
    }

    @IdRes
    public int b() {
        return this.f7131c;
    }

    public boolean c() {
        return this.f7130b;
    }

    public void d(@NonNull Bundle bundle) {
        this.f7130b = bundle.getBoolean("expanded", false);
        this.f7131c = bundle.getInt("expandedComponentIdHint", 0);
        if (this.f7130b) {
            a();
        }
    }

    @NonNull
    public Bundle e() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", this.f7130b);
        bundle.putInt("expandedComponentIdHint", this.f7131c);
        return bundle;
    }

    public boolean f(boolean z) {
        if (this.f7130b == z) {
            return false;
        }
        this.f7130b = z;
        a();
        return true;
    }

    public void g(@IdRes int i2) {
        this.f7131c = i2;
    }
}

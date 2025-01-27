package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes.dex */
class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: a */
    private a f6701a;

    /* renamed from: b */
    private int f6702b;

    /* renamed from: c */
    private int f6703c;

    public ViewOffsetBehavior() {
        this.f6702b = 0;
        this.f6703c = 0;
    }

    public int a() {
        a aVar = this.f6701a;
        if (aVar != null) {
            return aVar.d();
        }
        return 0;
    }

    public int b() {
        a aVar = this.f6701a;
        if (aVar != null) {
            return aVar.e();
        }
        return 0;
    }

    public boolean c() {
        a aVar = this.f6701a;
        return aVar != null && aVar.f();
    }

    public boolean d() {
        a aVar = this.f6701a;
        return aVar != null && aVar.g();
    }

    protected void e(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i2) {
        coordinatorLayout.onLayoutChild(v, i2);
    }

    public void f(boolean z) {
        a aVar = this.f6701a;
        if (aVar != null) {
            aVar.i(z);
        }
    }

    public boolean g(int i2) {
        a aVar = this.f6701a;
        if (aVar != null) {
            return aVar.j(i2);
        }
        this.f6703c = i2;
        return false;
    }

    public boolean h(int i2) {
        a aVar = this.f6701a;
        if (aVar != null) {
            return aVar.k(i2);
        }
        this.f6702b = i2;
        return false;
    }

    public void i(boolean z) {
        a aVar = this.f6701a;
        if (aVar != null) {
            aVar.l(z);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i2) {
        e(coordinatorLayout, v, i2);
        if (this.f6701a == null) {
            this.f6701a = new a(v);
        }
        this.f6701a.h();
        this.f6701a.a();
        int i3 = this.f6702b;
        if (i3 != 0) {
            this.f6701a.k(i3);
            this.f6702b = 0;
        }
        int i4 = this.f6703c;
        if (i4 == 0) {
            return true;
        }
        this.f6701a.j(i4);
        this.f6703c = 0;
        return true;
    }

    public ViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6702b = 0;
        this.f6703c = 0;
    }
}

package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
class a {

    /* renamed from: a */
    private final View f6704a;

    /* renamed from: b */
    private int f6705b;

    /* renamed from: c */
    private int f6706c;

    /* renamed from: d */
    private int f6707d;

    /* renamed from: e */
    private int f6708e;

    /* renamed from: f */
    private boolean f6709f = true;

    /* renamed from: g */
    private boolean f6710g = true;

    public a(View view) {
        this.f6704a = view;
    }

    void a() {
        View view = this.f6704a;
        ViewCompat.offsetTopAndBottom(view, this.f6707d - (view.getTop() - this.f6705b));
        View view2 = this.f6704a;
        ViewCompat.offsetLeftAndRight(view2, this.f6708e - (view2.getLeft() - this.f6706c));
    }

    public int b() {
        return this.f6706c;
    }

    public int c() {
        return this.f6705b;
    }

    public int d() {
        return this.f6708e;
    }

    public int e() {
        return this.f6707d;
    }

    public boolean f() {
        return this.f6710g;
    }

    public boolean g() {
        return this.f6709f;
    }

    void h() {
        this.f6705b = this.f6704a.getTop();
        this.f6706c = this.f6704a.getLeft();
    }

    public void i(boolean z) {
        this.f6710g = z;
    }

    public boolean j(int i2) {
        if (!this.f6710g || this.f6708e == i2) {
            return false;
        }
        this.f6708e = i2;
        a();
        return true;
    }

    public boolean k(int i2) {
        if (!this.f6709f || this.f6707d == i2) {
            return false;
        }
        this.f6707d = i2;
        a();
        return true;
    }

    public void l(boolean z) {
        this.f6709f = z;
    }
}

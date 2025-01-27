package com.google.android.material.m.w;

import androidx.annotation.RequiresApi;

@RequiresApi(21)
/* loaded from: classes.dex */
class c {

    /* renamed from: a, reason: collision with root package name */
    final int f7593a;

    /* renamed from: b, reason: collision with root package name */
    final int f7594b;

    /* renamed from: c, reason: collision with root package name */
    final boolean f7595c;

    private c(int i2, int i3, boolean z) {
        this.f7593a = i2;
        this.f7594b = i3;
        this.f7595c = z;
    }

    static c a(int i2, int i3) {
        return new c(i2, i3, true);
    }

    static c b(int i2, int i3) {
        return new c(i2, i3, false);
    }
}

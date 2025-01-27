package com.vivo.google.android.exoplayer3;

import android.text.Layout;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class z4 {

    /* renamed from: a */
    public String f28316a;

    /* renamed from: b */
    public String f28317b;

    /* renamed from: c */
    public List<String> f28318c;

    /* renamed from: d */
    public String f28319d;

    /* renamed from: e */
    public String f28320e;

    /* renamed from: f */
    public int f28321f;

    /* renamed from: g */
    public boolean f28322g;

    /* renamed from: h */
    public int f28323h;

    /* renamed from: i */
    public boolean f28324i;

    /* renamed from: j */
    public int f28325j;
    public int k;
    public int l;
    public int m;
    public int n;
    public float o;
    public Layout.Alignment p;

    public z4() {
        b();
    }

    public static int a(int i2, String str, String str2, int i3) {
        if (str.isEmpty() || i2 == -1) {
            return i2;
        }
        if (str.equals(str2)) {
            return i2 + i3;
        }
        return -1;
    }

    public int a() {
        int i2 = this.l;
        if (i2 == -1 && this.m == -1) {
            return -1;
        }
        return (i2 == 1 ? 1 : 0) | (this.m == 1 ? 2 : 0);
    }

    public void b() {
        this.f28316a = "";
        this.f28317b = "";
        this.f28318c = Collections.emptyList();
        this.f28319d = "";
        this.f28320e = null;
        this.f28322g = false;
        this.f28324i = false;
        this.f28325j = -1;
        this.k = -1;
        this.l = -1;
        this.m = -1;
        this.n = -1;
        this.p = null;
    }
}

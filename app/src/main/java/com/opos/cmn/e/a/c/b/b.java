package com.opos.cmn.e.a.c.b;

import java.util.Arrays;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    private String f16989a;

    /* renamed from: b */
    private boolean f16990b;

    /* renamed from: c */
    private Object[] f16991c;

    public b(String str, boolean z, Object[] objArr) {
        this.f16989a = str;
        this.f16990b = z;
        this.f16991c = objArr;
    }

    public String a() {
        return this.f16989a;
    }

    public boolean b() {
        return this.f16990b;
    }

    public Object[] c() {
        return this.f16991c;
    }

    public String toString() {
        return "ToastParams{pkgName='" + this.f16989a + "', gbClick=" + this.f16990b + ", objects=" + Arrays.toString(this.f16991c) + '}';
    }
}

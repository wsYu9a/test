package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;

/* loaded from: classes2.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    public int f11176a;

    /* renamed from: b, reason: collision with root package name */
    public int f11177b;

    /* renamed from: c, reason: collision with root package name */
    public String f11178c;

    /* renamed from: d, reason: collision with root package name */
    public String f11179d;

    /* renamed from: e, reason: collision with root package name */
    public String f11180e;

    /* renamed from: f, reason: collision with root package name */
    public Context f11181f;

    /* renamed from: g, reason: collision with root package name */
    public ClassLoader f11182g;

    /* renamed from: h, reason: collision with root package name */
    public String f11183h;

    /* renamed from: i, reason: collision with root package name */
    public String f11184i;

    /* renamed from: j, reason: collision with root package name */
    public String f11185j;

    /* renamed from: k, reason: collision with root package name */
    public String f11186k;

    /* renamed from: l, reason: collision with root package name */
    public ActivityInfo[] f11187l;

    /* renamed from: m, reason: collision with root package name */
    public String f11188m;

    /* renamed from: n, reason: collision with root package name */
    public String f11189n;

    /* renamed from: o, reason: collision with root package name */
    public String f11190o;

    /* renamed from: p, reason: collision with root package name */
    public int f11191p;

    /* renamed from: q, reason: collision with root package name */
    public int f11192q;

    /* renamed from: r, reason: collision with root package name */
    public PackageInfo f11193r;

    /* renamed from: s, reason: collision with root package name */
    public long f11194s;

    /* renamed from: t, reason: collision with root package name */
    public int f11195t;

    /* renamed from: u, reason: collision with root package name */
    public int f11196u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f11197v;

    /* renamed from: w, reason: collision with root package name */
    public int f11198w;

    /* renamed from: x, reason: collision with root package name */
    public int f11199x = -1;

    /* renamed from: y, reason: collision with root package name */
    public boolean f11200y;

    public s() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        s sVar = (s) obj;
        String str = this.f11178c;
        if (str == null) {
            if (sVar.f11178c != null) {
                return false;
            }
        } else if (!str.equals(sVar.f11178c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f11178c;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public s(PackageInfo packageInfo, int i10, String str, String str2, String str3, String str4) {
        this.f11193r = packageInfo;
        this.f11176a = i10;
        this.f11178c = str;
        this.f11179d = str2;
        this.f11184i = str3;
        this.f11185j = str4;
    }
}

package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;

/* loaded from: classes.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    public int f9391a;

    /* renamed from: b, reason: collision with root package name */
    public int f9392b;

    /* renamed from: c, reason: collision with root package name */
    public String f9393c;

    /* renamed from: d, reason: collision with root package name */
    public String f9394d;

    /* renamed from: e, reason: collision with root package name */
    public String f9395e;

    /* renamed from: f, reason: collision with root package name */
    public Context f9396f;

    /* renamed from: g, reason: collision with root package name */
    public ClassLoader f9397g;

    /* renamed from: h, reason: collision with root package name */
    public String f9398h;

    /* renamed from: i, reason: collision with root package name */
    public String f9399i;

    /* renamed from: j, reason: collision with root package name */
    public String f9400j;
    public String k;
    public ActivityInfo[] l;
    public String m;
    public String n;
    public String o;
    public int p;
    public int q;
    public PackageInfo r;
    public long s;
    public int t;
    public int u;
    public boolean v;
    public int w;
    public int x = -1;
    public boolean y;

    public s() {
    }

    public s(PackageInfo packageInfo, int i2, String str, String str2, String str3, String str4) {
        this.r = packageInfo;
        this.f9391a = i2;
        this.f9393c = str;
        this.f9394d = str2;
        this.f9399i = str3;
        this.f9400j = str4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        String str = this.f9393c;
        String str2 = ((s) obj).f9393c;
        if (str == null) {
            if (str2 != null) {
                return false;
            }
        } else if (!str.equals(str2)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f9393c;
        return (str == null ? 0 : str.hashCode()) + 31;
    }
}

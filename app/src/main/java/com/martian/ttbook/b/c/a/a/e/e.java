package com.martian.ttbook.b.c.a.a.e;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: a */
    public Map<Object, Object> f15826a;

    public e(Map<Object, Object> map) {
        this.f15826a = map;
        if (map == null) {
            this.f15826a = new HashMap();
        }
    }

    public double a(Object obj) {
        return b(obj, 0.0d);
    }

    public double b(Object obj, double d2) {
        Object obj2 = this.f15826a.get(obj);
        if (obj2 != null && (obj2 instanceof double[])) {
            try {
                try {
                    return ((double[]) obj2)[0];
                } catch (Exception unused) {
                    if (obj2 instanceof int[]) {
                        return ((int[]) obj2)[0];
                    }
                    if (obj2 instanceof long[]) {
                        return ((long[]) obj2)[0];
                    }
                }
            } catch (Exception unused2) {
            }
        }
        return d2;
    }

    public int c(Object obj, int i2) {
        Object obj2 = this.f15826a.get(obj);
        if (obj2 != null && (obj2 instanceof int[])) {
            try {
                return ((int[]) obj2)[0];
            } catch (Exception unused) {
            }
        }
        return i2;
    }

    public String d(Object obj, String str) {
        Object obj2 = this.f15826a.get(obj);
        return (obj2 == null || !(obj2 instanceof String)) ? str : (String) obj2;
    }

    public void e(Object obj, long j2) {
        this.f15826a.put(obj, new long[]{j2});
    }

    public boolean f(Object obj, boolean z) {
        Object obj2 = this.f15826a.get(obj);
        if (obj2 != null && (obj2 instanceof boolean[])) {
            try {
                return ((boolean[]) obj2)[0];
            } catch (Exception unused) {
            }
        }
        return z;
    }

    public int g(Object obj) {
        return c(obj, 0);
    }

    public void h(Object obj, double d2) {
        this.f15826a.put(obj, new double[]{d2});
    }

    public void i(Object obj, int i2) {
        this.f15826a.put(obj, new int[]{i2});
    }

    public void j(Object obj, String str) {
        this.f15826a.put(obj, str);
    }

    public void k(Object obj, boolean z) {
        this.f15826a.put(obj, new boolean[]{z});
    }

    public String l(Object obj) {
        Object obj2 = this.f15826a.get(obj);
        if (obj2 == null || !(obj2 instanceof String)) {
            return null;
        }
        return (String) obj2;
    }
}

package com.martian.ttbook.b.c.a.a.d.b;

import android.os.Build;
import android.view.View;
import com.martian.ttbook.b.c.a.a.d.b.e;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes4.dex */
public class l {

    /* renamed from: a */
    public static WeakHashMap<View, Object[]> f15795a = new WeakHashMap<>();

    public static int a(String str) {
        int a2 = com.martian.ttbook.b.c.a.a.e.f.c().a(str, -1);
        com.martian.ttbook.b.c.a.a.e.f.c().f(str);
        return a2;
    }

    public static Map<Object, Object> b(d dVar) {
        Map map = (Map) com.martian.ttbook.b.c.a.a.b.f15209d[7];
        Map<Object, Object> map2 = (Map) map.get(dVar.f15668b);
        if (map2 != null) {
            return map2;
        }
        HashMap hashMap = new HashMap();
        map.put(dVar.f15668b, hashMap);
        return hashMap;
    }

    public static void c(View view, Object[] objArr) {
        Object[] objArr2 = f15795a.get(view);
        if (objArr2 != null) {
            objArr[5] = objArr2[5];
        }
        f15795a.put(view, objArr);
    }

    public static void d(d dVar, int i2) {
        b(dVar).put(dVar.f15668b, Integer.valueOf(i2));
    }

    public static void e(d dVar, e eVar) {
        f(dVar, eVar, false);
    }

    public static void f(d dVar, e eVar, boolean z) {
        ((Map) com.martian.ttbook.b.c.a.a.b.f15209d[6]).put(eVar.f15701c.d(e.c.Q, ""), new Object[]{new WeakReference(dVar.f15668b), dVar.f15669c, dVar.f15675i, Integer.valueOf(dVar.f15671e.a()), j.q.getPackageName(), com.martian.ttbook.b.c.a.a.e.b.p(), com.martian.ttbook.b.c.a.a.e.b.v(), com.martian.ttbook.b.c.a.a.e.b.q(), Build.BRAND, Build.MODEL, Boolean.valueOf(com.martian.ttbook.b.c.a.a.e.b.E()), com.martian.ttbook.b.c.a.a.e.b.u(), Boolean.valueOf(z)});
    }

    public static void g(Object obj, double d2, double d3, double d4, int i2, int i3, int i4, long j2, int i5) {
        com.martian.ttbook.b.c.a.a.b.g(new Object[]{0, new WeakReference(obj), Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j2), Integer.valueOf(i5)}, j.q);
    }

    public static void h(Object obj, long j2) {
        com.martian.ttbook.b.c.a.a.b.g(new Object[]{3, new WeakReference(obj), Long.valueOf(j2)}, j.q);
    }

    public static void i(Object obj, boolean z, boolean z2) {
        com.martian.ttbook.b.c.a.a.b.g(new Object[]{5, new WeakReference(obj), Boolean.valueOf(z), Boolean.valueOf(z2)}, j.q);
    }

    public static void j(Object obj, byte[] bArr) {
        com.martian.ttbook.b.c.a.a.b.g(new Object[]{4, new WeakReference(obj), bArr}, j.q);
    }

    public static void k(Object obj, int[] iArr) {
        com.martian.ttbook.b.c.a.a.e.d.g("ADGLOBALTAG", "update saved point");
        com.martian.ttbook.b.c.a.a.b.g(new Object[]{6, new WeakReference(obj), iArr}, j.q);
    }

    public static void l(Object obj, Object[] objArr, com.martian.ttbook.b.c.a.a.c.h hVar, View view, View[] viewArr) {
        m(obj, objArr, hVar, view, viewArr, null, null);
    }

    public static void m(Object obj, Object[] objArr, com.martian.ttbook.b.c.a.a.c.h hVar, View view, View[] viewArr, WeakReference<View> weakReference, WeakReference weakReference2) {
        n(obj, objArr, hVar, view, viewArr, weakReference, weakReference2, null);
    }

    public static void n(Object obj, Object[] objArr, com.martian.ttbook.b.c.a.a.c.h hVar, View view, View[] viewArr, WeakReference<View> weakReference, WeakReference weakReference2, Object obj2) {
        View.OnAttachStateChangeListener onAttachStateChangeListener;
        WeakReference[] weakReferenceArr = new WeakReference[viewArr.length];
        for (int i2 = 0; i2 < viewArr.length; i2++) {
            weakReferenceArr[i2] = new WeakReference(viewArr[i2]);
        }
        Object[] objArr2 = f15795a.get(view);
        if (objArr2 != null && (onAttachStateChangeListener = (View.OnAttachStateChangeListener) objArr2[4]) != null) {
            view.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            objArr[5] = objArr2[5];
        }
        f15795a.put(view, objArr);
        com.martian.ttbook.b.c.a.a.b.g(new Object[]{2, new WeakReference(obj), new WeakReference(objArr), new WeakReference(view), weakReferenceArr, Integer.valueOf(hVar.a()), weakReference, weakReference2, obj2}, j.q);
    }

    public static void o(Object obj, Object[] objArr, com.martian.ttbook.b.c.a.a.c.h hVar, Object obj2) {
        com.martian.ttbook.b.c.a.a.b.g(new Object[]{7, new WeakReference(obj), new WeakReference(objArr), Integer.valueOf(hVar.a()), obj2}, j.q);
    }

    public static void p(Object[] objArr) {
        com.martian.ttbook.b.c.a.a.b.g(new Object[]{9, new WeakReference(objArr)}, j.q);
    }

    public static void q(Object[] objArr, int i2) {
        com.martian.ttbook.b.c.a.a.b.g(new Object[]{8, new WeakReference(objArr), Integer.valueOf(i2)}, j.q);
    }

    public static int r(d dVar) {
        Object obj = b(dVar).get(dVar.f15668b);
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return 0;
    }

    public static void s(Object obj, boolean z, boolean z2) {
        com.martian.ttbook.b.c.a.a.b.g(new Object[]{1, new WeakReference(obj), Boolean.valueOf(z), Boolean.valueOf(z2)}, j.q);
    }
}

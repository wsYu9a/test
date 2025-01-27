package com.aggmoread.sdk.z.d.a.a.d.b;

import android.os.Build;
import android.view.View;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.e.m;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class l {

    /* renamed from: a */
    public static WeakHashMap<View, Object[]> f6059a = new WeakHashMap<>();

    public static int a(String str) {
        int a10 = com.aggmoread.sdk.z.d.a.a.e.h.a().a(str, -1);
        com.aggmoread.sdk.z.d.a.a.e.h.a().a(str);
        return a10;
    }

    public static int b(d dVar) {
        Object obj = a(dVar).get(dVar.f5856b);
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return 0;
    }

    public static Map<Object, Object> a(d dVar) {
        Map map = (Map) com.aggmoread.sdk.z.d.a.a.b.f5207d[6];
        Map<Object, Object> map2 = (Map) map.get(dVar.f5856b);
        if (map2 != null) {
            return map2;
        }
        HashMap hashMap = new HashMap();
        map.put(dVar.f5856b, hashMap);
        return hashMap;
    }

    public static void b(Object obj, boolean z10, boolean z11) {
        com.aggmoread.sdk.z.d.a.a.b.a(new Object[]{1, new WeakReference(obj), Boolean.valueOf(z10), Boolean.valueOf(z11)}, j.f6027q);
    }

    public static void a(View view, Object[] objArr) {
        Object[] objArr2 = f6059a.get(view);
        if (objArr2 != null) {
            objArr[2] = objArr2[2];
        }
        f6059a.put(view, objArr);
    }

    public static void a(d dVar, int i10) {
        a(dVar).put(dVar.f5856b, Integer.valueOf(i10));
    }

    public static void a(d dVar, e eVar) {
        a(dVar, eVar, false);
    }

    public static void a(d dVar, e eVar, boolean z10) {
        ((Map) com.aggmoread.sdk.z.d.a.a.b.f5207d[7]).put(eVar.f5907c.a(e.c.T, ""), new Object[]{new WeakReference(dVar.f5856b), dVar.f5857c, dVar.f5863i, Integer.valueOf(dVar.f5859e.a()), j.f6027q.getPackageName(), com.aggmoread.sdk.z.d.a.a.e.c.e(), com.aggmoread.sdk.z.d.a.a.e.c.q(), com.aggmoread.sdk.z.d.a.a.e.c.g(), Build.BRAND, Build.MODEL, Boolean.valueOf(com.aggmoread.sdk.z.d.a.a.e.c.B()), com.aggmoread.sdk.z.d.a.a.e.c.p(), Boolean.valueOf(z10)});
    }

    public static void a(Object obj, double d10, double d11, double d12, int i10, int i11, int i12, long j10, int i13) {
        com.aggmoread.sdk.z.d.a.a.b.a(new Object[]{0, new WeakReference(obj), Double.valueOf(d10), Double.valueOf(d11), Double.valueOf(d12), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Long.valueOf(j10), Integer.valueOf(i13)}, j.f6027q);
    }

    public static void a(Object obj, long j10) {
        com.aggmoread.sdk.z.d.a.a.b.a(new Object[]{3, new WeakReference(obj), Long.valueOf(j10)}, j.f6027q);
    }

    public static void a(Object obj, e eVar) {
        com.aggmoread.sdk.z.d.a.a.b.a(new Object[]{10, new WeakReference(obj), Double.valueOf(m.e(eVar)), Double.valueOf(m.f(eVar))}, j.f6027q);
    }

    public static void a(Object obj, boolean z10, boolean z11) {
        com.aggmoread.sdk.z.d.a.a.b.a(new Object[]{5, new WeakReference(obj), Boolean.valueOf(z10), Boolean.valueOf(z11)}, j.f6027q);
    }

    public static void a(Object obj, byte[] bArr) {
        com.aggmoread.sdk.z.d.a.a.b.a(new Object[]{4, new WeakReference(obj), bArr}, j.f6027q);
    }

    public static void a(Object obj, int[] iArr) {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMGTAG", "update saved point");
        com.aggmoread.sdk.z.d.a.a.b.a(new Object[]{6, new WeakReference(obj), iArr}, j.f6027q);
    }

    public static void a(Object obj, Object[] objArr, com.aggmoread.sdk.z.d.a.a.c.i iVar, View view, View[] viewArr) {
        a(obj, objArr, iVar, view, viewArr, null, null);
    }

    public static void a(Object obj, Object[] objArr, com.aggmoread.sdk.z.d.a.a.c.i iVar, View view, View[] viewArr, WeakReference<View> weakReference, WeakReference weakReference2) {
        a(obj, objArr, iVar, view, viewArr, weakReference, weakReference2, null);
    }

    public static void a(Object obj, Object[] objArr, com.aggmoread.sdk.z.d.a.a.c.i iVar, View view, View[] viewArr, WeakReference<View> weakReference, WeakReference weakReference2, Object obj2) {
        View.OnAttachStateChangeListener onAttachStateChangeListener;
        WeakReference[] weakReferenceArr = new WeakReference[viewArr.length];
        for (int i10 = 0; i10 < viewArr.length; i10++) {
            weakReferenceArr[i10] = new WeakReference(viewArr[i10]);
        }
        Object[] objArr2 = f6059a.get(view);
        if (objArr2 != null && (onAttachStateChangeListener = (View.OnAttachStateChangeListener) objArr2[3]) != null) {
            view.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            objArr[2] = objArr2[2];
        }
        f6059a.put(view, objArr);
        com.aggmoread.sdk.z.d.a.a.b.a(new Object[]{2, new WeakReference(obj), new WeakReference(objArr), new WeakReference(view), weakReferenceArr, Integer.valueOf(iVar.a()), weakReference, weakReference2, obj2}, j.f6027q);
    }

    public static void a(Object obj, Object[] objArr, com.aggmoread.sdk.z.d.a.a.c.i iVar, Object obj2) {
        boolean a10 = m.a(iVar);
        com.aggmoread.sdk.z.d.a.a.e.e.b("xxx", "register isAvailable " + a10);
        if (a10) {
            com.aggmoread.sdk.z.d.a.a.b.a(new Object[]{7, new WeakReference(obj), new WeakReference(objArr), Integer.valueOf(iVar.a()), obj2}, j.f6027q);
        }
    }

    public static void a(Object[] objArr) {
        com.aggmoread.sdk.z.d.a.a.b.a(new Object[]{9, new WeakReference(objArr)}, j.f6027q);
    }

    public static void a(Object[] objArr, int i10) {
        com.aggmoread.sdk.z.d.a.a.b.a(new Object[]{8, new WeakReference(objArr), Integer.valueOf(i10)}, j.f6027q);
    }
}

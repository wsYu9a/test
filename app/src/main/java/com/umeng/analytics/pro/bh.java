package com.umeng.analytics.pro;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class bh implements Serializable {

    /* renamed from: d */
    private static Map<Class<? extends av>, Map<? extends bc, bh>> f25734d = new HashMap();

    /* renamed from: a */
    public final String f25735a;

    /* renamed from: b */
    public final byte f25736b;

    /* renamed from: c */
    public final bi f25737c;

    public bh(String str, byte b2, bi biVar) {
        this.f25735a = str;
        this.f25736b = b2;
        this.f25737c = biVar;
    }

    public static void a(Class<? extends av> cls, Map<? extends bc, bh> map) {
        f25734d.put(cls, map);
    }

    public static Map<? extends bc, bh> a(Class<? extends av> cls) {
        if (!f25734d.containsKey(cls)) {
            try {
                cls.newInstance();
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("IllegalAccessException for TBase class: " + cls.getName() + ", message: " + e2.getMessage());
            } catch (InstantiationException e3) {
                throw new RuntimeException("InstantiationException for TBase class: " + cls.getName() + ", message: " + e3.getMessage());
            }
        }
        return f25734d.get(cls);
    }
}

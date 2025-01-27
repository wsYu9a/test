package com.umeng.analytics.pro;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class ct implements Serializable {

    /* renamed from: d */
    private static Map<Class<? extends ch>, Map<? extends co, ct>> f23760d = new HashMap();

    /* renamed from: a */
    public final String f23761a;

    /* renamed from: b */
    public final byte f23762b;

    /* renamed from: c */
    public final cu f23763c;

    public ct(String str, byte b10, cu cuVar) {
        this.f23761a = str;
        this.f23762b = b10;
        this.f23763c = cuVar;
    }

    public static void a(Class<? extends ch> cls, Map<? extends co, ct> map) {
        f23760d.put(cls, map);
    }

    public static Map<? extends co, ct> a(Class<? extends ch> cls) {
        if (!f23760d.containsKey(cls)) {
            try {
                cls.newInstance();
            } catch (IllegalAccessException e10) {
                throw new RuntimeException("IllegalAccessException for TBase class: " + cls.getName() + ", message: " + e10.getMessage());
            } catch (InstantiationException e11) {
                throw new RuntimeException("InstantiationException for TBase class: " + cls.getName() + ", message: " + e11.getMessage());
            }
        }
        return f23760d.get(cls);
    }
}

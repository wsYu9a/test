package com.google.gson.internal;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a */
    private static final Map<Class<?>, Class<?>> f8154a;

    /* renamed from: b */
    private static final Map<Class<?>, Class<?>> f8155b;

    static {
        HashMap hashMap = new HashMap(16);
        HashMap hashMap2 = new HashMap(16);
        a(hashMap, hashMap2, Boolean.TYPE, Boolean.class);
        a(hashMap, hashMap2, Byte.TYPE, Byte.class);
        a(hashMap, hashMap2, Character.TYPE, Character.class);
        a(hashMap, hashMap2, Double.TYPE, Double.class);
        a(hashMap, hashMap2, Float.TYPE, Float.class);
        a(hashMap, hashMap2, Integer.TYPE, Integer.class);
        a(hashMap, hashMap2, Long.TYPE, Long.class);
        a(hashMap, hashMap2, Short.TYPE, Short.class);
        a(hashMap, hashMap2, Void.TYPE, Void.class);
        f8154a = Collections.unmodifiableMap(hashMap);
        f8155b = Collections.unmodifiableMap(hashMap2);
    }

    private e() {
    }

    private static void a(Map<Class<?>, Class<?>> map, Map<Class<?>, Class<?>> map2, Class<?> cls, Class<?> cls2) {
        map.put(cls, cls2);
        map2.put(cls2, cls);
    }

    public static boolean b(Type type) {
        return f8154a.containsKey(type);
    }

    public static boolean c(Type type) {
        return f8155b.containsKey(a.b(type));
    }

    public static <T> Class<T> d(Class<T> cls) {
        Class<T> cls2 = (Class) f8155b.get(a.b(cls));
        return cls2 == null ? cls : cls2;
    }

    public static <T> Class<T> e(Class<T> cls) {
        Class<T> cls2 = (Class) f8154a.get(a.b(cls));
        return cls2 == null ? cls : cls2;
    }
}

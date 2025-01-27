package n5;

import b5.u;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@b
@a5.c
/* loaded from: classes2.dex */
public final class h {

    /* renamed from: a */
    public static final Map<Class<?>, Class<?>> f28780a;

    /* renamed from: b */
    public static final Map<Class<?>, Class<?>> f28781b;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap(16);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(16);
        a(linkedHashMap, linkedHashMap2, Boolean.TYPE, Boolean.class);
        a(linkedHashMap, linkedHashMap2, Byte.TYPE, Byte.class);
        a(linkedHashMap, linkedHashMap2, Character.TYPE, Character.class);
        a(linkedHashMap, linkedHashMap2, Double.TYPE, Double.class);
        a(linkedHashMap, linkedHashMap2, Float.TYPE, Float.class);
        a(linkedHashMap, linkedHashMap2, Integer.TYPE, Integer.class);
        a(linkedHashMap, linkedHashMap2, Long.TYPE, Long.class);
        a(linkedHashMap, linkedHashMap2, Short.TYPE, Short.class);
        a(linkedHashMap, linkedHashMap2, Void.TYPE, Void.class);
        f28780a = Collections.unmodifiableMap(linkedHashMap);
        f28781b = Collections.unmodifiableMap(linkedHashMap2);
    }

    public static void a(Map<Class<?>, Class<?>> map, Map<Class<?>, Class<?>> map2, Class<?> cls, Class<?> cls2) {
        map.put(cls, cls2);
        map2.put(cls2, cls);
    }

    public static Set<Class<?>> b() {
        return f28780a.keySet();
    }

    public static Set<Class<?>> c() {
        return f28781b.keySet();
    }

    public static boolean d(Class<?> cls) {
        return f28781b.containsKey(u.E(cls));
    }

    public static <T> Class<T> e(Class<T> cls) {
        u.E(cls);
        Class<T> cls2 = (Class) f28781b.get(cls);
        return cls2 == null ? cls : cls2;
    }

    public static <T> Class<T> f(Class<T> cls) {
        u.E(cls);
        Class<T> cls2 = (Class) f28780a.get(cls);
        return cls2 == null ? cls : cls2;
    }
}

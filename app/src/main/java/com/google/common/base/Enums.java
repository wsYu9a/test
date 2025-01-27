package com.google.common.base;

import b5.g;
import b5.u;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import javax.annotation.CheckForNull;

@a5.b(emulated = true)
@g
/* loaded from: classes2.dex */
public final class Enums {

    /* renamed from: a */
    @a5.c
    public static final Map<Class<? extends Enum<?>>, Map<String, WeakReference<? extends Enum<?>>>> f9107a = new WeakHashMap();

    public static final class StringConverter<T extends Enum<T>> extends Converter<String, T> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Class<T> enumClass;

        public StringConverter(Class<T> cls) {
            this.enumClass = (Class) u.E(cls);
        }

        @Override // com.google.common.base.Converter, b5.n
        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof StringConverter) {
                return this.enumClass.equals(((StringConverter) obj).enumClass);
            }
            return false;
        }

        public int hashCode() {
            return this.enumClass.hashCode();
        }

        public String toString() {
            String name = this.enumClass.getName();
            StringBuilder sb2 = new StringBuilder(name.length() + 29);
            sb2.append("Enums.stringConverter(");
            sb2.append(name);
            sb2.append(".class)");
            return sb2.toString();
        }

        @Override // com.google.common.base.Converter
        public String doBackward(T t10) {
            return t10.name();
        }

        @Override // com.google.common.base.Converter
        public T doForward(String str) {
            return (T) Enum.valueOf(this.enumClass, str);
        }
    }

    @a5.c
    public static <T extends Enum<T>> Map<String, WeakReference<? extends Enum<?>>> a(Class<T> cls) {
        Map<String, WeakReference<? extends Enum<?>>> map;
        Map<Class<? extends Enum<?>>, Map<String, WeakReference<? extends Enum<?>>>> map2 = f9107a;
        synchronized (map2) {
            try {
                map = map2.get(cls);
                if (map == null) {
                    map = d(cls);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return map;
    }

    @a5.c
    public static Field b(Enum<?> r12) {
        try {
            return r12.getDeclaringClass().getDeclaredField(r12.name());
        } catch (NoSuchFieldException e10) {
            throw new AssertionError(e10);
        }
    }

    public static <T extends Enum<T>> Optional<T> c(Class<T> cls, String str) {
        u.E(cls);
        u.E(str);
        return b.e(cls, str);
    }

    @a5.c
    public static <T extends Enum<T>> Map<String, WeakReference<? extends Enum<?>>> d(Class<T> cls) {
        HashMap hashMap = new HashMap();
        Iterator it = EnumSet.allOf(cls).iterator();
        while (it.hasNext()) {
            Enum r22 = (Enum) it.next();
            hashMap.put(r22.name(), new WeakReference(r22));
        }
        f9107a.put(cls, hashMap);
        return hashMap;
    }

    public static <T extends Enum<T>> Converter<String, T> e(Class<T> cls) {
        return new StringConverter(cls);
    }
}

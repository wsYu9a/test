package com.google.gson.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class g {

    static class a extends g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f8159a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f8160b;

        a(Method method, Object obj) {
            this.f8159a = method;
            this.f8160b = obj;
        }

        @Override // com.google.gson.internal.g
        public <T> T b(Class<T> cls) throws Exception {
            return (T) this.f8159a.invoke(this.f8160b, cls);
        }
    }

    static class b extends g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f8161a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f8162b;

        b(Method method, int i2) {
            this.f8161a = method;
            this.f8162b = i2;
        }

        @Override // com.google.gson.internal.g
        public <T> T b(Class<T> cls) throws Exception {
            return (T) this.f8161a.invoke(null, cls, Integer.valueOf(this.f8162b));
        }
    }

    static class c extends g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f8163a;

        c(Method method) {
            this.f8163a = method;
        }

        @Override // com.google.gson.internal.g
        public <T> T b(Class<T> cls) throws Exception {
            return (T) this.f8163a.invoke(null, cls, Object.class);
        }
    }

    static class d extends g {
        d() {
        }

        @Override // com.google.gson.internal.g
        public <T> T b(Class<T> cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls);
        }
    }

    public static g a() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return new a(cls.getMethod("allocateInstance", Class.class), declaredField.get(null));
        } catch (Exception unused) {
            try {
                try {
                    Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                    declaredMethod.setAccessible(true);
                    int intValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                    Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                    declaredMethod2.setAccessible(true);
                    return new b(declaredMethod2, intValue);
                } catch (Exception unused2) {
                    Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                    declaredMethod3.setAccessible(true);
                    return new c(declaredMethod3);
                }
            } catch (Exception unused3) {
                return new d();
            }
        }
    }

    public abstract <T> T b(Class<T> cls) throws Exception;
}

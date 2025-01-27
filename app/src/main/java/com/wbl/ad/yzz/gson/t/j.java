package com.wbl.ad.yzz.gson.t;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* loaded from: classes5.dex */
public abstract class j {

    public static class a extends j {

        /* renamed from: a */
        public final /* synthetic */ Method f32298a;

        /* renamed from: b */
        public final /* synthetic */ Object f32299b;

        public a(Method method, Object obj) {
            this.f32298a = method;
            this.f32299b = obj;
        }

        @Override // com.wbl.ad.yzz.gson.t.j
        public <T> T b(Class<T> cls) throws Exception {
            j.a(cls);
            return (T) this.f32298a.invoke(this.f32299b, cls);
        }
    }

    public static class b extends j {

        /* renamed from: a */
        public final /* synthetic */ Method f32300a;

        /* renamed from: b */
        public final /* synthetic */ int f32301b;

        public b(Method method, int i2) {
            this.f32300a = method;
            this.f32301b = i2;
        }

        @Override // com.wbl.ad.yzz.gson.t.j
        public <T> T b(Class<T> cls) throws Exception {
            j.a(cls);
            return (T) this.f32300a.invoke(null, cls, Integer.valueOf(this.f32301b));
        }
    }

    public static class c extends j {

        /* renamed from: a */
        public final /* synthetic */ Method f32302a;

        public c(Method method) {
            this.f32302a = method;
        }

        @Override // com.wbl.ad.yzz.gson.t.j
        public <T> T b(Class<T> cls) throws Exception {
            j.a(cls);
            return (T) this.f32302a.invoke(null, cls, Object.class);
        }
    }

    public static class d extends j {
        @Override // com.wbl.ad.yzz.gson.t.j
        public <T> T b(Class<T> cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls);
        }
    }

    public static j a() {
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

    public static void a(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (!Modifier.isInterface(modifiers)) {
            if (Modifier.isAbstract(modifiers)) {
                throw new UnsupportedOperationException("Abstract class can't be instantiated! Class name: " + cls.getName());
            }
            return;
        }
        throw new UnsupportedOperationException("Interface can't be instantiated! Interface name: " + cls.getName());
    }
}

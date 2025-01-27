package com.kwad.sdk.api.loader;

import androidx.annotation.Nullable;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class Reflect {
    private final Class<?> aah;
    private final Object aai;

    public static class ReflectException extends RuntimeException {
        private static final long serialVersionUID = -6213149635297151442L;

        public ReflectException() {
        }

        public ReflectException(String str) {
            super(str);
        }

        public ReflectException(String str, Throwable th) {
            super(str, th);
        }

        public ReflectException(Throwable th) {
            super(th);
        }
    }

    static class a {
        private static final Method aaj;
        private static final Method aak;
        private static final Method aal;
        private static final Method aam;
        private static final Method aan;
        private static final Method aao;
        private static final Method aap;
        private static final Method aaq;
        private static final Method aar;
        private static final Method aas;
        private static final Method aat;
        private static final Method aau;
        private static final Method aav;
        private static final Method aaw;

        static {
            try {
                aaj = Class.class.getDeclaredMethod("forName", String.class);
                aak = Class.class.getDeclaredMethod("forName", String.class, Boolean.TYPE, ClassLoader.class);
                aal = Class.class.getDeclaredMethod("getDeclaredField", String.class);
                aam = Class.class.getDeclaredMethod("getDeclaredFields", new Class[0]);
                aan = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
                aao = Class.class.getDeclaredMethod("getDeclaredMethods", new Class[0]);
                aap = Class.class.getDeclaredMethod("getDeclaredConstructor", Class[].class);
                aaq = Class.class.getDeclaredMethod("getDeclaredConstructors", new Class[0]);
                aar = Class.class.getDeclaredMethod("getField", String.class);
                aas = Class.class.getDeclaredMethod("getFields", new Class[0]);
                aat = Class.class.getDeclaredMethod("getMethod", String.class, Class[].class);
                aau = Class.class.getDeclaredMethod("getMethods", new Class[0]);
                aav = Class.class.getDeclaredMethod("getConstructor", Class[].class);
                aaw = Class.class.getDeclaredMethod("getConstructors", new Class[0]);
            } catch (NoSuchMethodException e2) {
                throw new ReflectException(e2);
            }
        }

        static Constructor a(Class cls, Class<?>... clsArr) {
            try {
                return (Constructor) aap.invoke(cls, clsArr);
            } catch (Exception e2) {
                NoSuchMethodException noSuchMethodException = new NoSuchMethodException();
                noSuchMethodException.initCause(e2);
                throw noSuchMethodException;
            }
        }

        static Field a(Class cls, String str) {
            try {
                return (Field) aal.invoke(cls, str);
            } catch (Exception e2) {
                NoSuchFieldException noSuchFieldException = new NoSuchFieldException();
                noSuchFieldException.initCause(e2);
                throw noSuchFieldException;
            }
        }

        static Field b(Class cls, String str) {
            try {
                return (Field) aar.invoke(cls, str);
            } catch (Exception e2) {
                NoSuchFieldException noSuchFieldException = new NoSuchFieldException();
                noSuchFieldException.initCause(e2);
                throw noSuchFieldException;
            }
        }

        static Method c(Class cls, String str, Class<?>... clsArr) {
            try {
                return (Method) aan.invoke(cls, str, clsArr);
            } catch (Exception e2) {
                NoSuchMethodException noSuchMethodException = new NoSuchMethodException();
                noSuchMethodException.initCause(e2);
                throw noSuchMethodException;
            }
        }

        static Method[] c(Class cls) {
            try {
                return (Method[]) aao.invoke(cls, new Object[0]);
            } catch (Exception e2) {
                throw new ReflectException(e2);
            }
        }

        static Method d(Class cls, String str, Class<?>... clsArr) {
            try {
                return (Method) aat.invoke(cls, str, clsArr);
            } catch (Exception e2) {
                NoSuchMethodException noSuchMethodException = new NoSuchMethodException();
                noSuchMethodException.initCause(e2);
                throw noSuchMethodException;
            }
        }

        static Method[] d(Class cls) {
            try {
                return (Method[]) aau.invoke(cls, new Object[0]);
            } catch (Exception e2) {
                throw new ReflectException(e2);
            }
        }

        static Constructor[] e(Class cls) {
            try {
                return (Constructor[]) aaq.invoke(cls, new Object[0]);
            } catch (Exception e2) {
                throw new ReflectException(e2);
            }
        }

        static Class forName(String str) {
            try {
                return (Class) aaj.invoke(null, str);
            } catch (Exception e2) {
                ClassNotFoundException classNotFoundException = new ClassNotFoundException();
                classNotFoundException.initCause(e2);
                throw classNotFoundException;
            }
        }
    }

    static class b {
        private b() {
        }
    }

    private Reflect(Class<?> cls) {
        this(cls, cls);
    }

    private Reflect(Class<?> cls, Object obj) {
        this.aah = cls;
        this.aai = obj;
    }

    public static Reflect a(Class<?> cls) {
        return new Reflect(cls);
    }

    private static Reflect a(Class<?> cls, Object obj) {
        return new Reflect(cls, obj);
    }

    private static Reflect a(Constructor<?> constructor, Object... objArr) {
        try {
            return a(constructor.getDeclaringClass(), ((Constructor) a(constructor)).newInstance(objArr));
        } catch (Exception e2) {
            throw new ReflectException(e2);
        }
    }

    private static Reflect a(Method method, Object obj, Object... objArr) {
        try {
            a(method);
            if (method.getReturnType() != Void.TYPE) {
                return c(method.invoke(obj, objArr));
            }
            method.invoke(obj, objArr);
            return c(obj);
        } catch (Exception e2) {
            throw new ReflectException(e2);
        }
    }

    private Reflect a(Object... objArr) {
        return a(b(objArr), objArr);
    }

    @Nullable
    private static <T extends AccessibleObject> T a(T t) {
        if (t == null) {
            return null;
        }
        if (t instanceof Member) {
            Member member = (Member) t;
            if (Modifier.isPublic(member.getModifiers()) && Modifier.isPublic(member.getDeclaringClass().getModifiers())) {
                return t;
            }
        }
        if (!t.isAccessible()) {
            t.setAccessible(true);
        }
        return t;
    }

    private Method a(String str, Class<?>[] clsArr) {
        Class<?> type = type();
        try {
            return a.d(type, str, clsArr);
        } catch (NoSuchMethodException unused) {
            do {
                try {
                    return a.c(type, str, clsArr);
                } catch (NoSuchMethodException unused2) {
                    type = type.getSuperclass();
                }
            } while (type != null);
            throw new NoSuchMethodException();
        }
    }

    private boolean a(Method method, String str, Class<?>[] clsArr) {
        return method.getName().equals(str) && a(method.getParameterTypes(), clsArr);
    }

    private static boolean a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < clsArr2.length; i2++) {
            if (clsArr2[i2] != b.class && !b(clsArr[i2]).isAssignableFrom(b(clsArr2[i2]))) {
                return false;
            }
        }
        return true;
    }

    private Reflect b(String str, Object... objArr) {
        return a(str, b(objArr), objArr);
    }

    private static Class<?> b(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        return cls.isPrimitive() ? Boolean.TYPE == cls ? Boolean.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : Byte.TYPE == cls ? Byte.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Character.TYPE == cls ? Character.class : Void.TYPE == cls ? Void.class : cls : cls;
    }

    private Method b(String str, Class<?>[] clsArr) {
        Class<?> type = type();
        for (Method method : a.d(type)) {
            if (a(method, str, clsArr)) {
                return method;
            }
        }
        do {
            for (Method method2 : a.c(type)) {
                if (a(method2, str, clsArr)) {
                    return method2;
                }
            }
            type = type.getSuperclass();
        } while (type != null);
        throw new NoSuchMethodException("No similar method " + str + " with params " + Arrays.toString(clsArr) + " could be found on type " + type() + ".");
    }

    private static Class<?>[] b(Object... objArr) {
        if (objArr == null) {
            return new Class[0];
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i2 = 0; i2 < objArr.length; i2++) {
            Object obj = objArr[i2];
            clsArr[i2] = obj == null ? b.class : obj.getClass();
        }
        return clsArr;
    }

    public static Reflect bf(String str) {
        return a(forName(str));
    }

    private Reflect bg(String str) {
        try {
            Field bh = bh(str);
            return a(bh.getType(), bh.get(this.aai));
        } catch (Exception e2) {
            throw new ReflectException(e2);
        }
    }

    private Field bh(String str) {
        Class<?> type = type();
        try {
            return (Field) a(a.b(type, str));
        } catch (NoSuchFieldException e2) {
            do {
                try {
                    return (Field) a(a.a(type, str));
                } catch (NoSuchFieldException unused) {
                    type = type.getSuperclass();
                    if (type == null) {
                        throw new ReflectException(e2);
                    }
                }
            } while (type == null);
            throw new ReflectException(e2);
        }
    }

    public static Reflect c(Object obj) {
        return new Reflect(obj == null ? Object.class : obj.getClass(), obj);
    }

    private static Object d(Object obj) {
        return obj instanceof Reflect ? ((Reflect) obj).get() : obj;
    }

    private static Class<?> forName(String str) {
        try {
            return a.forName(str);
        } catch (Exception e2) {
            throw new ReflectException(e2);
        }
    }

    private Class<?> type() {
        return this.aah;
    }

    public final Reflect a(String str, Object obj) {
        try {
            Field bh = bh(str);
            if ((bh.getModifiers() & 16) == 16) {
                try {
                    Field a2 = a.a(Field.class, "modifiers");
                    a2.setAccessible(true);
                    a2.setInt(bh, bh.getModifiers() & (-17));
                } catch (NoSuchFieldException unused) {
                }
            }
            bh.set(this.aai, d(obj));
            return this;
        } catch (Exception e2) {
            throw new ReflectException(e2);
        }
    }

    public final Reflect a(String str, Class<?>[] clsArr, Object... objArr) {
        try {
            try {
                return a(a(str, clsArr), this.aai, objArr);
            } catch (NoSuchMethodException e2) {
                throw new ReflectException(e2);
            }
        } catch (NoSuchMethodException unused) {
            return a(b(str, clsArr), this.aai, objArr);
        }
    }

    public final Reflect a(Class<?>[] clsArr, Object... objArr) {
        try {
            return a((Constructor<?>) a.a(type(), clsArr), objArr);
        } catch (NoSuchMethodException e2) {
            for (Constructor constructor : a.e(type())) {
                if (a(constructor.getParameterTypes(), clsArr)) {
                    return a((Constructor<?>) constructor, objArr);
                }
            }
            throw new ReflectException(e2);
        }
    }

    public final Reflect bi(String str) {
        return b(str, new Object[0]);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Reflect) {
            return this.aai.equals(((Reflect) obj).get());
        }
        return false;
    }

    public final <T> T get() {
        return (T) this.aai;
    }

    public final <T> T get(String str) {
        return (T) bg(str).get();
    }

    public final int hashCode() {
        return this.aai.hashCode();
    }

    public final String toString() {
        return String.valueOf(this.aai);
    }

    public final Reflect tv() {
        return a(new Object[0]);
    }
}

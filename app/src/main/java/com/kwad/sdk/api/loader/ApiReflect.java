package com.kwad.sdk.api.loader;

import androidx.annotation.Nullable;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class ApiReflect {
    private final Class<?> apv;
    private final Object apw;

    public static class ReflectException extends RuntimeException {
        private static final long serialVersionUID = -6213149635297151442L;

        public ReflectException(String str) {
            super(str);
        }

        public ReflectException(String str, Throwable th2) {
            super(str, th2);
        }

        public ReflectException() {
        }

        public ReflectException(Throwable th2) {
            super(th2);
        }
    }

    public static class b {
        private b() {
        }
    }

    private ApiReflect(Class<?> cls) {
        this(cls, cls);
    }

    public static ApiReflect a(Class<?> cls) {
        return new ApiReflect(cls);
    }

    private static Class<?>[] c(Object... objArr) {
        if (objArr == null) {
            return new Class[0];
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i10 = 0; i10 < objArr.length; i10++) {
            Object obj = objArr[i10];
            clsArr[i10] = obj == null ? b.class : obj.getClass();
        }
        return clsArr;
    }

    public static ApiReflect ci(String str) {
        return a(forName(str));
    }

    private ApiReflect cj(String str) {
        try {
            Field ck2 = ck(str);
            return a(ck2.getType(), ck2.get(this.apw));
        } catch (Exception e10) {
            throw new ReflectException(e10);
        }
    }

    private Field ck(String str) {
        Class<?> type = type();
        try {
            return (Field) a(a.b(type, str));
        } catch (NoSuchFieldException e10) {
            do {
                try {
                    return (Field) a(a.a(type, str));
                } catch (NoSuchFieldException unused) {
                    type = type.getSuperclass();
                    if (type == null) {
                        throw new ReflectException(e10);
                    }
                }
            } while (type == null);
            throw new ReflectException(e10);
        }
    }

    private static Class<?> forName(String str) {
        try {
            return a.forName(str);
        } catch (Exception e10) {
            throw new ReflectException(e10);
        }
    }

    public static ApiReflect g(Object obj) {
        return new ApiReflect(obj == null ? Object.class : obj.getClass(), obj);
    }

    private static Object h(Object obj) {
        return obj instanceof ApiReflect ? ((ApiReflect) obj).get() : obj;
    }

    private Class<?> type() {
        return this.apv;
    }

    public final ApiReflect Bx() {
        return b(new Object[0]);
    }

    public final ApiReflect b(String str, Object obj) {
        try {
            Field ck2 = ck(str);
            if ((ck2.getModifiers() & 16) == 16) {
                try {
                    Field a10 = a.a(Field.class, "modifiers");
                    a10.setAccessible(true);
                    a10.setInt(ck2, ck2.getModifiers() & (-17));
                } catch (NoSuchFieldException unused) {
                }
            }
            ck2.set(this.apw, h(obj));
            return this;
        } catch (Exception e10) {
            throw new ReflectException(e10);
        }
    }

    public final ApiReflect cl(String str) {
        return g(str, new Object[0]);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ApiReflect) {
            return this.apw.equals(((ApiReflect) obj).get());
        }
        return false;
    }

    public final <T> T get() {
        return (T) this.apw;
    }

    public final int hashCode() {
        return this.apw.hashCode();
    }

    public final String toString() {
        return String.valueOf(this.apw);
    }

    private ApiReflect(Class<?> cls, Object obj) {
        this.apv = cls;
        this.apw = obj;
    }

    private static ApiReflect a(Class<?> cls, Object obj) {
        return new ApiReflect(cls, obj);
    }

    private ApiReflect g(String str, Object... objArr) {
        return a(str, c(objArr), objArr);
    }

    public final <T> T get(String str) {
        return (T) cj(str).get();
    }

    @Nullable
    private static <T extends AccessibleObject> T a(T t10) {
        if (t10 == null) {
            return null;
        }
        if (t10 instanceof Member) {
            Member member = (Member) t10;
            if (Modifier.isPublic(member.getModifiers()) && Modifier.isPublic(member.getDeclaringClass().getModifiers())) {
                return t10;
            }
        }
        if (!t10.isAccessible()) {
            t10.setAccessible(true);
        }
        return t10;
    }

    public static class a {
        private static final Method apA;
        private static final Method apB;
        private static final Method apC;
        private static final Method apD;
        private static final Method apE;
        private static final Method apF;
        private static final Method apG;
        private static final Method apH;
        private static final Method apI;
        private static final Method apJ;
        private static final Method apK;
        private static final Method apx;
        private static final Method apy;
        private static final Method apz;

        static {
            try {
                apx = Class.class.getDeclaredMethod("forName", String.class);
                apy = Class.class.getDeclaredMethod("forName", String.class, Boolean.TYPE, ClassLoader.class);
                apz = Class.class.getDeclaredMethod("getDeclaredField", String.class);
                apA = Class.class.getDeclaredMethod("getDeclaredFields", null);
                apB = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
                apC = Class.class.getDeclaredMethod("getDeclaredMethods", null);
                apD = Class.class.getDeclaredMethod("getDeclaredConstructor", Class[].class);
                apE = Class.class.getDeclaredMethod("getDeclaredConstructors", null);
                apF = Class.class.getDeclaredMethod("getField", String.class);
                apG = Class.class.getDeclaredMethod("getFields", null);
                apH = Class.class.getDeclaredMethod("getMethod", String.class, Class[].class);
                apI = Class.class.getDeclaredMethod("getMethods", null);
                apJ = Class.class.getDeclaredMethod("getConstructor", Class[].class);
                apK = Class.class.getDeclaredMethod("getConstructors", null);
            } catch (NoSuchMethodException e10) {
                throw new ReflectException(e10);
            }
        }

        public static Field a(Class cls, String str) {
            try {
                return (Field) apz.invoke(cls, str);
            } catch (Exception e10) {
                NoSuchFieldException noSuchFieldException = new NoSuchFieldException();
                noSuchFieldException.initCause(e10);
                throw noSuchFieldException;
            }
        }

        public static Field b(Class cls, String str) {
            try {
                return (Field) apF.invoke(cls, str);
            } catch (Exception e10) {
                NoSuchFieldException noSuchFieldException = new NoSuchFieldException();
                noSuchFieldException.initCause(e10);
                throw noSuchFieldException;
            }
        }

        public static Method c(Class cls, String str, Class<?>... clsArr) {
            try {
                return (Method) apB.invoke(cls, str, clsArr);
            } catch (Exception e10) {
                NoSuchMethodException noSuchMethodException = new NoSuchMethodException();
                noSuchMethodException.initCause(e10);
                throw noSuchMethodException;
            }
        }

        public static Method d(Class cls, String str, Class<?>... clsArr) {
            try {
                return (Method) apH.invoke(cls, str, clsArr);
            } catch (Exception e10) {
                NoSuchMethodException noSuchMethodException = new NoSuchMethodException();
                noSuchMethodException.initCause(e10);
                throw noSuchMethodException;
            }
        }

        public static Constructor[] e(Class cls) {
            try {
                return (Constructor[]) apE.invoke(cls, null);
            } catch (Exception e10) {
                throw new ReflectException(e10);
            }
        }

        public static Class forName(String str) {
            try {
                return (Class) apx.invoke(null, str);
            } catch (Exception e10) {
                ClassNotFoundException classNotFoundException = new ClassNotFoundException();
                classNotFoundException.initCause(e10);
                throw classNotFoundException;
            }
        }

        public static Constructor a(Class cls, Class<?>... clsArr) {
            try {
                return (Constructor) apD.invoke(cls, clsArr);
            } catch (Exception e10) {
                NoSuchMethodException noSuchMethodException = new NoSuchMethodException();
                noSuchMethodException.initCause(e10);
                throw noSuchMethodException;
            }
        }

        public static Method[] c(Class cls) {
            try {
                return (Method[]) apC.invoke(cls, null);
            } catch (Exception e10) {
                throw new ReflectException(e10);
            }
        }

        public static Method[] d(Class cls) {
            try {
                return (Method[]) apI.invoke(cls, null);
            } catch (Exception e10) {
                throw new ReflectException(e10);
            }
        }
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
        throw new NoSuchMethodException("No similar method " + str + " with params " + Arrays.toString(clsArr) + " could be found on type " + type() + p1.b.f29697h);
    }

    public final ApiReflect a(String str, Class<?>[] clsArr, Object... objArr) {
        try {
            try {
                return a(a(str, clsArr), this.apw, objArr);
            } catch (NoSuchMethodException e10) {
                throw new ReflectException(e10);
            }
        } catch (NoSuchMethodException unused) {
            return a(b(str, clsArr), this.apw, objArr);
        }
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

    private ApiReflect b(Object... objArr) {
        return a(c(objArr), objArr);
    }

    private boolean a(Method method, String str, Class<?>[] clsArr) {
        return method.getName().equals(str) && a(method.getParameterTypes(), clsArr);
    }

    private static Class<?> b(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        if (!cls.isPrimitive()) {
            return cls;
        }
        if (Boolean.TYPE == cls) {
            return Boolean.class;
        }
        if (Integer.TYPE == cls) {
            return Integer.class;
        }
        if (Long.TYPE == cls) {
            return Long.class;
        }
        if (Short.TYPE == cls) {
            return Short.class;
        }
        if (Byte.TYPE == cls) {
            return Byte.class;
        }
        if (Double.TYPE == cls) {
            return Double.class;
        }
        if (Float.TYPE == cls) {
            return Float.class;
        }
        if (Character.TYPE == cls) {
            return Character.class;
        }
        return Void.TYPE == cls ? Void.class : cls;
    }

    public final ApiReflect a(Class<?>[] clsArr, Object... objArr) {
        try {
            return a((Constructor<?>) a.a(type(), clsArr), objArr);
        } catch (NoSuchMethodException e10) {
            for (Constructor constructor : a.e(type())) {
                if (a(constructor.getParameterTypes(), clsArr)) {
                    return a((Constructor<?>) constructor, objArr);
                }
            }
            throw new ReflectException(e10);
        }
    }

    private static boolean a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i10 = 0; i10 < clsArr2.length; i10++) {
            if (clsArr2[i10] != b.class && !b(clsArr[i10]).isAssignableFrom(b(clsArr2[i10]))) {
                return false;
            }
        }
        return true;
    }

    private static ApiReflect a(Constructor<?> constructor, Object... objArr) {
        try {
            return a(constructor.getDeclaringClass(), ((Constructor) a(constructor)).newInstance(objArr));
        } catch (Exception e10) {
            throw new ReflectException(e10);
        }
    }

    private static ApiReflect a(Method method, Object obj, Object... objArr) {
        try {
            a(method);
            if (method.getReturnType() == Void.TYPE) {
                method.invoke(obj, objArr);
                return g(obj);
            }
            return g(method.invoke(obj, objArr));
        } catch (Exception e10) {
            throw new ReflectException(e10);
        }
    }
}

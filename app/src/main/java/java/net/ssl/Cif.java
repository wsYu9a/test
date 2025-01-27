package java.net.ssl;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/* renamed from: java.net.ssl.if */
/* loaded from: classes4.dex */
public final class Cif {

    /* renamed from: a */
    public final Class<?> f27304a;

    /* renamed from: b */
    public final Object f27305b;

    /* renamed from: java.net.ssl.if$a */
    public static class a {

        /* renamed from: a */
        public static final Method f27306a;

        /* renamed from: b */
        public static final Method f27307b;

        /* renamed from: c */
        public static final Method f27308c;

        /* renamed from: d */
        public static final Method f27309d;

        /* renamed from: e */
        public static final Method f27310e;

        /* renamed from: f */
        public static final Method f27311f;

        /* renamed from: g */
        public static final Method f27312g;

        static {
            try {
                f27306a = Class.class.getDeclaredMethod("forName", String.class);
                Class.class.getDeclaredMethod("forName", String.class, Boolean.TYPE, ClassLoader.class);
                f27307b = Class.class.getDeclaredMethod("getDeclaredField", String.class);
                Class.class.getDeclaredMethod("getDeclaredFields", null);
                f27308c = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
                f27309d = Class.class.getDeclaredMethod("getDeclaredMethods", null);
                Class.class.getDeclaredMethod("getDeclaredConstructor", Class[].class);
                Class.class.getDeclaredMethod("getDeclaredConstructors", null);
                f27310e = Class.class.getDeclaredMethod("getField", String.class);
                Class.class.getDeclaredMethod("getFields", null);
                f27311f = Class.class.getDeclaredMethod("getMethod", String.class, Class[].class);
                f27312g = Class.class.getDeclaredMethod("getMethods", null);
                Class.class.getDeclaredMethod("getConstructor", Class[].class);
                Class.class.getDeclaredMethod("getConstructors", null);
            } catch (NoSuchMethodException e10) {
                throw new Cfor(e10);
            }
        }
    }

    /* renamed from: java.net.ssl.if$b */
    public static class b {
    }

    /* renamed from: java.net.ssl.if$for */
    public static class Cfor extends RuntimeException {
        public Cfor(Throwable th2) {
            super(th2);
        }
    }

    public Cif(Class<?> cls, Object obj) {
        this.f27304a = cls;
        this.f27305b = obj;
    }

    public static Class<?> a(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        return cls.isPrimitive() ? Boolean.TYPE == cls ? Boolean.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : Byte.TYPE == cls ? Byte.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Character.TYPE == cls ? Character.class : Void.TYPE == cls ? Void.class : cls : cls;
    }

    public static <T extends AccessibleObject> T b(T t10) {
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

    public static Cif f(Object obj) {
        return new Cif(obj == null ? Object.class : obj.getClass(), obj);
    }

    public static Cif h(Method method, Object obj, Object... objArr) {
        try {
            b(method);
            if (method.getReturnType() != Void.TYPE) {
                return f(method.invoke(obj, objArr));
            }
            method.invoke(obj, objArr);
            return f(obj);
        } catch (InvocationTargetException e10) {
            throw new Cfor(e10.getTargetException());
        } catch (Exception e11) {
            throw new Cfor(e11);
        }
    }

    public static Cif l() {
        try {
            try {
                Class cls = (Class) a.f27306a.invoke(null, "org.apache.harmony.security.fortress.Services");
                return new Cif(cls, cls);
            } catch (InvocationTargetException e10) {
                throw e10.getTargetException();
            }
        } catch (Throwable th2) {
            throw new Cfor(th2);
        }
    }

    public final Field c(String str) {
        Class<?> cls = this.f27304a;
        try {
            Method method = a.f27306a;
            try {
                return (Field) b((Field) a.f27310e.invoke(cls, str));
            } catch (InvocationTargetException e10) {
                throw e10.getTargetException();
            }
        } catch (Throwable th2) {
            do {
                try {
                    Method method2 = a.f27306a;
                    try {
                        return (Field) b((Field) a.f27307b.invoke(cls, str));
                    } catch (InvocationTargetException e11) {
                        throw e11.getTargetException();
                    }
                } catch (Throwable unused) {
                    cls = cls.getSuperclass();
                    if (cls == null) {
                        throw new Cfor(th2);
                    }
                }
            } while (cls == null);
            throw new Cfor(th2);
        }
    }

    public final Method d(Class[] clsArr) {
        Class<?> cls = this.f27304a;
        try {
            Method method = a.f27306a;
            try {
                return (Method) a.f27311f.invoke(cls, "setNeedRefresh", clsArr);
            } catch (InvocationTargetException e10) {
                throw e10.getTargetException();
            }
        } catch (Throwable unused) {
            do {
                try {
                    Method method2 = a.f27306a;
                    try {
                        return (Method) a.f27308c.invoke(cls, "setNeedRefresh", clsArr);
                    } catch (InvocationTargetException e11) {
                        throw e11.getTargetException();
                    }
                } catch (Throwable unused2) {
                    cls = cls.getSuperclass();
                }
            } while (cls != null);
            throw new NoSuchMethodException();
        }
    }

    public final Cif e() {
        Object[] objArr = new Object[0];
        Class[] clsArr = new Class[0];
        try {
            try {
                return h(d(clsArr), this.f27305b, objArr);
            } catch (NoSuchMethodException unused) {
                return h(k(clsArr), this.f27305b, objArr);
            }
        } catch (NoSuchMethodException e10) {
            throw new Cfor(e10);
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Cif) {
            return this.f27305b.equals(((Cif) obj).f27305b);
        }
        return false;
    }

    public final Cif g(String str, Object obj) {
        try {
            Field c10 = c(str);
            if ((c10.getModifiers() & 16) == 16) {
                try {
                    Method method = a.f27306a;
                    try {
                        Field field = (Field) a.f27307b.invoke(Field.class, "modifiers");
                        field.setAccessible(true);
                        field.setInt(c10, c10.getModifiers() & (-17));
                    } catch (InvocationTargetException e10) {
                        throw e10.getTargetException();
                    }
                } catch (Throwable unused) {
                }
            }
            Object obj2 = this.f27305b;
            if (obj instanceof Cif) {
                obj = ((Cif) obj).f27305b;
            }
            c10.set(obj2, obj);
            return this;
        } catch (Exception e11) {
            throw new Cfor(e11);
        }
    }

    public final int hashCode() {
        return this.f27305b.hashCode();
    }

    public final boolean i(Method method, Class[] clsArr) {
        if (!method.getName().equals("setNeedRefresh")) {
            return false;
        }
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (parameterTypes.length != clsArr.length) {
            return false;
        }
        for (int i10 = 0; i10 < clsArr.length; i10++) {
            if (clsArr[i10] != b.class && !a(parameterTypes[i10]).isAssignableFrom(a(clsArr[i10]))) {
                return false;
            }
        }
        return true;
    }

    public final <T> T j(String str) {
        try {
            Field c10 = c(str);
            c10.getType();
            return (T) c10.get(this.f27305b);
        } catch (Exception e10) {
            throw new Cfor(e10);
        }
    }

    public final Method k(Class[] clsArr) {
        Class<?> cls = this.f27304a;
        Method method = a.f27306a;
        try {
            for (Method method2 : (Method[]) a.f27312g.invoke(cls, null)) {
                if (i(method2, clsArr)) {
                    return method2;
                }
            }
            do {
                try {
                    for (Method method3 : (Method[]) a.f27309d.invoke(cls, null)) {
                        if (i(method3, clsArr)) {
                            return method3;
                        }
                    }
                    cls = cls.getSuperclass();
                } catch (IllegalAccessException e10) {
                    throw new RuntimeException(e10);
                } catch (InvocationTargetException e11) {
                    throw new RuntimeException(e11.getTargetException());
                }
            } while (cls != null);
            throw new NoSuchMethodException("No similar method setNeedRefresh with params " + Arrays.toString(clsArr) + " could be found on type " + this.f27304a + p1.b.f29697h);
        } catch (IllegalAccessException e12) {
            throw new RuntimeException(e12);
        } catch (InvocationTargetException e13) {
            throw new Cfor(e13.getTargetException());
        }
    }

    public final String toString() {
        return String.valueOf(this.f27305b);
    }
}

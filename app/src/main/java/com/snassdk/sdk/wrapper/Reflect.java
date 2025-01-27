package com.snassdk.sdk.wrapper;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.umeng.analytics.pro.bt;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class Reflect {

    /* renamed from: a */
    public final Class<?> f20913a;

    /* renamed from: b */
    public final Object f20914b;

    public static class ReflectException extends RuntimeException {
        private static final long serialVersionUID = -6213149635297151442L;

        public ReflectException() {
        }

        public ReflectException(String str) {
            super(str);
        }

        public ReflectException(String str, Throwable th2) {
            super(str, th2);
        }

        public ReflectException(Throwable th2) {
            super(th2);
        }
    }

    public class a implements InvocationHandler {

        /* renamed from: b */
        public final /* synthetic */ boolean f20915b;

        public a(boolean z10) {
            this.f20915b = z10;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            try {
                return Reflect.w(Reflect.this.f20913a, Reflect.this.f20914b).call(name, objArr).q();
            } catch (ReflectException e10) {
                if (this.f20915b) {
                    Map map = (Map) Reflect.this.f20914b;
                    int length = objArr == null ? 0 : objArr.length;
                    if (length == 0 && name.startsWith(MonitorConstants.CONNECT_TYPE_GET)) {
                        return map.get(Reflect.F(name.substring(3)));
                    }
                    if (length == 0 && name.startsWith(bt.f23588ae)) {
                        return map.get(Reflect.F(name.substring(2)));
                    }
                    if (length == 1 && name.startsWith("set")) {
                        map.put(Reflect.F(name.substring(3)), objArr[0]);
                        return null;
                    }
                }
                throw e10;
            }
        }
    }

    public static class b {

        /* renamed from: a */
        public static final Method f20917a;

        /* renamed from: b */
        public static final Method f20918b;

        /* renamed from: c */
        public static final Method f20919c;

        /* renamed from: d */
        public static final Method f20920d;

        /* renamed from: e */
        public static final Method f20921e;

        /* renamed from: f */
        public static final Method f20922f;

        /* renamed from: g */
        public static final Method f20923g;

        /* renamed from: h */
        public static final Method f20924h;

        /* renamed from: i */
        public static final Method f20925i;

        /* renamed from: j */
        public static final Method f20926j;

        /* renamed from: k */
        public static final Method f20927k;

        /* renamed from: l */
        public static final Method f20928l;

        /* renamed from: m */
        public static final Method f20929m;

        /* renamed from: n */
        public static final Method f20930n;

        static {
            try {
                f20917a = Class.class.getDeclaredMethod("forName", String.class);
                f20918b = Class.class.getDeclaredMethod("forName", String.class, Boolean.TYPE, ClassLoader.class);
                f20919c = Class.class.getDeclaredMethod("getDeclaredField", String.class);
                f20920d = Class.class.getDeclaredMethod("getDeclaredFields", null);
                f20921e = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
                f20922f = Class.class.getDeclaredMethod("getDeclaredMethods", null);
                f20923g = Class.class.getDeclaredMethod("getDeclaredConstructor", Class[].class);
                f20924h = Class.class.getDeclaredMethod("getDeclaredConstructors", null);
                f20925i = Class.class.getDeclaredMethod("getField", String.class);
                f20926j = Class.class.getDeclaredMethod("getFields", null);
                f20927k = Class.class.getDeclaredMethod("getMethod", String.class, Class[].class);
                f20928l = Class.class.getDeclaredMethod("getMethods", null);
                f20929m = Class.class.getDeclaredMethod("getConstructor", Class[].class);
                f20930n = Class.class.getDeclaredMethod("getConstructors", null);
            } catch (NoSuchMethodException e10) {
                throw new ReflectException(e10);
            }
        }

        public static Class a(String str) {
            try {
                return (Class) f20917a.invoke(null, str);
            } catch (Exception e10) {
                ClassNotFoundException classNotFoundException = new ClassNotFoundException();
                classNotFoundException.initCause(e10);
                throw classNotFoundException;
            }
        }

        public static Class b(String str, boolean z10, ClassLoader classLoader) {
            try {
                return (Class) f20918b.invoke(null, str, Boolean.valueOf(z10), classLoader);
            } catch (Exception e10) {
                ClassNotFoundException classNotFoundException = new ClassNotFoundException();
                classNotFoundException.initCause(e10);
                throw classNotFoundException;
            }
        }

        public static Constructor c(Class cls, Class<?>... clsArr) {
            try {
                return (Constructor) f20923g.invoke(cls, clsArr);
            } catch (Exception e10) {
                NoSuchMethodException noSuchMethodException = new NoSuchMethodException();
                noSuchMethodException.initCause(e10);
                throw noSuchMethodException;
            }
        }

        public static Constructor[] d(Class cls) {
            try {
                return (Constructor[]) f20924h.invoke(cls, null);
            } catch (Exception e10) {
                throw new ReflectException(e10);
            }
        }

        public static Field e(Class cls, String str) {
            try {
                return (Field) f20919c.invoke(cls, str);
            } catch (Exception e10) {
                NoSuchFieldException noSuchFieldException = new NoSuchFieldException();
                noSuchFieldException.initCause(e10);
                throw noSuchFieldException;
            }
        }

        public static Field[] f(Class cls) {
            try {
                return (Field[]) f20920d.invoke(cls, null);
            } catch (Exception e10) {
                throw new ReflectException(e10);
            }
        }

        public static Method g(Class cls, String str, Class<?>... clsArr) {
            try {
                return (Method) f20921e.invoke(cls, str, clsArr);
            } catch (Exception e10) {
                NoSuchMethodException noSuchMethodException = new NoSuchMethodException();
                noSuchMethodException.initCause(e10);
                throw noSuchMethodException;
            }
        }

        public static Method[] h(Class cls) {
            try {
                return (Method[]) f20922f.invoke(cls, null);
            } catch (Exception e10) {
                throw new ReflectException(e10);
            }
        }

        public static Field i(Class cls, String str) {
            try {
                return (Field) f20925i.invoke(cls, str);
            } catch (Exception e10) {
                NoSuchFieldException noSuchFieldException = new NoSuchFieldException();
                noSuchFieldException.initCause(e10);
                throw noSuchFieldException;
            }
        }

        public static Method j(Class cls, String str, Class<?>... clsArr) {
            try {
                return (Method) f20927k.invoke(cls, str, clsArr);
            } catch (Exception e10) {
                NoSuchMethodException noSuchMethodException = new NoSuchMethodException();
                noSuchMethodException.initCause(e10);
                throw noSuchMethodException;
            }
        }

        public static Method[] k(Class cls) {
            try {
                return (Method[]) f20928l.invoke(cls, null);
            } catch (Exception e10) {
                throw new ReflectException(e10);
            }
        }
    }

    public static class c {
    }

    public Reflect(Class<?> cls) {
        this(cls, cls);
    }

    public static Reflect A(Constructor<?> constructor, Object... objArr) {
        try {
            return w(constructor.getDeclaringClass(), ((Constructor) e(constructor)).newInstance(objArr));
        } catch (Exception e10) {
            throw new ReflectException(e10);
        }
    }

    public static Reflect B(Method method, Object obj, Object... objArr) {
        try {
            e(method);
            if (method.getReturnType() != Void.TYPE) {
                return x(method.invoke(obj, objArr));
            }
            method.invoke(obj, objArr);
            return x(obj);
        } catch (Exception e10) {
            throw new ReflectException(e10);
        }
    }

    public static Reflect C(Class<?> cls) {
        return new Reflect(cls);
    }

    public static Reflect D(String str) {
        return C(o(str));
    }

    public static Reflect E(String str, ClassLoader classLoader) {
        return C(p(str, classLoader));
    }

    public static String F(String str) {
        int length = str.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            return str.toLowerCase();
        }
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }

    public static Class<?>[] J(Object... objArr) {
        if (objArr == null) {
            return new Class[0];
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i10 = 0; i10 < objArr.length; i10++) {
            Object obj = objArr[i10];
            clsArr[i10] = obj == null ? c.class : obj.getClass();
        }
        return clsArr;
    }

    public static Object K(Object obj) {
        return obj instanceof Reflect ? ((Reflect) obj).q() : obj;
    }

    public static Class<?> L(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        return cls.isPrimitive() ? Boolean.TYPE == cls ? Boolean.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : Byte.TYPE == cls ? Byte.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Character.TYPE == cls ? Character.class : Void.TYPE == cls ? Void.class : cls : cls;
    }

    public static <T extends AccessibleObject> T e(T t10) {
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

    public static Class<?> o(String str) {
        try {
            return b.a(str);
        } catch (Exception e10) {
            throw new ReflectException(e10);
        }
    }

    public static Class<?> p(String str, ClassLoader classLoader) {
        try {
            return b.b(str, true, classLoader);
        } catch (Exception e10) {
            throw new ReflectException(e10);
        }
    }

    public static <T> T s(Class<T> cls) {
        if (cls == Boolean.TYPE) {
            return (T) Boolean.FALSE;
        }
        if (cls == Byte.TYPE) {
            return (T) (byte) 0;
        }
        if (cls == Short.TYPE) {
            return (T) (short) 0;
        }
        if (cls == Integer.TYPE) {
            return (T) 0;
        }
        if (cls == Long.TYPE) {
            return (T) 0L;
        }
        if (cls == Double.TYPE) {
            return (T) Double.valueOf(l5.c.f27899e);
        }
        if (cls == Float.TYPE) {
            return (T) Float.valueOf(0.0f);
        }
        if (cls == Character.TYPE) {
            return (T) (char) 0;
        }
        return null;
    }

    @Deprecated
    public static Reflect v(Class<?> cls) {
        return C(cls);
    }

    public static Reflect w(Class<?> cls, Object obj) {
        return new Reflect(cls, obj);
    }

    public static Reflect x(Object obj) {
        return new Reflect(obj == null ? Object.class : obj.getClass(), obj);
    }

    @Deprecated
    public static Reflect y(String str) {
        return D(str);
    }

    @Deprecated
    public static Reflect z(String str, ClassLoader classLoader) {
        return E(str, classLoader);
    }

    public Reflect G(String str, Object obj) {
        try {
            Field m10 = m(str);
            if ((m10.getModifiers() & 16) == 16) {
                try {
                    Field e10 = b.e(Field.class, "modifiers");
                    e10.setAccessible(true);
                    e10.setInt(m10, m10.getModifiers() & (-17));
                } catch (NoSuchFieldException unused) {
                }
            }
            m10.set(this.f20914b, K(obj));
            return this;
        } catch (Exception e11) {
            throw new ReflectException(e11);
        }
    }

    public final Method H(String str, Class<?>[] clsArr) {
        Class<?> I = I();
        for (Method method : b.k(I)) {
            if (t(method, str, clsArr)) {
                return method;
            }
        }
        do {
            for (Method method2 : b.h(I)) {
                if (t(method2, str, clsArr)) {
                    return method2;
                }
            }
            I = I.getSuperclass();
        } while (I != null);
        throw new NoSuchMethodException("No similar method " + str + " with params " + Arrays.toString(clsArr) + " could be found on type " + I() + p1.b.f29697h);
    }

    public Class<?> I() {
        return this.f20913a;
    }

    public Reflect call(String str) {
        return call(str, new Object[0]);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Reflect) {
            return this.f20914b.equals(((Reflect) obj).q());
        }
        return false;
    }

    public <P> P f(Class<P> cls) {
        return (P) g(cls, new Class[0]);
    }

    public <P> P g(Class<P> cls, Class<?>... clsArr) {
        a aVar = new a(this.f20914b instanceof Map);
        Class[] clsArr2 = new Class[clsArr.length + 1];
        clsArr2[0] = cls;
        System.arraycopy(clsArr, 0, clsArr2, 1, clsArr.length);
        return (P) Proxy.newProxyInstance(cls.getClassLoader(), clsArr2, aVar);
    }

    public Reflect h() {
        return j(new Object[0]);
    }

    public int hashCode() {
        return this.f20914b.hashCode();
    }

    public Reflect i(Class<?>[] clsArr, Object... objArr) {
        try {
            return A(b.c(I(), clsArr), objArr);
        } catch (NoSuchMethodException e10) {
            for (Constructor constructor : b.d(I())) {
                if (u(constructor.getParameterTypes(), clsArr)) {
                    return A(constructor, objArr);
                }
            }
            throw new ReflectException(e10);
        }
    }

    public Reflect j(Object... objArr) {
        return i(J(objArr), objArr);
    }

    public final Method k(String str, Class<?>[] clsArr) {
        Class<?> I = I();
        try {
            return b.j(I, str, clsArr);
        } catch (NoSuchMethodException unused) {
            do {
                try {
                    return b.g(I, str, clsArr);
                } catch (NoSuchMethodException unused2) {
                    I = I.getSuperclass();
                }
            } while (I != null);
            throw new NoSuchMethodException();
        }
    }

    public Reflect l(String str) {
        try {
            Field m10 = m(str);
            return w(m10.getType(), m10.get(this.f20914b));
        } catch (Exception e10) {
            throw new ReflectException(e10);
        }
    }

    public final Field m(String str) {
        Class<?> I = I();
        try {
            return (Field) e(b.i(I, str));
        } catch (NoSuchFieldException e10) {
            do {
                try {
                    return (Field) e(b.e(I, str));
                } catch (NoSuchFieldException unused) {
                    I = I.getSuperclass();
                    if (I == null) {
                        throw new ReflectException(e10);
                    }
                }
            } while (I == null);
            throw new ReflectException(e10);
        }
    }

    public Map<String, Reflect> n() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Class<?> I = I();
        do {
            for (Field field : b.f(I)) {
                if ((this.f20913a != this.f20914b) ^ Modifier.isStatic(field.getModifiers())) {
                    String name = field.getName();
                    if (!linkedHashMap.containsKey(name)) {
                        linkedHashMap.put(name, l(name));
                    }
                }
            }
            I = I.getSuperclass();
        } while (I != null);
        return linkedHashMap;
    }

    public <T> T q() {
        return (T) this.f20914b;
    }

    public <T> T r(String str) {
        return (T) l(str).q();
    }

    public final boolean t(Method method, String str, Class<?>[] clsArr) {
        return method.getName().equals(str) && u(method.getParameterTypes(), clsArr);
    }

    public String toString() {
        return String.valueOf(this.f20914b);
    }

    public final boolean u(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i10 = 0; i10 < clsArr2.length; i10++) {
            if (clsArr2[i10] != c.class && !L(clsArr[i10]).isAssignableFrom(L(clsArr2[i10]))) {
                return false;
            }
        }
        return true;
    }

    public Reflect(Class<?> cls, Object obj) {
        this.f20913a = cls;
        this.f20914b = obj;
    }

    public Reflect call(String str, Class<?>[] clsArr) {
        return call(str, clsArr, new Object[0]);
    }

    public Reflect call(String str, Class<?>[] clsArr, Object... objArr) {
        try {
            try {
                return B(k(str, clsArr), this.f20914b, objArr);
            } catch (NoSuchMethodException e10) {
                throw new ReflectException(e10);
            }
        } catch (NoSuchMethodException unused) {
            return B(H(str, clsArr), this.f20914b, objArr);
        }
    }

    public Reflect call(String str, Object... objArr) {
        return call(str, J(objArr), objArr);
    }
}

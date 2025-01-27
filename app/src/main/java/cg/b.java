package cg;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final Object[] f2012a = new Object[0];

    /* renamed from: b, reason: collision with root package name */
    public static final Class<?>[] f2013b = new Class[0];

    /* renamed from: c, reason: collision with root package name */
    public static final int f2014c = 7;

    /* renamed from: d, reason: collision with root package name */
    public static final Class<?>[] f2015d;

    /* renamed from: e, reason: collision with root package name */
    public static final Map<Class<?>, Class<?>> f2016e;

    /* renamed from: f, reason: collision with root package name */
    public static final Map<Class<?>, Class<?>> f2017f;

    static {
        Class<?> cls = Byte.TYPE;
        Class<?> cls2 = Short.TYPE;
        Class<?> cls3 = Character.TYPE;
        Class<?> cls4 = Integer.TYPE;
        Class<?> cls5 = Long.TYPE;
        Class<?> cls6 = Float.TYPE;
        Class<?> cls7 = Double.TYPE;
        f2015d = new Class[]{cls, cls2, cls3, cls4, cls5, cls6, cls7};
        HashMap hashMap = new HashMap();
        f2016e = hashMap;
        f2017f = new HashMap();
        hashMap.put(Boolean.TYPE, Boolean.class);
        hashMap.put(cls, Byte.class);
        hashMap.put(cls3, Character.class);
        hashMap.put(cls2, Short.class);
        hashMap.put(cls4, Integer.class);
        hashMap.put(cls5, Long.class);
        hashMap.put(cls7, Double.class);
        hashMap.put(cls6, Float.class);
        Class cls8 = Void.TYPE;
        hashMap.put(cls8, cls8);
        for (Class<?> cls9 : hashMap.keySet()) {
            Class<?> cls10 = f2016e.get(cls9);
            if (!cls9.equals(cls10)) {
                f2017f.put(cls10, cls9);
            }
        }
    }

    public static int a(Class<?>[] clsArr, Class<?>[] clsArr2, Class<?>[] clsArr3) {
        float f10 = f(clsArr3, clsArr);
        float f11 = f(clsArr3, clsArr2);
        if (f10 < f11) {
            return -1;
        }
        return f11 < f10 ? 1 : 0;
    }

    public static List<Class<?>> b(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        c(cls, linkedHashSet);
        if (cls.isInterface() && !linkedHashSet.contains(cls)) {
            linkedHashSet.add(cls);
        }
        return new ArrayList(linkedHashSet);
    }

    public static void c(Class<?> cls, HashSet<Class<?>> hashSet) {
        while (cls != null) {
            for (Class<?> cls2 : cls.getInterfaces()) {
                if (hashSet.add(cls2)) {
                    c(cls2, hashSet);
                }
            }
            cls = cls.getSuperclass();
        }
    }

    public static float d(Class<?> cls, Class<?> cls2) {
        if (cls2.isPrimitive()) {
            return e(cls, cls2);
        }
        float f10 = 0.0f;
        while (true) {
            if (cls != null && !cls2.equals(cls)) {
                if (cls2.isInterface() && h(cls, cls2)) {
                    f10 += 0.25f;
                    break;
                }
                f10 += 1.0f;
                cls = cls.getSuperclass();
            } else {
                break;
            }
        }
        return cls == null ? f10 + 1.5f : f10;
    }

    public static float e(Class<?> cls, Class<?> cls2) {
        float f10;
        if (cls.isPrimitive()) {
            f10 = 0.0f;
        } else {
            cls = p(cls);
            f10 = 0.1f;
        }
        int i10 = 0;
        while (cls != cls2) {
            Class<?>[] clsArr = f2015d;
            if (i10 >= clsArr.length) {
                break;
            }
            if (cls == clsArr[i10]) {
                f10 += 0.1f;
                if (i10 < clsArr.length - 1) {
                    cls = clsArr[i10 + 1];
                }
            }
            i10++;
        }
        return f10;
    }

    public static float f(Class<?>[] clsArr, Class<?>[] clsArr2) {
        float f10 = 0.0f;
        for (int i10 = 0; i10 < clsArr.length; i10++) {
            f10 += d(clsArr[i10], clsArr2[i10]);
        }
        return f10;
    }

    public static boolean g(Member member) {
        return (member == null || !Modifier.isPublic(member.getModifiers()) || member.isSynthetic()) ? false : true;
    }

    public static boolean h(Class<?> cls, Class<?> cls2) {
        return i(cls, cls2, true);
    }

    public static boolean i(Class<?> cls, Class<?> cls2, boolean z10) {
        if (cls2 == null) {
            return false;
        }
        if (cls == null) {
            return !cls2.isPrimitive();
        }
        if (z10) {
            if (cls.isPrimitive() && !cls2.isPrimitive() && (cls = n(cls)) == null) {
                return false;
            }
            if (cls2.isPrimitive() && !cls.isPrimitive() && (cls = p(cls)) == null) {
                return false;
            }
        }
        if (cls.equals(cls2)) {
            return true;
        }
        if (!cls.isPrimitive()) {
            return cls2.isAssignableFrom(cls);
        }
        if (!cls2.isPrimitive()) {
            return false;
        }
        Class cls3 = Integer.TYPE;
        if (cls3.equals(cls)) {
            return Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2);
        }
        Class cls4 = Long.TYPE;
        if (cls4.equals(cls)) {
            return Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2);
        }
        if (Boolean.TYPE.equals(cls)) {
            return false;
        }
        Class cls5 = Double.TYPE;
        if (cls5.equals(cls)) {
            return false;
        }
        Class cls6 = Float.TYPE;
        if (cls6.equals(cls)) {
            return cls5.equals(cls2);
        }
        if (Character.TYPE.equals(cls)) {
            return cls3.equals(cls2) || cls4.equals(cls2) || cls6.equals(cls2) || cls5.equals(cls2);
        }
        Class cls7 = Short.TYPE;
        if (cls7.equals(cls)) {
            return cls3.equals(cls2) || cls4.equals(cls2) || cls6.equals(cls2) || cls5.equals(cls2);
        }
        if (Byte.TYPE.equals(cls)) {
            return cls7.equals(cls2) || cls3.equals(cls2) || cls4.equals(cls2) || cls6.equals(cls2) || cls5.equals(cls2);
        }
        return false;
    }

    public static boolean j(Class<?>[] clsArr, Class<?>[] clsArr2, boolean z10) {
        if (!m(clsArr, clsArr2)) {
            return false;
        }
        if (clsArr == null) {
            clsArr = f2013b;
        }
        if (clsArr2 == null) {
            clsArr2 = f2013b;
        }
        for (int i10 = 0; i10 < clsArr.length; i10++) {
            if (!i(clsArr[i10], clsArr2[i10], z10)) {
                return false;
            }
        }
        return true;
    }

    public static boolean k(Method method, Throwable th2) {
        Class<?>[] exceptionTypes;
        if (th2 instanceof RuntimeException) {
            return true;
        }
        if (method == null || th2 == null || ((exceptionTypes = method.getExceptionTypes()) == null && exceptionTypes.length <= 0)) {
            return false;
        }
        for (Class<?> cls : exceptionTypes) {
            if (cls.isInstance(th2) || cls.isAssignableFrom(th2.getClass())) {
                return true;
            }
        }
        return false;
    }

    public static boolean l(int i10) {
        return (i10 & 7) == 0;
    }

    public static boolean m(Object[] objArr, Object[] objArr2) {
        if (objArr == null && objArr2 != null && objArr2.length > 0) {
            return false;
        }
        if (objArr2 != null || objArr == null || objArr.length <= 0) {
            return objArr == null || objArr2 == null || objArr.length == objArr2.length;
        }
        return false;
    }

    public static Class<?> n(Class<?> cls) {
        return (cls == null || !cls.isPrimitive()) ? cls : f2016e.get(cls);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean o(AccessibleObject accessibleObject) {
        if (accessibleObject != 0 && !accessibleObject.isAccessible()) {
            accessibleObject.setAccessible(true);
            Member member = (Member) accessibleObject;
            if (!accessibleObject.isAccessible() && Modifier.isPublic(member.getModifiers()) && l(member.getDeclaringClass().getModifiers())) {
                try {
                    accessibleObject.setAccessible(true);
                    return true;
                } catch (SecurityException unused) {
                }
            }
        }
        return false;
    }

    public static Class<?> p(Class<?> cls) {
        return f2017f.get(cls);
    }
}

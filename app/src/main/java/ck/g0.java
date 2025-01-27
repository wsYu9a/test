package ck;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* loaded from: classes5.dex */
public final class g0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Unsafe f2178a;

    static {
        Unsafe unsafe = null;
        try {
            Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            unsafe = (Unsafe) declaredField.get(null);
        } catch (Throwable unused) {
        }
        f2178a = unsafe;
    }

    public g0() {
        throw new IllegalStateException("No instances!");
    }

    public static long a(Class<?> cls, String str) {
        try {
            return f2178a.objectFieldOffset(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e10) {
            InternalError internalError = new InternalError();
            internalError.initCause(e10);
            throw internalError;
        }
    }

    public static boolean b(Object obj, long j10, int i10, int i11) {
        return f2178a.compareAndSwapInt(obj, j10, i10, i11);
    }

    public static int c(Object obj, long j10, int i10) {
        Unsafe unsafe;
        int intVolatile;
        do {
            unsafe = f2178a;
            intVolatile = unsafe.getIntVolatile(obj, j10);
        } while (!unsafe.compareAndSwapInt(obj, j10, intVolatile, intVolatile + i10));
        return intVolatile;
    }

    public static int d(Object obj, long j10) {
        Unsafe unsafe;
        int intVolatile;
        do {
            unsafe = f2178a;
            intVolatile = unsafe.getIntVolatile(obj, j10);
        } while (!unsafe.compareAndSwapInt(obj, j10, intVolatile, intVolatile + 1));
        return intVolatile;
    }

    public static int e(Object obj, long j10, int i10) {
        Unsafe unsafe;
        int intVolatile;
        do {
            unsafe = f2178a;
            intVolatile = unsafe.getIntVolatile(obj, j10);
        } while (!unsafe.compareAndSwapInt(obj, j10, intVolatile, i10));
        return intVolatile;
    }

    public static final boolean f() {
        return f2178a != null;
    }
}

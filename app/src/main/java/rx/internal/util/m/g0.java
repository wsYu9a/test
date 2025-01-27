package rx.internal.util.m;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* loaded from: classes5.dex */
public final class g0 {

    /* renamed from: a */
    public static final Unsafe f36837a;

    static {
        Unsafe unsafe = null;
        try {
            Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            unsafe = (Unsafe) declaredField.get(null);
        } catch (Throwable unused) {
        }
        f36837a = unsafe;
    }

    private g0() {
        throw new IllegalStateException("No instances!");
    }

    public static long a(Class<?> cls, String str) {
        try {
            return f36837a.objectFieldOffset(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e2) {
            InternalError internalError = new InternalError();
            internalError.initCause(e2);
            throw internalError;
        }
    }

    public static boolean b(Object obj, long j2, int i2, int i3) {
        return f36837a.compareAndSwapInt(obj, j2, i2, i3);
    }

    public static int c(Object obj, long j2, int i2) {
        Unsafe unsafe;
        int intVolatile;
        do {
            unsafe = f36837a;
            intVolatile = unsafe.getIntVolatile(obj, j2);
        } while (!unsafe.compareAndSwapInt(obj, j2, intVolatile, intVolatile + i2));
        return intVolatile;
    }

    public static int d(Object obj, long j2) {
        Unsafe unsafe;
        int intVolatile;
        do {
            unsafe = f36837a;
            intVolatile = unsafe.getIntVolatile(obj, j2);
        } while (!unsafe.compareAndSwapInt(obj, j2, intVolatile, intVolatile + 1));
        return intVolatile;
    }

    public static int e(Object obj, long j2, int i2) {
        Unsafe unsafe;
        int intVolatile;
        do {
            unsafe = f36837a;
            intVolatile = unsafe.getIntVolatile(obj, j2);
        } while (!unsafe.compareAndSwapInt(obj, j2, intVolatile, i2));
        return intVolatile;
    }

    public static final boolean f() {
        return f36837a != null;
    }
}

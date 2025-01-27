package com.google.common.hash;

import a5.c;
import i5.h;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Random;
import javax.annotation.CheckForNull;
import sun.misc.Unsafe;

@h
@c
/* loaded from: classes2.dex */
abstract class Striped64 extends Number {
    private static final Unsafe UNSAFE;
    private static final long baseOffset;
    private static final long busyOffset;
    volatile transient long base;
    volatile transient int busy;

    @CheckForNull
    volatile transient b[] cells;
    static final ThreadLocal<int[]> threadHashCode = new ThreadLocal<>();
    static final Random rng = new Random();
    static final int NCPU = Runtime.getRuntime().availableProcessors();

    public class a implements PrivilegedExceptionAction<Unsafe> {
        @Override // java.security.PrivilegedExceptionAction
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unsafe run() throws Exception {
            for (Field field : Unsafe.class.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            throw new NoSuchFieldError("the Unsafe");
        }
    }

    public static final class b {

        /* renamed from: p, reason: collision with root package name */
        public static final Unsafe f10087p;

        /* renamed from: q, reason: collision with root package name */
        public static final long f10088q;

        /* renamed from: a, reason: collision with root package name */
        public volatile long f10089a;

        /* renamed from: b, reason: collision with root package name */
        public volatile long f10090b;

        /* renamed from: c, reason: collision with root package name */
        public volatile long f10091c;

        /* renamed from: d, reason: collision with root package name */
        public volatile long f10092d;

        /* renamed from: e, reason: collision with root package name */
        public volatile long f10093e;

        /* renamed from: f, reason: collision with root package name */
        public volatile long f10094f;

        /* renamed from: g, reason: collision with root package name */
        public volatile long f10095g;

        /* renamed from: h, reason: collision with root package name */
        public volatile long f10096h;

        /* renamed from: i, reason: collision with root package name */
        public volatile long f10097i;

        /* renamed from: j, reason: collision with root package name */
        public volatile long f10098j;

        /* renamed from: k, reason: collision with root package name */
        public volatile long f10099k;

        /* renamed from: l, reason: collision with root package name */
        public volatile long f10100l;

        /* renamed from: m, reason: collision with root package name */
        public volatile long f10101m;

        /* renamed from: n, reason: collision with root package name */
        public volatile long f10102n;

        /* renamed from: o, reason: collision with root package name */
        public volatile long f10103o;

        static {
            try {
                Unsafe unsafe = Striped64.getUnsafe();
                f10087p = unsafe;
                f10088q = unsafe.objectFieldOffset(b.class.getDeclaredField("h"));
            } catch (Exception e10) {
                throw new Error(e10);
            }
        }

        public b(long j10) {
            this.f10096h = j10;
        }

        public final boolean a(long j10, long j11) {
            return f10087p.compareAndSwapLong(this, f10088q, j10, j11);
        }
    }

    static {
        try {
            Unsafe unsafe = getUnsafe();
            UNSAFE = unsafe;
            baseOffset = unsafe.objectFieldOffset(Striped64.class.getDeclaredField("base"));
            busyOffset = unsafe.objectFieldOffset(Striped64.class.getDeclaredField("busy"));
        } catch (Exception e10) {
            throw new Error(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Unsafe getUnsafe() {
        try {
            try {
                return Unsafe.getUnsafe();
            } catch (SecurityException unused) {
                return (Unsafe) AccessController.doPrivileged(new a());
            }
        } catch (PrivilegedActionException e10) {
            throw new RuntimeException("Could not initialize intrinsics", e10.getCause());
        }
    }

    public final boolean casBase(long j10, long j11) {
        return UNSAFE.compareAndSwapLong(this, baseOffset, j10, j11);
    }

    public final boolean casBusy() {
        return UNSAFE.compareAndSwapInt(this, busyOffset, 0, 1);
    }

    public abstract long fn(long j10, long j11);

    public final void internalReset(long j10) {
        b[] bVarArr = this.cells;
        this.base = j10;
        if (bVarArr != null) {
            for (b bVar : bVarArr) {
                if (bVar != null) {
                    bVar.f10096h = j10;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x00f1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0023 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void retryUpdate(long r17, @javax.annotation.CheckForNull int[] r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.hash.Striped64.retryUpdate(long, int[], boolean):void");
    }
}

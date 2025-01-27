package com.google.common.primitives;

import a5.a;
import a5.c;
import a5.d;
import b5.u;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.reflect.Field;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import n5.b;
import sun.misc.Unsafe;

@b
@c
/* loaded from: classes2.dex */
public final class UnsignedBytes {

    /* renamed from: a */
    public static final byte f10195a = Byte.MIN_VALUE;

    /* renamed from: b */
    public static final byte f10196b = -1;

    /* renamed from: c */
    public static final int f10197c = 255;

    @d
    public static class LexicographicalComparatorHolder {

        /* renamed from: a */
        public static final String f10198a = LexicographicalComparatorHolder.class.getName().concat("$UnsafeComparator");

        /* renamed from: b */
        public static final Comparator<byte[]> f10199b = a();

        public enum PureJavaComparator implements Comparator<byte[]> {
            INSTANCE;

            @Override // java.lang.Enum
            public String toString() {
                return "UnsignedBytes.lexicographicalComparator() (pure Java version)";
            }

            @Override // java.util.Comparator
            public int compare(byte[] bArr, byte[] bArr2) {
                int min = Math.min(bArr.length, bArr2.length);
                for (int i10 = 0; i10 < min; i10++) {
                    int b10 = UnsignedBytes.b(bArr[i10], bArr2[i10]);
                    if (b10 != 0) {
                        return b10;
                    }
                }
                return bArr.length - bArr2.length;
            }
        }

        @d
        public enum UnsafeComparator implements Comparator<byte[]> {
            INSTANCE;

            static final boolean BIG_ENDIAN = ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN);
            static final int BYTE_ARRAY_BASE_OFFSET;
            static final Unsafe theUnsafe;

            public class a implements PrivilegedExceptionAction<Unsafe> {
                @Override // java.security.PrivilegedExceptionAction
                /* renamed from: a */
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

            static {
                Unsafe unsafe = getUnsafe();
                theUnsafe = unsafe;
                int arrayBaseOffset = unsafe.arrayBaseOffset(byte[].class);
                BYTE_ARRAY_BASE_OFFSET = arrayBaseOffset;
                if (!"64".equals(System.getProperty("sun.arch.data.model")) || arrayBaseOffset % 8 != 0 || unsafe.arrayIndexScale(byte[].class) != 1) {
                    throw new Error();
                }
            }

            private static Unsafe getUnsafe() {
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

            @Override // java.lang.Enum
            public String toString() {
                return "UnsignedBytes.lexicographicalComparator() (sun.misc.Unsafe version)";
            }

            @Override // java.util.Comparator
            public int compare(byte[] bArr, byte[] bArr2) {
                int min = Math.min(bArr.length, bArr2.length);
                int i10 = min & (-8);
                int i11 = 0;
                while (i11 < i10) {
                    Unsafe unsafe = theUnsafe;
                    int i12 = BYTE_ARRAY_BASE_OFFSET;
                    long j10 = i11;
                    long j11 = unsafe.getLong(bArr, i12 + j10);
                    long j12 = unsafe.getLong(bArr2, i12 + j10);
                    if (j11 != j12) {
                        if (BIG_ENDIAN) {
                            return UnsignedLongs.a(j11, j12);
                        }
                        int numberOfTrailingZeros = Long.numberOfTrailingZeros(j11 ^ j12) & (-8);
                        return ((int) ((j11 >>> numberOfTrailingZeros) & 255)) - ((int) ((j12 >>> numberOfTrailingZeros) & 255));
                    }
                    i11 += 8;
                }
                while (i11 < min) {
                    int b10 = UnsignedBytes.b(bArr[i11], bArr2[i11]);
                    if (b10 != 0) {
                        return b10;
                    }
                    i11++;
                }
                return bArr.length - bArr2.length;
            }
        }

        public static Comparator<byte[]> a() {
            try {
                Object[] enumConstants = Class.forName(f10198a).getEnumConstants();
                Objects.requireNonNull(enumConstants);
                return (Comparator) enumConstants[0];
            } catch (Throwable unused) {
                return UnsignedBytes.f();
            }
        }
    }

    @CanIgnoreReturnValue
    public static byte a(long j10) {
        u.p((j10 >> 8) == 0, "out of range: %s", j10);
        return (byte) j10;
    }

    public static int b(byte b10, byte b11) {
        return p(b10) - p(b11);
    }

    public static byte c(byte b10) {
        return (byte) (b10 ^ 128);
    }

    public static String d(String str, byte... bArr) {
        u.E(str);
        if (bArr.length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(bArr.length * (str.length() + 3));
        sb2.append(p(bArr[0]));
        for (int i10 = 1; i10 < bArr.length; i10++) {
            sb2.append(str);
            sb2.append(q(bArr[i10]));
        }
        return sb2.toString();
    }

    public static Comparator<byte[]> e() {
        return LexicographicalComparatorHolder.f10199b;
    }

    @d
    public static Comparator<byte[]> f() {
        return LexicographicalComparatorHolder.PureJavaComparator.INSTANCE;
    }

    public static byte g(byte... bArr) {
        u.d(bArr.length > 0);
        int p10 = p(bArr[0]);
        for (int i10 = 1; i10 < bArr.length; i10++) {
            int p11 = p(bArr[i10]);
            if (p11 > p10) {
                p10 = p11;
            }
        }
        return (byte) p10;
    }

    public static byte h(byte... bArr) {
        u.d(bArr.length > 0);
        int p10 = p(bArr[0]);
        for (int i10 = 1; i10 < bArr.length; i10++) {
            int p11 = p(bArr[i10]);
            if (p11 < p10) {
                p10 = p11;
            }
        }
        return (byte) p10;
    }

    @CanIgnoreReturnValue
    @a
    public static byte i(String str) {
        return j(str, 10);
    }

    @CanIgnoreReturnValue
    @a
    public static byte j(String str, int i10) {
        int parseInt = Integer.parseInt((String) u.E(str), i10);
        if ((parseInt >> 8) == 0) {
            return (byte) parseInt;
        }
        StringBuilder sb2 = new StringBuilder(25);
        sb2.append("out of range: ");
        sb2.append(parseInt);
        throw new NumberFormatException(sb2.toString());
    }

    public static byte k(long j10) {
        if (j10 > p((byte) -1)) {
            return (byte) -1;
        }
        if (j10 < 0) {
            return (byte) 0;
        }
        return (byte) j10;
    }

    public static void l(byte[] bArr) {
        u.E(bArr);
        m(bArr, 0, bArr.length);
    }

    public static void m(byte[] bArr, int i10, int i11) {
        u.E(bArr);
        u.f0(i10, i11, bArr.length);
        for (int i12 = i10; i12 < i11; i12++) {
            bArr[i12] = c(bArr[i12]);
        }
        Arrays.sort(bArr, i10, i11);
        while (i10 < i11) {
            bArr[i10] = c(bArr[i10]);
            i10++;
        }
    }

    public static void n(byte[] bArr) {
        u.E(bArr);
        o(bArr, 0, bArr.length);
    }

    public static void o(byte[] bArr, int i10, int i11) {
        u.E(bArr);
        u.f0(i10, i11, bArr.length);
        for (int i12 = i10; i12 < i11; i12++) {
            bArr[i12] = (byte) (bArr[i12] ^ Byte.MAX_VALUE);
        }
        Arrays.sort(bArr, i10, i11);
        while (i10 < i11) {
            bArr[i10] = (byte) (bArr[i10] ^ Byte.MAX_VALUE);
            i10++;
        }
    }

    public static int p(byte b10) {
        return b10 & 255;
    }

    @a
    public static String q(byte b10) {
        return r(b10, 10);
    }

    @a
    public static String r(byte b10, int i10) {
        u.k(i10 >= 2 && i10 <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", i10);
        return Integer.toString(p(b10), i10);
    }
}

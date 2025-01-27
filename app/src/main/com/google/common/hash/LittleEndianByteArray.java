package com.google.common.hash;

import com.google.common.primitives.Longs;
import i5.h;
import java.lang.reflect.Field;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

@h
/* loaded from: classes2.dex */
public final class LittleEndianByteArray {

    /* renamed from: a */
    public static final b f10057a;

    /* renamed from: b */
    public static final /* synthetic */ boolean f10058b = false;

    public enum JavaLittleEndianBytes implements b {
        INSTANCE { // from class: com.google.common.hash.LittleEndianByteArray.JavaLittleEndianBytes.1
            @Override // com.google.common.hash.LittleEndianByteArray.b
            public long getLongLittleEndian(byte[] bArr, int i10) {
                return Longs.j(bArr[i10 + 7], bArr[i10 + 6], bArr[i10 + 5], bArr[i10 + 4], bArr[i10 + 3], bArr[i10 + 2], bArr[i10 + 1], bArr[i10]);
            }

            @Override // com.google.common.hash.LittleEndianByteArray.b
            public void putLongLittleEndian(byte[] bArr, int i10, long j10) {
                long j11 = 255;
                for (int i11 = 0; i11 < 8; i11++) {
                    bArr[i10 + i11] = (byte) ((j10 & j11) >> (i11 * 8));
                    j11 <<= 8;
                }
            }
        };

        /* renamed from: com.google.common.hash.LittleEndianByteArray$JavaLittleEndianBytes$1 */
        public enum AnonymousClass1 extends JavaLittleEndianBytes {
            @Override // com.google.common.hash.LittleEndianByteArray.b
            public long getLongLittleEndian(byte[] bArr, int i10) {
                return Longs.j(bArr[i10 + 7], bArr[i10 + 6], bArr[i10 + 5], bArr[i10 + 4], bArr[i10 + 3], bArr[i10 + 2], bArr[i10 + 1], bArr[i10]);
            }

            @Override // com.google.common.hash.LittleEndianByteArray.b
            public void putLongLittleEndian(byte[] bArr, int i10, long j10) {
                long j11 = 255;
                for (int i11 = 0; i11 < 8; i11++) {
                    bArr[i10 + i11] = (byte) ((j10 & j11) >> (i11 * 8));
                    j11 <<= 8;
                }
            }
        }

        /* synthetic */ JavaLittleEndianBytes(a aVar) {
            this();
        }
    }

    public enum UnsafeByteArray implements b {
        UNSAFE_LITTLE_ENDIAN { // from class: com.google.common.hash.LittleEndianByteArray.UnsafeByteArray.1
            @Override // com.google.common.hash.LittleEndianByteArray.b
            public long getLongLittleEndian(byte[] bArr, int i10) {
                return UnsafeByteArray.theUnsafe.getLong(bArr, i10 + UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET);
            }

            @Override // com.google.common.hash.LittleEndianByteArray.b
            public void putLongLittleEndian(byte[] bArr, int i10, long j10) {
                UnsafeByteArray.theUnsafe.putLong(bArr, i10 + UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET, j10);
            }
        },
        UNSAFE_BIG_ENDIAN { // from class: com.google.common.hash.LittleEndianByteArray.UnsafeByteArray.2
            @Override // com.google.common.hash.LittleEndianByteArray.b
            public long getLongLittleEndian(byte[] bArr, int i10) {
                return Long.reverseBytes(UnsafeByteArray.theUnsafe.getLong(bArr, i10 + UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET));
            }

            @Override // com.google.common.hash.LittleEndianByteArray.b
            public void putLongLittleEndian(byte[] bArr, int i10, long j10) {
                UnsafeByteArray.theUnsafe.putLong(bArr, i10 + UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET, Long.reverseBytes(j10));
            }
        };

        private static final int BYTE_ARRAY_BASE_OFFSET;
        private static final Unsafe theUnsafe;

        /* renamed from: com.google.common.hash.LittleEndianByteArray$UnsafeByteArray$1 */
        public enum AnonymousClass1 extends UnsafeByteArray {
            @Override // com.google.common.hash.LittleEndianByteArray.b
            public long getLongLittleEndian(byte[] bArr, int i10) {
                return UnsafeByteArray.theUnsafe.getLong(bArr, i10 + UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET);
            }

            @Override // com.google.common.hash.LittleEndianByteArray.b
            public void putLongLittleEndian(byte[] bArr, int i10, long j10) {
                UnsafeByteArray.theUnsafe.putLong(bArr, i10 + UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET, j10);
            }
        }

        /* renamed from: com.google.common.hash.LittleEndianByteArray$UnsafeByteArray$2 */
        public enum AnonymousClass2 extends UnsafeByteArray {
            @Override // com.google.common.hash.LittleEndianByteArray.b
            public long getLongLittleEndian(byte[] bArr, int i10) {
                return Long.reverseBytes(UnsafeByteArray.theUnsafe.getLong(bArr, i10 + UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET));
            }

            @Override // com.google.common.hash.LittleEndianByteArray.b
            public void putLongLittleEndian(byte[] bArr, int i10, long j10) {
                UnsafeByteArray.theUnsafe.putLong(bArr, i10 + UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET, Long.reverseBytes(j10));
            }
        }

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
            BYTE_ARRAY_BASE_OFFSET = unsafe.arrayBaseOffset(byte[].class);
            if (unsafe.arrayIndexScale(byte[].class) != 1) {
                throw new AssertionError();
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

        /* synthetic */ UnsafeByteArray(a aVar) {
            this();
        }
    }

    public interface b {
        long getLongLittleEndian(byte[] bArr, int i10);

        void putLongLittleEndian(byte[] bArr, int i10, long j10);
    }

    static {
        b bVar = JavaLittleEndianBytes.INSTANCE;
        try {
            if ("amd64".equals(System.getProperty("os.arch"))) {
                bVar = ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN) ? UnsafeByteArray.UNSAFE_LITTLE_ENDIAN : UnsafeByteArray.UNSAFE_BIG_ENDIAN;
            }
        } catch (Throwable unused) {
        }
        f10057a = bVar;
    }

    public static int a(byte[] bArr, int i10) {
        return ((bArr[i10 + 3] & 255) << 24) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16);
    }

    public static long b(byte[] bArr, int i10) {
        return f10057a.getLongLittleEndian(bArr, i10);
    }

    public static long c(byte[] bArr, int i10, int i11) {
        long j10 = 0;
        for (int i12 = 0; i12 < Math.min(i11, 8); i12++) {
            j10 |= (bArr[i10 + i12] & 255) << (i12 * 8);
        }
        return j10;
    }

    public static void d(byte[] bArr, int i10, long j10) {
        f10057a.putLongLittleEndian(bArr, i10, j10);
    }

    public static boolean e() {
        return f10057a instanceof UnsafeByteArray;
    }
}

package com.bytedance.pangle.util.a;

import android.util.Pair;
import com.bytedance.pangle.util.f;
import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a */
    private static String f7830a = "";

    public static String[] a(File file) {
        String str;
        ByteBuffer b10;
        String str2 = "";
        try {
            b10 = b(file);
        } catch (Exception unused) {
            str = "";
        }
        if (b10.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
        ByteBuffer a10 = a(b10, b10.capacity() - 24);
        int i10 = 0;
        while (a10.hasRemaining()) {
            i10++;
            if (a10.remaining() < 8) {
                throw new Exception("Insufficient data to read size of APK Signing Block entry #".concat(String.valueOf(i10)));
            }
            long j10 = a10.getLong();
            if (j10 < 4 || j10 > 2147483647L) {
                throw new Exception("APK Signing Block entry #" + i10 + " size out of range: " + j10);
            }
            int i11 = (int) j10;
            int position = a10.position() + i11;
            if (i11 > a10.remaining()) {
                throw new Exception("APK Signing Block entry #" + i10 + " size out of range: " + i11 + ", available: " + a10.remaining());
            }
            int i12 = a10.getInt();
            if (i12 == -262969152) {
                f7830a = "V3";
            } else if (i12 == 1896449818) {
                f7830a = "V2";
            } else {
                a10.position(position);
            }
            str2 = f.a(b10.array());
            str = "";
            break;
        }
        str = "without v2 & v3 signature.";
        return new String[]{str2, f7830a, str};
    }

    private static ByteBuffer b(File file) {
        RandomAccessFile randomAccessFile = null;
        Pair<ByteBuffer, Long> a10 = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, t.f11211k);
            try {
                if (randomAccessFile2.length() >= 22 && (a10 = c.a(randomAccessFile2, 0)) == null) {
                    a10 = c.a(randomAccessFile2, 65535);
                }
                if (a10 == null) {
                    throw new Exception("Not an APK file: ZIP End of Central Directory record not found");
                }
                ByteBuffer byteBuffer = (ByteBuffer) a10.first;
                long longValue = ((Long) a10.second).longValue();
                long j10 = longValue - 20;
                if (j10 >= 0) {
                    randomAccessFile2.seek(j10);
                    if (randomAccessFile2.readInt() == 1347094023) {
                        throw new Exception("ZIP64 APK not supported");
                    }
                }
                c.a(byteBuffer);
                long a11 = c.a(byteBuffer, byteBuffer.position() + 16);
                if (a11 > longValue) {
                    throw new Exception("ZIP Central Directory offset out of range: " + a11 + ". ZIP End of Central Directory offset: " + longValue);
                }
                c.a(byteBuffer);
                if (c.a(byteBuffer, byteBuffer.position() + 12) + a11 != longValue) {
                    throw new Exception("ZIP Central Directory is not immediately followed by End of Central Directory");
                }
                if (a11 < 32) {
                    throw new Exception("APK too small for APK Signing Block. ZIP Central Directory offset: ".concat(String.valueOf(a11)));
                }
                ByteBuffer allocate = ByteBuffer.allocate(24);
                ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                allocate.order(byteOrder);
                randomAccessFile2.seek(a11 - allocate.capacity());
                randomAccessFile2.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
                if (allocate.getLong(8) != com.bytedance.hume.readapk.a.f7429b || allocate.getLong(16) != com.bytedance.hume.readapk.a.f7428a) {
                    throw new Exception("No APK Signing Block before ZIP Central Directory");
                }
                long j11 = allocate.getLong(0);
                if (j11 < allocate.capacity() || j11 > 2147483639) {
                    throw new Exception("APK Signing Block size out of range: ".concat(String.valueOf(j11)));
                }
                int i10 = (int) (8 + j11);
                long j12 = a11 - i10;
                if (j12 < 0) {
                    throw new Exception("APK Signing Block offset out of range: ".concat(String.valueOf(j12)));
                }
                ByteBuffer allocate2 = ByteBuffer.allocate(i10);
                allocate2.order(byteOrder);
                randomAccessFile2.seek(j12);
                randomAccessFile2.readFully(allocate2.array(), allocate2.arrayOffset(), allocate2.capacity());
                long j13 = allocate2.getLong(0);
                if (j13 == j11) {
                    ByteBuffer byteBuffer2 = (ByteBuffer) Pair.create(allocate2, Long.valueOf(j12)).first;
                    randomAccessFile2.close();
                    return byteBuffer2;
                }
                throw new Exception("APK Signing Block sizes in header and footer do not match: " + j13 + " vs " + j11);
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private static ByteBuffer a(ByteBuffer byteBuffer, int i10) {
        if (i10 >= 8) {
            int capacity = byteBuffer.capacity();
            if (i10 <= byteBuffer.capacity()) {
                int limit = byteBuffer.limit();
                int position = byteBuffer.position();
                try {
                    byteBuffer.position(0);
                    byteBuffer.limit(i10);
                    byteBuffer.position(8);
                    ByteBuffer slice = byteBuffer.slice();
                    slice.order(byteBuffer.order());
                    return slice;
                } finally {
                    byteBuffer.position(0);
                    byteBuffer.limit(limit);
                    byteBuffer.position(position);
                }
            }
            throw new IllegalArgumentException("end > capacity: " + i10 + " > " + capacity);
        }
        throw new IllegalArgumentException("end < start: " + i10 + " < 8");
    }
}

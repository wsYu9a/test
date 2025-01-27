package com.bytedance.hume.readapk;

import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    public static final long f5952a = 3617552046287187010L;

    /* renamed from: b */
    public static final long f5953b = 2334950737559900225L;

    /* renamed from: c */
    public static final int f5954c = 1896449818;

    /* renamed from: d */
    public static final int f5955d = 1114793335;

    /* renamed from: e */
    public static final int f5956e = 4096;

    /* renamed from: f */
    public static final String f5957f = "UTF-8";

    /* renamed from: g */
    private static final int f5958g = 32;

    /* renamed from: h */
    private static final int f5959h = 22;

    /* renamed from: i */
    private static final int f5960i = 101010256;

    /* renamed from: j */
    private static final int f5961j = 65535;
    private static final int k = 20;

    private a() {
    }

    public static long a(FileChannel fileChannel) {
        long size = fileChannel.size();
        if (size < 22) {
            throw new IOException("APK too small for ZIP End of Central Directory (EOCD) record");
        }
        long j2 = size - 22;
        long min = Math.min(j2, 65535L);
        int i2 = 0;
        while (true) {
            long j3 = i2;
            if (j3 > min) {
                throw new IOException("ZIP End of Central Directory (EOCD) record not found");
            }
            long j4 = j2 - j3;
            ByteBuffer allocate = ByteBuffer.allocate(4);
            fileChannel.position(j4);
            fileChannel.read(allocate);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            allocate.order(byteOrder);
            if (allocate.getInt(0) == f5960i) {
                ByteBuffer allocate2 = ByteBuffer.allocate(2);
                fileChannel.position(j4 + 20);
                fileChannel.read(allocate2);
                allocate2.order(byteOrder);
                short s = allocate2.getShort(0);
                if (s == i2) {
                    return s;
                }
            }
            i2++;
        }
    }

    public static long a(FileChannel fileChannel, long j2) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        fileChannel.position((fileChannel.size() - j2) - 6);
        fileChannel.read(allocate);
        return allocate.getInt(0);
    }

    private static ByteBuffer a(ByteBuffer byteBuffer, int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("size: " + i2);
        }
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        int i3 = i2 + position;
        if (i3 < position || i3 > limit) {
            throw new BufferUnderflowException();
        }
        byteBuffer.limit(i3);
        try {
            ByteBuffer slice = byteBuffer.slice();
            slice.order(byteBuffer.order());
            byteBuffer.position(i3);
            return slice;
        } finally {
            byteBuffer.limit(limit);
        }
    }

    private static ByteBuffer a(ByteBuffer byteBuffer, int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException("start: " + i2);
        }
        if (i3 < i2) {
            throw new IllegalArgumentException("end < start: " + i3 + " < " + i2);
        }
        int capacity = byteBuffer.capacity();
        if (i3 > byteBuffer.capacity()) {
            throw new IllegalArgumentException("end > capacity: " + i3 + " > " + capacity);
        }
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        try {
            byteBuffer.position(0);
            byteBuffer.limit(i3);
            byteBuffer.position(i2);
            ByteBuffer slice = byteBuffer.slice();
            slice.order(byteBuffer.order());
            return slice;
        } finally {
            byteBuffer.position(0);
            byteBuffer.limit(limit);
            byteBuffer.position(position);
        }
    }

    public static Map<Integer, ByteBuffer> a(ByteBuffer byteBuffer) {
        b(byteBuffer);
        ByteBuffer a2 = a(byteBuffer, 8, byteBuffer.capacity() - 24);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i2 = 0;
        while (a2.hasRemaining()) {
            i2++;
            if (a2.remaining() < 8) {
                throw new e("Insufficient data to read size of APK Signing Block entry #" + i2);
            }
            long j2 = a2.getLong();
            if (j2 < 4 || j2 > 2147483647L) {
                throw new e("APK Signing Block entry #" + i2 + " size out of range: " + j2);
            }
            int i3 = (int) j2;
            int position = a2.position() + i3;
            if (i3 > a2.remaining()) {
                throw new e("APK Signing Block entry #" + i2 + " size out of range: " + i3 + ", available: " + a2.remaining());
            }
            linkedHashMap.put(Integer.valueOf(a2.getInt()), a(a2, i3 - 4));
            a2.position(position);
        }
        return linkedHashMap;
    }

    public static long b(FileChannel fileChannel) {
        return a(fileChannel, a(fileChannel));
    }

    public static c<ByteBuffer, Long> b(FileChannel fileChannel, long j2) {
        if (j2 < 32) {
            throw new e("APK too small for APK Signing Block. ZIP Central Directory offset: " + j2);
        }
        fileChannel.position(j2 - 24);
        ByteBuffer allocate = ByteBuffer.allocate(24);
        fileChannel.read(allocate);
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        allocate.order(byteOrder);
        if (allocate.getLong(8) != f5953b || allocate.getLong(16) != f5952a) {
            throw new e("No APK Signing Block before ZIP Central Directory");
        }
        long j3 = allocate.getLong(0);
        if (j3 < allocate.capacity() || j3 > 2147483639) {
            throw new e("APK Signing Block size out of range: " + j3);
        }
        int i2 = (int) (8 + j3);
        long j4 = j2 - i2;
        if (j4 < 0) {
            throw new e("APK Signing Block offset out of range: " + j4);
        }
        fileChannel.position(j4);
        ByteBuffer allocate2 = ByteBuffer.allocate(i2);
        fileChannel.read(allocate2);
        allocate2.order(byteOrder);
        long j5 = allocate2.getLong(0);
        if (j5 == j3) {
            return c.a(allocate2, Long.valueOf(j4));
        }
        throw new e("APK Signing Block sizes in header and footer do not match: " + j5 + " vs " + j3);
    }

    private static void b(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    public static c<ByteBuffer, Long> c(FileChannel fileChannel) {
        return b(fileChannel, b(fileChannel));
    }
}

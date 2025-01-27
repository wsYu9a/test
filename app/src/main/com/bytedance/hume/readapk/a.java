package com.bytedance.hume.readapk;

import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.LinkedHashMap;
import java.util.Map;
import okhttp3.internal.ws.WebSocketProtocol;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a */
    public static final long f7428a = 3617552046287187010L;

    /* renamed from: b */
    public static final long f7429b = 2334950737559900225L;

    /* renamed from: c */
    public static final int f7430c = 1896449818;

    /* renamed from: d */
    public static final int f7431d = 1114793335;

    /* renamed from: e */
    public static final int f7432e = 4096;

    /* renamed from: f */
    public static final String f7433f = "UTF-8";

    /* renamed from: g */
    private static final int f7434g = 32;

    /* renamed from: h */
    private static final int f7435h = 22;

    /* renamed from: i */
    private static final int f7436i = 101010256;

    /* renamed from: j */
    private static final int f7437j = 65535;

    /* renamed from: k */
    private static final int f7438k = 20;

    private a() {
    }

    public static long a(FileChannel fileChannel) {
        long size = fileChannel.size();
        if (size < 22) {
            throw new IOException("APK too small for ZIP End of Central Directory (EOCD) record");
        }
        long j10 = size - 22;
        long min = Math.min(j10, WebSocketProtocol.PAYLOAD_SHORT_MAX);
        int i10 = 0;
        while (true) {
            long j11 = i10;
            if (j11 > min) {
                throw new IOException("ZIP End of Central Directory (EOCD) record not found");
            }
            long j12 = j10 - j11;
            ByteBuffer allocate = ByteBuffer.allocate(4);
            fileChannel.position(j12);
            fileChannel.read(allocate);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            allocate.order(byteOrder);
            if (allocate.getInt(0) == f7436i) {
                ByteBuffer allocate2 = ByteBuffer.allocate(2);
                fileChannel.position(j12 + 20);
                fileChannel.read(allocate2);
                allocate2.order(byteOrder);
                short s10 = allocate2.getShort(0);
                if (s10 == i10) {
                    return s10;
                }
            }
            i10++;
        }
    }

    public static long b(FileChannel fileChannel) {
        return a(fileChannel, a(fileChannel));
    }

    public static c<ByteBuffer, Long> c(FileChannel fileChannel) {
        return b(fileChannel, b(fileChannel));
    }

    public static long a(FileChannel fileChannel, long j10) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        fileChannel.position((fileChannel.size() - j10) - 6);
        fileChannel.read(allocate);
        return allocate.getInt(0);
    }

    public static c<ByteBuffer, Long> b(FileChannel fileChannel, long j10) {
        if (j10 < 32) {
            throw new e("APK too small for APK Signing Block. ZIP Central Directory offset: " + j10);
        }
        fileChannel.position(j10 - 24);
        ByteBuffer allocate = ByteBuffer.allocate(24);
        fileChannel.read(allocate);
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        allocate.order(byteOrder);
        if (allocate.getLong(8) != f7429b || allocate.getLong(16) != f7428a) {
            throw new e("No APK Signing Block before ZIP Central Directory");
        }
        long j11 = allocate.getLong(0);
        if (j11 < allocate.capacity() || j11 > 2147483639) {
            throw new e("APK Signing Block size out of range: " + j11);
        }
        int i10 = (int) (8 + j11);
        long j12 = j10 - i10;
        if (j12 < 0) {
            throw new e("APK Signing Block offset out of range: " + j12);
        }
        fileChannel.position(j12);
        ByteBuffer allocate2 = ByteBuffer.allocate(i10);
        fileChannel.read(allocate2);
        allocate2.order(byteOrder);
        long j13 = allocate2.getLong(0);
        if (j13 == j11) {
            return c.a(allocate2, Long.valueOf(j12));
        }
        throw new e("APK Signing Block sizes in header and footer do not match: " + j13 + " vs " + j11);
    }

    private static ByteBuffer a(ByteBuffer byteBuffer, int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("size: " + i10);
        }
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        int i11 = i10 + position;
        if (i11 < position || i11 > limit) {
            throw new BufferUnderflowException();
        }
        byteBuffer.limit(i11);
        try {
            ByteBuffer slice = byteBuffer.slice();
            slice.order(byteBuffer.order());
            byteBuffer.position(i11);
            return slice;
        } finally {
            byteBuffer.limit(limit);
        }
    }

    private static void b(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    private static ByteBuffer a(ByteBuffer byteBuffer, int i10, int i11) {
        if (i10 < 0) {
            throw new IllegalArgumentException("start: " + i10);
        }
        if (i11 < i10) {
            throw new IllegalArgumentException("end < start: " + i11 + " < " + i10);
        }
        int capacity = byteBuffer.capacity();
        if (i11 > byteBuffer.capacity()) {
            throw new IllegalArgumentException("end > capacity: " + i11 + " > " + capacity);
        }
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        try {
            byteBuffer.position(0);
            byteBuffer.limit(i11);
            byteBuffer.position(i10);
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
        ByteBuffer a10 = a(byteBuffer, 8, byteBuffer.capacity() - 24);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i10 = 0;
        while (a10.hasRemaining()) {
            i10++;
            if (a10.remaining() < 8) {
                throw new e("Insufficient data to read size of APK Signing Block entry #" + i10);
            }
            long j10 = a10.getLong();
            if (j10 < 4 || j10 > 2147483647L) {
                throw new e("APK Signing Block entry #" + i10 + " size out of range: " + j10);
            }
            int i11 = (int) j10;
            int position = a10.position() + i11;
            if (i11 > a10.remaining()) {
                throw new e("APK Signing Block entry #" + i10 + " size out of range: " + i11 + ", available: " + a10.remaining());
            }
            linkedHashMap.put(Integer.valueOf(a10.getInt()), a(a10, i11 - 4));
            a10.position(position);
        }
        return linkedHashMap;
    }
}

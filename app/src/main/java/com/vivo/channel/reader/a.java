package com.vivo.channel.reader;

import android.util.Pair;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.UShort;

/* loaded from: classes4.dex */
public abstract class a {

    /* renamed from: com.vivo.channel.reader.a$a */
    public static class C0565a extends Exception {
        public C0565a(String str) {
            super(str);
        }
    }

    public static int a(ByteBuffer byteBuffer, int i2) {
        return byteBuffer.getShort(i2) & UShort.MAX_VALUE;
    }

    public static long a(ByteBuffer byteBuffer) {
        c(byteBuffer);
        return b(byteBuffer, byteBuffer.position() + 16);
    }

    static Pair<ByteBuffer, Long> a(RandomAccessFile randomAccessFile) {
        if (randomAccessFile.length() < 22) {
            return null;
        }
        Pair<ByteBuffer, Long> a2 = a(randomAccessFile, 0);
        return a2 != null ? a2 : a(randomAccessFile, 65535);
    }

    private static Pair<ByteBuffer, Long> a(RandomAccessFile randomAccessFile, int i2) {
        if (i2 < 0 || i2 > 65535) {
            throw new IllegalArgumentException("maxCommentSize: " + i2);
        }
        long length = randomAccessFile.length();
        if (length < 22) {
            return null;
        }
        ByteBuffer allocate = ByteBuffer.allocate(((int) Math.min(i2, length - 22)) + 22);
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        allocate.order(byteOrder);
        long capacity = length - allocate.capacity();
        randomAccessFile.seek(capacity);
        randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
        int d2 = d(allocate);
        if (d2 == -1) {
            return null;
        }
        allocate.position(d2);
        ByteBuffer slice = allocate.slice();
        slice.order(byteOrder);
        return Pair.create(slice, Long.valueOf(capacity + d2));
    }

    public static final boolean a(RandomAccessFile randomAccessFile, long j2) {
        long j3 = j2 - 20;
        if (j3 < 0) {
            return false;
        }
        randomAccessFile.seek(j3);
        return randomAccessFile.readInt() == 1347094023;
    }

    public static long b(ByteBuffer byteBuffer) {
        c(byteBuffer);
        return b(byteBuffer, byteBuffer.position() + 12);
    }

    public static long b(ByteBuffer byteBuffer, int i2) {
        return byteBuffer.getInt(i2) & 4294967295L;
    }

    public static void c(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    private static int d(ByteBuffer byteBuffer) {
        c(byteBuffer);
        int capacity = byteBuffer.capacity();
        if (capacity < 22) {
            return -1;
        }
        int i2 = capacity - 22;
        int min = Math.min(i2, 65535);
        for (int i3 = 0; i3 < min; i3++) {
            int i4 = i2 - i3;
            if (byteBuffer.getInt(i4) == 101010256 && a(byteBuffer, i4 + 20) == i3) {
                return i4;
            }
        }
        return -1;
    }
}

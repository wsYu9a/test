package com.bytedance.pangle.g;

import android.util.Pair;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.UShort;

/* loaded from: classes2.dex */
abstract class s {
    public static Pair<ByteBuffer, Long> a(RandomAccessFile randomAccessFile, int i10) {
        if (i10 < 0 || i10 > 65535) {
            throw new IllegalArgumentException("maxCommentSize: ".concat(String.valueOf(i10)));
        }
        long length = randomAccessFile.length();
        if (length < 22) {
            return null;
        }
        ByteBuffer allocate = ByteBuffer.allocate(((int) Math.min(i10, length - 22)) + 22);
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        allocate.order(byteOrder);
        long capacity = length - allocate.capacity();
        randomAccessFile.seek(capacity);
        randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
        int b10 = b(allocate);
        if (b10 == -1) {
            return null;
        }
        allocate.position(b10);
        ByteBuffer slice = allocate.slice();
        slice.order(byteOrder);
        return Pair.create(slice, Long.valueOf(capacity + b10));
    }

    private static int b(ByteBuffer byteBuffer) {
        a(byteBuffer);
        int capacity = byteBuffer.capacity();
        if (capacity < 22) {
            return -1;
        }
        int i10 = capacity - 22;
        int min = Math.min(i10, 65535);
        for (int i11 = 0; i11 <= min; i11++) {
            int i12 = i10 - i11;
            if (byteBuffer.getInt(i12) == 101010256 && (byteBuffer.getShort(i12 + 20) & UShort.MAX_VALUE) == i11) {
                return i12;
            }
        }
        return -1;
    }

    public static void a(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    public static long a(ByteBuffer byteBuffer, int i10) {
        return byteBuffer.getInt(i10) & 4294967295L;
    }
}

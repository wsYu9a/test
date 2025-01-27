package com.bytedance.pangle.util.a;

import com.bytedance.pangle.util.f;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a */
    private static String f6307a = "";

    public static String[] a(File file) {
        String str;
        ByteBuffer b2;
        boolean z;
        String str2 = "";
        try {
            b2 = b(file);
        } catch (Exception unused) {
            str = "";
        }
        if (b2.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
        ByteBuffer a2 = a(b2, b2.capacity() - 24);
        int i2 = 0;
        while (a2.hasRemaining()) {
            i2++;
            if (a2.remaining() < 8) {
                throw new Exception("Insufficient data to read size of APK Signing Block entry #".concat(String.valueOf(i2)));
            }
            long j2 = a2.getLong();
            if (j2 < 4 || j2 > 2147483647L) {
                throw new Exception("APK Signing Block entry #" + i2 + " size out of range: " + j2);
            }
            int i3 = (int) j2;
            int position = a2.position() + i3;
            if (i3 > a2.remaining()) {
                throw new Exception("APK Signing Block entry #" + i2 + " size out of range: " + i3 + ", available: " + a2.remaining());
            }
            int i4 = a2.getInt();
            if (i4 == -262969152) {
                f6307a = "V3";
            } else if (i4 == 1896449818) {
                f6307a = "V2";
            } else {
                a2.position(position);
            }
            z = true;
            break;
        }
        z = false;
        if (z) {
            str2 = f.a(b2.array());
            str = "";
        } else {
            str = "without v2 & v3 signature.";
        }
        return new String[]{str2, f6307a, str};
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004b A[Catch: all -> 0x018c, TryCatch #0 {all -> 0x018c, blocks: (B:5:0x0008, B:9:0x0024, B:11:0x003a, B:15:0x004b, B:17:0x005d, B:21:0x0075, B:23:0x00a8, B:25:0x00b5, B:29:0x00c9, B:31:0x00d3, B:33:0x00f4, B:37:0x0104, B:38:0x011f, B:39:0x0120, B:40:0x012f, B:41:0x0130, B:42:0x013f, B:43:0x0140, B:44:0x0147, B:45:0x0148, B:46:0x0157, B:47:0x0158, B:48:0x015f, B:49:0x0160, B:50:0x017b, B:51:0x017c, B:52:0x0183, B:54:0x0184, B:55:0x018b, B:56:0x0014, B:59:0x001b), top: B:4:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x017c A[Catch: all -> 0x018c, TryCatch #0 {all -> 0x018c, blocks: (B:5:0x0008, B:9:0x0024, B:11:0x003a, B:15:0x004b, B:17:0x005d, B:21:0x0075, B:23:0x00a8, B:25:0x00b5, B:29:0x00c9, B:31:0x00d3, B:33:0x00f4, B:37:0x0104, B:38:0x011f, B:39:0x0120, B:40:0x012f, B:41:0x0130, B:42:0x013f, B:43:0x0140, B:44:0x0147, B:45:0x0148, B:46:0x0157, B:47:0x0158, B:48:0x015f, B:49:0x0160, B:50:0x017b, B:51:0x017c, B:52:0x0183, B:54:0x0184, B:55:0x018b, B:56:0x0014, B:59:0x001b), top: B:4:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.nio.ByteBuffer b(java.io.File r13) {
        /*
            Method dump skipped, instructions count: 406
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.util.a.b.b(java.io.File):java.nio.ByteBuffer");
    }

    private static ByteBuffer a(ByteBuffer byteBuffer, int i2) {
        if (i2 >= 8) {
            int capacity = byteBuffer.capacity();
            if (i2 <= byteBuffer.capacity()) {
                int limit = byteBuffer.limit();
                int position = byteBuffer.position();
                try {
                    byteBuffer.position(0);
                    byteBuffer.limit(i2);
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
            throw new IllegalArgumentException("end > capacity: " + i2 + " > " + capacity);
        }
        throw new IllegalArgumentException("end < start: " + i2 + " < 8");
    }
}

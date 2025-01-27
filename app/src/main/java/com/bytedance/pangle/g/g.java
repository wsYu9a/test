package com.bytedance.pangle.g;

import java.io.FileDescriptor;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.util.ArrayList;

/* loaded from: classes.dex */
abstract class g {

    /* renamed from: a */
    private static final byte[] f6133a = new byte[8];

    static class a {

        /* renamed from: a */
        public final ByteBuffer f6134a;

        /* renamed from: b */
        public final byte[] f6135b;

        a(ByteBuffer byteBuffer, byte[] bArr) {
            this.f6134a = byteBuffer;
            this.f6135b = bArr;
        }
    }

    static class b implements j {

        /* renamed from: a */
        private int f6136a;

        /* renamed from: b */
        private final ByteBuffer f6137b;

        /* renamed from: c */
        private final MessageDigest f6138c;

        /* renamed from: d */
        private final byte[] f6139d;

        /* renamed from: e */
        private final byte[] f6140e;

        /* synthetic */ b(byte[] bArr, ByteBuffer byteBuffer, byte b2) {
            this(bArr, byteBuffer);
        }

        @Override // com.bytedance.pangle.g.j
        public final void a(ByteBuffer byteBuffer) {
            byteBuffer.position();
            int remaining = byteBuffer.remaining();
            while (remaining > 0) {
                int min = Math.min(remaining, 4096 - this.f6136a);
                byteBuffer.limit(byteBuffer.position() + min);
                this.f6138c.update(byteBuffer);
                remaining -= min;
                int i2 = this.f6136a + min;
                this.f6136a = i2;
                if (i2 == 4096) {
                    MessageDigest messageDigest = this.f6138c;
                    byte[] bArr = this.f6139d;
                    messageDigest.digest(bArr, 0, bArr.length);
                    this.f6137b.put(this.f6139d);
                    this.f6138c.update(this.f6140e);
                    this.f6136a = 0;
                }
            }
        }

        final void b() {
            int position = this.f6137b.position() % 4096;
            if (position == 0) {
                return;
            }
            this.f6137b.put(ByteBuffer.allocate(4096 - position));
        }

        private b(byte[] bArr, ByteBuffer byteBuffer) {
            this.f6139d = new byte[32];
            this.f6140e = bArr;
            this.f6137b = byteBuffer.slice();
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            this.f6138c = messageDigest;
            messageDigest.update(bArr);
            this.f6136a = 0;
        }

        public final void a() {
            if (this.f6136a == 0) {
                return;
            }
            throw new IllegalStateException("Buffer is not empty: " + this.f6136a);
        }
    }

    static a a(RandomAccessFile randomAccessFile, m mVar, i iVar) {
        int[] a2 = a(randomAccessFile.length() - (mVar.f6148c - mVar.f6147b));
        int i2 = a2[a2.length - 1];
        int i3 = i2 + 4096;
        ByteBuffer a3 = iVar.a(i3);
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        a3.order(byteOrder);
        ByteBuffer a4 = a(a3, 0, i2);
        int i4 = i2 + 64;
        ByteBuffer a5 = a(a3, i2, i4);
        ByteBuffer a6 = a(a3, i4, i3);
        byte[] bArr = new byte[32];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(byteOrder);
        long j2 = mVar.f6147b;
        if (j2 % 4096 != 0) {
            throw new IllegalArgumentException("APK Signing Block does not start at the page  boundary: " + mVar.f6147b);
        }
        long j3 = mVar.f6148c;
        if ((j3 - j2) % 4096 != 0) {
            throw new IllegalArgumentException("Size of APK Signing Block is not a multiple of 4096: " + (mVar.f6148c - mVar.f6147b));
        }
        long j4 = j3 - j2;
        int[] a7 = a(randomAccessFile.length() - j4);
        if (a4 != null) {
            wrap.put(a(randomAccessFile, mVar, f6133a, a7, a4));
            wrap.flip();
        }
        if (a5 != null) {
            a5.order(byteOrder);
            long length = randomAccessFile.length();
            byte[] bArr2 = f6133a;
            if (bArr2.length != 8) {
                throw new IllegalArgumentException("salt is not 8 bytes long");
            }
            a5.put("TrueBrew".getBytes());
            a5.put((byte) 1);
            a5.put((byte) 0);
            a5.put((byte) 12);
            a5.put((byte) 7);
            a5.putShort((short) 1);
            a5.putShort((short) 1);
            a5.putInt(0);
            a5.putInt(0);
            a5.putLong(length);
            a5.put((byte) 2);
            a5.put((byte) 0);
            a5.put(bArr2);
            a(a5, 22);
            a5.flip();
        }
        if (a6 != null) {
            a6.order(byteOrder);
            long j5 = mVar.f6147b;
            long j6 = mVar.f6149d;
            a6.putInt(24);
            a6.putShort((short) 1);
            a(a6, 2);
            a6.putLong(j5);
            a6.putLong(j4);
            a6.putInt(20);
            a6.putShort((short) 2);
            a(a6, 2);
            a6.putLong(j6 + 16);
            a6.putInt(c(j5));
            a(a6, 4);
            a6.flip();
        }
        a3.position(i4 + a6.limit());
        a3.putInt(a6.limit() + 64 + 4);
        a3.flip();
        return new a(a3, bArr);
    }

    private static long b(long j2) {
        return ((j2 + 4096) - 1) / 4096;
    }

    private static int c(long j2) {
        int i2 = (int) j2;
        if (i2 == j2) {
            return i2;
        }
        throw new ArithmeticException("integer overflow");
    }

    private static void a(j jVar, k kVar, int i2) {
        long a2 = kVar.a();
        long j2 = 0;
        while (a2 > 0) {
            int min = (int) Math.min(a2, i2);
            kVar.a(jVar, j2, min);
            long j3 = min;
            j2 += j3;
            a2 -= j3;
        }
    }

    private static byte[] a(RandomAccessFile randomAccessFile, m mVar, byte[] bArr, int[] iArr, ByteBuffer byteBuffer) {
        b bVar = new b(bArr, a(byteBuffer, iArr[iArr.length - 2], iArr[iArr.length - 1]), (byte) 0);
        a(bVar, new l(randomAccessFile.getFD(), 0L, mVar.f6147b), 1048576);
        long j2 = mVar.f6149d + 16;
        FileDescriptor fd = randomAccessFile.getFD();
        long j3 = mVar.f6148c;
        a(bVar, new l(fd, j3, j2 - j3), 1048576);
        ByteBuffer order = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
        order.putInt(c(mVar.f6147b));
        order.flip();
        bVar.a(order);
        long j4 = j2 + 4;
        a(bVar, new l(randomAccessFile.getFD(), j4, randomAccessFile.length() - j4), 1048576);
        int length = (int) (randomAccessFile.length() % 4096);
        if (length != 0) {
            bVar.a(ByteBuffer.allocate(4096 - length));
        }
        bVar.a();
        bVar.b();
        for (int length2 = iArr.length - 3; length2 >= 0; length2--) {
            int i2 = length2 + 1;
            ByteBuffer a2 = a(byteBuffer, iArr[i2], iArr[length2 + 2]);
            ByteBuffer a3 = a(byteBuffer, iArr[length2], iArr[i2]);
            h hVar = new h(a2);
            b bVar2 = new b(bArr, a3, (byte) 0);
            a(bVar2, hVar, 4096);
            bVar2.a();
            bVar2.b();
        }
        byte[] bArr2 = new byte[32];
        b bVar3 = new b(bArr, ByteBuffer.wrap(bArr2), (byte) 0);
        bVar3.a(a(byteBuffer, 0, 4096));
        bVar3.a();
        return bArr2;
    }

    private static int[] a(long j2) {
        ArrayList arrayList = new ArrayList();
        do {
            j2 = b(j2) * 32;
            arrayList.add(Long.valueOf(b(j2) * 4096));
        } while (j2 > 4096);
        int[] iArr = new int[arrayList.size() + 1];
        int i2 = 0;
        iArr[0] = 0;
        while (i2 < arrayList.size()) {
            int i3 = i2 + 1;
            iArr[i3] = iArr[i2] + c(((Long) arrayList.get((arrayList.size() - i2) - 1)).longValue());
            i2 = i3;
        }
        return iArr;
    }

    private static ByteBuffer a(ByteBuffer byteBuffer, int i2, int i3) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.position(0);
        duplicate.limit(i3);
        duplicate.position(i2);
        return duplicate.slice();
    }

    private static void a(ByteBuffer byteBuffer, int i2) {
        byteBuffer.position(byteBuffer.position() + i2);
    }
}

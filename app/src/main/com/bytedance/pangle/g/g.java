package com.bytedance.pangle.g;

import java.io.FileDescriptor;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.util.ArrayList;

/* loaded from: classes2.dex */
abstract class g {

    /* renamed from: a */
    private static final byte[] f7635a = new byte[8];

    public static class a {

        /* renamed from: a */
        public final ByteBuffer f7636a;

        /* renamed from: b */
        public final byte[] f7637b;

        public a(ByteBuffer byteBuffer, byte[] bArr) {
            this.f7636a = byteBuffer;
            this.f7637b = bArr;
        }
    }

    public static class b implements j {

        /* renamed from: a */
        private int f7638a;

        /* renamed from: b */
        private final ByteBuffer f7639b;

        /* renamed from: c */
        private final MessageDigest f7640c;

        /* renamed from: d */
        private final byte[] f7641d;

        /* renamed from: e */
        private final byte[] f7642e;

        public /* synthetic */ b(byte[] bArr, ByteBuffer byteBuffer, byte b10) {
            this(bArr, byteBuffer);
        }

        @Override // com.bytedance.pangle.g.j
        public final void a(ByteBuffer byteBuffer) {
            byteBuffer.position();
            int remaining = byteBuffer.remaining();
            while (remaining > 0) {
                int min = Math.min(remaining, 4096 - this.f7638a);
                byteBuffer.limit(byteBuffer.position() + min);
                this.f7640c.update(byteBuffer);
                remaining -= min;
                int i10 = this.f7638a + min;
                this.f7638a = i10;
                if (i10 == 4096) {
                    MessageDigest messageDigest = this.f7640c;
                    byte[] bArr = this.f7641d;
                    messageDigest.digest(bArr, 0, bArr.length);
                    this.f7639b.put(this.f7641d);
                    this.f7640c.update(this.f7642e);
                    this.f7638a = 0;
                }
            }
        }

        public final void b() {
            int position = this.f7639b.position() % 4096;
            if (position == 0) {
                return;
            }
            this.f7639b.put(ByteBuffer.allocate(4096 - position));
        }

        private b(byte[] bArr, ByteBuffer byteBuffer) {
            this.f7641d = new byte[32];
            this.f7642e = bArr;
            this.f7639b = byteBuffer.slice();
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            this.f7640c = messageDigest;
            messageDigest.update(bArr);
            this.f7638a = 0;
        }

        public final void a() {
            if (this.f7638a == 0) {
                return;
            }
            throw new IllegalStateException("Buffer is not empty: " + this.f7638a);
        }
    }

    public static a a(RandomAccessFile randomAccessFile, m mVar, i iVar) {
        int[] a10 = a(randomAccessFile.length() - (mVar.f7650c - mVar.f7649b));
        int i10 = a10[a10.length - 1];
        int i11 = i10 + 4096;
        ByteBuffer a11 = iVar.a(i11);
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        a11.order(byteOrder);
        ByteBuffer a12 = a(a11, 0, i10);
        int i12 = i10 + 64;
        ByteBuffer a13 = a(a11, i10, i12);
        ByteBuffer a14 = a(a11, i12, i11);
        byte[] bArr = new byte[32];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(byteOrder);
        long j10 = mVar.f7649b;
        if (j10 % 4096 != 0) {
            throw new IllegalArgumentException("APK Signing Block does not start at the page  boundary: " + mVar.f7649b);
        }
        long j11 = mVar.f7650c;
        if ((j11 - j10) % 4096 != 0) {
            throw new IllegalArgumentException("Size of APK Signing Block is not a multiple of 4096: " + (mVar.f7650c - mVar.f7649b));
        }
        long j12 = j11 - j10;
        int[] a15 = a(randomAccessFile.length() - j12);
        if (a12 != null) {
            wrap.put(a(randomAccessFile, mVar, f7635a, a15, a12));
            wrap.flip();
        }
        if (a13 != null) {
            a13.order(byteOrder);
            long length = randomAccessFile.length();
            byte[] bArr2 = f7635a;
            if (bArr2.length != 8) {
                throw new IllegalArgumentException("salt is not 8 bytes long");
            }
            a13.put("TrueBrew".getBytes());
            a13.put((byte) 1);
            a13.put((byte) 0);
            a13.put((byte) 12);
            a13.put((byte) 7);
            a13.putShort((short) 1);
            a13.putShort((short) 1);
            a13.putInt(0);
            a13.putInt(0);
            a13.putLong(length);
            a13.put((byte) 2);
            a13.put((byte) 0);
            a13.put(bArr2);
            a(a13, 22);
            a13.flip();
        }
        if (a14 != null) {
            a14.order(byteOrder);
            long j13 = mVar.f7649b;
            long j14 = mVar.f7651d;
            a14.putInt(24);
            a14.putShort((short) 1);
            a(a14, 2);
            a14.putLong(j13);
            a14.putLong(j12);
            a14.putInt(20);
            a14.putShort((short) 2);
            a(a14, 2);
            a14.putLong(j14 + 16);
            a14.putInt(c(j13));
            a(a14, 4);
            a14.flip();
        }
        a11.position(i12 + a14.limit());
        a11.putInt(a14.limit() + 68);
        a11.flip();
        return new a(a11, bArr);
    }

    private static long b(long j10) {
        return (j10 + 4095) / 4096;
    }

    private static int c(long j10) {
        int i10 = (int) j10;
        if (i10 == j10) {
            return i10;
        }
        throw new ArithmeticException("integer overflow");
    }

    private static void a(j jVar, k kVar, int i10) {
        long a10 = kVar.a();
        long j10 = 0;
        while (a10 > 0) {
            int min = (int) Math.min(a10, i10);
            kVar.a(jVar, j10, min);
            long j11 = min;
            j10 += j11;
            a10 -= j11;
        }
    }

    private static byte[] a(RandomAccessFile randomAccessFile, m mVar, byte[] bArr, int[] iArr, ByteBuffer byteBuffer) {
        b bVar = new b(bArr, a(byteBuffer, iArr[iArr.length - 2], iArr[iArr.length - 1]), (byte) 0);
        a(bVar, new l(randomAccessFile.getFD(), 0L, mVar.f7649b), 1048576);
        long j10 = mVar.f7651d;
        FileDescriptor fd2 = randomAccessFile.getFD();
        long j11 = mVar.f7650c;
        a(bVar, new l(fd2, j11, (16 + j10) - j11), 1048576);
        ByteBuffer order = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
        order.putInt(c(mVar.f7649b));
        order.flip();
        bVar.a(order);
        long j12 = j10 + 20;
        a(bVar, new l(randomAccessFile.getFD(), j12, randomAccessFile.length() - j12), 1048576);
        int length = (int) (randomAccessFile.length() % 4096);
        if (length != 0) {
            bVar.a(ByteBuffer.allocate(4096 - length));
        }
        bVar.a();
        bVar.b();
        for (int length2 = iArr.length - 3; length2 >= 0; length2--) {
            int i10 = length2 + 1;
            ByteBuffer a10 = a(byteBuffer, iArr[i10], iArr[length2 + 2]);
            ByteBuffer a11 = a(byteBuffer, iArr[length2], iArr[i10]);
            h hVar = new h(a10);
            b bVar2 = new b(bArr, a11, (byte) 0);
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

    private static int[] a(long j10) {
        ArrayList arrayList = new ArrayList();
        do {
            j10 = b(j10) * 32;
            arrayList.add(Long.valueOf(b(j10) * 4096));
        } while (j10 > 4096);
        int[] iArr = new int[arrayList.size() + 1];
        int i10 = 0;
        iArr[0] = 0;
        while (i10 < arrayList.size()) {
            int i11 = i10 + 1;
            iArr[i11] = iArr[i10] + c(((Long) arrayList.get((arrayList.size() - i10) - 1)).longValue());
            i10 = i11;
        }
        return iArr;
    }

    private static ByteBuffer a(ByteBuffer byteBuffer, int i10, int i11) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.position(0);
        duplicate.limit(i11);
        duplicate.position(i10);
        return duplicate.slice();
    }

    private static void a(ByteBuffer byteBuffer, int i10) {
        byteBuffer.position(byteBuffer.position() + i10);
    }
}

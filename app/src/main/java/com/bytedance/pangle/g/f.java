package com.bytedance.pangle.g;

import android.util.ArrayMap;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.RequiresApi;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
final class f {

    /* renamed from: a */
    static final HashMap<String, SparseArray<m>> f6131a = new HashMap<>();

    /* renamed from: com.bytedance.pangle.g.f$1 */
    static class AnonymousClass1 implements i {
        AnonymousClass1() {
        }

        @Override // com.bytedance.pangle.g.i
        public final ByteBuffer a(int i2) {
            return ByteBuffer.allocate(i2);
        }
    }

    static class a implements j {

        /* renamed from: a */
        private final MessageDigest[] f6132a;

        a(MessageDigest[] messageDigestArr) {
            this.f6132a = messageDigestArr;
        }

        @Override // com.bytedance.pangle.g.j
        public final void a(ByteBuffer byteBuffer) {
            ByteBuffer slice = byteBuffer.slice();
            for (MessageDigest messageDigest : this.f6132a) {
                slice.position(0);
                messageDigest.update(slice);
            }
        }
    }

    @RequiresApi(api = 21)
    static void a(Map<Integer, byte[]> map, RandomAccessFile randomAccessFile, m mVar) {
        if (map.isEmpty()) {
            throw new SecurityException("No digests provided");
        }
        ArrayMap arrayMap = new ArrayMap();
        boolean z = true;
        if (map.containsKey(1)) {
            arrayMap.put(1, map.get(1));
        }
        if (map.containsKey(2)) {
            arrayMap.put(2, map.get(2));
        }
        boolean z2 = false;
        if (!arrayMap.isEmpty()) {
            try {
                a(arrayMap, randomAccessFile.getFD(), mVar);
                z = false;
            } catch (IOException e2) {
                throw new SecurityException("Cannot get FD", e2);
            }
        }
        if (map.containsKey(3)) {
            try {
                if (!Arrays.equals(a(map.get(3), randomAccessFile.length(), mVar), g.a(randomAccessFile, mVar, new i() { // from class: com.bytedance.pangle.g.f.1
                    AnonymousClass1() {
                    }

                    @Override // com.bytedance.pangle.g.i
                    public final ByteBuffer a(int i2) {
                        return ByteBuffer.allocate(i2);
                    }
                }).f6135b)) {
                    throw new SecurityException("APK verity digest of contents did not verify");
                }
            } catch (IOException | DigestException | NoSuchAlgorithmException e3) {
                throw new SecurityException("Error during verification", e3);
            }
        } else {
            z2 = z;
        }
        if (z2) {
            throw new SecurityException("No known digest exists for integrity check");
        }
    }

    static String b(int i2) {
        if (i2 == 1) {
            return "SHA-256";
        }
        if (i2 == 2) {
            return "SHA-512";
        }
        if (i2 == 3) {
            return "SHA-256";
        }
        throw new IllegalArgumentException("Unknown content digest algorthm: ".concat(String.valueOf(i2)));
    }

    static String c(int i2) {
        if (i2 == 513 || i2 == 514) {
            return "EC";
        }
        if (i2 == 769) {
            return "DSA";
        }
        if (i2 == 1057) {
            return "RSA";
        }
        if (i2 == 1059) {
            return "EC";
        }
        if (i2 == 1061) {
            return "DSA";
        }
        switch (i2) {
            case 257:
            case 258:
            case 259:
            case 260:
                return "RSA";
            default:
                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i2 & (-1)));
        }
    }

    static Pair<String, ? extends AlgorithmParameterSpec> d(int i2) {
        if (i2 != 513) {
            if (i2 == 514) {
                return Pair.create("SHA512withECDSA", null);
            }
            if (i2 != 769) {
                if (i2 != 1057) {
                    if (i2 != 1059) {
                        if (i2 != 1061) {
                            switch (i2) {
                                case 257:
                                    return Pair.create("SHA256withRSA/PSS", new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
                                case 258:
                                    return Pair.create("SHA512withRSA/PSS", new PSSParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1));
                                case 259:
                                    break;
                                case 260:
                                    return Pair.create("SHA512withRSA", null);
                                default:
                                    throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i2 & (-1)));
                            }
                        }
                    }
                }
                return Pair.create("SHA256withRSA", null);
            }
            return Pair.create("SHA256withDSA", null);
        }
        return Pair.create("SHA256withECDSA", null);
    }

    private static int e(int i2) {
        if (i2 == 1) {
            return 32;
        }
        if (i2 == 2) {
            return 64;
        }
        if (i2 == 3) {
            return 32;
        }
        throw new IllegalArgumentException("Unknown content digest algorthm: ".concat(String.valueOf(i2)));
    }

    private static ByteBuffer b(ByteBuffer byteBuffer, int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("size: ".concat(String.valueOf(i2)));
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

    static byte[] b(ByteBuffer byteBuffer) {
        int i2 = byteBuffer.getInt();
        if (i2 >= 0) {
            if (i2 <= byteBuffer.remaining()) {
                byte[] bArr = new byte[i2];
                byteBuffer.get(bArr);
                return bArr;
            }
            throw new IOException("Underflow while reading length-prefixed value. Length: " + i2 + ", available: " + byteBuffer.remaining());
        }
        throw new IOException("Negative length");
    }

    private static void a(Map<Integer, byte[]> map, FileDescriptor fileDescriptor, m mVar) {
        l lVar = new l(fileDescriptor, 0L, mVar.f6147b);
        long j2 = mVar.f6148c;
        l lVar2 = new l(fileDescriptor, j2, mVar.f6149d - j2);
        ByteBuffer duplicate = mVar.f6150e.duplicate();
        duplicate.order(ByteOrder.LITTLE_ENDIAN);
        long j3 = mVar.f6147b;
        s.a(duplicate);
        int position = duplicate.position() + 16;
        if (j3 >= 0 && j3 <= 4294967295L) {
            duplicate.putInt(duplicate.position() + position, (int) j3);
            h hVar = new h(duplicate);
            int size = map.size();
            int[] iArr = new int[size];
            Iterator<Integer> it = map.keySet().iterator();
            int i2 = 0;
            while (it.hasNext()) {
                iArr[i2] = it.next().intValue();
                i2++;
            }
            try {
                byte[][] a2 = a(iArr, new k[]{lVar, lVar2, hVar});
                for (int i3 = 0; i3 < size; i3++) {
                    int i4 = iArr[i3];
                    if (!MessageDigest.isEqual(map.get(Integer.valueOf(i4)), a2[i3])) {
                        throw new SecurityException(b(i4) + " digest of contents did not verify");
                    }
                }
                return;
            } catch (DigestException e2) {
                throw new SecurityException("Failed to compute digest(s) of contents", e2);
            }
        }
        throw new IllegalArgumentException("uint32 value of out range: ".concat(String.valueOf(j3)));
    }

    private static byte[][] a(int[] iArr, k[] kVarArr) {
        int i2;
        long j2;
        long j3 = 0;
        long j4 = 0;
        int i3 = 0;
        while (true) {
            i2 = 3;
            j2 = 1048576;
            if (i3 >= 3) {
                break;
            }
            j4 += ((kVarArr[i3].a() + 1048576) - 1) / 1048576;
            i3++;
        }
        if (j4 < 2097151) {
            int i4 = (int) j4;
            byte[][] bArr = new byte[iArr.length][];
            for (int i5 = 0; i5 < iArr.length; i5++) {
                byte[] bArr2 = new byte[(e(iArr[i5]) * i4) + 5];
                bArr2[0] = 90;
                a(i4, bArr2);
                bArr[i5] = bArr2;
            }
            byte[] bArr3 = new byte[5];
            bArr3[0] = -91;
            int length = iArr.length;
            MessageDigest[] messageDigestArr = new MessageDigest[length];
            for (int i6 = 0; i6 < iArr.length; i6++) {
                String b2 = b(iArr[i6]);
                try {
                    messageDigestArr[i6] = MessageDigest.getInstance(b2);
                } catch (NoSuchAlgorithmException e2) {
                    throw new RuntimeException(b2 + " digest not supported", e2);
                }
            }
            a aVar = new a(messageDigestArr);
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            while (i7 < i2) {
                k kVar = kVarArr[i7];
                long j5 = j3;
                int i10 = i9;
                a aVar2 = aVar;
                long a2 = kVar.a();
                while (a2 > j3) {
                    int min = (int) Math.min(a2, j2);
                    a(min, bArr3);
                    for (int i11 = 0; i11 < length; i11++) {
                        messageDigestArr[i11].update(bArr3);
                    }
                    a aVar3 = aVar2;
                    long j6 = j5;
                    try {
                        kVar.a(aVar3, j6, min);
                        aVar2 = aVar3;
                        k kVar2 = kVar;
                        int i12 = 0;
                        while (i12 < iArr.length) {
                            int i13 = iArr[i12];
                            byte[] bArr4 = bArr3;
                            byte[] bArr5 = bArr[i12];
                            int e3 = e(i13);
                            int i14 = length;
                            MessageDigest messageDigest = messageDigestArr[i12];
                            MessageDigest[] messageDigestArr2 = messageDigestArr;
                            int digest = messageDigest.digest(bArr5, (i10 * e3) + 5, e3);
                            if (digest != e3) {
                                throw new RuntimeException("Unexpected output size of " + messageDigest.getAlgorithm() + " digest: " + digest);
                            }
                            i12++;
                            bArr3 = bArr4;
                            length = i14;
                            messageDigestArr = messageDigestArr2;
                        }
                        long j7 = min;
                        long j8 = j6 + j7;
                        a2 -= j7;
                        i10++;
                        j3 = 0;
                        j2 = 1048576;
                        kVar = kVar2;
                        bArr3 = bArr3;
                        j5 = j8;
                    } catch (IOException e4) {
                        throw new DigestException("Failed to digest chunk #" + i10 + " of section #" + i8, e4);
                    }
                }
                i8++;
                i7++;
                i9 = i10;
                aVar = aVar2;
                j3 = 0;
                i2 = 3;
                j2 = 1048576;
            }
            byte[][] bArr6 = new byte[iArr.length][];
            for (int i15 = 0; i15 < iArr.length; i15++) {
                int i16 = iArr[i15];
                byte[] bArr7 = bArr[i15];
                String b3 = b(i16);
                try {
                    bArr6[i15] = MessageDigest.getInstance(b3).digest(bArr7);
                } catch (NoSuchAlgorithmException e5) {
                    throw new RuntimeException(b3 + " digest not supported", e5);
                }
            }
            return bArr6;
        }
        throw new DigestException("Too many chunks: ".concat(String.valueOf(j4)));
    }

    static byte[] a(byte[] bArr, long j2, m mVar) {
        if (bArr.length == 40) {
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            order.position(32);
            if (order.getLong() == j2 - (mVar.f6148c - mVar.f6147b)) {
                return Arrays.copyOfRange(bArr, 0, 32);
            }
            throw new SecurityException("APK content size did not verify");
        }
        throw new SecurityException("Verity digest size is wrong: " + bArr.length);
    }

    static int a(int i2, int i3) {
        int a2 = a(i2);
        int a3 = a(i3);
        if (a2 == 1) {
            if (a3 == 1) {
                return 0;
            }
            if (a3 == 2 || a3 == 3) {
                return -1;
            }
            throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(a3)));
        }
        if (a2 == 2) {
            if (a3 != 1) {
                if (a3 == 2) {
                    return 0;
                }
                if (a3 != 3) {
                    throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(a3)));
                }
            }
            return 1;
        }
        if (a2 != 3) {
            throw new IllegalArgumentException("Unknown digestAlgorithm1: ".concat(String.valueOf(a2)));
        }
        if (a3 == 1) {
            return 1;
        }
        if (a3 == 2) {
            return -1;
        }
        if (a3 == 3) {
            return 0;
        }
        throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(a3)));
    }

    static int a(int i2) {
        if (i2 == 513) {
            return 1;
        }
        if (i2 == 514) {
            return 2;
        }
        if (i2 == 769) {
            return 1;
        }
        if (i2 == 1057 || i2 == 1059 || i2 == 1061) {
            return 3;
        }
        switch (i2) {
            case 257:
            case 259:
                return 1;
            case 258:
            case 260:
                return 2;
            default:
                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i2 & (-1)));
        }
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

    static ByteBuffer a(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() >= 4) {
            int i2 = byteBuffer.getInt();
            if (i2 >= 0) {
                if (i2 <= byteBuffer.remaining()) {
                    return b(byteBuffer, i2);
                }
                throw new IOException("Length-prefixed field longer than remaining buffer. Field length: " + i2 + ", remaining: " + byteBuffer.remaining());
            }
            throw new IllegalArgumentException("Negative length");
        }
        throw new IOException("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + byteBuffer.remaining());
    }

    private static void a(int i2, byte[] bArr) {
        bArr[1] = (byte) (i2 & 255);
        bArr[2] = (byte) ((i2 >>> 8) & 255);
        bArr[3] = (byte) ((i2 >>> 16) & 255);
        bArr[4] = (byte) ((i2 >>> 24) & 255);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0246  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void a(java.lang.String r24, java.io.RandomAccessFile r25, int... r26) {
        /*
            Method dump skipped, instructions count: 600
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.g.f.a(java.lang.String, java.io.RandomAccessFile, int[]):void");
    }
}

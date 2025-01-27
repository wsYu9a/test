package com.tencent.bugly.proguard;

import java.nio.ByteBuffer;

/* renamed from: com.tencent.bugly.proguard.n */
/* loaded from: classes4.dex */
public final class C0869n {

    /* renamed from: a */
    private static final byte[] f22769a;

    /* renamed from: b */
    private static final byte[] f22770b;

    static {
        byte[] bArr = {com.sigmob.sdk.archives.tar.e.E, com.sigmob.sdk.archives.tar.e.F, com.sigmob.sdk.archives.tar.e.G, com.sigmob.sdk.archives.tar.e.H, com.sigmob.sdk.archives.tar.e.I, com.sigmob.sdk.archives.tar.e.J, com.sigmob.sdk.archives.tar.e.K, com.sigmob.sdk.archives.tar.e.L, nf.c.f28888t, 57, 65, 66, 67, 68, 69, 70};
        byte[] bArr2 = new byte[256];
        byte[] bArr3 = new byte[256];
        for (int i10 = 0; i10 < 256; i10++) {
            bArr2[i10] = bArr[i10 >>> 4];
            bArr3[i10] = bArr[i10 & 15];
        }
        f22769a = bArr2;
        f22770b = bArr3;
    }

    public static boolean a(byte b10, byte b11) {
        return b10 == b11;
    }

    public static boolean a(int i10, int i11) {
        return i10 == i11;
    }

    public static boolean a(long j10, long j11) {
        return j10 == j11;
    }

    public static boolean a(boolean z10, boolean z11) {
        return z10 == z11;
    }

    public static boolean a(Object obj, Object obj2) {
        return obj.equals(obj2);
    }

    public static byte[] a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        byte[] bArr = new byte[position];
        System.arraycopy(byteBuffer.array(), 0, bArr, 0, position);
        return bArr;
    }
}

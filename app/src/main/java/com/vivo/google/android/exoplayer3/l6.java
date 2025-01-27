package com.vivo.google.android.exoplayer3;

import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class l6 {

    /* renamed from: a */
    public static final byte[] f27726a = {0, 0, 0, 1};

    /* renamed from: b */
    public static final float[] f27727b = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};

    /* renamed from: c */
    public static final Object f27728c = new Object();

    /* renamed from: d */
    public static int[] f27729d = new int[10];

    public static final class a {

        /* renamed from: a */
        public final int f27730a;

        /* renamed from: b */
        public final int f27731b;

        /* renamed from: c */
        public final boolean f27732c;

        public a(int i2, int i3, boolean z) {
            this.f27730a = i2;
            this.f27731b = i3;
            this.f27732c = z;
        }
    }

    public static final class b {

        /* renamed from: a */
        public final int f27733a;

        /* renamed from: b */
        public final int f27734b;

        /* renamed from: c */
        public final int f27735c;

        /* renamed from: d */
        public final float f27736d;

        /* renamed from: e */
        public final boolean f27737e;

        /* renamed from: f */
        public final boolean f27738f;

        /* renamed from: g */
        public final int f27739g;

        /* renamed from: h */
        public final int f27740h;

        /* renamed from: i */
        public final int f27741i;

        /* renamed from: j */
        public final boolean f27742j;

        public b(int i2, int i3, int i4, float f2, boolean z, boolean z2, int i5, int i6, int i7, boolean z3) {
            this.f27733a = i2;
            this.f27734b = i3;
            this.f27735c = i4;
            this.f27736d = f2;
            this.f27737e = z;
            this.f27738f = z2;
            this.f27739g = i5;
            this.f27740h = i6;
            this.f27741i = i7;
            this.f27742j = z3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x0095, code lost:
    
        r8 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(byte[] r7, int r8, int r9, boolean[] r10) {
        /*
            Method dump skipped, instructions count: 188
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.l6.a(byte[], int, int, boolean[]):int");
    }

    public static a a(byte[] bArr, int i2, int i3) {
        o6 o6Var = new o6(bArr, i2, i3);
        o6Var.d(8);
        int d2 = o6Var.d();
        int d3 = o6Var.d();
        o6Var.f();
        return new a(d2, d3, o6Var.c());
    }

    public static void a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i2 + 1;
            if (i4 >= position) {
                byteBuffer.clear();
                return;
            }
            int i5 = byteBuffer.get(i2) & 255;
            if (i3 == 3) {
                if (i5 == 1 && (byteBuffer.get(i4) & 31) == 7) {
                    ByteBuffer duplicate = byteBuffer.duplicate();
                    duplicate.position(i2 - 3);
                    duplicate.limit(position);
                    byteBuffer.position(0);
                    byteBuffer.put(duplicate);
                    return;
                }
            } else if (i5 == 0) {
                i3++;
            }
            if (i5 != 0) {
                i3 = 0;
            }
            i2 = i4;
        }
    }

    public static void a(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static boolean a(String str, byte b2) {
        if ("video/avc".equals(str) && (b2 & 31) == 6) {
            return true;
        }
        return "video/hevc".equals(str) && ((b2 & 126) >> 1) == 39;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0158  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.vivo.google.android.exoplayer3.l6.b b(byte[] r19, int r20, int r21) {
        /*
            Method dump skipped, instructions count: 380
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.l6.b(byte[], int, int):com.vivo.google.android.exoplayer3.l6$b");
    }

    public static int a(byte[] bArr, int i2) {
        int i3;
        synchronized (f27728c) {
            int i4 = 0;
            int i5 = 0;
            while (i4 < i2) {
                while (true) {
                    if (i4 >= i2 - 2) {
                        i4 = i2;
                        break;
                    }
                    try {
                        if (bArr[i4] == 0 && bArr[i4 + 1] == 0 && bArr[i4 + 2] == 3) {
                            break;
                        }
                        i4++;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (i4 < i2) {
                    int[] iArr = f27729d;
                    if (iArr.length <= i5) {
                        f27729d = Arrays.copyOf(iArr, iArr.length * 2);
                    }
                    f27729d[i5] = i4;
                    i4 += 3;
                    i5++;
                }
            }
            i3 = i2 - i5;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < i5; i8++) {
                int i9 = f27729d[i8] - i6;
                System.arraycopy(bArr, i6, bArr, i7, i9);
                int i10 = i7 + i9;
                int i11 = i10 + 1;
                bArr[i10] = 0;
                i7 = i11 + 1;
                bArr[i11] = 0;
                i6 += i9 + 3;
            }
            System.arraycopy(bArr, i6, bArr, i7, i3 - i7);
        }
        return i3;
    }
}

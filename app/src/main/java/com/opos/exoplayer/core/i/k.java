package com.opos.exoplayer.core.i;

import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class k {

    /* renamed from: a */
    public static final byte[] f19027a = {0, 0, 0, 1};

    /* renamed from: b */
    public static final float[] f19028b = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};

    /* renamed from: c */
    private static final Object f19029c = new Object();

    /* renamed from: d */
    private static int[] f19030d = new int[10];

    public static final class a {

        /* renamed from: a */
        public final int f19031a;

        /* renamed from: b */
        public final int f19032b;

        /* renamed from: c */
        public final boolean f19033c;

        public a(int i2, int i3, boolean z) {
            this.f19031a = i2;
            this.f19032b = i3;
            this.f19033c = z;
        }
    }

    public static final class b {

        /* renamed from: a */
        public final int f19034a;

        /* renamed from: b */
        public final int f19035b;

        /* renamed from: c */
        public final int f19036c;

        /* renamed from: d */
        public final float f19037d;

        /* renamed from: e */
        public final boolean f19038e;

        /* renamed from: f */
        public final boolean f19039f;

        /* renamed from: g */
        public final int f19040g;

        /* renamed from: h */
        public final int f19041h;

        /* renamed from: i */
        public final int f19042i;

        /* renamed from: j */
        public final boolean f19043j;

        public b(int i2, int i3, int i4, float f2, boolean z, boolean z2, int i5, int i6, int i7, boolean z3) {
            this.f19034a = i2;
            this.f19035b = i3;
            this.f19036c = i4;
            this.f19037d = f2;
            this.f19038e = z;
            this.f19039f = z2;
            this.f19040g = i5;
            this.f19041h = i6;
            this.f19042i = i7;
            this.f19043j = z3;
        }
    }

    public static int a(byte[] bArr, int i2) {
        int i3;
        synchronized (f19029c) {
            int i4 = 0;
            int i5 = 0;
            while (i4 < i2) {
                try {
                    i4 = c(bArr, i4, i2);
                    if (i4 < i2) {
                        int[] iArr = f19030d;
                        if (iArr.length <= i5) {
                            f19030d = Arrays.copyOf(iArr, iArr.length * 2);
                        }
                        f19030d[i5] = i4;
                        i4 += 3;
                        i5++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            i3 = i2 - i5;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            while (i6 < i5) {
                int i9 = f19030d[i6] - i7;
                System.arraycopy(bArr, i7, bArr, i8, i9);
                int i10 = i8 + i9;
                int i11 = i10 + 1;
                byte b2 = (byte) 0;
                bArr[i10] = b2;
                bArr[i11] = b2;
                i7 += i9 + 3;
                i6++;
                i8 = i11 + 1;
            }
            System.arraycopy(bArr, i7, bArr, i8, i3 - i8);
        }
        return i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0062, code lost:
    
        if (r8 != null) goto L114;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(byte[] r5, int r6, int r7, boolean[] r8) {
        /*
            Method dump skipped, instructions count: 191
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.i.k.a(byte[], int, int, boolean[]):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0143  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.opos.exoplayer.core.i.k.b a(byte[] r18, int r19, int r20) {
        /*
            Method dump skipped, instructions count: 366
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.i.k.a(byte[], int, int):com.opos.exoplayer.core.i.k$b");
    }

    private static void a(n nVar, int i2) {
        int i3 = 8;
        int i4 = 8;
        for (int i5 = 0; i5 < i2; i5++) {
            if (i3 != 0) {
                i3 = ((nVar.e() + i4) + 256) % 256;
            }
            if (i3 != 0) {
                i4 = i3;
            }
        }
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

    public static int b(byte[] bArr, int i2) {
        return bArr[i2 + 3] & 31;
    }

    public static a b(byte[] bArr, int i2, int i3) {
        n nVar = new n(bArr, i2, i3);
        nVar.a(8);
        int d2 = nVar.d();
        int d3 = nVar.d();
        nVar.a();
        return new a(d2, d3, nVar.b());
    }

    public static int c(byte[] bArr, int i2) {
        return (bArr[i2 + 3] & 126) >> 1;
    }

    private static int c(byte[] bArr, int i2, int i3) {
        while (i2 < i3 - 2) {
            if (bArr[i2] == 0 && bArr[i2 + 1] == 0 && bArr[i2 + 2] == 3) {
                return i2;
            }
            i2++;
        }
        return i3;
    }
}

package com.opos.exoplayer.core.i;

import android.util.Pair;
import com.vivo.google.android.exoplayer3.DefaultLoadControl;

/* loaded from: classes4.dex */
public final class c {

    /* renamed from: a */
    private static final byte[] f19009a = {0, 0, 0, 1};

    /* renamed from: b */
    private static final int[] f19010b = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, DefaultLoadControl.DEFAULT_MAX_BUFFER_MS, 7350};

    /* renamed from: c */
    private static final int[] f19011c = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    private static int a(l lVar) {
        int c2 = lVar.c(5);
        return c2 == 31 ? lVar.c(6) + 32 : c2;
    }

    public static Pair<Integer, Integer> a(l lVar, boolean z) {
        int a2 = a(lVar);
        int b2 = b(lVar);
        int c2 = lVar.c(4);
        if (a2 == 5 || a2 == 29) {
            b2 = b(lVar);
            a2 = a(lVar);
            if (a2 == 22) {
                c2 = lVar.c(4);
            }
        }
        if (z) {
            if (a2 != 1 && a2 != 2 && a2 != 3 && a2 != 4 && a2 != 6 && a2 != 7 && a2 != 17) {
                switch (a2) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        throw new com.opos.exoplayer.core.o("Unsupported audio object type: " + a2);
                }
            }
            a(lVar, a2, c2);
            switch (a2) {
                case 17:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    int c3 = lVar.c(2);
                    if (c3 == 2 || c3 == 3) {
                        throw new com.opos.exoplayer.core.o("Unsupported epConfig: " + c3);
                    }
            }
        }
        int i2 = f19011c[c2];
        a.a(i2 != -1);
        return Pair.create(Integer.valueOf(b2), Integer.valueOf(i2));
    }

    public static Pair<Integer, Integer> a(byte[] bArr) {
        return a(new l(bArr), false);
    }

    private static void a(l lVar, int i2, int i3) {
        lVar.b(1);
        if (lVar.e()) {
            lVar.b(14);
        }
        boolean e2 = lVar.e();
        if (i3 == 0) {
            throw new UnsupportedOperationException();
        }
        if (i2 == 6 || i2 == 20) {
            lVar.b(3);
        }
        if (e2) {
            if (i2 == 22) {
                lVar.b(16);
            }
            if (i2 == 17 || i2 == 19 || i2 == 20 || i2 == 23) {
                lVar.b(3);
            }
            lVar.b(1);
        }
    }

    public static byte[] a(int i2, int i3, int i4) {
        return new byte[]{(byte) (((i2 << 3) & 248) | ((i3 >> 1) & 7)), (byte) (((i3 << 7) & 128) | ((i4 << 3) & 120))};
    }

    public static byte[] a(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = f19009a;
        byte[] bArr3 = new byte[bArr2.length + i3];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i2, bArr3, bArr2.length, i3);
        return bArr3;
    }

    private static int b(l lVar) {
        int c2 = lVar.c(4);
        if (c2 == 15) {
            return lVar.c(24);
        }
        a.a(c2 < 13);
        return f19010b[c2];
    }
}

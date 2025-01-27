package e5;

import java.util.Arrays;
import javax.annotation.CheckForNull;
import kotlin.UShort;

@m
@a5.c
/* loaded from: classes2.dex */
public final class j {

    /* renamed from: a */
    public static final byte f25611a = 0;

    /* renamed from: b */
    public static final int f25612b = 5;

    /* renamed from: c */
    public static final int f25613c = 32;

    /* renamed from: d */
    public static final int f25614d = 31;

    /* renamed from: e */
    public static final int f25615e = 1073741823;

    /* renamed from: f */
    public static final int f25616f = 3;

    /* renamed from: g */
    public static final int f25617g = 4;

    /* renamed from: h */
    public static final int f25618h = 256;

    /* renamed from: i */
    public static final int f25619i = 255;

    /* renamed from: j */
    public static final int f25620j = 65536;

    /* renamed from: k */
    public static final int f25621k = 65535;

    public static Object a(int i10) {
        if (i10 >= 2 && i10 <= 1073741824 && Integer.highestOneBit(i10) == i10) {
            return i10 <= 256 ? new byte[i10] : i10 <= 65536 ? new short[i10] : new int[i10];
        }
        StringBuilder sb2 = new StringBuilder(52);
        sb2.append("must be power of 2 between 2^1 and 2^30: ");
        sb2.append(i10);
        throw new IllegalArgumentException(sb2.toString());
    }

    public static int b(int i10, int i11) {
        return i10 & (~i11);
    }

    public static int c(int i10, int i11) {
        return i10 & i11;
    }

    public static int d(int i10, int i11, int i12) {
        return (i10 & (~i12)) | (i11 & i12);
    }

    public static int e(int i10) {
        return (i10 < 32 ? 4 : 2) * (i10 + 1);
    }

    public static int f(@CheckForNull Object obj, @CheckForNull Object obj2, int i10, Object obj3, int[] iArr, Object[] objArr, @CheckForNull Object[] objArr2) {
        int i11;
        int i12;
        int d10 = s0.d(obj);
        int i13 = d10 & i10;
        int h10 = h(obj3, i13);
        if (h10 == 0) {
            return -1;
        }
        int b10 = b(d10, i10);
        int i14 = -1;
        while (true) {
            i11 = h10 - 1;
            i12 = iArr[i11];
            if (b(i12, i10) != b10 || !b5.r.a(obj, objArr[i11]) || (objArr2 != null && !b5.r.a(obj2, objArr2[i11]))) {
                int c10 = c(i12, i10);
                if (c10 == 0) {
                    return -1;
                }
                i14 = i11;
                h10 = c10;
            }
        }
        int c11 = c(i12, i10);
        if (i14 == -1) {
            i(obj3, i13, c11);
        } else {
            iArr[i14] = d(iArr[i14], c11, i10);
        }
        return i11;
    }

    public static void g(Object obj) {
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
    }

    public static int h(Object obj, int i10) {
        return obj instanceof byte[] ? ((byte[]) obj)[i10] & 255 : obj instanceof short[] ? ((short[]) obj)[i10] & UShort.MAX_VALUE : ((int[]) obj)[i10];
    }

    public static void i(Object obj, int i10, int i11) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i10] = (byte) i11;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i10] = (short) i11;
        } else {
            ((int[]) obj)[i10] = i11;
        }
    }

    public static int j(int i10) {
        return Math.max(4, s0.a(i10 + 1, 1.0d));
    }
}

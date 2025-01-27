package e5;

import javax.annotation.CheckForNull;

@a5.b
@m
/* loaded from: classes2.dex */
public final class s0 {

    /* renamed from: a */
    public static final long f25633a = -862048943;

    /* renamed from: b */
    public static final long f25634b = 461845907;

    /* renamed from: c */
    public static final int f25635c = 1073741824;

    public static int a(int i10, double d10) {
        int max = Math.max(i10, 2);
        int highestOneBit = Integer.highestOneBit(max);
        if (max <= ((int) (d10 * highestOneBit))) {
            return highestOneBit;
        }
        int i11 = highestOneBit << 1;
        if (i11 > 0) {
            return i11;
        }
        return 1073741824;
    }

    public static boolean b(int i10, int i11, double d10) {
        return ((double) i10) > d10 * ((double) i11) && i11 < 1073741824;
    }

    public static int c(int i10) {
        return (int) (Integer.rotateLeft((int) (i10 * f25633a), 15) * f25634b);
    }

    public static int d(@CheckForNull Object obj) {
        return c(obj == null ? 0 : obj.hashCode());
    }
}

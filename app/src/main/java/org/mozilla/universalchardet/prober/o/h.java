package org.mozilla.universalchardet.prober.o;

/* loaded from: classes5.dex */
public class h extends g {
    public static final int l = 129;
    public static final int m = 159;
    public static final int n = 224;
    public static final int o = 239;
    public static final int p = 64;
    public static final int q = 128;

    @Override // org.mozilla.universalchardet.prober.o.b
    protected int b(byte[] bArr, int i2) {
        int i3;
        int i4 = bArr[i2] & 255;
        if (i4 >= 129 && i4 <= 159) {
            i3 = i4 - 129;
        } else {
            if (i4 < 224 || i4 > 239) {
                return -1;
            }
            i3 = (i4 - 224) + 31;
        }
        int i5 = i3 * 188;
        int i6 = bArr[i2 + 1] & 255;
        int i7 = i5 + (i6 - 64);
        return i6 >= 128 ? i7 - 1 : i7;
    }
}

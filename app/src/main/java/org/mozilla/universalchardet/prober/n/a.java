package org.mozilla.universalchardet.prober.n;

import org.mozilla.universalchardet.prober.n.b;

/* loaded from: classes5.dex */
public class a extends b {
    public static final int m = 164;
    public static final int n = 161;
    public static final int o = 243;
    public static final int p = 142;
    public static final int q = 143;
    public static final int r = 161;
    public static final int s = 254;

    @Override // org.mozilla.universalchardet.prober.n.b
    protected int b(byte[] bArr, int i2) {
        int i3;
        if ((bArr[i2] & 255) != 164 || (i3 = bArr[i2 + 1] & 255) < 161 || i3 > 243) {
            return -1;
        }
        return i3 - 161;
    }

    @Override // org.mozilla.universalchardet.prober.n.b
    protected void c(b.a aVar, byte[] bArr, int i2) {
        int i3;
        aVar.f35460a = -1;
        aVar.f35461b = 1;
        int i4 = bArr[i2] & 255;
        if (i4 == 142 || (i4 >= 161 && i4 <= 254)) {
            aVar.f35461b = 2;
        } else if (i4 == 143) {
            aVar.f35461b = 3;
        }
        if (i4 != 164 || (i3 = bArr[i2 + 1] & 255) < 161 || i3 > 243) {
            return;
        }
        aVar.f35460a = i3 - 161;
    }
}

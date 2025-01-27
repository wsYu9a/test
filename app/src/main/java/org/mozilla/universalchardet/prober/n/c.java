package org.mozilla.universalchardet.prober.n;

import org.mozilla.universalchardet.prober.n.b;

/* loaded from: classes5.dex */
public class c extends b {
    public static final int m = 130;
    public static final int n = 159;
    public static final int o = 241;
    public static final int p = 129;
    public static final int q = 159;
    public static final int r = 224;
    public static final int s = 239;

    @Override // org.mozilla.universalchardet.prober.n.b
    protected int b(byte[] bArr, int i2) {
        int i3;
        if ((bArr[i2] & 255) != 130 || (i3 = bArr[i2 + 1] & 255) < 159 || i3 > 241) {
            return -1;
        }
        return i3 - 159;
    }

    @Override // org.mozilla.universalchardet.prober.n.b
    protected void c(b.a aVar, byte[] bArr, int i2) {
        int i3;
        aVar.f35460a = -1;
        aVar.f35461b = 1;
        int i4 = bArr[i2] & 255;
        if ((i4 >= 129 && i4 <= 159) || (i4 >= 224 && i4 <= 239)) {
            aVar.f35461b = 2;
        }
        if (i4 != 130 || (i3 = bArr[i2 + 1] & 255) < 159 || i3 > 241) {
            return;
        }
        aVar.f35460a = i3 - 159;
    }
}

package org.mozilla.universalchardet.prober.o;

/* loaded from: classes5.dex */
public class c extends g {
    public static final int l = 161;
    public static final int m = 254;
    public static final int n = 161;
    public static final int o = 254;

    @Override // org.mozilla.universalchardet.prober.o.b
    protected int b(byte[] bArr, int i2) {
        int i3 = bArr[i2] & 255;
        if (i3 < 161) {
            return -1;
        }
        return (((i3 - 161) * 94) + (bArr[i2 + 1] & 255)) - 161;
    }
}

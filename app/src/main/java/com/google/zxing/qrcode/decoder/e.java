package com.google.zxing.qrcode.decoder;

/* loaded from: classes.dex */
final class e {

    /* renamed from: a */
    private static final int f8755a = 21522;

    /* renamed from: b */
    private static final int[][] f8756b = {new int[]{f8755a, 0}, new int[]{20773, 1}, new int[]{24188, 2}, new int[]{23371, 3}, new int[]{17913, 4}, new int[]{16590, 5}, new int[]{20375, 6}, new int[]{19104, 7}, new int[]{30660, 8}, new int[]{29427, 9}, new int[]{32170, 10}, new int[]{30877, 11}, new int[]{26159, 12}, new int[]{25368, 13}, new int[]{27713, 14}, new int[]{26998, 15}, new int[]{5769, 16}, new int[]{5054, 17}, new int[]{7399, 18}, new int[]{6608, 19}, new int[]{1890, 20}, new int[]{597, 21}, new int[]{3340, 22}, new int[]{2107, 23}, new int[]{13663, 24}, new int[]{12392, 25}, new int[]{16177, 26}, new int[]{14854, 27}, new int[]{9396, 28}, new int[]{8579, 29}, new int[]{11994, 30}, new int[]{11245, 31}};

    /* renamed from: c */
    private final ErrorCorrectionLevel f8757c;

    /* renamed from: d */
    private final byte f8758d;

    private e(int i2) {
        this.f8757c = ErrorCorrectionLevel.forBits((i2 >> 3) & 3);
        this.f8758d = (byte) (i2 & 7);
    }

    static e a(int i2, int i3) {
        e b2 = b(i2, i3);
        return b2 != null ? b2 : b(i2 ^ f8755a, i3 ^ f8755a);
    }

    private static e b(int i2, int i3) {
        int e2;
        int i4 = Integer.MAX_VALUE;
        int i5 = 0;
        for (int[] iArr : f8756b) {
            int i6 = iArr[0];
            if (i6 == i2 || i6 == i3) {
                return new e(iArr[1]);
            }
            int e3 = e(i2, i6);
            if (e3 < i4) {
                i5 = iArr[1];
                i4 = e3;
            }
            if (i2 != i3 && (e2 = e(i3, i6)) < i4) {
                i5 = iArr[1];
                i4 = e2;
            }
        }
        if (i4 <= 3) {
            return new e(i5);
        }
        return null;
    }

    static int e(int i2, int i3) {
        return Integer.bitCount(i2 ^ i3);
    }

    byte c() {
        return this.f8758d;
    }

    ErrorCorrectionLevel d() {
        return this.f8757c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f8757c == eVar.f8757c && this.f8758d == eVar.f8758d;
    }

    public int hashCode() {
        return (this.f8757c.ordinal() << 3) | this.f8758d;
    }
}

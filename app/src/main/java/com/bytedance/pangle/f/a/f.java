package com.bytedance.pangle.f.a;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    int[] f6114a;

    /* renamed from: b, reason: collision with root package name */
    int[] f6115b;

    f() {
    }

    public final String a(int i2) {
        int[] iArr;
        if (i2 < 0 || (iArr = this.f6114a) == null || i2 >= iArr.length) {
            return null;
        }
        int i3 = iArr[i2];
        int a2 = a(this.f6115b, i3);
        StringBuilder sb = new StringBuilder(a2);
        while (a2 != 0) {
            i3 += 2;
            sb.append((char) a(this.f6115b, i3));
            a2--;
        }
        return sb.toString();
    }

    private static final int a(int[] iArr, int i2) {
        int i3 = iArr[i2 / 4];
        return (i2 % 4) / 2 == 0 ? i3 & 65535 : i3 >>> 16;
    }
}

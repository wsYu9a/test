package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: classes.dex */
abstract class i extends h {
    i(com.google.zxing.common.a aVar) {
        super(aVar);
    }

    protected abstract void h(StringBuilder sb, int i2);

    protected abstract int i(int i2);

    final void j(StringBuilder sb, int i2, int i3) {
        int f2 = b().f(i2, i3);
        h(sb, f2);
        int i4 = i(f2);
        int i5 = 100000;
        for (int i6 = 0; i6 < 5; i6++) {
            if (i4 / i5 == 0) {
                sb.append('0');
            }
            i5 /= 10;
        }
        sb.append(i4);
    }
}

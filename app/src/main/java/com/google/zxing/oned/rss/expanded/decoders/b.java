package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: classes.dex */
final class b extends f {
    b(com.google.zxing.common.a aVar) {
        super(aVar);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.i
    protected void h(StringBuilder sb, int i2) {
        if (i2 < 10000) {
            sb.append("(3202)");
        } else {
            sb.append("(3203)");
        }
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.i
    protected int i(int i2) {
        return i2 < 10000 ? i2 : i2 - 10000;
    }
}

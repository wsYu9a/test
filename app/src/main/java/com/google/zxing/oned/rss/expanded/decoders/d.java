package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;

/* loaded from: classes.dex */
final class d extends h {

    /* renamed from: d */
    private static final int f8596d = 8;

    /* renamed from: e */
    private static final int f8597e = 2;

    /* renamed from: f */
    private static final int f8598f = 10;

    d(com.google.zxing.common.a aVar) {
        super(aVar);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.j
    public String d() throws NotFoundException, FormatException {
        if (c().l() < 48) {
            throw NotFoundException.getNotFoundInstance();
        }
        StringBuilder sb = new StringBuilder();
        f(sb, 8);
        int f2 = b().f(48, 2);
        sb.append("(393");
        sb.append(f2);
        sb.append(')');
        int f3 = b().f(50, 10);
        if (f3 / 100 == 0) {
            sb.append('0');
        }
        if (f3 / 10 == 0) {
            sb.append('0');
        }
        sb.append(f3);
        sb.append(b().c(60, null).b());
        return sb.toString();
    }
}

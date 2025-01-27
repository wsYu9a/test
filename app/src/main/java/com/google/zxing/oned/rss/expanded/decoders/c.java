package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;

/* loaded from: classes.dex */
final class c extends h {

    /* renamed from: d */
    private static final int f8594d = 8;

    /* renamed from: e */
    private static final int f8595e = 2;

    c(com.google.zxing.common.a aVar) {
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
        sb.append("(392");
        sb.append(f2);
        sb.append(')');
        sb.append(b().c(50, null).b());
        return sb.toString();
    }
}

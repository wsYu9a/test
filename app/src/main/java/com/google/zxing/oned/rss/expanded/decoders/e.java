package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.NotFoundException;

/* loaded from: classes.dex */
final class e extends i {

    /* renamed from: d */
    private static final int f8599d = 8;

    /* renamed from: e */
    private static final int f8600e = 20;

    /* renamed from: f */
    private static final int f8601f = 16;

    /* renamed from: g */
    private final String f8602g;

    /* renamed from: h */
    private final String f8603h;

    e(com.google.zxing.common.a aVar, String str, String str2) {
        super(aVar);
        this.f8602g = str2;
        this.f8603h = str;
    }

    private void k(StringBuilder sb, int i2) {
        int f2 = b().f(i2, 16);
        if (f2 == 38400) {
            return;
        }
        sb.append('(');
        sb.append(this.f8602g);
        sb.append(')');
        int i3 = f2 % 32;
        int i4 = f2 / 32;
        int i5 = (i4 % 12) + 1;
        int i6 = i4 / 12;
        if (i6 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i6);
        if (i5 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i5);
        if (i3 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i3);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.j
    public String d() throws NotFoundException {
        if (c().l() != 84) {
            throw NotFoundException.getNotFoundInstance();
        }
        StringBuilder sb = new StringBuilder();
        f(sb, 8);
        j(sb, 48, 20);
        k(sb, 68);
        return sb.toString();
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.i
    protected void h(StringBuilder sb, int i2) {
        sb.append('(');
        sb.append(this.f8603h);
        sb.append(i2 / 100000);
        sb.append(')');
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.i
    protected int i(int i2) {
        return i2 % 100000;
    }
}

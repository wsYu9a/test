package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import java.util.Map;

/* loaded from: classes.dex */
public final class s extends x {
    private final x k = new h();

    private static com.google.zxing.k r(com.google.zxing.k kVar) throws FormatException {
        String g2 = kVar.g();
        if (g2.charAt(0) == '0') {
            return new com.google.zxing.k(g2.substring(1), null, kVar.f(), BarcodeFormat.UPC_A);
        }
        throw FormatException.getFormatInstance();
    }

    @Override // com.google.zxing.oned.q, com.google.zxing.j
    public com.google.zxing.k a(com.google.zxing.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        return r(this.k.a(bVar, map));
    }

    @Override // com.google.zxing.oned.x, com.google.zxing.oned.q
    public com.google.zxing.k b(int i2, com.google.zxing.common.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException, ChecksumException {
        return r(this.k.b(i2, aVar, map));
    }

    @Override // com.google.zxing.oned.q, com.google.zxing.j
    public com.google.zxing.k c(com.google.zxing.b bVar) throws NotFoundException, FormatException {
        return r(this.k.c(bVar));
    }

    @Override // com.google.zxing.oned.x
    protected int l(com.google.zxing.common.a aVar, int[] iArr, StringBuilder sb) throws NotFoundException {
        return this.k.l(aVar, iArr, sb);
    }

    @Override // com.google.zxing.oned.x
    public com.google.zxing.k m(int i2, com.google.zxing.common.a aVar, int[] iArr, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException, ChecksumException {
        return r(this.k.m(i2, aVar, iArr, map));
    }

    @Override // com.google.zxing.oned.x
    BarcodeFormat q() {
        return BarcodeFormat.UPC_A;
    }
}

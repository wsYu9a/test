package com.google.zxing.s;

import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.j;
import com.google.zxing.k;
import com.google.zxing.l;
import java.util.Map;

/* loaded from: classes.dex */
public final class a implements j {

    /* renamed from: a */
    private final j f8815a;

    public a(j jVar) {
        this.f8815a = jVar;
    }

    private static void b(l[] lVarArr, int i2, int i3) {
        if (lVarArr != null) {
            for (int i4 = 0; i4 < lVarArr.length; i4++) {
                l lVar = lVarArr[i4];
                lVarArr[i4] = new l(lVar.c() + i2, lVar.d() + i3);
            }
        }
    }

    @Override // com.google.zxing.j
    public k a(com.google.zxing.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int e2 = bVar.e() / 2;
        int d2 = bVar.d() / 2;
        try {
            try {
                try {
                    try {
                        return this.f8815a.a(bVar.a(0, 0, e2, d2), map);
                    } catch (NotFoundException unused) {
                        k a2 = this.f8815a.a(bVar.a(e2, 0, e2, d2), map);
                        b(a2.f(), e2, 0);
                        return a2;
                    }
                } catch (NotFoundException unused2) {
                    k a3 = this.f8815a.a(bVar.a(0, d2, e2, d2), map);
                    b(a3.f(), 0, d2);
                    return a3;
                }
            } catch (NotFoundException unused3) {
                k a4 = this.f8815a.a(bVar.a(e2, d2, e2, d2), map);
                b(a4.f(), e2, d2);
                return a4;
            }
        } catch (NotFoundException unused4) {
            int i2 = e2 / 2;
            int i3 = d2 / 2;
            k a5 = this.f8815a.a(bVar.a(i2, i3, e2, d2), map);
            b(a5.f(), i2, i3);
            return a5;
        }
    }

    @Override // com.google.zxing.j
    public k c(com.google.zxing.b bVar) throws NotFoundException, ChecksumException, FormatException {
        return a(bVar, null);
    }

    @Override // com.google.zxing.j
    public void reset() {
        this.f8815a.reset();
    }
}

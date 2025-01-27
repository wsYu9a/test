package h6;

import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import java.util.Map;
import t5.j;
import t5.k;
import t5.l;

/* loaded from: classes2.dex */
public final class a implements j {

    /* renamed from: a */
    public final j f26499a;

    public a(j jVar) {
        this.f26499a = jVar;
    }

    public static void c(l[] lVarArr, int i10, int i11) {
        if (lVarArr != null) {
            for (int i12 = 0; i12 < lVarArr.length; i12++) {
                l lVar = lVarArr[i12];
                lVarArr[i12] = new l(lVar.c() + i10, lVar.d() + i11);
            }
        }
    }

    @Override // t5.j
    public k a(t5.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int e10 = bVar.e() / 2;
        int d10 = bVar.d() / 2;
        try {
            try {
                try {
                    try {
                        return this.f26499a.a(bVar.a(0, 0, e10, d10), map);
                    } catch (NotFoundException unused) {
                        k a10 = this.f26499a.a(bVar.a(e10, 0, e10, d10), map);
                        c(a10.f(), e10, 0);
                        return a10;
                    }
                } catch (NotFoundException unused2) {
                    k a11 = this.f26499a.a(bVar.a(0, d10, e10, d10), map);
                    c(a11.f(), 0, d10);
                    return a11;
                }
            } catch (NotFoundException unused3) {
                k a12 = this.f26499a.a(bVar.a(e10, d10, e10, d10), map);
                c(a12.f(), e10, d10);
                return a12;
            }
        } catch (NotFoundException unused4) {
            int i10 = e10 / 2;
            int i11 = d10 / 2;
            k a13 = this.f26499a.a(bVar.a(i10, i11, e10, d10), map);
            c(a13.f(), i10, i11);
            return a13;
        }
    }

    @Override // t5.j
    public k b(t5.b bVar) throws NotFoundException, ChecksumException, FormatException {
        return a(bVar, null);
    }

    @Override // t5.j
    public void reset() {
        this.f26499a.reset();
    }
}

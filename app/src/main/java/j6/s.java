package j6;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import java.util.Map;

/* loaded from: classes2.dex */
public final class s extends x {

    /* renamed from: k */
    public final x f27228k = new h();

    public static t5.k r(t5.k kVar) throws FormatException {
        String g10 = kVar.g();
        if (g10.charAt(0) == '0') {
            return new t5.k(g10.substring(1), null, kVar.f(), BarcodeFormat.UPC_A);
        }
        throw FormatException.getFormatInstance();
    }

    @Override // j6.q, t5.j
    public t5.k a(t5.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        return r(this.f27228k.a(bVar, map));
    }

    @Override // j6.q, t5.j
    public t5.k b(t5.b bVar) throws NotFoundException, FormatException {
        return r(this.f27228k.b(bVar));
    }

    @Override // j6.x, j6.q
    public t5.k c(int i10, z5.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException, ChecksumException {
        return r(this.f27228k.c(i10, aVar, map));
    }

    @Override // j6.x
    public int l(z5.a aVar, int[] iArr, StringBuilder sb2) throws NotFoundException {
        return this.f27228k.l(aVar, iArr, sb2);
    }

    @Override // j6.x
    public t5.k m(int i10, z5.a aVar, int[] iArr, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException, ChecksumException {
        return r(this.f27228k.m(i10, aVar, iArr, map));
    }

    @Override // j6.x
    public BarcodeFormat q() {
        return BarcodeFormat.UPC_A;
    }
}

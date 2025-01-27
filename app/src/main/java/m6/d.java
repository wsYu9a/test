package m6;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;

/* loaded from: classes2.dex */
public final class d extends h {

    /* renamed from: d */
    public static final int f28493d = 8;

    /* renamed from: e */
    public static final int f28494e = 2;

    /* renamed from: f */
    public static final int f28495f = 10;

    public d(z5.a aVar) {
        super(aVar);
    }

    @Override // m6.j
    public String d() throws NotFoundException, FormatException {
        if (c().l() < 48) {
            throw NotFoundException.getNotFoundInstance();
        }
        StringBuilder sb2 = new StringBuilder();
        f(sb2, 8);
        int f10 = b().f(48, 2);
        sb2.append("(393");
        sb2.append(f10);
        sb2.append(')');
        int f11 = b().f(50, 10);
        if (f11 / 100 == 0) {
            sb2.append('0');
        }
        if (f11 / 10 == 0) {
            sb2.append('0');
        }
        sb2.append(f11);
        sb2.append(b().c(60, null).b());
        return sb2.toString();
    }
}

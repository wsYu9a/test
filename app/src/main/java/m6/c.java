package m6;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;

/* loaded from: classes2.dex */
public final class c extends h {

    /* renamed from: d */
    public static final int f28491d = 8;

    /* renamed from: e */
    public static final int f28492e = 2;

    public c(z5.a aVar) {
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
        sb2.append("(392");
        sb2.append(f10);
        sb2.append(')');
        sb2.append(b().c(50, null).b());
        return sb2.toString();
    }
}

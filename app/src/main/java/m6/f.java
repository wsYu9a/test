package m6;

import com.google.zxing.NotFoundException;

/* loaded from: classes2.dex */
public abstract class f extends i {

    /* renamed from: d */
    public static final int f28501d = 5;

    /* renamed from: e */
    public static final int f28502e = 15;

    public f(z5.a aVar) {
        super(aVar);
    }

    @Override // m6.j
    public String d() throws NotFoundException {
        if (c().l() != 60) {
            throw NotFoundException.getNotFoundInstance();
        }
        StringBuilder sb2 = new StringBuilder();
        f(sb2, 5);
        j(sb2, 45, 15);
        return sb2.toString();
    }
}

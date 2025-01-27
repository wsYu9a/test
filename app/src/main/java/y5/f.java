package y5;

/* loaded from: classes2.dex */
public final class f extends a {
    @Override // y5.t
    /* renamed from: s */
    public b0 k(t5.k kVar) {
        String g10 = kVar.g();
        if (!g10.startsWith("MEBKM:")) {
            return null;
        }
        String r10 = a.r("TITLE:", g10, true);
        String[] q10 = a.q("URL:", g10, true);
        if (q10 == null) {
            return null;
        }
        String str = q10[0];
        if (c0.q(str)) {
            return new b0(str, r10);
        }
        return null;
    }
}

package y5;

/* loaded from: classes2.dex */
public final class d0 extends t {
    @Override // y5.t
    /* renamed from: q */
    public b0 k(t5.k kVar) {
        int indexOf;
        String c10 = t.c(kVar);
        if ((c10.startsWith("urlto:") || c10.startsWith("URLTO:")) && (indexOf = c10.indexOf(58, 6)) >= 0) {
            return new b0(c10.substring(indexOf + 1), indexOf > 6 ? c10.substring(6, indexOf) : null);
        }
        return null;
    }
}

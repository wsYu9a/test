package y5;

/* loaded from: classes2.dex */
public final class z extends t {
    @Override // y5.t
    /* renamed from: q */
    public y k(t5.k kVar) {
        String str;
        String c10 = t.c(kVar);
        if (!c10.startsWith("tel:") && !c10.startsWith("TEL:")) {
            return null;
        }
        if (c10.startsWith("TEL:")) {
            str = "tel:" + c10.substring(4);
        } else {
            str = c10;
        }
        int indexOf = c10.indexOf(63, 4);
        return new y(indexOf < 0 ? c10.substring(4) : c10.substring(4, indexOf), str, null);
    }
}

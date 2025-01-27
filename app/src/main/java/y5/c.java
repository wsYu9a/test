package y5;

/* loaded from: classes2.dex */
public final class c extends a {
    public static String t(String str) {
        int indexOf = str.indexOf(44);
        if (indexOf < 0) {
            return str;
        }
        return str.substring(indexOf + 1) + b5.a.O + str.substring(0, indexOf);
    }

    @Override // y5.t
    /* renamed from: s */
    public d k(t5.k kVar) {
        String[] q10;
        String c10 = t.c(kVar);
        if (!c10.startsWith("MECARD:") || (q10 = a.q("N:", c10, true)) == null) {
            return null;
        }
        String t10 = t(q10[0]);
        String r10 = a.r("SOUND:", c10, true);
        String[] q11 = a.q("TEL:", c10, true);
        String[] q12 = a.q("EMAIL:", c10, true);
        String r11 = a.r("NOTE:", c10, false);
        String[] q13 = a.q("ADR:", c10, true);
        String r12 = a.r("BDAY:", c10, true);
        return new d(t.j(t10), null, r10, q11, null, q12, null, null, r11, q13, null, a.r("ORG:", c10, true), !t.d(r12, 8) ? null : r12, null, a.q("URL:", c10, true), null);
    }
}

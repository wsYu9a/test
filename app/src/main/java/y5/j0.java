package y5;

/* loaded from: classes2.dex */
public final class j0 extends t {
    @Override // y5.t
    /* renamed from: q */
    public i0 k(t5.k kVar) {
        String g10;
        String c10 = t.c(kVar);
        if (!c10.startsWith("WIFI:") || (g10 = t.g("S:", c10, ';', false)) == null || g10.isEmpty()) {
            return null;
        }
        String g11 = t.g("P:", c10, ';', false);
        String g12 = t.g("T:", c10, ';', false);
        if (g12 == null) {
            g12 = "nopass";
        }
        return new i0(g12, g10, g11, Boolean.parseBoolean(t.g("H:", c10, ';', false)));
    }
}

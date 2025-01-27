package y5;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class b extends t {
    public static String[] q(String str, int i10, String str2, boolean z10) {
        ArrayList arrayList = null;
        for (int i11 = 1; i11 <= i10; i11++) {
            String g10 = t.g(str + i11 + m5.d.f28378d, str2, '\r', z10);
            if (g10 == null) {
                break;
            }
            if (arrayList == null) {
                arrayList = new ArrayList(i10);
            }
            arrayList.add(g10);
        }
        if (arrayList == null) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    @Override // y5.t
    /* renamed from: r */
    public d k(t5.k kVar) {
        String c10 = t.c(kVar);
        if (!c10.contains("MEMORY") || !c10.contains("\r\n")) {
            return null;
        }
        String g10 = t.g("NAME1:", c10, '\r', true);
        String g11 = t.g("NAME2:", c10, '\r', true);
        String[] q10 = q("TEL", 3, c10, true);
        String[] q11 = q("MAIL", 3, c10, true);
        String g12 = t.g("MEMORY:", c10, '\r', false);
        String g13 = t.g("ADD:", c10, '\r', true);
        return new d(t.j(g10), null, g11, q10, null, q11, null, null, g12, g13 != null ? new String[]{g13} : null, null, null, null, null, null, null);
    }
}

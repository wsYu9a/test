package y5;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class e extends a {
    public static String s(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        return str + b5.a.O + str2;
    }

    public static String[] t(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList(3);
        if (str != null) {
            arrayList.add(str);
        }
        if (str2 != null) {
            arrayList.add(str2);
        }
        if (str3 != null) {
            arrayList.add(str3);
        }
        int size = arrayList.size();
        if (size == 0) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[size]);
    }

    @Override // y5.t
    /* renamed from: u */
    public d k(t5.k kVar) {
        String c10 = t.c(kVar);
        if (!c10.startsWith("BIZCARD:")) {
            return null;
        }
        String s10 = s(a.r("N:", c10, true), a.r("X:", c10, true));
        String r10 = a.r("T:", c10, true);
        String r11 = a.r("C:", c10, true);
        return new d(t.j(s10), null, null, t(a.r("B:", c10, true), a.r("M:", c10, true), a.r("F:", c10, true)), null, t.j(a.r("E:", c10, true)), null, null, null, a.q("A:", c10, true), null, r11, null, r10, null, null);
    }
}

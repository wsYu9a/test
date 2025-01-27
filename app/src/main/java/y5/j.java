package y5;

import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class j extends a {

    /* renamed from: f */
    public static final Pattern f33025f = Pattern.compile("[a-zA-Z0-9@.!#$%&'*+\\-/=?^_`{|}~]+");

    public static boolean s(String str) {
        return str != null && f33025f.matcher(str).matches() && str.indexOf(64) >= 0;
    }

    @Override // y5.t
    /* renamed from: t */
    public h k(t5.k kVar) {
        String[] q10;
        String c10 = t.c(kVar);
        if (!c10.startsWith("MATMSG:") || (q10 = a.q("TO:", c10, true)) == null) {
            return null;
        }
        for (String str : q10) {
            if (!s(str)) {
                return null;
            }
        }
        return new h(q10, null, null, a.r("SUB:", c10, false), a.r("BODY:", c10, false));
    }
}

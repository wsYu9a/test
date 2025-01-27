package y5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class c0 extends t {

    /* renamed from: f */
    public static final Pattern f32962f = Pattern.compile("[a-zA-Z][a-zA-Z0-9+-.]+:");

    /* renamed from: g */
    public static final Pattern f32963g = Pattern.compile("([a-zA-Z0-9\\-]+\\.){1,6}[a-zA-Z]{2,}(:\\d{1,5})?(/|\\?|$)");

    public static boolean q(String str) {
        if (str.contains(" ")) {
            return false;
        }
        Matcher matcher = f32962f.matcher(str);
        if (matcher.find() && matcher.start() == 0) {
            return true;
        }
        Matcher matcher2 = f32963g.matcher(str);
        return matcher2.find() && matcher2.start() == 0;
    }

    @Override // y5.t
    /* renamed from: r */
    public b0 k(t5.k kVar) {
        String c10 = t.c(kVar);
        if (c10.startsWith("URL:") || c10.startsWith("URI:")) {
            return new b0(c10.substring(4).trim(), null);
        }
        String trim = c10.trim();
        if (q(trim)) {
            return new b0(trim, null);
        }
        return null;
    }
}

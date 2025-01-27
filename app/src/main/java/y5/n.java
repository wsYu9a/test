package y5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class n extends t {

    /* renamed from: f */
    public static final Pattern f33047f = Pattern.compile("geo:([\\-0-9.]+),([\\-0-9.]+)(?:,([\\-0-9.]+))?(?:\\?(.*))?", 2);

    @Override // y5.t
    /* renamed from: q */
    public m k(t5.k kVar) {
        Matcher matcher = f33047f.matcher(t.c(kVar));
        if (!matcher.matches()) {
            return null;
        }
        String group = matcher.group(4);
        try {
            double parseDouble = Double.parseDouble(matcher.group(1));
            if (parseDouble <= 90.0d && parseDouble >= -90.0d) {
                double parseDouble2 = Double.parseDouble(matcher.group(2));
                if (parseDouble2 <= 180.0d && parseDouble2 >= -180.0d) {
                    String group2 = matcher.group(3);
                    double d10 = l5.c.f27899e;
                    if (group2 != null) {
                        double parseDouble3 = Double.parseDouble(matcher.group(3));
                        if (parseDouble3 < l5.c.f27899e) {
                            return null;
                        }
                        d10 = parseDouble3;
                    }
                    return new m(parseDouble, parseDouble2, d10, group);
                }
            }
        } catch (NumberFormatException unused) {
        }
        return null;
    }
}

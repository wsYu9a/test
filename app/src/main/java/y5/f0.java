package y5;

import androidx.core.net.MailTo;
import java.util.List;

/* loaded from: classes2.dex */
public final class f0 extends t {
    public static String q(CharSequence charSequence, String str, boolean z10) {
        List<String> t10 = e0.t(charSequence, str, z10, false);
        if (t10 == null || t10.isEmpty()) {
            return null;
        }
        return t10.get(0);
    }

    public static String[] r(CharSequence charSequence, String str, boolean z10) {
        List<List<String>> u10 = e0.u(charSequence, str, z10, false);
        if (u10 == null || u10.isEmpty()) {
            return null;
        }
        int size = u10.size();
        String[] strArr = new String[size];
        for (int i10 = 0; i10 < size; i10++) {
            strArr[i10] = u10.get(i10).get(0);
        }
        return strArr;
    }

    public static String t(String str) {
        return str != null ? (str.startsWith(MailTo.MAILTO_SCHEME) || str.startsWith("MAILTO:")) ? str.substring(7) : str : str;
    }

    @Override // y5.t
    /* renamed from: s */
    public g k(t5.k kVar) {
        double parseDouble;
        double parseDouble2;
        String c10 = t.c(kVar);
        if (c10.indexOf("BEGIN:VEVENT") < 0) {
            return null;
        }
        String q10 = q("SUMMARY", c10, true);
        String q11 = q("DTSTART", c10, true);
        if (q11 == null) {
            return null;
        }
        String q12 = q("DTEND", c10, true);
        String q13 = q("DURATION", c10, true);
        String q14 = q("LOCATION", c10, true);
        String t10 = t(q("ORGANIZER", c10, true));
        String[] r10 = r("ATTENDEE", c10, true);
        if (r10 != null) {
            for (int i10 = 0; i10 < r10.length; i10++) {
                r10[i10] = t(r10[i10]);
            }
        }
        String q15 = q("DESCRIPTION", c10, true);
        String q16 = q("GEO", c10, true);
        if (q16 == null) {
            parseDouble = Double.NaN;
            parseDouble2 = Double.NaN;
        } else {
            int indexOf = q16.indexOf(59);
            if (indexOf < 0) {
                return null;
            }
            try {
                parseDouble = Double.parseDouble(q16.substring(0, indexOf));
                parseDouble2 = Double.parseDouble(q16.substring(indexOf + 1));
            } catch (NumberFormatException | IllegalArgumentException unused) {
                return null;
            }
        }
        return new g(q10, q11, q12, q13, q14, t10, r10, q15, parseDouble, parseDouble2);
    }
}

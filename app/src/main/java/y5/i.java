package y5;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.net.MailTo;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class i extends t {

    /* renamed from: f */
    public static final Pattern f33020f = Pattern.compile(",");

    @Override // y5.t
    /* renamed from: q */
    public h k(t5.k kVar) {
        String[] strArr;
        String[] strArr2;
        String[] strArr3;
        String str;
        String str2;
        String str3;
        String c10 = t.c(kVar);
        if (!c10.startsWith(MailTo.MAILTO_SCHEME) && !c10.startsWith("MAILTO:")) {
            if (j.s(c10)) {
                return new h(c10);
            }
            return null;
        }
        String substring = c10.substring(7);
        int indexOf = substring.indexOf(63);
        if (indexOf >= 0) {
            substring = substring.substring(0, indexOf);
        }
        try {
            String p10 = t.p(substring);
            String[] split = !p10.isEmpty() ? f33020f.split(p10) : null;
            Map<String, String> m10 = t.m(c10);
            if (m10 != null) {
                if (split == null && (str3 = m10.get(TypedValues.TransitionType.S_TO)) != null) {
                    split = f33020f.split(str3);
                }
                String str4 = m10.get(com.umeng.ccg.a.f24224a);
                String[] split2 = str4 != null ? f33020f.split(str4) : null;
                String str5 = m10.get("bcc");
                String[] split3 = str5 != null ? f33020f.split(str5) : null;
                String str6 = m10.get("subject");
                str2 = m10.get("body");
                strArr = split;
                strArr3 = split3;
                strArr2 = split2;
                str = str6;
            } else {
                strArr = split;
                strArr2 = null;
                strArr3 = null;
                str = null;
                str2 = null;
            }
            return new h(strArr, strArr2, strArr3, str, str2);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}

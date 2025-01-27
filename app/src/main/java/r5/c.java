package r5;

import f5.h;
import f5.i;
import kotlin.text.Typography;
import okio.Utf8;

@a5.b
@a
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a */
    public static final char f30309a = 0;

    /* renamed from: b */
    public static final char f30310b = 31;

    /* renamed from: c */
    public static final h f30311c;

    /* renamed from: d */
    public static final h f30312d;

    /* renamed from: e */
    public static final h f30313e;

    static {
        i.c b10 = i.b();
        b10.d((char) 0, Utf8.REPLACEMENT_CHARACTER);
        b10.e("�");
        for (char c10 = 0; c10 <= 31; c10 = (char) (c10 + 1)) {
            if (c10 != '\t' && c10 != '\n' && c10 != '\r') {
                b10.b(c10, "�");
            }
        }
        b10.b(Typography.amp, "&amp;");
        b10.b(Typography.less, "&lt;");
        b10.b(Typography.greater, "&gt;");
        f30312d = b10.c();
        b10.b('\'', "&apos;");
        b10.b(Typography.quote, "&quot;");
        f30311c = b10.c();
        b10.b('\t', "&#x9;");
        b10.b('\n', "&#xA;");
        b10.b('\r', "&#xD;");
        f30313e = b10.c();
    }

    public static h a() {
        return f30313e;
    }

    public static h b() {
        return f30312d;
    }
}

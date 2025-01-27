package y5;

import com.google.zxing.client.result.ParsedResultType;

/* loaded from: classes2.dex */
public abstract class q {

    /* renamed from: a */
    public final ParsedResultType f33049a;

    public q(ParsedResultType parsedResultType) {
        this.f33049a = parsedResultType;
    }

    public static void b(String str, StringBuilder sb2) {
        if (str == null || str.isEmpty()) {
            return;
        }
        if (sb2.length() > 0) {
            sb2.append('\n');
        }
        sb2.append(str);
    }

    public static void c(String[] strArr, StringBuilder sb2) {
        if (strArr != null) {
            for (String str : strArr) {
                b(str, sb2);
            }
        }
    }

    public abstract String a();

    public final ParsedResultType getType() {
        return this.f33049a;
    }

    public final String toString() {
        return a();
    }
}

package com.google.zxing.client.result;

/* loaded from: classes.dex */
public abstract class q {

    /* renamed from: a */
    private final ParsedResultType f8271a;

    protected q(ParsedResultType parsedResultType) {
        this.f8271a = parsedResultType;
    }

    public static void b(String str, StringBuilder sb) {
        if (str == null || str.isEmpty()) {
            return;
        }
        if (sb.length() > 0) {
            sb.append('\n');
        }
        sb.append(str);
    }

    public static void c(String[] strArr, StringBuilder sb) {
        if (strArr != null) {
            for (String str : strArr) {
                b(str, sb);
            }
        }
    }

    public abstract String a();

    public final ParsedResultType getType() {
        return this.f8271a;
    }

    public final String toString() {
        return a();
    }
}

package com.google.zxing.client.result;

import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class b0 extends q {

    /* renamed from: b */
    private static final Pattern f8206b = Pattern.compile(":/*([^/@]+)@[^/]+");

    /* renamed from: c */
    private final String f8207c;

    /* renamed from: d */
    private final String f8208d;

    public b0(String str, String str2) {
        super(ParsedResultType.URI);
        this.f8207c = h(str);
        this.f8208d = str2;
    }

    private static boolean f(String str, int i2) {
        int i3 = i2 + 1;
        int indexOf = str.indexOf(47, i3);
        if (indexOf < 0) {
            indexOf = str.length();
        }
        return t.e(str, i3, indexOf - i3);
    }

    private static String h(String str) {
        String trim = str.trim();
        int indexOf = trim.indexOf(58);
        if (indexOf >= 0 && !f(trim, indexOf)) {
            return trim;
        }
        return "http://" + trim;
    }

    @Override // com.google.zxing.client.result.q
    public String a() {
        StringBuilder sb = new StringBuilder(30);
        q.b(this.f8208d, sb);
        q.b(this.f8207c, sb);
        return sb.toString();
    }

    public String d() {
        return this.f8208d;
    }

    public String e() {
        return this.f8207c;
    }

    public boolean g() {
        return f8206b.matcher(this.f8207c).find();
    }
}

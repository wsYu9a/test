package com.google.zxing.client.result;

/* loaded from: classes.dex */
public final class y extends q {

    /* renamed from: b */
    private final String f8283b;

    /* renamed from: c */
    private final String f8284c;

    /* renamed from: d */
    private final String f8285d;

    public y(String str, String str2, String str3) {
        super(ParsedResultType.TEL);
        this.f8283b = str;
        this.f8284c = str2;
        this.f8285d = str3;
    }

    @Override // com.google.zxing.client.result.q
    public String a() {
        StringBuilder sb = new StringBuilder(20);
        q.b(this.f8283b, sb);
        q.b(this.f8285d, sb);
        return sb.toString();
    }

    public String d() {
        return this.f8283b;
    }

    public String e() {
        return this.f8284c;
    }

    public String f() {
        return this.f8285d;
    }
}

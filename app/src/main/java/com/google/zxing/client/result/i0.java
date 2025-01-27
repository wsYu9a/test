package com.google.zxing.client.result;

/* loaded from: classes.dex */
public final class i0 extends q {

    /* renamed from: b */
    private final String f8251b;

    /* renamed from: c */
    private final String f8252c;

    /* renamed from: d */
    private final String f8253d;

    /* renamed from: e */
    private final boolean f8254e;

    public i0(String str, String str2, String str3) {
        this(str, str2, str3, false);
    }

    @Override // com.google.zxing.client.result.q
    public String a() {
        StringBuilder sb = new StringBuilder(80);
        q.b(this.f8251b, sb);
        q.b(this.f8252c, sb);
        q.b(this.f8253d, sb);
        q.b(Boolean.toString(this.f8254e), sb);
        return sb.toString();
    }

    public String d() {
        return this.f8252c;
    }

    public String e() {
        return this.f8253d;
    }

    public String f() {
        return this.f8251b;
    }

    public boolean g() {
        return this.f8254e;
    }

    public i0(String str, String str2, String str3, boolean z) {
        super(ParsedResultType.WIFI);
        this.f8251b = str2;
        this.f8252c = str;
        this.f8253d = str3;
        this.f8254e = z;
    }
}

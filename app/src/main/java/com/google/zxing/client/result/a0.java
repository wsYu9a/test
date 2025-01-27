package com.google.zxing.client.result;

/* loaded from: classes.dex */
public final class a0 extends q {

    /* renamed from: b */
    private final String f8204b;

    /* renamed from: c */
    private final String f8205c;

    public a0(String str, String str2) {
        super(ParsedResultType.TEXT);
        this.f8204b = str;
        this.f8205c = str2;
    }

    @Override // com.google.zxing.client.result.q
    public String a() {
        return this.f8204b;
    }

    public String d() {
        return this.f8205c;
    }

    public String e() {
        return this.f8204b;
    }
}

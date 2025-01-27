package com.google.zxing.client.result;

/* loaded from: classes.dex */
public final class r extends q {

    /* renamed from: b */
    private final String f8272b;

    /* renamed from: c */
    private final String f8273c;

    r(String str) {
        this(str, str);
    }

    @Override // com.google.zxing.client.result.q
    public String a() {
        return this.f8272b;
    }

    public String d() {
        return this.f8273c;
    }

    public String e() {
        return this.f8272b;
    }

    r(String str, String str2) {
        super(ParsedResultType.PRODUCT);
        this.f8272b = str;
        this.f8273c = str2;
    }
}

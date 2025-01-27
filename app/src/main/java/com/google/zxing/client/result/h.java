package com.google.zxing.client.result;

/* loaded from: classes.dex */
public final class h extends q {

    /* renamed from: b */
    private final String[] f8243b;

    /* renamed from: c */
    private final String[] f8244c;

    /* renamed from: d */
    private final String[] f8245d;

    /* renamed from: e */
    private final String f8246e;

    /* renamed from: f */
    private final String f8247f;

    h(String str) {
        this(new String[]{str}, null, null, null, null);
    }

    @Override // com.google.zxing.client.result.q
    public String a() {
        StringBuilder sb = new StringBuilder(30);
        q.c(this.f8243b, sb);
        q.c(this.f8244c, sb);
        q.c(this.f8245d, sb);
        q.b(this.f8246e, sb);
        q.b(this.f8247f, sb);
        return sb.toString();
    }

    public String[] d() {
        return this.f8245d;
    }

    public String e() {
        return this.f8247f;
    }

    public String[] f() {
        return this.f8244c;
    }

    @Deprecated
    public String g() {
        String[] strArr = this.f8243b;
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        return strArr[0];
    }

    @Deprecated
    public String h() {
        return "mailto:";
    }

    public String i() {
        return this.f8246e;
    }

    public String[] j() {
        return this.f8243b;
    }

    h(String[] strArr, String[] strArr2, String[] strArr3, String str, String str2) {
        super(ParsedResultType.EMAIL_ADDRESS);
        this.f8243b = strArr;
        this.f8244c = strArr2;
        this.f8245d = strArr3;
        this.f8246e = str;
        this.f8247f = str2;
    }
}

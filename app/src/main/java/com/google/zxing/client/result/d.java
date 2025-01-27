package com.google.zxing.client.result;

/* loaded from: classes.dex */
public final class d extends q {

    /* renamed from: b */
    private final String[] f8211b;

    /* renamed from: c */
    private final String[] f8212c;

    /* renamed from: d */
    private final String f8213d;

    /* renamed from: e */
    private final String[] f8214e;

    /* renamed from: f */
    private final String[] f8215f;

    /* renamed from: g */
    private final String[] f8216g;

    /* renamed from: h */
    private final String[] f8217h;

    /* renamed from: i */
    private final String f8218i;

    /* renamed from: j */
    private final String f8219j;
    private final String[] k;
    private final String[] l;
    private final String m;
    private final String n;
    private final String o;
    private final String[] p;
    private final String[] q;

    public d(String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4, String[] strArr5, String[] strArr6, String[] strArr7) {
        this(strArr, null, null, strArr2, strArr3, strArr4, strArr5, null, null, strArr6, strArr7, null, null, null, null, null);
    }

    @Override // com.google.zxing.client.result.q
    public String a() {
        StringBuilder sb = new StringBuilder(100);
        q.c(this.f8211b, sb);
        q.c(this.f8212c, sb);
        q.b(this.f8213d, sb);
        q.b(this.o, sb);
        q.b(this.m, sb);
        q.c(this.k, sb);
        q.c(this.f8214e, sb);
        q.c(this.f8216g, sb);
        q.b(this.f8218i, sb);
        q.c(this.p, sb);
        q.b(this.n, sb);
        q.c(this.q, sb);
        q.b(this.f8219j, sb);
        return sb.toString();
    }

    public String[] d() {
        return this.l;
    }

    public String[] e() {
        return this.k;
    }

    public String f() {
        return this.n;
    }

    public String[] g() {
        return this.f8217h;
    }

    public String[] h() {
        return this.f8216g;
    }

    public String[] i() {
        return this.q;
    }

    public String j() {
        return this.f8218i;
    }

    public String[] k() {
        return this.f8211b;
    }

    public String[] l() {
        return this.f8212c;
    }

    public String m() {
        return this.f8219j;
    }

    public String n() {
        return this.m;
    }

    public String[] o() {
        return this.f8214e;
    }

    public String[] p() {
        return this.f8215f;
    }

    public String q() {
        return this.f8213d;
    }

    public String r() {
        return this.o;
    }

    public String[] s() {
        return this.p;
    }

    public d(String[] strArr, String[] strArr2, String str, String[] strArr3, String[] strArr4, String[] strArr5, String[] strArr6, String str2, String str3, String[] strArr7, String[] strArr8, String str4, String str5, String str6, String[] strArr9, String[] strArr10) {
        super(ParsedResultType.ADDRESSBOOK);
        this.f8211b = strArr;
        this.f8212c = strArr2;
        this.f8213d = str;
        this.f8214e = strArr3;
        this.f8215f = strArr4;
        this.f8216g = strArr5;
        this.f8217h = strArr6;
        this.f8218i = str2;
        this.f8219j = str3;
        this.k = strArr7;
        this.l = strArr8;
        this.m = str4;
        this.n = str5;
        this.o = str6;
        this.p = strArr9;
        this.q = strArr10;
    }
}

package com.google.zxing.client.result;

/* loaded from: classes.dex */
public final class g0 extends q {

    /* renamed from: b */
    private final String f8234b;

    /* renamed from: c */
    private final String f8235c;

    /* renamed from: d */
    private final String f8236d;

    /* renamed from: e */
    private final String f8237e;

    /* renamed from: f */
    private final String f8238f;

    /* renamed from: g */
    private final String f8239g;

    /* renamed from: h */
    private final int f8240h;

    /* renamed from: i */
    private final char f8241i;

    /* renamed from: j */
    private final String f8242j;

    public g0(String str, String str2, String str3, String str4, String str5, String str6, int i2, char c2, String str7) {
        super(ParsedResultType.VIN);
        this.f8234b = str;
        this.f8235c = str2;
        this.f8236d = str3;
        this.f8237e = str4;
        this.f8238f = str5;
        this.f8239g = str6;
        this.f8240h = i2;
        this.f8241i = c2;
        this.f8242j = str7;
    }

    @Override // com.google.zxing.client.result.q
    public String a() {
        StringBuilder sb = new StringBuilder(50);
        sb.append(this.f8235c);
        sb.append(' ');
        sb.append(this.f8236d);
        sb.append(' ');
        sb.append(this.f8237e);
        sb.append('\n');
        String str = this.f8238f;
        if (str != null) {
            sb.append(str);
            sb.append(' ');
        }
        sb.append(this.f8240h);
        sb.append(' ');
        sb.append(this.f8241i);
        sb.append(' ');
        sb.append(this.f8242j);
        sb.append('\n');
        return sb.toString();
    }

    public String d() {
        return this.f8238f;
    }

    public int e() {
        return this.f8240h;
    }

    public char f() {
        return this.f8241i;
    }

    public String g() {
        return this.f8242j;
    }

    public String h() {
        return this.f8234b;
    }

    public String i() {
        return this.f8239g;
    }

    public String j() {
        return this.f8236d;
    }

    public String k() {
        return this.f8237e;
    }

    public String l() {
        return this.f8235c;
    }
}

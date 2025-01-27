package y5;

import com.google.zxing.client.result.ParsedResultType;

/* loaded from: classes2.dex */
public final class d extends q {

    /* renamed from: b */
    public final String[] f32964b;

    /* renamed from: c */
    public final String[] f32965c;

    /* renamed from: d */
    public final String f32966d;

    /* renamed from: e */
    public final String[] f32967e;

    /* renamed from: f */
    public final String[] f32968f;

    /* renamed from: g */
    public final String[] f32969g;

    /* renamed from: h */
    public final String[] f32970h;

    /* renamed from: i */
    public final String f32971i;

    /* renamed from: j */
    public final String f32972j;

    /* renamed from: k */
    public final String[] f32973k;

    /* renamed from: l */
    public final String[] f32974l;

    /* renamed from: m */
    public final String f32975m;

    /* renamed from: n */
    public final String f32976n;

    /* renamed from: o */
    public final String f32977o;

    /* renamed from: p */
    public final String[] f32978p;

    /* renamed from: q */
    public final String[] f32979q;

    public d(String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4, String[] strArr5, String[] strArr6, String[] strArr7) {
        this(strArr, null, null, strArr2, strArr3, strArr4, strArr5, null, null, strArr6, strArr7, null, null, null, null, null);
    }

    @Override // y5.q
    public String a() {
        StringBuilder sb2 = new StringBuilder(100);
        q.c(this.f32964b, sb2);
        q.c(this.f32965c, sb2);
        q.b(this.f32966d, sb2);
        q.b(this.f32977o, sb2);
        q.b(this.f32975m, sb2);
        q.c(this.f32973k, sb2);
        q.c(this.f32967e, sb2);
        q.c(this.f32969g, sb2);
        q.b(this.f32971i, sb2);
        q.c(this.f32978p, sb2);
        q.b(this.f32976n, sb2);
        q.c(this.f32979q, sb2);
        q.b(this.f32972j, sb2);
        return sb2.toString();
    }

    public String[] d() {
        return this.f32974l;
    }

    public String[] e() {
        return this.f32973k;
    }

    public String f() {
        return this.f32976n;
    }

    public String[] g() {
        return this.f32970h;
    }

    public String[] h() {
        return this.f32969g;
    }

    public String[] i() {
        return this.f32979q;
    }

    public String j() {
        return this.f32971i;
    }

    public String[] k() {
        return this.f32964b;
    }

    public String[] l() {
        return this.f32965c;
    }

    public String m() {
        return this.f32972j;
    }

    public String n() {
        return this.f32975m;
    }

    public String[] o() {
        return this.f32967e;
    }

    public String[] p() {
        return this.f32968f;
    }

    public String q() {
        return this.f32966d;
    }

    public String r() {
        return this.f32977o;
    }

    public String[] s() {
        return this.f32978p;
    }

    public d(String[] strArr, String[] strArr2, String str, String[] strArr3, String[] strArr4, String[] strArr5, String[] strArr6, String str2, String str3, String[] strArr7, String[] strArr8, String str4, String str5, String str6, String[] strArr9, String[] strArr10) {
        super(ParsedResultType.ADDRESSBOOK);
        this.f32964b = strArr;
        this.f32965c = strArr2;
        this.f32966d = str;
        this.f32967e = strArr3;
        this.f32968f = strArr4;
        this.f32969g = strArr5;
        this.f32970h = strArr6;
        this.f32971i = str2;
        this.f32972j = str3;
        this.f32973k = strArr7;
        this.f32974l = strArr8;
        this.f32975m = str4;
        this.f32976n = str5;
        this.f32977o = str6;
        this.f32978p = strArr9;
        this.f32979q = strArr10;
    }
}

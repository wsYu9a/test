package y5;

import com.google.zxing.client.result.ParsedResultType;

/* loaded from: classes2.dex */
public final class i0 extends q {

    /* renamed from: b */
    public final String f33021b;

    /* renamed from: c */
    public final String f33022c;

    /* renamed from: d */
    public final String f33023d;

    /* renamed from: e */
    public final boolean f33024e;

    public i0(String str, String str2, String str3) {
        this(str, str2, str3, false);
    }

    @Override // y5.q
    public String a() {
        StringBuilder sb2 = new StringBuilder(80);
        q.b(this.f33021b, sb2);
        q.b(this.f33022c, sb2);
        q.b(this.f33023d, sb2);
        q.b(Boolean.toString(this.f33024e), sb2);
        return sb2.toString();
    }

    public String d() {
        return this.f33022c;
    }

    public String e() {
        return this.f33023d;
    }

    public String f() {
        return this.f33021b;
    }

    public boolean g() {
        return this.f33024e;
    }

    public i0(String str, String str2, String str3, boolean z10) {
        super(ParsedResultType.WIFI);
        this.f33021b = str2;
        this.f33022c = str;
        this.f33023d = str3;
        this.f33024e = z10;
    }
}

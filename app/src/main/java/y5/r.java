package y5;

import com.google.zxing.client.result.ParsedResultType;

/* loaded from: classes2.dex */
public final class r extends q {

    /* renamed from: b */
    public final String f33050b;

    /* renamed from: c */
    public final String f33051c;

    public r(String str) {
        this(str, str);
    }

    @Override // y5.q
    public String a() {
        return this.f33050b;
    }

    public String d() {
        return this.f33051c;
    }

    public String e() {
        return this.f33050b;
    }

    public r(String str, String str2) {
        super(ParsedResultType.PRODUCT);
        this.f33050b = str;
        this.f33051c = str2;
    }
}

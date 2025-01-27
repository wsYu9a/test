package y5;

import com.google.zxing.client.result.ParsedResultType;

/* loaded from: classes2.dex */
public final class y extends q {

    /* renamed from: b */
    public final String f33061b;

    /* renamed from: c */
    public final String f33062c;

    /* renamed from: d */
    public final String f33063d;

    public y(String str, String str2, String str3) {
        super(ParsedResultType.TEL);
        this.f33061b = str;
        this.f33062c = str2;
        this.f33063d = str3;
    }

    @Override // y5.q
    public String a() {
        StringBuilder sb2 = new StringBuilder(20);
        q.b(this.f33061b, sb2);
        q.b(this.f33063d, sb2);
        return sb2.toString();
    }

    public String d() {
        return this.f33061b;
    }

    public String e() {
        return this.f33062c;
    }

    public String f() {
        return this.f33063d;
    }
}

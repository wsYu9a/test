package y5;

import com.google.zxing.client.result.ParsedResultType;

/* loaded from: classes2.dex */
public final class o extends q {

    /* renamed from: b */
    public final String f33048b;

    public o(String str) {
        super(ParsedResultType.ISBN);
        this.f33048b = str;
    }

    @Override // y5.q
    public String a() {
        return this.f33048b;
    }

    public String d() {
        return this.f33048b;
    }
}

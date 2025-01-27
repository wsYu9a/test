package y5;

import com.google.zxing.client.result.ParsedResultType;

/* loaded from: classes2.dex */
public final class a0 extends q {

    /* renamed from: b */
    public final String f32957b;

    /* renamed from: c */
    public final String f32958c;

    public a0(String str, String str2) {
        super(ParsedResultType.TEXT);
        this.f32957b = str;
        this.f32958c = str2;
    }

    @Override // y5.q
    public String a() {
        return this.f32957b;
    }

    public String d() {
        return this.f32958c;
    }

    public String e() {
        return this.f32957b;
    }
}

package y5;

import com.google.zxing.client.result.ParsedResultType;

/* loaded from: classes2.dex */
public final class g0 extends q {

    /* renamed from: b */
    public final String f33004b;

    /* renamed from: c */
    public final String f33005c;

    /* renamed from: d */
    public final String f33006d;

    /* renamed from: e */
    public final String f33007e;

    /* renamed from: f */
    public final String f33008f;

    /* renamed from: g */
    public final String f33009g;

    /* renamed from: h */
    public final int f33010h;

    /* renamed from: i */
    public final char f33011i;

    /* renamed from: j */
    public final String f33012j;

    public g0(String str, String str2, String str3, String str4, String str5, String str6, int i10, char c10, String str7) {
        super(ParsedResultType.VIN);
        this.f33004b = str;
        this.f33005c = str2;
        this.f33006d = str3;
        this.f33007e = str4;
        this.f33008f = str5;
        this.f33009g = str6;
        this.f33010h = i10;
        this.f33011i = c10;
        this.f33012j = str7;
    }

    @Override // y5.q
    public String a() {
        StringBuilder sb2 = new StringBuilder(50);
        sb2.append(this.f33005c);
        sb2.append(b5.a.O);
        sb2.append(this.f33006d);
        sb2.append(b5.a.O);
        sb2.append(this.f33007e);
        sb2.append('\n');
        String str = this.f33008f;
        if (str != null) {
            sb2.append(str);
            sb2.append(b5.a.O);
        }
        sb2.append(this.f33010h);
        sb2.append(b5.a.O);
        sb2.append(this.f33011i);
        sb2.append(b5.a.O);
        sb2.append(this.f33012j);
        sb2.append('\n');
        return sb2.toString();
    }

    public String d() {
        return this.f33008f;
    }

    public int e() {
        return this.f33010h;
    }

    public char f() {
        return this.f33011i;
    }

    public String g() {
        return this.f33012j;
    }

    public String h() {
        return this.f33004b;
    }

    public String i() {
        return this.f33009g;
    }

    public String j() {
        return this.f33006d;
    }

    public String k() {
        return this.f33007e;
    }

    public String l() {
        return this.f33005c;
    }
}

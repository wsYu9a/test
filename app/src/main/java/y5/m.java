package y5;

import com.google.zxing.client.result.ParsedResultType;

/* loaded from: classes2.dex */
public final class m extends q {

    /* renamed from: b */
    public final double f33043b;

    /* renamed from: c */
    public final double f33044c;

    /* renamed from: d */
    public final double f33045d;

    /* renamed from: e */
    public final String f33046e;

    public m(double d10, double d11, double d12, String str) {
        super(ParsedResultType.GEO);
        this.f33043b = d10;
        this.f33044c = d11;
        this.f33045d = d12;
        this.f33046e = str;
    }

    @Override // y5.q
    public String a() {
        StringBuilder sb2 = new StringBuilder(20);
        sb2.append(this.f33043b);
        sb2.append(", ");
        sb2.append(this.f33044c);
        if (this.f33045d > l5.c.f27899e) {
            sb2.append(", ");
            sb2.append(this.f33045d);
            sb2.append('m');
        }
        if (this.f33046e != null) {
            sb2.append(" (");
            sb2.append(this.f33046e);
            sb2.append(')');
        }
        return sb2.toString();
    }

    public double d() {
        return this.f33045d;
    }

    public String e() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("geo:");
        sb2.append(this.f33043b);
        sb2.append(',');
        sb2.append(this.f33044c);
        if (this.f33045d > l5.c.f27899e) {
            sb2.append(',');
            sb2.append(this.f33045d);
        }
        if (this.f33046e != null) {
            sb2.append('?');
            sb2.append(this.f33046e);
        }
        return sb2.toString();
    }

    public double f() {
        return this.f33043b;
    }

    public double g() {
        return this.f33044c;
    }

    public String h() {
        return this.f33046e;
    }
}

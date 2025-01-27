package com.google.zxing.client.result;

/* loaded from: classes.dex */
public final class m extends q {

    /* renamed from: b */
    private final double f8265b;

    /* renamed from: c */
    private final double f8266c;

    /* renamed from: d */
    private final double f8267d;

    /* renamed from: e */
    private final String f8268e;

    m(double d2, double d3, double d4, String str) {
        super(ParsedResultType.GEO);
        this.f8265b = d2;
        this.f8266c = d3;
        this.f8267d = d4;
        this.f8268e = str;
    }

    @Override // com.google.zxing.client.result.q
    public String a() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.f8265b);
        sb.append(", ");
        sb.append(this.f8266c);
        if (this.f8267d > 0.0d) {
            sb.append(", ");
            sb.append(this.f8267d);
            sb.append('m');
        }
        if (this.f8268e != null) {
            sb.append(" (");
            sb.append(this.f8268e);
            sb.append(')');
        }
        return sb.toString();
    }

    public double d() {
        return this.f8267d;
    }

    public String e() {
        StringBuilder sb = new StringBuilder();
        sb.append("geo:");
        sb.append(this.f8265b);
        sb.append(',');
        sb.append(this.f8266c);
        if (this.f8267d > 0.0d) {
            sb.append(',');
            sb.append(this.f8267d);
        }
        if (this.f8268e != null) {
            sb.append('?');
            sb.append(this.f8268e);
        }
        return sb.toString();
    }

    public double f() {
        return this.f8265b;
    }

    public double g() {
        return this.f8266c;
    }

    public String h() {
        return this.f8268e;
    }
}

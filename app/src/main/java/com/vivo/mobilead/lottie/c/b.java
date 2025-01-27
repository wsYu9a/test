package com.vivo.mobilead.lottie.c;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    public final String f29190a;

    /* renamed from: b */
    public final String f29191b;

    /* renamed from: c */
    public final double f29192c;

    /* renamed from: d */
    public final a f29193d;

    /* renamed from: e */
    public final int f29194e;

    /* renamed from: f */
    public final double f29195f;

    /* renamed from: g */
    public final double f29196g;

    /* renamed from: h */
    public final int f29197h;

    /* renamed from: i */
    public final int f29198i;

    /* renamed from: j */
    public final double f29199j;
    public final boolean k;

    public enum a {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public b(String str, String str2, double d2, a aVar, int i2, double d3, double d4, int i3, int i4, double d5, boolean z) {
        this.f29190a = str;
        this.f29191b = str2;
        this.f29192c = d2;
        this.f29193d = aVar;
        this.f29194e = i2;
        this.f29195f = d3;
        this.f29196g = d4;
        this.f29197h = i3;
        this.f29198i = i4;
        this.f29199j = d5;
        this.k = z;
    }

    public int hashCode() {
        double hashCode = ((this.f29190a.hashCode() * 31) + this.f29191b.hashCode()) * 31;
        double d2 = this.f29192c;
        Double.isNaN(hashCode);
        int ordinal = (((((int) (hashCode + d2)) * 31) + this.f29193d.ordinal()) * 31) + this.f29194e;
        long doubleToLongBits = Double.doubleToLongBits(this.f29195f);
        return (((ordinal * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + this.f29197h;
    }
}

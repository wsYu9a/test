package com.vivo.mobilead.lottie.c;

import com.vivo.mobilead.lottie.c.b.n;
import java.util.List;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    private final List<n> f29388a;

    /* renamed from: b */
    private final char f29389b;

    /* renamed from: c */
    private final double f29390c;

    /* renamed from: d */
    private final double f29391d;

    /* renamed from: e */
    private final String f29392e;

    /* renamed from: f */
    private final String f29393f;

    public d(List<n> list, char c2, double d2, double d3, String str, String str2) {
        this.f29388a = list;
        this.f29389b = c2;
        this.f29390c = d2;
        this.f29391d = d3;
        this.f29392e = str;
        this.f29393f = str2;
    }

    public static int a(char c2, String str, String str2) {
        return ((((c2 + 0) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public List<n> a() {
        return this.f29388a;
    }

    public double b() {
        return this.f29391d;
    }

    public int hashCode() {
        return a(this.f29389b, this.f29393f, this.f29392e);
    }
}

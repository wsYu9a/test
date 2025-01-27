package com.vivo.mobilead.lottie.c.b;

import com.vivo.mobilead.lottie.a.a.s;

/* loaded from: classes4.dex */
public class q implements b {

    /* renamed from: a */
    private final String f29311a;

    /* renamed from: b */
    private final a f29312b;

    /* renamed from: c */
    private final com.vivo.mobilead.lottie.c.a.b f29313c;

    /* renamed from: d */
    private final com.vivo.mobilead.lottie.c.a.b f29314d;

    /* renamed from: e */
    private final com.vivo.mobilead.lottie.c.a.b f29315e;

    /* renamed from: f */
    private final boolean f29316f;

    public enum a {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static a a(int i2) {
            if (i2 == 1) {
                return SIMULTANEOUSLY;
            }
            if (i2 == 2) {
                return INDIVIDUALLY;
            }
            throw new IllegalArgumentException("Unknown trim path type " + i2);
        }
    }

    public q(String str, a aVar, com.vivo.mobilead.lottie.c.a.b bVar, com.vivo.mobilead.lottie.c.a.b bVar2, com.vivo.mobilead.lottie.c.a.b bVar3, boolean z) {
        this.f29311a = str;
        this.f29312b = aVar;
        this.f29313c = bVar;
        this.f29314d = bVar2;
        this.f29315e = bVar3;
        this.f29316f = z;
    }

    @Override // com.vivo.mobilead.lottie.c.b.b
    public com.vivo.mobilead.lottie.a.a.c a(com.vivo.mobilead.lottie.c cVar, com.vivo.mobilead.lottie.c.c.a aVar) {
        return new s(aVar, this);
    }

    public String a() {
        return this.f29311a;
    }

    public a b() {
        return this.f29312b;
    }

    public com.vivo.mobilead.lottie.c.a.b c() {
        return this.f29314d;
    }

    public com.vivo.mobilead.lottie.c.a.b d() {
        return this.f29313c;
    }

    public com.vivo.mobilead.lottie.c.a.b e() {
        return this.f29315e;
    }

    public boolean f() {
        return this.f29316f;
    }

    public String toString() {
        return "Trim Path: {start: " + this.f29313c + ", end: " + this.f29314d + ", offset: " + this.f29315e + "}";
    }
}

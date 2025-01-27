package com.vivo.mobilead.lottie.c.b;

/* loaded from: classes4.dex */
public class o implements b {

    /* renamed from: a */
    private final String f29287a;

    /* renamed from: b */
    private final int f29288b;

    /* renamed from: c */
    private final com.vivo.mobilead.lottie.c.a.h f29289c;

    /* renamed from: d */
    private final boolean f29290d;

    public o(String str, int i2, com.vivo.mobilead.lottie.c.a.h hVar, boolean z) {
        this.f29287a = str;
        this.f29288b = i2;
        this.f29289c = hVar;
        this.f29290d = z;
    }

    @Override // com.vivo.mobilead.lottie.c.b.b
    public com.vivo.mobilead.lottie.a.a.c a(com.vivo.mobilead.lottie.c cVar, com.vivo.mobilead.lottie.c.c.a aVar) {
        return new com.vivo.mobilead.lottie.a.a.q(cVar, aVar, this);
    }

    public String a() {
        return this.f29287a;
    }

    public com.vivo.mobilead.lottie.c.a.h b() {
        return this.f29289c;
    }

    public boolean c() {
        return this.f29290d;
    }

    public String toString() {
        return "ShapePath{name=" + this.f29287a + ", index=" + this.f29288b + '}';
    }
}

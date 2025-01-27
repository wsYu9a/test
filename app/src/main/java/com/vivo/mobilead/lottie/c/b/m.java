package com.vivo.mobilead.lottie.c.b;

import android.graphics.Path;

/* loaded from: classes4.dex */
public class m implements b {

    /* renamed from: a */
    private final boolean f29278a;

    /* renamed from: b */
    private final Path.FillType f29279b;

    /* renamed from: c */
    private final String f29280c;

    /* renamed from: d */
    private final com.vivo.mobilead.lottie.c.a.a f29281d;

    /* renamed from: e */
    private final com.vivo.mobilead.lottie.c.a.d f29282e;

    /* renamed from: f */
    private final boolean f29283f;

    public m(String str, boolean z, Path.FillType fillType, com.vivo.mobilead.lottie.c.a.a aVar, com.vivo.mobilead.lottie.c.a.d dVar, boolean z2) {
        this.f29280c = str;
        this.f29278a = z;
        this.f29279b = fillType;
        this.f29281d = aVar;
        this.f29282e = dVar;
        this.f29283f = z2;
    }

    @Override // com.vivo.mobilead.lottie.c.b.b
    public com.vivo.mobilead.lottie.a.a.c a(com.vivo.mobilead.lottie.c cVar, com.vivo.mobilead.lottie.c.c.a aVar) {
        return new com.vivo.mobilead.lottie.a.a.g(cVar, aVar, this);
    }

    public String a() {
        return this.f29280c;
    }

    public com.vivo.mobilead.lottie.c.a.a b() {
        return this.f29281d;
    }

    public com.vivo.mobilead.lottie.c.a.d c() {
        return this.f29282e;
    }

    public Path.FillType d() {
        return this.f29279b;
    }

    public boolean e() {
        return this.f29283f;
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f29278a + '}';
    }
}

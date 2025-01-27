package com.vivo.mobilead.lottie.c.b;

import android.graphics.PointF;

/* loaded from: classes4.dex */
public class j implements b {

    /* renamed from: a */
    private final String f29265a;

    /* renamed from: b */
    private final com.vivo.mobilead.lottie.c.a.m<PointF, PointF> f29266b;

    /* renamed from: c */
    private final com.vivo.mobilead.lottie.c.a.f f29267c;

    /* renamed from: d */
    private final com.vivo.mobilead.lottie.c.a.b f29268d;

    /* renamed from: e */
    private final boolean f29269e;

    public j(String str, com.vivo.mobilead.lottie.c.a.m<PointF, PointF> mVar, com.vivo.mobilead.lottie.c.a.f fVar, com.vivo.mobilead.lottie.c.a.b bVar, boolean z) {
        this.f29265a = str;
        this.f29266b = mVar;
        this.f29267c = fVar;
        this.f29268d = bVar;
        this.f29269e = z;
    }

    @Override // com.vivo.mobilead.lottie.c.b.b
    public com.vivo.mobilead.lottie.a.a.c a(com.vivo.mobilead.lottie.c cVar, com.vivo.mobilead.lottie.c.c.a aVar) {
        return new com.vivo.mobilead.lottie.a.a.o(cVar, aVar, this);
    }

    public String a() {
        return this.f29265a;
    }

    public com.vivo.mobilead.lottie.c.a.b b() {
        return this.f29268d;
    }

    public com.vivo.mobilead.lottie.c.a.f c() {
        return this.f29267c;
    }

    public com.vivo.mobilead.lottie.c.a.m<PointF, PointF> d() {
        return this.f29266b;
    }

    public boolean e() {
        return this.f29269e;
    }

    public String toString() {
        return "RectangleShape{position=" + this.f29266b + ", size=" + this.f29267c + '}';
    }
}

package com.vivo.mobilead.lottie.c.b;

import android.graphics.PointF;

/* loaded from: classes4.dex */
public class i implements b {

    /* renamed from: a */
    private final String f29251a;

    /* renamed from: b */
    private final a f29252b;

    /* renamed from: c */
    private final com.vivo.mobilead.lottie.c.a.b f29253c;

    /* renamed from: d */
    private final com.vivo.mobilead.lottie.c.a.m<PointF, PointF> f29254d;

    /* renamed from: e */
    private final com.vivo.mobilead.lottie.c.a.b f29255e;

    /* renamed from: f */
    private final com.vivo.mobilead.lottie.c.a.b f29256f;

    /* renamed from: g */
    private final com.vivo.mobilead.lottie.c.a.b f29257g;

    /* renamed from: h */
    private final com.vivo.mobilead.lottie.c.a.b f29258h;

    /* renamed from: i */
    private final com.vivo.mobilead.lottie.c.a.b f29259i;

    /* renamed from: j */
    private final boolean f29260j;

    public enum a {
        STAR(1),
        POLYGON(2);


        /* renamed from: c */
        private final int f29264c;

        a(int i2) {
            this.f29264c = i2;
        }

        public static a a(int i2) {
            for (a aVar : values()) {
                if (aVar.f29264c == i2) {
                    return aVar;
                }
            }
            return null;
        }
    }

    public i(String str, a aVar, com.vivo.mobilead.lottie.c.a.b bVar, com.vivo.mobilead.lottie.c.a.m<PointF, PointF> mVar, com.vivo.mobilead.lottie.c.a.b bVar2, com.vivo.mobilead.lottie.c.a.b bVar3, com.vivo.mobilead.lottie.c.a.b bVar4, com.vivo.mobilead.lottie.c.a.b bVar5, com.vivo.mobilead.lottie.c.a.b bVar6, boolean z) {
        this.f29251a = str;
        this.f29252b = aVar;
        this.f29253c = bVar;
        this.f29254d = mVar;
        this.f29255e = bVar2;
        this.f29256f = bVar3;
        this.f29257g = bVar4;
        this.f29258h = bVar5;
        this.f29259i = bVar6;
        this.f29260j = z;
    }

    @Override // com.vivo.mobilead.lottie.c.b.b
    public com.vivo.mobilead.lottie.a.a.c a(com.vivo.mobilead.lottie.c cVar, com.vivo.mobilead.lottie.c.c.a aVar) {
        return new com.vivo.mobilead.lottie.a.a.n(cVar, aVar, this);
    }

    public String a() {
        return this.f29251a;
    }

    public a b() {
        return this.f29252b;
    }

    public com.vivo.mobilead.lottie.c.a.b c() {
        return this.f29253c;
    }

    public com.vivo.mobilead.lottie.c.a.m<PointF, PointF> d() {
        return this.f29254d;
    }

    public com.vivo.mobilead.lottie.c.a.b e() {
        return this.f29255e;
    }

    public com.vivo.mobilead.lottie.c.a.b f() {
        return this.f29256f;
    }

    public com.vivo.mobilead.lottie.c.a.b g() {
        return this.f29257g;
    }

    public com.vivo.mobilead.lottie.c.a.b h() {
        return this.f29258h;
    }

    public com.vivo.mobilead.lottie.c.a.b i() {
        return this.f29259i;
    }

    public boolean j() {
        return this.f29260j;
    }
}

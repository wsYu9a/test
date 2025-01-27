package com.vivo.mobilead.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;

/* loaded from: classes4.dex */
public class r extends a {

    /* renamed from: c */
    private final com.vivo.mobilead.lottie.c.c.a f29059c;

    /* renamed from: d */
    private final String f29060d;

    /* renamed from: e */
    private final boolean f29061e;

    /* renamed from: f */
    private final com.vivo.mobilead.lottie.a.b.a<Integer, Integer> f29062f;

    /* renamed from: g */
    private com.vivo.mobilead.lottie.a.b.a<ColorFilter, ColorFilter> f29063g;

    public r(com.vivo.mobilead.lottie.c cVar, com.vivo.mobilead.lottie.c.c.a aVar, com.vivo.mobilead.lottie.c.b.p pVar) {
        super(cVar, aVar, pVar.g().a(), pVar.h().a(), pVar.i(), pVar.c(), pVar.d(), pVar.e(), pVar.f());
        this.f29059c = aVar;
        this.f29060d = pVar.a();
        this.f29061e = pVar.j();
        com.vivo.mobilead.lottie.a.b.a<Integer, Integer> a2 = pVar.b().a();
        this.f29062f = a2;
        a2.a(this);
        aVar.a(a2);
    }

    @Override // com.vivo.mobilead.lottie.a.a.a, com.vivo.mobilead.lottie.a.a.e
    public void a(Canvas canvas, Matrix matrix, int i2) {
        if (this.f29061e) {
            return;
        }
        this.f28957b.setColor(((com.vivo.mobilead.lottie.a.b.b) this.f29062f).i());
        com.vivo.mobilead.lottie.a.b.a<ColorFilter, ColorFilter> aVar = this.f29063g;
        if (aVar != null) {
            this.f28957b.setColorFilter(aVar.g());
        }
        super.a(canvas, matrix, i2);
    }

    @Override // com.vivo.mobilead.lottie.a.a.a, com.vivo.mobilead.lottie.c.f
    public <T> void a(T t, com.vivo.mobilead.lottie.g.c<T> cVar) {
        super.a((r) t, (com.vivo.mobilead.lottie.g.c<r>) cVar);
        if (t == com.vivo.mobilead.lottie.g.f29454b) {
            this.f29062f.a((com.vivo.mobilead.lottie.g.c<Integer>) cVar);
            return;
        }
        if (t == com.vivo.mobilead.lottie.g.B) {
            if (cVar == null) {
                this.f29063g = null;
                return;
            }
            com.vivo.mobilead.lottie.a.b.p pVar = new com.vivo.mobilead.lottie.a.b.p(cVar);
            this.f29063g = pVar;
            pVar.a(this);
            this.f29059c.a(this.f29062f);
        }
    }

    @Override // com.vivo.mobilead.lottie.a.a.c
    public String b() {
        return this.f29060d;
    }
}

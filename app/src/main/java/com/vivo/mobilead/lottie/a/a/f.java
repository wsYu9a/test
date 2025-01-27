package com.vivo.mobilead.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import com.vivo.mobilead.lottie.a.b.a;
import com.vivo.mobilead.lottie.c.b.q;
import java.util.List;

/* loaded from: classes4.dex */
public class f implements k, m, a.InterfaceC0598a {

    /* renamed from: b */
    private final String f28979b;

    /* renamed from: c */
    private final com.vivo.mobilead.lottie.c f28980c;

    /* renamed from: d */
    private final com.vivo.mobilead.lottie.a.b.a<?, PointF> f28981d;

    /* renamed from: e */
    private final com.vivo.mobilead.lottie.a.b.a<?, PointF> f28982e;

    /* renamed from: f */
    private final com.vivo.mobilead.lottie.c.b.a f28983f;

    /* renamed from: h */
    private boolean f28985h;

    /* renamed from: a */
    private final Path f28978a = new Path();

    /* renamed from: g */
    private b f28984g = new b();

    public f(com.vivo.mobilead.lottie.c cVar, com.vivo.mobilead.lottie.c.c.a aVar, com.vivo.mobilead.lottie.c.b.a aVar2) {
        this.f28979b = aVar2.a();
        this.f28980c = cVar;
        com.vivo.mobilead.lottie.a.b.a<PointF, PointF> a2 = aVar2.c().a();
        this.f28981d = a2;
        com.vivo.mobilead.lottie.a.b.a<PointF, PointF> a3 = aVar2.b().a();
        this.f28982e = a3;
        this.f28983f = aVar2;
        aVar.a(a2);
        aVar.a(a3);
        a2.a(this);
        a3.a(this);
    }

    private void c() {
        this.f28985h = false;
        this.f28980c.invalidateSelf();
    }

    @Override // com.vivo.mobilead.lottie.a.b.a.InterfaceC0598a
    public void a() {
        c();
    }

    @Override // com.vivo.mobilead.lottie.c.f
    public void a(com.vivo.mobilead.lottie.c.e eVar, int i2, List<com.vivo.mobilead.lottie.c.e> list, com.vivo.mobilead.lottie.c.e eVar2) {
        com.vivo.mobilead.lottie.f.g.a(eVar, i2, list, eVar2, this);
    }

    @Override // com.vivo.mobilead.lottie.c.f
    public <T> void a(T t, com.vivo.mobilead.lottie.g.c<T> cVar) {
        com.vivo.mobilead.lottie.a.b.a<?, PointF> aVar;
        if (t == com.vivo.mobilead.lottie.g.f29459g) {
            aVar = this.f28981d;
        } else if (t != com.vivo.mobilead.lottie.g.f29462j) {
            return;
        } else {
            aVar = this.f28982e;
        }
        aVar.a((com.vivo.mobilead.lottie.g.c<PointF>) cVar);
    }

    @Override // com.vivo.mobilead.lottie.a.a.c
    public void a(List<c> list, List<c> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            c cVar = list.get(i2);
            if (cVar instanceof s) {
                s sVar = (s) cVar;
                if (sVar.c() == q.a.SIMULTANEOUSLY) {
                    this.f28984g.a(sVar);
                    sVar.a(this);
                }
            }
        }
    }

    @Override // com.vivo.mobilead.lottie.a.a.c
    public String b() {
        return this.f28979b;
    }

    @Override // com.vivo.mobilead.lottie.a.a.m
    public Path e() {
        if (this.f28985h) {
            return this.f28978a;
        }
        this.f28978a.reset();
        if (!this.f28983f.e()) {
            PointF g2 = this.f28981d.g();
            float f2 = g2.x / 2.0f;
            float f3 = g2.y / 2.0f;
            float f4 = f2 * 0.55228f;
            float f5 = 0.55228f * f3;
            this.f28978a.reset();
            if (this.f28983f.d()) {
                float f6 = -f3;
                this.f28978a.moveTo(0.0f, f6);
                float f7 = 0.0f - f4;
                float f8 = -f2;
                float f9 = 0.0f - f5;
                this.f28978a.cubicTo(f7, f6, f8, f9, f8, 0.0f);
                float f10 = f5 + 0.0f;
                this.f28978a.cubicTo(f8, f10, f7, f3, 0.0f, f3);
                float f11 = f4 + 0.0f;
                this.f28978a.cubicTo(f11, f3, f2, f10, f2, 0.0f);
                this.f28978a.cubicTo(f2, f9, f11, f6, 0.0f, f6);
            } else {
                float f12 = -f3;
                this.f28978a.moveTo(0.0f, f12);
                float f13 = f4 + 0.0f;
                float f14 = 0.0f - f5;
                this.f28978a.cubicTo(f13, f12, f2, f14, f2, 0.0f);
                float f15 = f5 + 0.0f;
                this.f28978a.cubicTo(f2, f15, f13, f3, 0.0f, f3);
                float f16 = 0.0f - f4;
                float f17 = -f2;
                this.f28978a.cubicTo(f16, f3, f17, f15, f17, 0.0f);
                this.f28978a.cubicTo(f17, f14, f16, f12, 0.0f, f12);
            }
            PointF g3 = this.f28982e.g();
            this.f28978a.offset(g3.x, g3.y);
            this.f28978a.close();
            this.f28984g.a(this.f28978a);
        }
        this.f28985h = true;
        return this.f28978a;
    }
}

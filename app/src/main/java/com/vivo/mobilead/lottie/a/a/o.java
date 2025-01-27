package com.vivo.mobilead.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.vivo.mobilead.lottie.a.b.a;
import com.vivo.mobilead.lottie.c.b.q;
import java.util.List;

/* loaded from: classes4.dex */
public class o implements k, m, a.InterfaceC0598a {

    /* renamed from: c */
    private final String f29034c;

    /* renamed from: d */
    private final boolean f29035d;

    /* renamed from: e */
    private final com.vivo.mobilead.lottie.c f29036e;

    /* renamed from: f */
    private final com.vivo.mobilead.lottie.a.b.a<?, PointF> f29037f;

    /* renamed from: g */
    private final com.vivo.mobilead.lottie.a.b.a<?, PointF> f29038g;

    /* renamed from: h */
    private final com.vivo.mobilead.lottie.a.b.a<?, Float> f29039h;

    /* renamed from: j */
    private boolean f29041j;

    /* renamed from: a */
    private final Path f29032a = new Path();

    /* renamed from: b */
    private final RectF f29033b = new RectF();

    /* renamed from: i */
    private b f29040i = new b();

    public o(com.vivo.mobilead.lottie.c cVar, com.vivo.mobilead.lottie.c.c.a aVar, com.vivo.mobilead.lottie.c.b.j jVar) {
        this.f29034c = jVar.a();
        this.f29035d = jVar.e();
        this.f29036e = cVar;
        com.vivo.mobilead.lottie.a.b.a<PointF, PointF> a2 = jVar.d().a();
        this.f29037f = a2;
        com.vivo.mobilead.lottie.a.b.a<PointF, PointF> a3 = jVar.c().a();
        this.f29038g = a3;
        com.vivo.mobilead.lottie.a.b.a<Float, Float> a4 = jVar.b().a();
        this.f29039h = a4;
        aVar.a(a2);
        aVar.a(a3);
        aVar.a(a4);
        a2.a(this);
        a3.a(this);
        a4.a(this);
    }

    private void c() {
        this.f29041j = false;
        this.f29036e.invalidateSelf();
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
        com.vivo.mobilead.lottie.a.b.a aVar;
        if (t == com.vivo.mobilead.lottie.g.f29460h) {
            aVar = this.f29038g;
        } else if (t == com.vivo.mobilead.lottie.g.f29462j) {
            aVar = this.f29037f;
        } else if (t != com.vivo.mobilead.lottie.g.f29461i) {
            return;
        } else {
            aVar = this.f29039h;
        }
        aVar.a(cVar);
    }

    @Override // com.vivo.mobilead.lottie.a.a.c
    public void a(List<c> list, List<c> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            c cVar = list.get(i2);
            if (cVar instanceof s) {
                s sVar = (s) cVar;
                if (sVar.c() == q.a.SIMULTANEOUSLY) {
                    this.f29040i.a(sVar);
                    sVar.a(this);
                }
            }
        }
    }

    @Override // com.vivo.mobilead.lottie.a.a.c
    public String b() {
        return this.f29034c;
    }

    @Override // com.vivo.mobilead.lottie.a.a.m
    public Path e() {
        if (this.f29041j) {
            return this.f29032a;
        }
        this.f29032a.reset();
        if (!this.f29035d) {
            PointF g2 = this.f29038g.g();
            float f2 = g2.x / 2.0f;
            float f3 = g2.y / 2.0f;
            com.vivo.mobilead.lottie.a.b.a<?, Float> aVar = this.f29039h;
            float i2 = aVar == null ? 0.0f : ((com.vivo.mobilead.lottie.a.b.c) aVar).i();
            float min = Math.min(f2, f3);
            if (i2 > min) {
                i2 = min;
            }
            PointF g3 = this.f29037f.g();
            this.f29032a.moveTo(g3.x + f2, (g3.y - f3) + i2);
            this.f29032a.lineTo(g3.x + f2, (g3.y + f3) - i2);
            if (i2 > 0.0f) {
                RectF rectF = this.f29033b;
                float f4 = g3.x + f2;
                float f5 = i2 * 2.0f;
                float f6 = g3.y + f3;
                rectF.set(f4 - f5, f6 - f5, f4, f6);
                this.f29032a.arcTo(this.f29033b, 0.0f, 90.0f, false);
            }
            this.f29032a.lineTo((g3.x - f2) + i2, g3.y + f3);
            if (i2 > 0.0f) {
                RectF rectF2 = this.f29033b;
                float f7 = g3.x - f2;
                float f8 = g3.y + f3;
                float f9 = i2 * 2.0f;
                rectF2.set(f7, f8 - f9, f9 + f7, f8);
                this.f29032a.arcTo(this.f29033b, 90.0f, 90.0f, false);
            }
            this.f29032a.lineTo(g3.x - f2, (g3.y - f3) + i2);
            if (i2 > 0.0f) {
                RectF rectF3 = this.f29033b;
                float f10 = g3.x - f2;
                float f11 = g3.y - f3;
                float f12 = i2 * 2.0f;
                rectF3.set(f10, f11, f10 + f12, f12 + f11);
                this.f29032a.arcTo(this.f29033b, 180.0f, 90.0f, false);
            }
            this.f29032a.lineTo((g3.x + f2) - i2, g3.y - f3);
            if (i2 > 0.0f) {
                RectF rectF4 = this.f29033b;
                float f13 = g3.x + f2;
                float f14 = i2 * 2.0f;
                float f15 = g3.y - f3;
                rectF4.set(f13 - f14, f15, f13, f14 + f15);
                this.f29032a.arcTo(this.f29033b, 270.0f, 90.0f, false);
            }
            this.f29032a.close();
            this.f29040i.a(this.f29032a);
        }
        this.f29041j = true;
        return this.f29032a;
    }
}

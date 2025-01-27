package com.vivo.mobilead.lottie.a.a;

import android.graphics.Path;
import com.vivo.mobilead.lottie.a.b.a;
import com.vivo.mobilead.lottie.c.b.q;
import java.util.List;

/* loaded from: classes4.dex */
public class q implements m, a.InterfaceC0598a {

    /* renamed from: b */
    private final String f29053b;

    /* renamed from: c */
    private final boolean f29054c;

    /* renamed from: d */
    private final com.vivo.mobilead.lottie.c f29055d;

    /* renamed from: e */
    private final com.vivo.mobilead.lottie.a.b.a<?, Path> f29056e;

    /* renamed from: f */
    private boolean f29057f;

    /* renamed from: a */
    private final Path f29052a = new Path();

    /* renamed from: g */
    private b f29058g = new b();

    public q(com.vivo.mobilead.lottie.c cVar, com.vivo.mobilead.lottie.c.c.a aVar, com.vivo.mobilead.lottie.c.b.o oVar) {
        this.f29053b = oVar.a();
        this.f29054c = oVar.c();
        this.f29055d = cVar;
        com.vivo.mobilead.lottie.a.b.a<com.vivo.mobilead.lottie.c.b.l, Path> a2 = oVar.b().a();
        this.f29056e = a2;
        aVar.a(a2);
        a2.a(this);
    }

    private void c() {
        this.f29057f = false;
        this.f29055d.invalidateSelf();
    }

    @Override // com.vivo.mobilead.lottie.a.b.a.InterfaceC0598a
    public void a() {
        c();
    }

    @Override // com.vivo.mobilead.lottie.a.a.c
    public void a(List<c> list, List<c> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            c cVar = list.get(i2);
            if (cVar instanceof s) {
                s sVar = (s) cVar;
                if (sVar.c() == q.a.SIMULTANEOUSLY) {
                    this.f29058g.a(sVar);
                    sVar.a(this);
                }
            }
        }
    }

    @Override // com.vivo.mobilead.lottie.a.a.c
    public String b() {
        return this.f29053b;
    }

    @Override // com.vivo.mobilead.lottie.a.a.m
    public Path e() {
        if (this.f29057f) {
            return this.f29052a;
        }
        this.f29052a.reset();
        if (!this.f29054c) {
            this.f29052a.set(this.f29056e.g());
            this.f29052a.setFillType(Path.FillType.EVEN_ODD);
            this.f29058g.a(this.f29052a);
        }
        this.f29057f = true;
        return this.f29052a;
    }
}

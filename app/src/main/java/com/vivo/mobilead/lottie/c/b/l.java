package com.vivo.mobilead.lottie.c.b;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class l {

    /* renamed from: a */
    private final List<com.vivo.mobilead.lottie.c.a> f29275a;

    /* renamed from: b */
    private PointF f29276b;

    /* renamed from: c */
    private boolean f29277c;

    public l() {
        this.f29275a = new ArrayList();
    }

    public l(PointF pointF, boolean z, List<com.vivo.mobilead.lottie.c.a> list) {
        this.f29276b = pointF;
        this.f29277c = z;
        this.f29275a = new ArrayList(list);
    }

    private void a(float f2, float f3) {
        if (this.f29276b == null) {
            this.f29276b = new PointF();
        }
        this.f29276b.set(f2, f3);
    }

    public PointF a() {
        return this.f29276b;
    }

    public void a(l lVar, l lVar2, float f2) {
        if (this.f29276b == null) {
            this.f29276b = new PointF();
        }
        this.f29277c = lVar.b() || lVar2.b();
        if (lVar.c().size() != lVar2.c().size()) {
            com.vivo.mobilead.lottie.f.d.b("Curves must have the same number of control points. Shape 1: " + lVar.c().size() + "\tShape 2: " + lVar2.c().size());
        }
        int min = Math.min(lVar.c().size(), lVar2.c().size());
        if (this.f29275a.size() < min) {
            for (int size = this.f29275a.size(); size < min; size++) {
                this.f29275a.add(new com.vivo.mobilead.lottie.c.a());
            }
        } else if (this.f29275a.size() > min) {
            for (int size2 = this.f29275a.size() - 1; size2 >= min; size2--) {
                List<com.vivo.mobilead.lottie.c.a> list = this.f29275a;
                list.remove(list.size() - 1);
            }
        }
        PointF a2 = lVar.a();
        PointF a3 = lVar2.a();
        a(com.vivo.mobilead.lottie.f.g.a(a2.x, a3.x, f2), com.vivo.mobilead.lottie.f.g.a(a2.y, a3.y, f2));
        for (int size3 = this.f29275a.size() - 1; size3 >= 0; size3--) {
            com.vivo.mobilead.lottie.c.a aVar = lVar.c().get(size3);
            com.vivo.mobilead.lottie.c.a aVar2 = lVar2.c().get(size3);
            PointF a4 = aVar.a();
            PointF b2 = aVar.b();
            PointF c2 = aVar.c();
            PointF a5 = aVar2.a();
            PointF b3 = aVar2.b();
            PointF c3 = aVar2.c();
            this.f29275a.get(size3).a(com.vivo.mobilead.lottie.f.g.a(a4.x, a5.x, f2), com.vivo.mobilead.lottie.f.g.a(a4.y, a5.y, f2));
            this.f29275a.get(size3).b(com.vivo.mobilead.lottie.f.g.a(b2.x, b3.x, f2), com.vivo.mobilead.lottie.f.g.a(b2.y, b3.y, f2));
            this.f29275a.get(size3).c(com.vivo.mobilead.lottie.f.g.a(c2.x, c3.x, f2), com.vivo.mobilead.lottie.f.g.a(c2.y, c3.y, f2));
        }
    }

    public boolean b() {
        return this.f29277c;
    }

    public List<com.vivo.mobilead.lottie.c.a> c() {
        return this.f29275a;
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.f29275a.size() + "closed=" + this.f29277c + '}';
    }
}

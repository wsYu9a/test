package com.vivo.mobilead.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.LongSparseArray;
import com.vivo.mobilead.lottie.a.b.a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class h implements e, k, a.InterfaceC0598a {

    /* renamed from: a */
    private final String f28996a;

    /* renamed from: b */
    private final boolean f28997b;

    /* renamed from: c */
    private final com.vivo.mobilead.lottie.c.c.a f28998c;

    /* renamed from: d */
    private final LongSparseArray<LinearGradient> f28999d = new LongSparseArray<>();

    /* renamed from: e */
    private final LongSparseArray<RadialGradient> f29000e = new LongSparseArray<>();

    /* renamed from: f */
    private final Matrix f29001f = new Matrix();

    /* renamed from: g */
    private final Path f29002g;

    /* renamed from: h */
    private final Paint f29003h;

    /* renamed from: i */
    private final RectF f29004i;

    /* renamed from: j */
    private final List<m> f29005j;
    private final com.vivo.mobilead.lottie.c.b.f k;
    private final com.vivo.mobilead.lottie.a.b.a<com.vivo.mobilead.lottie.c.b.c, com.vivo.mobilead.lottie.c.b.c> l;
    private final com.vivo.mobilead.lottie.a.b.a<Integer, Integer> m;
    private final com.vivo.mobilead.lottie.a.b.a<PointF, PointF> n;
    private final com.vivo.mobilead.lottie.a.b.a<PointF, PointF> o;
    private com.vivo.mobilead.lottie.a.b.a<ColorFilter, ColorFilter> p;
    private com.vivo.mobilead.lottie.a.b.p q;
    private final com.vivo.mobilead.lottie.c r;
    private final int s;

    public h(com.vivo.mobilead.lottie.c cVar, com.vivo.mobilead.lottie.c.c.a aVar, com.vivo.mobilead.lottie.c.b.d dVar) {
        Path path = new Path();
        this.f29002g = path;
        this.f29003h = new com.vivo.mobilead.lottie.a.a(1);
        this.f29004i = new RectF();
        this.f29005j = new ArrayList();
        this.f28998c = aVar;
        this.f28996a = dVar.a();
        this.f28997b = dVar.h();
        this.r = cVar;
        this.k = dVar.b();
        path.setFillType(dVar.c());
        this.s = (int) (cVar.x().getDuration() / 32.0f);
        com.vivo.mobilead.lottie.a.b.a<com.vivo.mobilead.lottie.c.b.c, com.vivo.mobilead.lottie.c.b.c> a2 = dVar.d().a();
        this.l = a2;
        a2.a(this);
        aVar.a(a2);
        com.vivo.mobilead.lottie.a.b.a<Integer, Integer> a3 = dVar.e().a();
        this.m = a3;
        a3.a(this);
        aVar.a(a3);
        com.vivo.mobilead.lottie.a.b.a<PointF, PointF> a4 = dVar.f().a();
        this.n = a4;
        a4.a(this);
        aVar.a(a4);
        com.vivo.mobilead.lottie.a.b.a<PointF, PointF> a5 = dVar.g().a();
        this.o = a5;
        a5.a(this);
        aVar.a(a5);
    }

    private int[] a(int[] iArr) {
        com.vivo.mobilead.lottie.a.b.p pVar = this.q;
        if (pVar != null) {
            Integer[] numArr = (Integer[]) pVar.g();
            int i2 = 0;
            if (iArr.length == numArr.length) {
                while (i2 < iArr.length) {
                    iArr[i2] = numArr[i2].intValue();
                    i2++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i2 < numArr.length) {
                    iArr[i2] = numArr[i2].intValue();
                    i2++;
                }
            }
        }
        return iArr;
    }

    private LinearGradient c() {
        long e2 = e();
        LinearGradient linearGradient = this.f28999d.get(e2);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF g2 = this.n.g();
        PointF g3 = this.o.g();
        com.vivo.mobilead.lottie.c.b.c g4 = this.l.g();
        LinearGradient linearGradient2 = new LinearGradient(g2.x, g2.y, g3.x, g3.y, a(g4.b()), g4.a(), Shader.TileMode.CLAMP);
        this.f28999d.put(e2, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient d() {
        long e2 = e();
        RadialGradient radialGradient = this.f29000e.get(e2);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF g2 = this.n.g();
        PointF g3 = this.o.g();
        com.vivo.mobilead.lottie.c.b.c g4 = this.l.g();
        int[] a2 = a(g4.b());
        float[] a3 = g4.a();
        float f2 = g2.x;
        float f3 = g2.y;
        float hypot = (float) Math.hypot(g3.x - f2, g3.y - f3);
        RadialGradient radialGradient2 = new RadialGradient(f2, f3, hypot <= 0.0f ? 0.001f : hypot, a2, a3, Shader.TileMode.CLAMP);
        this.f29000e.put(e2, radialGradient2);
        return radialGradient2;
    }

    private int e() {
        int round = Math.round(this.n.h() * this.s);
        int round2 = Math.round(this.o.h() * this.s);
        int round3 = Math.round(this.l.h() * this.s);
        int i2 = round != 0 ? round * 527 : 17;
        if (round2 != 0) {
            i2 = i2 * 31 * round2;
        }
        return round3 != 0 ? i2 * 31 * round3 : i2;
    }

    @Override // com.vivo.mobilead.lottie.a.b.a.InterfaceC0598a
    public void a() {
        this.r.invalidateSelf();
    }

    @Override // com.vivo.mobilead.lottie.a.a.e
    public void a(Canvas canvas, Matrix matrix, int i2) {
        if (this.f28997b) {
            return;
        }
        com.vivo.mobilead.lottie.b.a("GradientFillContent#draw");
        this.f29002g.reset();
        for (int i3 = 0; i3 < this.f29005j.size(); i3++) {
            this.f29002g.addPath(this.f29005j.get(i3).e(), matrix);
        }
        this.f29002g.computeBounds(this.f29004i, false);
        Shader c2 = this.k == com.vivo.mobilead.lottie.c.b.f.LINEAR ? c() : d();
        this.f29001f.set(matrix);
        c2.setLocalMatrix(this.f29001f);
        this.f29003h.setShader(c2);
        com.vivo.mobilead.lottie.a.b.a<ColorFilter, ColorFilter> aVar = this.p;
        if (aVar != null) {
            this.f29003h.setColorFilter(aVar.g());
        }
        this.f29003h.setAlpha(com.vivo.mobilead.lottie.f.g.a((int) ((((i2 / 255.0f) * this.m.g().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.f29002g, this.f29003h);
        com.vivo.mobilead.lottie.b.b("GradientFillContent#draw");
    }

    @Override // com.vivo.mobilead.lottie.a.a.e
    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.f29002g.reset();
        for (int i2 = 0; i2 < this.f29005j.size(); i2++) {
            this.f29002g.addPath(this.f29005j.get(i2).e(), matrix);
        }
        this.f29002g.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.vivo.mobilead.lottie.c.f
    public void a(com.vivo.mobilead.lottie.c.e eVar, int i2, List<com.vivo.mobilead.lottie.c.e> list, com.vivo.mobilead.lottie.c.e eVar2) {
        com.vivo.mobilead.lottie.f.g.a(eVar, i2, list, eVar2, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.vivo.mobilead.lottie.c.f
    public <T> void a(T t, com.vivo.mobilead.lottie.g.c<T> cVar) {
        com.vivo.mobilead.lottie.c.c.a aVar;
        com.vivo.mobilead.lottie.a.b.a<?, ?> aVar2;
        if (t == com.vivo.mobilead.lottie.g.f29456d) {
            this.m.a((com.vivo.mobilead.lottie.g.c<Integer>) cVar);
            return;
        }
        if (t == com.vivo.mobilead.lottie.g.B) {
            if (cVar == null) {
                this.p = null;
                return;
            }
            com.vivo.mobilead.lottie.a.b.p pVar = new com.vivo.mobilead.lottie.a.b.p(cVar);
            this.p = pVar;
            pVar.a(this);
            aVar = this.f28998c;
            aVar2 = this.p;
        } else {
            if (t != com.vivo.mobilead.lottie.g.C) {
                return;
            }
            if (cVar == null) {
                com.vivo.mobilead.lottie.a.b.p pVar2 = this.q;
                if (pVar2 != null) {
                    this.f28998c.b(pVar2);
                }
                this.q = null;
                return;
            }
            com.vivo.mobilead.lottie.a.b.p pVar3 = new com.vivo.mobilead.lottie.a.b.p(cVar);
            this.q = pVar3;
            pVar3.a(this);
            aVar = this.f28998c;
            aVar2 = this.q;
        }
        aVar.a(aVar2);
    }

    @Override // com.vivo.mobilead.lottie.a.a.c
    public void a(List<c> list, List<c> list2) {
        for (int i2 = 0; i2 < list2.size(); i2++) {
            c cVar = list2.get(i2);
            if (cVar instanceof m) {
                this.f29005j.add((m) cVar);
            }
        }
    }

    @Override // com.vivo.mobilead.lottie.a.a.c
    public String b() {
        return this.f28996a;
    }
}

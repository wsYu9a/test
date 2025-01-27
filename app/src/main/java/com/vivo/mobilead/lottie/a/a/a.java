package com.vivo.mobilead.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.vivo.mobilead.lottie.a.b.a;
import com.vivo.mobilead.lottie.c.b.q;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class a implements e, k, a.InterfaceC0598a {

    /* renamed from: a */
    protected final com.vivo.mobilead.lottie.c.c.a f28956a;

    /* renamed from: b */
    final Paint f28957b;

    /* renamed from: g */
    private final com.vivo.mobilead.lottie.c f28962g;

    /* renamed from: i */
    private final float[] f28964i;

    /* renamed from: j */
    private final com.vivo.mobilead.lottie.a.b.a<?, Float> f28965j;
    private final com.vivo.mobilead.lottie.a.b.a<?, Integer> k;
    private final List<com.vivo.mobilead.lottie.a.b.a<?, Float>> l;
    private final com.vivo.mobilead.lottie.a.b.a<?, Float> m;
    private com.vivo.mobilead.lottie.a.b.a<ColorFilter, ColorFilter> n;

    /* renamed from: c */
    private final PathMeasure f28958c = new PathMeasure();

    /* renamed from: d */
    private final Path f28959d = new Path();

    /* renamed from: e */
    private final Path f28960e = new Path();

    /* renamed from: f */
    private final RectF f28961f = new RectF();

    /* renamed from: h */
    private final List<C0597a> f28963h = new ArrayList();

    /* renamed from: com.vivo.mobilead.lottie.a.a.a$a */
    private static final class C0597a {

        /* renamed from: a */
        private final List<m> f28966a;

        /* renamed from: b */
        private final s f28967b;

        private C0597a(s sVar) {
            this.f28966a = new ArrayList();
            this.f28967b = sVar;
        }

        /* synthetic */ C0597a(s sVar, AnonymousClass1 anonymousClass1) {
            this(sVar);
        }
    }

    a(com.vivo.mobilead.lottie.c cVar, com.vivo.mobilead.lottie.c.c.a aVar, Paint.Cap cap, Paint.Join join, float f2, com.vivo.mobilead.lottie.c.a.d dVar, com.vivo.mobilead.lottie.c.a.b bVar, List<com.vivo.mobilead.lottie.c.a.b> list, com.vivo.mobilead.lottie.c.a.b bVar2) {
        com.vivo.mobilead.lottie.a.a aVar2 = new com.vivo.mobilead.lottie.a.a(1);
        this.f28957b = aVar2;
        this.f28962g = cVar;
        this.f28956a = aVar;
        aVar2.setStyle(Paint.Style.STROKE);
        aVar2.setStrokeCap(cap);
        aVar2.setStrokeJoin(join);
        aVar2.setStrokeMiter(f2);
        this.k = dVar.a();
        this.f28965j = bVar.a();
        this.m = bVar2 == null ? null : bVar2.a();
        this.l = new ArrayList(list.size());
        this.f28964i = new float[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.l.add(list.get(i2).a());
        }
        aVar.a(this.k);
        aVar.a(this.f28965j);
        for (int i3 = 0; i3 < this.l.size(); i3++) {
            aVar.a(this.l.get(i3));
        }
        com.vivo.mobilead.lottie.a.b.a<?, Float> aVar3 = this.m;
        if (aVar3 != null) {
            aVar.a(aVar3);
        }
        this.k.a(this);
        this.f28965j.a(this);
        for (int i4 = 0; i4 < list.size(); i4++) {
            this.l.get(i4).a(this);
        }
        com.vivo.mobilead.lottie.a.b.a<?, Float> aVar4 = this.m;
        if (aVar4 != null) {
            aVar4.a(this);
        }
    }

    private void a(Canvas canvas, C0597a c0597a, Matrix matrix) {
        float f2;
        com.vivo.mobilead.lottie.b.a("StrokeContent#applyTrimPath");
        if (c0597a.f28967b == null) {
            com.vivo.mobilead.lottie.b.b("StrokeContent#applyTrimPath");
            return;
        }
        this.f28959d.reset();
        for (int size = c0597a.f28966a.size() - 1; size >= 0; size--) {
            this.f28959d.addPath(((m) c0597a.f28966a.get(size)).e(), matrix);
        }
        this.f28958c.setPath(this.f28959d, false);
        float length = this.f28958c.getLength();
        while (this.f28958c.nextContour()) {
            length += this.f28958c.getLength();
        }
        float floatValue = (c0597a.f28967b.f().g().floatValue() * length) / 360.0f;
        float floatValue2 = ((c0597a.f28967b.d().g().floatValue() * length) / 100.0f) + floatValue;
        float floatValue3 = ((c0597a.f28967b.e().g().floatValue() * length) / 100.0f) + floatValue;
        float f3 = 0.0f;
        for (int size2 = c0597a.f28966a.size() - 1; size2 >= 0; size2--) {
            this.f28960e.set(((m) c0597a.f28966a.get(size2)).e());
            this.f28960e.transform(matrix);
            this.f28958c.setPath(this.f28960e, false);
            float length2 = this.f28958c.getLength();
            float f4 = 1.0f;
            if (floatValue3 > length) {
                float f5 = floatValue3 - length;
                if (f5 < f3 + length2 && f3 < f5) {
                    f2 = floatValue2 > length ? (floatValue2 - length) / length2 : 0.0f;
                    f4 = Math.min(f5 / length2, 1.0f);
                    com.vivo.mobilead.lottie.f.h.a(this.f28960e, f2, f4, 0.0f);
                    canvas.drawPath(this.f28960e, this.f28957b);
                    f3 += length2;
                }
            }
            float f6 = f3 + length2;
            if (f6 >= floatValue2 && f3 <= floatValue3) {
                if (f6 > floatValue3 || floatValue2 >= f3) {
                    f2 = floatValue2 < f3 ? 0.0f : (floatValue2 - f3) / length2;
                    if (floatValue3 <= f6) {
                        f4 = (floatValue3 - f3) / length2;
                    }
                    com.vivo.mobilead.lottie.f.h.a(this.f28960e, f2, f4, 0.0f);
                }
                canvas.drawPath(this.f28960e, this.f28957b);
            }
            f3 += length2;
        }
        com.vivo.mobilead.lottie.b.b("StrokeContent#applyTrimPath");
    }

    private void a(Matrix matrix) {
        com.vivo.mobilead.lottie.b.a("StrokeContent#applyDashPattern");
        if (this.l.isEmpty()) {
            com.vivo.mobilead.lottie.b.b("StrokeContent#applyDashPattern");
            return;
        }
        float a2 = com.vivo.mobilead.lottie.f.h.a(matrix);
        for (int i2 = 0; i2 < this.l.size(); i2++) {
            this.f28964i[i2] = this.l.get(i2).g().floatValue();
            if (i2 % 2 == 0) {
                float[] fArr = this.f28964i;
                if (fArr[i2] < 1.0f) {
                    fArr[i2] = 1.0f;
                }
            } else {
                float[] fArr2 = this.f28964i;
                if (fArr2[i2] < 0.1f) {
                    fArr2[i2] = 0.1f;
                }
            }
            float[] fArr3 = this.f28964i;
            fArr3[i2] = fArr3[i2] * a2;
        }
        com.vivo.mobilead.lottie.a.b.a<?, Float> aVar = this.m;
        this.f28957b.setPathEffect(new DashPathEffect(this.f28964i, aVar == null ? 0.0f : aVar.g().floatValue()));
        com.vivo.mobilead.lottie.b.b("StrokeContent#applyDashPattern");
    }

    @Override // com.vivo.mobilead.lottie.a.b.a.InterfaceC0598a
    public void a() {
        this.f28962g.invalidateSelf();
    }

    @Override // com.vivo.mobilead.lottie.a.a.e
    public void a(Canvas canvas, Matrix matrix, int i2) {
        com.vivo.mobilead.lottie.b.a("StrokeContent#draw");
        if (com.vivo.mobilead.lottie.f.h.b(matrix)) {
            com.vivo.mobilead.lottie.b.b("StrokeContent#draw");
            return;
        }
        this.f28957b.setAlpha(com.vivo.mobilead.lottie.f.g.a((int) ((((i2 / 255.0f) * ((com.vivo.mobilead.lottie.a.b.e) this.k).i()) / 100.0f) * 255.0f), 0, 255));
        this.f28957b.setStrokeWidth(((com.vivo.mobilead.lottie.a.b.c) this.f28965j).i() * com.vivo.mobilead.lottie.f.h.a(matrix));
        if (this.f28957b.getStrokeWidth() <= 0.0f) {
            com.vivo.mobilead.lottie.b.b("StrokeContent#draw");
            return;
        }
        a(matrix);
        com.vivo.mobilead.lottie.a.b.a<ColorFilter, ColorFilter> aVar = this.n;
        if (aVar != null) {
            this.f28957b.setColorFilter(aVar.g());
        }
        for (int i3 = 0; i3 < this.f28963h.size(); i3++) {
            C0597a c0597a = this.f28963h.get(i3);
            if (c0597a.f28967b != null) {
                a(canvas, c0597a, matrix);
            } else {
                com.vivo.mobilead.lottie.b.a("StrokeContent#buildPath");
                this.f28959d.reset();
                for (int size = c0597a.f28966a.size() - 1; size >= 0; size--) {
                    this.f28959d.addPath(((m) c0597a.f28966a.get(size)).e(), matrix);
                }
                com.vivo.mobilead.lottie.b.b("StrokeContent#buildPath");
                com.vivo.mobilead.lottie.b.a("StrokeContent#drawPath");
                canvas.drawPath(this.f28959d, this.f28957b);
                com.vivo.mobilead.lottie.b.b("StrokeContent#drawPath");
            }
        }
        com.vivo.mobilead.lottie.b.b("StrokeContent#draw");
    }

    @Override // com.vivo.mobilead.lottie.a.a.e
    public void a(RectF rectF, Matrix matrix, boolean z) {
        com.vivo.mobilead.lottie.b.a("StrokeContent#getBounds");
        this.f28959d.reset();
        for (int i2 = 0; i2 < this.f28963h.size(); i2++) {
            C0597a c0597a = this.f28963h.get(i2);
            for (int i3 = 0; i3 < c0597a.f28966a.size(); i3++) {
                this.f28959d.addPath(((m) c0597a.f28966a.get(i3)).e(), matrix);
            }
        }
        this.f28959d.computeBounds(this.f28961f, false);
        float i4 = ((com.vivo.mobilead.lottie.a.b.c) this.f28965j).i();
        RectF rectF2 = this.f28961f;
        float f2 = i4 / 2.0f;
        rectF2.set(rectF2.left - f2, rectF2.top - f2, rectF2.right + f2, rectF2.bottom + f2);
        rectF.set(this.f28961f);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.vivo.mobilead.lottie.b.b("StrokeContent#getBounds");
    }

    @Override // com.vivo.mobilead.lottie.c.f
    public void a(com.vivo.mobilead.lottie.c.e eVar, int i2, List<com.vivo.mobilead.lottie.c.e> list, com.vivo.mobilead.lottie.c.e eVar2) {
        com.vivo.mobilead.lottie.f.g.a(eVar, i2, list, eVar2, this);
    }

    @Override // com.vivo.mobilead.lottie.c.f
    public <T> void a(T t, com.vivo.mobilead.lottie.g.c<T> cVar) {
        com.vivo.mobilead.lottie.a.b.a aVar;
        if (t == com.vivo.mobilead.lottie.g.f29456d) {
            aVar = this.k;
        } else {
            if (t != com.vivo.mobilead.lottie.g.o) {
                if (t == com.vivo.mobilead.lottie.g.B) {
                    if (cVar == null) {
                        this.n = null;
                        return;
                    }
                    com.vivo.mobilead.lottie.a.b.p pVar = new com.vivo.mobilead.lottie.a.b.p(cVar);
                    this.n = pVar;
                    pVar.a(this);
                    this.f28956a.a(this.n);
                    return;
                }
                return;
            }
            aVar = this.f28965j;
        }
        aVar.a(cVar);
    }

    @Override // com.vivo.mobilead.lottie.a.a.c
    public void a(List<c> list, List<c> list2) {
        s sVar = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            c cVar = list.get(size);
            if (cVar instanceof s) {
                s sVar2 = (s) cVar;
                if (sVar2.c() == q.a.INDIVIDUALLY) {
                    sVar = sVar2;
                }
            }
        }
        if (sVar != null) {
            sVar.a(this);
        }
        C0597a c0597a = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            c cVar2 = list2.get(size2);
            if (cVar2 instanceof s) {
                s sVar3 = (s) cVar2;
                if (sVar3.c() == q.a.INDIVIDUALLY) {
                    if (c0597a != null) {
                        this.f28963h.add(c0597a);
                    }
                    c0597a = new C0597a(sVar3);
                    sVar3.a(this);
                }
            }
            if (cVar2 instanceof m) {
                if (c0597a == null) {
                    c0597a = new C0597a(sVar);
                }
                c0597a.f28966a.add((m) cVar2);
            }
        }
        if (c0597a != null) {
            this.f28963h.add(c0597a);
        }
    }
}

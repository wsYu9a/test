package com.vivo.mobilead.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.vivo.mobilead.lottie.a.b.a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class g implements e, k, a.InterfaceC0598a {

    /* renamed from: a */
    private final Path f28986a;

    /* renamed from: b */
    private final Paint f28987b;

    /* renamed from: c */
    private final com.vivo.mobilead.lottie.c.c.a f28988c;

    /* renamed from: d */
    private final String f28989d;

    /* renamed from: e */
    private final boolean f28990e;

    /* renamed from: f */
    private final List<m> f28991f;

    /* renamed from: g */
    private final com.vivo.mobilead.lottie.a.b.a<Integer, Integer> f28992g;

    /* renamed from: h */
    private final com.vivo.mobilead.lottie.a.b.a<Integer, Integer> f28993h;

    /* renamed from: i */
    private com.vivo.mobilead.lottie.a.b.a<ColorFilter, ColorFilter> f28994i;

    /* renamed from: j */
    private final com.vivo.mobilead.lottie.c f28995j;

    public g(com.vivo.mobilead.lottie.c cVar, com.vivo.mobilead.lottie.c.c.a aVar, com.vivo.mobilead.lottie.c.b.m mVar) {
        Path path = new Path();
        this.f28986a = path;
        this.f28987b = new com.vivo.mobilead.lottie.a.a(1);
        this.f28991f = new ArrayList();
        this.f28988c = aVar;
        this.f28989d = mVar.a();
        this.f28990e = mVar.e();
        this.f28995j = cVar;
        if (mVar.b() == null || mVar.c() == null) {
            this.f28992g = null;
            this.f28993h = null;
            return;
        }
        path.setFillType(mVar.d());
        com.vivo.mobilead.lottie.a.b.a<Integer, Integer> a2 = mVar.b().a();
        this.f28992g = a2;
        a2.a(this);
        aVar.a(a2);
        com.vivo.mobilead.lottie.a.b.a<Integer, Integer> a3 = mVar.c().a();
        this.f28993h = a3;
        a3.a(this);
        aVar.a(a3);
    }

    @Override // com.vivo.mobilead.lottie.a.b.a.InterfaceC0598a
    public void a() {
        this.f28995j.invalidateSelf();
    }

    @Override // com.vivo.mobilead.lottie.a.a.e
    public void a(Canvas canvas, Matrix matrix, int i2) {
        if (this.f28990e) {
            return;
        }
        com.vivo.mobilead.lottie.b.a("FillContent#draw");
        this.f28987b.setColor(((com.vivo.mobilead.lottie.a.b.b) this.f28992g).i());
        this.f28987b.setAlpha(com.vivo.mobilead.lottie.f.g.a((int) ((((i2 / 255.0f) * this.f28993h.g().intValue()) / 100.0f) * 255.0f), 0, 255));
        com.vivo.mobilead.lottie.a.b.a<ColorFilter, ColorFilter> aVar = this.f28994i;
        if (aVar != null) {
            this.f28987b.setColorFilter(aVar.g());
        }
        this.f28986a.reset();
        for (int i3 = 0; i3 < this.f28991f.size(); i3++) {
            this.f28986a.addPath(this.f28991f.get(i3).e(), matrix);
        }
        canvas.drawPath(this.f28986a, this.f28987b);
        com.vivo.mobilead.lottie.b.b("FillContent#draw");
    }

    @Override // com.vivo.mobilead.lottie.a.a.e
    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.f28986a.reset();
        for (int i2 = 0; i2 < this.f28991f.size(); i2++) {
            this.f28986a.addPath(this.f28991f.get(i2).e(), matrix);
        }
        this.f28986a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.vivo.mobilead.lottie.c.f
    public void a(com.vivo.mobilead.lottie.c.e eVar, int i2, List<com.vivo.mobilead.lottie.c.e> list, com.vivo.mobilead.lottie.c.e eVar2) {
        com.vivo.mobilead.lottie.f.g.a(eVar, i2, list, eVar2, this);
    }

    @Override // com.vivo.mobilead.lottie.c.f
    public <T> void a(T t, com.vivo.mobilead.lottie.g.c<T> cVar) {
        com.vivo.mobilead.lottie.a.b.a<Integer, Integer> aVar;
        if (t == com.vivo.mobilead.lottie.g.f29453a) {
            aVar = this.f28992g;
        } else {
            if (t != com.vivo.mobilead.lottie.g.f29456d) {
                if (t == com.vivo.mobilead.lottie.g.B) {
                    if (cVar == null) {
                        this.f28994i = null;
                        return;
                    }
                    com.vivo.mobilead.lottie.a.b.p pVar = new com.vivo.mobilead.lottie.a.b.p(cVar);
                    this.f28994i = pVar;
                    pVar.a(this);
                    this.f28988c.a(this.f28994i);
                    return;
                }
                return;
            }
            aVar = this.f28993h;
        }
        aVar.a((com.vivo.mobilead.lottie.g.c<Integer>) cVar);
    }

    @Override // com.vivo.mobilead.lottie.a.a.c
    public void a(List<c> list, List<c> list2) {
        for (int i2 = 0; i2 < list2.size(); i2++) {
            c cVar = list2.get(i2);
            if (cVar instanceof m) {
                this.f28991f.add((m) cVar);
            }
        }
    }

    @Override // com.vivo.mobilead.lottie.a.a.c
    public String b() {
        return this.f28989d;
    }
}

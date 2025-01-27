package com.vivo.mobilead.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.vivo.mobilead.lottie.a.b.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes4.dex */
public class p implements e, j, k, m, a.InterfaceC0598a {

    /* renamed from: a */
    private final Matrix f29042a = new Matrix();

    /* renamed from: b */
    private final Path f29043b = new Path();

    /* renamed from: c */
    private final com.vivo.mobilead.lottie.c f29044c;

    /* renamed from: d */
    private final com.vivo.mobilead.lottie.c.c.a f29045d;

    /* renamed from: e */
    private final String f29046e;

    /* renamed from: f */
    private final boolean f29047f;

    /* renamed from: g */
    private final com.vivo.mobilead.lottie.a.b.a<Float, Float> f29048g;

    /* renamed from: h */
    private final com.vivo.mobilead.lottie.a.b.a<Float, Float> f29049h;

    /* renamed from: i */
    private final com.vivo.mobilead.lottie.a.b.o f29050i;

    /* renamed from: j */
    private d f29051j;

    public p(com.vivo.mobilead.lottie.c cVar, com.vivo.mobilead.lottie.c.c.a aVar, com.vivo.mobilead.lottie.c.b.k kVar) {
        this.f29044c = cVar;
        this.f29045d = aVar;
        this.f29046e = kVar.a();
        this.f29047f = kVar.e();
        com.vivo.mobilead.lottie.a.b.a<Float, Float> a2 = kVar.b().a();
        this.f29048g = a2;
        aVar.a(a2);
        a2.a(this);
        com.vivo.mobilead.lottie.a.b.a<Float, Float> a3 = kVar.c().a();
        this.f29049h = a3;
        aVar.a(a3);
        a3.a(this);
        com.vivo.mobilead.lottie.a.b.o j2 = kVar.d().j();
        this.f29050i = j2;
        j2.a(aVar);
        j2.a(this);
    }

    @Override // com.vivo.mobilead.lottie.a.b.a.InterfaceC0598a
    public void a() {
        this.f29044c.invalidateSelf();
    }

    @Override // com.vivo.mobilead.lottie.a.a.e
    public void a(Canvas canvas, Matrix matrix, int i2) {
        float floatValue = this.f29048g.g().floatValue();
        float floatValue2 = this.f29049h.g().floatValue();
        float floatValue3 = this.f29050i.b().g().floatValue() / 100.0f;
        float floatValue4 = this.f29050i.c().g().floatValue() / 100.0f;
        for (int i3 = ((int) floatValue) - 1; i3 >= 0; i3--) {
            this.f29042a.set(matrix);
            float f2 = i3;
            this.f29042a.preConcat(this.f29050i.b(f2 + floatValue2));
            this.f29051j.a(canvas, this.f29042a, (int) (i2 * com.vivo.mobilead.lottie.f.g.a(floatValue3, floatValue4, f2 / floatValue)));
        }
    }

    @Override // com.vivo.mobilead.lottie.a.a.e
    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.f29051j.a(rectF, matrix, z);
    }

    @Override // com.vivo.mobilead.lottie.c.f
    public void a(com.vivo.mobilead.lottie.c.e eVar, int i2, List<com.vivo.mobilead.lottie.c.e> list, com.vivo.mobilead.lottie.c.e eVar2) {
        com.vivo.mobilead.lottie.f.g.a(eVar, i2, list, eVar2, this);
    }

    @Override // com.vivo.mobilead.lottie.c.f
    public <T> void a(T t, com.vivo.mobilead.lottie.g.c<T> cVar) {
        com.vivo.mobilead.lottie.a.b.a<Float, Float> aVar;
        if (this.f29050i.a(t, cVar)) {
            return;
        }
        if (t == com.vivo.mobilead.lottie.g.q) {
            aVar = this.f29048g;
        } else if (t != com.vivo.mobilead.lottie.g.r) {
            return;
        } else {
            aVar = this.f29049h;
        }
        aVar.a((com.vivo.mobilead.lottie.g.c<Float>) cVar);
    }

    @Override // com.vivo.mobilead.lottie.a.a.c
    public void a(List<c> list, List<c> list2) {
        this.f29051j.a(list, list2);
    }

    @Override // com.vivo.mobilead.lottie.a.a.j
    public void a(ListIterator<c> listIterator) {
        if (this.f29051j != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.f29051j = new d(this.f29044c, this.f29045d, "Repeater", this.f29047f, arrayList, null);
    }

    @Override // com.vivo.mobilead.lottie.a.a.c
    public String b() {
        return this.f29046e;
    }

    @Override // com.vivo.mobilead.lottie.a.a.m
    public Path e() {
        Path e2 = this.f29051j.e();
        this.f29043b.reset();
        float floatValue = this.f29048g.g().floatValue();
        float floatValue2 = this.f29049h.g().floatValue();
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.f29042a.set(this.f29050i.b(i2 + floatValue2));
            this.f29043b.addPath(e2, this.f29042a);
        }
        return this.f29043b;
    }
}

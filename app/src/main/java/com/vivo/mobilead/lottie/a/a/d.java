package com.vivo.mobilead.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.vivo.mobilead.lottie.a.b.a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class d implements e, m, a.InterfaceC0598a, com.vivo.mobilead.lottie.c.f {

    /* renamed from: a */
    private final Matrix f28969a;

    /* renamed from: b */
    private final Path f28970b;

    /* renamed from: c */
    private final RectF f28971c;

    /* renamed from: d */
    private final String f28972d;

    /* renamed from: e */
    private final boolean f28973e;

    /* renamed from: f */
    private final List<c> f28974f;

    /* renamed from: g */
    private final com.vivo.mobilead.lottie.c f28975g;

    /* renamed from: h */
    private List<m> f28976h;

    /* renamed from: i */
    private com.vivo.mobilead.lottie.a.b.o f28977i;

    public d(com.vivo.mobilead.lottie.c cVar, com.vivo.mobilead.lottie.c.c.a aVar, com.vivo.mobilead.lottie.c.b.n nVar) {
        this(cVar, aVar, nVar.a(), nVar.c(), a(cVar, aVar, nVar.b()), a(nVar.b()));
    }

    d(com.vivo.mobilead.lottie.c cVar, com.vivo.mobilead.lottie.c.c.a aVar, String str, boolean z, List<c> list, com.vivo.mobilead.lottie.c.a.l lVar) {
        this.f28969a = new Matrix();
        this.f28970b = new Path();
        this.f28971c = new RectF();
        this.f28972d = str;
        this.f28975g = cVar;
        this.f28973e = z;
        this.f28974f = list;
        if (lVar != null) {
            com.vivo.mobilead.lottie.a.b.o j2 = lVar.j();
            this.f28977i = j2;
            j2.a(aVar);
            this.f28977i.a(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            c cVar2 = list.get(size);
            if (cVar2 instanceof j) {
                arrayList.add((j) cVar2);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((j) arrayList.get(size2)).a(list.listIterator(list.size()));
        }
    }

    static com.vivo.mobilead.lottie.c.a.l a(List<com.vivo.mobilead.lottie.c.b.b> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            com.vivo.mobilead.lottie.c.b.b bVar = list.get(i2);
            if (bVar instanceof com.vivo.mobilead.lottie.c.a.l) {
                return (com.vivo.mobilead.lottie.c.a.l) bVar;
            }
        }
        return null;
    }

    private static List<c> a(com.vivo.mobilead.lottie.c cVar, com.vivo.mobilead.lottie.c.c.a aVar, List<com.vivo.mobilead.lottie.c.b.b> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            c a2 = list.get(i2).a(cVar, aVar);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    @Override // com.vivo.mobilead.lottie.a.b.a.InterfaceC0598a
    public void a() {
        this.f28975g.invalidateSelf();
    }

    @Override // com.vivo.mobilead.lottie.a.a.e
    public void a(Canvas canvas, Matrix matrix, int i2) {
        if (this.f28973e) {
            return;
        }
        this.f28969a.set(matrix);
        com.vivo.mobilead.lottie.a.b.o oVar = this.f28977i;
        if (oVar != null) {
            this.f28969a.preConcat(oVar.d());
            i2 = (int) (((((this.f28977i.a() == null ? 100 : this.f28977i.a().g().intValue()) / 100.0f) * i2) / 255.0f) * 255.0f);
        }
        for (int size = this.f28974f.size() - 1; size >= 0; size--) {
            c cVar = this.f28974f.get(size);
            if (cVar instanceof e) {
                ((e) cVar).a(canvas, this.f28969a, i2);
            }
        }
    }

    @Override // com.vivo.mobilead.lottie.a.a.e
    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.f28969a.set(matrix);
        com.vivo.mobilead.lottie.a.b.o oVar = this.f28977i;
        if (oVar != null) {
            this.f28969a.preConcat(oVar.d());
        }
        this.f28971c.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f28974f.size() - 1; size >= 0; size--) {
            c cVar = this.f28974f.get(size);
            if (cVar instanceof e) {
                ((e) cVar).a(this.f28971c, this.f28969a, z);
                rectF.union(this.f28971c);
            }
        }
    }

    @Override // com.vivo.mobilead.lottie.c.f
    public void a(com.vivo.mobilead.lottie.c.e eVar, int i2, List<com.vivo.mobilead.lottie.c.e> list, com.vivo.mobilead.lottie.c.e eVar2) {
        if (eVar.a(b(), i2)) {
            if (!"__container".equals(b())) {
                eVar2 = eVar2.a(b());
                if (eVar.c(b(), i2)) {
                    list.add(eVar2.a(this));
                }
            }
            if (eVar.d(b(), i2)) {
                int b2 = i2 + eVar.b(b(), i2);
                for (int i3 = 0; i3 < this.f28974f.size(); i3++) {
                    c cVar = this.f28974f.get(i3);
                    if (cVar instanceof com.vivo.mobilead.lottie.c.f) {
                        ((com.vivo.mobilead.lottie.c.f) cVar).a(eVar, b2, list, eVar2);
                    }
                }
            }
        }
    }

    @Override // com.vivo.mobilead.lottie.c.f
    public <T> void a(T t, com.vivo.mobilead.lottie.g.c<T> cVar) {
        com.vivo.mobilead.lottie.a.b.o oVar = this.f28977i;
        if (oVar != null) {
            oVar.a(t, cVar);
        }
    }

    @Override // com.vivo.mobilead.lottie.a.a.c
    public void a(List<c> list, List<c> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.f28974f.size());
        arrayList.addAll(list);
        for (int size = this.f28974f.size() - 1; size >= 0; size--) {
            c cVar = this.f28974f.get(size);
            cVar.a(arrayList, this.f28974f.subList(0, size));
            arrayList.add(cVar);
        }
    }

    @Override // com.vivo.mobilead.lottie.a.a.c
    public String b() {
        return this.f28972d;
    }

    List<m> c() {
        if (this.f28976h == null) {
            this.f28976h = new ArrayList();
            for (int i2 = 0; i2 < this.f28974f.size(); i2++) {
                c cVar = this.f28974f.get(i2);
                if (cVar instanceof m) {
                    this.f28976h.add((m) cVar);
                }
            }
        }
        return this.f28976h;
    }

    Matrix d() {
        com.vivo.mobilead.lottie.a.b.o oVar = this.f28977i;
        if (oVar != null) {
            return oVar.d();
        }
        this.f28969a.reset();
        return this.f28969a;
    }

    @Override // com.vivo.mobilead.lottie.a.a.m
    public Path e() {
        this.f28969a.reset();
        com.vivo.mobilead.lottie.a.b.o oVar = this.f28977i;
        if (oVar != null) {
            this.f28969a.set(oVar.d());
        }
        this.f28970b.reset();
        if (this.f28973e) {
            return this.f28970b;
        }
        for (int size = this.f28974f.size() - 1; size >= 0; size--) {
            c cVar = this.f28974f.get(size);
            if (cVar instanceof m) {
                this.f28970b.addPath(((m) cVar).e(), this.f28969a);
            }
        }
        return this.f28970b;
    }
}

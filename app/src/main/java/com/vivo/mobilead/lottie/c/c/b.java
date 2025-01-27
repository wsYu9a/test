package com.vivo.mobilead.lottie.c.c;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.LongSparseArray;
import com.vivo.mobilead.lottie.LottieComposition;
import com.vivo.mobilead.lottie.a.b.p;
import com.vivo.mobilead.lottie.c.c.d;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class b extends a {

    /* renamed from: e */
    private com.vivo.mobilead.lottie.a.b.a<Float, Float> f29338e;

    /* renamed from: f */
    private final List<a> f29339f;

    /* renamed from: g */
    private final RectF f29340g;

    /* renamed from: h */
    private final RectF f29341h;

    /* renamed from: i */
    private Boolean f29342i;

    /* renamed from: j */
    private Boolean f29343j;

    /* renamed from: com.vivo.mobilead.lottie.c.c.b$1 */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        static final /* synthetic */ int[] f29344a;

        static {
            int[] iArr = new int[d.b.values().length];
            f29344a = iArr;
            try {
                iArr[d.b.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29344a[d.b.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public b(com.vivo.mobilead.lottie.c cVar, d dVar, List<d> list, LottieComposition lottieComposition) {
        super(cVar, dVar);
        int i2;
        a aVar;
        this.f29339f = new ArrayList();
        this.f29340g = new RectF();
        this.f29341h = new RectF();
        com.vivo.mobilead.lottie.c.a.b u = dVar.u();
        if (u != null) {
            com.vivo.mobilead.lottie.a.b.a<Float, Float> a2 = u.a();
            this.f29338e = a2;
            a(a2);
            this.f29338e.a(this);
        } else {
            this.f29338e = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(lottieComposition.getLayers().size());
        int size = list.size() - 1;
        a aVar2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            d dVar2 = list.get(size);
            a a3 = a.a(dVar2, cVar, lottieComposition);
            if (a3 != null) {
                longSparseArray.put(a3.c().e(), a3);
                if (aVar2 != null) {
                    aVar2.a(a3);
                    aVar2 = null;
                } else {
                    this.f29339f.add(0, a3);
                    int i3 = AnonymousClass1.f29344a[dVar2.l().ordinal()];
                    if (i3 == 1 || i3 == 2) {
                        aVar2 = a3;
                    }
                }
            }
            size--;
        }
        for (i2 = 0; i2 < longSparseArray.size(); i2++) {
            a aVar3 = (a) longSparseArray.get(longSparseArray.keyAt(i2));
            if (aVar3 != null && (aVar = (a) longSparseArray.get(aVar3.c().m())) != null) {
                aVar3.b(aVar);
            }
        }
    }

    @Override // com.vivo.mobilead.lottie.c.c.a
    public void a(float f2) {
        super.a(f2);
        if (this.f29338e != null) {
            f2 = ((long) (this.f29338e.g().floatValue() * 1000.0f)) / this.f29325b.x().getDuration();
        }
        if (this.f29326c.b() != 0.0f) {
            f2 /= this.f29326c.b();
        }
        float c2 = f2 - this.f29326c.c();
        for (int size = this.f29339f.size() - 1; size >= 0; size--) {
            this.f29339f.get(size).a(c2);
        }
    }

    @Override // com.vivo.mobilead.lottie.c.c.a, com.vivo.mobilead.lottie.a.a.e
    public void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        for (int size = this.f29339f.size() - 1; size >= 0; size--) {
            this.f29340g.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.f29339f.get(size).a(this.f29340g, this.f29324a, true);
            rectF.union(this.f29340g);
        }
    }

    @Override // com.vivo.mobilead.lottie.c.c.a, com.vivo.mobilead.lottie.c.f
    public <T> void a(T t, com.vivo.mobilead.lottie.g.c<T> cVar) {
        super.a((b) t, (com.vivo.mobilead.lottie.g.c<b>) cVar);
        if (t == com.vivo.mobilead.lottie.g.A) {
            if (cVar == null) {
                this.f29338e = null;
                return;
            }
            p pVar = new p(cVar);
            this.f29338e = pVar;
            a(pVar);
        }
    }

    @Override // com.vivo.mobilead.lottie.c.c.a
    void b(Canvas canvas, Matrix matrix, int i2) {
        com.vivo.mobilead.lottie.b.a("CompositionLayer#draw");
        canvas.save();
        this.f29341h.set(0.0f, 0.0f, this.f29326c.h(), this.f29326c.i());
        matrix.mapRect(this.f29341h);
        for (int size = this.f29339f.size() - 1; size >= 0; size--) {
            if (!this.f29341h.isEmpty() ? canvas.clipRect(this.f29341h) : true) {
                this.f29339f.get(size).a(canvas, matrix, i2);
            }
        }
        canvas.restore();
        com.vivo.mobilead.lottie.b.b("CompositionLayer#draw");
    }

    @Override // com.vivo.mobilead.lottie.c.c.a
    protected void b(com.vivo.mobilead.lottie.c.e eVar, int i2, List<com.vivo.mobilead.lottie.c.e> list, com.vivo.mobilead.lottie.c.e eVar2) {
        for (int i3 = 0; i3 < this.f29339f.size(); i3++) {
            this.f29339f.get(i3).a(eVar, i2, list, eVar2);
        }
    }

    public boolean f() {
        if (this.f29343j == null) {
            for (int size = this.f29339f.size() - 1; size >= 0; size--) {
                a aVar = this.f29339f.get(size);
                if (!(aVar instanceof f)) {
                    if ((aVar instanceof b) && ((b) aVar).f()) {
                        this.f29343j = Boolean.TRUE;
                        return true;
                    }
                } else {
                    if (aVar.e()) {
                        this.f29343j = Boolean.TRUE;
                        return true;
                    }
                }
            }
            this.f29343j = Boolean.FALSE;
        }
        return this.f29343j.booleanValue();
    }

    public boolean g() {
        if (this.f29342i == null) {
            if (!d()) {
                for (int size = this.f29339f.size() - 1; size >= 0; size--) {
                    if (!this.f29339f.get(size).d()) {
                    }
                }
                this.f29342i = Boolean.FALSE;
            }
            this.f29342i = Boolean.TRUE;
            return true;
        }
        return this.f29342i.booleanValue();
    }
}

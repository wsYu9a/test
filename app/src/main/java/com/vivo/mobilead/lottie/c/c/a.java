package com.vivo.mobilead.lottie.c.c;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import com.vivo.mobilead.lottie.LottieComposition;
import com.vivo.mobilead.lottie.a.b.a;
import com.vivo.mobilead.lottie.a.b.o;
import com.vivo.mobilead.lottie.c.b.g;
import com.vivo.mobilead.lottie.c.b.l;
import com.vivo.mobilead.lottie.c.c.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class a implements com.vivo.mobilead.lottie.a.a.e, a.InterfaceC0598a, com.vivo.mobilead.lottie.c.f {

    /* renamed from: a */
    final Matrix f29324a;

    /* renamed from: b */
    final com.vivo.mobilead.lottie.c f29325b;

    /* renamed from: c */
    final d f29326c;

    /* renamed from: d */
    final o f29327d;

    /* renamed from: e */
    private final Path f29328e = new Path();

    /* renamed from: f */
    private final Matrix f29329f = new Matrix();

    /* renamed from: g */
    private final Paint f29330g = new com.vivo.mobilead.lottie.a.a(1);

    /* renamed from: h */
    private final Paint f29331h = new com.vivo.mobilead.lottie.a.a(1, PorterDuff.Mode.DST_IN);

    /* renamed from: i */
    private final Paint f29332i = new com.vivo.mobilead.lottie.a.a(1, PorterDuff.Mode.DST_OUT);

    /* renamed from: j */
    private final Paint f29333j;
    private final Paint k;
    private final RectF l;
    private final RectF m;
    private final RectF n;
    private final RectF o;
    private final String p;
    private com.vivo.mobilead.lottie.a.b.g q;
    private a r;
    private a s;
    private List<a> t;
    private final List<com.vivo.mobilead.lottie.a.b.a<?, ?>> u;
    private boolean v;

    /* renamed from: com.vivo.mobilead.lottie.c.c.a$1 */
    class AnonymousClass1 implements a.InterfaceC0598a {

        /* renamed from: a */
        final /* synthetic */ com.vivo.mobilead.lottie.a.b.c f29334a;

        AnonymousClass1(com.vivo.mobilead.lottie.a.b.c cVar) {
            cVar = cVar;
        }

        @Override // com.vivo.mobilead.lottie.a.b.a.InterfaceC0598a
        public void a() {
            a.this.a(cVar.i() == 1.0f);
        }
    }

    /* renamed from: com.vivo.mobilead.lottie.c.c.a$2 */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a */
        static final /* synthetic */ int[] f29336a;

        /* renamed from: b */
        static final /* synthetic */ int[] f29337b;

        static {
            int[] iArr = new int[g.a.values().length];
            f29337b = iArr;
            try {
                iArr[g.a.MASK_MODE_SUBTRACT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29337b[g.a.MASK_MODE_INTERSECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f29337b[g.a.MASK_MODE_ADD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[d.a.values().length];
            f29336a = iArr2;
            try {
                iArr2[d.a.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f29336a[d.a.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f29336a[d.a.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f29336a[d.a.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f29336a[d.a.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f29336a[d.a.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f29336a[d.a.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    a(com.vivo.mobilead.lottie.c cVar, d dVar) {
        com.vivo.mobilead.lottie.a.a aVar = new com.vivo.mobilead.lottie.a.a(1);
        this.f29333j = aVar;
        this.k = new com.vivo.mobilead.lottie.a.a(PorterDuff.Mode.CLEAR);
        this.l = new RectF();
        this.m = new RectF();
        this.n = new RectF();
        this.o = new RectF();
        this.f29324a = new Matrix();
        this.u = new ArrayList();
        this.v = true;
        this.f29325b = cVar;
        this.f29326c = dVar;
        this.p = dVar.f() + "#draw";
        aVar.setXfermode(dVar.l() == d.b.INVERT ? new PorterDuffXfermode(PorterDuff.Mode.DST_OUT) : new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        o j2 = dVar.o().j();
        this.f29327d = j2;
        j2.a((a.InterfaceC0598a) this);
        if (dVar.j() != null && !dVar.j().isEmpty()) {
            com.vivo.mobilead.lottie.a.b.g gVar = new com.vivo.mobilead.lottie.a.b.g(dVar.j());
            this.q = gVar;
            Iterator<com.vivo.mobilead.lottie.a.b.a<l, Path>> it = gVar.b().iterator();
            while (it.hasNext()) {
                it.next().a(this);
            }
            for (com.vivo.mobilead.lottie.a.b.a<Integer, Integer> aVar2 : this.q.c()) {
                a(aVar2);
                aVar2.a(this);
            }
        }
        f();
    }

    static a a(d dVar, com.vivo.mobilead.lottie.c cVar, LottieComposition lottieComposition) {
        switch (AnonymousClass2.f29336a[dVar.k().ordinal()]) {
            case 1:
                return new f(cVar, dVar);
            case 2:
                return new b(cVar, dVar, lottieComposition.getPrecomps(dVar.g()), lottieComposition);
            case 3:
                return new g(cVar, dVar);
            case 4:
                return new c(cVar, dVar);
            case 5:
                return new e(cVar, dVar);
            case 6:
                return new h(cVar, dVar);
            default:
                com.vivo.mobilead.lottie.f.d.b("Unknown layer type " + dVar.k());
                return null;
        }
    }

    private void a(Canvas canvas) {
        com.vivo.mobilead.lottie.b.a("Layer#clearLayer");
        RectF rectF = this.l;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.k);
        com.vivo.mobilead.lottie.b.b("Layer#clearLayer");
    }

    private void a(Canvas canvas, Matrix matrix) {
        com.vivo.mobilead.lottie.b.a("Layer#saveLayer");
        a(canvas, this.l, this.f29331h, false);
        com.vivo.mobilead.lottie.b.b("Layer#saveLayer");
        for (int i2 = 0; i2 < this.q.a().size(); i2++) {
            com.vivo.mobilead.lottie.c.b.g gVar = this.q.a().get(i2);
            com.vivo.mobilead.lottie.a.b.a<l, Path> aVar = this.q.b().get(i2);
            com.vivo.mobilead.lottie.a.b.a<Integer, Integer> aVar2 = this.q.c().get(i2);
            int i3 = AnonymousClass2.f29337b[gVar.a().ordinal()];
            if (i3 == 1) {
                if (i2 == 0) {
                    Paint paint = new Paint();
                    paint.setColor(-16777216);
                    canvas.drawRect(this.l, paint);
                }
                if (gVar.d()) {
                    d(canvas, matrix, gVar, aVar, aVar2);
                } else {
                    c(canvas, matrix, gVar, aVar, aVar2);
                }
            } else if (i3 != 2) {
                if (i3 == 3) {
                    if (gVar.d()) {
                        b(canvas, matrix, gVar, aVar, aVar2);
                    } else {
                        a(canvas, matrix, gVar, aVar, aVar2);
                    }
                }
            } else if (gVar.d()) {
                f(canvas, matrix, gVar, aVar, aVar2);
            } else {
                e(canvas, matrix, gVar, aVar, aVar2);
            }
        }
        com.vivo.mobilead.lottie.b.a("Layer#restoreLayer");
        canvas.restore();
        com.vivo.mobilead.lottie.b.b("Layer#restoreLayer");
    }

    private void a(Canvas canvas, Matrix matrix, com.vivo.mobilead.lottie.c.b.g gVar, com.vivo.mobilead.lottie.a.b.a<l, Path> aVar, com.vivo.mobilead.lottie.a.b.a<Integer, Integer> aVar2) {
        this.f29328e.set(aVar.g());
        this.f29328e.transform(matrix);
        this.f29330g.setAlpha((int) (aVar2.g().intValue() * 2.55f));
        canvas.drawPath(this.f29328e, this.f29330g);
    }

    @SuppressLint({"WrongConstant"})
    private void a(Canvas canvas, RectF rectF, Paint paint, boolean z) {
        if (Build.VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF, paint, z ? 31 : 19);
        } else {
            canvas.saveLayer(rectF, paint);
        }
    }

    private void a(RectF rectF, Matrix matrix) {
        this.m.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (e()) {
            int size = this.q.a().size();
            for (int i2 = 0; i2 < size; i2++) {
                com.vivo.mobilead.lottie.c.b.g gVar = this.q.a().get(i2);
                this.f29328e.set(this.q.b().get(i2).g());
                this.f29328e.transform(matrix);
                int i3 = AnonymousClass2.f29337b[gVar.a().ordinal()];
                if (i3 == 1) {
                    return;
                }
                if ((i3 == 2 || i3 == 3) && gVar.d()) {
                    return;
                }
                this.f29328e.computeBounds(this.o, false);
                RectF rectF2 = this.m;
                if (i2 == 0) {
                    rectF2.set(this.o);
                } else {
                    rectF2.set(Math.min(rectF2.left, this.o.left), Math.min(this.m.top, this.o.top), Math.max(this.m.right, this.o.right), Math.max(this.m.bottom, this.o.bottom));
                }
            }
            if (rectF.intersect(this.m)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    public void a(boolean z) {
        if (z != this.v) {
            this.v = z;
            g();
        }
    }

    private void b(float f2) {
        this.f29325b.x().getPerformanceTracker().a(this.f29326c.f(), f2);
    }

    private void b(Canvas canvas, Matrix matrix, com.vivo.mobilead.lottie.c.b.g gVar, com.vivo.mobilead.lottie.a.b.a<l, Path> aVar, com.vivo.mobilead.lottie.a.b.a<Integer, Integer> aVar2) {
        a(canvas, this.l, this.f29330g, true);
        canvas.drawRect(this.l, this.f29330g);
        this.f29328e.set(aVar.g());
        this.f29328e.transform(matrix);
        this.f29330g.setAlpha((int) (aVar2.g().intValue() * 2.55f));
        canvas.drawPath(this.f29328e, this.f29332i);
        canvas.restore();
    }

    private void b(RectF rectF, Matrix matrix) {
        if (d() && this.f29326c.l() != d.b.INVERT) {
            this.n.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.r.a(this.n, matrix, true);
            if (rectF.intersect(this.n)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    private void c(Canvas canvas, Matrix matrix, com.vivo.mobilead.lottie.c.b.g gVar, com.vivo.mobilead.lottie.a.b.a<l, Path> aVar, com.vivo.mobilead.lottie.a.b.a<Integer, Integer> aVar2) {
        this.f29328e.set(aVar.g());
        this.f29328e.transform(matrix);
        canvas.drawPath(this.f29328e, this.f29332i);
    }

    private void d(Canvas canvas, Matrix matrix, com.vivo.mobilead.lottie.c.b.g gVar, com.vivo.mobilead.lottie.a.b.a<l, Path> aVar, com.vivo.mobilead.lottie.a.b.a<Integer, Integer> aVar2) {
        a(canvas, this.l, this.f29332i, true);
        canvas.drawRect(this.l, this.f29330g);
        this.f29332i.setAlpha((int) (aVar2.g().intValue() * 2.55f));
        this.f29328e.set(aVar.g());
        this.f29328e.transform(matrix);
        canvas.drawPath(this.f29328e, this.f29332i);
        canvas.restore();
    }

    private void e(Canvas canvas, Matrix matrix, com.vivo.mobilead.lottie.c.b.g gVar, com.vivo.mobilead.lottie.a.b.a<l, Path> aVar, com.vivo.mobilead.lottie.a.b.a<Integer, Integer> aVar2) {
        a(canvas, this.l, this.f29331h, true);
        this.f29328e.set(aVar.g());
        this.f29328e.transform(matrix);
        this.f29330g.setAlpha((int) (aVar2.g().intValue() * 2.55f));
        canvas.drawPath(this.f29328e, this.f29330g);
        canvas.restore();
    }

    private void f() {
        if (this.f29326c.d().isEmpty()) {
            a(true);
            return;
        }
        com.vivo.mobilead.lottie.a.b.c cVar = new com.vivo.mobilead.lottie.a.b.c(this.f29326c.d());
        cVar.a();
        cVar.a(new a.InterfaceC0598a() { // from class: com.vivo.mobilead.lottie.c.c.a.1

            /* renamed from: a */
            final /* synthetic */ com.vivo.mobilead.lottie.a.b.c f29334a;

            AnonymousClass1(com.vivo.mobilead.lottie.a.b.c cVar2) {
                cVar = cVar2;
            }

            @Override // com.vivo.mobilead.lottie.a.b.a.InterfaceC0598a
            public void a() {
                a.this.a(cVar.i() == 1.0f);
            }
        });
        a(cVar2.g().floatValue() == 1.0f);
        a(cVar2);
    }

    private void f(Canvas canvas, Matrix matrix, com.vivo.mobilead.lottie.c.b.g gVar, com.vivo.mobilead.lottie.a.b.a<l, Path> aVar, com.vivo.mobilead.lottie.a.b.a<Integer, Integer> aVar2) {
        a(canvas, this.l, this.f29331h, true);
        canvas.drawRect(this.l, this.f29330g);
        this.f29332i.setAlpha((int) (aVar2.g().intValue() * 2.55f));
        this.f29328e.set(aVar.g());
        this.f29328e.transform(matrix);
        canvas.drawPath(this.f29328e, this.f29332i);
        canvas.restore();
    }

    private void g() {
        this.f29325b.invalidateSelf();
    }

    private void h() {
        if (this.t != null) {
            return;
        }
        if (this.s == null) {
            this.t = Collections.emptyList();
            return;
        }
        this.t = new ArrayList();
        for (a aVar = this.s; aVar != null; aVar = aVar.s) {
            this.t.add(aVar);
        }
    }

    @Override // com.vivo.mobilead.lottie.a.b.a.InterfaceC0598a
    public void a() {
        g();
    }

    void a(float f2) {
        this.f29327d.a(f2);
        if (this.q != null) {
            for (int i2 = 0; i2 < this.q.b().size(); i2++) {
                this.q.b().get(i2).a(f2);
            }
        }
        if (this.f29326c.b() != 0.0f) {
            f2 /= this.f29326c.b();
        }
        a aVar = this.r;
        if (aVar != null) {
            this.r.a(aVar.f29326c.b() * f2);
        }
        for (int i3 = 0; i3 < this.u.size(); i3++) {
            this.u.get(i3).a(f2);
        }
    }

    @Override // com.vivo.mobilead.lottie.a.a.e
    public void a(Canvas canvas, Matrix matrix, int i2) {
        com.vivo.mobilead.lottie.b.a(this.p);
        if (!this.v || this.f29326c.v()) {
            com.vivo.mobilead.lottie.b.b(this.p);
            return;
        }
        h();
        com.vivo.mobilead.lottie.b.a("Layer#parentMatrix");
        this.f29329f.reset();
        this.f29329f.set(matrix);
        for (int size = this.t.size() - 1; size >= 0; size--) {
            this.f29329f.preConcat(this.t.get(size).f29327d.d());
        }
        com.vivo.mobilead.lottie.b.b("Layer#parentMatrix");
        int intValue = (int) ((((i2 / 255.0f) * (this.f29327d.a() == null ? 100 : this.f29327d.a().g().intValue())) / 100.0f) * 255.0f);
        if (!d() && !e()) {
            this.f29329f.preConcat(this.f29327d.d());
            com.vivo.mobilead.lottie.b.a("Layer#drawLayer");
            b(canvas, this.f29329f, intValue);
            com.vivo.mobilead.lottie.b.b("Layer#drawLayer");
            b(com.vivo.mobilead.lottie.b.b(this.p));
            return;
        }
        com.vivo.mobilead.lottie.b.a("Layer#computeBounds");
        a(this.l, this.f29329f, false);
        b(this.l, matrix);
        this.f29329f.preConcat(this.f29327d.d());
        a(this.l, this.f29329f);
        com.vivo.mobilead.lottie.b.b("Layer#computeBounds");
        if (!this.l.isEmpty()) {
            com.vivo.mobilead.lottie.b.a("Layer#saveLayer");
            a(canvas, this.l, this.f29330g, true);
            com.vivo.mobilead.lottie.b.b("Layer#saveLayer");
            a(canvas);
            com.vivo.mobilead.lottie.b.a("Layer#drawLayer");
            b(canvas, this.f29329f, intValue);
            com.vivo.mobilead.lottie.b.b("Layer#drawLayer");
            if (e()) {
                a(canvas, this.f29329f);
            }
            if (d()) {
                com.vivo.mobilead.lottie.b.a("Layer#drawMatte");
                com.vivo.mobilead.lottie.b.a("Layer#saveLayer");
                a(canvas, this.l, this.f29333j, false);
                com.vivo.mobilead.lottie.b.b("Layer#saveLayer");
                a(canvas);
                this.r.a(canvas, matrix, intValue);
                com.vivo.mobilead.lottie.b.a("Layer#restoreLayer");
                canvas.restore();
                com.vivo.mobilead.lottie.b.b("Layer#restoreLayer");
                com.vivo.mobilead.lottie.b.b("Layer#drawMatte");
            }
            com.vivo.mobilead.lottie.b.a("Layer#restoreLayer");
            canvas.restore();
            com.vivo.mobilead.lottie.b.b("Layer#restoreLayer");
        }
        b(com.vivo.mobilead.lottie.b.b(this.p));
    }

    @Override // com.vivo.mobilead.lottie.a.a.e
    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.l.set(0.0f, 0.0f, 0.0f, 0.0f);
        h();
        this.f29324a.set(matrix);
        if (z) {
            List<a> list = this.t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f29324a.preConcat(this.t.get(size).f29327d.d());
                }
            } else {
                a aVar = this.s;
                if (aVar != null) {
                    this.f29324a.preConcat(aVar.f29327d.d());
                }
            }
        }
        this.f29324a.preConcat(this.f29327d.d());
    }

    public void a(com.vivo.mobilead.lottie.a.b.a<?, ?> aVar) {
        if (aVar == null) {
            return;
        }
        this.u.add(aVar);
    }

    void a(a aVar) {
        this.r = aVar;
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
                b(eVar, i2 + eVar.b(b(), i2), list, eVar2);
            }
        }
    }

    @Override // com.vivo.mobilead.lottie.c.f
    public <T> void a(T t, com.vivo.mobilead.lottie.g.c<T> cVar) {
        this.f29327d.a(t, cVar);
    }

    @Override // com.vivo.mobilead.lottie.a.a.c
    public void a(List<com.vivo.mobilead.lottie.a.a.c> list, List<com.vivo.mobilead.lottie.a.a.c> list2) {
    }

    @Override // com.vivo.mobilead.lottie.a.a.c
    public String b() {
        return this.f29326c.f();
    }

    abstract void b(Canvas canvas, Matrix matrix, int i2);

    public void b(com.vivo.mobilead.lottie.a.b.a<?, ?> aVar) {
        this.u.remove(aVar);
    }

    void b(a aVar) {
        this.s = aVar;
    }

    void b(com.vivo.mobilead.lottie.c.e eVar, int i2, List<com.vivo.mobilead.lottie.c.e> list, com.vivo.mobilead.lottie.c.e eVar2) {
    }

    d c() {
        return this.f29326c;
    }

    boolean d() {
        return this.r != null;
    }

    boolean e() {
        com.vivo.mobilead.lottie.a.b.g gVar = this.q;
        return (gVar == null || gVar.b().isEmpty()) ? false : true;
    }
}

package com.vivo.mobilead.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.vivo.mobilead.lottie.a.b.a;

/* loaded from: classes4.dex */
public class o {

    /* renamed from: a */
    private final Matrix f29100a = new Matrix();

    /* renamed from: b */
    private final Matrix f29101b;

    /* renamed from: c */
    private final Matrix f29102c;

    /* renamed from: d */
    private final Matrix f29103d;

    /* renamed from: e */
    private final float[] f29104e;

    /* renamed from: f */
    private a<PointF, PointF> f29105f;

    /* renamed from: g */
    private a<?, PointF> f29106g;

    /* renamed from: h */
    private a<com.vivo.mobilead.lottie.g.d, com.vivo.mobilead.lottie.g.d> f29107h;

    /* renamed from: i */
    private a<Float, Float> f29108i;

    /* renamed from: j */
    private a<Integer, Integer> f29109j;
    private c k;
    private c l;
    private a<?, Float> m;
    private a<?, Float> n;

    public o(com.vivo.mobilead.lottie.c.a.l lVar) {
        this.f29105f = lVar.a() == null ? null : lVar.a().a();
        this.f29106g = lVar.b() == null ? null : lVar.b().a();
        this.f29107h = lVar.c() == null ? null : lVar.c().a();
        this.f29108i = lVar.d() == null ? null : lVar.d().a();
        c cVar = lVar.h() == null ? null : (c) lVar.h().a();
        this.k = cVar;
        if (cVar != null) {
            this.f29101b = new Matrix();
            this.f29102c = new Matrix();
            this.f29103d = new Matrix();
            this.f29104e = new float[9];
        } else {
            this.f29101b = null;
            this.f29102c = null;
            this.f29103d = null;
            this.f29104e = null;
        }
        this.l = lVar.i() == null ? null : (c) lVar.i().a();
        if (lVar.e() != null) {
            this.f29109j = lVar.e().a();
        }
        if (lVar.f() != null) {
            this.m = lVar.f().a();
        } else {
            this.m = null;
        }
        if (lVar.g() != null) {
            this.n = lVar.g().a();
        } else {
            this.n = null;
        }
    }

    private void e() {
        for (int i2 = 0; i2 < 9; i2++) {
            this.f29104e[i2] = 0.0f;
        }
    }

    public a<?, Integer> a() {
        return this.f29109j;
    }

    public void a(float f2) {
        a<Integer, Integer> aVar = this.f29109j;
        if (aVar != null) {
            aVar.a(f2);
        }
        a<?, Float> aVar2 = this.m;
        if (aVar2 != null) {
            aVar2.a(f2);
        }
        a<?, Float> aVar3 = this.n;
        if (aVar3 != null) {
            aVar3.a(f2);
        }
        a<PointF, PointF> aVar4 = this.f29105f;
        if (aVar4 != null) {
            aVar4.a(f2);
        }
        a<?, PointF> aVar5 = this.f29106g;
        if (aVar5 != null) {
            aVar5.a(f2);
        }
        a<com.vivo.mobilead.lottie.g.d, com.vivo.mobilead.lottie.g.d> aVar6 = this.f29107h;
        if (aVar6 != null) {
            aVar6.a(f2);
        }
        a<Float, Float> aVar7 = this.f29108i;
        if (aVar7 != null) {
            aVar7.a(f2);
        }
        c cVar = this.k;
        if (cVar != null) {
            cVar.a(f2);
        }
        c cVar2 = this.l;
        if (cVar2 != null) {
            cVar2.a(f2);
        }
    }

    public void a(a.InterfaceC0598a interfaceC0598a) {
        a<Integer, Integer> aVar = this.f29109j;
        if (aVar != null) {
            aVar.a(interfaceC0598a);
        }
        a<?, Float> aVar2 = this.m;
        if (aVar2 != null) {
            aVar2.a(interfaceC0598a);
        }
        a<?, Float> aVar3 = this.n;
        if (aVar3 != null) {
            aVar3.a(interfaceC0598a);
        }
        a<PointF, PointF> aVar4 = this.f29105f;
        if (aVar4 != null) {
            aVar4.a(interfaceC0598a);
        }
        a<?, PointF> aVar5 = this.f29106g;
        if (aVar5 != null) {
            aVar5.a(interfaceC0598a);
        }
        a<com.vivo.mobilead.lottie.g.d, com.vivo.mobilead.lottie.g.d> aVar6 = this.f29107h;
        if (aVar6 != null) {
            aVar6.a(interfaceC0598a);
        }
        a<Float, Float> aVar7 = this.f29108i;
        if (aVar7 != null) {
            aVar7.a(interfaceC0598a);
        }
        c cVar = this.k;
        if (cVar != null) {
            cVar.a(interfaceC0598a);
        }
        c cVar2 = this.l;
        if (cVar2 != null) {
            cVar2.a(interfaceC0598a);
        }
    }

    public void a(com.vivo.mobilead.lottie.c.c.a aVar) {
        aVar.a(this.f29109j);
        aVar.a(this.m);
        aVar.a(this.n);
        aVar.a(this.f29105f);
        aVar.a(this.f29106g);
        aVar.a(this.f29107h);
        aVar.a(this.f29108i);
        aVar.a(this.k);
        aVar.a(this.l);
    }

    public <T> boolean a(T t, com.vivo.mobilead.lottie.g.c<T> cVar) {
        a aVar;
        a aVar2;
        if (t == com.vivo.mobilead.lottie.g.f29457e) {
            aVar = this.f29105f;
            if (aVar == null) {
                this.f29105f = new p(cVar, new PointF());
                return true;
            }
        } else if (t == com.vivo.mobilead.lottie.g.f29458f) {
            aVar = this.f29106g;
            if (aVar == null) {
                this.f29106g = new p(cVar, new PointF());
                return true;
            }
        } else if (t == com.vivo.mobilead.lottie.g.k) {
            aVar = this.f29107h;
            if (aVar == null) {
                this.f29107h = new p(cVar, new com.vivo.mobilead.lottie.g.d());
                return true;
            }
        } else if (t == com.vivo.mobilead.lottie.g.l) {
            aVar = this.f29108i;
            if (aVar == null) {
                this.f29108i = new p(cVar, Float.valueOf(0.0f));
                return true;
            }
        } else if (t == com.vivo.mobilead.lottie.g.f29455c) {
            aVar = this.f29109j;
            if (aVar == null) {
                this.f29109j = new p(cVar, 100);
                return true;
            }
        } else {
            if ((t == com.vivo.mobilead.lottie.g.y && (aVar2 = this.m) != null) || ((t == com.vivo.mobilead.lottie.g.z && (aVar2 = this.n) != null) || (t == com.vivo.mobilead.lottie.g.m && (aVar2 = this.k) != null))) {
                aVar2.a(cVar);
                return true;
            }
            if (t != com.vivo.mobilead.lottie.g.n || (aVar = this.l) == null) {
                return false;
            }
        }
        aVar.a(cVar);
        return true;
    }

    public Matrix b(float f2) {
        a<?, PointF> aVar = this.f29106g;
        PointF g2 = aVar == null ? null : aVar.g();
        a<com.vivo.mobilead.lottie.g.d, com.vivo.mobilead.lottie.g.d> aVar2 = this.f29107h;
        com.vivo.mobilead.lottie.g.d g3 = aVar2 == null ? null : aVar2.g();
        this.f29100a.reset();
        if (g2 != null) {
            this.f29100a.preTranslate(g2.x * f2, g2.y * f2);
        }
        if (g3 != null) {
            double d2 = f2;
            this.f29100a.preScale((float) Math.pow(g3.a(), d2), (float) Math.pow(g3.b(), d2));
        }
        a<Float, Float> aVar3 = this.f29108i;
        if (aVar3 != null) {
            float floatValue = aVar3.g().floatValue();
            a<PointF, PointF> aVar4 = this.f29105f;
            PointF g4 = aVar4 != null ? aVar4.g() : null;
            this.f29100a.preRotate(floatValue * f2, g4 == null ? 0.0f : g4.x, g4 != null ? g4.y : 0.0f);
        }
        return this.f29100a;
    }

    public a<?, Float> b() {
        return this.m;
    }

    public a<?, Float> c() {
        return this.n;
    }

    public Matrix d() {
        this.f29100a.reset();
        a<?, PointF> aVar = this.f29106g;
        if (aVar != null) {
            PointF g2 = aVar.g();
            float f2 = g2.x;
            if (f2 != 0.0f || g2.y != 0.0f) {
                this.f29100a.preTranslate(f2, g2.y);
            }
        }
        a<Float, Float> aVar2 = this.f29108i;
        if (aVar2 != null) {
            float floatValue = aVar2 instanceof p ? aVar2.g().floatValue() : ((c) aVar2).i();
            if (floatValue != 0.0f) {
                this.f29100a.preRotate(floatValue);
            }
        }
        if (this.k != null) {
            float cos = this.l == null ? 0.0f : (float) Math.cos(Math.toRadians((-r0.i()) + 90.0f));
            float sin = this.l == null ? 1.0f : (float) Math.sin(Math.toRadians((-r4.i()) + 90.0f));
            float tan = (float) Math.tan(Math.toRadians(this.k.i()));
            e();
            float[] fArr = this.f29104e;
            fArr[0] = cos;
            fArr[1] = sin;
            float f3 = -sin;
            fArr[3] = f3;
            fArr[4] = cos;
            fArr[8] = 1.0f;
            this.f29101b.setValues(fArr);
            e();
            float[] fArr2 = this.f29104e;
            fArr2[0] = 1.0f;
            fArr2[3] = tan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.f29102c.setValues(fArr2);
            e();
            float[] fArr3 = this.f29104e;
            fArr3[0] = cos;
            fArr3[1] = f3;
            fArr3[3] = sin;
            fArr3[4] = cos;
            fArr3[8] = 1.0f;
            this.f29103d.setValues(fArr3);
            this.f29102c.preConcat(this.f29101b);
            this.f29103d.preConcat(this.f29102c);
            this.f29100a.preConcat(this.f29103d);
        }
        a<com.vivo.mobilead.lottie.g.d, com.vivo.mobilead.lottie.g.d> aVar3 = this.f29107h;
        if (aVar3 != null) {
            com.vivo.mobilead.lottie.g.d g3 = aVar3.g();
            if (g3.a() != 1.0f || g3.b() != 1.0f) {
                this.f29100a.preScale(g3.a(), g3.b());
            }
        }
        a<PointF, PointF> aVar4 = this.f29105f;
        if (aVar4 != null) {
            PointF g4 = aVar4.g();
            float f4 = g4.x;
            if (f4 != 0.0f || g4.y != 0.0f) {
                this.f29100a.preTranslate(-f4, -g4.y);
            }
        }
        return this.f29100a;
    }
}

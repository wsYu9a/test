package com.vivo.mobilead.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import com.vivo.mobilead.lottie.a.b.a;
import com.vivo.mobilead.lottie.c.b.i;
import com.vivo.mobilead.lottie.c.b.q;
import java.util.List;

/* loaded from: classes4.dex */
public class n implements k, m, a.InterfaceC0598a {

    /* renamed from: b */
    private final String f29022b;

    /* renamed from: c */
    private final com.vivo.mobilead.lottie.c f29023c;

    /* renamed from: d */
    private final i.a f29024d;

    /* renamed from: e */
    private final boolean f29025e;

    /* renamed from: f */
    private final com.vivo.mobilead.lottie.a.b.a<?, Float> f29026f;

    /* renamed from: g */
    private final com.vivo.mobilead.lottie.a.b.a<?, PointF> f29027g;

    /* renamed from: h */
    private final com.vivo.mobilead.lottie.a.b.a<?, Float> f29028h;

    /* renamed from: i */
    private final com.vivo.mobilead.lottie.a.b.a<?, Float> f29029i;

    /* renamed from: j */
    private final com.vivo.mobilead.lottie.a.b.a<?, Float> f29030j;
    private final com.vivo.mobilead.lottie.a.b.a<?, Float> k;
    private final com.vivo.mobilead.lottie.a.b.a<?, Float> l;
    private boolean n;

    /* renamed from: a */
    private final Path f29021a = new Path();
    private b m = new b();

    /* renamed from: com.vivo.mobilead.lottie.a.a.n$1 */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        static final /* synthetic */ int[] f29031a;

        static {
            int[] iArr = new int[i.a.values().length];
            f29031a = iArr;
            try {
                iArr[i.a.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29031a[i.a.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public n(com.vivo.mobilead.lottie.c cVar, com.vivo.mobilead.lottie.c.c.a aVar, com.vivo.mobilead.lottie.c.b.i iVar) {
        com.vivo.mobilead.lottie.a.b.a<Float, Float> aVar2;
        this.f29023c = cVar;
        this.f29022b = iVar.a();
        i.a b2 = iVar.b();
        this.f29024d = b2;
        this.f29025e = iVar.j();
        com.vivo.mobilead.lottie.a.b.a<Float, Float> a2 = iVar.c().a();
        this.f29026f = a2;
        com.vivo.mobilead.lottie.a.b.a<PointF, PointF> a3 = iVar.d().a();
        this.f29027g = a3;
        com.vivo.mobilead.lottie.a.b.a<Float, Float> a4 = iVar.e().a();
        this.f29028h = a4;
        com.vivo.mobilead.lottie.a.b.a<Float, Float> a5 = iVar.g().a();
        this.f29030j = a5;
        com.vivo.mobilead.lottie.a.b.a<Float, Float> a6 = iVar.i().a();
        this.l = a6;
        i.a aVar3 = i.a.STAR;
        if (b2 == aVar3) {
            this.f29029i = iVar.f().a();
            aVar2 = iVar.h().a();
        } else {
            aVar2 = null;
            this.f29029i = null;
        }
        this.k = aVar2;
        aVar.a(a2);
        aVar.a(a3);
        aVar.a(a4);
        aVar.a(a5);
        aVar.a(a6);
        if (b2 == aVar3) {
            aVar.a(this.f29029i);
            aVar.a(this.k);
        }
        a2.a(this);
        a3.a(this);
        a4.a(this);
        a5.a(this);
        a6.a(this);
        if (b2 == aVar3) {
            this.f29029i.a(this);
            this.k.a(this);
        }
    }

    private void c() {
        this.n = false;
        this.f29023c.invalidateSelf();
    }

    private void d() {
        int i2;
        float f2;
        float f3;
        double d2;
        float f4;
        float f5;
        float f6;
        float f7;
        double d3;
        float f8;
        float f9;
        float f10;
        double d4;
        float floatValue = this.f29026f.g().floatValue();
        double radians = Math.toRadians((this.f29028h == null ? 0.0d : r2.g().floatValue()) - 90.0d);
        double d5 = floatValue;
        Double.isNaN(d5);
        float f11 = (float) (6.283185307179586d / d5);
        float f12 = f11 / 2.0f;
        float f13 = floatValue - ((int) floatValue);
        int i3 = (f13 > 0.0f ? 1 : (f13 == 0.0f ? 0 : -1));
        if (i3 != 0) {
            double d6 = (1.0f - f13) * f12;
            Double.isNaN(d6);
            radians += d6;
        }
        float floatValue2 = this.f29030j.g().floatValue();
        float floatValue3 = this.f29029i.g().floatValue();
        com.vivo.mobilead.lottie.a.b.a<?, Float> aVar = this.k;
        float floatValue4 = aVar != null ? aVar.g().floatValue() / 100.0f : 0.0f;
        com.vivo.mobilead.lottie.a.b.a<?, Float> aVar2 = this.l;
        float floatValue5 = aVar2 != null ? aVar2.g().floatValue() / 100.0f : 0.0f;
        if (i3 != 0) {
            f5 = ((floatValue2 - floatValue3) * f13) + floatValue3;
            i2 = i3;
            double d7 = f5;
            double cos = Math.cos(radians);
            Double.isNaN(d7);
            float f14 = (float) (d7 * cos);
            double sin = Math.sin(radians);
            Double.isNaN(d7);
            f4 = (float) (d7 * sin);
            this.f29021a.moveTo(f14, f4);
            double d8 = (f11 * f13) / 2.0f;
            Double.isNaN(d8);
            d2 = radians + d8;
            f2 = f14;
            f3 = f12;
        } else {
            i2 = i3;
            double d9 = floatValue2;
            double cos2 = Math.cos(radians);
            Double.isNaN(d9);
            float f15 = (float) (cos2 * d9);
            double sin2 = Math.sin(radians);
            Double.isNaN(d9);
            float f16 = (float) (d9 * sin2);
            this.f29021a.moveTo(f15, f16);
            f2 = f15;
            f3 = f12;
            double d10 = f3;
            Double.isNaN(d10);
            d2 = radians + d10;
            f4 = f16;
            f5 = 0.0f;
        }
        double ceil = Math.ceil(d5) * 2.0d;
        int i4 = 0;
        float f17 = f3;
        float f18 = f2;
        boolean z = false;
        while (true) {
            double d11 = i4;
            if (d11 >= ceil) {
                PointF g2 = this.f29027g.g();
                this.f29021a.offset(g2.x, g2.y);
                this.f29021a.close();
                return;
            }
            float f19 = z ? floatValue2 : floatValue3;
            if (f5 == 0.0f || d11 != ceil - 2.0d) {
                f6 = f11;
                f7 = f17;
            } else {
                f6 = f11;
                f7 = (f11 * f13) / 2.0f;
            }
            if (f5 == 0.0f || d11 != ceil - 1.0d) {
                d3 = d11;
                f8 = f5;
                f5 = f19;
            } else {
                d3 = d11;
                f8 = f5;
            }
            double d12 = f5;
            double cos3 = Math.cos(d2);
            Double.isNaN(d12);
            double d13 = ceil;
            float f20 = (float) (d12 * cos3);
            double sin3 = Math.sin(d2);
            Double.isNaN(d12);
            float f21 = (float) (d12 * sin3);
            if (floatValue4 == 0.0f && floatValue5 == 0.0f) {
                this.f29021a.lineTo(f20, f21);
                d4 = d2;
                f9 = floatValue4;
                f10 = floatValue5;
            } else {
                f9 = floatValue4;
                double atan2 = (float) (Math.atan2(f4, f18) - 1.5707963267948966d);
                float cos4 = (float) Math.cos(atan2);
                float sin4 = (float) Math.sin(atan2);
                f10 = floatValue5;
                d4 = d2;
                double atan22 = (float) (Math.atan2(f21, f20) - 1.5707963267948966d);
                float cos5 = (float) Math.cos(atan22);
                float sin5 = (float) Math.sin(atan22);
                float f22 = z ? f9 : f10;
                float f23 = z ? f10 : f9;
                float f24 = (z ? floatValue3 : floatValue2) * f22 * 0.47829f;
                float f25 = cos4 * f24;
                float f26 = f24 * sin4;
                float f27 = (z ? floatValue2 : floatValue3) * f23 * 0.47829f;
                float f28 = cos5 * f27;
                float f29 = f27 * sin5;
                if (i2 != 0) {
                    if (i4 == 0) {
                        f25 *= f13;
                        f26 *= f13;
                    } else if (d3 == d13 - 1.0d) {
                        f28 *= f13;
                        f29 *= f13;
                    }
                }
                this.f29021a.cubicTo(f18 - f25, f4 - f26, f20 + f28, f21 + f29, f20, f21);
            }
            double d14 = f7;
            Double.isNaN(d14);
            d2 = d4 + d14;
            z = !z;
            i4++;
            f18 = f20;
            f4 = f21;
            floatValue5 = f10;
            floatValue4 = f9;
            f5 = f8;
            f11 = f6;
            ceil = d13;
        }
    }

    private void f() {
        int i2;
        double d2;
        double d3;
        double d4;
        int floor = (int) Math.floor(this.f29026f.g().floatValue());
        double radians = Math.toRadians((this.f29028h == null ? 0.0d : r2.g().floatValue()) - 90.0d);
        double d5 = floor;
        Double.isNaN(d5);
        float floatValue = this.l.g().floatValue() / 100.0f;
        float floatValue2 = this.f29030j.g().floatValue();
        double d6 = floatValue2;
        double cos = Math.cos(radians);
        Double.isNaN(d6);
        float f2 = (float) (cos * d6);
        double sin = Math.sin(radians);
        Double.isNaN(d6);
        float f3 = (float) (sin * d6);
        this.f29021a.moveTo(f2, f3);
        double d7 = (float) (6.283185307179586d / d5);
        Double.isNaN(d7);
        double d8 = radians + d7;
        double ceil = Math.ceil(d5);
        int i3 = 0;
        while (i3 < ceil) {
            double cos2 = Math.cos(d8);
            Double.isNaN(d6);
            float f4 = (float) (cos2 * d6);
            double sin2 = Math.sin(d8);
            Double.isNaN(d6);
            double d9 = ceil;
            float f5 = (float) (d6 * sin2);
            if (floatValue != 0.0f) {
                d3 = d6;
                i2 = i3;
                d2 = d8;
                double atan2 = (float) (Math.atan2(f3, f2) - 1.5707963267948966d);
                float cos3 = (float) Math.cos(atan2);
                float sin3 = (float) Math.sin(atan2);
                d4 = d7;
                double atan22 = (float) (Math.atan2(f5, f4) - 1.5707963267948966d);
                float f6 = floatValue2 * floatValue * 0.25f;
                this.f29021a.cubicTo(f2 - (cos3 * f6), f3 - (sin3 * f6), f4 + (((float) Math.cos(atan22)) * f6), f5 + (f6 * ((float) Math.sin(atan22))), f4, f5);
            } else {
                i2 = i3;
                d2 = d8;
                d3 = d6;
                d4 = d7;
                this.f29021a.lineTo(f4, f5);
            }
            Double.isNaN(d4);
            d8 = d2 + d4;
            i3 = i2 + 1;
            f3 = f5;
            f2 = f4;
            ceil = d9;
            d6 = d3;
            d7 = d4;
        }
        PointF g2 = this.f29027g.g();
        this.f29021a.offset(g2.x, g2.y);
        this.f29021a.close();
    }

    @Override // com.vivo.mobilead.lottie.a.b.a.InterfaceC0598a
    public void a() {
        c();
    }

    @Override // com.vivo.mobilead.lottie.c.f
    public void a(com.vivo.mobilead.lottie.c.e eVar, int i2, List<com.vivo.mobilead.lottie.c.e> list, com.vivo.mobilead.lottie.c.e eVar2) {
        com.vivo.mobilead.lottie.f.g.a(eVar, i2, list, eVar2, this);
    }

    @Override // com.vivo.mobilead.lottie.c.f
    public <T> void a(T t, com.vivo.mobilead.lottie.g.c<T> cVar) {
        com.vivo.mobilead.lottie.a.b.a aVar;
        com.vivo.mobilead.lottie.a.b.a<?, Float> aVar2;
        if (t == com.vivo.mobilead.lottie.g.s) {
            aVar = this.f29026f;
        } else if (t == com.vivo.mobilead.lottie.g.t) {
            aVar = this.f29028h;
        } else {
            if (t != com.vivo.mobilead.lottie.g.f29462j) {
                if (t != com.vivo.mobilead.lottie.g.u || (aVar2 = this.f29029i) == null) {
                    if (t == com.vivo.mobilead.lottie.g.v) {
                        aVar = this.f29030j;
                    } else if (t != com.vivo.mobilead.lottie.g.w || (aVar2 = this.k) == null) {
                        if (t != com.vivo.mobilead.lottie.g.x) {
                            return;
                        } else {
                            aVar = this.l;
                        }
                    }
                }
                aVar2.a((com.vivo.mobilead.lottie.g.c<Float>) cVar);
                return;
            }
            aVar = this.f29027g;
        }
        aVar.a(cVar);
    }

    @Override // com.vivo.mobilead.lottie.a.a.c
    public void a(List<c> list, List<c> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            c cVar = list.get(i2);
            if (cVar instanceof s) {
                s sVar = (s) cVar;
                if (sVar.c() == q.a.SIMULTANEOUSLY) {
                    this.m.a(sVar);
                    sVar.a(this);
                }
            }
        }
    }

    @Override // com.vivo.mobilead.lottie.a.a.c
    public String b() {
        return this.f29022b;
    }

    @Override // com.vivo.mobilead.lottie.a.a.m
    public Path e() {
        if (this.n) {
            return this.f29021a;
        }
        this.f29021a.reset();
        if (!this.f29025e) {
            int i2 = AnonymousClass1.f29031a[this.f29024d.ordinal()];
            if (i2 == 1) {
                d();
            } else if (i2 == 2) {
                f();
            }
            this.f29021a.close();
            this.m.a(this.f29021a);
        }
        this.n = true;
        return this.f29021a;
    }
}

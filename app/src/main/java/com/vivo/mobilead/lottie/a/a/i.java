package com.vivo.mobilead.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.LongSparseArray;

/* loaded from: classes4.dex */
public class i extends a {

    /* renamed from: c */
    private final String f29006c;

    /* renamed from: d */
    private final boolean f29007d;

    /* renamed from: e */
    private final LongSparseArray<LinearGradient> f29008e;

    /* renamed from: f */
    private final LongSparseArray<RadialGradient> f29009f;

    /* renamed from: g */
    private final RectF f29010g;

    /* renamed from: h */
    private final com.vivo.mobilead.lottie.c.b.f f29011h;

    /* renamed from: i */
    private final int f29012i;

    /* renamed from: j */
    private final com.vivo.mobilead.lottie.a.b.a<com.vivo.mobilead.lottie.c.b.c, com.vivo.mobilead.lottie.c.b.c> f29013j;
    private final com.vivo.mobilead.lottie.a.b.a<PointF, PointF> k;
    private final com.vivo.mobilead.lottie.a.b.a<PointF, PointF> l;
    private com.vivo.mobilead.lottie.a.b.p m;

    public i(com.vivo.mobilead.lottie.c cVar, com.vivo.mobilead.lottie.c.c.a aVar, com.vivo.mobilead.lottie.c.b.e eVar) {
        super(cVar, aVar, eVar.h().a(), eVar.i().a(), eVar.l(), eVar.d(), eVar.g(), eVar.j(), eVar.k());
        this.f29008e = new LongSparseArray<>();
        this.f29009f = new LongSparseArray<>();
        this.f29010g = new RectF();
        this.f29006c = eVar.a();
        this.f29011h = eVar.b();
        this.f29007d = eVar.m();
        this.f29012i = (int) (cVar.x().getDuration() / 32.0f);
        com.vivo.mobilead.lottie.a.b.a<com.vivo.mobilead.lottie.c.b.c, com.vivo.mobilead.lottie.c.b.c> a2 = eVar.c().a();
        this.f29013j = a2;
        a2.a(this);
        aVar.a(a2);
        com.vivo.mobilead.lottie.a.b.a<PointF, PointF> a3 = eVar.e().a();
        this.k = a3;
        a3.a(this);
        aVar.a(a3);
        com.vivo.mobilead.lottie.a.b.a<PointF, PointF> a4 = eVar.f().a();
        this.l = a4;
        a4.a(this);
        aVar.a(a4);
    }

    private int[] a(int[] iArr) {
        com.vivo.mobilead.lottie.a.b.p pVar = this.m;
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
        LinearGradient linearGradient = this.f29008e.get(e2);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF g2 = this.k.g();
        PointF g3 = this.l.g();
        com.vivo.mobilead.lottie.c.b.c g4 = this.f29013j.g();
        int[] a2 = a(g4.b());
        float[] a3 = g4.a();
        RectF rectF = this.f29010g;
        int width = (int) (rectF.left + (rectF.width() / 2.0f) + g2.x);
        RectF rectF2 = this.f29010g;
        int height = (int) (rectF2.top + (rectF2.height() / 2.0f) + g2.y);
        RectF rectF3 = this.f29010g;
        int width2 = (int) (rectF3.left + (rectF3.width() / 2.0f) + g3.x);
        RectF rectF4 = this.f29010g;
        LinearGradient linearGradient2 = new LinearGradient(width, height, width2, (int) (rectF4.top + (rectF4.height() / 2.0f) + g3.y), a2, a3, Shader.TileMode.CLAMP);
        this.f29008e.put(e2, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient d() {
        long e2 = e();
        RadialGradient radialGradient = this.f29009f.get(e2);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF g2 = this.k.g();
        PointF g3 = this.l.g();
        com.vivo.mobilead.lottie.c.b.c g4 = this.f29013j.g();
        int[] a2 = a(g4.b());
        float[] a3 = g4.a();
        RectF rectF = this.f29010g;
        int width = (int) (rectF.left + (rectF.width() / 2.0f) + g2.x);
        RectF rectF2 = this.f29010g;
        int height = (int) (rectF2.top + (rectF2.height() / 2.0f) + g2.y);
        RectF rectF3 = this.f29010g;
        int width2 = (int) (rectF3.left + (rectF3.width() / 2.0f) + g3.x);
        RectF rectF4 = this.f29010g;
        RadialGradient radialGradient2 = new RadialGradient(width, height, (float) Math.hypot(width2 - width, ((int) ((rectF4.top + (rectF4.height() / 2.0f)) + g3.y)) - height), a2, a3, Shader.TileMode.CLAMP);
        this.f29009f.put(e2, radialGradient2);
        return radialGradient2;
    }

    private int e() {
        int round = Math.round(this.k.h() * this.f29012i);
        int round2 = Math.round(this.l.h() * this.f29012i);
        int round3 = Math.round(this.f29013j.h() * this.f29012i);
        int i2 = round != 0 ? round * 527 : 17;
        if (round2 != 0) {
            i2 = i2 * 31 * round2;
        }
        return round3 != 0 ? i2 * 31 * round3 : i2;
    }

    @Override // com.vivo.mobilead.lottie.a.a.a, com.vivo.mobilead.lottie.a.a.e
    public void a(Canvas canvas, Matrix matrix, int i2) {
        if (this.f29007d) {
            return;
        }
        a(this.f29010g, matrix, false);
        this.f28957b.setShader(this.f29011h == com.vivo.mobilead.lottie.c.b.f.LINEAR ? c() : d());
        super.a(canvas, matrix, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.vivo.mobilead.lottie.a.a.a, com.vivo.mobilead.lottie.c.f
    public <T> void a(T t, com.vivo.mobilead.lottie.g.c<T> cVar) {
        super.a((i) t, (com.vivo.mobilead.lottie.g.c<i>) cVar);
        if (t == com.vivo.mobilead.lottie.g.C) {
            if (cVar == null) {
                com.vivo.mobilead.lottie.a.b.p pVar = this.m;
                if (pVar != null) {
                    this.f28956a.b(pVar);
                }
                this.m = null;
                return;
            }
            com.vivo.mobilead.lottie.a.b.p pVar2 = new com.vivo.mobilead.lottie.a.b.p(cVar);
            this.m = pVar2;
            pVar2.a(this);
            this.f28956a.a(this.m);
        }
    }

    @Override // com.vivo.mobilead.lottie.a.a.c
    public String b() {
        return this.f29006c;
    }
}

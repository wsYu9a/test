package com.vivo.mobilead.lottie.a.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;

/* loaded from: classes4.dex */
public class i extends f<PointF> {

    /* renamed from: c */
    private final PointF f29089c;

    /* renamed from: d */
    private final float[] f29090d;

    /* renamed from: e */
    private h f29091e;

    /* renamed from: f */
    private PathMeasure f29092f;

    public i(List<? extends com.vivo.mobilead.lottie.g.a<PointF>> list) {
        super(list);
        this.f29089c = new PointF();
        this.f29090d = new float[2];
        this.f29092f = new PathMeasure();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.vivo.mobilead.lottie.a.b.a
    /* renamed from: b */
    public PointF a(com.vivo.mobilead.lottie.g.a<PointF> aVar, float f2) {
        PointF pointF;
        h hVar = (h) aVar;
        Path b2 = hVar.b();
        if (b2 == null) {
            return aVar.f29463a;
        }
        com.vivo.mobilead.lottie.g.c<A> cVar = this.f29074b;
        if (cVar != 0 && (pointF = (PointF) cVar.a(hVar.f29466d, hVar.f29467e.floatValue(), hVar.f29463a, hVar.f29464b, d(), f2, h())) != null) {
            return pointF;
        }
        if (this.f29091e != hVar) {
            this.f29092f.setPath(b2, false);
            this.f29091e = hVar;
        }
        PathMeasure pathMeasure = this.f29092f;
        pathMeasure.getPosTan(f2 * pathMeasure.getLength(), this.f29090d, null);
        PointF pointF2 = this.f29089c;
        float[] fArr = this.f29090d;
        pointF2.set(fArr[0], fArr[1]);
        return this.f29089c;
    }
}

package com.vivo.mobilead.lottie.a.b;

import android.graphics.PointF;
import java.util.List;

/* loaded from: classes4.dex */
public class j extends f<PointF> {

    /* renamed from: c */
    private final PointF f29093c;

    public j(List<com.vivo.mobilead.lottie.g.a<PointF>> list) {
        super(list);
        this.f29093c = new PointF();
    }

    @Override // com.vivo.mobilead.lottie.a.b.a
    /* renamed from: b */
    public PointF a(com.vivo.mobilead.lottie.g.a<PointF> aVar, float f2) {
        PointF pointF;
        PointF pointF2;
        PointF pointF3 = aVar.f29463a;
        if (pointF3 == null || (pointF = aVar.f29464b) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF4 = pointF3;
        PointF pointF5 = pointF;
        com.vivo.mobilead.lottie.g.c<A> cVar = this.f29074b;
        if (cVar != 0 && (pointF2 = (PointF) cVar.a(aVar.f29466d, aVar.f29467e.floatValue(), pointF4, pointF5, f2, d(), h())) != null) {
            return pointF2;
        }
        PointF pointF6 = this.f29093c;
        float f3 = pointF4.x;
        float f4 = f3 + ((pointF5.x - f3) * f2);
        float f5 = pointF4.y;
        pointF6.set(f4, f5 + (f2 * (pointF5.y - f5)));
        return this.f29093c;
    }
}

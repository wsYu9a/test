package com.vivo.mobilead.lottie.a.b;

import android.graphics.Path;
import android.graphics.PointF;
import com.vivo.mobilead.lottie.LottieComposition;

/* loaded from: classes4.dex */
public class h extends com.vivo.mobilead.lottie.g.a<PointF> {

    /* renamed from: h */
    private Path f29087h;

    /* renamed from: i */
    private final com.vivo.mobilead.lottie.g.a<PointF> f29088i;

    public h(LottieComposition lottieComposition, com.vivo.mobilead.lottie.g.a<PointF> aVar) {
        super(lottieComposition, aVar.f29463a, aVar.f29464b, aVar.f29465c, aVar.f29466d, aVar.f29467e);
        this.f29088i = aVar;
        a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a() {
        boolean z;
        T t;
        T t2;
        T t3 = this.f29464b;
        if (t3 != 0 && (t2 = this.f29463a) != 0) {
            PointF pointF = (PointF) t3;
            if (((PointF) t2).equals(pointF.x, pointF.y)) {
                z = true;
                t = this.f29464b;
                if (t != 0 || z) {
                }
                com.vivo.mobilead.lottie.g.a<PointF> aVar = this.f29088i;
                this.f29087h = com.vivo.mobilead.lottie.f.h.a((PointF) this.f29463a, (PointF) t, aVar.f29468f, aVar.f29469g);
                return;
            }
        }
        z = false;
        t = this.f29464b;
        if (t != 0) {
        }
    }

    Path b() {
        return this.f29087h;
    }
}

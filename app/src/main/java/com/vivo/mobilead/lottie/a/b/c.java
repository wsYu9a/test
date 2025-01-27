package com.vivo.mobilead.lottie.a.b;

import java.util.List;

/* loaded from: classes4.dex */
public class c extends f<Float> {
    public c(List<com.vivo.mobilead.lottie.g.a<Float>> list) {
        super(list);
    }

    @Override // com.vivo.mobilead.lottie.a.b.a
    /* renamed from: b */
    public Float a(com.vivo.mobilead.lottie.g.a<Float> aVar, float f2) {
        return Float.valueOf(c(aVar, f2));
    }

    float c(com.vivo.mobilead.lottie.g.a<Float> aVar, float f2) {
        Float f3;
        if (aVar.f29463a == null || aVar.f29464b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.vivo.mobilead.lottie.g.c<A> cVar = this.f29074b;
        return (cVar == 0 || (f3 = (Float) cVar.a(aVar.f29466d, aVar.f29467e.floatValue(), aVar.f29463a, aVar.f29464b, f2, d(), h())) == null) ? com.vivo.mobilead.lottie.f.g.a(aVar.f(), aVar.g(), f2) : f3.floatValue();
    }

    public float i() {
        return c(c(), e());
    }
}

package com.vivo.mobilead.lottie.a.b;

import java.util.List;

/* loaded from: classes4.dex */
public class e extends f<Integer> {
    public e(List<com.vivo.mobilead.lottie.g.a<Integer>> list) {
        super(list);
    }

    @Override // com.vivo.mobilead.lottie.a.b.a
    /* renamed from: b */
    public Integer a(com.vivo.mobilead.lottie.g.a<Integer> aVar, float f2) {
        return Integer.valueOf(c(aVar, f2));
    }

    int c(com.vivo.mobilead.lottie.g.a<Integer> aVar, float f2) {
        Integer num;
        if (aVar.f29463a == null || aVar.f29464b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.vivo.mobilead.lottie.g.c<A> cVar = this.f29074b;
        return (cVar == 0 || (num = (Integer) cVar.a(aVar.f29466d, aVar.f29467e.floatValue(), aVar.f29463a, aVar.f29464b, f2, d(), h())) == null) ? com.vivo.mobilead.lottie.f.g.a(aVar.h(), aVar.i(), f2) : num.intValue();
    }

    public int i() {
        return c(c(), e());
    }
}

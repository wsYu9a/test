package com.vivo.mobilead.lottie.a.b;

import java.util.List;

/* loaded from: classes4.dex */
public class b extends f<Integer> {
    public b(List<com.vivo.mobilead.lottie.g.a<Integer>> list) {
        super(list);
    }

    @Override // com.vivo.mobilead.lottie.a.b.a
    /* renamed from: b */
    public Integer a(com.vivo.mobilead.lottie.g.a<Integer> aVar, float f2) {
        return Integer.valueOf(c(aVar, f2));
    }

    public int c(com.vivo.mobilead.lottie.g.a<Integer> aVar, float f2) {
        Integer num;
        Integer num2 = aVar.f29463a;
        if (num2 == null || aVar.f29464b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        int intValue = num2.intValue();
        int intValue2 = aVar.f29464b.intValue();
        com.vivo.mobilead.lottie.g.c<A> cVar = this.f29074b;
        return (cVar == 0 || (num = (Integer) cVar.a(aVar.f29466d, aVar.f29467e.floatValue(), Integer.valueOf(intValue), Integer.valueOf(intValue2), f2, d(), h())) == null) ? com.vivo.mobilead.lottie.f.b.a(com.vivo.mobilead.lottie.f.g.b(f2, 0.0f, 1.0f), intValue, intValue2) : num.intValue();
    }

    public int i() {
        return c(c(), e());
    }
}

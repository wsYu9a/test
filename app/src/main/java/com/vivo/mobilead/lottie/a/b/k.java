package com.vivo.mobilead.lottie.a.b;

import java.util.List;

/* loaded from: classes4.dex */
public class k extends f<com.vivo.mobilead.lottie.g.d> {

    /* renamed from: c */
    private final com.vivo.mobilead.lottie.g.d f29094c;

    public k(List<com.vivo.mobilead.lottie.g.a<com.vivo.mobilead.lottie.g.d>> list) {
        super(list);
        this.f29094c = new com.vivo.mobilead.lottie.g.d();
    }

    @Override // com.vivo.mobilead.lottie.a.b.a
    /* renamed from: b */
    public com.vivo.mobilead.lottie.g.d a(com.vivo.mobilead.lottie.g.a<com.vivo.mobilead.lottie.g.d> aVar, float f2) {
        com.vivo.mobilead.lottie.g.d dVar;
        com.vivo.mobilead.lottie.g.d dVar2;
        com.vivo.mobilead.lottie.g.d dVar3 = aVar.f29463a;
        if (dVar3 == null || (dVar = aVar.f29464b) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.vivo.mobilead.lottie.g.d dVar4 = dVar3;
        com.vivo.mobilead.lottie.g.d dVar5 = dVar;
        com.vivo.mobilead.lottie.g.c<A> cVar = this.f29074b;
        if (cVar != 0 && (dVar2 = (com.vivo.mobilead.lottie.g.d) cVar.a(aVar.f29466d, aVar.f29467e.floatValue(), dVar4, dVar5, f2, d(), h())) != null) {
            return dVar2;
        }
        this.f29094c.a(com.vivo.mobilead.lottie.f.g.a(dVar4.a(), dVar5.a(), f2), com.vivo.mobilead.lottie.f.g.a(dVar4.b(), dVar5.b(), f2));
        return this.f29094c;
    }
}

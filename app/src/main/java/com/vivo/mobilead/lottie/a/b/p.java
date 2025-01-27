package com.vivo.mobilead.lottie.a.b;

import java.util.Collections;

/* loaded from: classes4.dex */
public class p<K, A> extends a<K, A> {

    /* renamed from: c */
    private final com.vivo.mobilead.lottie.g.b<A> f29110c;

    /* renamed from: d */
    private final A f29111d;

    public p(com.vivo.mobilead.lottie.g.c<A> cVar) {
        this(cVar, null);
    }

    public p(com.vivo.mobilead.lottie.g.c<A> cVar, A a2) {
        super(Collections.emptyList());
        this.f29110c = new com.vivo.mobilead.lottie.g.b<>();
        a(cVar);
        this.f29111d = a2;
    }

    @Override // com.vivo.mobilead.lottie.a.b.a
    A a(com.vivo.mobilead.lottie.g.a<K> aVar, float f2) {
        return g();
    }

    @Override // com.vivo.mobilead.lottie.a.b.a
    public void b() {
        if (this.f29074b != null) {
            super.b();
        }
    }

    @Override // com.vivo.mobilead.lottie.a.b.a
    float f() {
        return 1.0f;
    }

    @Override // com.vivo.mobilead.lottie.a.b.a
    public A g() {
        com.vivo.mobilead.lottie.g.c<A> cVar = this.f29074b;
        A a2 = this.f29111d;
        return cVar.a(0.0f, 0.0f, a2, a2, h(), h(), h());
    }
}

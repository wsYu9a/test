package com.vivo.mobilead.lottie.a.a;

import com.vivo.mobilead.lottie.a.b.a;
import com.vivo.mobilead.lottie.c.b.q;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class s implements c, a.InterfaceC0598a {

    /* renamed from: a */
    private final String f29064a;

    /* renamed from: b */
    private final boolean f29065b;

    /* renamed from: c */
    private final List<a.InterfaceC0598a> f29066c = new ArrayList();

    /* renamed from: d */
    private final q.a f29067d;

    /* renamed from: e */
    private final com.vivo.mobilead.lottie.a.b.a<?, Float> f29068e;

    /* renamed from: f */
    private final com.vivo.mobilead.lottie.a.b.a<?, Float> f29069f;

    /* renamed from: g */
    private final com.vivo.mobilead.lottie.a.b.a<?, Float> f29070g;

    public s(com.vivo.mobilead.lottie.c.c.a aVar, com.vivo.mobilead.lottie.c.b.q qVar) {
        this.f29064a = qVar.a();
        this.f29065b = qVar.f();
        this.f29067d = qVar.b();
        com.vivo.mobilead.lottie.a.b.a<Float, Float> a2 = qVar.d().a();
        this.f29068e = a2;
        com.vivo.mobilead.lottie.a.b.a<Float, Float> a3 = qVar.c().a();
        this.f29069f = a3;
        com.vivo.mobilead.lottie.a.b.a<Float, Float> a4 = qVar.e().a();
        this.f29070g = a4;
        aVar.a(a2);
        aVar.a(a3);
        aVar.a(a4);
        a2.a(this);
        a3.a(this);
        a4.a(this);
    }

    @Override // com.vivo.mobilead.lottie.a.b.a.InterfaceC0598a
    public void a() {
        for (int i2 = 0; i2 < this.f29066c.size(); i2++) {
            this.f29066c.get(i2).a();
        }
    }

    void a(a.InterfaceC0598a interfaceC0598a) {
        this.f29066c.add(interfaceC0598a);
    }

    @Override // com.vivo.mobilead.lottie.a.a.c
    public void a(List<c> list, List<c> list2) {
    }

    @Override // com.vivo.mobilead.lottie.a.a.c
    public String b() {
        return this.f29064a;
    }

    q.a c() {
        return this.f29067d;
    }

    public com.vivo.mobilead.lottie.a.b.a<?, Float> d() {
        return this.f29068e;
    }

    public com.vivo.mobilead.lottie.a.b.a<?, Float> e() {
        return this.f29069f;
    }

    public com.vivo.mobilead.lottie.a.b.a<?, Float> f() {
        return this.f29070g;
    }

    public boolean g() {
        return this.f29065b;
    }
}

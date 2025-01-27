package com.vivo.mobilead.lottie.a.b;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class a<K, A> {

    /* renamed from: b */
    protected com.vivo.mobilead.lottie.g.c<A> f29074b;

    /* renamed from: d */
    private final List<? extends com.vivo.mobilead.lottie.g.a<K>> f29076d;

    /* renamed from: f */
    private com.vivo.mobilead.lottie.g.a<K> f29078f;

    /* renamed from: g */
    private com.vivo.mobilead.lottie.g.a<K> f29079g;

    /* renamed from: a */
    final List<InterfaceC0598a> f29073a = new ArrayList(1);

    /* renamed from: c */
    private boolean f29075c = false;

    /* renamed from: e */
    private float f29077e = 0.0f;

    /* renamed from: h */
    private float f29080h = -1.0f;

    /* renamed from: i */
    private A f29081i = null;

    /* renamed from: j */
    private float f29082j = -1.0f;
    private float k = -1.0f;

    /* renamed from: com.vivo.mobilead.lottie.a.b.a$a */
    public interface InterfaceC0598a {
        void a();
    }

    a(List<? extends com.vivo.mobilead.lottie.g.a<K>> list) {
        this.f29076d = list;
    }

    private float i() {
        if (this.f29082j == -1.0f) {
            this.f29082j = this.f29076d.isEmpty() ? 0.0f : this.f29076d.get(0).c();
        }
        return this.f29082j;
    }

    abstract A a(com.vivo.mobilead.lottie.g.a<K> aVar, float f2);

    public void a() {
        this.f29075c = true;
    }

    public void a(float f2) {
        if (this.f29076d.isEmpty()) {
            return;
        }
        com.vivo.mobilead.lottie.g.a<K> c2 = c();
        if (f2 < i()) {
            f2 = i();
        } else if (f2 > f()) {
            f2 = f();
        }
        if (f2 == this.f29077e) {
            return;
        }
        this.f29077e = f2;
        com.vivo.mobilead.lottie.g.a<K> c3 = c();
        if (c2 == c3 && c3.e()) {
            return;
        }
        b();
    }

    public void a(InterfaceC0598a interfaceC0598a) {
        this.f29073a.add(interfaceC0598a);
    }

    public void a(com.vivo.mobilead.lottie.g.c<A> cVar) {
        com.vivo.mobilead.lottie.g.c<A> cVar2 = this.f29074b;
        if (cVar2 != null) {
            cVar2.a((a<?, ?>) null);
        }
        this.f29074b = cVar;
        if (cVar != null) {
            cVar.a((a<?, ?>) this);
        }
    }

    public void b() {
        for (int i2 = 0; i2 < this.f29073a.size(); i2++) {
            this.f29073a.get(i2).a();
        }
    }

    protected com.vivo.mobilead.lottie.g.a<K> c() {
        com.vivo.mobilead.lottie.g.a<K> aVar = this.f29078f;
        if (aVar != null && aVar.a(this.f29077e)) {
            return this.f29078f;
        }
        com.vivo.mobilead.lottie.g.a<K> aVar2 = this.f29076d.get(r0.size() - 1);
        if (this.f29077e < aVar2.c()) {
            for (int size = this.f29076d.size() - 1; size >= 0; size--) {
                aVar2 = this.f29076d.get(size);
                if (aVar2.a(this.f29077e)) {
                    break;
                }
            }
        }
        this.f29078f = aVar2;
        return aVar2;
    }

    float d() {
        if (this.f29075c) {
            return 0.0f;
        }
        com.vivo.mobilead.lottie.g.a<K> c2 = c();
        if (c2.e()) {
            return 0.0f;
        }
        return (this.f29077e - c2.c()) / (c2.d() - c2.c());
    }

    protected float e() {
        com.vivo.mobilead.lottie.g.a<K> c2 = c();
        if (c2.e()) {
            return 0.0f;
        }
        return c2.f29465c.getInterpolation(d());
    }

    float f() {
        float d2;
        if (this.k == -1.0f) {
            if (this.f29076d.isEmpty()) {
                d2 = 1.0f;
            } else {
                d2 = this.f29076d.get(r0.size() - 1).d();
            }
            this.k = d2;
        }
        return this.k;
    }

    public A g() {
        com.vivo.mobilead.lottie.g.a<K> c2 = c();
        float e2 = e();
        if (this.f29074b == null && c2 == this.f29079g && this.f29080h == e2) {
            return this.f29081i;
        }
        this.f29079g = c2;
        this.f29080h = e2;
        A a2 = a(c2, e2);
        this.f29081i = a2;
        return a2;
    }

    public float h() {
        return this.f29077e;
    }
}

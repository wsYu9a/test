package com.martian.ttbook.b.c.a.a.b.a.d.a.g;

import android.view.View;
import android.view.ViewGroup;
import com.martian.ttbook.b.c.a.a.b.a.d.k;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.i;
import com.martian.ttbook.b.c.a.a.e.d;
import com.martian.ttbook.b.c.a.a.e.j;
import com.qumeng.advlib.core.AdRequestParam;
import com.qumeng.advlib.core.IMultiAdObject;
import com.qumeng.advlib.core.IMultiAdRequest;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class a extends k {
    private String q;
    private AtomicBoolean r;
    private IMultiAdObject s;
    int t;
    private AdRequestParam.ADLoadListener u;
    private IMultiAdObject.SplashEventListener v;

    /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.a.g.a$a */
    class RunnableC0295a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ com.martian.ttbook.b.c.a.a.d.b.m.a f15261a;

        RunnableC0295a(com.martian.ttbook.b.c.a.a.d.b.m.a aVar) {
            this.f15261a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.super.E(this.f15261a);
        }
    }

    class b implements AdRequestParam.ADLoadListener {
        b() {
        }

        public void a(IMultiAdObject iMultiAdObject) {
            d.g(a.this.q, "onSplashScreenAdLoad " + iMultiAdObject);
            if (iMultiAdObject == null) {
                a.this.J(new i(10008, "广告无填充"));
                return;
            }
            int c2 = com.martian.ttbook.b.c.a.a.b.a.d.a.b.c(iMultiAdObject);
            if (com.martian.ttbook.b.c.a.a.b.a.d.a.b.f(a.this.f15663d, c2)) {
                a.this.B(c2);
                return;
            }
            a.this.s = iMultiAdObject;
            a aVar = a.this;
            aVar.t = c2;
            com.martian.ttbook.b.c.a.a.b.a.d.a.b.g(aVar.f15661b, c2, aVar.f15663d);
            ArrayList arrayList = new ArrayList();
            arrayList.add(a.this);
            a.this.K(arrayList);
        }

        public void b(String str) {
            d.g(a.this.q, "onError  s = " + str);
            a.this.J(new i(-3000, str));
        }
    }

    class c implements IMultiAdObject.SplashEventListener {
        c() {
        }

        public void a() {
            d.g(a.this.q, "onObClicked");
            a.this.L();
        }

        public void b() {
            d.g(a.this.q, "onObShow");
            a.this.N();
        }

        public void c() {
            d.g(a.this.q, "onObSkip");
            a.this.M();
        }

        public void d() {
            d.g(a.this.q, "onObTimeOver");
            a.this.M();
        }
    }

    public a(com.martian.ttbook.b.c.a.a.d.b.d dVar, e eVar) {
        super(dVar, eVar);
        this.q = "QMSPTAG";
        this.r = new AtomicBoolean();
        this.u = new b();
        this.v = new c();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.k
    public void E(com.martian.ttbook.b.c.a.a.d.b.m.a aVar) {
        j.b(new RunnableC0295a(aVar), 500L);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.k
    public void H(View view) {
        d.g(this.q, "handle");
        this.m = false;
        IMultiAdRequest e2 = com.martian.ttbook.b.c.a.a.b.a.d.a.b.e(this.f15662c.f15670d, this.f15663d.f15701c.d(e.c.U, ""));
        d.g(this.q, "s = " + view + ",f = " + this.f15662c.n);
        AdRequestParam build = new AdRequestParam.Builder().adslotID(this.f15663d.f15701c.l(e.c.Q)).adType(6).adLoadListener(this.u).build();
        if (e2 != null) {
            e2.invokeADV(build);
        }
        new com.martian.ttbook.b.c.a.a.d.b.k(this.f15662c, this.f15663d).a(3).h();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.k
    public void I(ViewGroup viewGroup) {
        d.g(this.q, "showAd");
        if (!this.r.compareAndSet(false, true) || viewGroup == null || this.s == null) {
            return;
        }
        d.g(this.q, "showAd show");
        this.s.showSplashView(viewGroup, this.v);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.k, com.martian.ttbook.b.c.a.a.c.p.a
    public Map<String, Object> a() {
        return this.f15661b;
    }
}

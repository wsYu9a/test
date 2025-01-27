package com.martian.ttbook.b.c.a.a.b.a.d.b.c;

import com.martian.ttbook.b.a.k.n;
import com.martian.ttbook.b.c.a.a.b.a.d.h;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.i;
import com.martian.ttbook.b.c.a.a.d.b.k;
import com.martian.ttbook.b.c.a.a.d.b.l;
import com.martian.ttbook.b.c.a.a.e.d;
import com.martian.ttbook.b.c.a.a.e.j;
import com.opos.acs.st.utils.ErrorContants;
import com.umeng.union.UMUnionSdk;
import com.umeng.union.api.UMUnionApi;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class a extends h {

    /* renamed from: f */
    private boolean f15292f;

    /* renamed from: g */
    private Object[] f15293g;

    /* renamed from: h */
    private UMUnionApi.AdCallback f15294h;

    /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.b.c.a$a */
    class C0300a extends UMUnionApi.AdCallback {

        /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.b.c.a$a$a */
        class RunnableC0301a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ List f15296a;

            RunnableC0301a(List list) {
                this.f15296a = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                ((com.martian.ttbook.b.c.a.a.c.n.b) a.this.f15662c.f15673g).onAdLoaded(this.f15296a);
                ((com.martian.ttbook.b.c.a.a.c.n.b) a.this.f15662c.f15673g).onAdShow();
                ((com.martian.ttbook.b.c.a.a.c.n.b) a.this.f15662c.f15673g).onAdExposed();
            }
        }

        /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.b.c.a$a$b */
        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                Object obj = aVar.f15662c.f15668b;
                Object[] objArr = aVar.f15293g;
                a aVar2 = a.this;
                l.o(obj, objArr, aVar2.f15662c.f15671e, Integer.valueOf(aVar2.f15663d.f()));
                a aVar3 = a.this;
                l.s(aVar3.f15662c.f15668b, aVar3.f15663d.e(), a.this.f15663d.b());
                byte[] h2 = a.this.f15662c.r.h();
                if (h2 != null) {
                    l.j(a.this.f15662c.f15668b, h2);
                }
                l.i(a.this.f15293g, true, true);
                l.q(a.this.f15293g, 2);
            }
        }

        /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.b.c.a$a$c */
        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ((com.martian.ttbook.b.c.a.a.c.n.b) a.this.f15662c.f15673g).onAdClicked();
            }
        }

        C0300a() {
        }

        public void a(UMUnionApi.AdType adType) {
            d.g("UMINTAG", "AdCallback onClicked type:" + adType.name());
            l.i(a.this.f15293g, false, true);
            a aVar = a.this;
            k kVar = new k(aVar.f15662c, aVar.f15663d);
            a aVar2 = a.this;
            boolean g2 = kVar.g(aVar2.f15663d, null, 0L, aVar2.f15293g);
            kVar.h();
            if (g2 && (a.this.f15662c.f15673g instanceof com.martian.ttbook.b.c.a.a.c.n.b)) {
                j.c(new c());
            }
        }

        public void b(UMUnionApi.AdType adType, String str) {
            d.g("UMINTAG", "AdCallback onFailure type:" + adType.name() + " msg:" + str);
            a.this.F(new i(-3000, "type " + adType.name() + ", msg " + str));
        }

        public void c(UMUnionApi.AdType adType) {
            d.g("UMINTAG", "thread " + Thread.currentThread().getName());
            d.g("UMINTAG", "AdCallback onShow type:" + adType.name());
            a.this.f15292f = true;
            a aVar = a.this;
            new k(aVar.f15662c, aVar.f15663d).a(4).h();
            a aVar2 = a.this;
            new k(aVar2.f15662c, aVar2.f15663d).a(5).c(k.b.q, a.this.f15663d.f15700b.d(e.c.f15716f, ErrorContants.NET_ERROR)).h();
            ArrayList arrayList = new ArrayList();
            arrayList.add(a.this);
            if (a.this.f15662c.f15673g instanceof com.martian.ttbook.b.c.a.a.c.n.b) {
                j.c(new RunnableC0301a(arrayList));
            }
            n.c(new b(), 1L);
        }
    }

    class b implements UMUnionApi.AdCloseListener {
        b() {
        }

        public void a(UMUnionApi.AdType adType) {
            d.g("UMINTAG", "onClosed");
            a aVar = a.this;
            new k(aVar.f15662c, aVar.f15663d).a(1).h();
            com.martian.ttbook.b.c.a.a.c.e eVar = a.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.n.b) {
                ((com.martian.ttbook.b.c.a.a.c.n.b) eVar).onAdDismissed();
            }
        }
    }

    class c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ i f15301a;

        c(i iVar) {
            this.f15301a = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f15662c.f15673g.a(this.f15301a);
        }
    }

    public a(com.martian.ttbook.b.c.a.a.d.b.d dVar, e eVar) {
        super(dVar, eVar);
        this.f15292f = false;
        this.f15294h = new C0300a();
        this.f15293g = com.martian.ttbook.b.c.a.a.b.n();
    }

    public void F(i iVar) {
        new k(this.f15662c, this.f15663d).a(2).b(iVar).h();
        if (this.f15292f || !this.f15663d.k()) {
            j.c(new c(iVar));
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.c.a
    public void c(com.martian.ttbook.b.c.a.a.b.a.c cVar) {
        this.f15664e = cVar;
    }

    @Override // com.martian.ttbook.b.c.a.a.d.b.a
    public void w() {
        d.g("UMINTAG", "handle enter");
        com.martian.ttbook.b.c.a.a.b.a.d.n.g(this.f15662c.f15670d.getApplicationContext(), this.f15663d.f15701c.d(e.c.U, ""), this.f15663d.f15701c.d(e.c.T, "union_sdk"));
        this.f15292f = false;
        new k(this.f15662c, this.f15663d).a(3).h();
        d.g("UMINTAG", "load ad");
        UMUnionSdk.setAdCallback(this.f15294h);
        UMUnionSdk.loadInterstitialAd(com.martian.ttbook.b.c.a.a.d.a.d.v.d.a.a.a(this.f15662c.f15670d), new b());
    }
}

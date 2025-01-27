package com.martian.ttbook.b.c.a.a.b.a.d.b.d;

import android.view.View;
import android.view.ViewGroup;
import com.martian.ttbook.b.c.a.a.b.a.d.k;
import com.martian.ttbook.b.c.a.a.b.a.d.n;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.i;
import com.martian.ttbook.b.c.a.a.e.d;
import com.martian.ttbook.b.c.a.a.e.j;
import com.martian.ttbook.sdk.client.AdExtras;
import com.umeng.union.UMSplashAD;
import com.umeng.union.UMUnionSdk;
import com.umeng.union.api.UMUnionApi;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class a extends k {
    private UMSplashAD q;
    private AtomicBoolean r;

    /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.b.d.a$a */
    class C0302a implements UMUnionApi.AdLoadListener<UMSplashAD> {

        /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.b.d.a$a$a */
        class RunnableC0303a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ List f15304a;

            RunnableC0303a(List list) {
                this.f15304a = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.K(this.f15304a);
            }
        }

        /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.b.d.a$a$b */
        class b implements Runnable {

            /* renamed from: a */
            final /* synthetic */ UMUnionApi.AdType f15306a;

            /* renamed from: b */
            final /* synthetic */ String f15307b;

            b(UMUnionApi.AdType adType, String str) {
                this.f15306a = adType;
                this.f15307b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.J(new i(-3000, "failed type " + this.f15306a.name() + ", msg " + this.f15307b));
            }
        }

        C0302a() {
        }

        /* renamed from: a */
        public void c(UMUnionApi.AdType adType, UMSplashAD uMSplashAD) {
            d.g("UMSPTAG", "onSuccess");
            a.this.q = uMSplashAD;
            int price = a.this.q.getPrice();
            d.g("UMSPTAG", "ad ecpm " + price);
            a.this.f15661b.put(AdExtras.EXTRA_ECPM, String.valueOf(price));
            ArrayList arrayList = new ArrayList();
            arrayList.add(a.this);
            j.c(new RunnableC0303a(arrayList));
        }

        public void b(UMUnionApi.AdType adType, String str) {
            d.g("UMSPTAG", "onFailure");
            j.c(new b(adType, str));
        }
    }

    class b extends UMUnionApi.SplashAdListener {

        /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.b.d.a$b$a */
        class RunnableC0304a implements Runnable {
            RunnableC0304a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.M();
            }
        }

        /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.b.d.a$b$b */
        class RunnableC0305b implements Runnable {
            RunnableC0305b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.N();
            }
        }

        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.L();
            }
        }

        class d implements Runnable {

            /* renamed from: a */
            final /* synthetic */ int f15313a;

            /* renamed from: b */
            final /* synthetic */ String f15314b;

            d(int i2, String str) {
                this.f15313a = i2;
                this.f15314b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.J(new i(-3000, "failed  " + this.f15313a + ", msg " + this.f15314b));
            }
        }

        b() {
        }

        public void a(View view) {
            com.martian.ttbook.b.c.a.a.e.d.g("UMSPTAG", "onClicked");
            j.c(new c());
        }

        public void b() {
            com.martian.ttbook.b.c.a.a.e.d.g("UMSPTAG", "onDismissed");
            j.c(new RunnableC0304a());
        }

        public void c(int i2, String str) {
            com.martian.ttbook.b.c.a.a.e.d.c("UMSPTAG", "onError i %s, s %s", Integer.valueOf(i2), str);
            j.c(new d(i2, str));
        }

        public void d() {
            com.martian.ttbook.b.c.a.a.e.d.g("UMSPTAG", "onExposed");
            j.c(new RunnableC0305b());
        }
    }

    public a(com.martian.ttbook.b.c.a.a.d.b.d dVar, e eVar) {
        super(dVar, eVar);
        this.r = new AtomicBoolean();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.k
    public void H(View view) {
        this.m = false;
        n.g(this.f15662c.f15670d.getApplicationContext(), this.f15663d.f15701c.d(e.c.U, ""), this.f15663d.f15701c.d(e.c.T, "union_sdk"));
        new com.martian.ttbook.b.c.a.a.d.b.k(this.f15662c, this.f15663d).a(3).h();
        UMUnionSdk.loadSplashAd(new C0302a(), this.f15662c.n);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.k
    public void I(ViewGroup viewGroup) {
        if (viewGroup == null || this.q == null || !this.r.compareAndSet(false, true)) {
            return;
        }
        this.q.setAdEventListener(new b());
        this.q.show(viewGroup);
    }
}

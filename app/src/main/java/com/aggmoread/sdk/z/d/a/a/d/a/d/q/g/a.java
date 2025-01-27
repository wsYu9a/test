package com.aggmoread.sdk.z.d.a.a.d.a.d.q.g;

import android.app.Activity;
import android.content.Context;
import com.aggmoread.sdk.z.d.a.a.d.a.d.g;
import com.aggmoread.sdk.z.d.a.a.d.a.d.q.c;
import com.aggmoread.sdk.z.d.a.a.d.b.d;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.d.b.i;
import com.aggmoread.sdk.z.d.a.a.d.b.k;
import com.aggmoread.sdk.z.d.a.a.d.b.l;
import com.aggmoread.sdk.z.d.a.a.e.e;
import com.aggmoread.sdk.z.d.a.a.e.n;
import com.baidu.mobads.sdk.api.ExpressInterstitialAd;
import com.baidu.mobads.sdk.api.RequestParameters;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class a extends g {

    /* renamed from: p */
    private ExpressInterstitialAd f5504p;

    /* renamed from: q */
    private AtomicBoolean f5505q;

    /* renamed from: r */
    private c.j f5506r;

    /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.q.g.a$a */
    public class C0135a implements c.j {

        /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.q.g.a$a$a */
        public class RunnableC0136a implements Runnable {

            /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.q.g.a$a$a$a */
            public class RunnableC0137a implements Runnable {
                public RunnableC0137a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    l.a(((g) a.this).f5343n, 2);
                }
            }

            public RunnableC0136a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                Object obj = aVar.f5842g.f5856b;
                Object[] objArr = ((g) aVar).f5343n;
                a aVar2 = a.this;
                l.a(obj, objArr, aVar2.f5842g.f5859e, Integer.valueOf(aVar2.f5843h.f()));
                a aVar3 = a.this;
                l.b(aVar3.f5842g.f5856b, aVar3.f5843h.e(), a.this.f5843h.b());
                byte[] b10 = a.this.f5842g.f5872r.b();
                if (b10 != null) {
                    l.a(a.this.f5842g.f5856b, b10);
                }
                l.a((Object) ((g) a.this).f5343n, true, true);
                l.a(((g) a.this).f5343n, a.this.f5843h);
                n.a(new RunnableC0137a(), 3000L);
            }
        }

        public C0135a() {
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.q.c.j
        public void a(int i10, String str) {
            e.b("AMITAGBD", "onNoAD " + i10 + ", " + str);
            a.this.b(new i(i10, str));
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.q.c.j
        public void b() {
            e.b("AMITAGBD", "onAdCacheFailed");
            a.this.b(new i(-1000, "视频素材缓存失败"));
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.q.c.j
        public void c() {
            e.b("AMITAGBD", "onLpClosed");
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.q.c.j
        public void d() {
            e.b("AMITAGBD", "onAdCacheSuccess");
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.q.c.j
        public void f() {
            e.b("AMITAGBD", "onADReceive");
            int a10 = com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a((Object) a.this.f5504p);
            if (com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a(a.this.f5843h, a10)) {
                a.this.a(a10, 0);
            } else {
                a.this.b(a10);
                ((g) a.this).f5342m = true;
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.q.c.j
        public void g() {
            e.b("AMITAGBD", "onADExposureFailed");
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.q.c.j
        public void onADExposed() {
            e.b("AMITAGBD", "onADExposure");
            a.this.v();
            a.this.t();
            n.a(new RunnableC0136a(), 1L);
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.q.c.j
        public void onAdClick() {
            e.b("AMITAGBD", "onADClicked");
            a.this.r();
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.q.c.j
        public void onAdClose() {
            e.b("AMITAGBD", "onADClosed");
            a.this.s();
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.q.c.j
        public void onVideoDownloadFailed() {
            e.b("AMITAGBD", "onVideoDownloadFailed");
            a.this.b(new i(-1000, "视频素材缓存失败"));
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.q.c.j
        public void onVideoDownloadSuccess() {
            e.b("AMITAGBD", "onVideoDownloadSuccess");
            if (((g) a.this).f5342m) {
                a aVar = a.this;
                com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.b(aVar.f5841f, com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a((Object) aVar.f5504p), a.this.f5843h);
                a.this.u();
                a.this.w();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.q.c.j
        public void b(int i10, String str) {
            e.b("AMITAGBD", "onAdFailed " + i10 + ", " + str);
            a.this.b(new i(i10, str));
        }
    }

    public class b implements Runnable {

        /* renamed from: b */
        final /* synthetic */ Activity f5510b;

        public b(Activity activity) {
            this.f5510b = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f5504p != null) {
                a.this.f5504p.show(this.f5510b);
            }
        }
    }

    public a(d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        super(dVar, eVar);
        this.f5505q = new AtomicBoolean();
        this.f5506r = new C0135a();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.g, com.aggmoread.sdk.z.d.a.a.c.q.b
    public void b() {
        e.b("AMITAGBD", "show()");
        Context context = this.f5842g.f5858d;
        if (context instanceof Activity) {
            a((Activity) context);
        } else {
            super.b();
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void c(int i10) {
        e.c("win " + i10);
        com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a(this.f5504p, i10);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.q.b
    public void destroy() {
        ExpressInterstitialAd expressInterstitialAd = this.f5504p;
        if (expressInterstitialAd != null) {
            expressInterstitialAd.destroy();
            this.f5504p = null;
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public String j() {
        return com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a().a(this.f5504p);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void l() {
        String a10 = this.f5843h.f5907c.a(e.c.X, "");
        Context a11 = com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a(this.f5842g, this.f5843h, this.f5846k);
        com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a(a11, a10);
        ExpressInterstitialAd expressInterstitialAd = new ExpressInterstitialAd(a11.getApplicationContext(), this.f5843h.f5907c.c(e.c.T));
        this.f5504p = expressInterstitialAd;
        expressInterstitialAd.setLoadListener(c.a().a(this.f5506r));
        this.f5504p.setAppSid(a10);
        this.f5342m = false;
        new k(this.f5842g, this.f5843h).a(0).b();
        try {
            RequestParameters.Builder builder = new RequestParameters.Builder();
            com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a(builder, this.f5842g, this.f5843h);
            com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a(this.f5504p, builder.build());
        } catch (Exception unused) {
        }
        this.f5504p.load();
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMITAGBD", "load enter");
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.q.b
    public void a(Activity activity) {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMITAGBD", "show #2 activity = " + activity);
        if (this.f5342m && this.f5504p != null && this.f5505q.compareAndSet(false, true)) {
            com.aggmoread.sdk.z.d.a.a.e.e.b("AMITAGBD", "show #2 ");
            if (activity == null) {
                super.b();
                return;
            }
            try {
                activity.getWindow().getDecorView().post(new b(activity));
            } catch (Exception e10) {
                com.aggmoread.sdk.z.d.a.a.e.e.b("AMITAGBD", "show #3 " + e10.getMessage());
                ExpressInterstitialAd expressInterstitialAd = this.f5504p;
                if (expressInterstitialAd != null) {
                    expressInterstitialAd.show(activity);
                }
            }
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void b(int i10, int i11, String str) {
        com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a(this.f5504p, "203");
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.g, com.aggmoread.sdk.z.d.a.a.c.a
    public void a(com.aggmoread.sdk.z.d.a.a.d.a.c cVar) {
        this.f5844i = cVar;
    }
}

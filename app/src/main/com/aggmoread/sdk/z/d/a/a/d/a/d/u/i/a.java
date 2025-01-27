package com.aggmoread.sdk.z.d.a.a.d.a.d.u.i;

import android.app.Activity;
import android.content.Context;
import com.aggmoread.sdk.z.d.a.a.c.f;
import com.aggmoread.sdk.z.d.a.a.c.t.b;
import com.aggmoread.sdk.z.d.a.a.d.a.d.g;
import com.aggmoread.sdk.z.d.a.a.d.a.d.u.d;
import com.aggmoread.sdk.z.d.a.a.d.a.d.u.i.b;
import com.aggmoread.sdk.z.d.a.a.d.a.d.u.i.c;
import com.aggmoread.sdk.z.d.a.a.d.b.d;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.d.b.i;
import com.aggmoread.sdk.z.d.a.a.d.b.k;
import com.aggmoread.sdk.z.d.a.a.d.b.l;
import com.aggmoread.sdk.z.d.a.a.e.e;
import com.aggmoread.sdk.z.d.a.a.e.m;
import com.aggmoread.sdk.z.d.a.a.e.n;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.comm.util.AdError;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class a extends g {

    /* renamed from: p */
    private UnifiedInterstitialAD f5724p;

    /* renamed from: q */
    private AtomicBoolean f5725q;

    /* renamed from: r */
    private boolean f5726r;

    /* renamed from: s */
    private b.a f5727s;

    /* renamed from: t */
    private c.a f5728t;

    /* renamed from: u */
    final com.aggmoread.sdk.z.d.a.a.c.t.b f5729u;

    /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.u.i.a$a */
    public class C0165a implements b.a {

        /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.u.i.a$a$a */
        public class RunnableC0166a implements Runnable {

            /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.u.i.a$a$a$a */
            public class RunnableC0167a implements Runnable {
                public RunnableC0167a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    l.a(((g) a.this).f5343n, 2);
                }
            }

            public RunnableC0166a() {
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
                n.a(new RunnableC0167a(), 500L);
            }
        }

        public C0165a() {
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.i.b.a
        public void a() {
            e.b("AMITAGGDT", "onADReceive");
            if (a.this.o()) {
                int a10 = com.aggmoread.sdk.z.d.a.a.d.a.d.u.b.a(a.this.f5724p);
                if (com.aggmoread.sdk.z.d.a.a.d.a.d.u.b.a(a.this.f5843h, a10)) {
                    a.this.a(a10, 0);
                    a.this.f5726r = false;
                    return;
                }
                a.this.b(a10);
            }
            a aVar = a.this;
            com.aggmoread.sdk.z.d.a.a.d.a.d.u.b.a(aVar.f5841f, aVar.f5724p, a.this.f5843h);
            if (a.this.f5726r) {
                return;
            }
            a.this.u();
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.i.b.a
        public void b() {
            e.b("AMITAGGDT", "onADClosed");
            a.this.s();
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.i.b.a
        public void c() {
            e.b("AMITAGGDT", "onADOpened");
            a.this.v();
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.i.b.a
        public void onADClicked() {
            e.b("AMITAGGDT", "onADClicked");
            a.this.r();
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.i.b.a
        public void onADExposure() {
            e.b("AMITAGGDT", "onADExposure");
            a.this.t();
            n.a(new RunnableC0166a(), 1L);
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.i.b.a
        public void onADLeftApplication() {
            e.b("AMITAGGDT", "onADLeftApplication");
            a.this.q();
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.i.b.a
        public void onNoAD(AdError adError) {
            e.b("AMITAGGDT", "onNoAD");
            a.this.b(new i(adError.getErrorCode(), adError.getErrorMsg()));
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.i.b.a
        public void onRenderFail() {
            e.b("AMITAGGDT", "onRenderFail");
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.i.b.a
        public void onRenderSuccess() {
            e.b("AMITAGGDT", "onRenderSuccess");
            if (a.this.f5726r) {
                if (a.this.o()) {
                    if (com.aggmoread.sdk.z.d.a.a.d.a.d.u.b.a(a.this.f5843h, com.aggmoread.sdk.z.d.a.a.d.a.d.u.b.a(a.this.f5724p))) {
                        return;
                    }
                }
                e.b("AMITAGGDT", "onRenderSuccess notify");
                a.this.u();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.i.b.a
        public void onVideoCached() {
            e.b("AMITAGGDT", "onVideoCached");
            a.this.w();
        }
    }

    public class b implements c.a {

        /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.u.i.a$b$a */
        public class RunnableC0168a implements Runnable {
            public RunnableC0168a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ((com.aggmoread.sdk.z.d.a.a.c.l) a.this.f5842g.f5862h).b();
            }
        }

        public b() {
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.i.c.a
        public void a(long j10) {
            f fVar = a.this.f5842g.f5862h;
            if (fVar instanceof com.aggmoread.sdk.z.d.a.a.c.l) {
                ((com.aggmoread.sdk.z.d.a.a.c.l) fVar).a(j10);
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.i.c.a
        public void b() {
            if (a.this.f5842g.f5862h instanceof com.aggmoread.sdk.z.d.a.a.c.l) {
                n.a(new RunnableC0168a(), 2L);
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.i.c.a
        public void c() {
            f fVar = a.this.f5842g.f5862h;
            if (fVar instanceof com.aggmoread.sdk.z.d.a.a.c.l) {
                ((com.aggmoread.sdk.z.d.a.a.c.l) fVar).c();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.i.c.a
        public void onVideoComplete() {
            f fVar = a.this.f5842g.f5862h;
            if (fVar instanceof com.aggmoread.sdk.z.d.a.a.c.l) {
                ((com.aggmoread.sdk.z.d.a.a.c.l) fVar).onVideoComplete();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.i.c.a
        public void onVideoError(AdError adError) {
            f fVar = a.this.f5842g.f5862h;
            if (fVar instanceof com.aggmoread.sdk.z.d.a.a.c.l) {
                fVar.a(new i(adError.getErrorCode(), adError.getErrorMsg()));
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.i.c.a
        public void onVideoInit() {
            f fVar = a.this.f5842g.f5862h;
            if (fVar instanceof com.aggmoread.sdk.z.d.a.a.c.l) {
                ((com.aggmoread.sdk.z.d.a.a.c.l) fVar).onVideoInit();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.i.c.a
        public void onVideoLoading() {
            f fVar = a.this.f5842g.f5862h;
            if (fVar instanceof com.aggmoread.sdk.z.d.a.a.c.l) {
                ((com.aggmoread.sdk.z.d.a.a.c.l) fVar).onVideoLoading();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.i.c.a
        public void onVideoPause() {
            f fVar = a.this.f5842g.f5862h;
            if (fVar instanceof com.aggmoread.sdk.z.d.a.a.c.l) {
                ((com.aggmoread.sdk.z.d.a.a.c.l) fVar).onVideoPause();
            }
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.i.c.a
        public void onVideoStart() {
            f fVar = a.this.f5842g.f5862h;
            if (fVar instanceof com.aggmoread.sdk.z.d.a.a.c.l) {
                ((com.aggmoread.sdk.z.d.a.a.c.l) fVar).onVideoStart();
            }
        }
    }

    public class c implements Runnable {

        /* renamed from: b */
        final /* synthetic */ Activity f5735b;

        public c(Activity activity) {
            this.f5735b = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f5724p != null) {
                a.this.f5724p.show(this.f5735b);
            }
        }
    }

    public a(d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        super(dVar, eVar);
        this.f5725q = new AtomicBoolean();
        this.f5726r = true;
        this.f5727s = new C0165a();
        this.f5728t = new b();
        this.f5729u = new b.C0115b().b(1).a(1).a(true).b(true).a();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.q.b
    public void a(Activity activity) {
        e.b("AMITAGGDT", "show #2 activity = " + activity);
        if (this.f5342m && this.f5724p != null && this.f5725q.compareAndSet(false, true)) {
            e.b("AMITAGGDT", "show #2 ");
            if (activity == null) {
                super.b();
                return;
            }
            com.aggmoread.sdk.z.d.a.a.d.a.d.u.a.a(this.f5724p, k());
            try {
                activity.getWindow().getDecorView().post(new c(activity));
            } catch (Exception e10) {
                e.b("AMITAGGDT", "show #3 " + e10.getMessage());
                UnifiedInterstitialAD unifiedInterstitialAD = this.f5724p;
                if (unifiedInterstitialAD != null) {
                    unifiedInterstitialAD.show(activity);
                }
            }
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void c(int i10) {
        com.aggmoread.sdk.z.d.a.a.d.a.d.u.d.a(this.f5724p, i10);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.q.b
    public void destroy() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.f5724p;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.setMediaListener(null);
            this.f5724p.destroy();
            this.f5724p = null;
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public String j() {
        return com.aggmoread.sdk.z.d.a.a.d.a.d.u.b.a().a(this.f5842g);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void l() {
        Context context = this.f5842g.f5858d;
        com.aggmoread.sdk.z.d.a.a.e.f fVar = this.f5843h.f5907c;
        Object obj = e.c.X;
        com.aggmoread.sdk.z.d.a.a.d.a.d.u.b.a(context, fVar.a(obj, ""));
        com.aggmoread.sdk.z.d.a.a.d.a.d.u.b.a().a(this.f5843h, this.f5842g);
        UnifiedInterstitialAD unifiedInterstitialAD = (UnifiedInterstitialAD) com.aggmoread.sdk.z.d.a.a.d.a.d.u.d.a(this.f5842g.f5858d, this.f5843h.f5907c.c(obj), this.f5843h.f5907c.c(e.c.T), d.e.INTERSTITIAL, this.f5845j, new com.aggmoread.sdk.z.d.a.a.d.a.d.u.i.b(this.f5727s).a(), new Object[0]);
        this.f5724p = unifiedInterstitialAD;
        com.aggmoread.sdk.z.d.a.a.d.a.d.u.i.c cVar = new com.aggmoread.sdk.z.d.a.a.d.a.d.u.i.c(this.f5728t);
        if (this.f5842g.f5862h != null) {
            unifiedInterstitialAD.setMediaListener(cVar.a());
        }
        com.aggmoread.sdk.z.d.a.a.c.t.b bVar = this.f5842g.f5873s;
        if (bVar == null) {
            bVar = this.f5729u;
        }
        this.f5724p.setVideoOption(new VideoOption.Builder().setDetailPageMuted(bVar.e()).setAutoPlayMuted(bVar.d()).setAutoPlayPolicy(bVar.a()).build());
        if (bVar.c() >= 5 && bVar.c() <= 61) {
            this.f5724p.setMinVideoDuration(bVar.c());
        }
        if (bVar.b() >= 5 && bVar.b() <= 61) {
            this.f5724p.setMaxVideoDuration(bVar.b());
        }
        this.f5342m = false;
        this.f5726r = m.a("4.371");
        new k(this.f5842g, this.f5843h).a(0).b();
        this.f5724p.loadAD();
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMITAGGDT", "load enter");
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.g, com.aggmoread.sdk.z.d.a.a.c.a
    public void a(com.aggmoread.sdk.z.d.a.a.d.a.c cVar) {
        this.f5844i = cVar;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.g, com.aggmoread.sdk.z.d.a.a.c.q.b
    public void b() {
        if (!(this.f5842g.f5858d instanceof Activity)) {
            super.b();
            return;
        }
        if (this.f5342m && this.f5724p != null && this.f5725q.compareAndSet(false, true)) {
            com.aggmoread.sdk.z.d.a.a.d.a.d.u.a.a(this.f5724p, k());
            com.aggmoread.sdk.z.d.a.a.e.e.b("AMITAGGDT", "show #1 ");
            this.f5724p.show();
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void b(int i10, int i11, String str) {
        com.aggmoread.sdk.z.d.a.a.d.a.d.u.d.a(this.f5724p, i11, i10, str);
    }
}

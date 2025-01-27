package com.aggmoread.sdk.z.d.a.a.d.a.d.u.h;

import android.app.Activity;
import android.content.Context;
import com.aggmoread.sdk.z.d.a.a.c.t.b;
import com.aggmoread.sdk.z.d.a.a.d.a.c;
import com.aggmoread.sdk.z.d.a.a.d.a.d.f;
import com.aggmoread.sdk.z.d.a.a.d.a.d.u.d;
import com.aggmoread.sdk.z.d.a.a.d.a.d.u.i.b;
import com.aggmoread.sdk.z.d.a.a.d.b.d;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.d.b.i;
import com.aggmoread.sdk.z.d.a.a.d.b.k;
import com.aggmoread.sdk.z.d.a.a.d.b.l;
import com.aggmoread.sdk.z.d.a.a.e.m;
import com.aggmoread.sdk.z.d.a.a.e.n;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.comm.util.AdError;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class a extends f {

    /* renamed from: p */
    private UnifiedInterstitialAD f5718p;

    /* renamed from: q */
    private AtomicBoolean f5719q;

    /* renamed from: r */
    private b.a f5720r;

    /* renamed from: s */
    final com.aggmoread.sdk.z.d.a.a.c.t.b f5721s;

    /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.u.h.a$a */
    public class C0163a implements b.a {

        /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.u.h.a$a$a */
        public class RunnableC0164a implements Runnable {
            public RunnableC0164a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                Object obj = aVar.f5842g.f5856b;
                Object[] objArr = ((f) aVar).f5328n;
                a aVar2 = a.this;
                l.a(obj, objArr, aVar2.f5842g.f5859e, Integer.valueOf(aVar2.f5843h.f()));
                a aVar3 = a.this;
                l.b(aVar3.f5842g.f5856b, aVar3.f5843h.e(), a.this.f5843h.b());
                byte[] b10 = a.this.f5842g.f5872r.b();
                if (b10 != null) {
                    l.a(a.this.f5842g.f5856b, b10);
                }
                l.a((Object) ((f) a.this).f5328n, true, true);
                l.a(((f) a.this).f5328n, a.this.f5843h);
                l.a(((f) a.this).f5328n, 2);
            }
        }

        public C0163a() {
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.i.b.a
        public void a() {
            if (a.this.o()) {
                int a10 = com.aggmoread.sdk.z.d.a.a.d.a.d.u.b.a(a.this.f5718p);
                if (com.aggmoread.sdk.z.d.a.a.d.a.d.u.b.a(a.this.f5843h, a10)) {
                    a.this.a(a10, 0);
                    return;
                }
                a.this.b(a10);
            }
            a aVar = a.this;
            com.aggmoread.sdk.z.d.a.a.d.a.d.u.b.a(aVar.f5841f, aVar.f5718p, a.this.f5843h);
            a.this.u();
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.i.b.a
        public void b() {
            a.this.s();
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.i.b.a
        public void c() {
            a.this.v();
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.i.b.a
        public void onADClicked() {
            a.this.r();
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.i.b.a
        public void onADExposure() {
            a.this.t();
            n.a(new RunnableC0164a(), 1L);
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.i.b.a
        public void onADLeftApplication() {
            a.this.q();
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.i.b.a
        public void onNoAD(AdError adError) {
            a.this.b(new i(adError.getErrorCode(), adError.getErrorMsg()));
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.i.b.a
        public void onRenderFail() {
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.i.b.a
        public void onRenderSuccess() {
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.i.b.a
        public void onVideoCached() {
            a.this.w();
        }
    }

    public a(d dVar, e eVar) {
        super(dVar, eVar);
        this.f5719q = new AtomicBoolean();
        this.f5720r = new C0163a();
        this.f5721s = new b.C0115b().b(1).a(1).a(true).b(true).a();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.f, com.aggmoread.sdk.z.d.a.a.c.p.b
    public void a(Activity activity) {
        if (this.f5327m && this.f5718p != null && this.f5719q.compareAndSet(false, true)) {
            com.aggmoread.sdk.z.d.a.a.e.e.b("AMFTAGGDT", "show #2 ");
            if (activity == null) {
                super.b();
            } else {
                com.aggmoread.sdk.z.d.a.a.d.a.d.u.a.a(this.f5718p, k());
                this.f5718p.showFullScreenAD(activity);
            }
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void c(int i10) {
        com.aggmoread.sdk.z.d.a.a.d.a.d.u.d.a(this.f5718p, i10);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.p.b
    public void destroy() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.f5718p;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.setMediaListener(null);
            this.f5718p.destroy();
            this.f5718p = null;
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
        this.f5718p = (UnifiedInterstitialAD) com.aggmoread.sdk.z.d.a.a.d.a.d.u.d.a(this.f5842g.f5858d, this.f5843h.f5907c.c(obj), this.f5843h.f5907c.c(e.c.T), d.e.FULLSCREEN, this.f5845j, new com.aggmoread.sdk.z.d.a.a.d.a.d.u.i.b(this.f5720r).a(), new Object[0]);
        com.aggmoread.sdk.z.d.a.a.c.t.b bVar = this.f5842g.f5873s;
        if (bVar == null) {
            bVar = this.f5721s;
        }
        this.f5718p.setVideoOption(new VideoOption.Builder().setDetailPageMuted(bVar.e()).setAutoPlayMuted(bVar.d()).setAutoPlayPolicy(bVar.a()).build());
        if (bVar.c() >= 5 && bVar.c() <= 61) {
            this.f5718p.setMinVideoDuration(bVar.c());
        }
        if (bVar.b() >= 5 && bVar.b() <= 61) {
            this.f5718p.setMaxVideoDuration(bVar.b());
        }
        boolean a10 = m.a("4.390");
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMFTAGGDT", "reward " + a10);
        if (a10) {
            com.aggmoread.sdk.z.d.a.a.d.a.d.u.d.b(this.f5718p, this.f5842g, this.f5843h);
        }
        this.f5327m = false;
        new k(this.f5842g, this.f5843h).a(0).b();
        this.f5718p.loadFullScreenAD();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.f, com.aggmoread.sdk.z.d.a.a.c.a
    public void a(c cVar) {
        this.f5844i = cVar;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.f, com.aggmoread.sdk.z.d.a.a.c.p.b
    public void b() {
        Context context = this.f5842g.f5858d;
        if (context instanceof Activity) {
            a((Activity) context);
        } else {
            super.b();
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void b(int i10, int i11, String str) {
        com.aggmoread.sdk.z.d.a.a.d.a.d.u.d.a(this.f5718p, i11, i10, str);
    }
}

package com.aggmoread.sdk.z.d.a.a.d.a.d.v.h;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Nullable;
import com.aggmoread.sdk.z.d.a.a.c.f;
import com.aggmoread.sdk.z.d.a.a.c.t.b;
import com.aggmoread.sdk.z.d.a.a.d.a.d.g;
import com.aggmoread.sdk.z.d.a.a.d.b.d;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.d.b.i;
import com.aggmoread.sdk.z.d.a.a.d.b.k;
import com.aggmoread.sdk.z.d.a.a.d.b.l;
import com.aggmoread.sdk.z.d.a.a.e.e;
import com.aggmoread.sdk.z.d.a.a.e.n;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class a extends g {

    /* renamed from: p */
    private KsInterstitialAd f5789p;

    /* renamed from: q */
    private AtomicBoolean f5790q;

    /* renamed from: r */
    private KsVideoPlayConfig f5791r;

    /* renamed from: s */
    int f5792s;

    /* renamed from: t */
    final com.aggmoread.sdk.z.d.a.a.c.t.b f5793t;

    /* renamed from: u */
    private KsLoadManager.InterstitialAdListener f5794u;

    /* renamed from: v */
    private KsInterstitialAd.AdInteractionListener f5795v;

    /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.v.h.a$a */
    public class C0174a implements KsLoadManager.InterstitialAdListener {
        public C0174a() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public void onError(int i10, String str) {
            e.b("AMITAGKS", "onError i " + i10 + ",s  = " + str);
            a.this.b(new i(i10, str));
        }

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public void onInterstitialAdLoad(@Nullable List<KsInterstitialAd> list) {
            e.b("AMITAGKS", "onInterstitialAdLoad");
            if (list != null && list.size() > 0) {
                a.this.f5789p = list.get(0);
                a.this.f5789p.setAdInteractionListener(a.this.f5795v);
            }
            int a10 = com.aggmoread.sdk.z.d.a.a.d.a.d.v.b.a((Object) a.this.f5789p);
            if (com.aggmoread.sdk.z.d.a.a.d.a.d.v.b.a(a.this.f5843h, a10)) {
                a.this.a(a10, 0);
                return;
            }
            a.this.b(a10);
            a aVar = a.this;
            aVar.f5792s = a10;
            com.aggmoread.sdk.z.d.a.a.d.a.d.v.b.b(aVar.f5841f, a10, aVar.f5843h);
            a.this.u();
        }

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public void onRequestResult(int i10) {
            e.b("AMITAGKS", "onRequestResult " + i10);
        }
    }

    public class b implements KsInterstitialAd.AdInteractionListener {

        /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.v.h.a$b$a */
        public class RunnableC0175a implements Runnable {
            public RunnableC0175a() {
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
                l.a(((g) a.this).f5343n, 2);
            }
        }

        public b() {
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public void onAdClicked() {
            e.b("AMITAGKS", "onADClicked");
            a.this.r();
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public void onAdClosed() {
            e.b("AMITAGKS", "onADClosed");
            a.this.s();
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public void onAdShow() {
            e.b("AMITAGKS", "onADExposure");
            a.this.v();
            a.this.t();
            n.a(new RunnableC0175a(), 1L);
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public void onPageDismiss() {
            e.b("AMITAGKS", "onADLeftApplication");
            a.this.q();
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public void onSkippedAd() {
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public void onVideoPlayEnd() {
            f fVar = a.this.f5842g.f5862h;
            if (fVar instanceof com.aggmoread.sdk.z.d.a.a.c.l) {
                ((com.aggmoread.sdk.z.d.a.a.c.l) fVar).onVideoComplete();
            }
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public void onVideoPlayError(int i10, int i11) {
            f fVar = a.this.f5842g.f5862h;
            if (fVar instanceof com.aggmoread.sdk.z.d.a.a.c.l) {
                fVar.a(new i(i10, i11 + ""));
            }
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public void onVideoPlayStart() {
            f fVar = a.this.f5842g.f5862h;
            if (fVar instanceof com.aggmoread.sdk.z.d.a.a.c.l) {
                ((com.aggmoread.sdk.z.d.a.a.c.l) fVar).onVideoStart();
            }
        }
    }

    public class c implements Runnable {

        /* renamed from: b */
        final /* synthetic */ Activity f5799b;

        public c(Activity activity) {
            this.f5799b = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f5789p.showInterstitialAd(this.f5799b, a.this.f5791r);
        }
    }

    public a(d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        super(dVar, eVar);
        this.f5790q = new AtomicBoolean();
        this.f5793t = new b.C0115b().b(1).a(1).a(true).a();
        this.f5794u = new C0174a();
        this.f5795v = new b();
    }

    private void y() {
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.g, com.aggmoread.sdk.z.d.a.a.c.q.b
    public void b() {
        Context context = this.f5842g.f5858d;
        if (context instanceof Activity) {
            a((Activity) context);
        } else {
            super.b();
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void c(int i10) {
        super.c(i10);
        com.aggmoread.sdk.z.d.a.a.d.a.d.v.b.b(this.f5789p, i10);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.q.b
    public void destroy() {
        if (this.f5789p != null) {
            this.f5789p = null;
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public String j() {
        return com.aggmoread.sdk.z.d.a.a.d.a.d.v.b.a().a(this.f5789p);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void l() {
        e.b("AMITAGKS", "handle enter");
        if (!com.aggmoread.sdk.z.d.a.a.d.a.d.v.b.a(this.f5842g.f5858d, this.f5843h.f5907c.a(e.c.X, ""))) {
            b(new i(1001002008, "广告加载失败！"));
            com.aggmoread.sdk.z.d.a.a.e.e.b("AMITAGKS", "returen #1");
            return;
        }
        try {
            String c10 = this.f5843h.f5907c.c(e.c.T);
            String trim = c10.replace("L", "").trim();
            long parseLong = Long.parseLong(trim);
            com.aggmoread.sdk.z.d.a.a.e.e.b("AMITAGKS", "handle #3");
            com.aggmoread.sdk.z.d.a.a.e.e.b("AMITAGKS", "slotId = " + c10 + ",slotIdStr = " + trim + ",_slotId = " + parseLong);
            KsScene build = new KsScene.Builder(parseLong).build();
            com.aggmoread.sdk.z.d.a.a.c.t.b bVar = this.f5842g.f5873s;
            if (bVar == null) {
                bVar = this.f5793t;
            }
            this.f5791r = null;
            if (bVar != null) {
                KsVideoPlayConfig.Builder builder = new KsVideoPlayConfig.Builder();
                builder.videoSoundEnable(!bVar.d());
                this.f5791r = builder.build();
            }
            this.f5342m = false;
            new k(this.f5842g, this.f5843h).a(0).b();
            com.aggmoread.sdk.z.d.a.a.e.e.b("AMITAGKS", "load ad");
            KsAdSDK.getLoadManager().loadInterstitialAd(build, this.f5794u);
        } catch (Exception unused) {
            b(new i(1001002008, "广告ID配置错误，广告加载失败！"));
            com.aggmoread.sdk.z.d.a.a.e.e.b("AMITAGKS", "returen #2");
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void b(int i10, int i11, String str) {
        com.aggmoread.sdk.z.d.a.a.d.a.d.v.b.a(this.f5789p, i11);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.q.b
    public void a(Activity activity) {
        if (this.f5342m && this.f5789p != null && this.f5790q.compareAndSet(false, true)) {
            if (activity == null) {
                super.b();
                return;
            }
            y();
            try {
                activity.getWindow().getDecorView().post(new c(activity));
            } catch (Exception e10) {
                com.aggmoread.sdk.z.d.a.a.e.e.b("AMITAGKS", "show #3 " + e10.getMessage());
                this.f5789p.showInterstitialAd(activity, this.f5791r);
            }
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.g, com.aggmoread.sdk.z.d.a.a.c.a
    public void a(com.aggmoread.sdk.z.d.a.a.d.a.c cVar) {
        this.f5844i = cVar;
    }
}

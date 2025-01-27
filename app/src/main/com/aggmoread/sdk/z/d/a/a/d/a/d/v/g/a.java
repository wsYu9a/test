package com.aggmoread.sdk.z.d.a.a.d.a.d.v.g;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Nullable;
import com.aggmoread.sdk.z.d.a.a.c.l;
import com.aggmoread.sdk.z.d.a.a.c.t.b;
import com.aggmoread.sdk.z.d.a.a.d.a.d.f;
import com.aggmoread.sdk.z.d.a.a.d.a.d.v.g.b;
import com.aggmoread.sdk.z.d.a.a.d.b.d;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.d.b.i;
import com.aggmoread.sdk.z.d.a.a.d.b.k;
import com.aggmoread.sdk.z.d.a.a.e.e;
import com.aggmoread.sdk.z.d.a.a.e.n;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class a extends f {

    /* renamed from: p */
    private KsFullScreenVideoAd f5776p;

    /* renamed from: q */
    private AtomicBoolean f5777q;

    /* renamed from: r */
    private KsVideoPlayConfig f5778r;

    /* renamed from: s */
    private boolean f5779s;

    /* renamed from: t */
    int f5780t;

    /* renamed from: u */
    final com.aggmoread.sdk.z.d.a.a.c.t.b f5781u;

    /* renamed from: v */
    private b.a f5782v;

    /* renamed from: w */
    private KsFullScreenVideoAd.FullScreenVideoAdInteractionListener f5783w;

    /* renamed from: x */
    int f5784x;

    /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.v.g.a$a */
    public class C0173a implements b.a {
        public C0173a() {
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.v.g.b.a
        public void a(@Nullable List<KsFullScreenVideoAd> list) {
            e.b("AMFTAGKS", "onInterstitialAdLoad");
            if (list != null && list.size() > 0) {
                a.this.f5776p = list.get(0);
                a.this.f5776p.setFullScreenVideoAdInteractionListener(a.this.f5783w);
            }
            int a10 = com.aggmoread.sdk.z.d.a.a.d.a.d.v.b.a((Object) a.this.f5776p);
            if (com.aggmoread.sdk.z.d.a.a.d.a.d.v.b.a(a.this.f5843h, a10)) {
                a.this.a(a10, 0);
                return;
            }
            a.this.b(a10);
            a aVar = a.this;
            com.aggmoread.sdk.z.d.a.a.d.a.d.v.b.b(aVar.f5841f, a10, aVar.f5843h);
            a aVar2 = a.this;
            aVar2.f5780t = a10;
            aVar2.u();
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.v.g.b.a
        public void b(@Nullable List<KsFullScreenVideoAd> list) {
            e.b("AMFTAGKS", "onFullScreenVideoResult " + list);
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.v.g.b.a
        public void onError(int i10, String str) {
            e.b("AMFTAGKS", "onError i " + i10 + ",s  = " + str);
            a.this.b(new i(i10, str));
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.v.g.b.a
        public void onRequestResult(int i10) {
            e.b("AMFTAGKS", "onRequestResult " + i10);
        }
    }

    public class b implements KsFullScreenVideoAd.FullScreenVideoAdInteractionListener {
        public b() {
        }

        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onAdClicked() {
            e.b("AMFTAGKS", "onADClicked");
            a.this.f5779s = true;
            a.this.r();
        }

        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onPageDismiss() {
            e.b("AMFTAGKS", "onPageDismiss");
            a.this.s();
        }

        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onSkippedVideo() {
            e.b("AMFTAGKS", "onSkippedVideo");
            a.this.z();
        }

        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onVideoPlayEnd() {
            e.b("AMFTAGKS", "onVideoPlayEnd");
            a.this.A();
            a.this.z();
        }

        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onVideoPlayError(int i10, int i11) {
            e.b("AMFTAGKS", "onVideoPlayError i " + i10 + ",s " + i11);
            com.aggmoread.sdk.z.d.a.a.c.f fVar = a.this.f5842g.f5862h;
            if (fVar instanceof l) {
                fVar.a(new i(i10, i11 + ""));
            }
            a.this.c(new i(i10, String.valueOf(i11)));
        }

        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onVideoPlayStart() {
            e.b("AMFTAGKS", "onVideoPlayStart");
            a.this.v();
            a.this.t();
            a aVar = a.this;
            Object obj = aVar.f5842g.f5856b;
            Object[] objArr = ((f) aVar).f5328n;
            a aVar2 = a.this;
            com.aggmoread.sdk.z.d.a.a.d.b.l.a(obj, objArr, aVar2.f5842g.f5859e, Integer.valueOf(aVar2.f5843h.f()));
            a aVar3 = a.this;
            com.aggmoread.sdk.z.d.a.a.d.b.l.b(aVar3.f5842g.f5856b, aVar3.f5843h.e(), a.this.f5843h.b());
            if (a.this.f5842g.e() != null) {
                d dVar = a.this.f5842g;
                com.aggmoread.sdk.z.d.a.a.d.b.l.a(dVar.f5856b, dVar.e());
            }
            byte[] b10 = a.this.f5842g.f5872r.b();
            if (b10 != null) {
                com.aggmoread.sdk.z.d.a.a.d.b.l.a(a.this.f5842g.f5856b, b10);
            }
            com.aggmoread.sdk.z.d.a.a.d.b.l.a((Object) ((f) a.this).f5328n, true, true);
            com.aggmoread.sdk.z.d.a.a.d.b.l.a(((f) a.this).f5328n, a.this.f5843h);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aggmoread.sdk.z.d.a.a.d.b.l.a(((f) a.this).f5328n, 2);
            a.this.A();
        }
    }

    public a(d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        super(dVar, eVar);
        this.f5777q = new AtomicBoolean();
        this.f5779s = false;
        this.f5781u = new b.C0115b().b(1).a(1).a(true).a();
        this.f5782v = new C0173a();
        this.f5783w = new b();
        this.f5784x = 0;
    }

    public void A() {
        if (this.f5779s || this.f5784x > 5) {
            return;
        }
        e.b("AMFTAGKS", "find cc ");
        this.f5784x++;
        n.a(new c(), 500L);
    }

    private void y() {
    }

    public void z() {
        com.aggmoread.sdk.z.d.a.a.c.f fVar = this.f5842g.f5862h;
        if (fVar instanceof l) {
            ((l) fVar).onVideoComplete();
        }
        x();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.f, com.aggmoread.sdk.z.d.a.a.c.p.b
    public void b() {
        Context context = this.f5842g.f5858d;
        if (context instanceof Activity) {
            b((Activity) context);
        } else {
            super.b();
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void c(int i10) {
        super.c(i10);
        com.aggmoread.sdk.z.d.a.a.d.a.d.v.b.b(this.f5776p, i10);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.p.b
    public void destroy() {
        if (this.f5776p != null) {
            this.f5776p = null;
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public String j() {
        return com.aggmoread.sdk.z.d.a.a.d.a.d.v.b.a().a(this.f5776p);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void l() {
        if (!com.aggmoread.sdk.z.d.a.a.d.a.d.v.b.a(this.f5842g.f5858d, this.f5843h.f5907c.a(e.c.X, ""))) {
            b(new i(1001002008, "广告加载失败！"));
            return;
        }
        try {
            String c10 = this.f5843h.f5907c.c(e.c.T);
            String trim = c10.replace("L", "").trim();
            long parseLong = Long.parseLong(trim);
            com.aggmoread.sdk.z.d.a.a.e.e.b("AMFTAGKS", "slotId = " + c10 + ",slotIdStr = " + trim + ",_slotId = " + parseLong);
            KsScene build = new KsScene.Builder(parseLong).build();
            com.aggmoread.sdk.z.d.a.a.c.t.b bVar = this.f5842g.f5873s;
            if (bVar == null) {
                bVar = this.f5781u;
            }
            this.f5778r = null;
            if (bVar != null) {
                KsVideoPlayConfig.Builder builder = new KsVideoPlayConfig.Builder();
                builder.videoSoundEnable(!bVar.d());
                this.f5778r = builder.build();
            }
            this.f5327m = false;
            new k(this.f5842g, this.f5843h).a(0).b();
            com.aggmoread.sdk.z.d.a.a.e.e.b("AMFTAGKS", "load ad");
            KsAdSDK.getLoadManager().loadFullScreenVideoAd(build, new com.aggmoread.sdk.z.d.a.a.d.a.d.v.g.b(this.f5782v).a());
        } catch (Exception unused) {
            b(new i(1001002008, "广告ID配置错误，广告加载失败！"));
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void b(int i10, int i11, String str) {
        com.aggmoread.sdk.z.d.a.a.d.a.d.v.b.a(this.f5776p, i11);
    }

    private void b(Activity activity) {
        if (this.f5327m && this.f5776p != null && this.f5777q.compareAndSet(false, true)) {
            if (activity == null) {
                super.b();
            } else {
                y();
                this.f5776p.showFullScreenVideoAd(activity, this.f5778r);
            }
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.f, com.aggmoread.sdk.z.d.a.a.c.p.b
    public void a(Activity activity) {
        b(activity);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.f, com.aggmoread.sdk.z.d.a.a.c.a
    public void a(com.aggmoread.sdk.z.d.a.a.d.a.c cVar) {
        this.f5844i = cVar;
    }
}

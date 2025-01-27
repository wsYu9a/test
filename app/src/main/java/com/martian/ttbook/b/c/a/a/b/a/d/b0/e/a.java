package com.martian.ttbook.b.c.a.a.b.a.d.b0.e;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.martian.ttbook.b.c.a.a.b.a.d.b0.e.b;
import com.martian.ttbook.b.c.a.a.b.a.d.g;
import com.martian.ttbook.b.c.a.a.b.a.d.n;
import com.martian.ttbook.b.c.a.a.c.e;
import com.martian.ttbook.b.c.a.a.c.j;
import com.martian.ttbook.b.c.a.a.c.q.b;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.i;
import com.martian.ttbook.b.c.a.a.d.b.k;
import com.martian.ttbook.b.c.a.a.d.b.l;
import com.martian.ttbook.b.c.a.a.e.d;
import com.opos.acs.st.utils.ErrorContants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class a extends g {

    /* renamed from: f */
    private KsFullScreenVideoAd f15327f;

    /* renamed from: g */
    private boolean f15328g;

    /* renamed from: h */
    private Object[] f15329h;

    /* renamed from: j */
    private AtomicBoolean f15330j;
    private KsVideoPlayConfig k;
    private boolean l;
    int m;
    final com.martian.ttbook.b.c.a.a.c.q.b n;
    private b.a o;
    private KsFullScreenVideoAd.FullScreenVideoAdInteractionListener p;
    int q;

    /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.b0.e.a$a */
    class C0307a implements b.a {
        C0307a() {
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.b0.e.b.a
        public void a(@Nullable List<KsFullScreenVideoAd> list) {
            d.g("KSINTAG", "onInterstitialAdLoad");
            if (list != null && list.size() > 0) {
                a.this.f15327f = list.get(0);
                a.this.f15327f.setFullScreenVideoAdInteractionListener(a.this.p);
            }
            int b2 = com.martian.ttbook.b.c.a.a.b.a.d.b0.b.b(a.this.f15327f);
            if (com.martian.ttbook.b.c.a.a.b.a.d.b0.b.f(a.this.f15663d, b2)) {
                a.this.A(0);
                return;
            }
            a.this.B(b2);
            a.this.f15328g = true;
            a aVar = a.this;
            new k(aVar.f15662c, aVar.f15663d).a(4).h();
            a aVar2 = a.this;
            aVar2.m = b2;
            com.martian.ttbook.b.c.a.a.b.a.d.b0.b.h(aVar2.f15661b, b2, aVar2.f15663d);
            ArrayList arrayList = new ArrayList();
            arrayList.add(a.this);
            e eVar = a.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.m.b) {
                ((com.martian.ttbook.b.c.a.a.c.m.b) eVar).onAdLoaded(arrayList);
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.b0.e.b.a
        public void b(@Nullable List<KsFullScreenVideoAd> list) {
            d.g("KSINTAG", "onFullScreenVideoResult " + list);
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.b0.e.b.a
        public void onError(int i2, String str) {
            d.g("KSINTAG", "onError i " + i2 + ",s  = " + str);
            a.this.L(new i(i2, str));
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.b0.e.b.a
        public void onRequestResult(int i2) {
            d.g("KSINTAG", "onRequestResult " + i2);
        }
    }

    class b implements KsFullScreenVideoAd.FullScreenVideoAdInteractionListener {
        b() {
        }

        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onAdClicked() {
            d.g("KSINTAG", "onADClicked");
            a.this.l = true;
            l.i(a.this.f15329h, false, true);
            a aVar = a.this;
            k kVar = new k(aVar.f15662c, aVar.f15663d);
            a aVar2 = a.this;
            boolean g2 = kVar.g(aVar2.f15663d, null, 0L, aVar2.f15329h);
            kVar.h();
            if (g2) {
                e eVar = a.this.f15662c.f15673g;
                if (eVar instanceof com.martian.ttbook.b.c.a.a.c.m.b) {
                    ((com.martian.ttbook.b.c.a.a.c.m.b) eVar).onAdClicked();
                }
            }
        }

        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onPageDismiss() {
            d.g("KSINTAG", "onPageDismiss");
            a aVar = a.this;
            new k(aVar.f15662c, aVar.f15663d).a(1).h();
            e eVar = a.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.m.b) {
                ((com.martian.ttbook.b.c.a.a.c.m.b) eVar).onAdDismissed();
            }
        }

        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onSkippedVideo() {
            d.g("KSINTAG", "onSkippedVideo");
            a.this.Q();
        }

        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onVideoPlayEnd() {
            d.g("KSINTAG", "onVideoPlayEnd");
            a.this.R();
            a.this.Q();
        }

        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onVideoPlayError(int i2, int i3) {
            d.g("KSINTAG", "onVideoPlayError i " + i2 + ",s " + i3);
            e eVar = a.this.f15662c.f15674h;
            if (eVar instanceof j) {
                eVar.a(new i(i2, i3 + ""));
            }
            a aVar = a.this;
            if (aVar.f15662c.f15673g instanceof com.martian.ttbook.b.c.a.a.c.m.b) {
                aVar.L(new i(i2, String.valueOf(i3)));
            }
        }

        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onVideoPlayStart() {
            d.g("KSINTAG", "onVideoPlayStart");
            a aVar = a.this;
            new k(aVar.f15662c, aVar.f15663d).a(5).c(k.b.q, a.this.f15663d.f15700b.d(e.c.f15716f, ErrorContants.NET_ERROR)).h();
            com.martian.ttbook.b.c.a.a.c.e eVar = a.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.m.b) {
                ((com.martian.ttbook.b.c.a.a.c.m.b) eVar).onAdShow();
                ((com.martian.ttbook.b.c.a.a.c.m.b) a.this.f15662c.f15673g).onAdExposed();
            }
            a aVar2 = a.this;
            Object obj = aVar2.f15662c.f15668b;
            Object[] objArr = aVar2.f15329h;
            a aVar3 = a.this;
            l.o(obj, objArr, aVar3.f15662c.f15671e, Integer.valueOf(aVar3.f15663d.f()));
            a aVar4 = a.this;
            l.s(aVar4.f15662c.f15668b, aVar4.f15663d.e(), a.this.f15663d.b());
            if (a.this.f15662c.m() != null) {
                com.martian.ttbook.b.c.a.a.d.b.d dVar = a.this.f15662c;
                l.k(dVar.f15668b, dVar.m());
            }
            byte[] h2 = a.this.f15662c.r.h();
            if (h2 != null) {
                l.j(a.this.f15662c.f15668b, h2);
            }
            l.i(a.this.f15329h, true, true);
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.q(a.this.f15329h, 2);
            a.this.R();
        }
    }

    public a(com.martian.ttbook.b.c.a.a.d.b.d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar) {
        super(dVar, eVar);
        this.f15328g = false;
        this.f15330j = new AtomicBoolean();
        this.l = false;
        this.n = new b.C0342b().h(1).a(1).b(true).c();
        this.o = new C0307a();
        this.p = new b();
        this.q = 0;
        this.f15329h = com.martian.ttbook.b.c.a.a.b.n();
    }

    private void I(Activity activity) {
        if (this.f15328g && this.f15327f != null && this.f15330j.compareAndSet(false, true)) {
            if (activity == null) {
                super.show();
            } else {
                P();
                this.f15327f.showFullScreenVideoAd(activity, this.k);
            }
        }
    }

    public void L(i iVar) {
        new k(this.f15662c, this.f15663d).a(2).b(iVar).h();
        if (this.f15328g || !this.f15663d.k()) {
            this.f15662c.f15673g.a(iVar);
        }
    }

    private void P() {
    }

    public void Q() {
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15674h;
        if (eVar instanceof j) {
            ((j) eVar).onVideoComplete();
        }
        com.martian.ttbook.b.c.a.a.c.e eVar2 = this.f15662c.f15673g;
        if (eVar2 instanceof com.martian.ttbook.b.c.a.a.c.m.b) {
            ((com.martian.ttbook.b.c.a.a.c.m.b) eVar2).onAdVideoCompleted();
        }
    }

    public void R() {
        if (this.l || this.q > 5) {
            return;
        }
        d.g("KSINTAG", "find cc ");
        this.q++;
        com.martian.ttbook.b.c.a.a.e.j.b(new c(), 500L);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.g, com.martian.ttbook.b.c.a.a.c.a
    public void a(int i2, int i3, String str) {
        com.martian.ttbook.b.c.a.a.b.a.d.b0.b.e(this.f15327f, i3);
    }

    @Override // com.martian.ttbook.b.c.a.a.c.m.a
    public void b() {
        if (this.f15327f != null) {
            this.f15327f = null;
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.c.a
    public void c(com.martian.ttbook.b.c.a.a.b.a.c cVar) {
        this.f15664e = cVar;
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.g, com.martian.ttbook.b.c.a.a.c.a
    public void sendWinNotification(int i2) {
        super.sendWinNotification(i2);
        com.martian.ttbook.b.c.a.a.b.a.d.b0.b.g(this.f15327f, i2);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.g, com.martian.ttbook.b.c.a.a.c.m.a
    public void show() {
        Context context = this.f15662c.f15670d;
        if (context instanceof Activity) {
            I((Activity) context);
        } else {
            super.show();
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.g, com.martian.ttbook.b.c.a.a.c.m.a
    public void show(Activity activity) {
        I(activity);
    }

    @Override // com.martian.ttbook.b.c.a.a.d.b.a
    public void w() {
        if (!n.j(this.f15662c.f15670d, this.f15663d.f15701c.d(e.c.U, ""))) {
            L(new i(-1000, "广告加载失败！"));
            return;
        }
        try {
            String l = this.f15663d.f15701c.l(e.c.Q);
            String trim = l.replace("L", "").trim();
            long parseLong = Long.parseLong(trim);
            d.g("KSINTAG", "slotId = " + l + ",slotIdStr = " + trim + ",_slotId = " + parseLong);
            KsScene build = new KsScene.Builder(parseLong).build();
            com.martian.ttbook.b.c.a.a.c.q.b bVar = this.f15662c.s;
            if (bVar == null) {
                bVar = this.n;
            }
            this.k = null;
            if (bVar != null) {
                KsVideoPlayConfig.Builder builder = new KsVideoPlayConfig.Builder();
                builder.videoSoundEnable(!bVar.k());
                this.k = builder.build();
            }
            this.f15328g = false;
            new k(this.f15662c, this.f15663d).a(3).h();
            d.g("KSINTAG", "load ad");
            KsAdSDK.getLoadManager().loadFullScreenVideoAd(build, new com.martian.ttbook.b.c.a.a.b.a.d.b0.e.b(this.o).a());
        } catch (Exception unused) {
            L(new i(-1000, "广告ID配置错误，广告加载失败！"));
        }
    }
}

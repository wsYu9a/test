package com.martian.ttbook.b.c.a.a.b.a.d.b0.f;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.martian.ttbook.b.a.k.n;
import com.martian.ttbook.b.c.a.a.b.a.d.h;
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
public class a extends h {

    /* renamed from: f */
    private KsInterstitialAd f15335f;

    /* renamed from: g */
    private boolean f15336g;

    /* renamed from: h */
    private Object[] f15337h;

    /* renamed from: j */
    private AtomicBoolean f15338j;
    private KsVideoPlayConfig k;
    int l;
    final com.martian.ttbook.b.c.a.a.c.q.b m;
    private KsLoadManager.InterstitialAdListener n;
    private KsInterstitialAd.AdInteractionListener o;

    /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.b0.f.a$a */
    class C0308a implements KsLoadManager.InterstitialAdListener {
        C0308a() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public void onError(int i2, String str) {
            d.g("KSINTAG", "onError i " + i2 + ",s  = " + str);
            a.this.J(new i(i2, str));
        }

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public void onInterstitialAdLoad(@Nullable List<KsInterstitialAd> list) {
            d.g("KSINTAG", "onInterstitialAdLoad");
            if (list != null && list.size() > 0) {
                a.this.f15335f = list.get(0);
                a.this.f15335f.setAdInteractionListener(a.this.o);
            }
            int b2 = com.martian.ttbook.b.c.a.a.b.a.d.b0.b.b(a.this.f15335f);
            if (com.martian.ttbook.b.c.a.a.b.a.d.b0.b.f(a.this.f15663d, b2)) {
                a.this.A(0);
                return;
            }
            a.this.B(b2);
            a.this.f15336g = true;
            a aVar = a.this;
            new k(aVar.f15662c, aVar.f15663d).a(4).h();
            a aVar2 = a.this;
            aVar2.l = b2;
            com.martian.ttbook.b.c.a.a.b.a.d.b0.b.h(aVar2.f15661b, b2, aVar2.f15663d);
            ArrayList arrayList = new ArrayList();
            arrayList.add(a.this);
            e eVar = a.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.n.b) {
                ((com.martian.ttbook.b.c.a.a.c.n.b) eVar).onAdLoaded(arrayList);
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public void onRequestResult(int i2) {
            d.g("KSINTAG", "onRequestResult " + i2);
        }
    }

    class b implements KsInterstitialAd.AdInteractionListener {

        /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.b0.f.a$b$a */
        class RunnableC0309a implements Runnable {
            RunnableC0309a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                Object obj = aVar.f15662c.f15668b;
                Object[] objArr = aVar.f15337h;
                a aVar2 = a.this;
                l.o(obj, objArr, aVar2.f15662c.f15671e, Integer.valueOf(aVar2.f15663d.f()));
                a aVar3 = a.this;
                l.s(aVar3.f15662c.f15668b, aVar3.f15663d.e(), a.this.f15663d.b());
                byte[] h2 = a.this.f15662c.r.h();
                if (h2 != null) {
                    l.j(a.this.f15662c.f15668b, h2);
                }
                l.i(a.this.f15337h, true, true);
                l.q(a.this.f15337h, 2);
            }
        }

        b() {
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public void onAdClicked() {
            d.g("KSINTAG", "onADClicked");
            l.i(a.this.f15337h, false, true);
            a aVar = a.this;
            k kVar = new k(aVar.f15662c, aVar.f15663d);
            a aVar2 = a.this;
            boolean g2 = kVar.g(aVar2.f15663d, null, 0L, aVar2.f15337h);
            kVar.h();
            if (g2) {
                e eVar = a.this.f15662c.f15673g;
                if (eVar instanceof com.martian.ttbook.b.c.a.a.c.n.b) {
                    ((com.martian.ttbook.b.c.a.a.c.n.b) eVar).onAdClicked();
                }
            }
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public void onAdClosed() {
            d.g("KSINTAG", "onADClosed");
            a aVar = a.this;
            new k(aVar.f15662c, aVar.f15663d).a(1).h();
            e eVar = a.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.n.b) {
                ((com.martian.ttbook.b.c.a.a.c.n.b) eVar).onAdDismissed();
            }
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public void onAdShow() {
            d.g("KSINTAG", "onADExposure");
            a aVar = a.this;
            new k(aVar.f15662c, aVar.f15663d).a(5).c(k.b.q, a.this.f15663d.f15700b.d(e.c.f15716f, ErrorContants.NET_ERROR)).h();
            com.martian.ttbook.b.c.a.a.c.e eVar = a.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.n.b) {
                ((com.martian.ttbook.b.c.a.a.c.n.b) eVar).onAdShow();
                ((com.martian.ttbook.b.c.a.a.c.n.b) a.this.f15662c.f15673g).onAdExposed();
            }
            n.c(new RunnableC0309a(), 1L);
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public void onPageDismiss() {
            d.g("KSINTAG", "onADLeftApplication");
            com.martian.ttbook.b.c.a.a.c.e eVar = a.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.n.b) {
                ((com.martian.ttbook.b.c.a.a.c.n.b) eVar).a();
            }
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public void onSkippedAd() {
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public void onVideoPlayEnd() {
            com.martian.ttbook.b.c.a.a.c.e eVar = a.this.f15662c.f15674h;
            if (eVar instanceof j) {
                ((j) eVar).onVideoComplete();
            }
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public void onVideoPlayError(int i2, int i3) {
            com.martian.ttbook.b.c.a.a.c.e eVar = a.this.f15662c.f15674h;
            if (eVar instanceof j) {
                eVar.a(new i(i2, i3 + ""));
            }
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public void onVideoPlayStart() {
            com.martian.ttbook.b.c.a.a.c.e eVar = a.this.f15662c.f15674h;
            if (eVar instanceof j) {
                ((j) eVar).onVideoStart();
            }
        }
    }

    class c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Activity f15342a;

        c(Activity activity) {
            this.f15342a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f15335f.showInterstitialAd(this.f15342a, a.this.k);
        }
    }

    public a(com.martian.ttbook.b.c.a.a.d.b.d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar) {
        super(dVar, eVar);
        this.f15336g = false;
        this.f15338j = new AtomicBoolean();
        this.m = new b.C0342b().h(1).a(1).b(true).c();
        this.n = new C0308a();
        this.o = new b();
        this.f15337h = com.martian.ttbook.b.c.a.a.b.n();
    }

    public void J(i iVar) {
        new k(this.f15662c, this.f15663d).a(2).b(iVar).h();
        if (this.f15336g || !this.f15663d.k()) {
            this.f15662c.f15673g.a(iVar);
        }
    }

    private void M() {
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.h, com.martian.ttbook.b.c.a.a.c.a
    public void a(int i2, int i3, String str) {
        com.martian.ttbook.b.c.a.a.b.a.d.b0.b.e(this.f15335f, i3);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.h, com.martian.ttbook.b.c.a.a.c.n.a
    public void b() {
        if (this.f15335f != null) {
            this.f15335f = null;
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.c.a
    public void c(com.martian.ttbook.b.c.a.a.b.a.c cVar) {
        this.f15664e = cVar;
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.h, com.martian.ttbook.b.c.a.a.c.n.a
    public int getAdPatternType() {
        KsInterstitialAd ksInterstitialAd = this.f15335f;
        if (ksInterstitialAd != null) {
            return com.martian.ttbook.b.c.a.a.b.a.d.b0.c.a(ksInterstitialAd.getMaterialType());
        }
        return 0;
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.h, com.martian.ttbook.b.c.a.a.c.a
    public void sendWinNotification(int i2) {
        super.sendWinNotification(i2);
        com.martian.ttbook.b.c.a.a.b.a.d.b0.b.g(this.f15335f, i2);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.h, com.martian.ttbook.b.c.a.a.c.n.a
    public void show() {
        Context context = this.f15662c.f15670d;
        if (context instanceof Activity) {
            show((Activity) context);
        } else {
            super.show();
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.h, com.martian.ttbook.b.c.a.a.c.n.a
    public void show(Activity activity) {
        if (this.f15336g && this.f15335f != null && this.f15338j.compareAndSet(false, true)) {
            if (activity == null) {
                super.show();
                return;
            }
            M();
            try {
                activity.getWindow().getDecorView().post(new c(activity));
            } catch (Exception e2) {
                d.g("KSINTAG", "show #3 " + e2.getMessage());
                this.f15335f.showInterstitialAd(activity, this.k);
            }
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.d.b.a
    public void w() {
        d.g("KSINTAG", "handle enter");
        if (!com.martian.ttbook.b.c.a.a.b.a.d.n.j(this.f15662c.f15670d, this.f15663d.f15701c.d(e.c.U, ""))) {
            J(new i(-1000, "广告加载失败！"));
            d.g("KSINTAG", "returen #1");
            return;
        }
        try {
            String l = this.f15663d.f15701c.l(e.c.Q);
            String trim = l.replace("L", "").trim();
            long parseLong = Long.parseLong(trim);
            d.g("KSINTAG", "handle #3");
            d.g("KSINTAG", "slotId = " + l + ",slotIdStr = " + trim + ",_slotId = " + parseLong);
            KsScene build = new KsScene.Builder(parseLong).build();
            com.martian.ttbook.b.c.a.a.c.q.b bVar = this.f15662c.s;
            if (bVar == null) {
                bVar = this.m;
            }
            this.k = null;
            if (bVar != null) {
                KsVideoPlayConfig.Builder builder = new KsVideoPlayConfig.Builder();
                builder.videoSoundEnable(!bVar.k());
                this.k = builder.build();
            }
            this.f15336g = false;
            new k(this.f15662c, this.f15663d).a(3).h();
            d.g("KSINTAG", "load ad");
            KsAdSDK.getLoadManager().loadInterstitialAd(build, this.n);
        } catch (Exception unused) {
            J(new i(-1000, "广告ID配置错误，广告加载失败！"));
            d.g("KSINTAG", "returen #2");
        }
    }
}

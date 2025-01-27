package com.martian.ttbook.b.c.a.a.b.a.d.x.i;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.SplashAd;
import com.baidu.mobads.sdk.api.SplashInteractionListener;
import com.martian.ttbook.b.c.a.a.b.a.d.k;
import com.martian.ttbook.b.c.a.a.b.a.d.n;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.i;
import com.martian.ttbook.b.c.a.a.e.d;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class a extends k {
    private SplashAd q;
    private AtomicBoolean r;

    /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.x.i.a$a */
    class C0331a implements SplashInteractionListener {
        C0331a() {
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onADLoaded() {
            d.g("BDSPTAG", "onADLoaded");
            int b2 = com.martian.ttbook.b.c.a.a.b.a.d.x.a.b(a.this.q);
            if (com.martian.ttbook.b.c.a.a.b.a.d.x.a.f(a.this.f15663d, b2)) {
                a.this.B(0);
                return;
            }
            a.this.G(b2);
            a aVar = a.this;
            com.martian.ttbook.b.c.a.a.b.a.d.x.a.g(aVar.f15661b, b2, aVar.f15663d);
            ArrayList arrayList = new ArrayList();
            arrayList.add(a.this);
            a.this.K(arrayList);
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdCacheFailed() {
            d.g("BDSPTAG", "onAdCacheFailed");
            a.this.J(new i(-3000, "广告素材加载失败！"));
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdCacheSuccess() {
            d.g("BDSPTAG", "onAdCacheSuccess");
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdClick() {
            d.g("BDSPTAG", IAdInterListener.AdCommandType.AD_CLICK);
            a.this.L();
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdDismissed() {
            d.g("BDSPTAG", "onAdDismissed");
            a.this.M();
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdFailed(String str) {
            a.this.J(new i(-3000, str));
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdPresent() {
            d.g("BDSPTAG", "onAdPresent");
            a.this.N();
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onLpClosed() {
            d.g("BDSPTAG", "onLpClosed");
        }
    }

    public a(com.martian.ttbook.b.c.a.a.d.b.d dVar, e eVar) {
        super(dVar, eVar);
        this.r = new AtomicBoolean();
    }

    private void P(ViewGroup viewGroup, SplashAd splashAd) {
        if (splashAd != null) {
            splashAd.show(viewGroup);
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.k
    public void H(View view) {
        this.m = false;
        String d2 = this.f15663d.f15701c.d(e.c.U, "");
        n.a(this.f15662c.f15670d, d2);
        RequestParameters.Builder builder = new RequestParameters.Builder();
        builder.addExtra("timeout", String.valueOf(this.f15662c.n));
        builder.addExtra(SplashAd.KEY_DISPLAY_DOWNLOADINFO, "true");
        builder.addExtra(SplashAd.KEY_POPDIALOG_DOWNLOAD, "false");
        SplashAd splashAd = new SplashAd(this.f15662c.f15670d.getApplicationContext(), this.f15663d.f15701c.l(e.c.Q), builder.build(), new C0331a());
        this.q = splashAd;
        splashAd.setAppSid(d2);
        new com.martian.ttbook.b.c.a.a.d.b.k(this.f15662c, this.f15663d).a(3).h();
        this.q.load();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.k
    public void I(ViewGroup viewGroup) {
        if (viewGroup == null || this.q == null || !this.r.compareAndSet(false, true)) {
            return;
        }
        P(viewGroup, this.q);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.k, com.martian.ttbook.b.c.a.a.c.a
    public void a(int i2, int i3, String str) {
        com.martian.ttbook.b.c.a.a.b.a.d.x.a.e(this.q, "203");
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.k, com.martian.ttbook.b.c.a.a.c.a
    public void sendWinNotification(int i2) {
        d.h("win " + i2);
        com.martian.ttbook.b.c.a.a.b.a.d.x.a.d(this.q, i2);
    }
}

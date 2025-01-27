package com.martian.ttbook.b.c.a.a.b.a.d.b0.h;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.martian.ttbook.b.c.a.a.b.a.d.b0.b;
import com.martian.ttbook.b.c.a.a.b.a.d.k;
import com.martian.ttbook.b.c.a.a.b.a.d.n;
import com.martian.ttbook.b.c.a.a.d.b.d;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.i;
import com.martian.ttbook.b.c.a.a.e.j;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class a extends k implements KsLoadManager.SplashScreenAdListener, KsSplashScreenAd.SplashScreenAdInteractionListener {
    private String q;
    private AtomicBoolean r;
    private KsSplashScreenAd s;
    int t;

    /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.b0.h.a$a */
    class RunnableC0311a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ com.martian.ttbook.b.c.a.a.d.b.m.a f15351a;

        RunnableC0311a(com.martian.ttbook.b.c.a.a.d.b.m.a aVar) {
            this.f15351a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.super.E(this.f15351a);
        }
    }

    public a(d dVar, e eVar) {
        super(dVar, eVar);
        this.q = "KSSPTAG";
        this.r = new AtomicBoolean();
        this.t = -1;
    }

    private void Q() {
    }

    private void R() {
        M();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.k
    public void E(com.martian.ttbook.b.c.a.a.d.b.m.a aVar) {
        j.b(new RunnableC0311a(aVar), 500L);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.k
    public void H(View view) {
        com.martian.ttbook.b.c.a.a.e.d.g(this.q, "handle");
        this.m = false;
        if (!n.j(this.f15662c.f15670d, this.f15663d.f15701c.d(e.c.U, ""))) {
            J(new i(-1000, "广告加载失败！"));
            return;
        }
        com.martian.ttbook.b.c.a.a.e.d.g(this.q, "s = " + view + ",f = " + this.f15662c.n);
        String l = this.f15663d.f15701c.l(e.c.Q);
        String trim = l.replace("L", "").trim();
        long parseLong = Long.parseLong(trim);
        com.martian.ttbook.b.c.a.a.e.d.g(this.q, "slotId = " + l + ",slotIdStr = " + trim + ",_slotId = " + parseLong);
        KsAdSDK.getLoadManager().loadSplashScreenAd(new KsScene.Builder(parseLong).build(), this);
        new com.martian.ttbook.b.c.a.a.d.b.k(this.f15662c, this.f15663d).a(3).h();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.k
    public void I(ViewGroup viewGroup) {
        com.martian.ttbook.b.c.a.a.e.d.g(this.q, "showAd");
        if (this.r.compareAndSet(false, true)) {
            Q();
            if (viewGroup == null || this.s == null) {
                return;
            }
            com.martian.ttbook.b.c.a.a.e.d.g(this.q, "showAd show");
            View view = this.s.getView(viewGroup.getContext(), this);
            if (view != null) {
                viewGroup.addView(view, new ViewGroup.LayoutParams(-1, -1));
            }
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.k, com.martian.ttbook.b.c.a.a.c.p.a
    public Map<String, Object> a() {
        return this.f15661b;
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.k, com.martian.ttbook.b.c.a.a.c.a
    public void a(int i2, int i3, String str) {
        b.e(this.s, i3);
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdClicked() {
        com.martian.ttbook.b.c.a.a.e.d.g(this.q, "onAdClicked");
        L();
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdShowEnd() {
        com.martian.ttbook.b.c.a.a.e.d.g(this.q, "onAdShowEnd");
        R();
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdShowError(int i2, String str) {
        com.martian.ttbook.b.c.a.a.e.d.g(this.q, "onAdShowError");
        J(new i(i2, str));
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdShowStart() {
        com.martian.ttbook.b.c.a.a.e.d.g(this.q, "onAdShowStart");
        N();
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onDownloadTipsDialogCancel() {
        com.martian.ttbook.b.c.a.a.e.d.g(this.q, "onDownloadTipsDialogCancel");
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onDownloadTipsDialogDismiss() {
        com.martian.ttbook.b.c.a.a.e.d.g(this.q, "onDownloadTipsDialogDismiss");
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onDownloadTipsDialogShow() {
        com.martian.ttbook.b.c.a.a.e.d.g(this.q, "onDownloadTipsDialogShow");
    }

    @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
    public void onError(int i2, String str) {
        com.martian.ttbook.b.c.a.a.e.d.g(this.q, "onError i " + i2 + ", s = " + str);
        J(new i(i2, str));
    }

    @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
    public void onRequestResult(int i2) {
        com.martian.ttbook.b.c.a.a.e.d.g(this.q, "onRequestResult " + i2);
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onSkippedAd() {
        com.martian.ttbook.b.c.a.a.e.d.g(this.q, "onSkippedAd");
        R();
    }

    @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
    public void onSplashScreenAdLoad(@Nullable KsSplashScreenAd ksSplashScreenAd) {
        com.martian.ttbook.b.c.a.a.e.d.g(this.q, "onSplashScreenAdLoad " + ksSplashScreenAd);
        if (ksSplashScreenAd == null) {
            J(new i(10008, "广告无填充"));
            return;
        }
        int b2 = b.b(ksSplashScreenAd);
        if (b.f(this.f15663d, b2)) {
            B(0);
            return;
        }
        G(b2);
        this.s = ksSplashScreenAd;
        this.t = b2;
        b.h(this.f15661b, b2, this.f15663d);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        K(arrayList);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.k, com.martian.ttbook.b.c.a.a.c.a
    public void sendWinNotification(int i2) {
        super.sendWinNotification(i2);
        b.g(this.s, this.t);
    }
}

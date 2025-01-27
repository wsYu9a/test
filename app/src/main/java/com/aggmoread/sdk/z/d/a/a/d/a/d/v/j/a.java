package com.aggmoread.sdk.z.d.a.a.d.a.d.v.j;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.aggmoread.sdk.z.d.a.a.d.a.d.j;
import com.aggmoread.sdk.z.d.a.a.d.a.d.v.b;
import com.aggmoread.sdk.z.d.a.a.d.a.d.v.c;
import com.aggmoread.sdk.z.d.a.a.d.b.d;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.d.b.i;
import com.aggmoread.sdk.z.d.a.a.d.b.k;
import com.aggmoread.sdk.z.d.a.a.e.n;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class a extends j implements KsLoadManager.SplashScreenAdListener, KsSplashScreenAd.SplashScreenAdInteractionListener {
    int A;

    /* renamed from: x */
    private String f5810x;

    /* renamed from: y */
    private AtomicBoolean f5811y;

    /* renamed from: z */
    private KsSplashScreenAd f5812z;

    /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.v.j.a$a */
    public class RunnableC0177a implements Runnable {

        /* renamed from: b */
        final /* synthetic */ com.aggmoread.sdk.z.d.a.a.d.b.m.a f5813b;

        public RunnableC0177a(com.aggmoread.sdk.z.d.a.a.d.b.m.a aVar) {
            this.f5813b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.super.a(this.f5813b);
        }
    }

    public a(d dVar, e eVar) {
        super(dVar, eVar);
        this.f5810x = "AMSTAGKS";
        this.f5811y = new AtomicBoolean();
        this.A = -1;
    }

    private void u() {
    }

    private void v() {
        r();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.j
    public void a(View view) {
        com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5810x, "handle");
        this.f5378r = false;
        if (!b.a(this.f5842g.f5858d, this.f5843h.f5907c.a(e.c.X, ""))) {
            b(new i(1001002008, "广告加载失败！"));
            return;
        }
        com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5810x, "s = " + view + ",f = " + this.f5842g.f5868n);
        String c10 = this.f5843h.f5907c.c(e.c.T);
        String trim = c10.replace("L", "").trim();
        long parseLong = Long.parseLong(trim);
        com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5810x, "slotId = " + c10 + ",slotIdStr = " + trim + ",_slotId = " + parseLong);
        KsAdSDK.getLoadManager().loadSplashScreenAd(c.a().a(new KsScene.Builder(parseLong)).build(), this);
        new k(this.f5842g, this.f5843h).a(0).b();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.j, com.aggmoread.sdk.z.d.a.a.d.b.a
    public void b(int i10, int i11, String str) {
        b.a(this.f5812z, i11);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.j, com.aggmoread.sdk.z.d.a.a.d.b.a
    public void c(int i10) {
        super.c(i10);
        b.b(this.f5812z, this.A);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.j, com.aggmoread.sdk.z.d.a.a.c.a
    public Map<String, Object> h() {
        return this.f5841f;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public String j() {
        return b.a().a(this.f5812z);
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdClicked() {
        com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5810x, "onAdClicked");
        q();
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdShowEnd() {
        com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5810x, "onAdShowEnd");
        v();
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdShowError(int i10, String str) {
        com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5810x, "onAdShowError");
        b(new i(i10, str));
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onAdShowStart() {
        com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5810x, "onAdShowStart");
        s();
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onDownloadTipsDialogCancel() {
        com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5810x, "onDownloadTipsDialogCancel");
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onDownloadTipsDialogDismiss() {
        com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5810x, "onDownloadTipsDialogDismiss");
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onDownloadTipsDialogShow() {
        com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5810x, "onDownloadTipsDialogShow");
    }

    @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
    public void onError(int i10, String str) {
        com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5810x, "onError i " + i10 + ", s = " + str);
        b(new i(i10, str));
    }

    @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
    public void onRequestResult(int i10) {
        com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5810x, "onRequestResult " + i10);
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
    public void onSkippedAd() {
        com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5810x, "onSkippedAd");
        v();
    }

    @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
    public void onSplashScreenAdLoad(@Nullable KsSplashScreenAd ksSplashScreenAd) {
        com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5810x, "onSplashScreenAdLoad " + ksSplashScreenAd);
        if (ksSplashScreenAd == null) {
            b(new i(1001004001, "广告无填充"));
            return;
        }
        int a10 = b.a((Object) ksSplashScreenAd);
        if (b.a(this.f5843h, a10)) {
            a(a10, 0);
            return;
        }
        b(a10);
        this.f5812z = ksSplashScreenAd;
        this.A = a10;
        b.b(this.f5841f, a10, this.f5843h);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        e(arrayList);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.j
    public void b(ViewGroup viewGroup) {
        com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5810x, "showAd");
        if (this.f5811y.compareAndSet(false, true)) {
            u();
            if (viewGroup == null || this.f5812z == null) {
                return;
            }
            com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5810x, "showAd show");
            View view = this.f5812z.getView(viewGroup.getContext(), this);
            if (view != null) {
                viewGroup.addView(view, new ViewGroup.LayoutParams(-1, -1));
            }
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.j
    public void a(com.aggmoread.sdk.z.d.a.a.d.b.m.a aVar) {
        n.a(new RunnableC0177a(aVar), 500L);
    }
}

package com.kwad.components.ad.reward.n;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.ah;
import com.kwad.components.core.webview.jshandler.ak;
import com.kwad.components.core.webview.jshandler.al;
import com.kwad.components.core.webview.jshandler.ar;
import com.kwad.components.core.webview.jshandler.bb;
import com.kwad.components.core.webview.jshandler.be;
import com.kwad.components.core.webview.jshandler.y;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.bm;

/* loaded from: classes2.dex */
public class e extends com.kwad.sdk.core.download.a.a implements ak.b, ar.b {
    private KsAdWebView dY;

    /* renamed from: ea */
    private com.kwad.components.core.webview.a f11736ea;

    /* renamed from: eb */
    private com.kwad.sdk.core.webview.b f11737eb;

    /* renamed from: ee */
    private com.kwad.sdk.core.webview.d.a.a f11738ee;

    @Nullable
    private AdTemplate mAdTemplate;

    @Nullable
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private final com.kwad.components.ad.reward.e.l mRewardVerifyListener = new com.kwad.components.ad.reward.e.l() { // from class: com.kwad.components.ad.reward.n.e.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (e.this.zW != null) {
                e.this.zW.ah(true);
            }
        }
    };
    private View zV;
    private be zW;
    private f zX;

    /* renamed from: com.kwad.components.ad.reward.n.e$1 */
    public class AnonymousClass1 implements com.kwad.components.ad.reward.e.l {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (e.this.zW != null) {
                e.this.zW.ah(true);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.n.e$2 */
    public class AnonymousClass2 implements KsAdWebView.e {
        public AnonymousClass2() {
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.e
        public final void onPageFinished() {
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.e
        public final void onPageStart() {
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.e
        public final void onReceivedHttpError(int i10, String str, String str2) {
            com.kwad.sdk.core.d.c.d("BottomCardWebViewHelper", "onReceivedHttpError: " + i10 + ", " + str);
            e.this.ko();
        }
    }

    public e(KsAdWebView ksAdWebView, View view, @Nullable com.kwad.components.core.e.d.c cVar, com.kwad.sdk.core.webview.d.a.a aVar) {
        this.zV = view;
        this.dY = ksAdWebView;
        this.mApkDownloadHelper = cVar;
        this.f11738ee = aVar;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void U(String str) {
        if (bm.isNullString(str)) {
            ko();
            return;
        }
        aZ();
        this.dY.setClientConfig(this.dY.getClientConfig().ex(this.mAdTemplate).b(getWebErrorListener()));
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.dY);
        this.f11736ea = aVar;
        a(aVar, str);
        this.dY.addJavascriptInterface(this.f11736ea, "KwaiAd");
        this.dY.loadUrl(str);
    }

    private void aZ() {
        com.kwad.components.core.webview.a aVar = this.f11736ea;
        if (aVar != null) {
            aVar.destroy();
            this.f11736ea = null;
        }
    }

    private void ad(boolean z10) {
        com.kwad.sdk.core.d.c.d("BottomCardWebViewHelper", "switchWebView: " + z10);
        KsAdWebView ksAdWebView = this.dY;
        if (ksAdWebView == null) {
            return;
        }
        ksAdWebView.setVisibility(z10 ? 0 : 8);
    }

    @NonNull
    private KsAdWebView.e getWebErrorListener() {
        return new KsAdWebView.e() { // from class: com.kwad.components.ad.reward.n.e.2
            public AnonymousClass2() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageFinished() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onReceivedHttpError(int i10, String str, String str2) {
                com.kwad.sdk.core.d.c.d("BottomCardWebViewHelper", "onReceivedHttpError: " + i10 + ", " + str);
                e.this.ko();
            }
        };
    }

    private void k(String str, int i10) {
        f fVar = this.zX;
        if (fVar != null) {
            fVar.i(str, i10);
        }
    }

    public void ko() {
        View view = this.zV;
        if (view != null) {
            view.setVisibility(0);
        }
        ad(false);
    }

    public final void kn() {
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this);
        }
        com.kwad.components.ad.reward.b.fv().b(this.mRewardVerifyListener);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFailed() {
        AdTemplate adTemplate = this.mAdTemplate;
        k(adTemplate != null ? com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.eb(adTemplate)) : "立即下载", 100);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFinished() {
        AdTemplate adTemplate = this.mAdTemplate;
        k(adTemplate == null ? "" : com.kwad.sdk.core.response.b.a.cg(adTemplate), 100);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onIdle() {
        AdTemplate adTemplate = this.mAdTemplate;
        k(adTemplate != null ? com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.eb(adTemplate)) : "立即下载", 100);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onInstalled() {
        AdTemplate adTemplate = this.mAdTemplate;
        k(adTemplate != null ? com.kwad.sdk.core.response.b.a.ac(com.kwad.sdk.core.response.b.e.eb(adTemplate)) : "立即打开", 100);
    }

    @Override // com.kwad.sdk.core.download.a.a
    public final void onPaused(int i10) {
        k(com.kwad.sdk.core.response.b.a.dp(i10), i10);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onProgressUpdate(int i10) {
        if (i10 != 0) {
            k(com.kwad.sdk.core.response.b.a.m36do(i10), i10);
        }
    }

    private void b(AdTemplate adTemplate, ViewGroup viewGroup) {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.f11737eb = bVar;
        bVar.setAdTemplate(adTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.f11737eb;
        bVar2.mScreenOrientation = 0;
        bVar2.aIc = null;
        bVar2.QI = viewGroup;
        bVar2.Qc = this.dY;
        bVar2.mReportExtData = null;
        bVar2.aIe = true;
    }

    public final void a(f fVar) {
        this.zX = fVar;
    }

    public final void a(AdTemplate adTemplate, ViewGroup viewGroup) {
        KsAdWebView ksAdWebView = this.dY;
        if (ksAdWebView != null) {
            ksAdWebView.setBackgroundColor(0);
            if (this.dY.getBackground() != null) {
                this.dY.getBackground().setAlpha(0);
            }
        }
        com.kwad.components.ad.reward.b.fv().a(this.mRewardVerifyListener);
        this.mAdTemplate = adTemplate;
        b(adTemplate, viewGroup);
        U(com.kwad.sdk.core.response.b.b.cs(this.mAdTemplate));
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.b(this);
        }
    }

    private void a(com.kwad.components.core.webview.a aVar, String str) {
        aVar.a(new y(this.f11737eb, this.mApkDownloadHelper, this.f11738ee));
        aVar.a(new ae(this.f11737eb));
        aVar.a(new ad(this.f11737eb));
        aVar.a(new ar(this, str));
        be beVar = new be();
        this.zW = beVar;
        aVar.a(beVar);
        aVar.a(new al(this.f11737eb));
        aVar.b(new com.kwad.components.core.webview.jshandler.n(this.f11737eb));
        aVar.b(new com.kwad.components.core.webview.jshandler.m(this.f11737eb));
        aVar.a(new ah(this.f11737eb));
        aVar.a(new com.kwad.components.core.webview.tachikoma.a.f());
        aVar.a(new ak(this.f11737eb, this));
        aVar.a(new bb(this.f11737eb, this.mApkDownloadHelper));
        aVar.a(new com.kwad.components.ad.reward.i.b(this.dY.getContext(), this.mAdTemplate, PlayableSource.ACTIONBAR_CLICK));
    }

    @Override // com.kwad.components.core.webview.jshandler.ar.b
    public final void a(ar.a aVar) {
        com.kwad.sdk.core.d.c.d("BottomCardWebViewHelper", getClass().getName() + " updatePageStatus: " + aVar);
        if (aVar.status == 1) {
            ad(true);
        } else {
            ko();
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.ak.b
    public final void a(@NonNull ak.a aVar) {
        com.kwad.sdk.core.d.c.d("BottomCardWebViewHelper", "onAdFrameValid : " + aVar.toJson());
    }
}

package com.kwad.sdk.core.webview.a;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;

/* loaded from: classes3.dex */
public class c extends com.kwad.sdk.core.webview.a.a {
    private a JF;

    public static class a {
        private KsAdWebView.c QN;
        private int Qq;
        private KsAdWebView.e aIr;
        private KsAdWebView.d aIs;
        private boolean aIt;
        private boolean aIw;
        private KsAdWebView.b aco;
        private AdTemplate mAdTemplate;
        private final Context mContext;
        private boolean aIu = true;
        private boolean aIv = true;
        private boolean aIq = true;
        private boolean aIx = false;
        private long aIy = 600;
        private long aIz = 0;

        public a(Context context) {
            this.mContext = context;
        }

        private boolean IF() {
            return this.aIx;
        }

        public final KsAdWebView.d IE() {
            return this.aIs;
        }

        public final boolean IG() {
            return this.aIv;
        }

        public final boolean IH() {
            return this.aIq;
        }

        public final boolean II() {
            return this.aIu;
        }

        public final boolean IJ() {
            return this.aIw;
        }

        public final boolean IK() {
            if (!IF()) {
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j10 = this.aIz;
            return j10 > 0 && currentTimeMillis - j10 <= this.aIy;
        }

        public final a a(KsAdWebView.d dVar) {
            this.aIs = dVar;
            return this;
        }

        public final void aE(long j10) {
            this.aIz = j10;
        }

        public final a b(KsAdWebView.e eVar) {
            this.aIr = eVar;
            return this;
        }

        public final a bv(boolean z10) {
            this.aIx = true;
            return this;
        }

        public final a bw(boolean z10) {
            this.aIt = true;
            return this;
        }

        public final a bx(boolean z10) {
            this.aIv = z10;
            return this;
        }

        public final a by(boolean z10) {
            this.aIu = z10;
            return this;
        }

        public final a bz(boolean z10) {
            this.aIw = true;
            return this;
        }

        public final a c(KsAdWebView.c cVar) {
            this.QN = cVar;
            return this;
        }

        public final a dB(int i10) {
            this.Qq = i10;
            return this;
        }

        public final a ex(AdTemplate adTemplate) {
            this.mAdTemplate = adTemplate;
            return this;
        }

        public final AdTemplate getAdTemplate() {
            return this.mAdTemplate;
        }

        public final Context getContext() {
            return this.mContext;
        }

        public final KsAdWebView.e iF() {
            return this.aIr;
        }

        public final KsAdWebView.b mX() {
            return this.aco;
        }

        public final com.kwad.sdk.core.adlog.c.a oz() {
            return com.kwad.sdk.core.adlog.c.a.CP().cJ(this.Qq).cK(this.aIt ? 1 : 0);
        }

        public final KsAdWebView.c qq() {
            return this.QN;
        }

        public final a a(KsAdWebView.b bVar) {
            this.aco = bVar;
            return this;
        }
    }

    public static int a(@NonNull a aVar, String str) {
        int E = com.kwad.sdk.core.download.a.b.E(aVar.getContext(), str);
        if (E == 1) {
            if (aVar.mX() != null) {
                aVar.mX().onSuccess();
            }
            com.kwad.sdk.core.adlog.c.a(aVar.getAdTemplate(), "", 2, (com.kwad.sdk.core.adlog.c.a) null);
        } else {
            if (aVar.mX() != null) {
                aVar.mX().onFailed();
            }
            if (E == -1) {
                com.kwad.sdk.core.adlog.c.b(aVar.getAdTemplate(), "", 2, null);
            }
        }
        return E;
    }

    private boolean eW(String str) {
        try {
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.printStackTrace(e10);
        }
        if (!str.startsWith("http") && !str.startsWith("https")) {
            if (!str.startsWith("tel:") && !str.startsWith("sms:")) {
                a aVar = this.JF;
                if (aVar != null) {
                    if (aVar.IG()) {
                        a(this.JF, str);
                        return true;
                    }
                    if (eX(str)) {
                        return true;
                    }
                }
                return false;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            a aVar2 = this.JF;
            if (aVar2 != null) {
                aVar2.getContext().startActivity(intent);
            }
            return true;
        }
        return false;
    }

    private static boolean eX(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("hwfastapp://") || str.startsWith("hap://app") || str.startsWith("intent://hapjs.org/") || str.startsWith("intent://");
    }

    public final void N(String str) {
        this.mUniqueId = str;
    }

    public final a getClientConfig() {
        return this.JF;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        com.kwad.sdk.core.webview.b.c.b.ae(this.mUniqueId, "onPageFinished");
        a aVar = this.JF;
        if (aVar == null || aVar.iF() == null) {
            return;
        }
        this.JF.iF().onPageFinished();
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        com.kwad.sdk.core.webview.b.c.b.ae(this.mUniqueId, "onPageStart");
        a aVar = this.JF;
        if (aVar == null || aVar.iF() == null) {
            return;
        }
        this.JF.iF().onPageStart();
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i10, String str, String str2) {
        super.onReceivedError(webView, i10, str, str2);
        com.kwad.sdk.core.d.c.d("KsAdWebViewClient", "onReceivedError " + i10);
        a aVar = this.JF;
        if (aVar != null && aVar.iF() != null) {
            this.JF.iF().onReceivedHttpError(i10, str, str2);
        }
        com.kwad.sdk.core.webview.b.c.b.ag(str2, str);
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        boolean didCrash;
        if (Build.VERSION.SDK_INT >= 26 && renderProcessGoneDetail != null) {
            didCrash = renderProcessGoneDetail.didCrash();
            if (didCrash) {
                return true;
            }
        }
        return super.onRenderProcessGone(webView, renderProcessGoneDetail);
    }

    public final void setClientConfig(a aVar) {
        this.JF = aVar;
        setNeedHybridLoad(aVar.IH());
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        com.kwad.sdk.core.d.c.w("KsAdWebViewClient", "shouldOverrideUrlLoading url=" + str);
        com.kwad.sdk.core.webview.b.c.b.ae(this.mUniqueId, "shouldOverrideUrlLoading");
        a aVar = this.JF;
        if (aVar == null || !aVar.IK() || ((this.JF.IE() != null && this.JF.IE().shouldOverrideUrlLoading(webView, str)) || eW(str))) {
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }
}

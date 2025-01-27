package com.kwad.sdk.core.webview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.webview.a.c;
import com.kwad.sdk.n.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bw;
import com.kwad.sdk.utils.by;
import com.kwad.sdk.utils.l;
import com.sigmob.sdk.base.mta.PointCategory;

/* loaded from: classes3.dex */
public class KsAdWebView extends com.kwad.sdk.core.webview.c {

    @NonNull
    private c.a JF;
    private com.kwad.sdk.core.webview.a.c aIj;
    private String aIk;
    private long aIl;

    @Nullable
    private com.kwad.sdk.core.webview.d aIm;
    private String mUniqueId;

    /* renamed from: com.kwad.sdk.core.webview.KsAdWebView$1 */
    public class AnonymousClass1 extends com.kwad.sdk.core.webview.a.c {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.webview.a.c, android.webkit.WebViewClient
        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (KsAdWebView.this.aIm != null) {
                KsAdWebView.this.aIm.c(KsAdWebView.this.JF);
            }
        }

        @Override // com.kwad.sdk.core.webview.a.c, android.webkit.WebViewClient
        public final void onReceivedError(WebView webView, int i10, String str, String str2) {
            super.onReceivedError(webView, i10, str, str2);
            if (KsAdWebView.this.aIm != null) {
                com.kwad.sdk.core.webview.d unused = KsAdWebView.this.aIm;
                com.kwad.sdk.core.webview.d.d(KsAdWebView.this.JF);
            }
        }
    }

    public class a implements DownloadListener {
        private a() {
        }

        @Override // android.webkit.DownloadListener
        public final void onDownloadStart(String str, String str2, String str3, String str4, long j10) {
            boolean o10 = bw.o(KsAdWebView.this, 100);
            com.kwad.sdk.core.d.c.d("KsAdWebView", "onDownloadStart: currentVisible " + o10);
            if (o10 && KsAdWebView.this.JF.IK()) {
                if (KsAdWebView.this.JF == null || KsAdWebView.this.JF.getAdTemplate() == null || !KsAdWebView.this.JF.II()) {
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                        intent.setFlags(268435456);
                        KsAdWebView.this.getContext().startActivity(intent);
                        return;
                    } catch (Exception e10) {
                        com.kwad.sdk.core.d.c.printStackTrace(e10);
                        return;
                    }
                }
                com.kwad.sdk.core.response.b.e.eb(KsAdWebView.this.JF.getAdTemplate()).adConversionInfo.appDownloadUrl = str;
                KsAdWebView.this.JF.getAdTemplate().isWebViewDownload = true;
                c.a readyClientConfig = KsAdWebView.this.getReadyClientConfig();
                if (readyClientConfig != null) {
                    readyClientConfig.ex(KsAdWebView.this.JF.getAdTemplate());
                }
                ((com.kwad.sdk.service.a.a) ServiceProvider.get(com.kwad.sdk.service.a.a.class)).h(m.wrapContextIfNeed(KsAdWebView.this.getContext()), KsAdWebView.this.JF.getAdTemplate());
            }
        }

        public /* synthetic */ a(KsAdWebView ksAdWebView, byte b10) {
            this();
        }
    }

    public interface b {
        void onFailed();

        void onSuccess();
    }

    public interface c {
        void qr();
    }

    public interface d {
        boolean shouldOverrideUrlLoading(WebView webView, String str);
    }

    public interface e {
        void onPageFinished();

        void onPageStart();

        void onReceivedHttpError(int i10, String str, String str2);
    }

    public KsAdWebView(Context context) {
        super(context);
        init(context);
    }

    private String ID() {
        return "KSADSDK_V3.3.69_" + getContext().getPackageName() + hf.e.f26694a + l.ch(getContext());
    }

    public c.a getReadyClientConfig() {
        com.kwad.sdk.core.webview.a.c cVar = this.aIj;
        if (cVar == null || cVar.getClientConfig() == null) {
            return null;
        }
        return this.aIj.getClientConfig();
    }

    private void init(Context context) {
        com.kwad.sdk.core.d.c.i("KsAdWebView", PointCategory.INIT);
        setAccessibilityStateDisable(context);
        WebSettings a10 = by.a(this);
        a10.setUseWideViewPort(true);
        a10.setDomStorageEnabled(true);
        setVerticalScrollBarEnabled(false);
        AnonymousClass1 anonymousClass1 = new com.kwad.sdk.core.webview.a.c() { // from class: com.kwad.sdk.core.webview.KsAdWebView.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.core.webview.a.c, android.webkit.WebViewClient
            public final void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (KsAdWebView.this.aIm != null) {
                    KsAdWebView.this.aIm.c(KsAdWebView.this.JF);
                }
            }

            @Override // com.kwad.sdk.core.webview.a.c, android.webkit.WebViewClient
            public final void onReceivedError(WebView webView, int i10, String str, String str2) {
                super.onReceivedError(webView, i10, str, str2);
                if (KsAdWebView.this.aIm != null) {
                    com.kwad.sdk.core.webview.d unused = KsAdWebView.this.aIm;
                    com.kwad.sdk.core.webview.d.d(KsAdWebView.this.JF);
                }
            }
        };
        this.aIj = anonymousClass1;
        anonymousClass1.N(this.mUniqueId);
        setWebViewClient(this.aIj);
        setWebChromeClient(new com.kwad.sdk.core.webview.a.b());
        setDownloadListener(new a(this, (byte) 0));
        a10.setUserAgentString(a10.getUserAgentString() + ID());
        this.JF = new c.a(getContext());
    }

    private void setAccessibilityStateDisable(Context context) {
    }

    public c.a getClientConfig() {
        return this.JF;
    }

    public long getLoadTime() {
        return this.aIl;
    }

    public String getLoadUrl() {
        return this.aIk;
    }

    public String getUniqueId() {
        return this.mUniqueId;
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        com.kwad.sdk.core.webview.b.c.b.fi(this.mUniqueId);
        this.aIk = str;
        this.aIl = System.currentTimeMillis();
        super.loadUrl(str);
    }

    public final void onActivityCreate() {
        com.kwad.sdk.core.webview.d dVar = this.aIm;
        if (dVar != null) {
            dVar.a(this.JF);
        }
    }

    public final void onActivityDestroy() {
        release();
        com.kwad.sdk.core.webview.d dVar = this.aIm;
        if (dVar != null) {
            dVar.b(this.JF);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i10, int i11, int i12, int i13) {
        super.onScrollChanged(i10, i11, i12, i13);
        c.a aVar = this.JF;
        if (aVar == null || aVar.qq() == null) {
            return;
        }
        this.JF.qq().qr();
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.JF.aE(System.currentTimeMillis());
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setClientConfig(c.a aVar) {
        this.aIj.setClientConfig(aVar);
        if (this.JF.IJ()) {
            this.aIm = new com.kwad.sdk.core.webview.d();
        }
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        if (com.kwad.framework.a.a.ns.booleanValue() && !(webChromeClient instanceof com.kwad.sdk.core.webview.a.b)) {
            throw new IllegalArgumentException("client is not instanceof KSWebChromeClient");
        }
        super.setWebChromeClient(webChromeClient);
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        if (com.kwad.framework.a.a.ns.booleanValue() && !(webViewClient instanceof com.kwad.sdk.core.webview.a.a)) {
            throw new IllegalArgumentException("Not supported set webViewClient, please check it");
        }
        super.setWebViewClient(webViewClient);
    }

    public KsAdWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public KsAdWebView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        init(context);
    }

    public KsAdWebView(Context context, AttributeSet attributeSet, int i10, boolean z10) {
        super(context, attributeSet, i10, z10);
        init(context);
    }
}

package com.kwad.components.core.n.b.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.webview.BaseKsWebView;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.bz;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class a extends BaseKsWebView {
    private KsAdWebView PT;
    private boolean enableScroll;

    /* renamed from: com.kwad.components.core.n.b.d.a$1 */
    public class AnonymousClass1 implements KsAdWebView.d {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.d
        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (a.this.mWebLoadListener != null) {
                return a.this.mWebLoadListener.shouldOverrideUrlLoading(webView, str);
            }
            return false;
        }
    }

    /* renamed from: com.kwad.components.core.n.b.d.a$2 */
    public class AnonymousClass2 implements KsAdWebView.b {
        public AnonymousClass2() {
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.b
        public final void onFailed() {
            if (a.this.mDeeplinkListener != null) {
                a.this.mDeeplinkListener.onFailed();
            }
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.b
        public final void onSuccess() {
            if (a.this.mDeeplinkListener != null) {
                a.this.mDeeplinkListener.onSuccess();
            }
        }
    }

    /* renamed from: com.kwad.components.core.n.b.d.a$3 */
    public class AnonymousClass3 implements KsAdWebView.e {
        public AnonymousClass3() {
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.e
        public final void onPageFinished() {
            if (a.this.mWebLoadListener != null) {
                a.this.mWebLoadListener.onPageFinished();
            }
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.e
        public final void onPageStart() {
            if (a.this.mWebLoadListener != null) {
                a.this.mWebLoadListener.onPageStart();
            }
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.e
        public final void onReceivedHttpError(int i10, String str, String str2) {
            if (a.this.mWebLoadListener != null) {
                a.this.mWebLoadListener.onReceivedHttpError(i10, str, str2);
            }
        }
    }

    public a(@NonNull Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        setBackgroundColor(0);
        this.PT = new KsAdWebView(context);
        this.PT.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.PT.setBackgroundColor(0);
        this.PT.setClientConfig(this.PT.getClientConfig().b(new KsAdWebView.e() { // from class: com.kwad.components.core.n.b.d.a.3
            public AnonymousClass3() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageFinished() {
                if (a.this.mWebLoadListener != null) {
                    a.this.mWebLoadListener.onPageFinished();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageStart() {
                if (a.this.mWebLoadListener != null) {
                    a.this.mWebLoadListener.onPageStart();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onReceivedHttpError(int i10, String str, String str2) {
                if (a.this.mWebLoadListener != null) {
                    a.this.mWebLoadListener.onReceivedHttpError(i10, str, str2);
                }
            }
        }).a(new KsAdWebView.b() { // from class: com.kwad.components.core.n.b.d.a.2
            public AnonymousClass2() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onFailed() {
                if (a.this.mDeeplinkListener != null) {
                    a.this.mDeeplinkListener.onFailed();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onSuccess() {
                if (a.this.mDeeplinkListener != null) {
                    a.this.mDeeplinkListener.onSuccess();
                }
            }
        }).a(new KsAdWebView.d() { // from class: com.kwad.components.core.n.b.d.a.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (a.this.mWebLoadListener != null) {
                    return a.this.mWebLoadListener.shouldOverrideUrlLoading(webView, str);
                }
                return false;
            }
        }));
        addView(this.PT);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    @SuppressLint({"JavascriptInterface", "AddJavascriptInterface"})
    public final void addJavascriptInterface(Object obj, String str) {
        this.PT.addJavascriptInterface(obj, str);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void callJs(String str) {
        bz.a(this.PT, str, (String) null);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final boolean canGoBack() {
        return this.PT.canGoBack();
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final boolean canGoForward() {
        return this.PT.canGoForward();
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void destroy() {
        this.PT.destroy();
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void goBack() {
        this.PT.goBack();
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void goForward() {
        this.PT.goForward();
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void loadUrl(String str) {
        this.PT.loadUrl(str);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView, android.view.View
    public final void scrollBy(int i10, int i11) {
        if (this.enableScroll) {
            this.PT.scrollBy(i10, i11);
        }
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView, android.view.View
    public final void scrollTo(int i10, int i11) {
        if (this.enableScroll) {
            this.PT.scrollTo(i10, i11);
        }
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setAcceptThirdPartyCookies(boolean z10) {
        CookieManager.getInstance().setAcceptThirdPartyCookies(this.PT, z10);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setAdCacheId(int i10, String str) {
        AdTemplate a10 = c.a(com.kwad.components.core.n.a.d.a.a.au(i10), str);
        if (a10 != null) {
            this.PT.getClientConfig().ex(a10);
        }
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setAdTemplateString(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            AdTemplate adTemplate = new AdTemplate();
            adTemplate.parseJson(jSONObject);
            this.PT.getClientConfig().ex(adTemplate);
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setAllowContentAccess(boolean z10) {
        this.PT.getSettings().setAllowContentAccess(z10);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setAllowFileAccess(boolean z10) {
        this.PT.getSettings().setAllowFileAccess(z10);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setAllowFileAccessFromFileURLs(boolean z10) {
        this.PT.getSettings().setAllowFileAccessFromFileURLs(z10);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setAllowUniversalAccessFromFileURLs(boolean z10) {
        this.PT.getSettings().setAllowUniversalAccessFromFileURLs(z10);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setCacheMode(int i10) {
        this.PT.getSettings().setCacheMode(i10);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setContextUniqId(int i10) {
        AdTemplate o10 = c.o(com.kwad.components.core.n.a.d.a.a.au(i10));
        if (o10 != null) {
            this.PT.getClientConfig().ex(o10);
        }
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setDebugEnabled(boolean z10) {
        WebView.setWebContentsDebuggingEnabled(z10);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setDeeplinkEnabled(boolean z10) {
        this.PT.getClientConfig().bx(z10);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setEnableScroll(boolean z10) {
        this.enableScroll = z10;
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setEnableWebCache(boolean z10) {
        this.PT.setNeedHybridLoad(z10);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setInnerDownloadEnabled(boolean z10) {
        this.PT.getClientConfig().by(z10);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setJavaScriptEnabled(boolean z10) {
        this.PT.getSettings().setJavaScriptEnabled(z10);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setMixedContentMode(int i10) {
        this.PT.getSettings().setMixedContentMode(i10);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setSavePassword(boolean z10) {
        this.PT.getSettings().setSavePassword(z10);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setTextZoom(int i10) {
        this.PT.getSettings().setTextZoom(i10);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void callJs(String str, String str2) {
        bz.a(this.PT, str, str2);
    }
}

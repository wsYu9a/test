package com.kwad.components.core.offline.init.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.webview.BaseKsWebView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.bo;

/* loaded from: classes2.dex */
public final class a extends BaseKsWebView {
    private KsAdWebView KZ;
    private boolean enableScroll;

    /* renamed from: com.kwad.components.core.offline.init.c.a$1 */
    final class AnonymousClass1 implements KsAdWebView.b {
        AnonymousClass1() {
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

    /* renamed from: com.kwad.components.core.offline.init.c.a$2 */
    final class AnonymousClass2 implements KsAdWebView.d {
        AnonymousClass2() {
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.d
        public final void onPageFinished() {
            if (a.this.mWebLoadListener != null) {
                a.this.mWebLoadListener.onPageFinished();
            }
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.d
        public final void onPageStart() {
            if (a.this.mWebLoadListener != null) {
                a.this.mWebLoadListener.onPageStart();
            }
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.d
        public final void onReceivedHttpError(int i2, String str, String str2) {
            if (a.this.mWebLoadListener != null) {
                a.this.mWebLoadListener.onReceivedHttpError(i2, str, str2);
            }
        }
    }

    public a(@NonNull Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        setBackgroundColor(0);
        this.KZ = new KsAdWebView(context);
        this.KZ.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.KZ.setBackgroundColor(0);
        this.KZ.setClientConfig(this.KZ.getClientConfig().b(new KsAdWebView.d() { // from class: com.kwad.components.core.offline.init.c.a.2
            AnonymousClass2() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageFinished() {
                if (a.this.mWebLoadListener != null) {
                    a.this.mWebLoadListener.onPageFinished();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageStart() {
                if (a.this.mWebLoadListener != null) {
                    a.this.mWebLoadListener.onPageStart();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onReceivedHttpError(int i2, String str, String str2) {
                if (a.this.mWebLoadListener != null) {
                    a.this.mWebLoadListener.onReceivedHttpError(i2, str, str2);
                }
            }
        }).a(new KsAdWebView.b() { // from class: com.kwad.components.core.offline.init.c.a.1
            AnonymousClass1() {
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
        }));
        addView(this.KZ);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    @SuppressLint({"JavascriptInterface", "AddJavascriptInterface"})
    public final void addJavascriptInterface(Object obj, String str) {
        this.KZ.addJavascriptInterface(obj, str);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void callJs(String str) {
        bo.a(this.KZ, str, (String) null);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void callJs(String str, String str2) {
        bo.a(this.KZ, str, str2);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void destroy() {
        this.KZ.destroy();
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void loadUrl(String str) {
        this.KZ.loadUrl(str);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView, android.view.View
    public final void scrollBy(int i2, int i3) {
        if (this.enableScroll) {
            this.KZ.scrollBy(i2, i3);
        }
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView, android.view.View
    public final void scrollTo(int i2, int i3) {
        if (this.enableScroll) {
            this.KZ.scrollTo(i2, i3);
        }
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setAcceptThirdPartyCookies(boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(this.KZ, z);
        }
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setAllowContentAccess(boolean z) {
        this.KZ.getSettings().setAllowContentAccess(z);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setAllowFileAccess(boolean z) {
        this.KZ.getSettings().setAllowFileAccess(z);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setAllowFileAccessFromFileURLs(boolean z) {
        this.KZ.getSettings().setAllowFileAccessFromFileURLs(z);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setAllowUniversalAccessFromFileURLs(boolean z) {
        this.KZ.getSettings().setAllowUniversalAccessFromFileURLs(z);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setCacheMode(int i2) {
        this.KZ.getSettings().setCacheMode(i2);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setContextUniqId(int i2) {
        AdTemplate av = com.kwad.components.core.offline.api.a.kwai.a.av(i2);
        if (av != null) {
            this.KZ.getClientConfig().ct(av);
        }
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setDebugEnabled(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(z);
        }
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setDeeplinkEnabled(boolean z) {
        this.KZ.getClientConfig().bc(z);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setEnableScroll(boolean z) {
        this.enableScroll = z;
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setEnableWebCache(boolean z) {
        this.KZ.setNeedHybridLoad(z);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setInnerDownloadEnabled(boolean z) {
        this.KZ.getClientConfig().bd(z);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setJavaScriptEnabled(boolean z) {
        this.KZ.getSettings().setJavaScriptEnabled(z);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setMixedContentMode(int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.KZ.getSettings().setMixedContentMode(i2);
        }
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setSavePassword(boolean z) {
        this.KZ.getSettings().setSavePassword(z);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setTextZoom(int i2) {
        this.KZ.getSettings().setTextZoom(i2);
    }
}

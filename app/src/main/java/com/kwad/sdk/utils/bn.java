package com.kwad.sdk.utils;

import android.os.Build;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.annotation.MainThread;

/* loaded from: classes2.dex */
public final class bn {
    @MainThread
    public static WebSettings a(WebView webView) {
        webView.getSettings().setAllowFileAccess(false);
        return b(webView);
    }

    private static WebSettings b(WebView webView) {
        WebSettings settings = webView.getSettings();
        settings.setAllowContentAccess(false);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setTextZoom(100);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            settings.setMixedContentMode(0);
        }
        if (i2 < 19) {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        }
        if (i2 >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);
        }
        webView.setSaveEnabled(false);
        return settings;
    }
}

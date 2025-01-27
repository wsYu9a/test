package com.tencent.bugly.crashreport;

import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.crash.h5.H5JavaScriptInterface;

/* loaded from: classes4.dex */
public class a implements CrashReport.WebViewInterface {

    /* renamed from: a */
    final /* synthetic */ WebView f22228a;

    public a(WebView webView) {
        this.f22228a = webView;
    }

    @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
    public void addJavascriptInterface(H5JavaScriptInterface h5JavaScriptInterface, String str) {
        this.f22228a.addJavascriptInterface(h5JavaScriptInterface, str);
    }

    @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
    public CharSequence getContentDescription() {
        return this.f22228a.getContentDescription();
    }

    @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
    public String getUrl() {
        return this.f22228a.getUrl();
    }

    @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
    public void loadUrl(String str) {
        this.f22228a.loadUrl(str);
    }

    @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
    public void setJavaScriptEnabled(boolean z10) {
        WebSettings settings = this.f22228a.getSettings();
        if (settings.getJavaScriptEnabled()) {
            return;
        }
        settings.setJavaScriptEnabled(true);
    }
}

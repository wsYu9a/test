package com.ss.android.downloadlib.addownload.compliance;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import b.b.a.b.b;
import com.bytedance.sdk.openadsdk.R;
import com.ss.android.downloadlib.addownload.pa;
import com.ss.android.downloadlib.lg.t;
import org.apache.http.HttpHost;

/* loaded from: classes4.dex */
public class AppPrivacyPolicyActivity extends Activity {

    /* renamed from: g */
    private long f24110g;

    /* renamed from: i */
    private long f24111i;

    /* renamed from: j */
    private ImageView f24112j;
    private String q;
    private WebView zx;

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.AppPrivacyPolicyActivity$1 */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            q.j("lp_app_privacy_click_close", AppPrivacyPolicyActivity.this.f24110g);
            AppPrivacyPolicyActivity.this.finish();
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.AppPrivacyPolicyActivity$2 */
    class AnonymousClass2 extends WebViewClient {
        AnonymousClass2() {
        }

        private boolean j(Uri uri) {
            String scheme = uri.getScheme();
            return (HttpHost.DEFAULT_SCHEME_NAME.equals(scheme) || b.f4198a.equals(scheme)) ? false : true;
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (Build.VERSION.SDK_INT < 26) {
                return super.onRenderProcessGone(webView, renderProcessGoneDetail);
            }
            if (renderProcessGoneDetail.didCrash()) {
                t.j("The WebView rendering process crashed!");
                if (webView != null) {
                    ((ViewGroup) webView.getParent()).removeView(webView);
                    webView.destroy();
                }
                return true;
            }
            t.j("System killed the WebView rendering process to reclaim memory. Recreating...");
            if (webView != null) {
                ((ViewGroup) webView.getParent()).removeView(webView);
                webView.destroy();
            }
            return true;
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(21)
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return j(webResourceRequest.getUrl());
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return j(Uri.parse(str));
        }
    }

    private void zx() {
        this.f24112j = (ImageView) findViewById(R.id.iv_privacy_back);
        this.zx = (WebView) findViewById(R.id.privacy_webview);
        this.f24112j.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppPrivacyPolicyActivity.1
            AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                q.j("lp_app_privacy_click_close", AppPrivacyPolicyActivity.this.f24110g);
                AppPrivacyPolicyActivity.this.finish();
            }
        });
        WebSettings settings = this.zx.getSettings();
        settings.setDefaultFontSize(16);
        settings.setCacheMode(-1);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setSavePassword(false);
        settings.setAllowFileAccess(false);
        this.zx.setWebViewClient(new WebViewClient() { // from class: com.ss.android.downloadlib.addownload.compliance.AppPrivacyPolicyActivity.2
            AnonymousClass2() {
            }

            private boolean j(Uri uri) {
                String scheme = uri.getScheme();
                return (HttpHost.DEFAULT_SCHEME_NAME.equals(scheme) || b.f4198a.equals(scheme)) ? false : true;
            }

            @Override // android.webkit.WebViewClient
            public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
                if (Build.VERSION.SDK_INT < 26) {
                    return super.onRenderProcessGone(webView, renderProcessGoneDetail);
                }
                if (renderProcessGoneDetail.didCrash()) {
                    t.j("The WebView rendering process crashed!");
                    if (webView != null) {
                        ((ViewGroup) webView.getParent()).removeView(webView);
                        webView.destroy();
                    }
                    return true;
                }
                t.j("System killed the WebView rendering process to reclaim memory. Recreating...");
                if (webView != null) {
                    ((ViewGroup) webView.getParent()).removeView(webView);
                    webView.destroy();
                }
                return true;
            }

            @Override // android.webkit.WebViewClient
            @TargetApi(21)
            public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                return j(webResourceRequest.getUrl());
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return j(Uri.parse(str));
            }
        });
        j(this.zx);
        this.zx.setScrollBarStyle(0);
        this.zx.loadUrl(this.q);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        q.j("lp_app_privacy_click_close", this.f24110g);
        super.onBackPressed();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ttdownloader_activity_app_privacy_policy);
        if (j()) {
            zx();
        } else {
            com.ss.android.socialbase.appdownloader.i.j((Activity) this);
        }
    }

    public static void j(Activity activity, long j2) {
        Intent intent = new Intent(activity, (Class<?>) AppPrivacyPolicyActivity.class);
        intent.putExtra("app_info_id", j2);
        activity.startActivity(intent);
    }

    private boolean j() {
        this.f24111i = getIntent().getLongExtra("app_info_id", 0L);
        com.ss.android.downloadlib.addownload.zx.zx j2 = i.j().j(this.f24111i);
        if (j2 == null) {
            return false;
        }
        this.f24110g = j2.zx;
        String str = j2.k;
        this.q = str;
        if (!TextUtils.isEmpty(str)) {
            return true;
        }
        this.q = pa.k().optString("ad_privacy_backup_url", "https://sf6-ttcdn-tos.pstatp.com/obj/ad-tetris-site/personal-privacy-page.html");
        return true;
    }

    private void j(WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable unused) {
        }
    }
}

package com.opos.cmn.biz.web.b.b.b;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.http.SslError;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.cmn.biz.web.a.b.c;
import java.util.Map;
import org.apache.http.HttpHost;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    private Context f16876a;

    /* renamed from: b */
    private Map<String, Object> f16877b;

    /* renamed from: c */
    private boolean f16878c;

    /* renamed from: d */
    private WebView f16879d;

    /* renamed from: e */
    private RelativeLayout f16880e;

    /* renamed from: f */
    private RelativeLayout f16881f;

    /* renamed from: j */
    private String f16885j;
    private com.opos.cmn.biz.web.b.a.a.b l;
    private com.opos.cmn.biz.web.b.a.a.a m;

    /* renamed from: g */
    private RelativeLayout f16882g = null;

    /* renamed from: h */
    private TextView f16883h = null;

    /* renamed from: i */
    private ProgressBar f16884i = null;
    private boolean k = false;

    /* renamed from: com.opos.cmn.biz.web.b.b.b.b$1 */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar = b.this;
            bVar.a(bVar.f16885j);
        }
    }

    /* renamed from: com.opos.cmn.biz.web.b.b.b.b$2 */
    class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.r();
        }
    }

    /* renamed from: com.opos.cmn.biz.web.b.b.b.b$3 */
    class AnonymousClass3 extends WebChromeClient {
        AnonymousClass3() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            com.opos.cmn.an.f.a.b("WebWidgetImpl", "consoleMessage:line=" + consoleMessage.lineNumber() + "sourseId=" + consoleMessage.sourceId() + "message=" + consoleMessage.message());
            return super.onConsoleMessage(consoleMessage);
        }

        @Override // android.webkit.WebChromeClient
        public void onExceededDatabaseQuota(String str, String str2, long j2, long j3, long j4, WebStorage.QuotaUpdater quotaUpdater) {
            com.opos.cmn.an.f.a.b("WebWidgetImpl", "onExceededDatabaseQuota=url:" + str);
            quotaUpdater.updateQuota(j3 * 2);
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i2) {
            super.onProgressChanged(webView, i2);
            com.opos.cmn.an.f.a.b("WebWidgetImpl", "onProgressChanged:newProgress=" + i2);
            b.this.f16884i.setProgress(i2);
            if (i2 < 100 || b.this.f16884i == null) {
                return;
            }
            b.this.f16884i.setVisibility(8);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            com.opos.cmn.an.f.a.b("WebWidgetImpl", "onReceivedTitle=title:" + str);
            super.onReceivedTitle(webView, str);
        }
    }

    /* renamed from: com.opos.cmn.biz.web.b.b.b.b$4 */
    class AnonymousClass4 extends WebViewClient {
        AnonymousClass4() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            StringBuilder sb = new StringBuilder();
            sb.append("onPageFinished:url=");
            if (str == null) {
                str = "null";
            }
            sb.append(str);
            com.opos.cmn.an.f.a.b("WebWidgetImpl", sb.toString());
            if (b.this.k) {
                return;
            }
            b.this.p();
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            StringBuilder sb = new StringBuilder();
            sb.append("onPageStarted:url=");
            if (str == null) {
                str = "null";
            }
            sb.append(str);
            com.opos.cmn.an.f.a.b("WebWidgetImpl", sb.toString());
            b.this.k = false;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            StringBuilder sb = new StringBuilder();
            sb.append("onReceivedError:errorCode=");
            sb.append(i2);
            sb.append(",description=");
            if (str == null) {
                str = "null";
            }
            sb.append(str);
            sb.append(",failingUrl=");
            if (str2 == null) {
                str2 = "null";
            }
            sb.append(str2);
            com.opos.cmn.an.f.a.c("WebWidgetImpl", sb.toString());
            b.this.k = true;
            b.this.q();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            StringBuilder sb = new StringBuilder();
            sb.append("onReceivedSslError:error=");
            sb.append(sslError != null ? sslError.toString() : "null");
            com.opos.cmn.an.f.a.c("WebWidgetImpl", sb.toString());
            b.this.a(sslErrorHandler, sslError);
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (Build.VERSION.SDK_INT < 26) {
                return super.onRenderProcessGone(webView, renderProcessGoneDetail);
            }
            com.opos.cmn.an.f.a.d("WebWidgetImpl", "onRenderProcessGone WebView rendering process killed to reclaim memory. Recreating...");
            b.this.c();
            return true;
        }

        @Override // android.webkit.WebViewClient
        public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
            StringBuilder sb = new StringBuilder();
            sb.append("onUnhandledKeyEvent:event=");
            sb.append(keyEvent != null ? keyEvent.toString() : "null");
            com.opos.cmn.an.f.a.c("WebWidgetImpl", sb.toString());
            super.onUnhandledKeyEvent(webView, keyEvent);
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            com.opos.cmn.an.f.a.b("WebWidgetImpl", "shouldInterceptRequest : " + str);
            WebResourceResponse a2 = c.a().a(str);
            return a2 != null ? a2 : super.shouldInterceptRequest(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("shouldOverrideUrlLoading:url=");
            sb.append(str != null ? str : "null");
            com.opos.cmn.an.f.a.b("WebWidgetImpl", sb.toString());
            if (com.opos.cmn.an.c.a.a(str) || str.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            b.this.b(str);
            return true;
        }
    }

    /* renamed from: com.opos.cmn.biz.web.b.b.b.b$5 */
    class AnonymousClass5 implements DialogInterface.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ SslErrorHandler f16890a;

        AnonymousClass5(SslErrorHandler sslErrorHandler) {
            sslErrorHandler = sslErrorHandler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            sslErrorHandler.proceed();
        }
    }

    /* renamed from: com.opos.cmn.biz.web.b.b.b.b$6 */
    class AnonymousClass6 implements DialogInterface.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ SslErrorHandler f16892a;

        AnonymousClass6(SslErrorHandler sslErrorHandler) {
            sslErrorHandler = sslErrorHandler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            sslErrorHandler.cancel();
            b.this.r();
        }
    }

    public b(Context context, com.opos.cmn.biz.web.b.a.b bVar) {
        this.f16876a = context;
        this.f16877b = bVar.f16866b;
        this.l = bVar.f16865a;
        this.m = bVar.f16868d;
        this.f16878c = bVar.f16867c;
        f();
        k();
    }

    public void a(SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslErrorHandler != null) {
            try {
                com.opos.cmn.biz.web.b.a.a.a aVar = this.m;
                if (aVar != null) {
                    aVar.a(sslErrorHandler, sslError);
                } else if (this.f16876a instanceof Activity) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this.f16876a);
                    builder.setMessage("SSL证书验证错误，是否继续？");
                    builder.setPositiveButton("继续", new DialogInterface.OnClickListener() { // from class: com.opos.cmn.biz.web.b.b.b.b.5

                        /* renamed from: a */
                        final /* synthetic */ SslErrorHandler f16890a;

                        AnonymousClass5(SslErrorHandler sslErrorHandler2) {
                            sslErrorHandler = sslErrorHandler2;
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            sslErrorHandler.proceed();
                        }
                    });
                    builder.setNegativeButton("取消", new DialogInterface.OnClickListener() { // from class: com.opos.cmn.biz.web.b.b.b.b.6

                        /* renamed from: a */
                        final /* synthetic */ SslErrorHandler f16892a;

                        AnonymousClass6(SslErrorHandler sslErrorHandler2) {
                            sslErrorHandler = sslErrorHandler2;
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            sslErrorHandler.cancel();
                            b.this.r();
                        }
                    });
                    AlertDialog create = builder.create();
                    create.setCancelable(false);
                    create.setCanceledOnTouchOutside(false);
                    create.show();
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("WebWidgetImpl", "", e2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean b(java.lang.String r6) {
        /*
            r5 = this;
            boolean r0 = com.opos.cmn.an.c.a.a(r6)
            java.lang.String r1 = "WebWidgetImpl"
            if (r0 != 0) goto L3f
            android.content.Intent r0 = new android.content.Intent     // Catch: java.lang.Exception -> L39
            java.lang.String r2 = "android.intent.action.VIEW"
            android.net.Uri r3 = android.net.Uri.parse(r6)     // Catch: java.lang.Exception -> L39
            r0.<init>(r2, r3)     // Catch: java.lang.Exception -> L39
            java.lang.String r2 = "android.intent.category.BROWSABLE"
            r0.addCategory(r2)     // Catch: java.lang.Exception -> L39
            r2 = 0
            r0.setComponent(r2)     // Catch: java.lang.Exception -> L39
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L39
            r4 = 15
            if (r3 < r4) goto L25
            r0.setSelector(r2)     // Catch: java.lang.Exception -> L39
        L25:
            r2 = 268435456(0x10000000, float:2.524355E-29)
            r0.addFlags(r2)     // Catch: java.lang.Exception -> L39
            android.content.Context r2 = r5.f16876a     // Catch: java.lang.Exception -> L39
            boolean r2 = com.opos.cmn.an.h.d.a.a(r2, r0)     // Catch: java.lang.Exception -> L39
            if (r2 == 0) goto L3f
            android.content.Context r2 = r5.f16876a     // Catch: java.lang.Exception -> L39
            r2.startActivity(r0)     // Catch: java.lang.Exception -> L39
            r0 = 1
            goto L40
        L39:
            r0 = move-exception
            java.lang.String r2 = ""
            com.opos.cmn.an.f.a.c(r1, r2, r0)
        L3f:
            r0 = 0
        L40:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "checkLaunchApp url="
            r2.append(r3)
            if (r6 == 0) goto L4d
            goto L4f
        L4d:
            java.lang.String r6 = "null"
        L4f:
            r2.append(r6)
            java.lang.String r6 = "result="
            r2.append(r6)
            r2.append(r0)
            java.lang.String r6 = r2.toString()
            com.opos.cmn.an.f.a.b(r1, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.biz.web.b.b.b.b.b(java.lang.String):boolean");
    }

    private void f() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f16876a);
        this.f16880e = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f16880e.setFitsSystemWindows(true);
        View g2 = g();
        this.f16880e.addView(g2);
        if (!this.f16878c) {
            g2.setVisibility(8);
        }
        h();
        i();
        j();
    }

    private View g() {
        LinearLayout linearLayout = new LinearLayout(this.f16876a);
        linearLayout.setId(1);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.f16876a, 43.33f)));
        if (com.opos.cmn.biz.web.b.b.a.a.b(this.f16876a)) {
            linearLayout.setBackgroundColor(Color.parseColor("#F5EEEEEE"));
        } else {
            com.opos.cmn.biz.web.b.b.a.a.a(linearLayout, com.opos.cmn.an.d.a.a.c(this.f16876a, "o_cmn_biz_ui_web_title_bar_bg.9.png"));
        }
        this.f16883h = new TextView(this.f16876a);
        Drawable c2 = com.opos.cmn.an.d.a.a.c(this.f16876a, "o_cmn_biz_ui_web_close_bn.png");
        c2.setBounds(0, 0, com.opos.cmn.an.h.f.a.a(this.f16876a, 26.0f), com.opos.cmn.an.h.f.a.a(this.f16876a, 24.0f));
        this.f16883h.setCompoundDrawables(c2, null, null, null);
        this.f16883h.setGravity(17);
        this.f16883h.setTextSize(2, 15.0f);
        this.f16883h.setTextColor(Color.parseColor("#2ac795"));
        this.f16883h.setCompoundDrawablePadding(com.opos.cmn.an.h.f.a.a(this.f16876a, 2.0f));
        this.f16883h.setText("返回");
        linearLayout.addView(this.f16883h, new LinearLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.f16876a, 43.33f)));
        return linearLayout;
    }

    private void h() {
        this.f16881f = new RelativeLayout(this.f16876a);
        WebView webView = new WebView(this.f16876a);
        this.f16879d = webView;
        this.f16881f.addView(webView, new RelativeLayout.LayoutParams(-1, -1));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(3, 1);
        this.f16880e.addView(this.f16881f, layoutParams);
    }

    private void i() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f16876a);
        this.f16882g = relativeLayout;
        relativeLayout.setVisibility(8);
        this.f16882g.setGravity(17);
        ImageView imageView = new ImageView(this.f16876a);
        imageView.setId(2);
        imageView.setImageDrawable(com.opos.cmn.an.d.a.a.c(this.f16876a, "o_cmn_biz_ui_web_err_tag_img.png"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f16876a, 39.33f), com.opos.cmn.an.h.f.a.a(this.f16876a, 40.0f));
        layoutParams.addRule(14, -1);
        this.f16882g.addView(imageView, layoutParams);
        TextView textView = new TextView(this.f16876a);
        textView.setId(3);
        textView.setText("网络繁忙，请刷新");
        textView.setTextSize(2, 14.0f);
        textView.setTextColor(Color.parseColor("#ababab"));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(14, -1);
        layoutParams2.addRule(3, 2);
        layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(this.f16876a, 15.0f);
        this.f16882g.addView(textView, layoutParams2);
        a aVar = new a(this.f16876a, "o_cmn_biz_ui_web_err_refresh_normal_img.png", "o_cmn_biz_ui_web_err_refresh_press_img.png");
        aVar.setGravity(17);
        aVar.setText("刷新");
        aVar.setTextSize(2, 12.0f);
        aVar.setTextColor(Color.parseColor("#36ae9e"));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f16876a, 52.67f), com.opos.cmn.an.h.f.a.a(this.f16876a, 23.33f));
        layoutParams3.addRule(14, -1);
        layoutParams3.addRule(3, 3);
        layoutParams3.topMargin = com.opos.cmn.an.h.f.a.a(this.f16876a, 37.67f);
        aVar.setOnClickListener(new View.OnClickListener() { // from class: com.opos.cmn.biz.web.b.b.b.b.1
            AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b bVar = b.this;
                bVar.a(bVar.f16885j);
            }
        });
        this.f16882g.addView(aVar, layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams4.addRule(3, 1);
        this.f16880e.addView(this.f16882g, layoutParams4);
    }

    private void j() {
        ProgressBar progressBar = new ProgressBar(this.f16876a);
        this.f16884i = progressBar;
        com.opos.cmn.biz.web.b.b.a.a.a(progressBar, "mOnlyIndeterminate", new Boolean(false));
        this.f16884i.setIndeterminate(false);
        this.f16884i.setProgressDrawable(new ClipDrawable(new ColorDrawable(Color.parseColor("#33cc9c")), 3, 1));
        this.f16884i.setBackgroundColor(Color.parseColor("#cfcfcf"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.f16876a, 1.33f));
        layoutParams.addRule(3, 1);
        this.f16880e.addView(this.f16884i, layoutParams);
    }

    private void k() {
        this.f16883h.setOnClickListener(new View.OnClickListener() { // from class: com.opos.cmn.biz.web.b.b.b.b.2
            AnonymousClass2() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.r();
            }
        });
        m();
        n();
        o();
        l();
        this.f16879d.requestFocusFromTouch();
        this.f16879d.requestFocus();
    }

    private void l() {
        Map<String, Object> map = this.f16877b;
        if (map == null || map.size() <= 0) {
            return;
        }
        try {
            for (Map.Entry<String, Object> entry : this.f16877b.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (!com.opos.cmn.an.c.a.a(key) && value != null) {
                    com.opos.cmn.an.f.a.b("WebWidgetImpl", "addJavascriptInterface jsName=" + key + ",object=" + value);
                    this.f16879d.addJavascriptInterface(value, key);
                }
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("WebWidgetImpl", "", e2);
        }
    }

    private void m() {
        WebSettings settings = this.f16879d.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setDatabasePath(this.f16876a.getApplicationContext().getDir("database", 0).getPath());
        settings.setCacheMode(-1);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setUseWideViewPort(true);
        settings.setSavePassword(false);
        settings.setAllowFileAccess(false);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 16) {
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
        }
        if (i2 >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(this.f16879d, true);
            settings.setMixedContentMode(0);
        }
        settings.setAllowContentAccess(false);
    }

    private void n() {
        this.f16879d.setWebChromeClient(new WebChromeClient() { // from class: com.opos.cmn.biz.web.b.b.b.b.3
            AnonymousClass3() {
            }

            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                com.opos.cmn.an.f.a.b("WebWidgetImpl", "consoleMessage:line=" + consoleMessage.lineNumber() + "sourseId=" + consoleMessage.sourceId() + "message=" + consoleMessage.message());
                return super.onConsoleMessage(consoleMessage);
            }

            @Override // android.webkit.WebChromeClient
            public void onExceededDatabaseQuota(String str, String str2, long j2, long j3, long j4, WebStorage.QuotaUpdater quotaUpdater) {
                com.opos.cmn.an.f.a.b("WebWidgetImpl", "onExceededDatabaseQuota=url:" + str);
                quotaUpdater.updateQuota(j3 * 2);
            }

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i2) {
                super.onProgressChanged(webView, i2);
                com.opos.cmn.an.f.a.b("WebWidgetImpl", "onProgressChanged:newProgress=" + i2);
                b.this.f16884i.setProgress(i2);
                if (i2 < 100 || b.this.f16884i == null) {
                    return;
                }
                b.this.f16884i.setVisibility(8);
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView webView, String str) {
                com.opos.cmn.an.f.a.b("WebWidgetImpl", "onReceivedTitle=title:" + str);
                super.onReceivedTitle(webView, str);
            }
        });
    }

    private void o() {
        this.f16879d.setWebViewClient(new WebViewClient() { // from class: com.opos.cmn.biz.web.b.b.b.b.4
            AnonymousClass4() {
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                StringBuilder sb = new StringBuilder();
                sb.append("onPageFinished:url=");
                if (str == null) {
                    str = "null";
                }
                sb.append(str);
                com.opos.cmn.an.f.a.b("WebWidgetImpl", sb.toString());
                if (b.this.k) {
                    return;
                }
                b.this.p();
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                StringBuilder sb = new StringBuilder();
                sb.append("onPageStarted:url=");
                if (str == null) {
                    str = "null";
                }
                sb.append(str);
                com.opos.cmn.an.f.a.b("WebWidgetImpl", sb.toString());
                b.this.k = false;
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i2, String str, String str2) {
                StringBuilder sb = new StringBuilder();
                sb.append("onReceivedError:errorCode=");
                sb.append(i2);
                sb.append(",description=");
                if (str == null) {
                    str = "null";
                }
                sb.append(str);
                sb.append(",failingUrl=");
                if (str2 == null) {
                    str2 = "null";
                }
                sb.append(str2);
                com.opos.cmn.an.f.a.c("WebWidgetImpl", sb.toString());
                b.this.k = true;
                b.this.q();
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                StringBuilder sb = new StringBuilder();
                sb.append("onReceivedSslError:error=");
                sb.append(sslError != null ? sslError.toString() : "null");
                com.opos.cmn.an.f.a.c("WebWidgetImpl", sb.toString());
                b.this.a(sslErrorHandler, sslError);
            }

            @Override // android.webkit.WebViewClient
            public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
                if (Build.VERSION.SDK_INT < 26) {
                    return super.onRenderProcessGone(webView, renderProcessGoneDetail);
                }
                com.opos.cmn.an.f.a.d("WebWidgetImpl", "onRenderProcessGone WebView rendering process killed to reclaim memory. Recreating...");
                b.this.c();
                return true;
            }

            @Override // android.webkit.WebViewClient
            public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
                StringBuilder sb = new StringBuilder();
                sb.append("onUnhandledKeyEvent:event=");
                sb.append(keyEvent != null ? keyEvent.toString() : "null");
                com.opos.cmn.an.f.a.c("WebWidgetImpl", sb.toString());
                super.onUnhandledKeyEvent(webView, keyEvent);
            }

            @Override // android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                com.opos.cmn.an.f.a.b("WebWidgetImpl", "shouldInterceptRequest : " + str);
                WebResourceResponse a2 = c.a().a(str);
                return a2 != null ? a2 : super.shouldInterceptRequest(webView, str);
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                StringBuilder sb = new StringBuilder();
                sb.append("shouldOverrideUrlLoading:url=");
                sb.append(str != null ? str : "null");
                com.opos.cmn.an.f.a.b("WebWidgetImpl", sb.toString());
                if (com.opos.cmn.an.c.a.a(str) || str.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    return super.shouldOverrideUrlLoading(webView, str);
                }
                b.this.b(str);
                return true;
            }
        });
    }

    public void p() {
        this.f16881f.setVisibility(0);
        this.f16882g.setVisibility(8);
    }

    public void q() {
        this.f16881f.setVisibility(8);
        this.f16882g.setVisibility(0);
    }

    public void r() {
        com.opos.cmn.biz.web.b.a.a.b bVar = this.l;
        if (bVar != null) {
            bVar.c();
        }
    }

    private void s() {
        if (this.f16879d != null) {
            com.opos.cmn.an.f.a.b("WebWidgetImpl", "closeWebView");
            this.f16879d.removeAllViews();
            this.f16881f.removeView(this.f16879d);
            this.f16879d.stopLoading();
            this.f16879d.getSettings().setJavaScriptEnabled(false);
            this.f16879d.clearHistory();
            this.f16879d.clearCache(true);
            this.f16879d.destroyDrawingCache();
            this.f16879d.destroy();
            this.f16879d = null;
        }
    }

    public View a() {
        return this.f16880e;
    }

    public void a(String str) {
        if (this.f16879d == null || com.opos.cmn.an.c.a.a(str)) {
            return;
        }
        this.f16879d.loadUrl(str);
        this.f16885j = str;
    }

    public boolean b() {
        RelativeLayout relativeLayout = this.f16882g;
        return relativeLayout != null && relativeLayout.getVisibility() == 0;
    }

    public void c() {
        if (this.f16879d != null) {
            com.opos.cmn.an.f.a.b("WebWidgetImpl", "closeWebView");
            s();
            RelativeLayout relativeLayout = this.f16880e;
            if (relativeLayout != null) {
                relativeLayout.removeAllViews();
                this.f16880e = null;
            }
            this.f16876a = null;
        }
    }

    public void d() {
        com.opos.cmn.an.f.a.b("WebWidgetImpl", "reInitWebView");
        s();
        h();
        k();
    }

    public boolean e() {
        WebView webView = this.f16879d;
        if (webView == null || !webView.canGoBack()) {
            return false;
        }
        this.f16879d.goBack();
        return true;
    }
}

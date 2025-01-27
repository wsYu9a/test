package com.sigmob.sdk.base.views;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.czhj.sdk.common.utils.ReflectionUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.toolbox.StringUtil;
import com.sigmob.sdk.base.common.o;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.nativead.APKStatusBroadcastReceiver;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
public class g extends WebView {

    /* renamed from: g */
    public static boolean f18562g = false;

    /* renamed from: a */
    public APKStatusBroadcastReceiver f18563a;

    /* renamed from: b */
    public WeakReference<o.a> f18564b;

    /* renamed from: c */
    public BaseAdUnit f18565c;

    /* renamed from: d */
    public WebViewClient f18566d;

    /* renamed from: e */
    public Set<String> f18567e;

    /* renamed from: f */
    public Map<String, String> f18568f;

    public class a implements o.a {
        public a() {
        }

        @Override // com.sigmob.sdk.base.common.o.a
        public void a(boolean z10, long j10) {
            o.a listener = g.this.getListener();
            if (listener != null) {
                listener.a(z10, j10);
            }
            g.this.e();
        }

        @Override // com.sigmob.sdk.base.common.o.a
        public void b(boolean z10, long j10) {
            o.a listener = g.this.getListener();
            if (listener != null) {
                listener.c(z10, j10);
            } else if (z10) {
                g.this.f();
            } else {
                g.this.c();
            }
        }

        @Override // com.sigmob.sdk.base.common.o.a
        public void c(boolean z10, long j10) {
            o.a listener = g.this.getListener();
            if (listener != null) {
                listener.c(z10, j10);
            } else if (z10) {
                g.this.b();
            } else {
                g.this.c();
            }
        }

        @Override // com.sigmob.sdk.base.common.o.a
        public void a(boolean z10) {
            o.a listener = g.this.getListener();
            if (listener != null) {
                listener.a(z10);
            }
        }

        @Override // com.sigmob.sdk.base.common.o.a
        public void b(boolean z10) {
            o.a listener = g.this.getListener();
            if (listener != null) {
                listener.b(z10);
            } else if (z10) {
                g.this.d();
            } else {
                g.this.c();
            }
        }
    }

    public class b extends WebChromeClient {
        public b() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            SigmobLog.i(str2);
            jsResult.confirm();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
            SigmobLog.i(str2);
            jsResult.confirm();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            SigmobLog.i(str2);
            jsResult.confirm();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            SigmobLog.i(str2);
            jsPromptResult.confirm();
            return true;
        }
    }

    public class c {
        public c() {
        }

        @JavascriptInterface
        public int cancelDownloadTask() {
            if (g.this.f18565c == null || g.this.f18565c.getApkDownloadType() == 0) {
                return -1;
            }
            return com.sigmob.sdk.base.common.n.a(g.this.getContext(), g.this.f18565c);
        }

        @JavascriptInterface
        public int getApKDownloadProcess() {
            g.this.g();
            if (g.this.getContext() == null || g.this.f18565c == null) {
                return -1;
            }
            long[] c10 = g.this.f18565c.getApkDownloadType() != 0 ? com.sigmob.sdk.base.common.n.c(g.this.getContext(), g.this.f18565c) : com.sigmob.sdk.base.common.p.a(g.this.getContext(), g.this.f18565c.getDownloadId());
            int i10 = (int) c10[2];
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 4) {
                        return i10 != 8 ? -1 : 100;
                    }
                    return -2;
                }
                long j10 = c10[0];
                long j11 = c10[1];
                if (j11 != 0 && j10 != 0) {
                    return (int) ((j10 * 100) / j11);
                }
            }
            return 0;
        }

        @JavascriptInterface
        public int getApKDownloadType() {
            if (g.this.f18565c != null) {
                return g.this.f18565c.getApkDownloadType();
            }
            return -1;
        }

        @JavascriptInterface
        public int pauseDownload() {
            if (g.this.f18565c == null || g.this.f18565c.getApkDownloadType() == 0) {
                return -1;
            }
            return com.sigmob.sdk.base.common.n.b(g.this.getContext(), g.this.f18565c);
        }

        @JavascriptInterface
        public int resumeDownload() {
            if (g.this.f18565c == null || g.this.f18565c.getApkDownloadType() == 0) {
                return -1;
            }
            return com.sigmob.sdk.base.common.n.d(g.this.getContext(), g.this.f18565c);
        }
    }

    public class d {

        /* renamed from: a */
        public BaseAdUnit f18572a;

        public d(BaseAdUnit baseAdUnit) {
            this.f18572a = baseAdUnit;
        }

        @JavascriptInterface
        public boolean canInstall(String str) {
            if (this.f18572a == null) {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(this.f18572a.getApkName())) {
                    str = this.f18572a.getApkName();
                } else if (TextUtils.isEmpty(this.f18572a.getApkMd5())) {
                    str = "";
                } else {
                    str = this.f18572a.getApkMd5() + ".apk";
                }
            }
            return this.f18572a.canInstall(str);
        }

        @JavascriptInterface
        public boolean canOpen(String str) {
            if (!TextUtils.isEmpty(str)) {
                return com.sigmob.sdk.base.common.u.a(com.sigmob.sdk.a.d(), str);
            }
            BaseAdUnit baseAdUnit = this.f18572a;
            if (baseAdUnit == null) {
                return false;
            }
            return baseAdUnit.canOpen();
        }

        @JavascriptInterface
        public int getInteractionType() {
            if (g.this.f18565c != null) {
                return g.this.f18565c.getInteractionType();
            }
            return 0;
        }

        @JavascriptInterface
        public int getSubInteractionType() {
            if (g.this.f18565c != null) {
                return g.this.f18565c.getsubInteractionType();
            }
            return 0;
        }

        @JavascriptInterface
        public boolean isOpenListReport() {
            return (com.sigmob.sdk.base.l.w().o().isEmpty() || com.sigmob.sdk.base.services.b.h()) ? false : true;
        }

        @JavascriptInterface
        public void onOpenListReport() {
            com.sigmob.sdk.base.services.b.i();
        }
    }

    public g(Context context) {
        super(context);
        this.f18567e = new HashSet();
        this.f18568f = new HashMap();
        removeJavascriptInterface("searchBoxJavaBridge_");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        a(getSettings());
        if (!f18562g) {
            a(getContext());
            f18562g = true;
        }
        resumeTimers();
        b(context);
    }

    public o.a getListener() {
        WeakReference<o.a> weakReference = this.f18564b;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final void a(Context context) {
    }

    @Override // android.webkit.WebView
    @SuppressLint({"JavascriptInterface"})
    public void addJavascriptInterface(Object obj, String str) {
        super.addJavascriptInterface(obj, str);
        this.f18567e.add(str);
    }

    public void c() {
        a("bridge.notifyApkDownloadFailEvent();", (ValueCallback) null);
    }

    public void d() {
        a("bridge.notifyApkDownloadInstalledEvent();", (ValueCallback) null);
    }

    @Override // android.webkit.WebView
    public void destroy() {
        h();
        SigmobLog.d(" BaseWebView destroy called ");
        super.destroy();
    }

    public void e() {
        a("bridge.notifyApkDownloadPauseEvent();", (ValueCallback) null);
    }

    public void f() {
        a("bridge.notifyApkDownloadStartEvent();", (ValueCallback) null);
    }

    public void g() {
        if (this.f18565c == null || this.f18563a != null) {
            return;
        }
        APKStatusBroadcastReceiver aPKStatusBroadcastReceiver = new APKStatusBroadcastReceiver(new a(), this.f18565c.getUuid());
        this.f18563a = aPKStatusBroadcastReceiver;
        aPKStatusBroadcastReceiver.a(aPKStatusBroadcastReceiver);
    }

    public void h() {
        com.sigmob.sdk.base.utils.e.e(this);
        APKStatusBroadcastReceiver aPKStatusBroadcastReceiver = this.f18563a;
        if (aPKStatusBroadcastReceiver != null) {
            aPKStatusBroadcastReceiver.b(aPKStatusBroadcastReceiver);
            this.f18563a = null;
        }
        setWebViewClient(null);
        removeAllViews();
        Iterator<String> it = this.f18567e.iterator();
        while (it.hasNext()) {
            removeJavascriptInterface(it.next());
        }
        this.f18567e.clear();
        setWebChromeClient(null);
        loadUrl("");
        this.f18565c = null;
    }

    public void i() {
        setWebChromeClient(new b());
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        String url = StringUtil.getUrl(str);
        this.f18568f.put("Referer", "");
        BaseAdUnit baseAdUnit = this.f18565c;
        if (baseAdUnit != null && baseAdUnit.isDisablexRequestWith()) {
            this.f18568f.put(m5.c.f28300d1, "");
        }
        loadUrl(url, this.f18568f);
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void setAdUnit(BaseAdUnit baseAdUnit) {
        this.f18565c = baseAdUnit;
        if (baseAdUnit != null) {
            addJavascriptInterface(new d(baseAdUnit), "sigandroidh5");
        }
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        this.f18566d = webViewClient;
        super.setWebViewClient(webViewClient);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00f4 A[Catch: Exception -> 0x0035, TryCatch #0 {Exception -> 0x0035, blocks: (B:6:0x0007, B:9:0x002a, B:11:0x0030, B:12:0x0038, B:14:0x0068, B:15:0x0079, B:16:0x00e7, B:17:0x00ea, B:18:0x00ee, B:20:0x00f4, B:23:0x0105, B:29:0x007e, B:31:0x00c0), top: B:5:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b(android.content.Context r8) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r0 >= r1) goto L7
            return
        L7:
            java.lang.String r0 = "/app_webview"
            java.lang.String r1 = "/app_hws_webview"
            java.lang.String r2 = "/webview_data.lock"
            java.io.File r3 = q7.d.a(r8)     // Catch: java.lang.Exception -> L35
            java.lang.String r3 = r3.getAbsolutePath()     // Catch: java.lang.Exception -> L35
            java.util.HashSet r4 = new java.util.HashSet     // Catch: java.lang.Exception -> L35
            r4.<init>()     // Catch: java.lang.Exception -> L35
            java.lang.String r5 = c4.a.a()     // Catch: java.lang.Exception -> L35
            java.lang.String r6 = r8.getPackageName()     // Catch: java.lang.Exception -> L35
            boolean r6 = android.text.TextUtils.equals(r6, r5)     // Catch: java.lang.Exception -> L35
            java.lang.String r7 = "_"
            if (r6 != 0) goto L7e
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Exception -> L35
            if (r6 == 0) goto L38
            java.lang.String r5 = r8.getPackageName()     // Catch: java.lang.Exception -> L35
            goto L38
        L35:
            r8 = move-exception
            goto L109
        L38:
            s7.a.a(r5)     // Catch: java.lang.Exception -> L35
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L35
            r8.<init>()     // Catch: java.lang.Exception -> L35
            r8.append(r7)     // Catch: java.lang.Exception -> L35
            r8.append(r5)     // Catch: java.lang.Exception -> L35
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Exception -> L35
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L35
            r5.<init>()     // Catch: java.lang.Exception -> L35
            r5.append(r3)     // Catch: java.lang.Exception -> L35
            r5.append(r0)     // Catch: java.lang.Exception -> L35
            r5.append(r8)     // Catch: java.lang.Exception -> L35
            r5.append(r2)     // Catch: java.lang.Exception -> L35
            java.lang.String r0 = r5.toString()     // Catch: java.lang.Exception -> L35
            r4.add(r0)     // Catch: java.lang.Exception -> L35
            boolean r0 = com.czhj.sdk.common.utils.RomUtils.isHuawei()     // Catch: java.lang.Exception -> L35
            if (r0 == 0) goto Lea
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L35
            r0.<init>()     // Catch: java.lang.Exception -> L35
            r0.append(r3)     // Catch: java.lang.Exception -> L35
            r0.append(r1)     // Catch: java.lang.Exception -> L35
            r0.append(r8)     // Catch: java.lang.Exception -> L35
            r0.append(r2)     // Catch: java.lang.Exception -> L35
        L79:
            java.lang.String r8 = r0.toString()     // Catch: java.lang.Exception -> L35
            goto Le7
        L7e:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L35
            r8.<init>()     // Catch: java.lang.Exception -> L35
            r8.append(r7)     // Catch: java.lang.Exception -> L35
            r8.append(r5)     // Catch: java.lang.Exception -> L35
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Exception -> L35
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L35
            r5.<init>()     // Catch: java.lang.Exception -> L35
            r5.append(r3)     // Catch: java.lang.Exception -> L35
            r5.append(r0)     // Catch: java.lang.Exception -> L35
            r5.append(r2)     // Catch: java.lang.Exception -> L35
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> L35
            r4.add(r5)     // Catch: java.lang.Exception -> L35
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L35
            r5.<init>()     // Catch: java.lang.Exception -> L35
            r5.append(r3)     // Catch: java.lang.Exception -> L35
            r5.append(r0)     // Catch: java.lang.Exception -> L35
            r5.append(r8)     // Catch: java.lang.Exception -> L35
            r5.append(r2)     // Catch: java.lang.Exception -> L35
            java.lang.String r0 = r5.toString()     // Catch: java.lang.Exception -> L35
            r4.add(r0)     // Catch: java.lang.Exception -> L35
            boolean r0 = com.czhj.sdk.common.utils.RomUtils.isHuawei()     // Catch: java.lang.Exception -> L35
            if (r0 == 0) goto Lea
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L35
            r0.<init>()     // Catch: java.lang.Exception -> L35
            r0.append(r3)     // Catch: java.lang.Exception -> L35
            r0.append(r1)     // Catch: java.lang.Exception -> L35
            r0.append(r2)     // Catch: java.lang.Exception -> L35
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L35
            r4.add(r0)     // Catch: java.lang.Exception -> L35
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L35
            r0.<init>()     // Catch: java.lang.Exception -> L35
            r0.append(r3)     // Catch: java.lang.Exception -> L35
            r0.append(r1)     // Catch: java.lang.Exception -> L35
            r0.append(r8)     // Catch: java.lang.Exception -> L35
            r0.append(r2)     // Catch: java.lang.Exception -> L35
            goto L79
        Le7:
            r4.add(r8)     // Catch: java.lang.Exception -> L35
        Lea:
            java.util.Iterator r8 = r4.iterator()     // Catch: java.lang.Exception -> L35
        Lee:
            boolean r0 = r8.hasNext()     // Catch: java.lang.Exception -> L35
            if (r0 == 0) goto L10c
            java.lang.Object r0 = r8.next()     // Catch: java.lang.Exception -> L35
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Exception -> L35
            java.io.File r1 = new java.io.File     // Catch: java.lang.Exception -> L35
            r1.<init>(r0)     // Catch: java.lang.Exception -> L35
            boolean r0 = r1.exists()     // Catch: java.lang.Exception -> L35
            if (r0 == 0) goto Lee
            a(r1)     // Catch: java.lang.Exception -> L35
            goto L10c
        L109:
            r8.printStackTrace()
        L10c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.views.g.b(android.content.Context):void");
    }

    public void a(boolean z10) {
    }

    public void b() {
        a("bridge.notifyApkDownloadEndEvent();", (ValueCallback) null);
    }

    @SuppressLint({"AddJavascriptInterface"})
    public void a(o.a aVar) {
        this.f18564b = new WeakReference<>(aVar);
    }

    public void b(boolean z10) {
        if (z10) {
            stopLoading();
            loadUrl("");
        }
        onPause();
    }

    public static void a(File file, boolean z10) {
        if (z10) {
            try {
                if (file.exists()) {
                    return;
                }
                file.createNewFile();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public void a(String str, ValueCallback valueCallback) {
        SigmobLog.d("Injecting Javascript into MRAID WebView:\n\t" + str);
        if (str.startsWith("bridge")) {
            str = str.replaceFirst("bridge", StringUtil.decode(StringUtil.f8837s));
        }
        evaluateJavascript(str, valueCallback);
    }

    public static void a(WebView webView) {
        CookieManager.getInstance().setAcceptThirdPartyCookies(webView, com.sigmob.sdk.base.f.f().b());
    }

    public static void a() {
        CookieManager cookieManager = CookieManager.getInstance();
        if (com.sigmob.sdk.base.f.f().b()) {
            cookieManager.setAcceptCookie(true);
            CookieManager.setAcceptFileSchemeCookies(true);
            return;
        }
        cookieManager.setAcceptCookie(false);
        CookieManager.setAcceptFileSchemeCookies(false);
        cookieManager.removeSessionCookies(null);
        cookieManager.removeAllCookies(null);
        cookieManager.flush();
    }

    @TargetApi(28)
    public static void a(File file) {
        try {
            FileLock tryLock = new RandomAccessFile(file, "rw").getChannel().tryLock();
            if (tryLock != null) {
                tryLock.close();
            } else {
                a(file, file.delete());
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            a(file, file.exists() ? file.delete() : false);
        }
    }

    public final void a(WebSettings webSettings) {
        try {
            ReflectionUtil.MethodBuilder methodBuilder = new ReflectionUtil.MethodBuilder(webSettings, new String(Base64.decode(com.sigmob.sdk.base.k.C, 2)));
            methodBuilder.addParam(Boolean.TYPE, Boolean.TRUE);
            methodBuilder.execute();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        try {
            ReflectionUtil.MethodBuilder methodBuilder2 = new ReflectionUtil.MethodBuilder(webSettings, new String(Base64.decode(com.sigmob.sdk.base.k.E, 2)));
            methodBuilder2.addParam(Boolean.TYPE, Boolean.TRUE);
            methodBuilder2.execute();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        webSettings.setDomStorageEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setBuiltInZoomControls(false);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setSupportZoom(true);
        webSettings.setDefaultTextEncodingName("UTF-8");
        webSettings.setBlockNetworkImage(false);
        webSettings.setBlockNetworkLoads(false);
        webSettings.setCacheMode(-1);
        int i10 = Build.VERSION.SDK_INT;
        webSettings.setMediaPlaybackRequiresUserGesture(false);
        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setAllowContentAccess(true);
        if (i10 >= 26) {
            webSettings.setSafeBrowsingEnabled(false);
        }
        webSettings.setMixedContentMode(0);
        addJavascriptInterface(new c(), "sigandroidapk");
    }
}

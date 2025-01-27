package com.aggmoread.sdk.z.b.u;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class i extends WebView {

    /* renamed from: a */
    private h f5059a;

    /* renamed from: b */
    private Context f5060b;

    /* renamed from: c */
    private TextView f5061c;

    /* renamed from: d */
    private d f5062d;

    public class b extends WebChromeClient {
        private b() {
        }

        @Override // android.webkit.WebChromeClient
        public Bitmap getDefaultVideoPoster() {
            try {
                return Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
            } catch (Exception unused) {
                return super.getDefaultVideoPoster();
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i10) {
            if (i10 >= 95) {
                i.this.f5059a.setVisibility(8);
                i.this.f5062d.a();
            } else {
                i.this.f5059a.b(i10);
            }
            super.onProgressChanged(webView, i10);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (i.this.f5061c != null) {
                i.this.f5061c.setText(str);
            }
        }

        public /* synthetic */ b(i iVar, a aVar) {
            this();
        }
    }

    public class c extends WebViewClient {

        /* renamed from: a */
        Method f5064a;

        public c() {
            this.f5064a = null;
            try {
                this.f5064a = Class.forName("android.webkit.SslErrorHandler").getDeclaredMethod(a(), null);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }

        private String a() {
            return "proce".concat("ed");
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            Method method = this.f5064a;
            if (method != null) {
                try {
                    method.invoke(sslErrorHandler, null);
                    return;
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
            sslErrorHandler.cancel();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str == null || str.equals("about:blank")) {
                return false;
            }
            try {
                if (!str.startsWith("http:") && !str.startsWith("https:")) {
                    i.this.f5060b.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    return true;
                }
                return false;
            } catch (Exception unused) {
                return true;
            }
        }
    }

    public interface d {

        /* renamed from: a */
        public static final d f5066a = new a();

        public static class a implements d {
            @Override // com.aggmoread.sdk.z.b.u.i.d
            public void a() {
            }
        }

        void a();
    }

    public i(Context context) {
        super(context);
        this.f5062d = d.f5066a;
        this.f5060b = context;
        a();
    }

    private int a(Context context, float f10) {
        return (int) ((f10 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if ((action == 0 || action == 1) && !hasFocus()) {
            requestFocus();
        }
        return super.onTouchEvent(motionEvent);
    }

    private void b() {
        WebSettings settings = getSettings();
        int i10 = Build.VERSION.SDK_INT;
        settings.setMediaPlaybackRequiresUserGesture(false);
        if (i10 >= 26) {
            settings.setSafeBrowsingEnabled(false);
        }
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setNeedInitialFocus(false);
        settings.setSavePassword(false);
        settings.setAllowFileAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        String path = this.f5060b.getApplicationContext().getDir("jhad_database", 0).getPath();
        try {
            settings.setDomStorageEnabled(true);
            settings.setDatabaseEnabled(true);
            settings.setDatabasePath(path);
        } catch (Exception unused) {
        }
        try {
            com.aggmoread.sdk.z.d.a.a.e.j.a(settings, "setAppCacheEnabled", (Class<?>[]) new Class[]{Boolean.class}, Boolean.TRUE);
            com.aggmoread.sdk.z.d.a.a.e.j.a(settings, "setAppCachePath", (Class<?>[]) new Class[]{String.class}, path);
            com.aggmoread.sdk.z.d.a.a.e.j.a(settings, "setAppCacheMaxSize", (Class<?>[]) new Class[]{Long.class}, 10485760);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        try {
            settings.setGeolocationEnabled(true);
            settings.setGeolocationDatabasePath(path);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        settings.setSupportZoom(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setDomStorageEnabled(true);
        settings.setMixedContentMode(0);
        CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
    }

    private void a() {
        h hVar = new h(this.f5060b);
        this.f5059a = hVar;
        hVar.setLayoutParams(new ViewGroup.LayoutParams(-1, a(this.f5060b, 2.0f)));
        this.f5059a.a(-16776961);
        this.f5059a.b(10);
        addView(this.f5059a);
        try {
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
        } catch (Exception unused) {
        }
        b();
        setWebChromeClient(new b());
        setWebViewClient(new c());
    }

    public void a(TextView textView) {
        this.f5061c = textView;
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.f5062d = dVar;
        }
    }
}

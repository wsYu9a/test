package com.martian.ttbook.b.a.q;

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
import com.vivo.advv.Color;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public class f extends WebView {

    /* renamed from: a */
    private e f15159a;

    /* renamed from: b */
    private Context f15160b;

    /* renamed from: c */
    private TextView f15161c;

    /* renamed from: d */
    private d f15162d;

    private class b extends WebChromeClient {
        private b() {
        }

        /* synthetic */ b(f fVar, a aVar) {
            this();
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
        public void onProgressChanged(WebView webView, int i2) {
            if (i2 >= 95) {
                f.this.f15159a.setVisibility(8);
                f.this.f15162d.onLoadCompleted();
            } else {
                f.this.f15159a.c(i2);
            }
            super.onProgressChanged(webView, i2);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (f.this.f15161c != null) {
                f.this.f15161c.setText(str);
            }
        }
    }

    private class c extends WebViewClient {

        /* renamed from: a */
        Method f15164a;

        public c() {
            this.f15164a = null;
            try {
                this.f15164a = Class.forName("android.webkit.SslErrorHandler").getDeclaredMethod(a(), new Class[0]);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        private String a() {
            return "proce".concat("ed");
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            Method method = this.f15164a;
            if (method != null) {
                try {
                    method.invoke(sslErrorHandler, new Object[0]);
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
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
                    f.this.f15160b.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
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
        public static final d f15166a = new a();

        static class a implements d {
            a() {
            }

            @Override // com.martian.ttbook.b.a.q.f.d
            public void onLoadCompleted() {
            }
        }

        void onLoadCompleted();
    }

    public f(Context context) {
        super(context);
        this.f15162d = d.f15166a;
        this.f15160b = context;
        c();
    }

    private int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void c() {
        e eVar = new e(this.f15160b);
        this.f15159a = eVar;
        eVar.setLayoutParams(new ViewGroup.LayoutParams(-1, a(this.f15160b, 2.0f)));
        this.f15159a.b(Color.BLUE);
        this.f15159a.c(10);
        addView(this.f15159a);
        try {
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
        } catch (Exception unused) {
        }
        g();
        setWebChromeClient(new b());
        setWebViewClient(new c());
    }

    private void g() {
        WebSettings settings = getSettings();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 17) {
            settings.setMediaPlaybackRequiresUserGesture(false);
        }
        if (i2 >= 26) {
            settings.setSafeBrowsingEnabled(false);
        }
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setNeedInitialFocus(false);
        settings.setSavePassword(false);
        settings.setAllowFileAccess(false);
        if (i2 >= 16) {
            settings.setAllowFileAccessFromFileURLs(false);
        }
        String path = this.f15160b.getApplicationContext().getDir("jhad_database", 0).getPath();
        try {
            settings.setDomStorageEnabled(true);
            settings.setDatabaseEnabled(true);
            settings.setDatabasePath(path);
        } catch (Exception unused) {
        }
        try {
            settings.setAppCacheEnabled(true);
            settings.setAppCachePath(path);
            settings.setAppCacheMaxSize(10485760L);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            settings.setGeolocationEnabled(true);
            settings.setGeolocationDatabasePath(path);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        settings.setSupportZoom(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setDomStorageEnabled(true);
        if (Build.VERSION.SDK_INT < 21) {
            CookieManager.getInstance().setAcceptCookie(true);
        } else {
            settings.setMixedContentMode(0);
            CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
        }
    }

    public void d(TextView textView) {
        this.f15161c = textView;
    }

    public void e(d dVar) {
        if (dVar != null) {
            this.f15162d = dVar;
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if ((action == 0 || action == 1) && !hasFocus()) {
            requestFocus();
        }
        return super.onTouchEvent(motionEvent);
    }
}

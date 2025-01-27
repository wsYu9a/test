package com.alipay.sdk.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import com.alipay.sdk.exception.NetErrorException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a extends Activity {

    /* renamed from: a */
    private WebView f5286a;

    /* renamed from: b */
    private b.b.a.g.a f5287b;

    /* renamed from: d */
    private boolean f5289d;

    /* renamed from: c */
    private Handler f5288c = new Handler();

    /* renamed from: e */
    private Runnable f5290e = new f(this);

    /* renamed from: com.alipay.sdk.app.a$a */
    private class C0061a extends WebChromeClient {
        private C0061a() {
        }

        /* synthetic */ C0061a(a aVar, byte b2) {
            this();
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            String message = consoleMessage.message();
            if (TextUtils.isEmpty(message)) {
                return super.onConsoleMessage(consoleMessage);
            }
            String replaceFirst = message.startsWith("h5container.message: ") ? message.replaceFirst("h5container.message: ", "") : null;
            if (TextUtils.isEmpty(replaceFirst)) {
                return super.onConsoleMessage(consoleMessage);
            }
            a.d(a.this, replaceFirst);
            return super.onConsoleMessage(consoleMessage);
        }
    }

    class b extends WebViewClient {
        private b() {
        }

        /* synthetic */ b(a aVar, byte b2) {
            this();
        }

        @Override // android.webkit.WebViewClient
        public final void onPageFinished(WebView webView, String str) {
            a.this.q();
            a.this.f5288c.removeCallbacks(a.this.f5290e);
        }

        @Override // android.webkit.WebViewClient
        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            a.this.o();
            a.this.f5288c.postDelayed(a.this.f5290e, 30000L);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (!a.this.f5289d) {
                a.this.runOnUiThread(new p(this, sslErrorHandler));
            } else {
                sslErrorHandler.proceed();
                a.this.f5289d = false;
            }
        }

        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            String b2;
            if (TextUtils.equals(str, b.b.a.b.a.k) || TextUtils.equals(str, b.b.a.b.a.l)) {
                d.f5308a = d.a();
                a.this.finish();
                return true;
            }
            if (!str.startsWith(b.b.a.b.a.f4197j)) {
                webView.loadUrl(str);
                return true;
            }
            try {
                String substring = str.substring(str.indexOf(b.b.a.b.a.f4197j) + 24);
                int parseInt = Integer.parseInt(substring.substring(substring.lastIndexOf(b.b.a.b.a.m) + 10));
                if (parseInt == ac.SUCCEEDED.a()) {
                    String decode = URLDecoder.decode(str);
                    String substring2 = decode.substring(decode.indexOf(b.b.a.b.a.f4197j) + 24, decode.lastIndexOf(b.b.a.b.a.m));
                    ac a2 = ac.a(parseInt);
                    b2 = d.b(a2.a(), a2.b(), substring2);
                } else {
                    ac a3 = ac.a(ac.FAILED.a());
                    b2 = d.b(a3.a(), a3.b(), "");
                }
                d.f5308a = b2;
            } catch (Exception unused) {
                d.f5308a = d.d();
            }
            a.this.runOnUiThread(new s(this));
            return true;
        }
    }

    private static void a() {
        Object obj = com.alipay.sdk.util.b.f5441b;
        synchronized (obj) {
            try {
                obj.notify();
            } catch (Exception unused) {
            }
        }
    }

    static /* synthetic */ void b(a aVar) {
        aVar.o();
        try {
            b.b.a.c.e b2 = b.b.a.c.b.b(new b.b.a.c.c(), aVar.getIntent().getExtras().getString("params"), new JSONObject());
            b.b.a.c.a aVar2 = b2.f4235a;
            aVar2.f4219b = "com.alipay.mobilecashier";
            aVar2.f4222e = "com.alipay.mcpay";
            aVar2.f4221d = "4.0.3";
            aVar2.f4220c = "/cashier/main";
            try {
                JSONObject jSONObject = new b.b.a.e.d(new b.b.a.c.c()).a(aVar, b2, false).f5419c;
                aVar.q();
                aVar.g(jSONObject);
            } catch (NetErrorException unused) {
                aVar.runOnUiThread(new h(aVar));
            } catch (Exception unused2) {
                aVar.runOnUiThread(new i(aVar));
            } finally {
                aVar.q();
            }
        } catch (Exception unused3) {
            aVar.finish();
        }
    }

    static /* synthetic */ void c(a aVar, com.alipay.sdk.authjs.a aVar2) {
        if (aVar.f5286a == null || aVar2 == null) {
            return;
        }
        try {
            aVar.runOnUiThread(new e(aVar, String.format("AlipayJSBridge._invokeJS(%s)", aVar2.a())));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    static /* synthetic */ void d(a aVar, String str) {
        new com.alipay.sdk.authjs.d(aVar, new o(aVar)).f(str);
    }

    private void e(com.alipay.sdk.authjs.a aVar) {
        if (this.f5286a == null || aVar == null) {
            return;
        }
        try {
            runOnUiThread(new e(this, String.format("AlipayJSBridge._invokeJS(%s)", aVar.a())));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private void f(String str) {
        new com.alipay.sdk.authjs.d(this, new o(this)).f(str);
    }

    private void g(JSONObject jSONObject) {
        for (com.alipay.sdk.protocol.a aVar : com.alipay.sdk.protocol.a.a(com.alipay.sdk.protocol.b.d(jSONObject.optJSONObject(b.b.a.b.c.f4210c), b.b.a.b.c.f4211d))) {
            if (aVar == com.alipay.sdk.protocol.a.WapPay) {
                String str = com.alipay.sdk.util.a.a(aVar.e())[0];
                if (com.alipay.sdk.util.j.e(str)) {
                    runOnUiThread(new j(this, str));
                    return;
                } else {
                    finish();
                    return;
                }
            }
        }
    }

    private void i() {
        o();
        try {
            b.b.a.c.e b2 = b.b.a.c.b.b(new b.b.a.c.c(), getIntent().getExtras().getString("params"), new JSONObject());
            b.b.a.c.a aVar = b2.f4235a;
            aVar.f4219b = "com.alipay.mobilecashier";
            aVar.f4222e = "com.alipay.mcpay";
            aVar.f4221d = "4.0.3";
            aVar.f4220c = "/cashier/main";
            try {
                JSONObject jSONObject = new b.b.a.e.d(new b.b.a.c.c()).a(this, b2, false).f5419c;
                q();
                g(jSONObject);
            } catch (NetErrorException unused) {
                runOnUiThread(new h(this));
            } catch (Exception unused2) {
                runOnUiThread(new i(this));
            } finally {
                q();
            }
        } catch (Exception unused3) {
            finish();
        }
    }

    static /* synthetic */ void j(a aVar) {
        AlertDialog.Builder builder = new AlertDialog.Builder(aVar);
        builder.setMessage("不能连接到服务器，是否重试？");
        builder.setPositiveButton("确定", new k(aVar));
        builder.setNeutralButton("取消", new m(aVar));
        builder.create().show();
    }

    private void k() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("不能连接到服务器，是否重试？");
        builder.setPositiveButton("确定", new k(this));
        builder.setNeutralButton("取消", new m(this));
        builder.create().show();
    }

    static /* synthetic */ void l(a aVar) {
        AlertDialog.Builder builder = new AlertDialog.Builder(aVar);
        builder.setMessage("系统繁忙，请稍后再试");
        builder.setNeutralButton("确定", new n(aVar));
        builder.create().show();
    }

    private void n() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("系统繁忙，请稍后再试");
        builder.setNeutralButton("确定", new n(this));
        builder.create().show();
    }

    public void o() {
        if (this.f5287b == null) {
            this.f5287b = new b.b.a.g.a(this);
        }
        try {
            this.f5287b.f();
        } catch (Exception unused) {
            this.f5287b = null;
        }
    }

    public void q() {
        b.b.a.g.a aVar = this.f5287b;
        if (aVar != null && aVar.d()) {
            this.f5287b.g();
        }
        this.f5287b = null;
    }

    @Override // android.app.Activity
    public void finish() {
        Object obj = com.alipay.sdk.util.b.f5441b;
        synchronized (obj) {
            try {
                obj.notify();
            } catch (Exception unused) {
            }
        }
        super.finish();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent().getExtras() == null) {
            finish();
            return;
        }
        super.requestWindowFeature(1);
        b.b.a.f.a.a().c(this, b.b.a.c.d.a());
        LinearLayout linearLayout = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(1);
        setContentView(linearLayout, layoutParams);
        WebView webView = new WebView(this);
        this.f5286a = webView;
        layoutParams.weight = 1.0f;
        webView.setVisibility(0);
        linearLayout.addView(this.f5286a, layoutParams);
        WebSettings settings = this.f5286a.getSettings();
        settings.setUserAgentString(settings.getUserAgentString() + com.alipay.sdk.util.j.j(this));
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setMinimumFontSize(settings.getMinimumFontSize() + 8);
        settings.setAllowFileAccess(false);
        settings.setTextSize(WebSettings.TextSize.NORMAL);
        this.f5286a.setVerticalScrollbarOverlay(true);
        this.f5286a.setWebViewClient(new b(this, (byte) 0));
        this.f5286a.setWebChromeClient(new C0061a(this, (byte) 0));
        this.f5286a.setDownloadListener(new com.alipay.sdk.app.b(this));
        new Thread(new g(this)).start();
        if (Build.VERSION.SDK_INT >= 7) {
            try {
                Method method = this.f5286a.getSettings().getClass().getMethod("setDomStorageEnabled", Boolean.TYPE);
                if (method != null) {
                    method.invoke(this.f5286a.getSettings(), Boolean.TRUE);
                }
            } catch (Exception unused) {
            }
        }
        try {
            Method method2 = this.f5286a.getClass().getMethod("removeJavascriptInterface", new Class[0]);
            if (method2 != null) {
                method2.invoke(this.f5286a, "searchBoxJavaBridge_");
            }
        } catch (Exception unused2) {
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }
}

package com.vivo.mobilead.web;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebBackForwardList;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.vivo.ic.webview.BridgeUtils;
import com.vivo.ic.webview.CommonWebView;
import com.vivo.ic.webview.IBridge;
import com.vivo.ic.webview.WebCallBack;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class b extends WebViewClient {

    /* renamed from: i */
    public static HashMap<String, String> f30846i = new a();

    /* renamed from: j */
    public static final Pattern f30847j;

    /* renamed from: a */
    private Context f30848a;

    /* renamed from: b */
    private IBridge f30849b;

    /* renamed from: c */
    private com.vivo.mobilead.web.a f30850c;

    /* renamed from: d */
    private WebCallBack f30851d;

    /* renamed from: e */
    private boolean f30852e;

    /* renamed from: f */
    private com.vivo.mobilead.web.c f30853f;

    /* renamed from: g */
    private long f30854g;

    /* renamed from: h */
    private boolean f30855h;

    static class a extends HashMap<String, String> {
        a() {
            put("space", "com.vivo.space");
            put("vivospace", "com.vivo.space");
            put("vivomarket", "com.bbk.appstore");
            put("vivogame", "com.vivo.game");
        }
    }

    /* renamed from: com.vivo.mobilead.web.b$b */
    static class C0675b extends HashMap<Integer, String> {
        C0675b() {
            put(2, "3");
            put(4, "1");
            put(5, "4");
            put(3, "2");
        }
    }

    class c implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ Activity f30856a;

        /* renamed from: b */
        final /* synthetic */ WebView f30857b;

        /* renamed from: c */
        final /* synthetic */ SslErrorHandler f30858c;

        /* renamed from: d */
        final /* synthetic */ SslError f30859d;

        /* renamed from: e */
        final /* synthetic */ com.vivo.mobilead.web.d f30860e;

        c(Activity activity, WebView webView, SslErrorHandler sslErrorHandler, SslError sslError, com.vivo.mobilead.web.d dVar) {
            this.f30856a = activity;
            this.f30857b = webView;
            this.f30858c = sslErrorHandler;
            this.f30859d = sslError;
            this.f30860e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.a(this.f30856a, this.f30857b, this.f30858c, this.f30859d, this.f30860e);
        }
    }

    class d implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ SslErrorHandler f30862a;

        /* renamed from: b */
        final /* synthetic */ com.vivo.mobilead.web.d f30863b;

        d(b bVar, SslErrorHandler sslErrorHandler, com.vivo.mobilead.web.d dVar) {
            this.f30862a = sslErrorHandler;
            this.f30863b = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SslErrorHandler sslErrorHandler = this.f30862a;
            if (sslErrorHandler != null) {
                sslErrorHandler.proceed();
            }
            this.f30863b.a();
        }
    }

    class e implements PopupWindow.OnDismissListener {

        /* renamed from: a */
        final /* synthetic */ SslErrorHandler f30864a;

        e(b bVar, SslErrorHandler sslErrorHandler) {
            this.f30864a = sslErrorHandler;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            SslErrorHandler sslErrorHandler = this.f30864a;
            if (sslErrorHandler != null) {
                sslErrorHandler.cancel();
            }
        }
    }

    class f extends com.vivo.mobilead.web.a {
        f(b bVar) {
        }

        @Override // com.vivo.ic.webview.JsInterface
        public void login(String str, String str2) {
        }

        @Override // com.vivo.ic.webview.JsInterface
        public void share(String str, String str2) {
        }
    }

    static {
        new C0675b();
        f30847j = Pattern.compile("(?i)((?:http|https|file):\\/\\/|(?:inline|data|about|javascript):)(.*)");
    }

    public b(Context context, IBridge iBridge, CommonWebView commonWebView, boolean z, boolean z2) {
        this.f30854g = 200L;
        this.f30855h = true;
        this.f30848a = context;
        this.f30849b = iBridge;
        com.vivo.mobilead.web.a b2 = b();
        this.f30850c = b2;
        b2.a(context, commonWebView);
        this.f30850c.a(this.f30849b);
        this.f30852e = z;
    }

    protected Bitmap a(String str, String str2, Map<String, String> map) {
        return null;
    }

    final String b(String str) {
        try {
            String scheme = Uri.parse(str).getScheme();
            HashMap<String, String> c2 = c();
            if (c2.containsKey(scheme)) {
                return c2.get(scheme);
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    protected String b(String str, String str2, Map<String, String> map) {
        return "utf-8";
    }

    protected String c(String str, String str2, Map<String, String> map) {
        return "image/*";
    }

    protected HashMap<String, String> c() {
        return f30846i;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        TextView titleTextView;
        super.onPageFinished(webView, str);
        WebCallBack webCallBack = this.f30851d;
        if (webCallBack != null) {
            webCallBack.onPageFinished(str);
        }
        String title = webView.getTitle();
        if (TextUtils.isEmpty(title) || this.f30852e) {
            return;
        }
        Context context = this.f30848a;
        if (!(context instanceof VivoADSDKWebView) || (titleTextView = ((VivoADSDKWebView) context).getTitleTextView()) == null) {
            return;
        }
        if (title.length() > 13) {
            title = title.substring(0, 13);
        }
        titleTextView.setText(title);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        WebCallBack webCallBack = this.f30851d;
        if (webCallBack != null) {
            webCallBack.onPageStarted(str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i2, String str, String str2) {
        Log.d("HtmlWebViewClient", "onReceivedError, errorCode = " + i2);
        WebCallBack webCallBack = this.f30851d;
        if (webCallBack != null) {
            webCallBack.onReceiverdError(str2);
        }
        super.onReceivedError(webView, i2, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        a(webView, sslErrorHandler, sslError);
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        try {
            if (Build.VERSION.SDK_INT >= 26 && renderProcessGoneDetail != null && !renderProcessGoneDetail.didCrash()) {
                if (webView == null) {
                    return true;
                }
                ViewParent parent = webView.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(webView);
                }
                webView.destroy();
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(21)
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        Bitmap a2 = a(webResourceRequest.getUrl().toString(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders());
        return a2 != null ? new WebResourceResponse(c(webResourceRequest.getUrl().toString(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders()), b(webResourceRequest.getUrl().toString(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders()), a(a2, 100, webResourceRequest.getUrl().toString())) : super.shouldInterceptRequest(webView, webResourceRequest);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Log.d("HtmlWebViewClient", "commonWebView shouldOverrideUrlLoading " + str);
        if (this.f30849b != null && BridgeUtils.isJsBridge(str)) {
            try {
                this.f30849b.execute(URLDecoder.decode(str, "utf-8"));
                this.f30849b.fetchJsMsgQueue();
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        WebCallBack webCallBack = this.f30851d;
        if (webCallBack != null && webCallBack.shouldHandleUrl(str)) {
            return true;
        }
        WebCallBack webCallBack2 = this.f30851d;
        if (webCallBack2 != null && webCallBack2.shouldOverrideUrlLoading(webView, str)) {
            return true;
        }
        try {
            Intent parseUri = Intent.parseUri(str, 1);
            if (f30847j.matcher(str).matches()) {
                return false;
            }
            if (this.f30848a.getPackageManager().resolveActivity(parseUri, 0) == null) {
                return true;
            }
            try {
            } catch (Exception unused) {
                Log.i("HtmlWebViewClient", "cannot start activity");
            }
            if (this.f30853f != null && !this.f30855h && Math.abs(System.currentTimeMillis() - this.f30853f.getDispatchTouchTime()) > this.f30854g) {
                return false;
            }
            String b2 = b(str);
            if (parseUri != null && !TextUtils.isEmpty(b2)) {
                parseUri.setPackage(b2);
            }
            return ((Activity) this.f30848a).startActivityIfNeeded(parseUri, -1);
        } catch (Exception e3) {
            Log.e("HtmlWebViewClient", "Bad URI " + str + ": " + e3.getMessage());
            return false;
        }
    }

    public void a(WebCallBack webCallBack) {
        this.f30851d = webCallBack;
    }

    protected Bitmap.CompressFormat a(String str) {
        return Bitmap.CompressFormat.JPEG;
    }

    private void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        try {
            Context context = webView.getContext();
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && !activity.isDestroyed()) {
                    com.vivo.mobilead.web.d dVar = new com.vivo.mobilead.web.d((Activity) context);
                    dVar.a(new c(activity, webView, sslErrorHandler, sslError, dVar));
                    dVar.b(new d(this, sslErrorHandler, dVar));
                    dVar.a(new e(this, sslErrorHandler));
                    dVar.b();
                }
                return;
            }
            if (sslErrorHandler != null) {
                sslErrorHandler.cancel();
            }
        } catch (Exception unused) {
            if (sslErrorHandler != null) {
                sslErrorHandler.cancel();
            }
        }
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(11)
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        Bitmap a2 = a(str, (String) null, (Map<String, String>) null);
        if (a2 != null) {
            return new WebResourceResponse(c(str, null, null), b(str, null, null), a(a2, 100, str));
        }
        return super.shouldInterceptRequest(webView, str);
    }

    protected com.vivo.mobilead.web.a b() {
        return new f(this);
    }

    public b(Context context, IBridge iBridge, CommonWebView commonWebView, boolean z, com.vivo.mobilead.web.c cVar, long j2, boolean z2) {
        this(context, iBridge, commonWebView, z, false);
        this.f30853f = cVar;
        this.f30854g = j2;
        this.f30855h = z2;
    }

    public void a(Activity activity, WebView webView, SslErrorHandler sslErrorHandler, SslError sslError, com.vivo.mobilead.web.d dVar) {
        if (sslErrorHandler != null) {
            try {
                sslErrorHandler.cancel();
            } catch (Exception unused) {
                return;
            }
        }
        WebBackForwardList copyBackForwardList = webView.copyBackForwardList();
        if (copyBackForwardList != null) {
            if (copyBackForwardList.getSize() == 0) {
                if (dVar != null) {
                    dVar.a();
                }
                activity.finish();
                return;
            } else if (copyBackForwardList.getSize() == 1) {
                String url = copyBackForwardList.getItemAtIndex(0).getUrl();
                if (!TextUtils.isEmpty(url) && !url.equals(sslError.getUrl())) {
                    if (dVar != null) {
                        dVar.a();
                    }
                    WebView.HitTestResult hitTestResult = webView.getHitTestResult();
                    if (hitTestResult == null || !TextUtils.isEmpty(hitTestResult.getExtra())) {
                        return;
                    }
                    activity.finish();
                    return;
                }
            }
        }
        if (dVar != null) {
            dVar.a();
        }
    }

    private InputStream a(Bitmap bitmap, int i2, String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(a(str), i2, byteArrayOutputStream);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        try {
            byteArrayOutputStream.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return byteArrayInputStream;
    }

    public final Object a(String str, String str2, String str3) {
        try {
            if (TextUtils.isEmpty(str3)) {
                str3 = "";
            }
            return this.f30850c.getClass().getMethod(str, String.class, String.class).invoke(this.f30850c, str2, str3);
        } catch (Exception e2) {
            e2.printStackTrace();
            this.f30850c.a(false, e2.getMessage(), null);
            return null;
        }
    }

    public final boolean a() {
        return this.f30850c.a();
    }
}
